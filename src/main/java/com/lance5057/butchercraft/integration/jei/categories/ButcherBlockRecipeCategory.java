package com.lance5057.butchercraft.integration.jei.categories;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;
import com.lance5057.butchercraft.workstations.butcherblock.ButcherBlockRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class ButcherBlockRecipeCategory implements IRecipeCategory<ButcherBlockRecipe> {
	public static final RecipeType<ButcherBlockRecipe> TYPE = RecipeType.create(Butchercraft.MOD_ID, "butcher_block",
			ButcherBlockRecipe.class);
	private final Component localizedName;
	private final IDrawable icon;

	public ButcherBlockRecipeCategory(IGuiHelper guiHelper) {
		localizedName = Component.translatable("Butchercraft.jei.butcherblock");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ButchercraftItems.BUTCHER_BLOCK_BLOCK_ITEM.get()));
	}

	@Override
	public RecipeType<ButcherBlockRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public int getWidth() {
		return 144;
	}

	@Override
	public int getHeight() {
		return 144;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, ButcherBlockRecipe recipe, IFocusGroup focuses) {
		int count = recipe.tools().size();
		int offset = 2;
		int width = (16 + offset);
		int placementH = 0;
		int height = (16 + offset);
		int placementW = 0;
		int c = 0;

		builder.addSlot(RecipeIngredientRole.INPUT, (this.getWidth() / 2 - 8), 40)
				.addIngredients(recipe.carcass());

		for (AnimatedRecipeItemUse a : recipe.tools()) {
			builder.addSlot(RecipeIngredientRole.CATALYST, 1 + placementW, 1 + placementH).addIngredients(a.tool());

			placementW += width;
			c++;
			if (c > 7) {
				placementH += height;
				placementW = 0;
				c = 0;
			}
		}

		c = 0;
		placementW = 0;
		placementH = 0;

		for (Ingredient i : recipe.jei()) {
			builder.addSlot(RecipeIngredientRole.OUTPUT, 1 + placementW, 73 + placementH+18).addIngredients(i);
			placementW += width;
			c++;
			if (c > 7) {
				placementH += height;
				placementW = 0;
				c = 0;
			}
		}
	}

	@Override
	public void draw(ButcherBlockRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		guiGraphics.blit(ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/gui/jei.png"), 0, 0, 108, 78, 144, 144);
	}
}
