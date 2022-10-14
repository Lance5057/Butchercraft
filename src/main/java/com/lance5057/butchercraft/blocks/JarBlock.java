package com.lance5057.butchercraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JarBlock extends HorizontalDirectionalBlock {
	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 11.0D, 12.0D);

	public JarBlock(Properties p_52591_) {
		super(p_52591_);
	}

	public VoxelShape getShape(BlockState p_152917_, BlockGetter p_152918_, BlockPos p_152919_, CollisionContext p_152920_) {
	      return SHAPE;
	   }

	public BlockState updateShape(BlockState p_152926_, Direction p_152927_, BlockState p_152928_,
			LevelAccessor p_152929_, BlockPos p_152930_, BlockPos p_152931_) {
		return !p_152926_.canSurvive(p_152929_, p_152930_) ? Blocks.AIR.defaultBlockState()
				: super.updateShape(p_152926_, p_152927_, p_152928_, p_152929_, p_152930_, p_152931_);
	}

	public boolean canSurvive(BlockState p_152922_, LevelReader p_152923_, BlockPos p_152924_) {
		return !p_152923_.isEmptyBlock(p_152924_.below());
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING);
	}

	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
	      return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
	   }
}