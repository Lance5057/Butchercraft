package com.lance5057.butchercraft.workstations.recipes;

import com.lance5057.butchercraft.ButchercraftRecipes;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public class HookRecipe extends MultiToolRecipe {

	public HookRecipe(ResourceLocation idIn,
					  String groupIn,
					  int recipeWidthIn,
					  int recipeHeightIn,
					  NonNullList<Ingredient> recipeItemsIn,
					  NonNullList<AnimatedRecipeItemUse> recipeToolsIn) {
		super(idIn, groupIn, recipeWidthIn, recipeHeightIn, recipeItemsIn, recipeToolsIn, ButchercraftRecipes.HOOK.get());
		// TODO Auto-generated constructor stub
	}

    
}
