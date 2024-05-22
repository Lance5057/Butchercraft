package com.lance5057.butchercraft.data.builders.recipes;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimatedFloat;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimatedFloatVector3;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimationFloatTransform;
import com.lance5057.butchercraft.data.builders.recipes.loottables.ButcherBlockLootTables;
import com.lance5057.butchercraft.data.builders.recipes.loottables.MeatHookLoottables;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.DifferenceIngredient;
import net.minecraftforge.registries.ForgeRegistries;

public class ButchercraftRecipeProvider extends RecipeProvider {

	public ButchercraftRecipeProvider(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}

	BlacklistedModel standardModel(ResourceLocation rl) {
		return new BlacklistedModel(rl, null, true,
				new AnimationFloatTransform().setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(0))));
	}

	BlacklistedModel standardHookToolModel(Item i) {
		return new BlacklistedModel(i,
				new AnimationFloatTransform().setScale(new AnimatedFloatVector3().setAll(new AnimatedFloat(0.5f)))
						.setRotation(new AnimatedFloatVector3().setZ(new AnimatedFloat(-45, 45, 0, 0.05f, true, true)))
						.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
								.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0))));
	}

	BlacklistedModel hideModel(ResourceLocation rl) {
		return new BlacklistedModel(rl, null, true,
				new AnimationFloatTransform().setLocation(new AnimatedFloatVector3().setY(new AnimatedFloat(12, 0))));
	}

	BlacklistedModel layFlatModel(Item rl) {
		return new BlacklistedModel(rl, new AnimationFloatTransform()
				.setLocation(
						new AnimatedFloatVector3(new AnimatedFloat(8), new AnimatedFloat(1f), new AnimatedFloat(8)))
				.setRotation(new AnimatedFloatVector3().setX(new AnimatedFloat(-90)))
				.setScale(new AnimatedFloatVector3(new AnimatedFloat(1), new AnimatedFloat(1), new AnimatedFloat(1))));
	}

	BlacklistedModel standardButcherBlockModel(ResourceLocation rl) {
		return new BlacklistedModel(rl, null, true,
				new AnimationFloatTransform().setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(0))));
	}

	BlacklistedModel standardButcherBlockToolModel(Item i) {
		return new BlacklistedModel(i,
				new AnimationFloatTransform()
						.setRotation(new AnimatedFloatVector3().setZ(new AnimatedFloat(-45, 45, 0, 0.05f, true, true)))
						.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
								.setY(new AnimatedFloat(8, 0)).setZ(new AnimatedFloat(8, 0)))
						.setScale(new AnimatedFloatVector3().setAll(new AnimatedFloat(0.5f))));
	}

	@Override
	protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.COW_CARCASS.get())
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow")),
						standardHookToolModel(Items.BUCKET))

				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 12, true, MeatHookLoottables.SKIN_COW,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow")),
						standardHookToolModel(ButchercraftItems.SKINNING_KNIFE.get()))

				.tool(Ingredient.of(ButchercraftItems.BONE_SAW.get()), 12, true, MeatHookLoottables.BISECT_COW,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_skinned")),
						standardHookToolModel(ButchercraftItems.BONE_SAW.get()))

				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 12, true, MeatHookLoottables.DISEMBOWEL_COW,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_gutted")),
						standardHookToolModel(ButchercraftItems.GUT_KNIFE.get()))

				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 12, true, MeatHookLoottables.BUTCHER_COW,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_bisected")),
						standardHookToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))

				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BUCKET.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.HEART.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COW_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BEEF_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BEEF_STEW_MEAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.OXTAIL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COW_HIDE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BEEF_RIBS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BEEF_ROAST.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_BEEF.get()))
				.JEIIngredient(Ingredient.of(Items.BEEF)).JEIIngredient(Ingredient.of(Items.BONE))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cow"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.SHEEP_CARCASS.get())
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 12, true, MeatHookLoottables.SKIN_SHEEP,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep")),
						standardHookToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.BONE_SAW.get()), 12, true, MeatHookLoottables.BISECT_SHEEP,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_skinned")),
						standardHookToolModel(ButchercraftItems.BONE_SAW.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 12, true, MeatHookLoottables.DISEMBOWEL_SHEEP,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_gutted")),
						standardHookToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 12, true, MeatHookLoottables.BUTCHER_SHEEP,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_bisected")),
						standardHookToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BUCKET.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SHEEP_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SHEEP_HIDE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.HEART.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.MUTTON_STEW_MEAT.get()))
				.JEIIngredient(Ingredient.of(Items.BONE))
				.JEIIngredient(Ingredient.of(ButchercraftItems.MUTTON_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.MUTTON_RIBS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.MUTTON_ROAST.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_MUTTON.get()))
				.JEIIngredient(Ingredient.of(Items.MUTTON))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sheep"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.PIG_CARCASS.get())
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 12, true, MeatHookLoottables.SKIN_PIG,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig")),
						standardHookToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.BONE_SAW.get()), 12, true, MeatHookLoottables.BISECT_PIG,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_skinned")),
						standardHookToolModel(ButchercraftItems.BONE_SAW.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 12, true, MeatHookLoottables.DISEMBOWEL_PIG,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_gutted")),
						standardHookToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 12, true, MeatHookLoottables.BUTCHER_PIG,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_bisected")),
						standardHookToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BUCKET.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.PIG_HIDE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.PIG_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.HEART.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.PORK_STEW_MEAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.PORK_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.PORK_RIBS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.PORK_ROAST.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_PORK.get()))
				.JEIIngredient(Ingredient.of(Items.PORKCHOP)).JEIIngredient(Ingredient.of(Items.BONE))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pig"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.GOAT_CARCASS.get())
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 12, true, MeatHookLoottables.SKIN_GOAT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat")),
						standardHookToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.BONE_SAW.get()), 12, true, MeatHookLoottables.BISECT_GOAT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_skinned")),
						standardHookToolModel(ButchercraftItems.BONE_SAW.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 12, true, MeatHookLoottables.DISEMBOWEL_GOAT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_gutted")),
						standardHookToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 12, true, MeatHookLoottables.BUTCHER_GOAT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_bisected")),
						standardHookToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BUCKET.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_HIDE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.HEART.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_STEW_MEAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_RIBS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_ROAST.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_GOAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_CHOP.get()))
				.JEIIngredient(Ingredient.of(Items.BONE))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CHICKEN_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 12, true,
						ButcherBlockLootTables.DEOFFAL_CHICKEN,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken_plucked")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.HEART.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get())).JEIIngredient(Ingredient.of(Items.CHICKEN))
				.JEIIngredient(Ingredient.of(Items.FEATHER))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CHICKEN_HEAD_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_chicken"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.CHICKEN)
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 12, true,
						ButcherBlockLootTables.BUTCHER_CHICKEN,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CHICKEN_BREAST.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CHICKEN_LEG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CHICKEN_THIGH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CHICKEN_WING.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CHICKEN_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(Items.BONE_MEAL))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_whole_chicken"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.BLACK_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_black")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_black")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_BLACK_RABBIT,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_black")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_black_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT_HIDE)).JEIIngredient(Ingredient.of(Items.RABBIT_FOOT))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_BLACK_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_black_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.BROWN_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_brown")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_brown")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_BROWN_RABBIT,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_brown")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_brown_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT_HIDE)).JEIIngredient(Ingredient.of(Items.RABBIT_FOOT))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_BROWN_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_brown_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_splotched")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_splotched")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_SPLOTCHED_RABBIT,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_splotched")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_splotched_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT_HIDE)).JEIIngredient(Ingredient.of(Items.RABBIT_FOOT))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SPLOTCHED_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_splotched_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.GOLD_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_gold")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_gold")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_GOLD_RABBIT,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_gold")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_gold_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT_HIDE)).JEIIngredient(Ingredient.of(Items.RABBIT_FOOT))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_GOLD_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_gold_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.SALT_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_salt")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_salt")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_SALT_RABBIT,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_salt")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_salt_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT_HIDE)).JEIIngredient(Ingredient.of(Items.RABBIT_FOOT))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SALT_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_salt_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.WHITE_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_white")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_white")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_WHITE_RABBIT,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_white")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardButcherBlockModel(
								new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_white_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT_HIDE)).JEIIngredient(Ingredient.of(Items.RABBIT_FOOT))
				.JEIIngredient(Ingredient.of(ButchercraftItems.KIDNEY.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LIVER.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STOMACH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LUNG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TRIPE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_WHITE_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(Items.RABBIT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_white_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.RABBIT)
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 12, true,
						ButcherBlockLootTables.BUTCHER_RABBIT,
						standardButcherBlockModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_skinned")),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_LEG.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SADDLE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_THIGH.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(Items.BONE_MEAL))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_whole_rabbit"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.COW_HIDE.get())
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true, MeatHookLoottables.SCRAPE_HIDE,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_hide")),
						standardHookToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(Items.SHEARS), 6, true, MeatHookLoottables.COW_LEATHER,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_hide")),
						standardHookToolModel(Items.SHEARS))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(Items.LEATHER))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cow_hide"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.GOAT_HIDE.get())
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true, MeatHookLoottables.SCRAPE_HIDE,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_hide")),
						standardHookToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(Items.SHEARS), 6, true, MeatHookLoottables.GOAT_LEATHER,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_hide")),
						standardHookToolModel(Items.SHEARS))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(Items.LEATHER))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_hide"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.PIG_HIDE.get())
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true, MeatHookLoottables.SCRAPE_HIDE,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_hide")),
						standardHookToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(Items.SHEARS), 6, true, MeatHookLoottables.PIG_LEATHER,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_hide")),
						standardHookToolModel(Items.SHEARS))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(Items.LEATHER))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pig_hide"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.SHEEP_HIDE.get())
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true, MeatHookLoottables.SCRAPE_HIDE,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_hide")),
						standardHookToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(Items.SHEARS), 6, true, MeatHookLoottables.SHEEP_LEATHER,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_hide")),
						standardHookToolModel(Items.SHEARS))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SINEW.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.FAT.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(Items.LEATHER))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sheep_hide"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.BLOOD_SAUSAGE_LINKED.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 8, true,
						ButcherBlockLootTables.BLOOD_SAUSAGE_LINKED,
						layFlatModel(ButchercraftItems.BLOOD_SAUSAGE_LINKED.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLOOD_SAUSAGE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "blood_sausage_linked"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.SAUSAGE_LINKED.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 8, true,
						ButcherBlockLootTables.SAUSAGE_LINKED, layFlatModel(ButchercraftItems.SAUSAGE_LINKED.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SAUSAGE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sausage_linked"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.BEEF_ROAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.BEEF_ROAST,
						layFlatModel(ButchercraftItems.BEEF_ROAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(Items.BEEF))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_roast"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_BEEF_ROAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_BEEF_ROAST,
						layFlatModel(ButchercraftItems.COOKED_BEEF_ROAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(Items.COOKED_BEEF))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_roast"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.PORK_ROAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.PORK_ROAST,
						layFlatModel(ButchercraftItems.PORK_ROAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(Items.PORKCHOP))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_roast"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_PORK_ROAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_PORK_ROAST,
						layFlatModel(ButchercraftItems.COOKED_PORK_ROAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(Items.COOKED_PORKCHOP))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_roast"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.MUTTON_ROAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.MUTTON_ROAST, layFlatModel(ButchercraftItems.MUTTON_ROAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(Items.MUTTON))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "mutton_roast"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_MUTTON_ROAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_MUTTON_ROAST,
						layFlatModel(ButchercraftItems.COOKED_MUTTON_ROAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(Items.COOKED_MUTTON))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_mutton_roast"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.GOAT_ROAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.GOAT_ROAST,
						layFlatModel(ButchercraftItems.GOAT_ROAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_CHOP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_roast"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_GOAT_ROAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_GOAT_ROAST,
						layFlatModel(ButchercraftItems.COOKED_GOAT_ROAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_GOAT_CHOP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_goat_roast"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.BEEF)
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.BEEF_CUBES,
						layFlatModel(Items.BEEF), standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_BEEF.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.COOKED_BEEF)
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_BEEF_CUBES, layFlatModel(Items.COOKED_BEEF),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_CUBED_BEEF.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.PORKCHOP)
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.PORK_CUBES,
						layFlatModel(Items.PORKCHOP),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_PORK.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.COOKED_PORKCHOP)
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_PORK_CUBES, layFlatModel(Items.COOKED_PORKCHOP),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_CUBED_PORK.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.MUTTON)
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.MUTTON_CUBES, layFlatModel(Items.MUTTON),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_MUTTON.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "mutton_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.COOKED_MUTTON)
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_MUTTON_CUBES, layFlatModel(Items.COOKED_MUTTON),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_CUBED_MUTTON.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_mutton_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.GOAT_CHOP.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.GOAT_CUBES,
						layFlatModel(ButchercraftItems.GOAT_CHOP.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_GOAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_GOAT_CHOP.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_GOAT_CUBES,
						layFlatModel(ButchercraftItems.COOKED_GOAT_CHOP.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_CUBED_GOAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_goat_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CHICKEN_BREAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.CHICKEN_CUBES, layFlatModel(ButchercraftItems.CHICKEN_BREAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_CHICKEN.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "chicken_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_CHICKEN_BREAST.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_CHICKEN_CUBES,
						layFlatModel(ButchercraftItems.COOKED_CHICKEN_BREAST.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_CUBED_CHICKEN.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_chicken_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.RABBIT_SADDLE.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.RABBIT_CUBES, layFlatModel(ButchercraftItems.RABBIT_SADDLE.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CUBED_RABBIT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "rabbit_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_RABBIT_SADDLE.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_RABBIT_CUBES,
						layFlatModel(ButchercraftItems.COOKED_RABBIT_SADDLE.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_CUBED_RABBIT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_rabbit_cubes"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CUBED_BEEF.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.BEEF_STEW,
						layFlatModel(ButchercraftItems.CUBED_BEEF.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BEEF_STEW_MEAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_CUBED_BEEF.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_BEEF_STEW,
						layFlatModel(ButchercraftItems.COOKED_CUBED_BEEF.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_BEEF_STEW_MEAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CUBED_PORK.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.PORK_STEW,
						layFlatModel(ButchercraftItems.CUBED_PORK.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.PORK_STEW_MEAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_CUBED_PORK.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_PORK_STEW,
						layFlatModel(ButchercraftItems.COOKED_CUBED_PORK.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_PORK_STEW_MEAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CUBED_MUTTON.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.MUTTON_STEW,
						layFlatModel(ButchercraftItems.CUBED_MUTTON.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.MUTTON_STEW_MEAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "mutton_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_CUBED_MUTTON.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_MUTTON_STEW,
						layFlatModel(ButchercraftItems.COOKED_CUBED_MUTTON.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_mutton_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CUBED_GOAT.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.GOAT_STEW,
						layFlatModel(ButchercraftItems.CUBED_GOAT.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_STEW_MEAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_CUBED_GOAT.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_GOAT_STEW,
						layFlatModel(ButchercraftItems.COOKED_CUBED_GOAT.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_GOAT_STEW_MEAT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_goat_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CUBED_CHICKEN.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.CHICKEN_STEW, layFlatModel(ButchercraftItems.CUBED_CHICKEN.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STEW_CHICKEN.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "chicken_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_CUBED_CHICKEN.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_CHICKEN_STEW,
						layFlatModel(ButchercraftItems.COOKED_CUBED_CHICKEN.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_STEW_CHICKEN.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_chicken_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CUBED_RABBIT.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true, ButcherBlockLootTables.RABBIT_STEW,
						layFlatModel(ButchercraftItems.CUBED_RABBIT.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.STEW_RABBIT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "rabbit_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COOKED_CUBED_RABBIT.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 4, true,
						ButcherBlockLootTables.COOKED_RABBIT_STEW,
						layFlatModel(ButchercraftItems.COOKED_CUBED_RABBIT.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COOKED_STEW_RABBIT.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_rabbit_stew"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.TRIPE.get())
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 4, true, ButcherBlockLootTables.EMPTY,
						layFlatModel(ButchercraftItems.TRIPE.get()),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(Items.WATER_BUCKET), 1, true, ButcherBlockLootTables.CASING,
						layFlatModel(ButchercraftItems.TRIPE.get()), standardButcherBlockToolModel(Items.WATER_BUCKET))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CASING.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "casing"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.RABBIT_BLACK_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true,
						ButcherBlockLootTables.BLACK_RABBIT_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/black_rabbit_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLACK_BUNNY_EARS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BLACK_BUNNY_TAIL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "black_rabbit_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.RABBIT_BROWN_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true,
						ButcherBlockLootTables.BROWN_RABBIT_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/brown_rabbit_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BROWN_BUNNY_EARS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BROWN_BUNNY_TAIL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "brown_rabbit_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.RABBIT_GOLD_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true,
						ButcherBlockLootTables.GOLD_RABBIT_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/gold_rabbit_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOLD_BUNNY_EARS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOLD_BUNNY_TAIL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "gold_rabbit_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.RABBIT_SALT_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true,
						ButcherBlockLootTables.SALT_RABBIT_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/salt_rabbit_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SALT_BUNNY_EARS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SALT_BUNNY_TAIL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "salt_rabbit_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.RABBIT_SPLOTCHED_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true,
						ButcherBlockLootTables.SPLOTCHED_RABBIT_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/splotched_rabbit_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SPLOTCHED_BUNNY_EARS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SPLOTCHED_BUNNY_TAIL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "splotched_rabbit_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.RABBIT_WHITE_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true,
						ButcherBlockLootTables.WHITE_RABBIT_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/white_rabbit_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.WHITE_BUNNY_EARS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.WHITE_BUNNY_TAIL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.RABBIT_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "white_rabbit_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CHICKEN_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true, ButcherBlockLootTables.CHICKEN_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CHICKEN_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.CHICKEN_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BEAK.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.WATTLE.get()))
				.JEIIngredient(Ingredient.of(Items.FEATHER))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "chicken_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.COW_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true, ButcherBlockLootTables.COW_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TONGUE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.HORN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.COW_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BEEF_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cow_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.SHEEP_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true, ButcherBlockLootTables.SHEEP_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TONGUE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.SHEEP_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.MUTTON_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.JEIIngredient(Ingredient.of(Items.STRING))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sheep_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.PIG_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true, ButcherBlockLootTables.PIG_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TONGUE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.PIG_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.PORK_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pig_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.GOAT_HEAD_ITEM.get())
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 4, true, ButcherBlockLootTables.GOAT_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.EYEBALL.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.BRAIN.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.TONGUE.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_SKULL_HEAD_ITEM.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.GOAT_SCRAPS.get()))
				.JEIIngredient(Ingredient.of(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_head"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.BONE_SAW.get()).define('I', Items.IRON_INGOT)
				.define('S', Items.STICK).pattern("IIS").pattern("IIS").unlockedBy("has_iron", has(Items.IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "bone_saw"));
		ShapedRecipeBuilder.shaped(ButchercraftItems.BUTCHER_KNIFE.get()).define('I', Items.IRON_INGOT)
				.define('S', Items.STICK).pattern(" II").pattern(" II").pattern("S  ")
				.unlockedBy("has_iron", has(Items.IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_knife"));
		ShapedRecipeBuilder.shaped(ButchercraftItems.SKINNING_KNIFE.get()).define('I', Items.IRON_INGOT)
				.define('S', Items.STICK).pattern(" II").pattern("S  ").unlockedBy("has_iron", has(Items.IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "skinning_knife"));
		ShapedRecipeBuilder.shaped(ButchercraftItems.GUT_KNIFE.get()).define('I', Items.IRON_INGOT)
				.define('S', Items.STICK).pattern("I  ").pattern(" I ").pattern(" S ")
				.unlockedBy("has_iron", has(Items.IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "gut_knife"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.HOOK_BLOCK_ITEM.get()).define('I', Items.IRON_INGOT)
				.define('C', Items.CHAIN).define('N', Items.IRON_NUGGET).pattern("III").pattern("NCN").pattern("NNN")
				.unlockedBy("has_iron", has(Items.IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "meat_hook"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.GRINDER_TIP.get()).define('I', Items.IRON_TRAPDOOR)
				.define('C', Items.IRON_BARS).pattern("C  ").pattern("I  ")
				.unlockedBy("has_iron", has(Items.IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "grinder_tip"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.EXTRUDER_TIP.get()).define('I', Items.IRON_TRAPDOOR)
				.define('C', Items.IRON_INGOT).pattern("C  ").pattern("I  ")
				.unlockedBy("has_iron", has(Items.IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "extruder_tip"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.GRINDER_BLOCK_ITEM.get()).define('S', Items.IRON_SWORD)
				.define('P', Items.PISTON).define('C', Items.IRON_INGOT).define('B', ItemTags.BUTTONS)
				.define('H', Items.HOPPER).pattern("BH ").pattern("CSC").pattern("CPH")
				.unlockedBy("has_iron", has(Items.IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "grinder"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.MASK.get()).define('W', Items.LIGHT_BLUE_CARPET)
				.define('S', Items.STRING).pattern("SWS").unlockedBy("has_wool", has(Items.LIGHT_BLUE_CARPET))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "mask"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.BOOTS.get()).define('W', Items.BLACK_WOOL)
				.define('B', Items.LEATHER_BOOTS).define('F', ButchercraftItems.LARD.get()).pattern(" F ")
				.pattern("WBW").unlockedBy("has_boots", has(Items.LEATHER_BOOTS))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "boots"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.GLOVES.get()).define('W', Items.LIGHT_BLUE_WOOL)
				.define('B', Items.LEATHER).define('F', ButchercraftItems.LARD.get()).pattern("W W").pattern("BFB")
				.unlockedBy("has_wool", has(Items.LIGHT_BLUE_WOOL))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "gloves"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.APRON.get()).define('W', Items.WHITE_CARPET)
				.define('S', Items.STRING).define('F', ButchercraftItems.LARD.get()).pattern(" S ").pattern("WWW")
				.pattern("SFS").unlockedBy("has_wool", has(Items.WHITE_CARPET))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "apron"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.PAPER_HAT.get()).define('P', Items.PAPER).pattern("PPP")
				.pattern("P P").unlockedBy("has_paper", has(Items.PAPER))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "paper_hat"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.BUTCHER_BLOCK_BLOCK_ITEM.get()).define('W', ItemTags.WOODEN_SLABS)
				.define('S', Items.STICK).pattern("WWW").pattern("SWS")
				.unlockedBy("has_wood", has(ItemTags.WOODEN_SLABS))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcherblock"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.COW_HOOD.get()).define('H', ButchercraftItems.COW_HEAD_ITEM.get())
				.define('L', ButchercraftItems.COW_HIDE.get()).define('S', Tags.Items.STRING).pattern(" H ")
				.pattern("SLS").unlockedBy("has_head", has(ButchercraftItems.COW_HEAD_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cow_hood"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.GOAT_HOOD.get())
				.define('H', ButchercraftItems.GOAT_HEAD_ITEM.get()).define('L', ButchercraftItems.GOAT_HIDE.get())
				.define('S', Tags.Items.STRING).pattern(" H ").pattern("SLS")
				.unlockedBy("has_head", has(ButchercraftItems.GOAT_HEAD_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_hood"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.PIG_HOOD.get()).define('H', ButchercraftItems.PIG_HEAD_ITEM.get())
				.define('L', ButchercraftItems.PIG_HIDE.get()).define('S', Tags.Items.STRING).pattern(" H ")
				.pattern("SLS").unlockedBy("has_head", has(ButchercraftItems.PIG_HEAD_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pig_hood"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.SHEEP_HOOD.get())
				.define('H', ButchercraftItems.SHEEP_HEAD_ITEM.get()).define('L', ButchercraftItems.SHEEP_HIDE.get())
				.define('S', Tags.Items.STRING).pattern(" H ").pattern("SLS")
				.unlockedBy("has_head", has(ButchercraftItems.SHEEP_HEAD_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sheep_hood"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.CHICKEN_MASK.get())
				.define('H', ButchercraftItems.CHICKEN_HEAD_ITEM.get()).define('F', Items.FEATHER).pattern("F F")
				.pattern("FHF").pattern("F F").unlockedBy("has_head", has(ButchercraftItems.CHICKEN_HEAD_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "chicken_mask"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.BEEF_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.BEEF_RAW),
						Ingredient.of(ButchercraftItems.GROUND_BEEF.get())), 9)
				.unlockedBy("has_beef", has(ButchercraftItemTags.BEEF_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_BEEF_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.BEEF_COOKED),
						Ingredient.of(ButchercraftItems.COOKED_GROUND_BEEF.get())), 9)
				.unlockedBy("has_beef_cooked", has(ButchercraftItemTags.BEEF_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.PORK_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.PORK_RAW),
						Ingredient.of(ButchercraftItems.GROUND_PORK.get())), 9)
				.unlockedBy("has_pork", has(ButchercraftItemTags.PORK_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_PORK_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.PORK_COOKED),
						Ingredient.of(ButchercraftItems.COOKED_GROUND_PORK.get())), 9)
				.unlockedBy("has_pork_cooked", has(ButchercraftItemTags.PORK_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.MUTTON_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.MUTTON_RAW),
						Ingredient.of(ButchercraftItems.GROUND_MUTTON.get())), 9)
				.unlockedBy("has_lamb", has(ButchercraftItemTags.MUTTON_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_MUTTON_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.MUTTON_COOKED),
						Ingredient.of(ButchercraftItems.COOKED_GROUND_MUTTON.get())), 9)
				.unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_lamb_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.GOAT_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.GOAT_RAW),
						Ingredient.of(ButchercraftItems.GROUND_GOAT.get())), 9)
				.unlockedBy("has_goat", has(ButchercraftItemTags.GOAT_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_GOAT_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.GOAT_COOKED),
						Ingredient.of(ButchercraftItems.COOKED_GROUND_GOAT.get())), 9)
				.unlockedBy("has_goat_cooked", has(ButchercraftItemTags.GOAT_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_goat_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.CHICKEN_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.CHICKEN_RAW),
						Ingredient.of(ButchercraftItems.GROUND_CHICKEN.get())), 9)
				.unlockedBy("has_chicken", has(ButchercraftItemTags.CHICKEN_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "chicken_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_CHICKEN_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.CHICKEN_COOKED),
						Ingredient.of(ButchercraftItems.COOKED_GROUND_CHICKEN.get())), 9)
				.unlockedBy("has_chicken_cooked", has(ButchercraftItemTags.CHICKEN_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_chicken_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.RABBIT_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.RABBIT_RAW),
						Ingredient.of(ButchercraftItems.GROUND_RABBIT.get())), 9)
				.unlockedBy("has_rabbit", has(ButchercraftItemTags.RABBIT_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "rabbit_block"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_RABBIT_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.RABBIT_COOKED),
						Ingredient.of(ButchercraftItems.COOKED_GROUND_RABBIT.get())), 9)
				.unlockedBy("has_rabbit_cooked", has(ButchercraftItemTags.RABBIT_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_rabbit_block"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.BEEF_SCRAPS.get(), 9)
				.requires(ButchercraftItems.BEEF_BLOCK_ITEM.get())
				.unlockedBy("has_beef", has(ButchercraftItemTags.BEEF_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_BEEF_SCRAPS.get(), 9)
				.requires(ButchercraftItems.COOKED_BEEF_BLOCK_ITEM.get())
				.unlockedBy("has_beef_cooked", has(ButchercraftItemTags.BEEF_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.PORK_SCRAPS.get(), 9)
				.requires(ButchercraftItems.PORK_BLOCK_ITEM.get())
				.unlockedBy("has_pork", has(ButchercraftItemTags.PORK_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_PORK_SCRAPS.get(), 9)
				.requires(ButchercraftItems.COOKED_PORK_BLOCK_ITEM.get())
				.unlockedBy("has_pork_cooked", has(ButchercraftItemTags.PORK_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.MUTTON_SCRAPS.get(), 9)
				.requires(ButchercraftItems.MUTTON_BLOCK_ITEM.get())
				.unlockedBy("has_lamb", has(ButchercraftItemTags.MUTTON_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_MUTTON_SCRAPS.get(), 9)
				.requires(ButchercraftItems.COOKED_MUTTON_BLOCK_ITEM.get())
				.unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_lamb_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.GOAT_SCRAPS.get(), 9)
				.requires(ButchercraftItems.GOAT_BLOCK_ITEM.get())
				.unlockedBy("has_goat", has(ButchercraftItemTags.GOAT_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_GOAT_SCRAPS.get(), 9)
				.requires(ButchercraftItems.COOKED_GOAT_BLOCK_ITEM.get())
				.unlockedBy("has_goat_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_goat_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.CHICKEN_SCRAPS.get(), 9)
				.requires(ButchercraftItems.CHICKEN_BLOCK_ITEM.get())
				.unlockedBy("has_chicken", has(ButchercraftItemTags.CHICKEN_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "chicken_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_CHICKEN_SCRAPS.get(), 9)
				.requires(ButchercraftItems.COOKED_CHICKEN_BLOCK_ITEM.get())
				.unlockedBy("has_chicken_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_chicken_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.RABBIT_SCRAPS.get(), 9)
				.requires(ButchercraftItems.RABBIT_BLOCK_ITEM.get())
				.unlockedBy("has_rabbit", has(ButchercraftItemTags.RABBIT_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "rabbit_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_RABBIT_SCRAPS.get(), 9)
				.requires(ButchercraftItems.COOKED_RABBIT_BLOCK_ITEM.get())
				.unlockedBy("has_rabbit_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_rabbit_block_to_scraps"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.BLOOD_SAUSAGE_BLOCK_ITEM.get(), 1)
				.requires(ButchercraftItems.BLOOD_SAUSAGE.get(), 9)
				.unlockedBy("has_blood_sausage", has(ButchercraftItems.BLOOD_SAUSAGE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "blood_sausage_to_block"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.BLOOD_SAUSAGE.get(), 9)
				.requires(ButchercraftItems.BLOOD_SAUSAGE_BLOCK_ITEM.get(), 1)
				.unlockedBy("has_blood_sausage_block", has(ButchercraftItems.BLOOD_SAUSAGE_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "blood_sausage_from_block"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.SAUSAGE_BLOCK_ITEM.get(), 1)
				.requires(ButchercraftItems.SAUSAGE.get(), 9)
				.unlockedBy("has_sausage", has(ButchercraftItems.SAUSAGE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sausage_to_block"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.SAUSAGE.get(), 9)
				.requires(ButchercraftItems.SAUSAGE_BLOCK_ITEM.get(), 1)
				.unlockedBy("has_sausage_block", has(ButchercraftItems.SAUSAGE_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sausage_from__block"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_BLOOD_SAUSAGE_BLOCK_ITEM.get(), 1)
				.requires(ButchercraftItems.COOKED_BLOOD_SAUSAGE.get(), 9)
				.unlockedBy("has_blood_sausage", has(ButchercraftItems.COOKED_BLOOD_SAUSAGE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_blood_sausage_to_block"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_BLOOD_SAUSAGE.get(), 9)
				.requires(ButchercraftItems.COOKED_BLOOD_SAUSAGE_BLOCK_ITEM.get(), 1)
				.unlockedBy("has_blood_sausage_block", has(ButchercraftItems.COOKED_BLOOD_SAUSAGE_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_blood_sausage_from_block"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_SAUSAGE_BLOCK_ITEM.get(), 1)
				.requires(ButchercraftItems.COOKED_SAUSAGE.get(), 9)
				.unlockedBy("has_sausage", has(ButchercraftItems.COOKED_SAUSAGE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_sausage_to_block"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_SAUSAGE.get(), 9)
				.requires(ButchercraftItems.COOKED_SAUSAGE_BLOCK_ITEM.get(), 1)
				.unlockedBy("has_sausage_block", has(ButchercraftItems.COOKED_SAUSAGE_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_sausage_from__block"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.BLOOD_SAUSAGE_MIX.get(), 8)
				.requires(ButchercraftItemTags.GROUND_MEAT_RAW).requires(ButchercraftItemTags.GROUND_MEAT_RAW)
				.requires(ButchercraftItemTags.GROUND_MEAT_RAW).requires(ButchercraftItemTags.GROUND_MEAT_RAW)
				.requires(ButchercraftItemTags.GROUND_MEAT_RAW).requires(ButchercraftItemTags.GROUND_MEAT_RAW)
				.requires(ButchercraftItems.FAT.get()).requires(Items.WHEAT_SEEDS)
				.requires(ButchercraftItems.BLOOD_FLUID_BOTTLE.get())
				.unlockedBy("has_lamb", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "blood_sausage_mix"));

		ShapelessRecipeBuilder.shapeless(Items.RED_DYE, 2).requires(ButchercraftItems.BLOOD_FLUID_BOTTLE.get())
				.unlockedBy("has_blood", has(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "blood_dye"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.LEATHER_CORD.get(), 3)
				.requires(ButchercraftItems.LEATHER_SCRAP.get(), 3)
				.unlockedBy("has_scrap", has(ButchercraftItems.LEATHER_SCRAP.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "leather_cord"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_BLACK_RABBIT_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.BLACK_RABBIT_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_rabbit", has(ButchercraftItems.BLACK_RABBIT_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_black_rabbit"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_BROWN_RABBIT_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.BROWN_RABBIT_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_rabbit", has(ButchercraftItems.BROWN_RABBIT_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_brown_rabbit"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_GOLD_RABBIT_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.GOLD_RABBIT_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_rabbit", has(ButchercraftItems.GOLD_RABBIT_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_gold_rabbit"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_SALT_RABBIT_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.SALT_RABBIT_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_rabbit", has(ButchercraftItems.SALT_RABBIT_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_salt_rabbit"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_SPLOTCHED_RABBIT_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_rabbit", has(ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_splotched_rabbit"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_WHITE_RABBIT_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.WHITE_RABBIT_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_rabbit", has(ButchercraftItems.WHITE_RABBIT_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_white_rabbit"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_GOAT_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.GOAT_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_goat", has(ButchercraftItems.GOAT_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_goat"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_COW_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.COW_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_cow", has(ButchercraftItems.COW_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_cow"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_SHEEP_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.SHEEP_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_sheep", has(ButchercraftItems.SHEEP_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_sheep"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_PIG_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.PIG_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_pig", has(ButchercraftItems.PIG_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_pig"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TAXIDERMY_CHICKEN_ITEM_BLOCK.get(), 1)
				.requires(ButchercraftItems.CHICKEN_CARCASS.get()).requires(Items.HAY_BLOCK)
				.unlockedBy("has_chicken", has(ButchercraftItems.CHICKEN_CARCASS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "taxidermy_chicken"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.BLOOD_FLUID_BUCKET.get(), 1)
				.requires(ButchercraftItems.BLOOD_FLUID_BOTTLE.get(), 4).requires(Items.BUCKET)
				.unlockedBy("has_blood", has(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "blood_bucket"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.BLOOD_FLUID_BOTTLE.get(), 4)
				.requires(ButchercraftItems.BLOOD_FLUID_BUCKET.get(), 1).requires(Items.GLASS_BOTTLE, 4)
				.unlockedBy("has_blood", has(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "blood_bottle"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get(), 8)
				.requires(ButchercraftItems.BLOOD_FLUID_BUCKET.get(), 1).requires(ItemTags.PLANKS)
				.requires(ItemTags.PLANKS).requires(ItemTags.PLANKS).requires(ItemTags.PLANKS).requires(ItemTags.PLANKS)
				.requires(ItemTags.PLANKS).requires(ItemTags.PLANKS).requires(ItemTags.PLANKS)
				.unlockedBy("has_blood", has(ButchercraftItems.BLOOD_FLUID_BUCKET.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "barn_wood"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.TRIMMED_BARN_WOOD_ITEM.get(), 1)
				.requires(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get(), 1).requires(Items.BONE_MEAL, 1)
				.unlockedBy("has_barn_wood", has(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "trimmed_barn_wood"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.SOAP.get(), 1).requires(ButchercraftItems.LARD.get(), 1)
				.requires(Items.BONE_MEAL, 1).requires(Ingredient.of(ItemTags.FLOWERS))
				.unlockedBy("has_barn_wood", has(ButchercraftItems.LARD.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "soap"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.BARN_WOOD_DOOR_ITEM.get(), 3).pattern("xx ").pattern("xx ")
				.pattern("xx ").define('x', ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get())
				.unlockedBy("has_barn_wood", has(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "barn_wood_door"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.BARN_WOOD_SLAB_ITEM.get(), 6).pattern("xxx")
				.define('x', ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get())
				.unlockedBy("has_barn_wood", has(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "barn_wood_slab"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.BARN_WOOD_STAIRS_ITEM.get(), 4).pattern("x  ").pattern("xx ")
				.pattern("xxx").define('x', ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get())
				.unlockedBy("has_barn_wood", has(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "barn_wood_stairs"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.BARN_WOOD_TRAPDOOR_ITEM.get(), 2).pattern("xxx").pattern("xxx")
				.define('x', ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get())
				.unlockedBy("has_barn_wood", has(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "barn_wood_trapdoor"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.BARN_WOOD_FENCE_ITEM.get(), 3).pattern("xsx").pattern("xsx")
				.define('x', ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()).define('s', Items.STICK)
				.unlockedBy("has_barn_wood", has(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "barn_wood_fence"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.BARN_WOOD_FENCE_GATE_ITEM.get()).pattern("sxs").pattern("sxs")
				.define('x', ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()).define('s', Items.STICK)
				.unlockedBy("has_barn_wood", has(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "barn_wood_fence_gate"));

		createFoodRecipe(Ingredient.of(ButchercraftItems.BRAIN.get()), ButchercraftItems.COOKED_BRAIN.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.HEART.get()), ButchercraftItems.COOKED_HEART.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.KIDNEY.get()), ButchercraftItems.COOKED_KIDNEY.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.LIVER.get()), ButchercraftItems.COOKED_LIVER.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.LUNG.get()), ButchercraftItems.COOKED_LUNG.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.STOMACH.get()), ButchercraftItems.COOKED_STOMACH.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.TRIPE.get()), ButchercraftItems.COOKED_TRIPE.get(), consumer);

		createFoodRecipe(Ingredient.of(ButchercraftItems.BEEF_STEW_MEAT.get()),
				ButchercraftItems.COOKED_BEEF_STEW_MEAT.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.BEEF_ROAST.get()), ButchercraftItems.COOKED_BEEF_ROAST.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.BEEF_RIBS.get()), ButchercraftItems.COOKED_BEEF_RIBS.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CUBED_BEEF.get()), ButchercraftItems.COOKED_CUBED_BEEF.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GROUND_BEEF.get()), ButchercraftItems.COOKED_GROUND_BEEF.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.BEEF_SCRAPS.get()), ButchercraftItems.COOKED_BEEF_SCRAPS.get(),
				consumer);

		createFoodRecipe(Ingredient.of(ButchercraftItems.PORK_STEW_MEAT.get()),
				ButchercraftItems.COOKED_PORK_STEW_MEAT.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.PORK_ROAST.get()), ButchercraftItems.COOKED_PORK_ROAST.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.PORK_RIBS.get()), ButchercraftItems.COOKED_PORK_RIBS.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CUBED_PORK.get()), ButchercraftItems.COOKED_CUBED_PORK.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GROUND_PORK.get()), ButchercraftItems.COOKED_GROUND_PORK.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.PORK_SCRAPS.get()), ButchercraftItems.COOKED_PORK_SCRAPS.get(),
				consumer);

		createFoodRecipe(Ingredient.of(ButchercraftItems.MUTTON_STEW_MEAT.get()),
				ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.MUTTON_ROAST.get()),
				ButchercraftItems.COOKED_MUTTON_ROAST.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.MUTTON_RIBS.get()), ButchercraftItems.COOKED_MUTTON_RIBS.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CUBED_MUTTON.get()),
				ButchercraftItems.COOKED_CUBED_MUTTON.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GROUND_MUTTON.get()),
				ButchercraftItems.COOKED_GROUND_MUTTON.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.MUTTON_SCRAPS.get()),
				ButchercraftItems.COOKED_MUTTON_SCRAPS.get(), consumer);

		createFoodRecipe(Ingredient.of(ButchercraftItems.GOAT_CHOP.get()), ButchercraftItems.COOKED_GOAT_CHOP.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GOAT_STEW_MEAT.get()),
				ButchercraftItems.COOKED_GOAT_STEW_MEAT.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GOAT_ROAST.get()), ButchercraftItems.COOKED_GOAT_ROAST.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GOAT_RIBS.get()), ButchercraftItems.COOKED_GOAT_RIBS.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CUBED_GOAT.get()), ButchercraftItems.COOKED_CUBED_GOAT.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GROUND_GOAT.get()), ButchercraftItems.COOKED_GROUND_GOAT.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GOAT_SCRAPS.get()), ButchercraftItems.COOKED_GOAT_SCRAPS.get(),
				consumer);

		createFoodRecipe(Ingredient.of(ButchercraftItems.RABBIT_LEG.get()), ButchercraftItems.COOKED_RABBIT_LEG.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.RABBIT_SADDLE.get()),
				ButchercraftItems.COOKED_RABBIT_SADDLE.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CUBED_RABBIT.get()),
				ButchercraftItems.COOKED_CUBED_RABBIT.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GROUND_RABBIT.get()),
				ButchercraftItems.COOKED_GROUND_RABBIT.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.RABBIT_SCRAPS.get()),
				ButchercraftItems.COOKED_RABBIT_SCRAPS.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.RABBIT_THIGH.get()),
				ButchercraftItems.COOKED_RABBIT_THIGH.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.STEW_RABBIT.get()), ButchercraftItems.COOKED_STEW_RABBIT.get(),
				consumer);

		createFoodRecipe(Ingredient.of(ButchercraftItems.CHICKEN_BREAST.get()),
				ButchercraftItems.COOKED_CHICKEN_BREAST.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CHICKEN_LEG.get()), ButchercraftItems.COOKED_CHICKEN_LEG.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CHICKEN_SCRAPS.get()),
				ButchercraftItems.COOKED_CHICKEN_SCRAPS.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CHICKEN_THIGH.get()),
				ButchercraftItems.COOKED_CHICKEN_THIGH.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CHICKEN_WING.get()),
				ButchercraftItems.COOKED_CHICKEN_WING.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.STEW_CHICKEN.get()),
				ButchercraftItems.COOKED_STEW_CHICKEN.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CUBED_CHICKEN.get()),
				ButchercraftItems.COOKED_CUBED_CHICKEN.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GROUND_CHICKEN.get()),
				ButchercraftItems.COOKED_GROUND_CHICKEN.get(), consumer);

		createFoodRecipe(Ingredient.of(ButchercraftItems.SAUSAGE.get()), ButchercraftItems.COOKED_SAUSAGE.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.BLOOD_SAUSAGE.get()),
				ButchercraftItems.COOKED_BLOOD_SAUSAGE.get(), consumer);

		createFoodRecipe(Ingredient.of(ButchercraftItems.HORN.get()), ButchercraftItems.GELATIN.get(), consumer,
				"horn_gelatin");
		createFoodRecipe(Ingredient.of(ButchercraftItems.SINEW.get()), ButchercraftItems.GELATIN.get(), consumer,
				"sinew_gelatin");
		createFoodRecipe(Ingredient.of(ButchercraftItems.BEAK.get()), ButchercraftItems.GELATIN.get(), consumer,
				"beak_gelatin");
		createFoodRecipe(Ingredient.of(ButchercraftItems.FAT.get()), ButchercraftItems.LARD.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.OXTAIL.get()), ButchercraftItems.COOKED_OXTAIL.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.WATTLE.get()), ButchercraftItems.COOKED_WATTLE.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.EYEBALL.get()), ButchercraftItems.COOKED_EYEBALL.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.TONGUE.get()), ButchercraftItems.COOKED_TONGUE.get(),
				consumer);

		GrinderRecipeBuilder
				.grind(Ingredient.of(ButchercraftItems.BEEF_SCRAPS.get()), 1,
						Ingredient.of(ButchercraftItems.GRINDER_TIP.get()), ButchercraftItems.GROUND_BEEF.get(), 4, 2)
				.unlockedBy("has_beef_scrap", has(ButchercraftItems.BEEF_SCRAPS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_scrap_to_ground_beef"));

		GrinderRecipeBuilder
				.grind(Ingredient.of(ButchercraftItems.PORK_SCRAPS.get()), 1,
						Ingredient.of(ButchercraftItems.GRINDER_TIP.get()), ButchercraftItems.GROUND_PORK.get(), 4, 2)
				.unlockedBy("has_pork_scrap", has(ButchercraftItems.BEEF_SCRAPS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_scrap_to_ground_pork"));

		GrinderRecipeBuilder
				.grind(Ingredient.of(ButchercraftItems.MUTTON_SCRAPS.get()), 1,
						Ingredient.of(ButchercraftItems.GRINDER_TIP.get()), ButchercraftItems.GROUND_MUTTON.get(), 4, 2)
				.unlockedBy("has_mutton_scrap", has(ButchercraftItems.MUTTON_SCRAPS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "mutton_scrap_to_ground_mutton"));

		GrinderRecipeBuilder
				.grind(Ingredient.of(ButchercraftItems.GOAT_SCRAPS.get()), 1,
						Ingredient.of(ButchercraftItems.GRINDER_TIP.get()), ButchercraftItems.GROUND_GOAT.get(), 4, 2)
				.unlockedBy("has_goat_scrap", has(ButchercraftItems.GOAT_SCRAPS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_scrap_to_ground_goat"));

		GrinderRecipeBuilder.grind(Ingredient.of(ButchercraftItems.CHICKEN_SCRAPS.get()), 1,
				Ingredient.of(ButchercraftItems.GRINDER_TIP.get()), ButchercraftItems.GROUND_CHICKEN.get(), 4, 2)
				.unlockedBy("has_chicken_scrap", has(ButchercraftItems.CHICKEN_SCRAPS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "chicken_scrap_to_ground_chicken"));

		GrinderRecipeBuilder
				.grind(Ingredient.of(ButchercraftItems.RABBIT_SCRAPS.get()), 1,
						Ingredient.of(ButchercraftItems.GRINDER_TIP.get()), ButchercraftItems.GROUND_RABBIT.get(), 4, 2)
				.unlockedBy("has_rabbit_scrap", has(ButchercraftItems.RABBIT_SCRAPS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "rabbit_scrap_to_ground_rabbit"));

		GrinderRecipeBuilder.grind(Ingredient.of(ButchercraftItemTags.GROUND_MEAT_RAW), 8,
				Ingredient.of(ButchercraftItems.EXTRUDER_TIP.get()), ButchercraftItems.SAUSAGE_LINKED.get(), 16, 1)
				.unlockedBy("has_ground_beef", has(ButchercraftItems.GROUND_BEEF.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "ground_beef_to_sausage"));

		GrinderRecipeBuilder
				.grind(Ingredient.of(ButchercraftItems.BLOOD_SAUSAGE_MIX.get()), 8,
						Ingredient.of(ButchercraftItems.EXTRUDER_TIP.get()),
						ButchercraftItems.BLOOD_SAUSAGE_LINKED.get(), 16, 1)
				.unlockedBy("has_blood_sausage_mix", has(ButchercraftItems.BLOOD_SAUSAGE_MIX.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "blood_sausage_to_links"));
	}

	private void createFoodRecipe(Ingredient pIngredient, ItemLike pResult, Consumer<FinishedRecipe> consumer) {
		createFoodRecipe(pIngredient, pResult, consumer, ForgeRegistries.ITEMS.getKey(pResult.asItem()).getPath());
	}

	private void createFoodRecipe(Ingredient pIngredient, ItemLike pResult, Consumer<FinishedRecipe> consumer,
			String id) {
		SimpleCookingRecipeBuilder.smoking(pIngredient, pResult, .35F, 100)
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(pIngredient.getItems()[0].getItem()).getPath(),
						has(pIngredient.getItems()[0].getItem()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, id + "_from_smoking"));
		SimpleCookingRecipeBuilder.campfireCooking(pIngredient, pResult, .35F, 600)
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(pIngredient.getItems()[0].getItem()).getPath(),
						has(pIngredient.getItems()[0].getItem()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, id + "_from_campfire_cooking"));
		SimpleCookingRecipeBuilder.smelting(pIngredient, pResult, .35F, 200)
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(pIngredient.getItems()[0].getItem()).getPath(),
						has(pIngredient.getItems()[0].getItem()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, id + "_from_smelting"));
	}

}
