package com.lance5057.butchercraft.data.builders;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.lance5057.butchercraft.Butchercraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;

public class ButcherBlockLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

	public static final ResourceLocation PLUCK_CHICKEN = new ResourceLocation(Butchercraft.MOD_ID, "butcherblock/pluck_chicken");
    public static final ResourceLocation DEOFFAL_CHICKEN = new ResourceLocation(Butchercraft.MOD_ID, "butcherblock/deoffal_chicken");
    
    public static final ResourceLocation BUTCHER_CHICKEN = new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/butcher_chicken");
    
	@Override
    public void accept(BiConsumer<ResourceLocation, Builder> t) {
		
	}
}
