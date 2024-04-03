package com.lance5057.butchercraft.workstations.grinder;

import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.ButchercraftRecipes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class GrinderRecipe implements Recipe<GrinderContainer> {

	public final ResourceLocation idIn;
	public final String groupIn;
	public final Ingredient ingredient;
	public final int count;
	public final Ingredient attachment;
	public final ItemStack result;
	public final int grinds;

	public int getGrinds() {
		return grinds;
	}

	public GrinderRecipe(ResourceLocation idIn, String groupIn, Ingredient itemIn, int count, Ingredient attachment,
			ItemStack result, int grinds) {
		this.idIn = idIn;
		this.groupIn = groupIn;
		this.ingredient = itemIn;
		this.count = count;
		this.attachment = attachment;
		this.result = result;
		this.grinds = grinds;
	}

	@Override
	public boolean matches(GrinderContainer pContainer, Level pLevel) {
		return ingredient.test(pContainer.getInsertedItem()) && attachment.test(pContainer.getAttachment());
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return result;
	}

	@Override
	public ResourceLocation getId() {
		return idIn;
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
	public ItemStack assemble(GrinderContainer pContainer) {
		return this.result.copy();
	}
}
