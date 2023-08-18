package com.lance5057.butchercraft.food;

import net.minecraft.world.food.FoodProperties;

public class FoodsGoat {
	public static final FoodProperties GOAT_STEWMEAT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().build();
    public static final FoodProperties COOKED_GOAT_STEWMEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).meat().build();
    public static final FoodProperties ROAST = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.7F).meat().build();
    public static final FoodProperties COOKED_ROAST = (new FoodProperties.Builder()).nutrition(11).saturationMod(1.3F).meat().build();
    public static final FoodProperties GOAT_RIBS = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.7F).meat().build();
    public static final FoodProperties COOKED_GOAT_RIBS = (new FoodProperties.Builder()).nutrition(11).saturationMod(1.3F).meat().build();
    public static final FoodProperties CUBED_GOAT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_CUBED_GOAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).meat().build();
    public static final FoodProperties GROUND_GOAT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).meat().build();
    public static final FoodProperties COOKED_GROUND_GOAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
    public static final FoodProperties GOAT_SCRAPS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_GOAT_SCRAPS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).meat().build();
}
