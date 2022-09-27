package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimatedFloat;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimatedFloatVector3;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimationFloatTransform;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
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
		MeatHookRecipeBuilder.shapedRecipe(COW_CARCASS.get())
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/skin_cow"),
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow"), null, true,
								new AnimationFloatTransform()),
						new BlacklistedModel(SKINNING_KNIFE.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.tool(Ingredient.of(BONE_SAW.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/delimb_cow"),
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_skinned"), null,
								true, new AnimationFloatTransform()),
						new BlacklistedModel(BONE_SAW.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.tool(Ingredient.of(GUT_KNIFE.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/deoffal_cow"),
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_gutted"), null,
								true, new AnimationFloatTransform()),
						new BlacklistedModel(GUT_KNIFE.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))

				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/butcher_cow"),
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/cow_bisected"), null,
								true, new AnimationFloatTransform()),
						new BlacklistedModel(BUTCHER_KNIFE.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cowtest"));

		MeatHookRecipeBuilder.shapedRecipe(SHEEP_CARCASS.get())
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/skin_sheep"),
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep"), null, true,
								new AnimationFloatTransform()),
						new BlacklistedModel(SKINNING_KNIFE.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.tool(Ingredient.of(GUT_KNIFE.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/deoffal_sheep"),
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_skinned"), null,
								true, new AnimationFloatTransform()),
						new BlacklistedModel(GUT_KNIFE.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.tool(Ingredient.of(BONE_SAW.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/delimb_sheep"),
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_gutted"), null,
								true, new AnimationFloatTransform()),
						new BlacklistedModel(BONE_SAW.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 6, true,
						new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/butcher_sheep"),
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/sheep_bisected"), null,
								true, new AnimationFloatTransform()),
						new BlacklistedModel(BUTCHER_KNIFE.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "sheeptest"));

		MeatHookRecipeBuilder.shapedRecipe(PIG_CARCASS.get())
				.tool(Ingredient.of(SKINNING_KNIFE.get()), 6, true,
						MeatHookLoottables.SKIN_PIG,
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig"), null, true,
								new AnimationFloatTransform()),
						new BlacklistedModel(SKINNING_KNIFE.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.tool(Ingredient.of(GUT_KNIFE.get()), 6, true,
						MeatHookLoottables.DISEMBOWEL_PIG,
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_skinned"), null,
								true, new AnimationFloatTransform()),
						new BlacklistedModel(GUT_KNIFE.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.tool(Ingredient.of(BONE_SAW.get()), 6, true,
						MeatHookLoottables.BISECT_PIG,
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_gutted"), null,
								true, new AnimationFloatTransform()),
						new BlacklistedModel(BONE_SAW.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.tool(Ingredient.of(BUTCHER_KNIFE.get()), 6, true,
						MeatHookLoottables.BUTCHER_PIG,
						new BlacklistedModel(new ResourceLocation(Butchercraft.MOD_ID, "meathook/pig_bisected"), null,
								true, new AnimationFloatTransform()),
						new BlacklistedModel(BUTCHER_KNIFE.get(),
								new AnimationFloatTransform()
										.setLocation(new AnimatedFloatVector3().setX(new AnimatedFloat(8, 0))
												.setY(new AnimatedFloat(24, 0)).setZ(new AnimatedFloat(12, 0)))))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pigtest"));

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

		ShapelessRecipeBuilder.shapeless(BEEF_BLOCK_ITEM.get())
				.requires(Ingredient.of(ButchercraftItemTags.ANY_BEEF_RAW), 9)
				.unlockedBy("has_beef", has(ButchercraftItemTags.ANY_BEEF_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_block"));
		ShapelessRecipeBuilder.shapeless(COOKED_BEEF_BLOCK_ITEM.get())
				.requires(Ingredient.of(ButchercraftItemTags.ANY_BEEF_COOKED), 9)
				.unlockedBy("has_beef_cooked", has(ButchercraftItemTags.ANY_BEEF_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_block"));
		ShapelessRecipeBuilder.shapeless(PORK_BLOCK_ITEM.get())
				.requires(Ingredient.of(ButchercraftItemTags.ANY_PORK_RAW), 9)
				.unlockedBy("has_pork", has(ButchercraftItemTags.ANY_PORK_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_block"));
		ShapelessRecipeBuilder.shapeless(COOKED_PORK_BLOCK_ITEM.get())
				.requires(Ingredient.of(ButchercraftItemTags.ANY_PORK_COOKED), 9)
				.unlockedBy("has_pork_cooked", has(ButchercraftItemTags.ANY_PORK_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_block"));
		ShapelessRecipeBuilder.shapeless(LAMB_BLOCK_ITEM.get())
				.requires(Ingredient.of(ButchercraftItemTags.ANY_LAMB_RAW), 9)
				.unlockedBy("has_lamb", has(ButchercraftItemTags.ANY_LAMB_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_block"));
		ShapelessRecipeBuilder.shapeless(COOKED_LAMB_BLOCK_ITEM.get())
				.requires(Ingredient.of(ButchercraftItemTags.ANY_LAMB_COOKED), 9)
				.unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.ANY_LAMB_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_lamb_block"));

		ShapelessRecipeBuilder.shapeless(BEEF_SCRAPS.get(), 9).requires(BEEF_BLOCK_ITEM.get())
				.unlockedBy("has_beef", has(ButchercraftItemTags.ANY_BEEF_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "beef_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(COOKED_BEEF_SCRAPS.get(), 9).requires(COOKED_BEEF_BLOCK_ITEM.get())
				.unlockedBy("has_beef_cooked", has(ButchercraftItemTags.ANY_BEEF_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_beef_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(PORK_SCRAPS.get(), 9).requires(PORK_BLOCK_ITEM.get())
				.unlockedBy("has_pork", has(ButchercraftItemTags.ANY_PORK_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "pork_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(COOKED_PORK_SCRAPS.get(), 9).requires(COOKED_PORK_BLOCK_ITEM.get())
				.unlockedBy("has_pork_cooked", has(ButchercraftItemTags.ANY_PORK_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_pork_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(LAMB_SCRAPS.get(), 9).requires(LAMB_BLOCK_ITEM.get())
				.unlockedBy("has_lamb", has(ButchercraftItemTags.ANY_LAMB_RAW))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "lamb_block_to_scraps"));
		ShapelessRecipeBuilder.shapeless(COOKED_LAMB_SCRAPS.get(), 9).requires(COOKED_LAMB_BLOCK_ITEM.get())
				.unlockedBy("has_lamb_cooked", has(ButchercraftItemTags.ANY_LAMB_COOKED))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cooked_lamb_block_to_scraps"));

		createFoodRecipe(Ingredient.of(BRAIN.get()), COOKED_BRAIN.get(), consumer);
		createFoodRecipe(Ingredient.of(HEART.get()), COOKED_HEART.get(), consumer);
		createFoodRecipe(Ingredient.of(KIDNEY.get()), COOKED_KIDNEY.get(), consumer);
		createFoodRecipe(Ingredient.of(LIVER.get()), COOKED_LIVER.get(), consumer);
		createFoodRecipe(Ingredient.of(LUNG.get()), COOKED_LUNG.get(), consumer);
		createFoodRecipe(Ingredient.of(STOMACHE.get()), COOKED_STOMACHE.get(), consumer);
		createFoodRecipe(Ingredient.of(TRIPE.get()), COOKED_TRIPE.get(), consumer);

		createFoodRecipe(Ingredient.of(BEEF_STEW_MEAT.get()), COOKED_BEEF_STEW_MEAT.get(), consumer);
		createFoodRecipe(Ingredient.of(SAUSAGE.get()), COOKED_SAUSAGE.get(), consumer);
		createFoodRecipe(Ingredient.of(BEEF_ROAST.get()), COOKED_BEEF_ROAST.get(), consumer);
		createFoodRecipe(Ingredient.of(BEEF_RIBS.get()), COOKED_BEEF_RIBS.get(), consumer);
		createFoodRecipe(Ingredient.of(CUBED_BEEF.get()), COOKED_CUBED_BEEF.get(), consumer);
		createFoodRecipe(Ingredient.of(GROUND_BEEF.get()), COOKED_GROUND_BEEF.get(), consumer);
		createFoodRecipe(Ingredient.of(BEEF_SCRAPS.get()), COOKED_BEEF_SCRAPS.get(), consumer);
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
