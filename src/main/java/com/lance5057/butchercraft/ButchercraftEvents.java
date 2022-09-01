package com.lance5057.butchercraft;

import javax.annotation.Nonnull;

import com.lance5057.butchercraft.loot.ButcheringKnifeModifier;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ButchercraftEvents {

	@SubscribeEvent
	public static void registerModifierSerializers(
			@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
		event.getRegistry().register(new ButcheringKnifeModifier.Serializer()
				.setRegistryName(new ResourceLocation(Butchercraft.MOD_ID, "butcherknife")));
	}
}
