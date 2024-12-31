package com.lance5057.butchercraft.data.builders;

import java.util.concurrent.CompletableFuture;

import com.lance5057.butchercraft.ButchercraftItems;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

public class DataMapGen extends DataMapProvider {

	public DataMapGen(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(packOutput, lookupProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void gather() {
		Builder<Compostable, Item> compostables = this.builder(NeoForgeDataMaps.COMPOSTABLES);

		compostables.add(ButchercraftItems.HEART.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.COOKED_HEART.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.TRIPE.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.COOKED_TRIPE.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.STOMACH.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.COOKED_STOMACH.asItem().builtInRegistryHolder(), new Compostable(0.8f),
				false);
		compostables.add(ButchercraftItems.KIDNEY.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.COOKED_KIDNEY.asItem().builtInRegistryHolder(), new Compostable(0.8f),
				false);
		compostables.add(ButchercraftItems.LIVER.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.COOKED_LIVER.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.BRAIN.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.COOKED_BRAIN.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);

		compostables.add(ButchercraftItems.BEEF_SCRAPS.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.CHICKEN_SCRAPS.asItem().builtInRegistryHolder(), new Compostable(0.8f),
				false);
		compostables.add(ButchercraftItems.GOAT_SCRAPS.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.MUTTON_SCRAPS.asItem().builtInRegistryHolder(), new Compostable(0.8f),
				false);
		compostables.add(ButchercraftItems.PORK_SCRAPS.asItem().builtInRegistryHolder(), new Compostable(0.8f), false);
		compostables.add(ButchercraftItems.RABBIT_SCRAPS.asItem().builtInRegistryHolder(), new Compostable(0.8f),
				false);
	}
}