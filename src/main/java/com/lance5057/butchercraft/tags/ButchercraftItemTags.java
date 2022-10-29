package com.lance5057.butchercraft.tags;

import com.lance5057.butchercraft.Butchercraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ButchercraftItemTags {
    public static final TagKey<Item> CARCASSES = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "carcasses"));
    
    public static final TagKey<Item> ANY_MEAT_RAW = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_meat_raw"));
    public static final TagKey<Item> ANY_MEAT_COOKED = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_meat_cooked"));
    
    public static final TagKey<Item> ANY_BEEF_RAW = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_beef_raw"));
    public static final TagKey<Item> ANY_PORK_RAW = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_pork_raw"));
    public static final TagKey<Item> ANY_LAMB_RAW = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_lamb_raw"));
    
    public static final TagKey<Item> ANY_BEEF_COOKED = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_beef_cooked"));
    public static final TagKey<Item> ANY_PORK_COOKED = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_pork_cooked"));
    public static final TagKey<Item> ANY_LAMB_COOKED = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_lamb_cooked"));
    
    public static final TagKey<Item> ANY_GROUND_MEAT_RAW = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_ground_meat_raw"));
    
    public static final TagKey<Item> ANY_SCRAP_MEAT_RAW = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_scrap_meat_raw"));
    public static final TagKey<Item> ANY_ROAST_RAW = ItemTags.create(new ResourceLocation(Butchercraft.MOD_ID, "any_roast_raw"));
}
