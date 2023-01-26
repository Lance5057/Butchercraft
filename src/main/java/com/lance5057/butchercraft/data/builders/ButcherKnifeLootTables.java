package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ButcherKnifeLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        createButcherKnifeLootTable(consumer, EntityType.COW, new LootTable.Builder().withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.COW_CARCASS.get()))));
        createButcherKnifeLootTable(consumer, EntityType.SHEEP, new LootTable.Builder().withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.SHEEP_CARCASS.get()))));
        createButcherKnifeLootTable(consumer, EntityType.PIG, new LootTable.Builder().withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.PIG_CARCASS.get()))));
    }

    public static void createButcherKnifeLootTable(BiConsumer<ResourceLocation, LootTable.Builder> consumer, EntityType<?> entityType, LootTable.Builder lootTable) {
        consumer.accept(new ResourceLocation(Butchercraft.MOD_ID, "butcher_knife/" + ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath()), lootTable);
    }

}
