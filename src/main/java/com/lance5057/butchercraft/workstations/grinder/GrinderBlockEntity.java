package com.lance5057.butchercraft.workstations.grinder;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import com.lance5057.butchercraft.ButchercraftBlockEntities;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;
import com.lance5057.butchercraft.workstations.BlockEntityItemHandler;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class GrinderBlockEntity extends BlockEntity {
	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);

	private ItemStack output = ItemStack.EMPTY;
	private int grinds = 0;

	public GrinderBlockEntity(BlockPos pPos, BlockState pState) {
		super(ButchercraftBlockEntities.GRINDER.get(), pPos, pState);
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

	private IItemHandlerModifiable createHandler() {
		return new BlockEntityItemHandler<GrinderBlockEntity>(this, 3) {

			@Override
			public boolean isItemValid(int slot, @NotNull ItemStack stack) {
				boolean b = stack.is(ButchercraftItemTags.GRINDER_ATTACHMENT);
				if (slot == 1)
					return b;
				return !b;
			}

			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				if (slot == 0 || slot == 2)
					return 8;
				return 1;
			}

			@Override
			protected void onContentsChanged(int slot) {
				zeroProgress();
				updateInventory();
			}

			@Override
			@NotNull
			public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {

				if (this.getStackInSlot(slot) == ItemStack.EMPTY) {
					this.getBlockEntity().updateInventory();
					return super.insertItem(slot, stack, simulate);
				}
				return stack;
			}
		};

	}

	public void extractItem(Player playerEntity, IItemHandlerModifiable inventory) {
		if (!inventory.getStackInSlot(0).isEmpty()) {
			ItemStack itemStack = inventory.getStackInSlot(0).copy();
			playerEntity.addItem(itemStack);
			inventory.setStackInSlot(0, ItemStack.EMPTY);
			updateInventory();

			return;

		} else if (!inventory.getStackInSlot(1).isEmpty()) {
			ItemStack itemStack = inventory.getStackInSlot(1).copy();
			playerEntity.addItem(itemStack);
			inventory.setStackInSlot(1, ItemStack.EMPTY);
			updateInventory();

			return;
		}

		updateInventory();
	}

	public ItemStack insertItem(IItemHandler inventory, ItemStack heldItem) {
		if (inventory.isItemValid(0, heldItem)) {
			if (!inventory.insertItem(0, heldItem, true).equals(heldItem, false)) {
				heldItem = inventory.insertItem(0, heldItem.copy(), false);

				updateInventory();
				return heldItem;
			}
		} else if (inventory.isItemValid(1, heldItem)) {
			if (!inventory.insertItem(1, heldItem, true).equals(heldItem, false)) {
				heldItem = inventory.insertItem(1, heldItem.copy(), false);

				updateInventory();
				return heldItem;
			}
		}

		updateInventory();
		return heldItem;
	}

	// External extract handler
	public void extractItem(Player playerEntity) {
		handler.ifPresent(inventory -> this.extractItem(playerEntity, inventory));
	}

	// External insert handler
	public ItemStack insertItem(ItemStack heldItem) {
		if (handler.isPresent()) {
			Optional<ItemStack> s = handler.map(i -> insertItem(i, heldItem));
			if (s.isPresent())
				return s.get();
		}
		return heldItem;
	}

	public void zeroProgress() {
		grinds = 0;
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
	}

	public ItemStack getInsertedItem() {
		return handler.map(inventory -> inventory.getStackInSlot(0)).orElse(ItemStack.EMPTY);
	}

	public ItemStack getInsertedItem2() {
		return handler.map(inventory -> inventory.getStackInSlot(2)).orElse(ItemStack.EMPTY);
	}

	public ItemStack getAttachment() {
		return handler.map(inventory -> inventory.getStackInSlot(1)).orElse(ItemStack.EMPTY);
	}

	public int getGrind() {
		return grinds;
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

		this.grinds = nbt.getInt("Grinds");
	}

	CompoundTag writeNBT(CompoundTag tag) {

		IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createHandler);
		tag.put("inventory", ((ItemStackHandler) itemInteractionHandler).serializeNBT());

		tag.putInt("Grinds", this.grinds);

		return tag;
	}

	@Override
	public void load(@Nonnull CompoundTag nbt) {
		super.load(nbt);
		readNBT(nbt);
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag nbt) {
		super.saveAdditional(nbt);
		writeNBT(nbt);
	}

	public Optional<GrinderRecipe> matchRecipe(ItemStack ingredient, ItemStack ingredient2, ItemStack attachment) {
		if (this.level != null) {
			return level.getRecipeManager().getRecipeFor(ButchercraftRecipes.GRINDER.get(),
					new GrinderContainer(ingredient, ingredient2, attachment), level);
		}
		return Optional.empty();

	}

	public InteractionResult grind(Player Player) {
		handler.ifPresent(inv -> {
			Optional<GrinderRecipe> recipeOptional = matchRecipe(getInsertedItem(), output, output);
			if (recipeOptional.isPresent()) {
				GrinderRecipe recipe = recipeOptional.get();

				if (this.grinds < recipe.getGrinds()) {
					grinds++;

					for (int i = 0; i < 1 + level.random.nextInt(4); i++)
						level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, getInsertedItem()),
								worldPosition.getX() + 0.25f + level.random.nextDouble() / 2,
								worldPosition.getY() - 0.5f - level.random.nextDouble(),
								worldPosition.getZ() + 0.25f + level.random.nextDouble() / 2, 0, 0, 0);

					level.playSound(Player, worldPosition, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1, 1);
				} else {
					ItemStack in = getInsertedItem();

					for (int i = 0; i < in.getCount(); i++) {

						ItemStack r = recipe.getResultItem().copy();

						level.addFreshEntity(new ItemEntity(level, getBlockPos().getX(), getBlockPos().getY() + 0.5f,
								getBlockPos().getZ(), r));
					}
					inv.setStackInSlot(0, ItemStack.EMPTY);
				}
				updateInventory();
			}
		});

		return InteractionResult.SUCCESS;
	}
}
