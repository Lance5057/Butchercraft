package com.lance5057.butchercraft.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class ClothingTemptGoal extends TemptGoal {

	public ClothingTemptGoal(PathfinderMob pMob, double pSpeedModifier, Ingredient pItems, boolean pCanScare) {
		super(pMob, pSpeedModifier, pItems, pCanScare);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean shouldFollow(LivingEntity living) {
		for (ItemStack i : living.getArmorSlots()) {
			if (this.items.test(i))
				return true;
		}
		return false;
	}
}
