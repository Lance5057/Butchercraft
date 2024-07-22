package com.lance5057.butchercraft.effects;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BloodSplatteredEffect extends SoapableMobEffect {

	public BloodSplatteredEffect() {
		super(MobEffectCategory.HARMFUL, 7995392);
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (pLivingEntity.level().random.nextInt() % 5 == 0)
			pLivingEntity.level().addParticle(ParticleTypes.FALLING_LAVA,
					pLivingEntity.position().x - 0.5f + pLivingEntity.level().random.nextDouble(),
					pLivingEntity.position().y + 1.5f - pLivingEntity.level().random.nextDouble(),
					pLivingEntity.position().z - 0.25f + pLivingEntity.level().random.nextDouble() / 2, 0, 0, 0);
		return super.applyEffectTick(pLivingEntity, pAmplifier);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}
}
