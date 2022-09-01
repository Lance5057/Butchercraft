package com.lance5057.butchercraft.data.builders;

import com.google.gson.JsonObject;
import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ButcherKnifeRecipeBuilder implements RecipeBuilder {
    private final ItemStack result;
    private final EntityType<?> entityType;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
    private String group;

    public ButcherKnifeRecipeBuilder(ItemStack result, EntityType<?> entityType) {
        this.result = result;
        this.entityType = entityType;
    }

    public static ButcherKnifeRecipeBuilder butcheringRecipe(ItemStack result, EntityType<?> entityType) {
        return new ButcherKnifeRecipeBuilder(result, entityType);
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancementBuilder.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    /**
     * Makes sure that this recipe is valid and obtainable.
     */
    private void validate(ResourceLocation id) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.validate(pRecipeId);
        this.advancementBuilder.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId))
                .requirements(RequirementsStrategy.OR);
        pFinishedRecipeConsumer.accept(new Result(pRecipeId,
                result,
                entityType,
                this.group == null ? "" : this.group,
                this.advancementBuilder,
                new ResourceLocation(pRecipeId.getNamespace(), "recipes/butcher_knife/" + pRecipeId.getPath())));

    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation pRecipeId;
        private final ItemStack output;
        private final EntityType<?> entityType;
        private final String group;
        private final Advancement.Builder advancementBuilder;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pRecipeId, ItemStack result, EntityType<?> entityType, String group, Advancement.Builder advancementBuilder, ResourceLocation advancementId) {
            this.pRecipeId = pRecipeId;
            this.output = result;
            this.entityType = entityType;
            this.group = group;
            this.advancementBuilder = advancementBuilder;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            pJson.addProperty("group", this.group);
            final JsonObject result = new JsonObject();
            pJson.addProperty("entity", entityType.getRegistryName().toString());
            pJson.add("result", serializeItemstack(output));
        }

        @Override
        public ResourceLocation getId() {
            return pRecipeId;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ButchercraftRecipeSerializers.BUTCHER_KNIFE_SERIALIZER.get();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return advancementBuilder.serializeToJson();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }

    public static JsonObject serializeItemstack(ItemStack itemStack) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("item", Registry.ITEM.getKey(itemStack.getItem()).toString());
        if (itemStack.getCount() > 1) {
            jsonObject.addProperty("count", itemStack.getCount());
        }
        return jsonObject;
    }
}
