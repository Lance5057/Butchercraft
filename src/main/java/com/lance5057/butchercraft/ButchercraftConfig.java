package com.lance5057.butchercraft;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ButchercraftConfig {
	public static ModConfigSpec spec;

	public static final String CATEGORY_ANIMALS = "animals";
	public static final ModConfigSpec.DoubleValue BREEDING_MULTIPLIER;
	public static final ModConfigSpec.DoubleValue AGE_MULTIPLIER;
	public static final ModConfigSpec.DoubleValue WILDLIFE_NUTRITION;

	public static final String CATEGORY_MOBS = "mobs";
	public static final ModConfigSpec.DoubleValue HOOD_SPAWN_CHANCE;
	public static final ModConfigSpec.DoubleValue HOOD_ARMY_CHANCE;

	public static final String CATEGORY_GEAR = "gear";
	public static final ModConfigSpec.IntValue CARCASS_EFFECT_CHANCE;

	static {
		ModConfigSpec.Builder Builder = new ModConfigSpec.Builder();

		Builder.comment("Animals").push(CATEGORY_ANIMALS);
		BREEDING_MULTIPLIER = Builder.comment("How much longer should it take for a baby animal to age?")
				.defineInRange("breeding_mulitplier", 0.1, 0, 1);

		AGE_MULTIPLIER = Builder
				.comment("How much longer should it take for an animal to be able to breed again?")
				.defineInRange("age_multiplier", 4, 1, Double.MAX_VALUE);

		WILDLIFE_NUTRITION = Builder.comment("Nutrition of wild animals.")
				.defineInRange("nutrition_multiplier", 0.3, 0, 1);
		Builder.pop();

		Builder.comment("Mobs").push(CATEGORY_MOBS);
		HOOD_SPAWN_CHANCE = Builder.comment("Chance that an undead mob will spawn with an animal hood.")
				.defineInRange("hoodChanceMultiplier", 0.1, 0, 1);

		HOOD_ARMY_CHANCE = Builder
				.comment("Chance that an undead with a hood spawns with an army of matching animals.")
				.defineInRange("armyHoodChanceMultiplier", 0.1, 0, 1);
		Builder.pop();

		Builder.comment("Mobs").push(CATEGORY_MOBS);
		CARCASS_EFFECT_CHANCE = Builder.comment(
				"Chance that a carcass applies its bloody effects per inventory tick. (Default 1/1000) Raising this can decrease server lag.")
				.defineInRange("armyHoodChanceMultiplier", 1000, 1, Integer.MAX_VALUE);
		Builder.pop();

		spec = Builder.build();
	}
}
