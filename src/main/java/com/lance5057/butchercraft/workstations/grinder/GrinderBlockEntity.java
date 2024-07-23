package com.lance5057.butchercraft.workstations.grinder;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.lance5057.butchercraft.ButchercraftBlockEntities;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;
import com.lance5057.butchercraft.workstations.BlockEntityItemHandler;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.ItemStackHandler;

public class GrinderBlockEntity extends BlockEntity {
	private final ItemStackHandler inventory = createHandler();
	private final Lazy<ItemStackHandler> itemHandler = Lazy.of(() -> inventory);

	private ItemStack output = ItemStack.EMPTY;
	private int itemsUsed = 0;
	private int grinds = 0;
	private int grindsMax = 0;
	private boolean isExtruder = false;

	public GrinderBlockEntity(BlockPos pPos, BlockState pState) {
		super(ButchercraftBlockEntities.GRINDER.get(), pPos, pState);
	}

	public ItemStackHandler getHandler() {
		return itemHandler.get();
	}

	private ItemStackHandler createHandler() {
		return new BlockEntityItemHandler<>(this, 3) {

			@Override
			public boolean isItemValid(int slot, @NotNull ItemStack stack) {
				if (slot == 1) {
					if (stack.is(ButchercraftItemTags.GRINDER_ATTACHMENT)) {
						return true;
					} else
						return false;
				}

				if (slot == 2) {
					if (stack.is(ButchercraftItemTags.SAUSAGE_CASING)) {
						if (this.getStackInSlot(1).is(ButchercraftItems.EXTRUDER_TIP.get()))
							return true;
					}
					return false;
				}
				return true;
			}

			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				if (slot == 0)
					return 8;
				return 1;
			}

			@Override
			protected void onContentsChanged(int slot) {

				updateInventory();
			}

			@Override
			@NotNull
			public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
				if (this.getStackInSlot(slot) == ItemStack.EMPTY) {
					if (slot == 0) {
						Optional<RecipeHolder<GrinderRecipe>> r = level.getRecipeManager().getRecipeFor(
								ButchercraftRecipes.GRINDER.get(), new GrinderContainer(stack, getStackInSlot(1)),
								level);
						if (r.isPresent()) {
							this.getBlockEntity().setupRecipe(r.get().value().grinds(), r.get().value().getResultItem(null),
									getStackInSlot(1), r.get().value().count());
							this.getBlockEntity().updateInventory();
							return super.insertItem(slot, stack, simulate);
						}
					} else {

						this.getBlockEntity().updateInventory();
						return super.insertItem(slot, stack, simulate);
					}
				}
				return stack;
			}

