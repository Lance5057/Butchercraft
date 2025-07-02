package com.lance5057.butchercraft.tags;

import com.lance5057.butchercraft.Butchercraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ButchercraftBlockTags {

	public static final TagKey<Block> VILLAGER_JOB_SITES = neoforgeBlockTag("villager_job_sites");

	public static TagKey<Block> neoforgeBlockTag(String tag) {
		return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", tag));
	}

	public static TagKey<Block> butcherTag(String tag) {
		return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, tag));
	}

}
