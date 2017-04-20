package com.Lance5057.ButcherCraft.core;

import com.Lance5057.ButcherCraft.Butchercraft;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ItemMisc  extends Item {

	public ItemMisc(String name, String oreDict) {
	        setRegistryName(name);
	        setUnlocalizedName(Butchercraft.MODID + "." + name);
	        GameRegistry.register(this);
	        
	        if(oreDict != null)
	        	OreDictionary.registerOre(oreDict, this);
	    }
}
