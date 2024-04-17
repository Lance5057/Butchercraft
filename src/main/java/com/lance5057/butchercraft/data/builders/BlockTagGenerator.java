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

	}
}
