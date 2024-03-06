package com.lance5057.butchercraft.data.builders.recipes;

import static com.lance5057.butchercraft.ButchercraftItems.BEEF_BLOCK_ITEM;
import static com.lance5057.butchercraft.ButchercraftItems.BEEF_SCRAPS;
import static com.lance5057.butchercraft.ButchercraftItems.BONE_SAW;
import static com.lance5057.butchercraft.ButchercraftItems.BRAIN;
import static com.lance5057.butchercraft.ButchercraftItems.BUTCHER_KNIFE;
import static com.lance5057.butchercraft.ButchercraftItems.CHICKEN_CARCASS;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_BEEF_BLOCK_ITEM;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_BEEF_SCRAPS;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_BRAIN;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_HEART;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_KIDNEY;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_LAMB_BLOCK_ITEM;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_LAMB_SCRAPS;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_LIVER;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_LUNG;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_PORK_BLOCK_ITEM;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_PORK_SCRAPS;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_STOMACH;
import static com.lance5057.butchercraft.ButchercraftItems.COOKED_TRIPE;
import static com.lance5057.butchercraft.ButchercraftItems.COW_CARCASS;
import static com.lance5057.butchercraft.ButchercraftItems.GROUND_BEEF;
import static com.lance5057.butchercraft.ButchercraftItems.GUT_KNIFE;
import static com.lance5057.butchercraft.ButchercraftItems.HEART;
import static com.lance5057.butchercraft.ButchercraftItems.HOOK_BLOCK_ITEM;
import static com.lance5057.butchercraft.ButchercraftItems.KIDNEY;
import static com.lance5057.butchercraft.ButchercraftItems.LAMB_BLOCK_ITEM;
import static com.lance5057.butchercraft.ButchercraftItems.LAMB_SCRAPS;
import static com.lance5057.butchercraft.ButchercraftItems.LIVER;
import static com.lance5057.butchercraft.ButchercraftItems.LUNG;
import static com.lance5057.butchercraft.ButchercraftItems.PIG_CARCASS;
import static com.lance5057.butchercraft.ButchercraftItems.PORK_BLOCK_ITEM;
import static com.lance5057.butchercraft.ButchercraftItems.PORK_SCRAPS;
import static com.lance5057.butchercraft.ButchercraftItems.SHEEP_CARCASS;
import static com.lance5057.butchercraft.ButchercraftItems.SKINNING_KNIFE;
import static com.lance5057.butchercraft.ButchercraftItems.STOMACH;
import static com.lance5057.butchercraft.ButchercraftItems.TRIPE;
import static net.minecraft.world.item.Items.IRON_INGOT;
import static net.minecraft.world.item.Items.STICK;

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
		return new BlacklistedModel(rl, null, true, new AnimationFloatTransform());
	}

	BlacklistedModel standardHookToolModel(Item i) {
		return new BlacklistedModel(i,
				new AnimationFloatTransform()
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
				.setLocation(new AnimatedFloatVector3(new AnimatedFloat(8), new AnimatedFloat(0), new AnimatedFloat(8)))
				.setRotation(new AnimatedFloatVector3().setX(new AnimatedFloat(-90)))
				.setScale(new AnimatedFloatVector3().setAll(new AnimatedFloat(1))));
	}

	BlacklistedModel standardButcherBlockToolModel(Item i) {
		return new BlacklistedModel(i,
				new AnimationFloatTransform()
						.setRotation(new AnimatedFloatVector3().setZ(new AnimatedFloat(-45, 45, 0, 0.05f, true, true)))
						.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
								.setY(new AnimatedFloat(8, 0)).setZ(new AnimatedFloat(8, 0)))
						.setScale(new AnimatedFloatVector3().setAll(new AnimatedFloat(-0.5f, 0))));
	}

	@Override
	protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
		MeatHookRecipeBuilder.shapedRecipe(COW_CARCASS.get())
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 12, true, MeatHookLoottables.SKIN_COW,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow")),
						standardHookToolModel(SKINNING_KNIFE.get()))
				.tool(Ingredient.of(BONE_SAW.get()), 12, true, MeatHookLoottables.BISECT_COW,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_skinned")),
						standardHookToolModel(BONE_SAW.get()))
				.tool(Ingredient.of(GUT_KNIFE.get()), 12, true, MeatHookLoottables.DISEMBOWEL_COW,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_gutted")),
						standardHookToolModel(GUT_KNIFE.get()))
				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 12, true, MeatHookLoottables.BUTCHER_COW,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_bisected")),
						standardHookToolModel(BUTCHER_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cow"));

		MeatHookRecipeBuilder.shapedRecipe(SHEEP_CARCASS.get())
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 12, true, MeatHookLoottables.SKIN_SHEEP,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep")),
						standardHookToolModel(SKINNING_KNIFE.get()))
				.tool(Ingredient.of(BONE_SAW.get()), 12, true, MeatHookLoottables.BISECT_SHEEP,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_skinned")),
						standardHookToolModel(BONE_SAW.get()))
				.tool(Ingredient.of(GUT_KNIFE.get()), 12, true, MeatHookLoottables.DISEMBOWEL_SHEEP,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_gutted")),
						standardHookToolModel(GUT_KNIFE.get()))
				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 12, true, MeatHookLoottables.BUTCHER_SHEEP,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_bisected")),
						standardHookToolModel(BUTCHER_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sheep"));

		MeatHookRecipeBuilder.shapedRecipe(PIG_CARCASS.get())
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 12, true, MeatHookLoottables.SKIN_PIG,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig")),
						standardHookToolModel(SKINNING_KNIFE.get()))
				.tool(Ingredient.of(BONE_SAW.get()), 12, true, MeatHookLoottables.BISECT_PIG,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_skinned")),
						standardHookToolModel(BONE_SAW.get()))
				.tool(Ingredient.of(GUT_KNIFE.get()), 12, true, MeatHookLoottables.DISEMBOWEL_PIG,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_gutted")),
						standardHookToolModel(GUT_KNIFE.get()))
				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 12, true, MeatHookLoottables.BUTCHER_PIG,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_bisected")),
						standardHookToolModel(BUTCHER_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pig"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.GOAT_CARCASS.get())
				.tool(Ingredient.of(Items.BUCKET), 1, true, MeatHookLoottables.BLOOD_BUCKET,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat")),
						standardHookToolModel(Items.BUCKET))
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 12, true, MeatHookLoottables.SKIN_GOAT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat")),
						standardHookToolModel(SKINNING_KNIFE.get()))
				.tool(Ingredient.of(BONE_SAW.get()), 12, true, MeatHookLoottables.BISECT_GOAT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_skinned")),
						standardHookToolModel(BONE_SAW.get()))
				.tool(Ingredient.of(GUT_KNIFE.get()), 12, true, MeatHookLoottables.DISEMBOWEL_GOAT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_gutted")),
						standardHookToolModel(GUT_KNIFE.get()))
				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 12, true, MeatHookLoottables.BUTCHER_GOAT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_bisected")),
						standardHookToolModel(BUTCHER_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat"));

		ButcherBlockRecipeBuilder.shapedRecipe(CHICKEN_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(Tags.Items.SHEARS), 1, true, ButcherBlockLootTables.PLUCK_CHICKEN,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken")),
						standardButcherBlockToolModel(Items.SHEARS))
				.tool(Ingredient.of(GUT_KNIFE.get()), 12, true, ButcherBlockLootTables.DEOFFAL_CHICKEN,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken_plucked")),
						standardButcherBlockToolModel(GUT_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_chicken"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.CHICKEN)
				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 12, true, ButcherBlockLootTables.BUTCHER_CHICKEN,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_whole_chicken"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.BLACK_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_black")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_black")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_BLACK_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_black")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_black_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_black_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.BROWN_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_brown")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_brown")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_BROWN_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_brown")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_brown_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_brown_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_splotched")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_splotched")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_SPLOTCHED_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_splotched")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_splotched_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_splotched_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.GOLD_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_gold")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_gold")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_GOLD_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_gold")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_gold_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_gold_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.SALT_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_salt")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_salt")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_SALT_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_salt")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_salt_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_salt_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.WHITE_RABBIT_CARCASS.get())
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_white")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(Items.GLASS_BOTTLE), 1, true, ButcherBlockLootTables.BLOOD_BOTTLE,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_white")),
						standardButcherBlockToolModel(Items.GLASS_BOTTLE))
				.tool(Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
						ButcherBlockLootTables.SKIN_WHITE_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_white")),
						standardButcherBlockToolModel(ButchercraftItems.SKINNING_KNIFE.get()))
				.tool(Ingredient.of(ButchercraftItems.GUT_KNIFE.get()), 6, true, ButcherBlockLootTables.DEOFFAL_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_white_gutted")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_white_rabbit"));

		ButcherBlockRecipeBuilder.shapedRecipe(Items.RABBIT)
				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 12, true, ButcherBlockLootTables.BUTCHER_RABBIT,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/rabbit_skinned")),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_whole_rabbit"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.COW_HIDE.get())
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 6, true, MeatHookLoottables.SCRAPE_HIDE,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_hide")),
						standardHookToolModel(SKINNING_KNIFE.get()))
				.tool(Ingredient.of(Items.SHEARS), 6, true, MeatHookLoottables.COW_LEATHER,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_hide")),
						standardHookToolModel(Items.SHEARS))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cow_hide"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.GOAT_HIDE.get())
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 6, true, MeatHookLoottables.SCRAPE_HIDE,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_hide")),
						standardHookToolModel(SKINNING_KNIFE.get()))
				.tool(Ingredient.of(Items.SHEARS), 6, true, MeatHookLoottables.GOAT_LEATHER,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/goat_hide")),
						standardHookToolModel(Items.SHEARS))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "goat_hide"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.PIG_HIDE.get())
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 6, true, MeatHookLoottables.SCRAPE_HIDE,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_hide")),
						standardHookToolModel(SKINNING_KNIFE.get()))
				.tool(Ingredient.of(Items.SHEARS), 6, true, MeatHookLoottables.PIG_LEATHER,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_hide")),
						standardHookToolModel(Items.SHEARS))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pig_hide"));

		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.SHEEP_HIDE.get())
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 6, true, MeatHookLoottables.SCRAPE_HIDE,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_hide")),
						standardHookToolModel(SKINNING_KNIFE.get()))
				.tool(Ingredient.of(Items.SHEARS), 6, true, MeatHookLoottables.SHEEP_LEATHER,
						hideModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_hide")),
						standardHookToolModel(Items.SHEARS))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sheep_hide"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.CHICKEN_HEAD_ITEM.get())
				.tool(Ingredient.of(GUT_KNIFE.get()), 12, true, ButcherBlockLootTables.CHICKEN_HEAD,
						standardModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/chicken_head")),
						standardButcherBlockToolModel(ButchercraftItems.GUT_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "chicken_head"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.BLOOD_SAUSAGE_LINKED.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 8, true,
						ButcherBlockLootTables.BLOOD_SAUSAGE_LINKED,
						layFlatModel(ButchercraftItems.BLOOD_SAUSAGE_LINKED.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "blood_sausage_linked"));

		ButcherBlockRecipeBuilder.shapedRecipe(ButchercraftItems.SAUSAGE_LINKED.get())
				.tool(Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()), 8, true,
						ButcherBlockLootTables.SAUSAGE_LINKED, layFlatModel(ButchercraftItems.SAUSAGE_LINKED.get()),
						standardButcherBlockToolModel(ButchercraftItems.BUTCHER_KNIFE.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sausage_linked"));

		ShapedRecipeBuilder.shaped(BONE_SAW.get()).define('I', IRON_INGOT).define('S', STICK).pattern("IIS")
				.pattern("IIS").unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "bone_saw"));
		ShapedRecipeBuilder.shaped(BUTCHER_KNIFE.get()).define('I', IRON_INGOT).define('S', STICK).pattern(" II")
				.pattern(" II").pattern("S  ").unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "butcher_knife"));
		ShapedRecipeBuilder.shaped(SKINNING_KNIFE.get()).define('I', IRON_INGOT).define('S', STICK).pattern(" II")
				.pattern("S  ").unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "skinning_knife"));
		ShapedRecipeBuilder.shaped(GUT_KNIFE.get()).define('I', IRON_INGOT).define('S', STICK).pattern("I  ")
				.pattern(" I ").pattern(" S ").unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "gut_knife"));

		ShapedRecipeBuilder.shaped(HOOK_BLOCK_ITEM.get()).define('I', IRON_INGOT).define('C', Items.CHAIN)
				.define('N', Items.IRON_NUGGET).pattern("III").pattern("NCN").pattern("NNN")
				.unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "meat_hook"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.GRINDER_TIP.get()).define('I', Items.IRON_TRAPDOOR)
				.define('C', Items.IRON_BARS).pattern("C  ").pattern("I  ").unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "grinder_tip"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.EXTRUDER_TIP.get()).define('I', Items.IRON_TRAPDOOR)
				.define('C', Items.IRON_INGOT).pattern("C  ").pattern("I  ").unlockedBy("has_iron", has(IRON_INGOT))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "extruder_tip"));

		ShapedRecipeBuilder.shaped(ButchercraftItems.GRINDER_BLOCK_ITEM.get()).define('S', Items.IRON_SWORD)
				.define('P', Items.PISTON).define('C', Items.IRON_INGOT).define('B', ItemTags.BUTTONS)
				.define('H', Items.HOPPER).pattern("BH ").pattern("CSC").pattern("CPH")
				.unlockedBy("has_iron", has(IRON_INGOT))
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

		ShapelessRecipeBuilder.shapeless(BEEF_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.BEEF_RAW),
						Ingredient.of(ButchercraftItems.GROUND_BEEF.get())), 9)
				.unlockedBy("has_beef", has(ButchercraftItemTags.BEEF_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_block"));
		ShapelessRecipeBuilder.shapeless(COOKED_BEEF_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.BEEF_COOKED),
						Ingredient.of(ButchercraftItems.COOKED_GROUND_BEEF.get())), 9)
				.unlockedBy("has_beef_cooked", has(ButchercraftItemTags.BEEF_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_block"));
		ShapelessRecipeBuilder.shapeless(PORK_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.PORK_RAW),
						Ingredient.of(ButchercraftItems.GROUND_PORK.get())), 9)
				.unlockedBy("has_pork", has(ButchercraftItemTags.PORK_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_block"));
		ShapelessRecipeBuilder.shapeless(COOKED_PORK_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.PORK_COOKED),
						Ingredient.of(ButchercraftItems.COOKED_GROUND_PORK.get())), 9)
				.unlockedBy("has_pork_cooked", has(ButchercraftItemTags.PORK_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_block"));
		ShapelessRecipeBuilder.shapeless(LAMB_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.MUTTON_RAW),
						Ingredient.of(ButchercraftItems.GROUND_LAMB.get())), 9)
				.unlockedBy("has_lamb", has(ButchercraftItemTags.MUTTON_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_block"));
		ShapelessRecipeBuilder.shapeless(COOKED_LAMB_BLOCK_ITEM.get())
				.requires(DifferenceIngredient.of(Ingredient.of(ButchercraftItemTags.MUTTON_COOKED),
						Ingredient.of(ButchercraftItems.COOKED_GROUND_LAMB.get())), 9)
				.unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_lamb_block"));

		ShapelessRecipeBuilder.shapeless(BEEF_SCRAPS.get(), 9).requires(BEEF_BLOCK_ITEM.get())
				.unlockedBy("has_beef", has(ButchercraftItemTags.BEEF_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(COOKED_BEEF_SCRAPS.get(), 9).requires(COOKED_BEEF_BLOCK_ITEM.get())
				.unlockedBy("has_beef_cooked", has(ButchercraftItemTags.BEEF_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(PORK_SCRAPS.get(), 9).requires(PORK_BLOCK_ITEM.get())
				.unlockedBy("has_pork", has(ButchercraftItemTags.PORK_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(COOKED_PORK_SCRAPS.get(), 9).requires(COOKED_PORK_BLOCK_ITEM.get())
				.unlockedBy("has_pork_cooked", has(ButchercraftItemTags.PORK_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(LAMB_SCRAPS.get(), 9).requires(LAMB_BLOCK_ITEM.get())
				.unlockedBy("has_lamb", has(ButchercraftItemTags.MUTTON_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(COOKED_LAMB_SCRAPS.get(), 9).requires(COOKED_LAMB_BLOCK_ITEM.get())
				.unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_lamb_block_to_scraps"));

		ShapelessRecipeBuilder.shapeless(Items.COOKED_BEEF, 4).requires(ButchercraftItems.COOKED_BEEF_ROAST.get())
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_beef_cooked", has(ButchercraftItemTags.BEEF_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_roast_to_steaks"));
		ShapelessRecipeBuilder.shapeless(Items.COOKED_PORKCHOP, 4).requires(ButchercraftItems.COOKED_PORK_ROAST.get())
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_pork_cooked", has(ButchercraftItemTags.PORK_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_roast_to_steaks"));
		ShapelessRecipeBuilder.shapeless(Items.COOKED_MUTTON, 4).requires(ButchercraftItems.COOKED_LAMB_ROAST.get())
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_lamb_roast_to_steaks"));

		ShapelessRecipeBuilder.shapeless(Items.BEEF, 4).requires(ButchercraftItems.BEEF_ROAST.get())
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_beef_cooked", has(ButchercraftItemTags.BEEF_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_roast_to_steaks"));
		ShapelessRecipeBuilder.shapeless(Items.PORKCHOP, 4).requires(ButchercraftItems.PORK_ROAST.get())
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_pork_cooked", has(ButchercraftItemTags.PORK_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_roast_to_steaks"));
		ShapelessRecipeBuilder.shapeless(Items.MUTTON, 4).requires(ButchercraftItems.LAMB_ROAST.get())
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.MUTTON_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_roast_to_steaks"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_CUBED_BEEF.get()).requires(Items.COOKED_BEEF)
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_beef_cooked", has(ButchercraftItemTags.BEEF_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_to_cubes"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_CUBED_PORK.get()).requires(Items.COOKED_PORKCHOP)
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_pork_cooked", has(ButchercraftItemTags.PORK_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_to_cubes"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_CUBED_LAMB.get()).requires(Items.COOKED_MUTTON)
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_lamb_to_cubes"));

		ShapelessRecipeBuilder.shapeless(ButchercraftItems.CUBED_BEEF.get()).requires(Items.BEEF)
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_beef_cooked", has(ButchercraftItemTags.BEEF_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_to_cubes"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.CUBED_PORK.get()).requires(Items.PORKCHOP)
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_pork_cooked", has(ButchercraftItemTags.PORK_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_to_cubes"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.CUBED_LAMB.get()).requires(Items.MUTTON)
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.MUTTON_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_to_cubes"));

