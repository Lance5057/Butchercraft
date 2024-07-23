package com.lance5057.butchercraft.data.builders.recipes.loottables;

import java.util.function.BiConsumer;

import org.jetbrains.annotations.NotNull;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class MeatHookLoottables implements LootTableSubProvider {

	public static final ResourceKey<LootTable> SKIN_COW = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "meat_hook/skin_cow"));
	public static final ResourceKey<LootTable> DISEMBOWEL_COW = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/deoffal_cow"));
	public static final ResourceKey<LootTable> BISECT_COW = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "meat_hook/delimb_cow"));
	public static final ResourceKey<LootTable> BUTCHER_COW = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/butcher_cow"));

	public static final ResourceKey<LootTable> SKIN_PIG = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "meat_hook/skin_pig"));
	public static final ResourceKey<LootTable> DISEMBOWEL_PIG = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/disembowel_pig"));
	public static final ResourceKey<LootTable> BISECT_PIG = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "meat_hook/bisect_pig"));
	public static final ResourceKey<LootTable> BUTCHER_PIG = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/butcher_pig"));

	public static final ResourceKey<LootTable> SKIN_SHEEP = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "meat_hook/skin_sheep"));
	public static final ResourceKey<LootTable> DISEMBOWEL_SHEEP = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/disembowel_sheep"));
	public static final ResourceKey<LootTable> BISECT_SHEEP = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/bisect_sheep"));
	public static final ResourceKey<LootTable> BUTCHER_SHEEP = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/butcher_sheep"));

	public static final ResourceKey<LootTable> SKIN_GOAT = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "meat_hook/skin_goat"));
	public static final ResourceKey<LootTable> DISEMBOWEL_GOAT = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/disembowel_goat"));
	public static final ResourceKey<LootTable> BISECT_GOAT = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/bisect_goat"));
	public static final ResourceKey<LootTable> BUTCHER_GOAT = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/butcher_goat"));

	public static final ResourceKey<LootTable> BLOOD_BUCKET = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/blood_bucket"));

	public static final ResourceKey<LootTable> SCRAPE_HIDE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/scrape_hide"));
	public static final ResourceKey<LootTable> COW_LEATHER = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/cow_leather"));
	public static final ResourceKey<LootTable> GOAT_LEATHER = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/goat_leather"));
	public static final ResourceKey<LootTable> PIG_LEATHER = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/pig_leather"));
	public static final ResourceKey<LootTable> SHEEP_LEATHER = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
			"meat_hook/sheep_leather"));

	private final HolderLookup.Provider provider;

    public MeatHookLoottables(HolderLookup.Provider provider) {
		this.provider = provider;
    }

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, Builder> t) {
		t.accept(BLOOD_BUCKET,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.BLOOD_FLUID_BUCKET.get(), 1)));

		t.accept(SCRAPE_HIDE,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 1, 4, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.FAT.get(), 0, 2, 0, 1, provider)));

		t.accept(COW_LEATHER,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 4))
						.withPool(createPoolWithItem(Items.LEATHER, 12, 12, 0, 1, provider)));
		t.accept(GOAT_LEATHER,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 4))
						.withPool(createPoolWithItem(Items.LEATHER, 8, 8, 0, 1, provider)));
		t.accept(PIG_LEATHER,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 4))
						.withPool(createPoolWithItem(Items.LEATHER, 8, 8, 0, 1, provider)));
		t.accept(SHEEP_LEATHER,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 1, 4))
						.withPool(createPoolWithItem(Items.LEATHER, 6, 6, 0, 1, provider)));

		t.accept(SKIN_COW,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.COW_HIDE.get(), 1))
						.withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 8, 16, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.FAT.get(), 4, 12, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 12, 0, 1, provider)));
		t.accept(DISEMBOWEL_COW,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.HEART.get()))
						.withPool(createPoolWithItem(ButchercraftItems.KIDNEY.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.LIVER.get()))
						.withPool(createPoolWithItem(ButchercraftItems.STOMACH.get(), 4))
						.withPool(createPoolWithItem(ButchercraftItems.LUNG.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.TRIPE.get(), 8)));
		t.accept(BISECT_COW,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.COW_HEAD_ITEM.get()))
						.withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 0, 4, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.BEEF_SCRAPS.get(), 0, 8, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.BEEF_STEW_MEAT.get(), 24, 0, 1, provider))
						.withPool(createPoolWithItem(Items.BONE, 4, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.OXTAIL.get(), 1, 3, 0, 1, provider)));
		t.accept(BUTCHER_COW,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.BEEF_SCRAPS.get(), 29))
						.withPool(createPoolWithItem(ButchercraftItems.BEEF_RIBS.get(), 6, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.BEEF_ROAST.get(), 21, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.CUBED_BEEF.get(), 9, 9, 0, 1, provider))
						.withPool(createPoolWithItem(Items.BEEF, 40, 81, 0, 1, provider))
						.withPool(createPoolWithItem(Items.BONE, 4, 12, 0, 1, provider)));

		t.accept(SKIN_PIG,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.PIG_HIDE.get(), 1))
						.withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 4, 8, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.FAT.get(), 4, 12, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 12, 0, 1, provider)));
		t.accept(DISEMBOWEL_PIG,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.HEART.get()))
						.withPool(createPoolWithItem(ButchercraftItems.KIDNEY.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.LIVER.get()))
						.withPool(createPoolWithItem(ButchercraftItems.STOMACH.get()))
						.withPool(createPoolWithItem(ButchercraftItems.LUNG.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.TRIPE.get(), 8))
						.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 12)));
		t.accept(BISECT_PIG, LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.PIG_HEAD_ITEM.get()))
