package com.lance5057.butchercraft.items;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class KnifeItem extends SwordItem {

	public KnifeItem(Properties builderIn) {
		super(Tiers.IRON, 3, 0, builderIn);
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
		ItemStack container = itemStack.copy();
		if (container.hurt(1, RandomSource.create(), null))
			return ItemStack.EMPTY;
		else
			return container;
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}
}
