package com.lance5057.butchercraft.entity;

import java.util.HashSet;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftBlocks;
import com.lance5057.butchercraft.ButchercraftItems;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ButchercraftVillagers {
	public static DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE,
			Butchercraft.MOD_ID);
	public static DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister
			.create(Registries.VILLAGER_PROFESSION, Butchercraft.MOD_ID);

	public static final DeferredHolder<PoiType, PoiType> SLAUGHTER_POI = POI_TYPES.register("slaughter_poi", () -> {
		HashSet<BlockState> s = new HashSet<BlockState>();
		s.addAll(ButchercraftBlocks.MEAT_HOOK.get().getStateDefinition().getPossibleStates());
		s.addAll(ButchercraftBlocks.MEAT_HOOK.get().getStateDefinition().getPossibleStates());
		return new PoiType(s, 1, 1);
	});

	public static final DeferredHolder<VillagerProfession, VillagerProfession> SLAUGHTER_PROFESSION = PROFESSIONS.register(
			"slaughter_profession",
			() -> new VillagerProfession("slaugther",
					holder -> holder.value().equals(ButchercraftVillagers.SLAUGHTER_POI.get()),
					holder -> holder.value().equals(ButchercraftVillagers.SLAUGHTER_POI.get()), ImmutableSet.of(),
					ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));

	public static void register(IEventBus modEventBus) {
		POI_TYPES.register(modEventBus);
		PROFESSIONS.register(modEventBus);
	}

	public static void fillTradeData() {
		VillagerTrades.ItemListing[] slaughterLevel1 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.EmeraldForItems(ButchercraftItems.MASK.get(), 1, 8, 5),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.GLOVES.get(), 1, 8, 5),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.BOOTS.get(), 1, 8, 5),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.APRON.get(), 1, 8, 5),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.BEAK.get(), 1, 4, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.EYEBALL.get(), 1, 2, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.FAT.get(), 1, 1, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.HORN.get(), 1, 4, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.WATTLE.get(), 1, 2, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.SOAP.get(), 6, 1, 8, 3) };

		VillagerTrades.ItemListing[] slaughterLevel2 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.EmeraldForItems(ButchercraftItems.MASK.get(), 1, 8, 5),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.GLOVES.get(), 1, 8, 5),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.BOOTS.get(), 1, 8, 5),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.APRON.get(), 1, 8, 5),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.BEAK.get(), 1, 4, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.EYEBALL.get(), 1, 2, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.FAT.get(), 1, 1, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.HORN.get(), 1, 4, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.WATTLE.get(), 1, 2, 16, 1),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.SOAP.get(), 6, 1, 8, 3) };

		VillagerTrades.ItemListing[] slaughterLevel3 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.EmeraldForItems(ButchercraftItems.BUTCHER_KNIFE.get(), 1, 16, 15),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.GUT_KNIFE.get(), 1, 16, 15),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.SKINNING_KNIFE.get(), 1, 16, 15),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.BONE_SAW.get(), 1, 16, 15),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.APRON.get(), 12, 1, 16, 10),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.MASK.get(), 12, 1, 16, 10),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.GLOVES.get(), 12, 1, 16, 10),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.BOOTS.get(), 12, 1, 16, 10) };

		VillagerTrades.ItemListing[] slaughterLevel4 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.EmeraldForItems(ButchercraftItems.CHICKEN_CARCASS.get(), 8, 8, 5),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.COW_CARCASS.get(), 24, 4, 15),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.GOAT_CARCASS.get(), 16, 4, 10),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.SHEEP_CARCASS.get(), 16, 4, 10),
				new VillagerTrades.EmeraldForItems(ButchercraftItems.PIG_CARCASS.get(), 16, 4, 10),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.BUTCHER_KNIFE.get(), 24, 1, 16, 10),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.GUT_KNIFE.get(), 24, 1, 16, 10),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.SKINNING_KNIFE.get(), 24, 1, 16, 10),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.BONE_SAW.get(), 24, 1, 16, 10) };

		VillagerTrades.ItemListing[] slaughterLevel5 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.CHICKEN_CARCASS.get(), 8, 1, 8, 5),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.COW_CARCASS.get(), 24, 1, 4, 15),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.GOAT_CARCASS.get(), 16, 1, 4, 10),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.SHEEP_CARCASS.get(), 16, 1, 4, 10),
				new VillagerTrades.ItemsForEmeralds(ButchercraftItems.PIG_CARCASS.get(), 16, 1, 4, 10) };

		VillagerTrades.TRADES.put(SLAUGHTER_PROFESSION.get(), toIntMap(ImmutableMap.of(1, slaughterLevel1, 2,
				slaughterLevel2, 3, slaughterLevel3, 4, slaughterLevel4, 5, slaughterLevel5)));
	}

	private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(
			ImmutableMap<Integer, VillagerTrades.ItemListing[]> p_221238_0_) {
		return new Int2ObjectOpenHashMap<>(p_221238_0_);
	}
}
