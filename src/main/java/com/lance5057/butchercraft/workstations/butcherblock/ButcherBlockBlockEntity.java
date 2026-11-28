package com.lance5057.butchercraft.workstations.butcherblock;

import java.util.Optional;

import javax.annotation.Nonnull;

import com.lance5057.butchercraft.ButchercraftBlockEntities;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.workstations.butcherblock.recipes.ButcherBlockRecipe;
import com.lance5057.butchercraft.workstations.hook.HookRecipeContainer;

import api.LanceNestAPI.src.blockentities.MultiToolRecipeStation;
import api.LanceNestAPI.src.blocks.RecipeToolSupplier.components.item.BlockEntityItemHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeManager.CachedCheck;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.ItemStackHandler;

public class ButcherBlockBlockEntity extends MultiToolRecipeStation<HookRecipeContainer, ButcherBlockRecipe> {
	private final ItemStackHandler inventory = createItemHandler();
	private final Lazy<ItemStackHandler> itemHandler = Lazy.of(() -> inventory);

	public boolean recipeLocked = false;
	// public NonNullList<RecipeItemUse> toolList;
	public int progress;
	public int maxProgress;
//	private Ingredient curTool;
//	public int toolCount;
	public int stage = 0;
	public boolean displayTools = true;

	private final CachedCheck<HookRecipeContainer, ButcherBlockRecipe> quickCheck = RecipeManager
			.createCheck(ButchercraftRecipes.BUTCHER_BLOCK.get());

	public ButcherBlockBlockEntity(BlockPos pPos, BlockState pState) {
		super(1, 1, 1, ButchercraftBlockEntities.BUTCHER_BLOCK.get(), pPos, pState);
	}

	@Override
	public Optional<RecipeHolder<ButcherBlockRecipe>> matchRecipe() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	protected void setupRecipe() {
//		this.progress = 0;
//		this.maxProgress = r.tools().get(i).uses();
//		this.curTool = r.tools().get(i).tool();
//		this.toolCount = r.tools().get(i).count();

//		this.stage = i;
	}

	@Override
	protected BlockEntityItemHandler createItemHandler() {
		return new BlockEntityItemHandler(this, 1) {
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
							.filter(recipe -> recipe.value() instanceof ButcherBlockRecipe)
							.map(recipe -> (ButcherBlockRecipe) recipe.value())
							.anyMatch(hookRecipe -> hookRecipe.getIngredientIn().test(stack));
				}
				return recipeWithInputExists && super.isItemValid(slot, stack);
			}
		};
	}

	@Override
	public void addParticle() {
		// TODO Auto-generated method stub

	}

	@Override
	public void finishRecipe(Player Player, ButcherBlockRecipe recipe) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void readNBTExtra(CompoundTag nbt, Provider registries) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void writeNBTExtra(CompoundTag nbt, Provider registries) {
		// TODO Auto-generated method stub

	}
}
