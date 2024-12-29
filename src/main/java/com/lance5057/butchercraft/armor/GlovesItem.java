package com.lance5057.butchercraft.armor;

import com.lance5057.butchercraft.ButchercraftMobEffects;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GlovesItem extends ArmorItem {
	public GlovesItem(Holder<ArmorMaterial> pMaterial, Properties pProperties) {
		super(pMaterial, Type.CHESTPLATE, pProperties);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if (entity instanceof LivingEntity living) {
			if (living.hasEffect(ButchercraftMobEffects.DIRTY))
				living.removeEffect(ButchercraftMobEffects.DIRTY);
		}
	}
}