//		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_GROUND_BEEF.get(), 1)
//				.requires(COOKED_BEEF_SCRAPS.get()).requires(BUTCHER_KNIFE.get())
//				.unlockedBy("has_beef_cooked", has(ButchercraftItemTags.BEEF_COOKED))
//				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_scraps_to_ground"));
//		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_GROUND_PORK.get(), 1)
//				.requires(COOKED_PORK_SCRAPS.get()).requires(BUTCHER_KNIFE.get())
//				.unlockedBy("has_pork_cooked", has(ButchercraftItemTags.PORK_COOKED))
//				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_scraps_to_ground"));
//		ShapelessRecipeBuilder.shapeless(ButchercraftItems.COOKED_GROUND_LAMB.get(), 1)
//				.requires(COOKED_LAMB_SCRAPS.get()).requires(BUTCHER_KNIFE.get())
//				.unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.MUTTON_COOKED))
//				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_lamb_scraps_to_ground"));

		ShapelessRecipeBuilder.shapeless(GROUND_BEEF.get(), 1).requires(BEEF_SCRAPS.get()).requires(BUTCHER_KNIFE.get())
				.unlockedBy("has_beef", has(ButchercraftItemTags.BEEF_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_scraps_to_ground"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.GROUND_PORK.get(), 1).requires(PORK_SCRAPS.get())
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_pork", has(ButchercraftItemTags.PORK_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_scraps_to_ground"));
		ShapelessRecipeBuilder.shapeless(ButchercraftItems.GROUND_LAMB.get(), 1).requires(LAMB_SCRAPS.get())
				.requires(BUTCHER_KNIFE.get()).unlockedBy("has_lamb", has(ButchercraftItemTags.MUTTON_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_scraps_to_ground"));

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

		createFoodRecipe(Ingredient.of(BRAIN.get()), COOKED_BRAIN.get(), consumer);
		createFoodRecipe(Ingredient.of(HEART.get()), COOKED_HEART.get(), consumer);
		createFoodRecipe(Ingredient.of(KIDNEY.get()), COOKED_KIDNEY.get(), consumer);
		createFoodRecipe(Ingredient.of(LIVER.get()), COOKED_LIVER.get(), consumer);
		createFoodRecipe(Ingredient.of(LUNG.get()), COOKED_LUNG.get(), consumer);
		createFoodRecipe(Ingredient.of(STOMACH.get()), COOKED_STOMACH.get(), consumer);
		createFoodRecipe(Ingredient.of(TRIPE.get()), COOKED_TRIPE.get(), consumer);

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

		createFoodRecipe(Ingredient.of(ButchercraftItems.LAMB_STEW_MEAT.get()),
				ButchercraftItems.COOKED_LAMB_STEW_MEAT.get(), consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.LAMB_ROAST.get()), ButchercraftItems.COOKED_LAMB_ROAST.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.LAMB_RIBS.get()), ButchercraftItems.COOKED_LAMB_RIBS.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.CUBED_LAMB.get()), ButchercraftItems.COOKED_CUBED_LAMB.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.GROUND_LAMB.get()), ButchercraftItems.COOKED_GROUND_LAMB.get(),
				consumer);
		createFoodRecipe(Ingredient.of(ButchercraftItems.LAMB_SCRAPS.get()), ButchercraftItems.COOKED_LAMB_SCRAPS.get(),
				consumer);

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

		GrinderRecipeBuilder
				.grind(Ingredient.of(ButchercraftItems.BEEF_SCRAPS.get()), 1,
						Ingredient.of(ButchercraftItems.GRINDER_TIP.get()), ButchercraftItems.GROUND_BEEF.get(), 4, 2)
				.unlockedBy("has_beef_scrap", has(BEEF_SCRAPS.get()))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_scrap_to_ground_beef"));

		GrinderRecipeBuilder.grind(Ingredient.of(ButchercraftItemTags.GROUND_MEAT_RAW), 8,
				Ingredient.of(ButchercraftItems.EXTRUDER_TIP.get()), ButchercraftItems.SAUSAGE_LINKED.get(), 16, 1)
				.unlockedBy("has_ground_beef", has(GROUND_BEEF.get()))
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
