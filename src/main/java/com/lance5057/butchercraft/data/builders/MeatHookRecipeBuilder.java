package com.lance5057.butchercraft.data.builders;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.workstations.recipes.AnimatedRecipeItemUse;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class MeatHookRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final int count;
	private final List<String> pattern = Lists.newArrayList();
	private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
	private final List<AnimatedRecipeItemUse> tools = NonNullList.create();
	private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
	private String group;

	public MeatHookRecipeBuilder(Item resultIn, int countIn) {
		this.result = resultIn;
		this.count = countIn;
	}

	public static MeatHookRecipeBuilder shapedRecipe(Item resultIn) {
		return new MeatHookRecipeBuilder(resultIn, 1);
	}

	public MeatHookRecipeBuilder tool(Ingredient tool, int count, int uses, boolean damage, ResourceLocation table,
			BlacklistedModel... model) {
		this.tools.add(new AnimatedRecipeItemUse(uses, tool, count, damage, table, model));
		return this;
	}

	public MeatHookRecipeBuilder tool(Ingredient tool, int uses, boolean damage, ResourceLocation table,
			BlacklistedModel... model) {
		this.tools.add(new AnimatedRecipeItemUse(uses, tool, 1, damage, table, model));
		return this;
	}

	/**
	 * Adds a criterion needed to unlock the recipe.
	 */
	public MeatHookRecipeBuilder addCriterion(String name, CriterionTriggerInstance criterionIn) {
		this.advancementBuilder.addCriterion(name, criterionIn);
		return this;
	}

	public MeatHookRecipeBuilder setGroup(String groupIn) {
		this.group = groupIn;
		return this;
	}

//	/**
//	 * Builds this recipe into an {@link FinishedRecipe}.
//	 */
//	public void build(Consumer<FinishedRecipe> consumerIn) {
//		this.build(consumerIn, this.result.);
//	}
//
//	/**
//	 * Builds this recipe into an {@link FinishedRecipe}. Use
//	 * {@link #build(Consumer)} if save is the same as the ID for the result.
//	 */
//	public void build(Consumer<FinishedRecipe> consumerIn, String save) {
//		ResourceLocation resourcelocation = Registry.ITEM.getKey(this.result);
//		if ((new ResourceLocation(save)).equals(resourcelocation)) {
//			throw new IllegalStateException("Shaped Recipe " + save + " should remove its 'save' argument");
//		} else {
//			this.build(consumerIn, new ResourceLocation(Reference.MOD_ID, save));
//		}
//	}

//	/**
//	 * Builds this recipe into an {@link FinishedRecipe}.
//	 */
//	public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
//		this.validate(id);
//		this.advancementBuilder.parent(new ResourceLocation("recipes/root"))
//				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
//				.rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
//		consumerIn.accept(new CraftingAnvilRecipeProvider.AnvilResult(id, this.result, this.count, this.schematic,
//				this.group == null ? "" : this.group, this.pattern, this.key, this.tools, this.advancementBuilder,
//				new ResourceLocation(id.getNamespace(),
//						"recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + id.getPath())));
//	}

	/**
	 * Makes sure that this recipe is valid and obtainable.
	 */
	private void validate(ResourceLocation id) {
		if (this.tools.isEmpty()) {
			throw new IllegalStateException("No toolset is defined for shaped recipe " + id + "!");
		}
	}

	@Override
	public RecipeBuilder unlockedBy(String p_176496_, CriterionTriggerInstance p_176497_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeBuilder group(String p_176495_) {
		this.group = p_176495_;
		return this;
	}

	@Override
	public Item getResult() {
		return this.result;
	}

	@Override
	public void save(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
		this.validate(id);
		this.advancementBuilder.parent(new ResourceLocation("recipes/root"))
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
				.rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
		consumerIn.accept(new MeatHookRecipeProvider.Result(id, this.result, this.group == null ? "" : this.group,
				this.pattern, this.key, this.tools, this.advancementBuilder, new ResourceLocation(id.getNamespace(),
						"recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + id.getPath())));
	}
}
