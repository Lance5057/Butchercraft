package com.lance5057.butchercraft;

import java.util.Map;

import com.lance5057.butchercraft.workstations.client.ButcherBlockRenderer;
import com.lance5057.butchercraft.workstations.client.DryingRackRenderer;
import com.lance5057.butchercraft.workstations.client.MeatHookRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent.RegisterAdditional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = Butchercraft.MOD_ID)
public class ButchercraftClient {

	// @SubscribeEvent
	public static void setBERenderers() {
		BlockEntityRenderers.register(ButchercraftBlockEntities.MEAT_HOOK.get(), MeatHookRenderer::new);
		BlockEntityRenderers.register(ButchercraftBlockEntities.DRYING_RACK.get(), DryingRackRenderer::new);
		BlockEntityRenderers.register(ButchercraftBlockEntities.BUTCHER_BLOCK.get(), ButcherBlockRenderer::new);
	}

	@SubscribeEvent
	public static void RegisterHookModels(RegisterAdditional event) {
		Map<ResourceLocation, Resource> rrs = Minecraft.getInstance().getResourceManager()
				.listResources("models/meathook", (p_215600_) -> {
					return p_215600_.getPath().endsWith(".json");
				});

		rrs.forEach((rl, r) -> {
			String s = rl.toString();

			s = s.substring(s.indexOf('/') + 1, s.indexOf('.'));

			ResourceLocation rl2 = new ResourceLocation(rl.getNamespace(), s);

			event.register(rl2);
		});
	}
}
