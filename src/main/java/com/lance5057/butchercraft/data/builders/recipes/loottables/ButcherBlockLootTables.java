package com.lance5057.butchercraft.data.builders.recipes.loottables;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

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

	public static final ResourceLocation BLOOD_SAUSAGE_LINKED = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/blood_sausage_linked");
	public static final ResourceLocation SAUSAGE_LINKED = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/sausage_linked");

	public static final ResourceLocation BEEF_ROAST = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/beef_roast");
	public static final ResourceLocation BEEF_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/beef_cubes");
	public static final ResourceLocation BEEF_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/beef_stew");
	public static final ResourceLocation COOKED_BEEF_ROAST = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_beef_roast");
	public static final ResourceLocation COOKED_BEEF_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_beef_cubes");
	public static final ResourceLocation COOKED_BEEF_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_beef_stew");

	public static final ResourceLocation PORK_ROAST = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/pork_roast");
	public static final ResourceLocation PORK_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/pork_cubes");
	public static final ResourceLocation PORK_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/pork_stew");
	public static final ResourceLocation COOKED_PORK_ROAST = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_pork_roast");
	public static final ResourceLocation COOKED_PORK_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_pork_cubes");
	public static final ResourceLocation COOKED_PORK_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_pork_stew");

	public static final ResourceLocation MUTTON_ROAST = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/mutton_roast");
	public static final ResourceLocation MUTTON_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/mutton_cubes");
	public static final ResourceLocation MUTTON_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/mutton_stew");
	public static final ResourceLocation COOKED_MUTTON_ROAST = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_mutton_roast");
	public static final ResourceLocation COOKED_MUTTON_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_mutton_cubes");
	public static final ResourceLocation COOKED_MUTTON_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_mutton_stew");

	public static final ResourceLocation GOAT_ROAST = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/goat_roast");
	public static final ResourceLocation GOAT_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/goat_cubes");
	public static final ResourceLocation GOAT_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/goat_stew");
	public static final ResourceLocation COOKED_GOAT_ROAST = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_goat_roast");
	public static final ResourceLocation COOKED_GOAT_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_goat_cubes");
	public static final ResourceLocation COOKED_GOAT_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_goat_stew");

	public static final ResourceLocation CHICKEN_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/chicken_cubes");
	public static final ResourceLocation CHICKEN_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/chicken_stew");
	public static final ResourceLocation COOKED_CHICKEN_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_chicken_cubes");
	public static final ResourceLocation COOKED_CHICKEN_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_chicken_stew");

	public static final ResourceLocation RABBIT_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/rabbit_cubes");
	public static final ResourceLocation RABBIT_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/rabbit_stew");
	public static final ResourceLocation COOKED_RABBIT_CUBES = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_rabbit_cubes");
	public static final ResourceLocation COOKED_RABBIT_STEW = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/cooked_rabbit_stew");

	public static final ResourceLocation COW_HEAD = new ResourceLocation(Butchercraft.MOD_ID, "butcherblock/cow_head");
	public static final ResourceLocation SHEEP_HEAD = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/sheep_head");
	public static final ResourceLocation PIG_HEAD = new ResourceLocation(Butchercraft.MOD_ID, "butcherblock/pig_head");
	public static final ResourceLocation GOAT_HEAD = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/goat_head");
	public static final ResourceLocation CHICKEN_HEAD = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/chicken_head");
	public static final ResourceLocation BLACK_RABBIT_HEAD = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/black_rabbit_head");
	public static final ResourceLocation BROWN_RABBIT_HEAD = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/brown_rabbit_head");
	public static final ResourceLocation SPLOTCHED_RABBIT_HEAD = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/splotched_rabbit_head");
	public static final ResourceLocation GOLD_RABBIT_HEAD = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/gold_rabbit_head");
	public static final ResourceLocation SALT_RABBIT_HEAD = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/salt_rabbit_head");
	public static final ResourceLocation WHITE_RABBIT_HEAD = new ResourceLocation(Butchercraft.MOD_ID,
			"butcherblock/white_rabbit_head");

	public static final ResourceLocation CASING = new ResourceLocation(Butchercraft.MOD_ID, "butcherblock/casing");
	public static final ResourceLocation EMPTY = new ResourceLocation(Butchercraft.MOD_ID, "empty");

	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> t) {
		t.accept(EMPTY, LootTable.lootTable());

		t.accept(CASING,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CASING.get(), 1))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.FAT.get(), 0, 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SINEW.get(), 0, 2))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.BUCKET, 1)));

		t.accept(BLOOD_BOTTLE, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BLOOD_FLUID_BOTTLE.get(), 1)));

		t.accept(PLUCK_CHICKEN,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(Items.FEATHER, 1, 5, 0, 1)));
		t.accept(DEOFFAL_CHICKEN,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.HEART.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_HEAD_ITEM.get(), 1))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.KIDNEY.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LIVER.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.STOMACH.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LUNG.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.TRIPE.get(), 1))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 8, 0, 1))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.FAT.get(), 2, 6, 0, 1))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.CHICKEN, 1)));

		t.accept(BUTCHER_CHICKEN, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_BREAST.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_LEG.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_THIGH.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_WING.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_SCRAPS.get(), 4, 8, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(Items.BONE_MEAL, 2, 6, 0, 1)));

		t.accept(SKIN_BLACK_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_BLACK_HEAD_ITEM.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2, 0, 1)));

		t.accept(SKIN_BROWN_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_BROWN_HEAD_ITEM.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2, 0, 1)));

		t.accept(SKIN_SPLOTCHED_RABBIT, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SPLOTCHED_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
				.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2, 0, 1)));

		t.accept(SKIN_GOLD_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_GOLD_HEAD_ITEM.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2, 0, 1)));

		t.accept(SKIN_SALT_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SALT_HEAD_ITEM.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2, 0, 1)));

		t.accept(SKIN_WHITE_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_WHITE_HEAD_ITEM.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_HIDE))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT_FOOT, 1, 2, 0, 1)));

		t.accept(DEOFFAL_RABBIT,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.HEART.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.KIDNEY.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LIVER.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.STOMACH.get()))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LUNG.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.TRIPE.get(), 1))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 8, 0, 1))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.FAT.get(), 2, 6, 0, 1))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.RABBIT, 1)));

		t.accept(BUTCHER_RABBIT,
				LootTable.lootTable()
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_LEG.get(), 4))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SADDLE.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_THIGH.get(), 2))
						.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SCRAPS.get(), 4, 8))
						.withPool(MeatHookLoottables.createPoolWithItem(Items.BONE_MEAL, 2, 6, 0, 1)));

		t.accept(BLOOD_SAUSAGE_LINKED, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BLOOD_SAUSAGE.get(), 8)));
		t.accept(SAUSAGE_LINKED, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SAUSAGE.get(), 8)));

		t.accept(BEEF_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CUBED_BEEF.get(), 2)));
		t.accept(COOKED_BEEF_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_CUBED_BEEF.get(), 2)));
		t.accept(BEEF_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BEEF_STEW_MEAT.get(), 2)));
		t.accept(COOKED_BEEF_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_BEEF_STEW_MEAT.get(), 2)));
		t.accept(BEEF_ROAST, LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(Items.BEEF, 4)));
		t.accept(COOKED_BEEF_ROAST,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(Items.COOKED_BEEF, 4)));

		t.accept(PORK_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CUBED_PORK.get(), 2)));
		t.accept(COOKED_PORK_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_CUBED_PORK.get(), 2)));
		t.accept(PORK_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.PORK_STEW_MEAT.get(), 2)));
		t.accept(COOKED_PORK_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_PORK_STEW_MEAT.get(), 2)));
		t.accept(PORK_ROAST, LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(Items.PORKCHOP, 4)));
		t.accept(COOKED_PORK_ROAST,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(Items.COOKED_PORKCHOP, 4)));

		t.accept(MUTTON_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CUBED_MUTTON.get(), 2)));
		t.accept(COOKED_MUTTON_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_CUBED_MUTTON.get(), 2)));
		t.accept(MUTTON_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.MUTTON_STEW_MEAT.get(), 2)));
		t.accept(COOKED_MUTTON_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get(), 2)));
		t.accept(MUTTON_ROAST, LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(Items.MUTTON, 4)));
		t.accept(COOKED_MUTTON_ROAST,
				LootTable.lootTable().withPool(MeatHookLoottables.createPoolWithItem(Items.COOKED_MUTTON, 4)));

		t.accept(GOAT_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CUBED_GOAT.get(), 2)));
		t.accept(COOKED_GOAT_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_CUBED_GOAT.get(), 2)));
		t.accept(GOAT_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.GOAT_STEW_MEAT.get(), 2)));
		t.accept(COOKED_GOAT_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_GOAT_STEW_MEAT.get(), 2)));
		t.accept(GOAT_ROAST, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.GOAT_CHOP.get(), 4)));
		t.accept(COOKED_GOAT_ROAST, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_GOAT_CHOP.get(), 4)));

		t.accept(CHICKEN_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CUBED_CHICKEN.get(), 2)));
		t.accept(COOKED_CHICKEN_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_CUBED_CHICKEN.get(), 2)));
		t.accept(CHICKEN_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.STEW_CHICKEN.get(), 2)));
		t.accept(COOKED_CHICKEN_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_STEW_CHICKEN.get(), 2)));

		t.accept(RABBIT_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CUBED_RABBIT.get(), 2)));
		t.accept(COOKED_RABBIT_CUBES, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_CUBED_RABBIT.get(), 2)));
		t.accept(RABBIT_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.STEW_RABBIT.get(), 2)));
		t.accept(COOKED_RABBIT_STEW, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COOKED_STEW_RABBIT.get(), 2)));

		t.accept(BLACK_RABBIT_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BLACK_BUNNY_EARS.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BLACK_BUNNY_TAIL.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SCRAPS.get(), 2, 4, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 3, 0, 1)));

		t.accept(BROWN_RABBIT_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BROWN_BUNNY_EARS.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BROWN_BUNNY_TAIL.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SCRAPS.get(), 2, 4, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 3, 0, 1)));

		t.accept(SPLOTCHED_RABBIT_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SPLOTCHED_BUNNY_EARS.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SPLOTCHED_BUNNY_TAIL.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SCRAPS.get(), 2, 4, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 3, 0, 1)));

		t.accept(GOLD_RABBIT_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.GOLD_BUNNY_EARS.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.GOLD_BUNNY_TAIL.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SCRAPS.get(), 2, 4, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 3, 0, 1)));

		t.accept(SALT_RABBIT_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SALT_BUNNY_EARS.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SALT_BUNNY_TAIL.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SCRAPS.get(), 2, 4, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 3, 0, 1)));

		t.accept(WHITE_RABBIT_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.WHITE_BUNNY_EARS.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.WHITE_BUNNY_TAIL.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.RABBIT_SCRAPS.get(), 2, 4, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 3, 0, 1)));

		t.accept(CHICKEN_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.WATTLE.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BEAK.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.CHICKEN_SCRAPS.get(), 2, 4, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 2, 0, 1)));

		t.accept(COW_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.HORN.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.TONGUE.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.COW_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BEEF_SCRAPS.get(), 4, 8, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 2, 4, 0, 1)));

		t.accept(PIG_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.TONGUE.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.PIG_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.PORK_SCRAPS.get(), 4, 8, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 2, 4, 0, 1)));

		t.accept(SHEEP_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.TONGUE.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.SHEEP_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.MUTTON_SCRAPS.get(), 4, 8, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 2, 4, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(Items.STRING, 1, 3)));

		t.accept(GOAT_HEAD, LootTable.lootTable()
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.TONGUE.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.EYEBALL.get(), 2))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.BRAIN.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.GOAT_SKULL_HEAD_ITEM.get()))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.GOAT_SCRAPS.get(), 4, 8, 0, 1))
				.withPool(MeatHookLoottables.createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 2, 4, 0, 1)));
	}

}
