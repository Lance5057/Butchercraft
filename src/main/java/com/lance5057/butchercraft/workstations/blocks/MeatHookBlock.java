package com.lance5057.butchercraft.workstations.blocks;

import javax.annotation.Nonnull;

import com.lance5057.butchercraft.items.CarcassItem;
import com.lance5057.butchercraft.workstations.blockentities.MeatHookBlockEntity;

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
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class MeatHookBlock extends Block implements EntityBlock, SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public MeatHookBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).strength(3, 4).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
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

	@Nonnull
	@Override
	public InteractionResult use(@Nonnull BlockState blockState, Level world, @Nonnull BlockPos blockPos,
			@Nonnull Player playerEntity, @Nonnull InteractionHand hand, @Nonnull BlockHitResult blockRayTraceResult) {
		if (world.isClientSide)
			return InteractionResult.SUCCESS; // on client side, don't do anything

		BlockEntity entity = world.getBlockEntity(blockPos);
		if (entity instanceof MeatHookBlockEntity te) {

			// Get item in both InteractionHands
			ItemStack heldMain = playerEntity.getItemInHand(InteractionHand.MAIN_HAND);

			if (heldMain.getItem() instanceof CarcassItem)
				te.insertItem(heldMain);
			else if (heldMain != ItemStack.EMPTY)
				te.useTool(heldMain, playerEntity);
		}

		return InteractionResult.SUCCESS;

	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		// TODO Auto-generated method stub
		return new MeatHookBlockEntity(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());

		return this.defaultBlockState()
				.setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
	}
}
