package com.lance5057.butchercraft.data.builders;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockTagGenerator extends BlockTagsProvider {
	public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Butchercraft.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ButchercraftBlocks.MEAT_HOOK.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ButchercraftBlocks.GRINDER.get());

		tag(BlockTags.MINEABLE_WITH_AXE).add(ButchercraftBlocks.BUTCHER_BLOCK.get());

		tag(BlockTags.MINEABLE_WITH_AXE).add(ButchercraftBlocks.BEEF_BLOCK.get())
				.add(ButchercraftBlocks.COOKED_BEEF_BLOCK.get()).add(ButchercraftBlocks.PORK_BLOCK.get())
				.add(ButchercraftBlocks.COOKED_PORK_BLOCK.get()).add(ButchercraftBlocks.MUTTON_BLOCK.get())
				.add(ButchercraftBlocks.COOKED_MUTTON_BLOCK.get())

				.add(ButchercraftBlocks.BARN_WOOD_BLOCK.get()).add(ButchercraftBlocks.BARN_WOOD_DOOR.get())
				.add(ButchercraftBlocks.BARN_WOOD_FENCE.get()).add(ButchercraftBlocks.BARN_WOOD_FENCE_GATE.get())
				.add(ButchercraftBlocks.BARN_WOOD_SLAB.get()).add(ButchercraftBlocks.BARN_WOOD_STAIRS.get())
				.add(ButchercraftBlocks.BARN_WOOD_TRAPDOOR.get()).add(ButchercraftBlocks.TRIMMED_BARN_WOOD_BLOCK.get());

		tag(BlockTags.FENCES).add(ButchercraftBlocks.BARN_WOOD_FENCE.get());
		tag(BlockTags.FENCE_GATES).add(ButchercraftBlocks.BARN_WOOD_FENCE_GATE.get());
		tag(BlockTags.WOODEN_FENCES).add(ButchercraftBlocks.BARN_WOOD_FENCE.get());
	}
}
