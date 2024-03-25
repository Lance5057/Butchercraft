package com.lance5057.butchercraft;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;

public class ButchercraftConfig {
	public static ForgeConfigSpec spec;

	public static final String CATEGORY_ANIMALS = "animals";
	public static final ForgeConfigSpec.DoubleValue BREEDING_MULTIPLIER;
	public static final ForgeConfigSpec.DoubleValue AGE_MULTIPLIER;
	public static final ForgeConfigSpec.DoubleValue WILDLIFE_NUTRITION;

	public static final String CATEGORY_MOBS = "mobs";
	public static final ForgeConfigSpec.DoubleValue HOOD_SPAWN_CHANCE;
	public static final ForgeConfigSpec.DoubleValue HOOD_ARMY_CHANCE;

	static {
		ForgeConfigSpec.Builder Builder = new ForgeConfigSpec.Builder();

		Builder.comment("Animals").push(CATEGORY_ANIMALS);
		BREEDING_MULTIPLIER = Builder.comment("How much longer should it take for a baby animal to age?").defineInRange("breeding_mulitplier", 0.1, 0, 1);
		

		AGE_MULTIPLIER = (DoubleValue) Builder.comment("How much longer should it take for an animal to be able to breed again?")
				.defineInRange("age_multiplier", 4, 1, Double.MAX_VALUE);
		
		WILDLIFE_NUTRITION = (DoubleValue) Builder.comment("Nutrition of wild animals.").defineInRange("nutrition_multiplier", 0.3, 0, 1);
		Builder.pop();
		
		Builder.comment("Mobs").push(CATEGORY_MOBS);
		HOOD_SPAWN_CHANCE = (DoubleValue) Builder.comment("Chance that an undead mob will spawn with an animal hood.").defineInRange("hoodChanceMultiplier", 0.1, 0, 1);
		
		HOOD_ARMY_CHANCE = (DoubleValue) Builder.comment("Chance that an undead with a hood spawns with an army of matching animals.")
				.defineInRange("armyHoodChanceMultiplier", 0.1, 0, 1);
		Builder.pop();

		spec = Builder.build();
	}
}
