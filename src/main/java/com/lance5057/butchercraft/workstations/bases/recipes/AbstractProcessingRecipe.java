package com.lance5057.butchercraft.workstations.bases.recipes;

import api.LanceNestAPI.src.interfaces.ingredient.io.single.StationIngredientIn;
import api.LanceNestAPI.src.recipes.AnimatedRecipeItemUse;
import api.LanceNestAPI.src.recipes.multitoolrecipe.MultiToolRecipe;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public abstract class AbstractProcessingRecipe extends MultiToolRecipe implements StationIngredientIn {
	String group;
	Ingredient itemIn;
	NonNullList<Ingredient> jei;

	public AbstractProcessingRecipe(String group, Ingredient itemIn, NonNullList<AnimatedRecipeItemUse> tools) {
		super(tools);
		this.group = group;
		this.itemIn = itemIn;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		// To avoid breaking things
		return ItemStack.EMPTY.copy();
	}

	@Override
	public void setIngredientIn(Ingredient ing) {
		this.itemIn = ing;
	}
}
