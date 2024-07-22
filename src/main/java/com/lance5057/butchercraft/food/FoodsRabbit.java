package com.lance5057.butchercraft.food;

import net.minecraft.world.food.FoodProperties;

public class FoodsRabbit {
    public static final FoodProperties CUBED = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.3F)/*.meat()*/.build();
    public static final FoodProperties COOKED_CUBED = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.5F)/*.meat()*/.build();
    public static final FoodProperties GROUND = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.2F)/*.meat()*/.build();
    public static final FoodProperties COOKED_GROUND = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.5F)/*.meat()*/.build();
    public static final FoodProperties SCRAPS = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.2F)/*.meat()*/.build();
    public static final FoodProperties COOKED_SCRAPS = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3F)/*.meat()*/.build();
    public static final FoodProperties STEW = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.3F)/*.meat()*/.build();
    public static final FoodProperties COOKED_STEW = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.4F)/*.meat()*/.build();
    
    public static final FoodProperties SADDLE = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.4F)/*.meat()*/.build();
    public static final FoodProperties COOKED_SADDLE = (new FoodProperties.Builder()).nutrition(3).saturationModifier(0.5F)/*.meat()*/.build();
    public static final FoodProperties THIGH = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.3F)/*.meat()*/.build();
    public static final FoodProperties COOKED_THIGH = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.4F)/*.meat()*/.build();
    public static final FoodProperties LEG = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.3F)/*.meat()*/.build();
    public static final FoodProperties COOKED_LEG = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.4F)/*.meat()*/.build();
}
