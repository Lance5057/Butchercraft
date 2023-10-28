package com.lance5057.butchercraft.blocks;

import net.minecraft.world.level.block.SkullBlock;

public class AnimalHeadBlock extends SkullBlock {

	public AnimalHeadBlock(Type pType, Properties pProperties) {
		super(pType, pProperties);
		// TODO Auto-generated constructor stub
	}

	public static enum Types implements SkullBlock.Type {
		COW, SHEEP, PIG, GOAT, CHICKEN, RABBIT;
	}
}
