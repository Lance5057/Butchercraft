package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class CookingPotRecipes extends RecipeProvider {

	public CookingPotRecipes(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.KETCHUP_JAR_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO).addIngredient(Items.SUGAR).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "ketchup_jar"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.BBQ_JAR_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO).addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.SUGAR).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "bbq_sugar"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.BBQ_JAR_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO).addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.HONEY_BOTTLE).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "bbq_honey"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.STOCK_JAR_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES).addIngredient(Tags.Items.BONES).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "stock_jar"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.GRAVY_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.BOWL)
				.addIngredient(ButchercraftItemTags.ANY_SCRAP_MEAT_RAW)
				.addIngredient(ButchercraftItems.STOCK_JAR_ITEM.get()).addIngredient(Items.WHEAT).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "gravy_boat"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.LAMB_STEW.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ButchercraftItems.LAMB_STEW_MEAT.get()).addIngredient(Items.CARROT)
				.addIngredient(Items.POTATO).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_stew"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.PORK_STEW.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ButchercraftItems.PORK_STEW_MEAT.get()).addIngredient(Items.CARROT)
				.addIngredient(Items.POTATO).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_stew"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.SAUSAGE_ROLL.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ButchercraftItems.SAUSAGE.get()).addIngredient(ModItems.WHEAT_DOUGH.get())
				.build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sausage_roll"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.SOS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BREAD)
				.addIngredient(ButchercraftItems.BEEF_SCRAPS.get()).addIngredient(Items.WHEAT)
				.addIngredient(ForgeTags.MILK).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sos"));

		CookingPotRecipeBuilder.cookingPotRecipe(ButchercraftItems.LARD.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ButchercraftItems.FAT.get()).addIngredient(ButchercraftItems.FAT.get()).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lard"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.HASH_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ModItems.ONION.get()).addIngredient(Items.POTATO)
				.addIngredient(ButchercraftItems.GROUND_BEEF.get())
				.addIngredient(ButchercraftItems.KETCHUP_JAR_ITEM.get()).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "hash_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.POT_ROAST_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ButchercraftItemTags.ANY_ROAST_RAW).addIngredient(ModItems.ONION.get())
				.addIngredient(Items.POTATO).addIngredient(Items.CARROT).build(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pot_roast"));
//		CookingPotRecipeBuilder.cookingPotRecipe(ButchercraftItems.SOAP.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
//		.addIngredient(ButchercraftItems.LARD.get())
//		.addIngredient(ItemTags.FLOWERS)
//		.addIngredient(ItemTags.FLOWERS)
//		.build(consumer);
	}
}
