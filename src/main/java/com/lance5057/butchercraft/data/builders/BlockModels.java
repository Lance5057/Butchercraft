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
		this.horizontalBlock(ButchercraftBlocks.MEAT_HOOK.get(), models().getExistingFile(modLoc("block/meat_hook")));

		this.simpleBlock(ButchercraftBlocks.BUTCHER_BLOCK.get(),
				models().getExistingFile(modLoc("block/butcherblock")));
		this.horizontalBlock(ButchercraftBlocks.GRINDER.get(), models().getExistingFile(modLoc("block/grinder")));

		this.simpleBlock(ButchercraftBlocks.BEEF_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_BEEF_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.PORK_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_PORK_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.LAMB_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_LAMB_BLOCK.get());

		this.horizontalBlock(ButchercraftBlocks.COW_HIDE_CARPET.get(),
				models().getExistingFile(modLoc("block/cow_hide_carpet")));
		this.horizontalBlock(ButchercraftBlocks.PIG_HIDE_CARPET.get(),
				models().getExistingFile(modLoc("block/pig_hide_carpet")));
		this.horizontalBlock(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(),
				models().getExistingFile(modLoc("block/sheep_hide_carpet")));
		
		this.horizontalBlock(ButchercraftBlocks.COW_BLOCK.get(),
				models().getExistingFile(modLoc("block/cow")));
		this.horizontalBlock(ButchercraftBlocks.PIG_BLOCK.get(),
				models().getExistingFile(modLoc("block/pig")));
		this.horizontalBlock(ButchercraftBlocks.SHEEP_BLOCK.get(),
				models().getExistingFile(modLoc("block/sheep")));
		this.horizontalBlock(ButchercraftBlocks.GOAT_BLOCK.get(),
				models().getExistingFile(modLoc("block/goat")));
		this.horizontalBlock(ButchercraftBlocks.CHICKEN_BLOCK.get(),
				models().getExistingFile(modLoc("block/chicken")));
		this.horizontalBlock(ButchercraftBlocks.RABBIT_BLOCK.get(),
				models().getExistingFile(modLoc("block/rabbit")));

	}
}
