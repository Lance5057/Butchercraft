package com.lance5057.butchercraft.food;

import net.minecraft.world.food.FoodProperties;

public class FoodsSheep {
	public static final FoodProperties LAMB_STEWMEAT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().build();
    public static final FoodProperties COOKED_LAMB_STEWMEAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
    public static final FoodProperties ROAST = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).meat().build();
    public static final FoodProperties COOKED_ROAST = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.2F).meat().build();
    public static final FoodProperties LAMB_RIBS = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).meat().build();
    public static final FoodProperties COOKED_LAMB_RIBS = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.2F).meat().build();
    public static final FoodProperties LAMB_RIB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat().build();
    public static final FoodProperties COOKED_LAMB_RIB = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).meat().build();
    public static final FoodProperties CUBED_LAMB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat().build();
    public static final FoodProperties COOKED_CUBED_LAMB = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).meat().build();
    public static final FoodProperties GROUND_LAMB = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().build();
    public static final FoodProperties COOKED_GROUND_LAMB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat().build();
    public static final FoodProperties LAMB_SCRAPS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat().build();
    public static final FoodProperties COOKED_LAMB_SCRAPS = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).meat().build();
    public static final FoodProperties LAMB_JERKY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat().alwaysEat().build();
}
