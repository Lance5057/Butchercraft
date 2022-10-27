package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.client.DryingRackRenderer;
import com.lance5057.butchercraft.workstations.client.MeatHookRenderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = Butchercraft.MOD_ID)
public class ButchercraftClient {
	
	//@SubscribeEvent
	public static void setBERenderers() {
		BlockEntityRenderers.register(ButchercraftBlockEntities.MEAT_HOOK.get(), MeatHookRenderer::new);
		BlockEntityRenderers.register(ButchercraftBlockEntities.DRYING_RACK.get(), DryingRackRenderer::new);
	}
}
 