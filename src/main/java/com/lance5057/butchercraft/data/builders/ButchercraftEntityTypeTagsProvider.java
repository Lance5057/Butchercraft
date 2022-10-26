package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.tags.ButchercraftEntityTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ButchercraftEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public ButchercraftEntityTypeTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Butchercraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ButchercraftEntityTags.CARCASSES).add(EntityType.COW, EntityType.SHEEP, EntityType.PIG);
    }

}