			@Override
			@NotNull
			public ItemStack extractItem(int slot, int amount, boolean simulate) {
				this.getBlockEntity().zeroProgress();
				return super.extractItem(slot, amount, simulate);

			}
		};

	}

	// External extract handler
	public void extractItem(Player playerEntity) {
		if (!inventory.getStackInSlot(0).isEmpty()) {
			ItemStack itemStack = inventory.getStackInSlot(0).copy();
			playerEntity.addItem(itemStack);
			inventory.setStackInSlot(0, ItemStack.EMPTY);
			zeroProgress();
			updateInventory();

			return;

		} else if (!inventory.getStackInSlot(2).isEmpty()) {
			ItemStack itemStack = inventory.getStackInSlot(2).copy();
			playerEntity.addItem(itemStack);
			inventory.setStackInSlot(2, ItemStack.EMPTY);
			zeroProgress();
			updateInventory();

			return;

		} else if (!inventory.getStackInSlot(1).isEmpty()) {
			if (inventory.getStackInSlot(0).isEmpty()) {
				ItemStack itemStack = inventory.getStackInSlot(1).copy();
				playerEntity.addItem(itemStack);
				inventory.setStackInSlot(1, ItemStack.EMPTY);
				zeroProgress();
				updateInventory();

				return;
			}
		}

		updateInventory();
	}

	// External insert handler
	public ItemStack insertItem(ItemStack heldItem) {
		for (int i = 0; i < 3; i++) {
			if (inventory.isItemValid(i, heldItem)) {

				if (!ItemStack.isSameItemSameComponents(inventory.insertItem(i, heldItem, true), heldItem)) {

					heldItem = inventory.insertItem(i, heldItem.copy(), false);

					updateInventory();
					return heldItem;
				}
			}
		}

		updateInventory();
		return heldItem;
	}

	public void zeroProgress() {
		itemsUsed = 0;
		grinds = 0;
		grindsMax = 0;
		output = ItemStack.EMPTY;
		this.isExtruder = false;
	}

	public void setupRecipe(int grindsMax, ItemStack output, ItemStack extruder, int used) {
		zeroProgress();
		this.grindsMax = grindsMax;
		this.output = output;
		this.itemsUsed = used;

		if (extruder.is(ButchercraftItems.EXTRUDER_TIP.get())) {
			this.isExtruder = true;
		}
	}

	public void updateInventory() {
		requestModelDataUpdate();

		this.setChanged();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(),
				Block.UPDATE_ALL);
	}

	public ItemStack getInsertedItem() {
		return inventory.getStackInSlot(0);
	}

	public ItemStack getAttachment() {
		return inventory.getStackInSlot(1);
	}

	public ItemStack getCasing() {
		return inventory.getStackInSlot(2);
	}

	public int getGrind() {
		return grinds;
	}

	public int getMaxGrind() {
		return grindsMax;
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
		CompoundTag nbt = super.getUpdateTag(registries);

		nbt = writeNBT(nbt, registries);

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
//		tag = writeNBT(tag);

		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
		CompoundTag tag = pkt.getTag();

		readNBT(tag, registries);
	}

	void readNBT(CompoundTag nbt, HolderLookup.Provider registries) {
		if (nbt.contains("inventory")) {
			inventory.deserializeNBT(registries, nbt.getCompound("inventory"));
		}

		this.grinds = nbt.getInt("grinds");
		this.grindsMax = nbt.getInt("grinds_max");

		this.output = ItemStack.parseOptional(registries, nbt.getCompound("output"));
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tag.put("inventory", inventory.serializeNBT(registries));

		tag.putInt("grinds", this.grinds);
		tag.putInt("grinds_max", this.grindsMax);

		if (!output.isEmpty()) {
			tag.put("output", output.save(registries, new CompoundTag()));
		}

		return tag;
	}

	@Override
	protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.loadAdditional(tag, registries);
		readNBT(tag, registries);
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.saveAdditional(nbt, registries);
		nbt = writeNBT(nbt, registries);
	}

	public Optional<RecipeHolder<GrinderRecipe>> matchRecipe(ItemStack ingredient, ItemStack attachment) {
		if (this.level != null) {
			return level.getRecipeManager().getRecipeFor(ButchercraftRecipes.GRINDER.get(),
					new GrinderContainer(ingredient, attachment), level);
		}
		return Optional.empty();

	}

	public ItemInteractionResult grind(Player Player, BlockState blockState) {
		if (!this.output.isEmpty()) {

			if (this.isExtruder) {
				if (this.getCasing().isEmpty())
					return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
			}

			if (this.getInsertedItem().getCount() < this.itemsUsed) {
				return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
			}

			if (this.grinds < this.grindsMax) {
				this.grinds++;

				for (int i = 0; i < 1 + level.random.nextInt(4); i++)
					level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, getInsertedItem()),
							worldPosition.getX() + 0.5f, worldPosition.getY() + 0.25f, worldPosition.getZ() + 0.25f, 0,
							0, -0.1f);

				level.playSound(Player, worldPosition, SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1, 1);

			} else {
				ItemStack in = inventory.getStackInSlot(0);
				ItemStack casing = inventory.getStackInSlot(2);

				if (casing != ItemStack.EMPTY) {
					for (int i = 0; i < casing.getCount(); i++) {

						ItemStack r = output.copy();

						dropLoot(blockState, r);
					}
				} else {
					ItemStack r = output.copy();

					dropLoot(blockState, r);
				}

				ItemStack s = in.copy();
				s.setCount(in.getCount() - this.itemsUsed);

				inventory.setStackInSlot(0, ItemStack.EMPTY);
				inventory.setStackInSlot(2, ItemStack.EMPTY);

				if (inventory.isItemValid(0, s)) {
					dropLoot(blockState, inventory.insertItem(0, s, false));
				}

			}
			updateInventory();
			return ItemInteractionResult.SUCCESS;
		}

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

	}

	private void dropLoot(BlockState blockState, ItemStack item) {
		Direction d = blockState.getValue(GrinderBlock.FACING);

		switch (d) {
		case NORTH:
			level.addFreshEntity(new ItemEntity(level, getBlockPos().getX() + 1, getBlockPos().getY(),
					getBlockPos().getZ(), item, 0, 0, 0));
			break;
		case SOUTH:
			level.addFreshEntity(new ItemEntity(level, getBlockPos().getX() + 0.5f, getBlockPos().getY(),
					getBlockPos().getZ() + 1.25f, item, 0, 0, 0.1f));
			break;
		case EAST:
			level.addFreshEntity(new ItemEntity(level, getBlockPos().getX(), getBlockPos().getY(),
					getBlockPos().getZ() + 1, item, 0, 0, 0));
			break;
		case WEST:
			level.addFreshEntity(new ItemEntity(level, getBlockPos().getX(), getBlockPos().getY(),
					getBlockPos().getZ() - 1, item, 0, 0, 0));
			break;
		default:
			break;

		}

	}
}
