package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.ButchercraftBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ButchercraftBlocks.MEAT_HOOK.get());
        
        tag(BlockTags.MINEABLE_WITH_AXE).add(ButchercraftBlocks.BEEF_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ButchercraftBlocks.COOKED_BEEF_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ButchercraftBlocks.PORK_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ButchercraftBlocks.COOKED_PORK_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ButchercraftBlocks.LAMB_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ButchercraftBlocks.COOKED_LAMB_BLOCK.get());
        
        
    }
}
