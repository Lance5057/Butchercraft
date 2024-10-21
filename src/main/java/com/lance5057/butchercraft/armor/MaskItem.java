package com.lance5057.butchercraft.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class MaskItem extends ArmorItem {
	public MaskItem(Holder<ArmorMaterial> pMaterial, Properties pProperties) {
		super(pMaterial, Type.HELMET, pProperties);
	}
}
