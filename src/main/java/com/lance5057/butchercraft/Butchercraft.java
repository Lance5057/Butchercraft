package com.lance5057.butchercraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lance5057.butchercraft.armor.BCArmorMaterial;
import com.lance5057.butchercraft.entity.ButchercraftVillagers;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Butchercraft.MOD_ID)
public class Butchercraft {

	public final static String MOD_ID = "butchercraft";
	public static final String VERSION = "2.6.5";

	public static Logger logger = LogManager.getLogger();

	public Butchercraft(IEventBus modEventBus, ModContainer container) {
		modEventBus.addListener(this::setupClient);
		modEventBus.addListener(this::setupCommon);

		container.registerConfig(ModConfig.Type.COMMON, ButchercraftConfig.spec);

		modEventBus.addListener(ButchercraftBlockEntities::addSkulls);

		BCArmorMaterial.register(modEventBus);
		ButchercraftBlocks.register(modEventBus);
		ButchercraftItems.register(modEventBus);
		ButchercraftRecipeSerializers.register(modEventBus);
		ButchercraftBlockEntities.register(modEventBus);
		ButchercraftRecipes.register(modEventBus);
		ButchercraftLootModifiers.register(modEventBus);
		ButchercraftMobEffects.register(modEventBus);
		ButchercraftFluids.register(modEventBus);
		ButchercraftVillagers.register(modEventBus);
	}

	public void setupClient(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ButchercraftClient.setBERenderers();
			ButchercraftVillagers.fillTradeData();

		});
	}

	public void setupCommon(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ButchercraftBlocks.setup();
		});
	}

}
