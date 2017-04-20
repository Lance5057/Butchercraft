package com.Lance5057.ButcherCraft;

import com.Lance5057.ButcherCraft.core.tools.ToolEvents;
import com.Lance5057.ButcherCraft.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Butchercraft.MODID, name = Butchercraft.MODNAME, version = Butchercraft.MODVERSION, dependencies = "required-after:forge@[13.19.0.2129,)", useMetadata = true)
public class Butchercraft {

		public static final String MODID = "butchercraft";
		public static final String MODNAME = "ButcherCraft";
		public static final String MODVERSION = "0.0.1";

		@SidedProxy(clientSide = "com.Lance5057.ButcherCraft.proxy.ClientProxy", serverSide = "com.Lance5057.ButcherCraft.proxy.CommonProxy")
		public static CommonProxy proxy;
		public static BCBlocks blocks;
		public static BCItems items;
		
		public static ToolEvents tEvents;

		@Mod.Instance
		public static Butchercraft instance;

		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent e) {
			blocks = new BCBlocks();
			items = new BCItems();
			
			blocks.preInit(e);
			items.preInit(e);
			
			proxy.preInit(e);
			
			tEvents = new ToolEvents();
		}

		@Mod.EventHandler
		public void init(FMLInitializationEvent e) {
			blocks.init(e);
			items.init(e);
			
			proxy.init(e);
		}

		@Mod.EventHandler
		public void postInit(FMLPostInitializationEvent e) {
			blocks.postInit(e);
			items.postInit(e);
			
			proxy.postInit(e);
		}
}
