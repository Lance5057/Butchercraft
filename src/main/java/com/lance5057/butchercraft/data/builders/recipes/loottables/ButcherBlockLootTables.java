package com.lance5057.butchercraft.data.builders.recipes.loottables;

import static com.lance5057.butchercraft.ButchercraftItems.FAT;
import static com.lance5057.butchercraft.ButchercraftItems.HEART;
import static com.lance5057.butchercraft.ButchercraftItems.KIDNEY;
import static com.lance5057.butchercraft.ButchercraftItems.LIVER;
import static com.lance5057.butchercraft.ButchercraftItems.LUNG;
import static com.lance5057.butchercraft.ButchercraftItems.SINEW;
import static com.lance5057.butchercraft.ButchercraftItems.STOMACHE;
import static com.lance5057.butchercraft.ButchercraftItems.TRIPE;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.lance5057.butchercraft.Butchercraft;

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
			"meat_hook/butcher_chicken");

	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> t) {
		t.accept(PLUCK_CHICKEN,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(Items.FEATHER, 1, 5)));
		t.accept(DEOFFAL_CHICKEN,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(HEART.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(KIDNEY.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(LIVER.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(STOMACHE.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(LUNG.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(TRIPE.get(), 1))
						.withPool(MeatHookLoottables.createPoolWithItem(SINEW.get(), 4, 8))
						.withPool(MeatHookLoottables.createPoolWithItem(FAT.get(), 2, 6))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.CHICKEN, 1)));
	}
}
