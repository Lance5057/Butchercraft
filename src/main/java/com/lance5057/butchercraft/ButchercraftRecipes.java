package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.recipes.dryingrack.DryingRackRecipe;
import com.lance5057.butchercraft.workstations.recipes.meathook.HookRecipe;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, Butchercraft.MOD_ID);
    public static final RegistryObject<RecipeType<HookRecipe>> HOOK = createRecipeType("meat_hook");
	public static final RegistryObject<RecipeType<DryingRackRecipe>> DRYING_RACK = createRecipeType("drying_rack");

    private static <T extends Recipe<?>> RegistryObject<RecipeType<T>> createRecipeType(String name) {
        return RECIPE_TYPES.register(name, () -> new RecipeType<T>() {
            @Override()
            public String toString() {
                return name;
            }
        });
    }

    public static void register(IEventBus modBus) {
        RECIPE_TYPES.register(modBus);
    }
}
