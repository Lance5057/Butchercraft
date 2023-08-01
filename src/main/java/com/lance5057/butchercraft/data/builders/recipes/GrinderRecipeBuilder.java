package com.lance5057.butchercraft.data.builders.recipes;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.workstations.grinder.GrinderRecipeSerializer;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class GrinderRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final Ingredient ingredient;
	private final Ingredient attachment;
	private final int count;
	private final int grinds;
	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
	private final GrinderRecipeSerializer serializer;

	private GrinderRecipeBuilder(ItemLike pResult, Ingredient pIngredient, Ingredient attachment, int pGrind, int count,
			GrinderRecipeSerializer serializer) {
		this.result = pResult.asItem();
		this.ingredient = pIngredient;
		this.attachment = attachment;
		this.count = count;
		this.grinds = pGrind;
		this.serializer = serializer;
	}

	public static GrinderRecipeBuilder grind(Ingredient pIngredient, Ingredient attachment, ItemLike pResult,
			int grinds, int count) {
		return new GrinderRecipeBuilder(pResult, pIngredient, attachment, grinds, count,
				ButchercraftRecipeSerializers.GRINDER_SERIALIZER.get());
	}

	public GrinderRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
		return this;
	}

	public GrinderRecipeBuilder group(@Nullable String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	public Item getResult() {
		return this.result;
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
		save(pFinishedRecipeConsumer, Butchercraft.MOD_ID + ":mortar/" + location.getPath());
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		this.ensureValid(pRecipeId);
		this.advancement.parent(new ResourceLocation("recipes/root"))
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
				.rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);

		ResourceLocation r = new ResourceLocation(pRecipeId.getNamespace(),
				"recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath());

		pFinishedRecipeConsumer.accept(
				new GrinderRecipeBuilder.Result(pRecipeId, this.group == null ? "" : this.group, this.ingredient,
						attachment, this.result, this.grinds, this.count, this.advancement, r, this.serializer));
	}

	/**
	 * Makes sure that this obtainable.
	 */
	private void ensureValid(ResourceLocation pId) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + pId);
		}
	}

	public static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final String group;
		private final Ingredient ingredient;
		private final Ingredient attachment;
		private final Item result;
		private final int count;
		private final int grinds;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;
		private final GrinderRecipeSerializer serializer;

		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, Ingredient attachment, Item pResult,
				int pGrinds, int pCount, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId,
				GrinderRecipeSerializer pSerializer) {
			this.id = pId;
			this.group = pGroup;
			this.ingredient = pIngredient;
			this.attachment = attachment;
			this.result = pResult;
			this.count = pCount;
			this.grinds = pGrinds;
			this.advancement = pAdvancement;
			this.advancementId = pAdvancementId;
			this.serializer = pSerializer;
		}

		public void serializeRecipeData(JsonObject pJson) {
			if (!this.group.isEmpty()) {
				pJson.addProperty("group", this.group);
			}

			pJson.add("ingredient", this.ingredient.toJson());

			pJson.add("attachment", this.attachment.toJson());

			JsonObject objectResult = new JsonObject();
			objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
			if (count > 1) {
				objectResult.addProperty("count", count);
			}
			pJson.add("result", objectResult);

			pJson.addProperty("grinds", this.grinds);
		}

		public RecipeSerializer<?> getType() {
			return this.serializer;
		}

		/**
		 * Gets the ID for the recipe.
		 */
		public ResourceLocation getId() {
			return this.id;
		}

		/**
		 * Gets the JSON for the advancement that unlocks this recipe. Null if there is
		 * no advancement.
		 */
		@Nullable
		public JsonObject serializeAdvancement() {
			return this.advancement.serializeToJson();
		}

		/**
		 * Gets the ID for the advancement associated with this recipe. Should not be
		 * null if {@link #getAdvancementJson} is non-null.
		 */
		@Nullable
		public ResourceLocation getAdvancementId() {
			return this.advancementId;
		}
	}
}