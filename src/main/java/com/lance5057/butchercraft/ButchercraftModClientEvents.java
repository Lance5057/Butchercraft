package com.lance5057.butchercraft;

import net.minecraft.core.component.DataComponents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ButchercraftModClientEvents {
    @SubscribeEvent
    public static void registerColorHandlers(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
            return stack.has(DataComponents.DYED_COLOR) ? stack.get(DataComponents.DYED_COLOR).rgb() : 0xFFFFFF;
        }, ButchercraftItems.SHEEP_HOOD);
    }
}
