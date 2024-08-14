package com.lance5057.butchercraft.items;

import java.util.List;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.Tool;

public class KnifeItem extends SwordItem {

	public KnifeItem(Properties builderIn) {
		super(Tiers.IRON, builderIn, new Tool(List.of(), 2.4F, 1));
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
