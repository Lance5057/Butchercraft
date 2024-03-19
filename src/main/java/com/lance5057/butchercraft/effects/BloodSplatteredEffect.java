package com.lance5057.butchercraft.effects;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BloodSplatteredEffect extends SoapableMobEffect {

	public BloodSplatteredEffect() {
		super(MobEffectCategory.HARMFUL, 7995392);
	}

	@Override
	public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		super.applyEffectTick(pLivingEntity, pAmplifier);

		if (pLivingEntity.getLevel().random.nextInt() % 5 == 0)
			pLivingEntity.level.addParticle(ParticleTypes.FALLING_LAVA,
					pLivingEntity.position().x - 0.5f + pLivingEntity.level.random.nextDouble(),
					pLivingEntity.position().y + 1.5f - pLivingEntity.level.random.nextDouble(),
					pLivingEntity.position().z - 0.25f + pLivingEntity.level.random.nextDouble() / 2, 0, 0, 0);
	}

	@Override
	public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
		return true;
	}
}
