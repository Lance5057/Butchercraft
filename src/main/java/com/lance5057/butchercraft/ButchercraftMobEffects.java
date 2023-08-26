package com.lance5057.butchercraft;

import com.lance5057.butchercraft.effects.BloodSplatteredEffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ButchercraftMobEffects {
	private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
			Butchercraft.MOD_ID);

	public static final RegistryObject<BloodSplatteredEffect> BLOODY = EFFECTS.register("blood_splatter",
			BloodSplatteredEffect::new);

	public static void register(IEventBus modBus) {
		EFFECTS.register(modBus);
	}
}
