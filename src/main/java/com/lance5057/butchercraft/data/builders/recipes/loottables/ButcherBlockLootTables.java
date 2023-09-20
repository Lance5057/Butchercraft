package com.lance5057.butchercraft.data.builders.recipes.loottables;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;

public class ButcherBlockLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

	public static final ResourceLocation PLUCK_CHICKEN = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/pluck_chicken");
	public static final ResourceLocation DEOFFAL_CHICKEN = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/deoffal_chicken");

	public static final ResourceLocation BUTCHER_CHICKEN = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/butcher_chicken");
	
	public static final ResourceLocation BLOOD_BOTTLE = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/blood_bottle");

	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> t) {
		t.accept(BLOOD_BOTTLE,
                LootTable.lootTable()
                        .withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BLOOD_FLUID_BOTTLE.get(), 1)));
		
		t.accept(PLUCK_CHICKEN,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(Items.FEATHER, 1, 5)));
		t.accept(DEOFFAL_CHICKEN,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.HEART.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.KIDNEY.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LIVER.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.STOMACH.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LUNG.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.TRIPE.get(), 1))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 8))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.FAT.get(), 2, 6))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.CHICKEN, 1)));

		t.accept(BUTCHER_CHICKEN,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_BREAST.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_LEG.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_THIGH.get(),2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_WING.get(),2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_SCRAPS.get(), 4, 8))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.BONE_MEAL, 2, 6)));
	}

}
