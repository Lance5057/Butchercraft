package com.lance5057.butchercraft.workstations.recipes;

import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.ButchercraftRecipes;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class HookRecipe implements Recipe<Container> {

	private final ResourceLocation idIn;
	private final String groupIn;
	private final Ingredient carcassIn;
	private final NonNullList<AnimatedRecipeItemUse> recipeToolsIn;
	public HookRecipe(ResourceLocation idIn,
					  String groupIn,
					  Ingredient carcassIn,
					  NonNullList<AnimatedRecipeItemUse> recipeToolsIn) {
		this.idIn = idIn;
		this.groupIn = groupIn;
		this.carcassIn = carcassIn;
		this.recipeToolsIn = recipeToolsIn;
	}

	public Ingredient getCarcassIn() {
		return carcassIn;
	}

	@Override
	public boolean matches(Container pContainer, Level pLevel) {
		return carcassIn.test(pContainer.getItem(0));
	}

	@Override
	public ItemStack assemble(Container pContainer) {
		return null;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return null;
	}

	@Override
	public ResourceLocation getId() {
		return idIn;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ButchercraftRecipeSerializers.HOOK_SERIALIZER.get();
	}

	@Override
	public String getGroup() {
		return groupIn;
	}

	@Override
	public RecipeType<?> getType() {
		return ButchercraftRecipes.HOOK.get();
	}

	public NonNullList<AnimatedRecipeItemUse> getRecipeToolsIn() {
		return recipeToolsIn;
	}

	public boolean matches(ItemStack insertedItem, ItemStack butcheringTool) {
		return carcassIn.test(insertedItem) && recipeToolsIn.stream().anyMatch(animatedRecipeItemUse -> animatedRecipeItemUse.tool.test(butcheringTool));
	}
}
