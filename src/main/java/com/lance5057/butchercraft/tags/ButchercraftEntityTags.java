package com.lance5057.butchercraft.tags;

import com.lance5057.butchercraft.Butchercraft;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ButchercraftEntityTags {
    public static final TagKey<EntityType<?>> CARCASSES = create("butcher_knife_animals");

    private static TagKey<EntityType<?>> create(String pName) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(Butchercraft.MOD_ID, pName));
    }
}
