package com.lance5057.butchercraft.workstations.hook;

import java.util.Optional;

import javax.annotation.Nonnull;

import com.lance5057.butchercraft.ButchercraftBlockEntities;
import com.lance5057.butchercraft.ButchercraftMobEffects;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.armor.ApronItem;
import com.lance5057.butchercraft.armor.BootsItem;
import com.lance5057.butchercraft.armor.GlovesItem;
import com.lance5057.butchercraft.armor.MaskItem;
import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.ItemStackHandler;

// TODO Track recipe stage and damage tool on use
public class MeatHookBlockEntity extends BlockEntity {
	private final ItemStackHandler inventory = createHandler();
	private final Lazy<ItemStackHandler> itemHandler = Lazy.of(() -> inventory);

	public boolean recipeLocked = false;
	// public NonNullList<RecipeItemUse> toolList;
	public int progress;
	public int maxProgress;
	private Ingredient curTool;
	public int toolCount;
	public int stage = 0;

	public MeatHookBlockEntity(BlockPos pPos, BlockState pState) {
		super(ButchercraftBlockEntities.MEAT_HOOK.get(), pPos, pState);
	}

	public ItemStackHandler getHandler() {
		return itemHandler.get();
	}

	public void setRecipe(Optional<HookRecipe> r) {

		if (r.isPresent()) {
			this.setupStage(r.get(), 0);
		} else
			this.zeroProgress();
	}

	public void zeroProgress() {
		this.progress = 0;
		this.maxProgress = 0;
		this.curTool = null;
		this.toolCount = 0;
		this.stage = 0;
	}

	public Optional<AnimatedRecipeItemUse> getCurrentTool() {
		return matchRecipe().map(hookRecipe -> hookRecipe.value().tools().get(stage));
	}

	protected void setupStage(HookRecipe r, int i) {

		this.progress = 0;
		this.maxProgress = r.tools().get(i).uses();
		this.curTool = r.tools().get(i).tool();
		this.toolCount = r.tools().get(i).count();

		this.stage = i;
	}

	boolean isFinalStage(HookRecipe r) {
		int i = r.tools().size();
		if (i - 1 > stage) {
			return false;
		}
		return true;
	}

	// Attempt to find a recipe that matches the tool and the item in its inventory
	private Optional<RecipeHolder<HookRecipe>> matchRecipe() {
		if (this.level != null) {
			return level.getRecipeManager().getRecipeFor(ButchercraftRecipes.HOOK.get(),
					new HookRecipeContainer(getInsertedItem()), level);
		}
		return Optional.empty();

	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(1) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}

