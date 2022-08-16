package com.lance5057.butchercraft.tags;

import com.lance5057.butchercraft.Butchercraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ButchercraftItemTags {
    public static final TagKey<Item> CARCASSES = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "carcasses"));
}
