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

	public enum Types implements SkullBlock.Type {
		CHICKEN("chicken"),
		CHICKEN_SKULL("chicken_skull"),
		COW("cow"),
		COW_SKULL("cow_skull"),
		GOAT("goat"),
		GOAT_SKULL("goat_skull"),
		PIG("pig"),
		PIG_SKULL("pig_skull"),
		RABBIT_BLACK("rabbit_black"),
		RABBIT_BROWN("rabbit_brown"),
		RABBIT_GOLD("rabbit_gold"),
		RABBIT_SALT("rabbit_salt"),
		RABBIT_SPLOTCHED("rabbit_splotched"),
		RABBIT_WHITE("rabbit_white"),
		RABBIT_SKULL("rabbit_skull"),
		SHEEP("sheep"),
		SHEEP_SKULL("sheep_skull");

		private final String name;

		Types(String name) {
			this.name = name;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}
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
