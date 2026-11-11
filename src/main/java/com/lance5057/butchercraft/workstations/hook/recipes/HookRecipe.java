package com.lance5057.butchercraft.workstations.hook.recipes;

import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.workstations.bases.recipes.AbstractProcessingRecipe;
import com.lance5057.butchercraft.workstations.hook.HookRecipeContainer;

import api.LanceNestAPI.src.recipes.AnimatedRecipeItemUse;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class HookRecipe extends AbstractProcessingRecipe<HookRecipeContainer> {
	ResourceLocation entity;

	public HookRecipe(String group, Ingredient itemIn, ResourceLocation entity,
			NonNullList<AnimatedRecipeItemUse> tools) {
		super(group, itemIn, tools);
		this.entity = entity;
	}

	@Override
	public boolean matches(HookRecipeContainer input, Level level) {
		return this.getIngredientIn().test(input.getItem(0).copy());
	}

	@Override
	public ItemStack assemble(HookRecipeContainer input, Provider registries) {
		return ItemStack.EMPTY.copy();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ButchercraftRecipeSerializers.HOOK_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ButchercraftRecipes.HOOK.get();
	}

}
