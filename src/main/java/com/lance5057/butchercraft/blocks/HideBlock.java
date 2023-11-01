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

public class HideBlock extends HorizontalDirectionalBlock {
	protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	//public static final IntegerProperty LIFT = IntegerProperty.create("lift", 0, 2);

	public HideBlock(Properties p_52591_) {
		super(p_52591_);
	}

	public VoxelShape getShape(BlockState p_152917_, BlockGetter p_152918_, BlockPos p_152919_,
			CollisionContext p_152920_) {
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
		BlockPos b = pContext.getClickedPos();
		boolean e = b.getX() % 2  == 0 && b.getZ() % 2 == 0;
		boolean o = b.getX() % 4 != 0 || b.getZ() % 4 != 0;

		int i = 0;
		if (e)
			i = 1;
		if (o)
			i = 2;

		return this.defaultBlockState().setValue(FACING,
				pContext.getHorizontalDirection().getOpposite());
	}
}
