package com.lance5057.butchercraft.workstations.butcherblock;

import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record ButcherBlockRecipe(
		String group,
		Ingredient carcass,
		NonNullList<AnimatedRecipeItemUse> tools,
		NonNullList<Ingredient> jei
) implements Recipe<ButcherBlockContainer> {
	@Override
	public boolean matches(ButcherBlockContainer pContainer, Level pLevel) {
		return carcass.test(pContainer.getInsertedItem());
	}

	@Override
	public ItemStack assemble(ButcherBlockContainer pContainer, HolderLookup.Provider registryAccess) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(HolderLookup.Provider registryAccess) {
		return ItemStack.EMPTY;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ButchercraftRecipeSerializers.BUTCHER_BLOCK_SERIALIZER.get();
	}

	@Override
	public String getGroup() {
		return group;
	}

	@Override
	public RecipeType<?> getType() {
		return ButchercraftRecipes.BUTCHER_BLOCK.get();
	}
}