package com.lance5057.butchercraft.workstations.blocks;

import javax.annotation.Nonnull;

import com.lance5057.butchercraft.items.CarcassItem;
import com.lance5057.butchercraft.workstations.blockentities.DryingRackBlockEntity;
import com.lance5057.butchercraft.workstations.blockentities.MeatHookBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class DryingRackBlock extends Block implements EntityBlock {

	public DryingRackBlock() { 
		super(BlockBehaviour.Properties.of(Material.WOOD).strength(1, 1).noOcclusion());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Nonnull
	@Override
	public InteractionResult use(@Nonnull BlockState blockState, Level world, @Nonnull BlockPos blockPos,
			@Nonnull Player playerEntity, @Nonnull InteractionHand hand, @Nonnull BlockHitResult blockRayTraceResult) {
		BlockEntity entity = world.getBlockEntity(blockPos);
		if (entity instanceof MeatHookBlockEntity te) {

			// Get item in both InteractionHands
			ItemStack heldMain = playerEntity.getItemInHand(InteractionHand.MAIN_HAND);
			// TODO May want to disable insertion if there's not enough space under the hook
			if (heldMain.getItem() instanceof CarcassItem) {
				// TODO Find a way to return SUCCESS on successful insertion
				te.insertItem(heldMain);
			} else if (heldMain != ItemStack.EMPTY)
				return te.butcher(playerEntity, heldMain);
		}

		return InteractionResult.PASS;

	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new DryingRackBlockEntity(pPos, pState);
	}
}
