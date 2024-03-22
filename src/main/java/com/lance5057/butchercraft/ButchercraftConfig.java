package com.lance5057.butchercraft;

import net.minecraftforge.common.ForgeConfigSpec;

public class ButchercraftConfig {
	public static ForgeConfigSpec spec;

	public static final String CATEGORY_ANIMALS = "animals";
	public static final ForgeConfigSpec.ConfigValue<Float> BREEDING_MULTIPLIER;
	public static final ForgeConfigSpec.ConfigValue<Float> AGE_MULTIPLIER;
	public static final ForgeConfigSpec.ConfigValue<Float> WILDLIFE_NUTRITION;

	public static final String CATEGORY_MOBS = "mobs";
	public static final ForgeConfigSpec.ConfigValue<Float> HOOD_SPAWN_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Float> HOOD_ARMY_CHANCE;

	static {
		ForgeConfigSpec.Builder Builder = new ForgeConfigSpec.Builder();

		Builder.comment("Animals").push(CATEGORY_ANIMALS);
		BREEDING_MULTIPLIER = Builder.comment("How much longer should it take for a baby animal to age?")
				.define("breeding_mulitplier", 4f);
		

		AGE_MULTIPLIER = Builder.comment("How much longer should it take for an animal to be able to breed again?")
				.define("age_multiplier", 4f);
		
		WILDLIFE_NUTRITION = Builder.comment("Nutrition of wild animals.").define("nutrition_multiplier", 0.3f);
		Builder.pop();
		
		Builder.comment("Mobs").push(CATEGORY_MOBS);
		HOOD_SPAWN_CHANCE = Builder.comment("Chance that an undead mob will spawn with an animal hood.").define("hoodChanceMultiplier", 0.1f);
		
		HOOD_ARMY_CHANCE = Builder.comment("Chance that an undead with a hood spawns with an army of matching animals.")
				.define("armyHoodChanceMultiplier", 0.1f);
		Builder.pop();

		spec = Builder.build();
	}
}
