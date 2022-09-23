package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.ButchercraftBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ButchercraftBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        dropSelf(ButchercraftBlocks.MEAT_HOOK.get());
        dropSelf(ButchercraftBlocks.COW_SKULL.get());
        
        dropSelf(ButchercraftBlocks.BEEF_BLOCK.get());
        dropSelf(ButchercraftBlocks.COOKED_BEEF_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ButchercraftBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
    }
}
