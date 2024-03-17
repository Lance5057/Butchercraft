package com.lance5057.butchercraft.integration.jei;

import org.jetbrains.annotations.NotNull;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.integration.jei.categories.ButcherBlockRecipeCategory;
import com.lance5057.butchercraft.integration.jei.categories.GrinderRecipeCategory;
import com.lance5057.butchercraft.integration.jei.categories.MeatHookRecipeCategory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
	private static final ResourceLocation ID = new ResourceLocation(Butchercraft.MOD_ID, "main");

	@Override
	public ResourceLocation getPluginUid() {
		return ID;
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new GrinderRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
				new ButcherBlockRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
				new MeatHookRecipeCategory(registry.getJeiHelpers().getGuiHelper()));

	}

	@Override
	public void registerRecipes(@NotNull IRecipeRegistration registry) {
		registry.addRecipes(GrinderRecipeCategory.TYPE,
				Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ButchercraftRecipes.GRINDER.get()));
		registry.addRecipes(MeatHookRecipeCategory.TYPE,
				Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ButchercraftRecipes.HOOK.get()));
		registry.addRecipes(ButcherBlockRecipeCategory.TYPE, Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(ButchercraftRecipes.BUTCHER_BLOCK.get()));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
		registry.addRecipeCatalyst(new ItemStack(ButchercraftItems.BUTCHER_BLOCK_BLOCK_ITEM.get()),
				ButcherBlockRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ButchercraftItems.HOOK_BLOCK_ITEM.get()), MeatHookRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ButchercraftItems.GRINDER_BLOCK_ITEM.get()),
				GrinderRecipeCategory.TYPE);
	}
}
