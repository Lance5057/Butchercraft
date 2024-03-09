package com.lance5057.butchercraft.integration.jei.categories;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;
import com.lance5057.butchercraft.workstations.hook.HookRecipe;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class MeatHookRecipeCategory implements IRecipeCategory<HookRecipe> {
	public static final RecipeType<HookRecipe> TYPE = RecipeType.create(Butchercraft.MOD_ID, "hook",
			HookRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public MeatHookRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(new ResourceLocation(Butchercraft.MOD_ID, "textures/gui/jei.png"), 0, 0,
				138, 77);
		localizedName = Component.translatable("Butchercraft.jei.hook");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ButchercraftItems.GRINDER_BLOCK_ITEM.get()));
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
		
		int placement = 0;
		for (AnimatedRecipeItemUse a : recipe.getRecipeToolsIn()) {
			builder.addSlot(RecipeIngredientRole.INPUT, (this.getBackground().getWidth() / 2) - (width * count)/2 + placement, 2)
					.addIngredients(a.tool);
			
			placement += width;
		}
	}

	@Override
	public void draw(HookRecipe recipe, IRecipeSlotsView slotsView, PoseStack ms, double mouseX, double mouseY) {
		RenderSystem.enableBlend();

		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;
		
		int count = recipe.getRecipeToolsIn().size();
		int offset = 2;
		int width = (16 + offset);
		
		int placement = 0;
		for (AnimatedRecipeItemUse a : recipe.getRecipeToolsIn()) {
			fontRenderer.draw(ms, "x" + a.uses, this.getBackground().getWidth() / 2 - (width * count)/2 + placement, 16, 0);
			
			placement += width;
		}

		RenderSystem.disableBlend();
	}
}
