package com.lance5057.butchercraft.items;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;

public class WolfFoodSpecialItem extends Item {

	Holder<MobEffect> effect;

	public WolfFoodSpecialItem(Properties properties, Holder<MobEffect> effect) {
		super(properties);
		this.effect = effect;
	}

	public Holder<MobEffect> getEffect() {
		return effect;
	}
}
