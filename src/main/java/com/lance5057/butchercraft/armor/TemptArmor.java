package com.lance5057.butchercraft.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public abstract class TemptArmor extends ArmorItem {

	public TemptArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {

		super(pMaterial, pSlot, pProperties);
	}
}
