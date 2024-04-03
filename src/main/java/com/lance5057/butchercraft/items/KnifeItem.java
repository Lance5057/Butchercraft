package com.lance5057.butchercraft.items;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class KnifeItem extends SwordItem {

	public KnifeItem(Properties builderIn) {
		super(Tiers.IRON, 1, -2.4F, builderIn);
	}

//	@Override
//	public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
//		ItemStack container = itemStack.copy();
//		if (container.hurt(1, RandomSource.create(), null))
//			return ItemStack.EMPTY;
//		else
//			return container;
//	}
}
