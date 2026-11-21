package com.lance5057.butchercraft.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CompatTags {
    public static TagKey<Item> neoforgeItemTag(String tag) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", tag));
    }

    public static final TagKey<Item> FOODS_COOKED_BEEF = neoforgeItemTag("foods/cooked_beef");
    public static final TagKey<Item> FOODS_RAW_BEEF = neoforgeItemTag("foods/raw_beef");
    public static final TagKey<Item> FOODS_COOKED_CHICKEN = neoforgeItemTag("foods/cooked_chicken");
    public static final TagKey<Item> FOODS_RAW_CHICKEN = neoforgeItemTag("foods/raw_chicken");
    public static final TagKey<Item> FOODS_COOKED_MUTTON = neoforgeItemTag("foods/cooked_mutton");
    public static final TagKey<Item> FOODS_RAW_MUTTON = neoforgeItemTag("foods/raw_mutton");
    public static final TagKey<Item> FOODS_COOKED_PORK = neoforgeItemTag("foods/cooked_pork");
    public static final TagKey<Item> FOODS_RAW_PORK = neoforgeItemTag("foods/raw_pork");
}
