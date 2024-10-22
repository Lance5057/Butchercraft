package com.lance5057.butchercraft.integration.emi;

import com.lance5057.butchercraft.ButchercraftBlocks;
import com.lance5057.butchercraft.ButchercraftRecipes;
import com.lance5057.butchercraft.integration.emi.recipes.ButcherBlockEmiRecipe;
import com.lance5057.butchercraft.integration.emi.recipes.GrinderEmiRecipe;
import com.lance5057.butchercraft.integration.emi.recipes.MeatHookEmiRecipe;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

@EmiEntrypoint
public class EMIPlugin implements EmiPlugin {
	public static final EmiStack BUTCHER_BLOCK_WORKSTATION = EmiStack.of(ButchercraftBlocks.BUTCHER_BLOCK);
	public static final EmiStack GRINDER_WORKSTATION = EmiStack.of(ButchercraftBlocks.GRINDER);
	public static final EmiStack MEAT_HOOK_WORKSTATION = EmiStack.of(ButchercraftBlocks.MEAT_HOOK);

	public static final EmiRecipeCategory BUTCHER_BLOCK_CATEGORY = new EmiRecipeCategory(ResourceLocation.fromNamespaceAndPath("butchercraft", "butcher_block"), BUTCHER_BLOCK_WORKSTATION) {
		@Override
		public Component getName() {
			return Component.translatable("Butchercraft.jei.butcherblock");
		}
	};
	public static final EmiRecipeCategory GRINDER_CATEGORY = new EmiRecipeCategory(ResourceLocation.fromNamespaceAndPath("butchercraft", "grinder"), GRINDER_WORKSTATION) {
		@Override
		public Component getName() {
			return Component.translatable("Butchercraft.jei.grinder");
		}
	};;
	public static final EmiRecipeCategory MEAT_HOOK_CATEGORY = new EmiRecipeCategory(ResourceLocation.fromNamespaceAndPath("butchercraft", "hook"), MEAT_HOOK_WORKSTATION) {
		@Override
		public Component getName() {
			return Component.translatable("Butchercraft.jei.hook");
		}
	};;

	@Override
	public void register(EmiRegistry registry) {
		registry.addCategory(BUTCHER_BLOCK_CATEGORY);
		registry.addCategory(GRINDER_CATEGORY);
		registry.addCategory(MEAT_HOOK_CATEGORY);

		registry.addWorkstation(BUTCHER_BLOCK_CATEGORY, BUTCHER_BLOCK_WORKSTATION);
		registry.addWorkstation(GRINDER_CATEGORY, GRINDER_WORKSTATION);
		registry.addWorkstation(MEAT_HOOK_CATEGORY, MEAT_HOOK_WORKSTATION);

		RecipeManager recipeManager = registry.getRecipeManager();
		recipeManager.getAllRecipesFor(ButchercraftRecipes.BUTCHER_BLOCK.get())
				.stream()
				.map(holder -> new ButcherBlockEmiRecipe(holder.value(), holder.id()))
				.forEach(registry::addRecipe);
		recipeManager.getAllRecipesFor(ButchercraftRecipes.GRINDER.get())
				.stream()
				.map(holder -> new GrinderEmiRecipe(holder.value(), holder.id()))
				.forEach(registry::addRecipe);
		recipeManager.getAllRecipesFor(ButchercraftRecipes.HOOK.get())
				.stream()
				.map(holder -> new MeatHookEmiRecipe(holder.value(), holder.id()))
				.forEach(registry::addRecipe);
	}
}
