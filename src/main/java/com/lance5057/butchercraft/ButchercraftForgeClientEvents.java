package com.lance5057.butchercraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.MerchantScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT, modid = Butchercraft.MOD_ID)
public class ButchercraftForgeClientEvents {
	@SubscribeEvent
	public static void cancelTrade(ScreenEvent.Opening event) {
		if (event.getNewScreen() instanceof MerchantScreen m) {
			Minecraft mine = Minecraft.getInstance();
			if (mine.player.hasEffect(ButchercraftMobEffects.STINKY.get())
					|| mine.player.hasEffect(ButchercraftMobEffects.BLOODY.get())) {
				event.setCanceled(true);
			}
		}
	}
}
