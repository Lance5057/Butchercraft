package com.lance5057.butchercraft;

import com.lance5057.butchercraft.capabilities.AnimalCare;
import com.lance5057.butchercraft.capabilities.AnimalCareProvider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;

public class ButchercraftEvents {

	public static void registerCaps(RegisterCapabilitiesEvent event) {
		event.register(AnimalCare.class);
	}

	public static void attachCaps(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Cow) {
			if (!event.getObject().getCapability(AnimalCareProvider.CARE).isPresent()) {
				event.addCapability(new ResourceLocation(Butchercraft.MOD_ID, "animalcare"), new AnimalCareProvider());
			}
		}

	}

	public static void breedEvent(BabyEntitySpawnEvent event) {
		Level level = event.getCausedByPlayer().level;

		if (level instanceof ServerLevel) {
			ServerLevel server = (ServerLevel) level;

			if (event.getChild() instanceof Cow) {
				Cow baby = (Cow) event.getChild();
				Cow pA = (Cow) event.getParentA();
				Cow pB = (Cow) event.getParentB();

				float pAN = pA.getCapability(AnimalCareProvider.CARE).map(i -> i.getNutrition()).orElse(0.3f); // TODO
																												// config
				float pBN = pB.getCapability(AnimalCareProvider.CARE).map(i -> i.getNutrition()).orElse(0.3f);

				if (pAN + pBN >= 2) {
					baby.getCapability(AnimalCareProvider.CARE).ifPresent(i -> i.setNutrition(0.9f));
					Cow baby2 = (Cow) baby.getType().spawn(server, null, event.getCausedByPlayer(), pA.blockPosition(),
							MobSpawnType.BREEDING, true, false);
					baby2.setBaby(true);
					baby2.getCapability(AnimalCareProvider.CARE).ifPresent(i -> i.setNutrition(0.9f));
				} else {
					float bred = Math.max(pAN, pBN) + Math.min(pAN, pBN)/2;
					baby.getCapability(AnimalCareProvider.CARE).ifPresent(i -> i.setNutrition(bred));
				}
			}
		}
	}
}
