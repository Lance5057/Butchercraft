package com.lance5057.butchercraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;
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
    public static final String VERSION = "2.1.3";

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
        
        ButchercraftBlocks.register(modEventBus);
        ButchercraftItems.register(modEventBus);
        ButchercraftRecipeSerializers.register(modEventBus);
        ButchercraftBlockEntities.register(modEventBus);
        ButchercraftRecipes.register(modEventBus);
        ButchercraftLootModifiers.register(modEventBus);
        
    }

    public void setupClient(FMLClientSetupEvent event) {
    	event.enqueueWork(() -> {
    		ButchercraftClient.setBERenderers();
    		
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.MEAT_HOOK.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.DRYING_RACK.get(), RenderType.cutout());
    		
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.COW_HIDE_CARPET.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.PIG_HIDE_CARPET.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(), RenderType.cutout());
    		
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.HASH_FEAST.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.BBQ_RIBS_FEAST.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.POT_ROAST_FEAST.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.SALISBURY_STEAK_FEAST.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.PULLED_PORK_FEAST.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.RACK_LAMB.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.STIRFRY.get(), RenderType.cutout());
    		
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_WHITE.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_ORANGE.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_MAGENTA.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_LIGHT_BLUE.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_YELLOW.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_LIME.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_PINK.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_GREY.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_LIGHT_GREY.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_CYAN.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_PURPLE.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_BLUE.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_BROWN.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_GREEN.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_RED.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.JELLY_BLACK.get(), RenderType.translucent());
    	});
    }

}
