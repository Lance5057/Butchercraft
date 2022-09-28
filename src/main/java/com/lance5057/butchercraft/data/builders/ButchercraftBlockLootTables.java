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
        dropSelf(ButchercraftBlocks.PIG_SKULL.get());
        dropSelf(ButchercraftBlocks.SHEEP_SKULL.get());
        
        dropSelf(ButchercraftBlocks.BEEF_BLOCK.get());
        dropSelf(ButchercraftBlocks.COOKED_BEEF_BLOCK.get());
        dropSelf(ButchercraftBlocks.PORK_BLOCK.get());
        dropSelf(ButchercraftBlocks.COOKED_PORK_BLOCK.get());
        dropSelf(ButchercraftBlocks.LAMB_BLOCK.get());
        dropSelf(ButchercraftBlocks.COOKED_LAMB_BLOCK.get());
        
        dropSelf(ButchercraftBlocks.COW_HIDE_CARPET.get());
        dropSelf(ButchercraftBlocks.PIG_HIDE_CARPET.get());
        dropSelf(ButchercraftBlocks.SHEEP_HIDE_CARPET.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ButchercraftBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
    }
}
