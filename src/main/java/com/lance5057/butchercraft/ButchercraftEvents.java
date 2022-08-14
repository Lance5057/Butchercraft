package com.lance5057.butchercraft;

import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ButchercraftEvents {

    @SubscribeEvent
    public void checkButcherEvent(LivingDeathEvent event) {
//	event.getEntityLiving().dea
    }
}
