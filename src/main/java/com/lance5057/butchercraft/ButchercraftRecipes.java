package com.lance5057.butchercraft;

import com.lance5057.butchercraft.recipes.ButcherKnifeRecipe;
import com.lance5057.butchercraft.workstations.recipes.HookRecipe;
import com.lance5057.butchercraft.workstations.recipes.HookRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftRecipes {
    public static final RecipeType<HookRecipe> HOOK = RecipeType.register("recipe_hook");
    public static final RecipeType<ButcherKnifeRecipe> KNIFE = RecipeType.register("recipe_knife");
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister
            .create(ForgeRegistries.RECIPE_SERIALIZERS, Butchercraft.MOD_ID);
    public static final RegistryObject<RecipeSerializer<HookRecipe>> HOOK_SERIALIZER = RECIPE_SERIALIZERS
            .register("hook_serializer", HookRecipeSerializer::new);
}
