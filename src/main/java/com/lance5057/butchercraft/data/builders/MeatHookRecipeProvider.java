package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.items.ButchercraftItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.Consumer;

public class MeatHookRecipeProvider extends RecipeProvider {
    public MeatHookRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        new MeatHookRecipeBuilder(
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.LEATHER)).apply(SetItemCountFunction.setCount(UniformGenerator.between(8f, 12f))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.LEATHER_SCRAP.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(8 , 16)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.FAT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4 , 12)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.SINEW.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4 , 12))))).build(),
                Ingredient.of(ButchercraftItems.COW_CARCASS.get()),
                Ingredient.of(ButchercraftItems.BUTCHER_KNIFE.get()),
                0)
                .group("cow_butchering")
                .unlockedBy("has_cow_carcass", inventoryTrigger(ItemPredicate.Builder.item().of(ButchercraftItems.COW_CARCASS.get()).build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(Butchercraft.MOD_ID, "skin_cow_carcass"));
    }

    @Override
    public String getName() {
        return "Butchercraft Meat Hook recipes";
    }

}
