package com.lance5057.butchercraft;

import com.lance5057.butchercraft.entity.ButchercraftVillagers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Butchercraft.MOD_ID)
public class Butchercraft {

	public final static String MOD_ID = "butchercraft";
	public static final String VERSION = "2.4.0";

	public static Logger logger = LogManager.getLogger();

	public Butchercraft(IEventBus modEventBus) {
		modEventBus.addListener(this::setupClient);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ButchercraftConfig.spec);

		IEventBus bus = NeoForge.EVENT_BUS;
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
