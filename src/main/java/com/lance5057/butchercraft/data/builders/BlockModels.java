package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockModels extends BlockStateProvider {

	public BlockModels(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Butchercraft.MOD_ID, exFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerStatesAndModels() {
		// TODO Auto-generated method stub
		this.horizontalBlock(ButchercraftBlocks.MEAT_HOOK.get(),
				models().getExistingFile(modLoc("block/meat_hook")));
		
		this.simpleBlock(ButchercraftBlocks.BEEF_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_BEEF_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.PORK_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_PORK_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.LAMB_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_LAMB_BLOCK.get());
		
		this.horizontalBlock(ButchercraftBlocks.COW_HIDE_CARPET.get(), models().getExistingFile(modLoc("block/cow_hide_carpet")));
	}

}
