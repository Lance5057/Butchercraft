package com.lance5057.butchercraft;

import com.lance5057.butchercraft.recipes.ButcherKnifeRecipe;
import com.lance5057.butchercraft.workstations.recipes.HookRecipe;
import net.minecraft.world.item.crafting.RecipeType;

public class ButchercraftRecipes {
    public static final RecipeType<HookRecipe> HOOK = RecipeType.register("recipe_hook");
    public static final RecipeType<ButcherKnifeRecipe> KNIFE = RecipeType.register("recipe_knife");
}
