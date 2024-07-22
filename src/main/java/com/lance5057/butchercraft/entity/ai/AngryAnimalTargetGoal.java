package com.lance5057.butchercraft.entity.ai;

import com.lance5057.butchercraft.ButchercraftMobEffects;

import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;

public class AngryAnimalTargetGoal extends NearestAttackableTargetGoal<Player> {

	public AngryAnimalTargetGoal(Animal pMob) {
		super(pMob, Player.class, false, false);
		this.targetConditions.ignoreLineOfSight();
	}

	@Override
	public boolean canUse() {
		if (this.mob.hasEffect(ButchercraftMobEffects.BLOODLUST.getDelegate())) {
			if (this.randomInterval > 0 && this.mob.getRandom().nextInt(this.randomInterval) != 0) {
				return false;
			} else {
				this.findTarget();
				return this.target != null;
			}
		}
		return false;
	}

}
