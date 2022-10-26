package com.lance5057.butchercraft.workstations.blockentities;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lance5057.butchercraft.ButchercraftBlockEntities;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.workstations.blocks.MeatHookBlock;
import com.lance5057.butchercraft.workstations.recipes.dryingrack.DryingRackContainer;
import com.lance5057.butchercraft.workstations.recipes.dryingrack.DryingRackRecipe;
import com.lance5057.butchercraft.workstations.recipes.meathook.HookRecipe;
import com.lance5057.butchercraft.workstations.recipes.meathook.HookRecipeContainer;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class DryingRackBlockEntity extends BlockEntity {
	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);
	private static final int NUM_SLOTS = 4;
	// private final NonNullList<ItemStack> items = NonNullList.withSize(4,
	// ItemStack.EMPTY);
	private final int[] cookingProgress = new int[4];
	private final int[] cookingTime = new int[4];

	public DryingRackBlockEntity(BlockPos pPos, BlockState pState) {
		super(ButchercraftBlockEntities.DRYING_RACK.get(), pPos, pState);
		// TODO Auto-generated constructor stub
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
		return new ItemStackHandler(8) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				// Item is only valid if it can find a recipe that uses the inserted item
				boolean recipeWithInputExists = false;
				if (level != null) {
					recipeWithInputExists = level.getRecipeManager().getRecipes().stream()
							.filter(recipe -> recipe instanceof DryingRackRecipe)
							.map(recipe -> (DryingRackRecipe) recipe)
							.anyMatch(hookRecipe -> hookRecipe.getInput().test(stack));
				}
				return recipeWithInputExists && super.isItemValid(slot, stack);
			}
		};
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
			getLevel().setBlock(getBlockPos(),
					getBlockState().setValue(MeatHookBlock.CARCASS_HOOKED, !getInsertedItem().isEmpty()),
					Block.UPDATE_ALL);
			this.getLevel().sendBlockUpdated(this.worldPosition, this.getBlockState(),
					this.getBlockState().setValue(MeatHookBlock.CARCASS_HOOKED, !getInsertedItem().isEmpty()),
					Block.UPDATE_ALL);
		}
	}

	public ItemStack getInsertedItem() {
		return handler.map(inventory -> inventory.getStackInSlot(0)).orElse(ItemStack.EMPTY);
	}

//	public boolean placeFood(ItemStack pStack, int pCookTime) {
//		
//		for (int i = 0; i < this.items.size(); ++i) {
//			ItemStack itemstack = this.items.get(i);
//			if (itemstack.isEmpty()) {
//				this.cookingTime[i] = pCookTime;
//				this.cookingProgress[i] = 0;
//				this.items.set(i, pStack.split(1));
//				this.markUpdated();
//				return true;
//			}
//		}
//
//		return false;
//	}

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

	}

	CompoundTag writeNBT(CompoundTag tag) {

		IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createHandler);
		tag.put("inventory", ((ItemStackHandler) itemInteractionHandler).serializeNBT());
		tag.putIntArray("CookingTimes", this.cookingProgress);
		tag.putIntArray("CookingTotalTimes", this.cookingTime);

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

	public Optional<DryingRackRecipe> matchRecipe(ItemStack itemstack) {
		if (this.level != null) {
			return level.getRecipeManager().getRecipeFor(ButchercraftRecipes.DRYING_RACK.get(),
					new SimpleContainer(itemstack), level);
		}
		return Optional.empty();

	}
}
