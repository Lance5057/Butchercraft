package com.lance5057.butchercraft.workstations.butcherblock;

import java.util.Collections;
import java.util.List;

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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ButcherBlockBlock extends Block implements EntityBlock, SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty DUMMY = BooleanProperty.create("dummy");

	public ButcherBlockBlock() {
		super(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3, 4).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(DUMMY, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED, DUMMY);
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
	protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos,
			CollisionContext context) {
		return !state.getValue(DUMMY) ? state.getShape(level, pos) : Shapes.empty();
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack heldMain, BlockState state, Level world, BlockPos blockPos,
			Player playerEntity, InteractionHand hand, BlockHitResult hitResult) {
		if (!state.getValue(DUMMY)) {
			BlockEntity entity = world.getBlockEntity(blockPos);
			if (entity instanceof ButcherBlockBlockEntity te) {
				if (playerEntity.isCrouching()) {
					if (te.stage == 0 && te.progress == 0) {
						te.extractItem(playerEntity);

						return ItemInteractionResult.SUCCESS;
					}
				} else if (te.isEmpty()) {
					if (isEmptyAbove(world, blockPos)) {
						te.insertItem(heldMain);
						return ItemInteractionResult.SUCCESS;
					} else {
						playerEntity.displayClientMessage(
								Component.translatable("butchercraft.block.butcherblock.no_space"), true);
						return ItemInteractionResult.CONSUME;
					}

				} else {
					if (heldMain.is(Items.PAPER)) {
						te.displayTools = !te.displayTools;
						return ItemInteractionResult.SUCCESS;
					} else
						return te.butcher(playerEntity, heldMain);
				}
			}
		} else {
			return world.getBlockState(blockPos.below()).useItemOn(heldMain, world, playerEntity, hand,
					hitResult.withPosition(blockPos.below()));
		}

		return ItemInteractionResult.CONSUME;

	}

	@Override
	protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock,
			BlockPos neighborPos, boolean movedByPiston) {
		super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
		if (!state.getValue(DUMMY)) {
			BlockEntity entity = level.getBlockEntity(pos);
			if (entity instanceof ButcherBlockBlockEntity te) {
				if (!te.isEmpty())
					placeAbove(level, state, pos);
			}
		} else {
			level.getBlockState(pos.above()).handleNeighborChanged(level, neighborPos, neighborBlock, pos.above(),
					movedByPiston);
		}
	}

	boolean isEmptyAbove(Level level, BlockPos pos) {
		if (!level.isEmptyBlock(pos.above()))
			return false;
		return true;
	}

	void placeAbove(Level level, BlockState state, BlockPos pos) {
		if (level.isEmptyBlock(pos.above()))
			level.setBlock(pos.above(), state.setValue(DUMMY, true), UPDATE_ALL);
	}

	void removeAbove(Level level, BlockPos pos) {
		if (level.getBlockState(pos.above()).getBlock() instanceof ButcherBlockBlock) {
			if (level.getBlockState(pos.above()).getValue(DUMMY)) {
				level.destroyBlock(pos.above(), false);
			}
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		if (!pState.getValue(DUMMY))
			return new ButcherBlockBlockEntity(pPos, pState);
		return null;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());

		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(WATERLOGGED,
				ifluidstate.getType() == Fluids.WATER);
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			if (!state.getValue(DUMMY)) {
				removeAbove(level, pos);
			}
			super.onRemove(state, level, pos, newState, isMoving);
		}
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
		if (state.getValue(DUMMY)) {
			return Collections.emptyList();
		}
		return super.getDrops(state, params);
	}
}