			@Override
			protected void onContentsChanged(int slot) {
				updateInventory();
				zeroProgress();
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				// Item is only valid if it can find a recipe that uses the inserted item
				boolean recipeWithInputExists = false;
				if (level != null) {
					recipeWithInputExists = level.getRecipeManager().getRecipes().stream()
							.filter(recipe -> recipe.value() instanceof HookRecipe).map(recipe -> (HookRecipe) recipe.value())
							.anyMatch(hookRecipe -> hookRecipe.carcass().test(stack));
				}
				return recipeWithInputExists && super.isItemValid(slot, stack);
			}
		};
	}

	public ItemStack getInsertedItem() {
		return inventory.getStackInSlot(0);
	}

	public boolean isEmpty() {
		return inventory.getStackInSlot(0).isEmpty();
	}

	// External extract handler
	public void extractItem(Player playerEntity) {
		if (!inventory.getStackInSlot(0).isEmpty()) {
			ItemStack itemStack = inventory.extractItem(0, inventory.getStackInSlot(0).getCount(), false);
			playerEntity.addItem(itemStack);
		}
		updateInventory();
	}

	// External insert handler
	public void insertItem(ItemStack heldItem) {
		if (inventory.isItemValid(0, heldItem))
			if (!ItemStack.isSameItemSameComponents(inventory.insertItem(0, heldItem, true), heldItem)) {
				final int leftover = inventory.insertItem(0, heldItem.copy(), false).getCount();
				heldItem.setCount(leftover);
			}
		updateInventory();
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.setChanged();
		if (this.getLevel() != null) {
			getLevel().setBlock(getBlockPos(),
					getBlockState().setValue(MeatHookBlock.CARCASS_HOOKED, !getInsertedItem().isEmpty()),
					Block.UPDATE_ALL);
			this.getLevel().sendBlockUpdated(this.worldPosition, this.getBlockState(),
					this.getBlockState().setValue(MeatHookBlock.CARCASS_HOOKED, !getInsertedItem().isEmpty()),
					Block.UPDATE_ALL);
		}
	}

	public ItemInteractionResult butcher(Player p, ItemStack butcheringTool) {
		Optional<RecipeHolder<HookRecipe>> recipeOptional = matchRecipe();
		if (recipeOptional.isPresent()) {
			HookRecipe recipe = recipeOptional.get().value();
			if (this.curTool == null) {
				setupStage(recipe, stage);
			}
			if (this.curTool.test(butcheringTool)) {
				if (butcheringTool.getCount() >= this.toolCount) {
					progress++;
					if (this.progress >= this.maxProgress) {
						if (butcheringTool.isDamageableItem())
							butcheringTool.hurtAndBreak(1, p, EquipmentSlot.MAINHAND);
						else
							butcheringTool.setCount(butcheringTool.getCount() - this.toolCount);
						if (isFinalStage(recipe)) {

							dropLoot(recipe.tools().get(stage), p);
							this.finishRecipe();
						} else {
							dropLoot(recipe.tools().get(stage), p);
							setupStage(recipe, stage + 1);
						}

						level.playSound(p, worldPosition, SoundEvents.SLIME_SQUISH, SoundSource.BLOCKS, 1, 1);
					} else {
						if (butcheringTool.isDamageableItem())
							butcheringTool.hurtAndBreak(1, p, EquipmentSlot.MAINHAND);
						else
							butcheringTool.setCount(butcheringTool.getCount() - this.toolCount);

						for (int i = 0; i < 1 + level.random.nextInt(4); i++)
							level.addParticle(ParticleTypes.FALLING_DRIPSTONE_LAVA,
									worldPosition.getX() + 0.25f + level.random.nextDouble() / 2,
									worldPosition.getY() - 0.5f - level.random.nextDouble(),
									worldPosition.getZ() + 0.25f + level.random.nextDouble() / 2, 0, 0, 0);

						level.playSound(p, worldPosition, SoundEvents.SLIME_SQUISH_SMALL, SoundSource.BLOCKS, 1, 1);

					}
				}

				ItemStack boots = p.getInventory().getArmor(0);
				if (boots.getItem() instanceof BootsItem)
					boots.hurtAndBreak(1, p, EquipmentSlot.FEET);
				else
					p.addEffect(new MobEffectInstance(ButchercraftMobEffects.BLOODTRAIL, 3600, 0, false, false,
							true));

				ItemStack apron = p.getInventory().getArmor(1);
				if (apron.getItem() instanceof ApronItem)
					apron.hurtAndBreak(1, p, EquipmentSlot.LEGS);
				else
					p.addEffect(
							new MobEffectInstance(ButchercraftMobEffects.BLOODY, 3600, 0, false, false, true));

				ItemStack gloves = p.getInventory().getArmor(2);
				if (gloves.getItem() instanceof GlovesItem)
					gloves.hurtAndBreak(1, p, EquipmentSlot.CHEST);
				else
					p.addEffect(new MobEffectInstance(ButchercraftMobEffects.DIRTY, 3600, 0, false, false, true));

				ItemStack mask = p.getInventory().getArmor(3);
				if (mask.getItem() instanceof MaskItem)
					mask.hurtAndBreak(1, p, EquipmentSlot.HEAD);
				else
					p.addEffect(
							new MobEffectInstance(ButchercraftMobEffects.STINKY, 3600, 0, false, false, true));

				this.updateInventory();
				return ItemInteractionResult.SUCCESS;
			}

		}

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	private void dropLoot(AnimatedRecipeItemUse recipeToolsIn, Player player) {
		if (level != null && !level.isClientSide()) {
			final LootParams pParams = new LootParams.Builder((ServerLevel) level)
					.withParameter(LootContextParams.TOOL, player.getMainHandItem())
					.withParameter(LootContextParams.THIS_ENTITY, player)
					.withLuck(
							player.getLuck() + player.getMainHandItem().getEnchantmentLevel(player.registryAccess().holderOrThrow(Enchantments.FORTUNE)))
					.create(LootContextParamSets.EMPTY);
			player.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, recipeToolsIn.lootTable())).getRandomItems(pParams)
					.forEach(itemStack -> {
//						if (player.isCrouching())
						level.addFreshEntity(new ItemEntity(level, getBlockPos().getX() + 0.5f,
								getBlockPos().getY() - 1.5f, getBlockPos().getZ() + 0.5f, itemStack, 0, 0, 0));
//						else {
//							if (!player.getInventory().add(itemStack)) {
//								player.drop(itemStack, false);
//							}
//						}
					});

		}
	}

	public void finishRecipe() {
		inventory.setStackInSlot(0, ItemStack.EMPTY);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
		CompoundTag nbt = super.getUpdateTag(registries);

		writeNBT(nbt, registries);

		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider registries) {
		readNBT(tag, registries);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		// TODO: is this necessary?
//		CompoundTag tag = new CompoundTag();
//
//		writeNBT(tag);

		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		readNBT(tag, registries);
	}

	void readNBT(CompoundTag nbt, HolderLookup.Provider registries) {
		if (nbt.contains("inventory")) {
			inventory.deserializeNBT(registries, nbt.getCompound("inventory"));
		}

		this.stage = nbt.getInt("stage");
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tag.put("inventory", inventory.serializeNBT(registries));

		tag.putInt("stage", stage);

		return tag;
	}

	@Override
	public void loadAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.loadAdditional(nbt, registries);
		readNBT(nbt, registries);
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.saveAdditional(nbt, registries);
		writeNBT(nbt, registries);
	}
}
