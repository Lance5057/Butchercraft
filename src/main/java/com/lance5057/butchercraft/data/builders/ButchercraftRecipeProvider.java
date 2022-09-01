package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimatedFloat;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimatedFloatVector3;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimationFloatTransform;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static com.lance5057.butchercraft.items.ButchercraftItems.*;
import static net.minecraft.world.item.Items.*;

public class ButchercraftRecipeProvider extends RecipeProvider {

	public ButchercraftRecipeProvider(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
		MeatHookRecipeBuilder.shapedRecipe(COW_CARCASS.get()).tool(Ingredient.of(SKINNING_KNIFE.get()), 6, true,
				new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/skin_cow"),
				new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "recipe/cow"), null, true,
						new AnimationFloatTransform()))
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/deoffal_cow"),
						new BlacklistedModel(DIAMOND_SWORD,
								new AnimationFloatTransform().setRotation(new AnimatedFloatVector3()
										.setY(new AnimatedFloat(0, 360, 0, 0.1f, true, false)))))
				.tool(Ingredient.of(BONE_SAW.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/delimb_cow"),
						new BlacklistedModel(DIAMOND_SWORD,
								new AnimationFloatTransform().setRotation(new AnimatedFloatVector3()
										.setY(new AnimatedFloat(0, 360, 0, 0.1f, true, false)))))
				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/butcher_cow"),
						new BlacklistedModel(DIAMOND_SWORD,
								new AnimationFloatTransform().setRotation(new AnimatedFloatVector3()
										.setY(new AnimatedFloat(0, 360, 0, 0.1f, true, false)))))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cowtest"));
		ShapedRecipeBuilder.shaped(BONE_SAW.get()).define('I', IRON_INGOT).define('S', STICK).pattern("IIS")
				.pattern("IIS").unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "bone_saw"));
		ShapedRecipeBuilder.shaped(BUTCHER_KNIFE.get()).define('I', IRON_INGOT).define('S', STICK).pattern(" II")
				.pattern(" II").pattern("S  ").unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_knife"));
		ShapedRecipeBuilder.shaped(SKINNING_KNIFE.get()).define('I', IRON_INGOT).define('S', STICK).pattern(" II")
				.pattern(" I ").pattern("S  ").unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "skinning_knife"));
		createFoodRecipe(Ingredient.of(COW_BRAIN.get()), COW_COOKED_BRAIN.get(), consumer);
		createFoodRecipe(Ingredient.of(COW_HEART.get()), COW_COOKED_HEART.get(), consumer);
		createFoodRecipe(Ingredient.of(COW_KIDNEY.get()), COW_COOKED_KIDNEY.get(), consumer);
		createFoodRecipe(Ingredient.of(COW_LIVER.get()), COW_COOKED_LIVER.get(), consumer);
		createFoodRecipe(Ingredient.of(COW_LUNG.get()), COW_COOKED_LUNG.get(), consumer);
		createFoodRecipe(Ingredient.of(COW_STOMACHE.get()), COW_COOKED_STOMACHE.get(), consumer);
		createFoodRecipe(Ingredient.of(COW_TRIPE.get()), COW_COOKED_TRIPE.get(), consumer);
		createFoodRecipe(Ingredient.of(BEEF_STEW_MEAT.get()), COOKED_BEEF_STEWMEAT.get(), consumer);
		createFoodRecipe(Ingredient.of(SAUSAGE.get()), COOKED_SAUSAGE.get(), consumer);
		createFoodRecipe(Ingredient.of(BEEF_ROAST.get()), COOKED_BEEF_ROAST.get(), consumer);
		createFoodRecipe(Ingredient.of(BEEF_RIBS.get()), COOKED_BEEF_RIBS.get(), consumer);
		createFoodRecipe(Ingredient.of(CUBED_BEEF.get()), COOKED_CUBED_BEEF.get(), consumer);
		createFoodRecipe(Ingredient.of(GROUND_BEEF.get()), COOKED_GROUND_BEEF.get(), consumer);
		createFoodRecipe(Ingredient.of(BEEF_SCRAPS.get()), COOKED_BEEF_SCRAPS.get(), consumer);
		ButcherKnifeRecipeBuilder.butcheringRecipe(new ItemStack(COW_CARCASS.get()), EntityType.COW)
				.unlockedBy("has_butcher_knife", has(BUTCHER_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_cow"));
	}

	private void createFoodRecipe(Ingredient pIngredient, ItemLike pResult, Consumer<FinishedRecipe> consumer) {
		SimpleCookingRecipeBuilder.smoking(pIngredient, pResult, .35F, 100)
				.unlockedBy("has_" + pIngredient.getItems()[0].getItem().getRegistryName().getPath(),
						has(pIngredient.getItems()[0].getItem()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID,
						pResult.asItem().getRegistryName().getPath() + "_from_smoking"));
		SimpleCookingRecipeBuilder.campfireCooking(pIngredient, pResult, .35F, 600)
				.unlockedBy("has_" + pIngredient.getItems()[0].getItem().getRegistryName().getPath(),
						has(pIngredient.getItems()[0].getItem()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID,
						pResult.asItem().getRegistryName().getPath() + "_from_campfire_cooking"));
		SimpleCookingRecipeBuilder.smelting(pIngredient, pResult, .35F, 200)
				.unlockedBy("has_" + pIngredient.getItems()[0].getItem().getRegistryName().getPath(),
						has(pIngredient.getItems()[0].getItem()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID,
						pResult.asItem().getRegistryName().getPath() + "_from_smelting"));
	}

}
