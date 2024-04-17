package com.lance5057.butchercraft.effects;

import com.lance5057.butchercraft.ButchercraftItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SoapableMobEffect extends MobEffect {

	protected SoapableMobEffect(MobEffectCategory pCategory, int pColor) {
		super(pCategory, pColor);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(ButchercraftItems.SOAP.get()));
		return ret;
	}
}
