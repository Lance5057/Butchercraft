package com.lance5057.butchercraft.items;

import com.lance5057.butchercraft.ButchercraftConfig;
import com.lance5057.butchercraft.ButchercraftMobEffects;
import com.lance5057.butchercraft.armor.ApronItem;
import com.lance5057.butchercraft.armor.BootsItem;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CarcassItem extends Item {

	public CarcassItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
		if (pLevel.getRandom().nextInt() % ButchercraftConfig.CARCASS_EFFECT_CHANCE.get() == 0)
			if (pEntity instanceof Player p) {
				ItemStack boots = p.getInventory().getArmor(0);
				if (boots.getItem() instanceof BootsItem)

					boots.hurtAndBreak(1,  p, EquipmentSlot.FEET);
				else
					p.addEffect(new MobEffectInstance(ButchercraftMobEffects.BLOODTRAIL, 3600, 0, false, false,
							true));

				ItemStack apron = p.getInventory().getArmor(1);
				if (apron.getItem() instanceof ApronItem)
					apron.hurtAndBreak(1, p, EquipmentSlot.LEGS);
				else
					p.addEffect(
							new MobEffectInstance(ButchercraftMobEffects.BLOODY, 3600, 0, false, false, true));
			}
	}
}