//                        .withPool(createPoolWithItem(ButchercraftItems.PIG_HOOVES.get(), 4))
				.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 0, 8, 0, 1, provider))
				.withPool(createPoolWithItem(ButchercraftItems.PORK_SCRAPS.get(), 2, 4, 0, 1, provider))
				.withPool(createPoolWithItem(ButchercraftItems.PORK_STEW_MEAT.get(), 5, 10, 0, 1, provider))
				.withPool(createPoolWithItem(Items.BONE, 4)));
		t.accept(BUTCHER_PIG,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.PORK_SCRAPS.get(), 10))
						.withPool(createPoolWithItem(ButchercraftItems.PORK_RIBS.get(), 6, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.PORK_ROAST.get(), 10, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.CUBED_PORK.get(), 4, 0, 1, provider))
						.withPool(createPoolWithItem(Items.PORKCHOP, 14)).withPool(createPoolWithItem(Items.BONE, 12)));

		t.accept(SKIN_SHEEP,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.SHEEP_HIDE.get(), 1))
						.withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 4, 8, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.FAT.get(), 4, 12, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 12, 0, 1, provider)));
		t.accept(DISEMBOWEL_SHEEP,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.HEART.get()))
						.withPool(createPoolWithItem(ButchercraftItems.KIDNEY.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.LIVER.get()))
						.withPool(createPoolWithItem(ButchercraftItems.STOMACH.get()))
						.withPool(createPoolWithItem(ButchercraftItems.LUNG.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.TRIPE.get(), 4))
						.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 8)));
		t.accept(BISECT_SHEEP,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.SHEEP_HEAD_ITEM.get()))
						.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 0, 6))
						.withPool(createPoolWithItem(ButchercraftItems.MUTTON_SCRAPS.get(), 4, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.MUTTON_STEW_MEAT.get(), 6, 0, 1, provider))
						.withPool(createPoolWithItem(Items.BONE, 4, 0, 1, provider)));
		t.accept(BUTCHER_SHEEP,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.MUTTON_SCRAPS.get(), 5, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.MUTTON_RIBS.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.MUTTON_ROAST.get(), 7))
						.withPool(createPoolWithItem(ButchercraftItems.CUBED_MUTTON.get(), 2, 0, 1, provider))
						.withPool(createPoolWithItem(Items.MUTTON, 10, 0, 1, provider))
						.withPool(createPoolWithItem(Items.BONE, 9, 0, 1, provider)));

		t.accept(SKIN_GOAT,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.GOAT_HIDE.get(), 1))
						.withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get(), 4, 8, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.FAT.get(), 4, 12, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 12, 0, 1, provider)));
		t.accept(DISEMBOWEL_GOAT,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.HEART.get()))
						.withPool(createPoolWithItem(ButchercraftItems.KIDNEY.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.LIVER.get()))
						.withPool(createPoolWithItem(ButchercraftItems.STOMACH.get()))
						.withPool(createPoolWithItem(ButchercraftItems.LUNG.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.TRIPE.get(), 4))
						.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 4, 8)));
		t.accept(BISECT_GOAT,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.GOAT_HEAD_ITEM.get()))
						.withPool(createPoolWithItem(ButchercraftItems.SINEW.get(), 0, 6, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.GOAT_SCRAPS.get(), 4, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.GOAT_STEW_MEAT.get(), 6, 0, 1, provider))
						.withPool(createPoolWithItem(Items.BONE, 4, 0, 1, provider)));
		t.accept(BUTCHER_GOAT,
				LootTable.lootTable().withPool(createPoolWithItem(ButchercraftItems.GOAT_SCRAPS.get(), 5, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.GOAT_RIBS.get(), 2))
						.withPool(createPoolWithItem(ButchercraftItems.GOAT_ROAST.get(), 7))
						.withPool(createPoolWithItem(ButchercraftItems.CUBED_GOAT.get(), 2, 0, 1, provider))
						.withPool(createPoolWithItem(ButchercraftItems.GOAT_CHOP.get(), 10, 0, 1, provider))
						.withPool(createPoolWithItem(Items.BONE, 9, 0, 1, provider)));
	}

	@NotNull
	public static LootPool.Builder createPoolWithItem(Item item, int count) {
		return LootPool.lootPool().add(LootItem.lootTableItem(item))
				.apply(SetItemCountFunction.setCount(ConstantValue.exactly(count)));
	}

	@NotNull
	public static LootPool.Builder createPoolWithItem(Item item, int min, int max) {
		return LootPool.lootPool().add(LootItem.lootTableItem(item))
				.apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)));
	}

	@NotNull
	public static LootPool.Builder createPoolWithItem(Item item) {
		return LootPool.lootPool().add(LootItem.lootTableItem(item));
	}

	@NotNull
	public static LootPool.Builder createPoolWithItem(Item item, int count, float lootMin, float lootMax, HolderLookup.Provider provider) {
		return LootPool.lootPool().add(LootItem.lootTableItem(item))
				.apply(SetItemCountFunction.setCount(ConstantValue.exactly(count)))
				.apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0.0F, 1.0F)));
	}

	@NotNull
	public static LootPool.Builder createPoolWithItem(Item item, int min, int max, float lootMin, float lootMax, HolderLookup.Provider provider) {
		return LootPool.lootPool().add(LootItem.lootTableItem(item))
				.apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
				.apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0.0F, 1.0F)));
	}

}