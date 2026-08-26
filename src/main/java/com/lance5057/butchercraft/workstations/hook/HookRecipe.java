package com.lance5057.butchercraft.workstations.hook;

import com.lance5057.butchercraft.workstations.bases.recipes.AbstractProcessingRecipe;

import api.LanceNestAPI.src.recipes.AnimatedRecipeItemUse;
import api.LanceNestAPI.src.util.recipes.MultiToolRecipeWrapper;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class HookRecipe extends AbstractProcessingRecipe {

	public HookRecipe(String group, Ingredient itemIn, NonNullList<AnimatedRecipeItemUse> tools) {
		super(group, itemIn, tools);
	}

	@Override
	public boolean matches(MultiToolRecipeWrapper input, Level level) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack assemble(MultiToolRecipeWrapper input, Provider registries) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeType<?> getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
