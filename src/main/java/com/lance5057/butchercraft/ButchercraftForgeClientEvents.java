package com.lance5057.butchercraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.MerchantScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ScreenEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT, modid = Butchercraft.MOD_ID)
public class ButchercraftForgeClientEvents {
	@SubscribeEvent
	public static void cancelTrade(ScreenEvent.Opening event) {
		if (event.getNewScreen() instanceof MerchantScreen m) {
			Minecraft mine = Minecraft.getInstance();
			if (mine.player.hasEffect(ButchercraftMobEffects.STINKY)
					|| mine.player.hasEffect(ButchercraftMobEffects.BLOODY)) {
				event.setCanceled(true);
			}
		}
	}
}
