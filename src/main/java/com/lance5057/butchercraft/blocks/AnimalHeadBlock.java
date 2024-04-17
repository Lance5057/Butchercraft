package com.lance5057.butchercraft.blocks;

import com.lance5057.butchercraft.ButchercraftBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AnimalHeadBlock extends SkullBlock {

	public AnimalHeadBlock(Type pType, Properties pProperties) {
		super(pType, pProperties);
		// TODO Auto-generated constructor stub
	}

	public static enum Types implements SkullBlock.Type {
		COW, COW_SKULL, SHEEP, SHEEP_SKULL, PIG, PIG_SKULL, GOAT, GOAT_SKULL, CHICKEN, CHICKEN_SKULL, RABBIT_BLACK,
		RABBIT_BROWN, RABBIT_GOLD, RABBIT_SALT, RABBIT_WHITE, RABBIT_SPLOTCHED, RABBIT_SKULL;
	}

	@Override
	public BlockEntity newBlockEntity(final BlockPos blockPos, final BlockState blockState) {
		return new SkullBlockEntity(blockPos, blockState) {

			@Override
			public BlockEntityType<?> getType() {
				return ButchercraftBlockEntities.SKULL.get();
			}
		};
	}
}
