package com.lance5057.butchercraft.data.builders.recipes;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.workstations.grinder.GrinderRecipe;
import com.lance5057.butchercraft.workstations.grinder.GrinderRecipeSerializer;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class GrinderRecipeBuilder implements RecipeBuilder {
	private final RecipeCategory category;
	private final Item result;
	private final Ingredient ingredient;
	private final int ingredientCount;
	private final Ingredient attachment;
	private final int resultCount;
	private final int grinds;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
	@Nullable
	private String group;
	private final GrinderRecipeSerializer serializer;

	private GrinderRecipeBuilder(RecipeCategory pCategory, ItemLike pResult, Ingredient pIngredient, Ingredient attachment, int pGrind, int count,
			GrinderRecipeSerializer serializer, int ingredientCount) {
		this.category = pCategory;
		this.result = pResult.asItem();
		this.ingredient = pIngredient;
		this.ingredientCount = ingredientCount;
		this.attachment = attachment;
		this.resultCount = count;
		this.grinds = pGrind;
		this.serializer = serializer;
		this.unlockedBy(RecipeBuilderUtil.getHasName(pIngredient.getItems()[0].getItem()), RecipeBuilderUtil.has(pIngredient.getItems()[0].getItem()));
	}

	public static GrinderRecipeBuilder grind(Ingredient pIngredient, RecipeCategory pCategory, int ingredientCount, Ingredient attachment,
			ItemLike pResult, int grinds, int resultCount) {
		return new GrinderRecipeBuilder(pCategory, pResult, pIngredient, attachment, grinds, resultCount,
				ButchercraftRecipeSerializers.GRINDER_SERIALIZER.get(), ingredientCount);
	}

	@Override
	public RecipeBuilder unlockedBy(String pCriterionName, Criterion<?> pCriterionTrigger) {
		this.criteria.put(pCriterionName, pCriterionTrigger);
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
	public void save(RecipeOutput pFinishedRecipeConsumer) {
		ResourceLocation location = BuiltInRegistries.ITEM.getKey(result);
		save(pFinishedRecipeConsumer, Butchercraft.MOD_ID + ":mortar/" + location.getPath());
	}

	@Override
	public void save(RecipeOutput pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		this.validate(pRecipeId);
		Advancement.Builder builder = pFinishedRecipeConsumer.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
				.rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(builder::addCriterion);

		ResourceLocation r = ResourceLocation.fromNamespaceAndPath(pRecipeId.getNamespace(),
				"recipes/" + this.category.getFolderName() + "/" + pRecipeId.getPath());

		pFinishedRecipeConsumer.accept(
				pRecipeId,
				new GrinderRecipe(this.group == null ? "" : this.group, this.ingredient,
						this.ingredientCount, this.attachment, new ItemStack(this.result, this.resultCount), this.grinds),
				builder.build(r)
		);
	}

	/**
	 * Makes sure that this obtainable.
	 */
	private void validate(ResourceLocation pId) {
		if (this.criteria.isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + pId);
		}
	}
}