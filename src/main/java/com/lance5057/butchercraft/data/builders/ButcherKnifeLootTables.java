package com.lance5057.butchercraft.data.builders;

import java.util.function.BiConsumer;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;

import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.ForgeRegistries;

public class ButcherKnifeLootTables implements LootTableSubProvider {

	@Override
	public void generate(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
		createButcherKnifeLootTable(consumer, EntityType.COW, new LootTable.Builder()
				.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.COW_CARCASS.get()))));
		createButcherKnifeLootTable(consumer, EntityType.SHEEP, new LootTable.Builder()
				.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.SHEEP_CARCASS.get()))));
		createButcherKnifeLootTable(consumer, EntityType.PIG, new LootTable.Builder()
				.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.PIG_CARCASS.get()))));
		createButcherKnifeLootTable(consumer, EntityType.CHICKEN, new LootTable.Builder()
				.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.CHICKEN_CARCASS.get()))));
		createButcherKnifeLootTable(consumer, EntityType.GOAT, new LootTable.Builder()
				.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.GOAT_CARCASS.get()))));

		createRabbitButcherKnifeLootTable(consumer, EntityType.RABBIT,
				new LootTable.Builder().withPool(
						LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.GOLD_RABBIT_CARCASS.get()))),
				"_gold");
		createRabbitButcherKnifeLootTable(consumer, EntityType.RABBIT,
				new LootTable.Builder().withPool(
						LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.BLACK_RABBIT_CARCASS.get()))),
				"_black");
		createRabbitButcherKnifeLootTable(consumer, EntityType.RABBIT,
				new LootTable.Builder().withPool(
						LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.BROWN_RABBIT_CARCASS.get()))),
				"_brown");
		createRabbitButcherKnifeLootTable(consumer, EntityType.RABBIT,
				new LootTable.Builder().withPool(
						LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.SALT_RABBIT_CARCASS.get()))),
				"_salt");
		createRabbitButcherKnifeLootTable(consumer, EntityType.RABBIT, new LootTable.Builder().withPool(
				LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.get()))),
				"_splotched");
		createRabbitButcherKnifeLootTable(consumer, EntityType.RABBIT,
				new LootTable.Builder().withPool(
						LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.WHITE_RABBIT_CARCASS.get()))),
				"_white");

	}

	public static void createButcherKnifeLootTable(BiConsumer<ResourceLocation, LootTable.Builder> consumer,
			EntityType<?> entityType, LootTable.Builder lootTable) {
		consumer.accept(new ResourceLocation(Butchercraft.MOD_ID,
				"butcher_knife/" + ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath()), lootTable);
	}

	public static void createRabbitButcherKnifeLootTable(BiConsumer<ResourceLocation, LootTable.Builder> consumer,
			EntityType<?> entityType, LootTable.Builder lootTable, String type) {
		consumer.accept(
				new ResourceLocation(Butchercraft.MOD_ID,
						"butcher_knife/" + ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath() + type),
				lootTable);
	}
}
