package com.lance5057.butchercraft.data.builders;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
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
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MeatHookRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final List<String> pattern = Lists.newArrayList();
    private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
    private final List<AnimatedRecipeItemUse> tools = NonNullList.create();
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
    private String group;

    public MeatHookRecipeBuilder(Item carcassIn) {
        this.result = carcassIn;
    }

    public static MeatHookRecipeBuilder shapedRecipe(Item resultIn) {
        return new MeatHookRecipeBuilder(resultIn);
    }

    public MeatHookRecipeBuilder tool(Ingredient tool,
                                      int count,
                                      int uses,
                                      boolean damage,
                                      ResourceLocation table,
                                      BlacklistedModel... model) {
        this.tools.add(new AnimatedRecipeItemUse(uses, tool, count, damage, table, model));
        return this;
    }

    public MeatHookRecipeBuilder tool(Ingredient tool,
                                      int uses,
                                      boolean damage,
                                      ResourceLocation table,
                                      BlacklistedModel... model) {
        this.tools.add(new AnimatedRecipeItemUse(uses, tool, 1, damage, table, model));
        return this;
    }

    /**
     * Makes sure that this recipe is valid and obtainable.
     */
    private void validate(ResourceLocation id) {
//        if (this.advancementBuilder.getCriteria().isEmpty()) {
//            throw new IllegalStateException("No way of obtaining recipe " + id);
//        }
        if (this.tools.isEmpty()) {
            throw new IllegalStateException("No toolset is defined for shaped recipe %s!".formatted(id));
        }
    }

    /**
     * Adds a criterion needed to unlock the recipe.
     */
    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancementBuilder.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumerIn, ResourceLocation pRecipeId) {
        this.validate(pRecipeId);
        this.advancementBuilder.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId))
                .requirements(RequirementsStrategy.OR);
        consumerIn.accept(new Result(pRecipeId,
                Ingredient.of(this.result),
                this.group == null ? "" : this.group,
                this.tools,
                this.advancementBuilder,
                new ResourceLocation(pRecipeId.getNamespace(), "recipes/meat_hook/" + pRecipeId.getPath())));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient carcass;
        private final String group;
        private final List<AnimatedRecipeItemUse> tools;
        private final Advancement.Builder advancementBuilder;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation idIn,
                      Ingredient carcassIn,
                      String groupIn,
                      List<AnimatedRecipeItemUse> toolsIn,
                      Advancement.Builder advancementBuilderIn,
                      ResourceLocation advancementIdIn) {
            this.id = idIn;
            // TODO Possibly restrict to items only
            this.carcass = carcassIn;
            this.group = groupIn;
            this.advancementBuilder = advancementBuilderIn;
            this.advancementId = advancementIdIn;
            this.tools = toolsIn;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            json.addProperty("group", this.group);
            JsonArray stepArray = new JsonArray();
            this.tools.stream().map(AnimatedRecipeItemUse::addProperty).forEach(stepArray::add);
            json.add("tools", stepArray);
            json.add("carcass", carcass.toJson());
        }

        public RecipeSerializer<?> getType() {
            return ButchercraftRecipeSerializers.HOOK_SERIALIZER.get();
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
        @Override
        public JsonObject serializeAdvancement() {
            return this.advancementBuilder.serializeToJson();
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
