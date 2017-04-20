package com.Lance5057.ButcherCraft.core.food;

import com.Lance5057.ButcherCraft.Butchercraft;

import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemButcherFood extends ItemFood {

	public ItemButcherFood(int amount, float saturation, boolean isWolfFood, boolean isCooked, String name) {
		super(amount, saturation, isWolfFood);
		setRegistryName(name);
        setUnlocalizedName(Butchercraft.MODID + "." + name);
        GameRegistry.register(this);
		if(!isCooked)
			this.setPotionEffect(new PotionEffect(Potion.getPotionById(17),600), 0.5f);
	}

}
