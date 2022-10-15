package com.lance5057.butchercraft.data.builders;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import com.lance5057.butchercraft.items.ButchercraftItems;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class CookingPotRecipes extends RecipeProvider {

	public CookingPotRecipes(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
		CookingPotRecipeBuilder
				.cookingPotRecipe(ButchercraftItems.KETCHUP_JAR_BLOCK_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING,
						1.0F, Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.addIngredient(Items.SUGAR)
				.build(consumer);
		
		CookingPotRecipeBuilder
		.cookingPotRecipe(ButchercraftItems.BBQ_JAR_BLOCK_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING,
				1.0F, Items.GLASS_BOTTLE)
		.addIngredient(ForgeTags.VEGETABLES_TOMATO)
		.addIngredient(ForgeTags.VEGETABLES_ONION)
		.addIngredient(Items.SUGAR)
		.build(consumer, "bbq_sugar");
		
		CookingPotRecipeBuilder
		.cookingPotRecipe(ButchercraftItems.BBQ_JAR_BLOCK_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING,
				1.0F, Items.GLASS_BOTTLE)
		.addIngredient(ForgeTags.VEGETABLES_TOMATO)
		.addIngredient(ForgeTags.VEGETABLES_ONION)
		.addIngredient(Items.HONEY_BOTTLE)
		.build(consumer, "bbq_honey");

		CookingPotRecipeBuilder
		.cookingPotRecipe(ButchercraftItems.STOCK_JAR_BLOCK_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING,
				1.0F, Items.GLASS_BOTTLE)
		.addIngredient(ForgeTags.VEGETABLES)
		.addIngredient(Tags.Items.BONES)
		.build(consumer);
		
		CookingPotRecipeBuilder
		.cookingPotRecipe(ButchercraftItems.GRAVY_BOAT_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING,
				1.0F, Items.BOWL)
		.addIngredient(ButchercraftItemTags.ANY_SCRAP_MEAT_RAW)
		.addIngredient(ButchercraftItems.STOCK_JAR_BLOCK_ITEM.get())
		.addIngredient(Items.WHEAT)
		.build(consumer);
		
		CookingPotRecipeBuilder.cookingPotRecipe(ButchercraftItems.LAMB_STEW.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL)
		.addIngredient(ButchercraftItems.LAMB_STEW_MEAT.get())
		.addIngredient(Items.CARROT)
		.addIngredient(Items.POTATO)
		.build(consumer);
		
		CookingPotRecipeBuilder.cookingPotRecipe(ButchercraftItems.PORK_STEW.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL)
		.addIngredient(ButchercraftItems.PORK_STEW_MEAT.get())
		.addIngredient(Items.CARROT)
		.addIngredient(Items.POTATO)
		.build(consumer);
		
		CookingPotRecipeBuilder.cookingPotRecipe(ButchercraftItems.SAUSAGE_ROLL.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
		.addIngredient(ButchercraftItems.SAUSAGE.get())
		.addIngredient(ModItems.WHEAT_DOUGH.get())
		.build(consumer);
		
		CookingPotRecipeBuilder.cookingPotRecipe(ButchercraftItems.SOS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BREAD)
		.addIngredient(ButchercraftItems.BEEF_SCRAPS.get())
		.addIngredient(Items.WHEAT)
		.addIngredient(ForgeTags.MILK)
		.build(consumer);
		
		CookingPotRecipeBuilder.cookingPotRecipe(ButchercraftItems.LARD.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
		.addIngredient(ButchercraftItems.FAT.get())
		.addIngredient(ButchercraftItems.FAT.get())
		.build(consumer);
		
		CookingPotRecipeBuilder.cookingPotRecipe(ButchercraftItems.SOAP.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
		.addIngredient(ButchercraftItems.LARD.get())
		.addIngredient(ItemTags.FLOWERS)
		.addIngredient(ItemTags.FLOWERS)
		.build(consumer);
	}
}
