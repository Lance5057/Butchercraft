package com.lance5057.butchercraft;

import com.lance5057.butchercraft.effects.BloodLustEffect;
import com.lance5057.butchercraft.effects.BloodSplatteredEffect;
import com.lance5057.butchercraft.effects.BloodTrailEffect;
import com.lance5057.butchercraft.effects.DirtyHandsEffect;
import com.lance5057.butchercraft.effects.PungentReekEffect;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.EffectCure;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ButchercraftMobEffects {
	public static final EffectCure SOAP = EffectCure.get("soap");

	private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT,
			Butchercraft.MOD_ID);

	public static final DeferredHolder<MobEffect, BloodSplatteredEffect> BLOODY = EFFECTS.register("blood_splatter",
			BloodSplatteredEffect::new);
	public static final DeferredHolder<MobEffect, PungentReekEffect> STINKY = EFFECTS.register("pungent_reek",
			PungentReekEffect::new);
	public static final DeferredHolder<MobEffect, BloodTrailEffect> BLOODTRAIL = EFFECTS.register("blood_trail",
			BloodTrailEffect::new);
	public static final DeferredHolder<MobEffect, DirtyHandsEffect> DIRTY = EFFECTS.register("dirty_hands", DirtyHandsEffect::new);
	public static final DeferredHolder<MobEffect, BloodLustEffect> BLOODLUST = EFFECTS.register("blood_lust",
			BloodLustEffect::new);

	public static void register(IEventBus modBus) {
		EFFECTS.register(modBus);
	}
}
