package com.lance5057.butchercraft.effects;

import java.util.Set;

import com.lance5057.butchercraft.ButchercraftMobEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.neoforge.common.EffectCure;

public class SoapableMobEffect extends MobEffect {

	protected SoapableMobEffect(MobEffectCategory pCategory, int pColor) {
		super(pCategory, pColor);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		super.fillEffectCures(cures, effectInstance);
		cures.add(ButchercraftMobEffects.SOAP);
	}
}
