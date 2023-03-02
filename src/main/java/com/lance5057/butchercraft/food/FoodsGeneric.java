package com.lance5057.butchercraft.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodsGeneric {
	public static final FoodProperties BRAIN = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
    public static final FoodProperties COOKED_BRAIN = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).meat().build();
    public static final FoodProperties HEART = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
    public static final FoodProperties COOKED_HEART = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).meat().build();
    public static final FoodProperties KIDNEY = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
    public static final FoodProperties COOKED_KIDNEY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat().build();
    public static final FoodProperties LIVER = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
    public static final FoodProperties COOKED_LIVER = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).meat().build();
    public static final FoodProperties LUNG = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
    public static final FoodProperties COOKED_LUNG = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F).meat().build();
    public static final FoodProperties STOMACHE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
    public static final FoodProperties COOKED_STOMACHE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).meat().build();
    public static final FoodProperties TRIPE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.6F).build();
    public static final FoodProperties COOKED_TRIPE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).meat().build();
    
    public static final FoodProperties SAUSAGE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
    public static final FoodProperties COOKED_SAUSAGE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).meat().build();
    
    public static final FoodProperties STOCK = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.0F).build();
    public static final FoodProperties GRAVY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
    
    
    
    public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
    public static final FoodProperties BUTTER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).build();
    
    public static final FoodProperties SAUSAGE_ROLL = (new FoodProperties.Builder()).nutrition(10).saturationMod(1F).build();
    public static final FoodProperties SOS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
    public static final FoodProperties LIVERONION = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F).build();
    public static final FoodProperties CHICKEN_FRIED_STEAK = (new FoodProperties.Builder()).nutrition(8).saturationMod(1F).build();
    public static final FoodProperties STUFFED_HEART = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.5F).build();
    public static final FoodProperties FRIED_BRAIN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
    public static final FoodProperties GRILLED_CHEESE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.75F).build();
    
    public static final FoodProperties POTATO_GRAVY = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties STIRFRY = (new FoodProperties.Builder()).nutrition(10).saturationMod(1F).build();
    public static final FoodProperties WELLINGTON = (new FoodProperties.Builder()).nutrition(12).saturationMod(1F).build();
    public static final FoodProperties HAGGIS = (new FoodProperties.Builder()).nutrition(8).saturationMod(1F).build();
    
    public static final FoodProperties JELLY = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.2F).alwaysEat().build();
}
