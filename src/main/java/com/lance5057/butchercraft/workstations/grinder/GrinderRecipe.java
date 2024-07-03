package com.lance5057.butchercraft.workstations.grinder;

import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.ButchercraftRecipes;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record GrinderRecipe(
		String group,
		Ingredient ingredient,
		int count,
		Ingredient attachment,
		ItemStack result,
		int grinds
) implements Recipe<GrinderContainer> {

	@Override
	public boolean matches(GrinderContainer pContainer, Level pLevel) {
		return ingredient.test(pContainer.getInsertedItem()) && attachment.test(pContainer.getAttachment());
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess registryAccess) {
		return result;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ButchercraftRecipeSerializers.GRINDER_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ButchercraftRecipes.GRINDER.get();
	}

	@Override
	public ItemStack assemble(GrinderContainer pContainer, RegistryAccess registryAccess) {
		return this.result.copy();
	}
}
