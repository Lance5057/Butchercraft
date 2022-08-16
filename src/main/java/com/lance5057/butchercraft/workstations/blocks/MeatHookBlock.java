package com.lance5057.butchercraft.workstations.blocks;

import com.lance5057.butchercraft.tags.ButchercraftItemTags;
import com.lance5057.butchercraft.workstations.blockentities.MeatHookBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nonnull;

public class MeatHookBlock extends BaseEntityBlock {

    public MeatHookBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(3, 4).air());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new MeatHookBlockEntity(pPos, pState);
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState blockState, Level world, @Nonnull BlockPos blockPos,
                                 @Nonnull Player playerEntity, @Nonnull InteractionHand hand, @Nonnull BlockHitResult blockRayTraceResult) {
        BlockEntity blockEntity = world.getBlockEntity(blockPos);
        if (blockEntity instanceof MeatHookBlockEntity meatHookBlockEntity) {
            ItemStack itemStack = playerEntity.getItemInHand(hand);
            // Attempt to insert carcass
            // TODO Redo logic since we check if items is valid on the block entity, maybe shrink the stack there
            if (itemStack.is(ButchercraftItemTags.CARCASSES) && meatHookBlockEntity.isEmpty()) {
                meatHookBlockEntity.insertItem(itemStack.split(1));
                return meatHookBlockEntity.isEmpty() ? InteractionResult.CONSUME : InteractionResult.PASS;
            }
            else {
                meatHookBlockEntity.useTool(itemStack, playerEntity);
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(blockState, world, blockPos, playerEntity, hand, blockRayTraceResult);

    }
}
