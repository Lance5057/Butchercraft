package com.Lance5057.ButcherCraft;

import org.apache.logging.log4j.Logger;

import com.Lance5057.ButcherCraft.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Butchercraft.MODID, name = Butchercraft.MODNAME, version = Butchercraft.MODVERSION, dependencies = "required-after:forge@[13.19.0.2129,)", useMetadata = true)
public class Butchercraft {

		public static final String MODID = "modtut";
		public static final String MODNAME = "Mod tutorials";
		public static final String MODVERSION = "0.0.1";

		@SidedProxy(clientSide = "", serverSide = "")
		public static CommonProxy proxy;

		@Mod.Instance
		public static Butchercraft instance;

		public static Logger logger;

		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event) {
			logger = event.getModLog();
			proxy.preInit(event);
		}

		@Mod.EventHandler
		public void init(FMLInitializationEvent e) {
			proxy.init(e);
		}

		@Mod.EventHandler
		public void postInit(FMLPostInitializationEvent e) {
			proxy.postInit(e);
		}
}
