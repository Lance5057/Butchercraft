package com.Lance5057.ButcherCraft;

import com.Lance5057.ButcherCraft.core.meathook.MeatHookBlock;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BCBlocks {

	public static final CreativeTabs butcherTab = new CreativeTabs("butchercraft.blocks") {
	    @Override public ItemStack getTabIconItem() {
	        return new ItemStack(Items.BEEF);
	    }
	};
	
	public static MeatHookBlock meatHook;

	public void preInit(FMLPreInitializationEvent e) {
		meatHook = new MeatHookBlock(Material.IRON);
		meatHook.setCreativeTab(butcherTab);
	}

	public void init(FMLInitializationEvent e) {
		
	}

	public void postInit(FMLPostInitializationEvent e) {

	}

}
