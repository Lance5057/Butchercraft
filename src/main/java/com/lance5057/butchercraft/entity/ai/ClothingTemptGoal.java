package com.lance5057.butchercraft.entity.ai;

import com.lance5057.butchercraft.ButchercraftMobEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class ClothingTemptGoal extends LivingTemptGoal {

	public ClothingTemptGoal(PathfinderMob pMob, double pSpeedModifier, Ingredient pItems, boolean pCanScare) {
		super(pMob, pSpeedModifier, pItems, pCanScare);
	}

	@Override
	public boolean shouldFollow(LivingEntity living) {
		if (living instanceof Player || living instanceof Monster)
			for (ItemStack i : living.getArmorSlots()) {
				if (this.items.test(i)) {
					if (living instanceof Monster) {
						this.mob.addEffect(new MobEffectInstance(ButchercraftMobEffects.BLOODLUST.getDelegate(), 60));
//						return false;
					}
					return true;
				}
			}
		return false;
	}
}
