package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.client.MeatHookRenderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@OnlyIn(Dist.CLIENT)

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = Butchercraft.MOD_ID)
public class ButchercraftClient {
	
	@SubscribeEvent
	public static void setBERenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ButchercraftBlockEntities.MEAT_HOOK.get(), MeatHookRenderer::new);
	}
}
