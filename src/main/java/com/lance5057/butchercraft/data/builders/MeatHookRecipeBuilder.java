package com.lance5057.butchercraft.data.builders;

import com.google.gson.JsonObject;
import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
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
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;

import java.util.function.Consumer;

public class MeatHookRecipeBuilder implements RecipeBuilder {
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private String group;
    private final LootTable output;
    private final Ingredient input;
    private final Ingredient tool;
    private final int stage;

    public MeatHookRecipeBuilder(LootTable output, Ingredient input, Ingredient tool, int stage) {
        this.output = output;
        this.input = input;
        this.tool = tool;
        this.stage = stage;
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return null;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.ensureValid(pRecipeId);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
        pFinishedRecipeConsumer.accept(new FinishedMeatHookRecipe(pRecipeId, output, group, input, tool, stage, advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/meat_hook/%s".formatted(pRecipeId.getPath()))));

    }

    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    public static class FinishedMeatHookRecipe implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final LootTable output;
        private final Ingredient input;
        private final Ingredient tool;
        private final int stage;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public FinishedMeatHookRecipe(ResourceLocation pRecipeId, LootTable output, String group, Ingredient input, Ingredient tool, int stage, Advancement.Builder advancement, ResourceLocation advancementId)  {
            id = pRecipeId;
            this.output = output;
            this.group = group;
            this.input = input;
            this.tool = tool;
            this.stage = stage;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }


        @Override
        public void serializeRecipeData(JsonObject pJson) {
            pJson.add("carcass", input.toJson());
            pJson.add("tool", tool.toJson());
            pJson.addProperty("group", group);
            pJson.addProperty("stage", stage);
            pJson.add("output", LootTables.serialize(output));
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ButchercraftRecipeSerializers.HOOK_SERIALIZER.get();
        }

        @Override
        public JsonObject serializeAdvancement() {
            return advancement.serializeToJson();
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return advancementId;
        }
    }
}
