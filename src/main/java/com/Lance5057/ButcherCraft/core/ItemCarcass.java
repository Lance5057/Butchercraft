package com.Lance5057.ButcherCraft.core;

import com.Lance5057.ButcherCraft.Butchercraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCarcass extends Item {

	public ItemCarcass(String name) {
	        setRegistryName(name);
	        setUnlocalizedName(Butchercraft.MODID + "." + name);
	        GameRegistry.register(this);
	    }

	private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
		NBTTagCompound tagCompound = stack.getTagCompound();
		if (tagCompound == null) {
			tagCompound = new NBTTagCompound();
			stack.setTagCompound(tagCompound);
		}
		return tagCompound;
	}
}