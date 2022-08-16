package com.lance5057.butchercraft.workstations.blockentities;

import java.util.Optional;

import javax.annotation.Nonnull;

import com.lance5057.butchercraft.ButchercraftBlockEntities;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.items.CarcassItem;
import com.lance5057.butchercraft.workstations.blockentities.bases.MultiToolRecipeStation;
import com.lance5057.butchercraft.workstations.recipes.HookRecipe;
import com.lance5057.butchercraft.workstations.recipes.WorkstationRecipeWrapper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class MeatHookBlockEntity extends MultiToolRecipeStation<HookRecipe> {

	private ItemStack ghostStack = ItemStack.EMPTY;

	public MeatHookBlockEntity(BlockPos pos, BlockState state) {
		super(1, 1, 1, ButchercraftBlockEntities.MEAT_HOOK.get(), pos, state);
	}

	public void setGhostStack(ItemStack i) {
		this.ghostStack = i;
	}

	public ItemStack getGhostStack() {
		return this.ghostStack;
	}

	@Override
	protected IItemHandlerModifiable createInteractionHandler() {
		return new ItemStackHandler(1) {
			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				if (stack.getItem() instanceof CarcassItem) {
					Optional<HookRecipe> recipe = matchRecipe();

					if (recipe.isPresent()) {
						if (recipe.get() != null)
							return true;
					}
				}
				return false;
			}

			@Override
			protected void onContentsChanged(int slot) {
				updateInventory();
				zeroProgress();
				Optional<HookRecipe> recipe = matchRecipe();

				setGhostStack(ItemStack.EMPTY);

				if (recipe.isPresent()) {
					setGhostStack(recipe.get().getRecipeOutput().copy());
					setRecipe(recipe);
				}
			}
		};
	}

	public void extractInsertItem(Player Player, InteractionHand InteractionHand) {
		InteractionHandler.ifPresent(inventory -> {
			ItemStack held = Player.getItemInHand(InteractionHand);
			if (!held.isEmpty()) {
				insertItem(inventory, held);
			} else {
				extractItem(Player, inventory);
			}
		});
		updateInventory();
	}

	public void extractItem(Player Player, IItemHandler inventory) {
		if (!inventory.getStackInSlot(0).isEmpty()) {
			ItemStack itemStack = inventory.extractItem(0, inventory.getStackInSlot(0).getCount(), false);
			Player.addItem(itemStack);
		}
		updateInventory();
	}

	public void insertItem(IItemHandler inventory, ItemStack heldItem) {
		if (inventory.isItemValid(0, heldItem))
			if (!inventory.insertItem(0, heldItem, true).sameItem(heldItem)) {
				final int leftover = inventory.insertItem(0, heldItem.copy(), false).getCount();
				heldItem.setCount(leftover);
			}
		updateInventory();
	}

	public void extractItem(Player Player) {
		InteractionHandler.ifPresent(inventory -> {
			this.extractItem(Player, inventory);
		});
	}

	public void insertItem(ItemStack heldItem) {
		InteractionHandler.ifPresent(inventory -> {
			this.insertItem(inventory, heldItem);
		});
	}

	@Override
	protected Optional<HookRecipe> matchRecipe() {
		if (level != null) {

			Optional<HookRecipe> recipe = InteractionHandler.map(i -> {
				return level.getRecipeManager().getRecipeFor(ButchercraftRecipes.HOOK.get(),
						new WorkstationRecipeWrapper(1, 1, i), level);
			}).get();

			return recipe;
		}
		return null;
	}

	@Override
	public void addParticle() {
		// TODO Auto-generated method stub

	}

	@Override
	public void finishRecipe(Player Player, HookRecipe recipe) {
		InteractionHandler.ifPresent(h -> {
			ItemStack item = recipe.getRecipeOutput().copy();
			BlockEntity te = level.getBlockEntity(this.getBlockPos().offset(0, -1, 0));
			if (te != null) {
				LazyOptional<IItemHandler> ih = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
						Direction.UP);

				item = ih.map(h2 -> dropItemBelow(h2, recipe.getRecipeOutput().copy())).get();
				if (item == null)
					craft();

			}
		});
	}

}
