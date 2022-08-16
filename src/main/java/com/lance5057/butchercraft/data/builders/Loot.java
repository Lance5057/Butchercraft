package com.lance5057.butchercraft.data.builders;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;
import com.lance5057.butchercraft.workstations.loottables.MeatHookLoottables;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class Loot extends LootTableProvider {

	public Loot(DataGenerator pGenerator) {
		super(pGenerator);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Nonnull
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
		return ImmutableList.of(Pair.of(MeatHookLoottables::new, LootContextParamSets.ALL_PARAMS));
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext validationtracker) {
		map.forEach((name, table) -> LootTables.validate(validationtracker, name, table));
	}
}
