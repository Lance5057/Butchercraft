package com.lance5057.butchercraft.workstations.blockentities;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.lwjgl.system.CallbackI.V;

import com.lance5057.butchercraft.ButchercraftBlockEntities;
import com.lance5057.butchercraft.workstations.recipes.AnimatedRecipeItemUse;
import com.lance5057.butchercraft.workstations.recipes.HookRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

// TODO Track recipe stage and damage tool on use
public class MeatHookBlockEntity extends BlockEntity {
	private final LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

	public boolean recipeLocked = false;
	// public NonNullList<RecipeItemUse> toolList;
	private int progress;
	private int maxProgress;
	private Ingredient curTool;
	public int toolCount;
	public int stage = 0;

	public MeatHookBlockEntity(BlockPos pPos, BlockState pState) {
		super(ButchercraftBlockEntities.MEAT_HOOK.get(), pPos, pState);
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (side != Direction.DOWN)
			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				return handler.cast();
			}
		return super.getCapability(cap, side);
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

	public AnimatedRecipeItemUse getCurrentTool() {
		HookRecipe currentRecipe = matchRecipe();
		return currentRecipe.getRecipeToolsIn().get(stage);
	}

	protected void setupStage(HookRecipe r, int i) {

		this.progress = 0;
		this.maxProgress = r.getRecipeToolsIn().get(i).uses;
		this.curTool = r.getRecipeToolsIn().get(i).tool;
		this.toolCount = r.getRecipeToolsIn().get(i).count;

		this.stage = i;
	}

	boolean isFinalStage(HookRecipe r) {
		int i = r.getRecipeToolsIn().size();
		if (i - 1 > stage) {
			return false;
		}
		return true;
	}

	// Attempt to find a recipe that matches the tool and the item in its inventory
	private HookRecipe matchRecipe() {
		if (this.level != null) {
			return level.getRecipeManager().getRecipes().stream().filter(recipe -> recipe instanceof HookRecipe)
					.map(recipe -> (HookRecipe) recipe).filter(recipe -> recipe.matches(getInsertedItem())).findFirst()
					.orElse(null);
		}
		return null;

	}

	private IItemHandler createHandler() {
		return new ItemStackHandler(1) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}

			@Override
			protected void onContentsChanged(int slot) {
				updateInventory();
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				// Item is only valid if it can find a recipe that uses the inserted item
				boolean recipeWithInputExists = false;
				if (level != null) {
					recipeWithInputExists = level.getRecipeManager().getRecipes().stream()
							.filter(recipe -> recipe instanceof HookRecipe).map(recipe -> (HookRecipe) recipe)
							.anyMatch(hookRecipe -> hookRecipe.getCarcassIn().test(stack));
				}
				return recipeWithInputExists && super.isItemValid(slot, stack);
			}
		};
	}

	public ItemStack getInsertedItem() {
		return handler.map(inventory -> inventory.getStackInSlot(0)).orElse(ItemStack.EMPTY);
	}

	public void extractInsertItem(Player playerEntity, InteractionHand hand) {
		handler.ifPresent(inventory -> {
			ItemStack held = playerEntity.getItemInHand(hand);
			if (!held.isEmpty()) {
				insertItem(inventory, held);
			} else {
				extractItem(playerEntity, inventory);
			}
		});
		updateInventory();
	}

	public void extractItem(Player playerEntity, IItemHandler inventory) {
		if (!inventory.getStackInSlot(0).isEmpty()) {
			ItemStack itemStack = inventory.extractItem(0, inventory.getStackInSlot(0).getCount(), false);
			playerEntity.addItem(itemStack);
		}
		updateInventory();
	}

	public void insertItem(IItemHandler inventory, ItemStack heldItem) {
		if (inventory.isItemValid(0, heldItem))
			if (!inventory.insertItem(0, heldItem, true).equals(heldItem, false)) {
				final int leftover = inventory.insertItem(0, heldItem.copy(), false).getCount();
				heldItem.setCount(leftover);
			}
		updateInventory();
	}

	public boolean isEmpty() {
		return handler.map(inventory -> inventory.getStackInSlot(0).isEmpty()).orElse(false);
	}

	// External extract handler
	public void extractItem(Player playerEntity) {
		handler.ifPresent(inventory -> this.extractItem(playerEntity, inventory));
	}

	// External insert handler
	public void insertItem(ItemStack heldItem) {
		handler.ifPresent(inventory -> this.insertItem(inventory, heldItem));
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.setChanged();
		if (this.getLevel() != null) {
			this.getLevel().sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
		}
	}

	public InteractionResult hammer(Player Player, ItemStack hammer) {
		HookRecipe r = matchRecipe();

		if (this.curTool == null) {
			setupStage(r, stage);
		}
		if (this.curTool.test(hammer))
			if (hammer.getCount() >= this.toolCount) {

				if (this.progress >= this.maxProgress) {

//						if (isFinalStage(r)) {
//
//							for (int i = 0; i < 5; i++) {
//								addParticle();
//							}
					level.playSound(Player, worldPosition, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1, 0);

					if (hammer.isDamageableItem())
						hammer.hurtAndBreak(1, Player, null);
					else
						hammer.setCount(hammer.getCount() - this.toolCount);
//
//							this.finishRecipe(Player, r);
//						} else {
					setupStage(r, stage + 1);
				}
			} else {
				if (hammer.isDamageableItem())
					hammer.hurtAndBreak(1, Player, null);
				else
					hammer.setCount(hammer.getCount() - this.toolCount);

				progress++;
			}

		this.updateInventory();

		return InteractionResult.SUCCESS;
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag nbt = super.getUpdateTag();

		writeNBT(nbt);

		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		readNBT(tag);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		CompoundTag tag = new CompoundTag();

		writeNBT(tag);

		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		readNBT(tag);
	}

	void readNBT(CompoundTag nbt) {
		final IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createHandler);
		((ItemStackHandler) itemInteractionHandler).deserializeNBT(nbt.getCompound("inventory"));

		this.stage = nbt.getInt("stage");
	}

	CompoundTag writeNBT(CompoundTag tag) {

		IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createHandler);
		tag.put("inventory", ((ItemStackHandler) itemInteractionHandler).serializeNBT());

		tag.putInt("stage", stage);

		return tag;
	}

	@Override
	public void load(@Nonnull CompoundTag nbt) {
		super.load(nbt);
		readNBT(nbt);
	}

	@Override
	@Nonnull
	public void saveAdditional(@Nonnull CompoundTag nbt) {
		super.saveAdditional(nbt);
		writeNBT(nbt);
		// return nbt;
	}
}
