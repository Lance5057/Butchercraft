package com.lance5057.butchercraft.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class ButchercraftFluidTags {
	public static TagKey<Fluid> neoforgeFluidTag(String tag) {
		return FluidTags.create(ResourceLocation.fromNamespaceAndPath("c", tag));
	}

	public static final TagKey<Fluid> BLOOD = neoforgeFluidTag("blood");

}
