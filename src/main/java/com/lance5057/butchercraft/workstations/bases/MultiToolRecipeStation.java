package com.lance5057.butchercraft.workstations.bases;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;
import com.lance5057.butchercraft.workstations.bases.recipes.MultiToolRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public abstract class MultiToolRecipeStation<V extends MultiToolRecipe> extends BlockEntity {
	protected final LazyOptional<IItemHandlerModifiable> InteractionHandler = LazyOptional
			.of(this::createInteractionHandler);
	// private ItemStack ghostStack = ItemStack.EMPTY;

	// public Optional<V> currentRecipe;
	public boolean recipeLocked = false;
	// public NonNullList<RecipeItemUse> toolList;
	private int progress;
	private int maxProgress;
	private Ingredient curTool;
	public int toolCount;
	public int stage = 0;
	public final int width;
	public final int height;
	public final int numSlots;

	public MultiToolRecipeStation(int slots, int width, int height, BlockEntityType<?> tileEntityTypeIn, BlockPos pos,
			BlockState state) {
		super(tileEntityTypeIn, pos, state);

		this.width = width;
		this.height = height;
		this.numSlots = slots;
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (side != Direction.DOWN)
			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				return InteractionHandler.cast();
			}
		return super.getCapability(cap, side);
	}

	protected abstract Optional<V> matchRecipe();
//    {
//
//	if (level != null) {
//	    Optional<V> recipe =  InteractionHandler.map(i -> {
//		return level.getRecipeManager().getRecipe(WorkstationRecipes.CRAFTING_ANVIL_RECIPE,
//			new WorkstationRecipeWrapper(width, height, i), level);
//	    }).get();
//
//	    // setRecipe(recipe);
//	    return recipe;
//	}
//	return null;
//    }

	public void setRecipe(Optional<V> r) {

		if (r.isPresent()) {
			this.setupStage(r.get(), 0);
		} else
			this.zeroProgress();
	}

	protected abstract IItemHandlerModifiable createInteractionHandler();
//    {
//	return new ItemStackInteractionHandler(numSlots) {
//	    @Override
//	    protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
//		return stack.getMaxStackSize();
//	    }
//
//	    @Override
//	    protected void onContentsChanged(int slot) {
//		updateInventory();
//		if (slot != 25) {
//
//		    zeroProgress();
//		    Optional<V> recipe = matchRecipe();
//
//		    if (recipe.isPresent()) {
//			setRecipe(recipe);
//		    }
//		}
//	    }
//	};
//    }

	public void zeroProgress() {
		this.progress = 0;
		this.maxProgress = 0;
		this.curTool = null;
		this.toolCount = 0;
		this.stage = 0;
	}

	public AnimatedRecipeItemUse getCurrentTool() {
		Optional<V> currentRecipe = matchRecipe();
		if (currentRecipe.isPresent())
			return currentRecipe.get().getToolList().get(stage);
		return null;
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.setChanged();
		if (this.getLevel() != null) {
			this.getLevel().sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
		}
	}

	protected void setupStage(V r, int i) {

		this.progress = 0;
		this.maxProgress = r.getToolList().get(i).uses;
		this.curTool = r.getToolList().get(i).tool;
		this.toolCount = r.getToolList().get(i).count;

		this.stage = i;
	}

	boolean isFinalStage(V r) {
		int i = r.getToolList().size();
		if (i - 1 > stage) {
			return false;
		}
		return true;
	}

	public InteractionResult hammer(Player Player, ItemStack hammer) {
		Optional<V> currentRecipe = matchRecipe();
		currentRecipe.ifPresent(r -> {

			if (this.curTool == null) {
				setupStage(r, stage);
			}
			if (this.curTool.test(hammer))
				if (hammer.getCount() >= this.toolCount) {

					if (this.progress >= this.maxProgress) {

						if (isFinalStage(r)) {

							for (int i = 0; i < 5; i++) {
								addParticle();
							}
							level.playSound(Player, worldPosition, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1, 0);

							if (hammer.isDamageableItem())
								hammer.hurtAndBreak(1, Player, (x) -> {
									x.broadcastBreakEvent(EquipmentSlot.MAINHAND);
								});
							else
								hammer.setCount(hammer.getCount() - this.toolCount);

							this.finishRecipe(Player, r);
						} else {
							setupStage(r, stage + 1);
						}
					} else {
						if (hammer.isDamageableItem())
							hammer.hurtAndBreak(1, Player, (x) -> {
								x.broadcastBreakEvent(EquipmentSlot.MAINHAND);
							});
						else
							hammer.setCount(hammer.getCount() - this.toolCount);

						progress++;
					}

				}
		});
		this.updateInventory();

		return InteractionResult.SUCCESS;
	}

	public abstract void addParticle();

	public abstract void finishRecipe(Player Player, V recipe);

	protected void craft() {
		this.InteractionHandler.ifPresent(it -> {
			for (int i = 0; i < width * height; i++) {
				ItemStack stack = it.getStackInSlot(i);
				stack.setCount(stack.getCount() - 1);
				it.setStackInSlot(i, stack);
			}
		});
	}

	protected ItemStack dropItemBelow(IItemHandler InteractionHandler, ItemStack insert) {
		for (int i = 0; i < InteractionHandler.getSlots(); i++) {
			insert = InteractionHandler.insertItem(i, insert, false);

			if (insert.isEmpty()) {
				return ItemStack.EMPTY;
			}
		}

		return insert;
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
				.orElseGet(this::createInteractionHandler);
		((ItemStackHandler) itemInteractionHandler).deserializeNBT(nbt.getCompound("inventory"));

		this.stage = nbt.getInt("stage");
	}

	CompoundTag writeNBT(CompoundTag tag) {

		IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createInteractionHandler);
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
