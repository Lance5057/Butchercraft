package com.lance5057.butchercraft.integration.jei.categories;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;
import com.lance5057.butchercraft.workstations.hook.HookRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class MeatHookRecipeCategory implements IRecipeCategory<HookRecipe> {
	public static final RecipeType<HookRecipe> TYPE = RecipeType.create(Butchercraft.MOD_ID, "hook", HookRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public MeatHookRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(new ResourceLocation(Butchercraft.MOD_ID, "textures/gui/jei.png"), 0, 78,
				144, 144);
		localizedName = Component.translatable("Butchercraft.jei.hook");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ButchercraftItems.HOOK_BLOCK_ITEM.get()));
	}

	@Override
	public RecipeType<HookRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, HookRecipe recipe, IFocusGroup focuses) {
		int count = recipe.getRecipeToolsIn().size();
		int offset = 2;
		int width = (16 + offset);

		int placementH = 0;
		int height = (16 + offset);
		int c = 0;
		int placementW = 0;

		builder.addSlot(RecipeIngredientRole.INPUT, (this.getBackground().getWidth() / 2 - 8), 65)
				.addIngredients(recipe.getCarcassIn());

		for (AnimatedRecipeItemUse a : recipe.getRecipeToolsIn()) {
			builder.addSlot(RecipeIngredientRole.CATALYST, 1 + placementW, 1 + placementH).addIngredients(a.tool);

			placementW += width;
		}
		
		c = 0;
		placementW = 0;
		placementH = 0;
		
		for (Ingredient i : recipe.getDummyList()) { 
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
}
