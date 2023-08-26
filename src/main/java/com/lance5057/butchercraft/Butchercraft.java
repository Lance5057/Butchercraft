package com.lance5057.butchercraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Butchercraft.MOD_ID)
public class Butchercraft {

	public final static String MOD_ID = "butchercraft";
	public static final String VERSION = "2.2.2a";

	public static Logger logger = LogManager.getLogger();

	public Butchercraft() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setupClient);

		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, ButchercraftConfig.initialize());
		// TODO Correct file name
		ButchercraftConfig.loadConfig(ButchercraftConfig.getInstance().getSpec(),
				FMLPaths.CONFIGDIR.get().resolve("butchercraft-common.toml"));

		IEventBus bus = MinecraftForge.EVENT_BUS;
		bus.addListener(ButchercraftEvents::registerCaps);
		bus.addGenericListener(Entity.class, ButchercraftEvents::attachCaps);
		bus.addListener(ButchercraftEvents::breedEvent);
		bus.addListener(ButchercraftEvents::cancelEat);
//		bus.addListener(ButchercraftEvents::registerLayerDefinitions);

		ButchercraftBlocks.register(modEventBus);
		ButchercraftItems.register(modEventBus);
		ButchercraftRecipeSerializers.register(modEventBus);
		ButchercraftBlockEntities.register(modEventBus);
		ButchercraftRecipes.register(modEventBus);
		ButchercraftLootModifiers.register(modEventBus);
		ButchercraftMobEffects.register(modEventBus);
		ButchercraftFluids.register(modEventBus);
	}

	public void setupClient(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ButchercraftClient.setBERenderers();

			ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.MEAT_HOOK.get(), RenderType.cutout());

			ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.COW_HIDE_CARPET.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.PIG_HIDE_CARPET.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(), RenderType.cutout());

		});
	}

}
