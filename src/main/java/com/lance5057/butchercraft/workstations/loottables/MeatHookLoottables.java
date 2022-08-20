package com.lance5057.butchercraft.workstations.loottables;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.items.ButchercraftItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class MeatHookLoottables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

	public static ResourceLocation allplanks = new ResourceLocation("recipes/sawhorse/planks");

	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> t) {
		// TODO Auto-generated method stub
		t.accept(new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/cow"),
				LootTable.lootTable()
						.withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.LEATHER))
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(8f, 12f))))
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(ButchercraftItems.LEATHER_SCRAP.get())
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(8, 16)))))
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(ButchercraftItems.FAT.get())
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12)))))
						.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.SINEW.get())
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12))))));

//		t.accept(new ResourceLocation(Butchercraft.MOD_ID, "recipes/sawhorse/oak_log"),
//				LootTable.lootTable()
//						.withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(4, 6))
//								.add(LootItem.lootTableItem(Items.STICK).setWeight(1)))
//						.withPool(LootPool.lootPool().name("extra").setRolls(UniformGenerator.between(1, 4))
//								.add(LootItem.lootTableItem(CompendiumItems.SAWDUST.get()).setWeight(1))));
	}
}