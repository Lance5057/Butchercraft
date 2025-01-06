package com.lance5057.butchercraft.workstations.hook;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MeatHookBlock extends Block implements EntityBlock, SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final IntegerProperty DUMMY = IntegerProperty.create("dummy", 0, 2);

	public MeatHookBlock() {
		super(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3, 4).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(DUMMY, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED, DUMMY);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return !state.getValue(WATERLOGGED);
	}

	@Override
	protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos,
			CollisionContext context) {
		return state.getValue(DUMMY) == 0 ? state.getShape(level, pos) : Shapes.empty();
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack heldMain, BlockState state, Level world, BlockPos blockPos,
			Player playerEntity, InteractionHand hand, BlockHitResult hitResult) {
		if (state.getValue(DUMMY) == 0) {
			BlockEntity entity = world.getBlockEntity(blockPos);
			if (entity instanceof MeatHookBlockEntity te) {
				if (playerEntity.isCrouching()) {
					if (te.stage == 0 && te.progress == 0) {
						te.extractItem(playerEntity);
						return ItemInteractionResult.SUCCESS;
					}
				} else if (te.isEmpty()) {
					if (isEmptyBelow(world, blockPos)) {
						te.insertItem(heldMain);
						return ItemInteractionResult.SUCCESS;
					} else {
						playerEntity.displayClientMessage(
								Component.translatable("butchercraft.block.meathook.no_space"), true);
						return ItemInteractionResult.CONSUME;
					}
				} else {
					if (heldMain.is(Items.PAPER))
					{
						te.displayTools = !te.displayTools;
						return ItemInteractionResult.SUCCESS;
					}
					else
						return te.butcher(playerEntity, heldMain);
				}
			}
		} else if (state.getValue(DUMMY) == 1) {
			BlockState state1 = world.getBlockState(blockPos.above());
			return state1.useItemOn(heldMain, world, playerEntity, hand, hitResult.withPosition(blockPos.above()));
		} else
			return world.getBlockState(blockPos.above(2)).useItemOn(heldMain, world, playerEntity, hand,
					hitResult.withPosition(blockPos.above(2)));

		return ItemInteractionResult.CONSUME;

	}

	@Override
	protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock,
			BlockPos neighborPos, boolean movedByPiston) {
		super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
		if (state.getValue(DUMMY) == 0) {
			BlockEntity entity = level.getBlockEntity(pos);
			if (entity instanceof MeatHookBlockEntity te) {
				if (!te.isEmpty())
					placeBelow(level, state, pos);
			}
		} else if (state.getValue(DUMMY) == 1) {
			level.getBlockState(pos.above()).handleNeighborChanged(level, pos.above(), neighborBlock, neighborPos,
					movedByPiston);
		} else {
			level.getBlockState(pos.above(2)).handleNeighborChanged(level, pos.above(2), neighborBlock, neighborPos,
					movedByPiston);
		}
	}

	boolean isEmptyBelow(Level level, BlockPos pos) {
		if (!level.isEmptyBlock(pos.below()))
			return false;
		if (!level.isEmptyBlock(pos.below(2)))
			return false;
		return true;
	}

	void placeBelow(Level level, BlockState state, BlockPos pos) {
		if (level.isEmptyBlock(pos.below()))
			level.setBlock(pos.below(), state.setValue(DUMMY, 1), UPDATE_ALL);
		if (level.isEmptyBlock(pos.below(2)))
			level.setBlock(pos.below(2), state.setValue(DUMMY, 2), UPDATE_ALL);
	}

	void removeBelow(Level level, BlockPos pos) {
		if (level.getBlockState(pos.below()).getBlock() instanceof MeatHookBlock)
			level.destroyBlock(pos.below(), false);
		if (level.getBlockState(pos.below(2)).getBlock() instanceof MeatHookBlock)
			level.destroyBlock(pos.below(2), false);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		if (pState.getValue(DUMMY) == 0)
			return new MeatHookBlockEntity(pPos, pState);
		return null;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());

		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getValue(DUMMY) == 0) {
			if (state.getBlock() != newState.getBlock()) {

				removeBelow(level, pos);

			}
		}
//		else if (state.getValue(DUMMY) == 1) {
//
//			this.removeBelow(level, pos.above());
//		} else {
//			this.removeBelow(level, pos.above());
//		}

		super.onRemove(state, level, pos, newState, isMoving);
	}
}
