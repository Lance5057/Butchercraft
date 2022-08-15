package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.ButchercraftBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ItemTagGenerator extends BlockTagsProvider {
    public ItemTagGenerator(DataGenerator generator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ButchercraftBlocks.MEAT_HOOK.get());
    }
}
