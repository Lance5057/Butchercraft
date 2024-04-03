package com.lance5057.butchercraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lance5057.butchercraft.entity.ButchercraftVillagers;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Butchercraft.MOD_ID)
public class Butchercraft {

	public final static String MOD_ID = "butchercraft";
	public static final String VERSION = "2.3.9";

	public static Logger logger = LogManager.getLogger();

	public Butchercraft() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setupClient);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ButchercraftConfig.spec);

		IEventBus bus = MinecraftForge.EVENT_BUS;
		bus.addListener(ButchercraftModEvents::registerCaps);
		bus.addGenericListener(Entity.class, ButchercraftModEvents::attachCaps);
		bus.addListener(ButchercraftModEvents::breedEvent);
		bus.addListener(ButchercraftModEvents::cancelEat);
		bus.addListener(ButchercraftModEvents::dirtyHands);
		bus.addListener(ButchercraftModEvents::buffZombie);
		bus.addListener(ButchercraftModEvents::EntityJoined);
		bus.addListener(ButchercraftModEvents::cancelInteractions);

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

}
