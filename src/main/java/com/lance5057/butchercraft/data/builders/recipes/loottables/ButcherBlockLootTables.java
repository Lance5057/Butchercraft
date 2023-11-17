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

	public static final ResourceLocation SKIN_BLACK_RABBIT = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/skin_black_rabbit");
	public static final ResourceLocation SKIN_BROWN_RABBIT = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/skin_brown_rabbit");
	public static final ResourceLocation SKIN_SPLOTCHED_RABBIT = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/skin_splotched_rabbit");
	public static final ResourceLocation SKIN_GOLD_RABBIT = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/skin_gold_rabbit");
	public static final ResourceLocation SKIN_SALT_RABBIT = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/skin_salt_rabbit");
	public static final ResourceLocation SKIN_WHITE_RABBIT = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/skin_white_rabbit");

	public static final ResourceLocation DEOFFAL_RABBIT = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/gut_rabbit");

	public static final ResourceLocation BUTCHER_RABBIT = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/butcher_rabbit");

	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> t) {
		t.accept(BLOOD_BOTTLE, LootTable.lootTable()
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
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_BREAST.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_LEG.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_THIGH.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_WING.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_SCRAPS.get(), 4, 8))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.BONE_MEAL, 2, 6)));

		t.accept(SKIN_BLACK_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BLACK_BUNNY_EARS.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BLACK_BUNNY_TAIL.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2)));

		t.accept(SKIN_BROWN_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BROWN_BUNNY_EARS.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BROWN_BUNNY_TAIL.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2)));

		t.accept(SKIN_SPLOTCHED_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SPLOTCHED_BUNNY_EARS.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SPLOTCHED_BUNNY_TAIL.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2)));

		t.accept(SKIN_GOLD_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.GOLD_BUNNY_EARS.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.GOLD_BUNNY_TAIL.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2)));

		t.accept(SKIN_SALT_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SALT_BUNNY_EARS.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SALT_BUNNY_TAIL.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2)));

		t.accept(SKIN_WHITE_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.WHITE_BUNNY_EARS.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.WHITE_BUNNY_TAIL.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2)));

		t.accept(DEOFFAL_RABBIT,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.HEART.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.KIDNEY.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LIVER.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.STOMACH.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LUNG.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.TRIPE.get(), 1))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 8))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.FAT.get(), 2, 6))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT, 1)));

		t.accept(BUTCHER_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_LEG.get(), 4))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SADDLE.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_THIGH.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SCRAPS.get(), 4, 8))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.BONE_MEAL, 2, 6)));
	}

}
