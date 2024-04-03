package com.lance5057.butchercraft;

import com.lance5057.butchercraft.effects.BloodLustEffect;
import com.lance5057.butchercraft.effects.BloodSplatteredEffect;
import com.lance5057.butchercraft.effects.BloodTrailEffect;
import com.lance5057.butchercraft.effects.DirtyHandsEffect;
import com.lance5057.butchercraft.effects.PungentReekEffect;

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
	public static final RegistryObject<PungentReekEffect> STINKY = EFFECTS.register("pungent_reek",
			PungentReekEffect::new);
	public static final RegistryObject<BloodTrailEffect> BLOODTRAIL = EFFECTS.register("blood_trail",
			BloodTrailEffect::new);
	public static final RegistryObject<DirtyHandsEffect> DIRTY = EFFECTS.register("dirty_hands", DirtyHandsEffect::new);
	public static final RegistryObject<BloodLustEffect> BLOODLUST = EFFECTS.register("blood_lust",
			BloodLustEffect::new);

	public static void register(IEventBus modBus) {
		EFFECTS.register(modBus);
	}
}
