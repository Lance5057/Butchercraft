package com.lance5057.butchercraft.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class TemptArmor extends ArmorItem {

	public TemptArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {

		super(pMaterial, pSlot, pProperties);
	}

	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {
		
	}
}
