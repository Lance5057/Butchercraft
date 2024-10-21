package com.lance5057.butchercraft.integration.jei.categories;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;
import com.lance5057.butchercraft.workstations.grinder.GrinderRecipe;

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
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class GrinderRecipeCategory implements IRecipeCategory<GrinderRecipe> {
	public static final RecipeType<GrinderRecipe> TYPE = RecipeType.create(Butchercraft.MOD_ID, "grinder",
			GrinderRecipe.class);
	private final Component localizedName;
	private final IDrawable icon;

	public GrinderRecipeCategory(IGuiHelper guiHelper) {
		localizedName = Component.translatable("Butchercraft.jei.grinder");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ButchercraftItems.GRINDER_BLOCK_ITEM.get()));
	}

	@Override
	public RecipeType<GrinderRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public int getWidth() {
		return 138;
	}

	@Override
	public int getHeight() {
		return 77;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, GrinderRecipe recipe, IFocusGroup focuses) {
		Ingredient input = recipe.ingredient();
		Ingredient attachment = recipe.attachment();
		ItemStack output = recipe.getResultItem(null);

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 17, 11)
				.addIngredients(input);
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 + 27, 50)
				.addIngredients(attachment);
		if (attachment.test(new ItemStack(ButchercraftItems.EXTRUDER_TIP.get())))
			builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 + 27 , 28)
					.addIngredients(Ingredient.of(ButchercraftItemTags.SAUSAGE_CASING));

		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2  + 51, 50)
				.addItemStack(output);
	}

	@Override
	public void draw(GrinderRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		guiGraphics.blit(ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/gui/jei.png"), 0, 0, 0, 0, 138, 77);
		guiGraphics.drawString(Minecraft.getInstance().font, "x" + recipe.grinds(), this.getWidth() / 2 - 56, 66, 0xffffff);
		guiGraphics.drawString(Minecraft.getInstance().font, "x" + recipe.count(), this.getWidth() / 2 + 2, 19, 0xffffff);
	}
}
