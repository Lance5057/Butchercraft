package com.lance5057.butchercraft.workstations.grinder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;

public class GrinderBlock extends Block implements EntityBlock, SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	protected static final VoxelShape SHAPEW = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 9.0D, 12.0D);
	protected static final VoxelShape SHAPEN = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 9.0D, 16.0D);

	public GrinderBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3, 4).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	public VoxelShape getShape(BlockState p_152917_, BlockGetter p_152918_, BlockPos p_152919_,
			CollisionContext p_152920_) {
		switch (p_152917_.getValue(FACING)) {

		case NORTH:
		case SOUTH:
			return SHAPEN;
		case WEST:
		case UP:
		case DOWN:
		case EAST:
		default:
			return SHAPEW;

		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return !state.getValue(WATERLOGGED);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Nonnull
	@Override
	public InteractionResult use(@Nonnull BlockState blockState, Level world, @Nonnull BlockPos blockPos,
			@Nonnull Player playerEntity, @Nonnull InteractionHand hand, @Nonnull BlockHitResult blockRayTraceResult) {
		BlockEntity blockentity = world.getBlockEntity(blockPos);
		if (blockentity instanceof GrinderBlockEntity be) {

			if (playerEntity.isCrouching()) {
				be.extractItem(playerEntity);
				return InteractionResult.SUCCESS;
			} else {

				ItemStack itemstack = playerEntity.getItemInHand(hand);
				if (!itemstack.isEmpty()) {
					playerEntity.setItemInHand(hand, be.insertItem(itemstack));
					return InteractionResult.SUCCESS;
				} else {
					return be.grind(playerEntity, blockState);
				}
			}
		}

		return InteractionResult.PASS;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new GrinderBlockEntity(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());

		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getCounterClockWise())
				.setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
	}

}
