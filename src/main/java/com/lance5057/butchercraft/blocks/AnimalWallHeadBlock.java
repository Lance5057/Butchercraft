package com.lance5057.butchercraft.blocks;

import com.lance5057.butchercraft.ButchercraftBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AnimalWallHeadBlock extends WallSkullBlock {

	public AnimalWallHeadBlock(SkullBlock.Type type, Properties props) {
		super(type, props);
	}

	@Override
	public BlockEntity newBlockEntity(final BlockPos blockPos, final BlockState blockState) {
		return new SkullBlockEntity(blockPos, blockState) {

			@Override
			public BlockEntityType<?> getType() {
				return ButchercraftBlockEntities.WALL_SKULL.get();
			}
		};
	}
}