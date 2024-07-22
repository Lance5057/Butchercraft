package com.lance5057.butchercraft.entity.ai;

import com.lance5057.butchercraft.ButchercraftMobEffects;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.animal.Animal;

public class AngryAnimalAttackGoal extends MeleeAttackGoal {
	public AngryAnimalAttackGoal(Animal animal, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
		super(animal, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
	}

	@Override
	public boolean canUse() {
		if (this.mob.hasEffect(ButchercraftMobEffects.BLOODLUST.getDelegate()))
			return super.canUse();
		return false;

	}
}