package com.lance5057.butchercraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lance5057.butchercraft.items.ButchercraftItems;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
    public static final String VERSION = "2.0.2";

    public static Logger logger = LogManager.getLogger();

    public Butchercraft() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setupClient);
    	
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ButchercraftConfig.initialize());
        // TODO Correct file name
        ButchercraftConfig.loadConfig(ButchercraftConfig.getInstance().getSpec(),
                FMLPaths.CONFIGDIR.get().resolve("compendium-common.toml"));

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
    		
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.COW_HIDE_CARPET.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.PIG_HIDE_CARPET.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(), RenderType.cutout());
    		
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.BBQ_JAR_BLOCK.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.STOCK_JAR_BLOCK.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.KETCHUP_JAR_BLOCK.get(), RenderType.translucent());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.GRAVY_BOAT.get(), RenderType.cutout());
    		ItemBlockRenderTypes.setRenderLayer(ButchercraftBlocks.HASH_FEAST.get(), RenderType.cutout());
    	});
    }

}
