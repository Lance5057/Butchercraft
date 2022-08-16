package com.lance5057.butchercraft.data.builders;

import com.google.gson.JsonObject;
import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.items.ButchercraftItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class MeatHookRecipeProvider extends ButchercraftRecipeProvider{
    public MeatHookRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void registerRecipes(Consumer<FinishedRecipe> recipes) {
        recipes.accept(new FinishedMeatHookRecipe(new ResourceLocation(Butchercraft.MOD_ID, "skin_cow_carcass"),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.LEATHER)).apply(SetItemCountFunction.setCount(UniformGenerator.between(8f, 12f))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.LEATHER_SCRAP.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(8 , 16)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.FAT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4 , 12)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.SINEW.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4 , 12))))).build(),
                Ingredient.of(ButchercraftItems.COW_CARCASS.get()),
                Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()),
                0));
    }

    @Override
    public String getName() {
        return "Butchercraft Meat Hook recipes";
    }

    public static class FinishedMeatHookRecipe implements FinishedRecipe {
        private final ResourceLocation id;
        private final LootTable output;
        private final Ingredient input;
        private final Ingredient tool;
        private final int stage;

        private FinishedMeatHookRecipe(ResourceLocation id, LootTable output, Ingredient input, Ingredient tool, int stage) {
            this.id = id;
            this.output = output;
            this.input = input;
            this.tool = tool;
            this.stage = stage;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            pJson.add("carcass", input.toJson());
            pJson.add("tool", tool.toJson());
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

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
