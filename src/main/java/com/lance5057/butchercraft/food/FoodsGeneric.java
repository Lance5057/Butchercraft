package com.lance5057.butchercraft.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodsGeneric {
	public static final FoodProperties BRAIN = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
	public static final FoodProperties COOKED_BRAIN = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties HEART = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
	public static final FoodProperties COOKED_HEART = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties KIDNEY = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
	public static final FoodProperties COOKED_KIDNEY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties LIVER = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
	public static final FoodProperties COOKED_LIVER = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F)
			.meat().build();
	public static final FoodProperties LUNG = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
	public static final FoodProperties COOKED_LUNG = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F)
			.meat().build();
	public static final FoodProperties STOMACH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
	public static final FoodProperties COOKED_STOMACH = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties TRIPE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
	public static final FoodProperties COOKED_TRIPE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties SAUSAGE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodProperties COOKED_SAUSAGE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties COOKED_BLOOD_SAUSAGE = (new FoodProperties.Builder()).nutrition(7)
			.saturationMod(0.4F).meat().effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600), 100).build();
	public static final FoodProperties EYEBALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
	public static final FoodProperties COOKED_EYEBALL = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
			.meat().build();
}
