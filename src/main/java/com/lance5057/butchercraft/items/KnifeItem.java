package com.lance5057.butchercraft.items;

import java.util.Random;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class KnifeItem extends SwordItem {

	public KnifeItem(Properties builderIn) {
		super(Tiers.IRON, 3, 0, builderIn);
	}

	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		ItemStack container = itemStack.copy();
		if(container.hurt(1, new Random(), null))
			return ItemStack.EMPTY;
		else
			return container;

	}
}
