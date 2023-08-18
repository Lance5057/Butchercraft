package com.lance5057.butchercraft.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodsChicken {
	public static final FoodProperties CUBED = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties COOKED_CUBED = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F)
			.meat().build();
	public static final FoodProperties GROUND = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodProperties COOKED_GROUND = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F)
			.meat().build();
	public static final FoodProperties SCRAPS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodProperties COOKED_SCRAPS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties STEW = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodProperties COOKED_STEW = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F)
			.meat().build();

	public static final FoodProperties BREAST = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties COOKED_BREAST = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F)
			.meat().build();
	public static final FoodProperties THIGH = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties COOKED_THIGH = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F)
			.meat().build();
	public static final FoodProperties WING = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties COOKED_WING = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties LEG = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties COOKED_LEG = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F)
			.meat().build();

	public static final FoodProperties WATTLE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties COOKED_WATTLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
			.effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0), 1F).meat().build();
}
