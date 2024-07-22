package com.lance5057.butchercraft.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public abstract class TemptArmor extends ArmorItem {

	public TemptArmor(Holder<ArmorMaterial> pMaterial, Type pSlot, Properties pProperties) {

		super(pMaterial, pSlot, pProperties);
	}
}
