package com.lance5057.butchercraft.workstations.butcherblock;

import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class ButcherBlockRecipe implements Recipe<ButcherBlockContainer> {

	private final ResourceLocation idIn;
	private final String groupIn;
	private final Ingredient carcassIn;
	private final NonNullList<AnimatedRecipeItemUse> recipeToolsIn;
	private final NonNullList<Ingredient> dummyList; //For JEI

	public ButcherBlockRecipe(ResourceLocation idIn, String groupIn, Ingredient carcassIn,
			NonNullList<AnimatedRecipeItemUse> recipeToolsIn, NonNullList<Ingredient> JEI) {
		this.idIn = idIn;
		this.groupIn = groupIn;
		this.carcassIn = carcassIn;
		this.recipeToolsIn = recipeToolsIn;
		this.dummyList = JEI;
	}

	public NonNullList<Ingredient> getDummyList() {
		return dummyList;
	}
	
	public Ingredient getCarcassIn() {
		return carcassIn;
	}

	@Override
	public boolean matches(ButcherBlockContainer pContainer, Level pLevel) {
		return carcassIn.test(pContainer.getInsertedItem());
	}

	@Override
	public ItemStack assemble(ButcherBlockContainer pContainer, RegistryAccess registryAccess) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess registryAccess) {
		return ItemStack.EMPTY;
	}

	@Override
	public ResourceLocation getId() {
		return idIn;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ButchercraftRecipeSerializers.BUTCHER_BLOCK_SERIALIZER.get();
	}

	@Override
	public String getGroup() {
		return groupIn;
	}

	@Override
	public RecipeType<?> getType() {
		return ButchercraftRecipes.BUTCHER_BLOCK.get();
	}

	public NonNullList<AnimatedRecipeItemUse> getRecipeToolsIn() {
		return recipeToolsIn;
	}

	public boolean matches(ItemStack insertedItem) {
		return carcassIn.test(insertedItem);
	}
}