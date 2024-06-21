package com.lance5057.butchercraft.data.builders;

import java.util.Collections;
import java.util.List;

import com.lance5057.butchercraft.data.builders.recipes.loottables.ButcherBlockLootTables;
import com.lance5057.butchercraft.data.builders.recipes.loottables.MeatHookLoottables;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ButchercraftLootTableProvider extends LootTableProvider {
    public ButchercraftLootTableProvider(PackOutput pOutput) {
        super(pOutput, Collections.emptySet(),
                List.of(
                        new SubProviderEntry(MeatHookLoottables::new, LootContextParamSets.ALL_PARAMS),
                        new SubProviderEntry(ButcherBlockLootTables::new, LootContextParamSets.ALL_PARAMS),
                        new SubProviderEntry(ButcherKnifeLootTables::new, LootContextParamSets.ENTITY),
                        new SubProviderEntry(ButchercraftBlockLootTables::new, LootContextParamSets.BLOCK)
                )
        );
    }
}
