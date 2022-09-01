package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.recipes.ButcherKnifeRecipe;
import com.lance5057.butchercraft.workstations.recipes.ButcherKnifeRecipeSerializer;
import com.lance5057.butchercraft.workstations.recipes.HookRecipe;
import com.lance5057.butchercraft.workstations.recipes.HookRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftRecipeSerializers {
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister
            .create(ForgeRegistries.RECIPE_SERIALIZERS, Butchercraft.MOD_ID);
    public static final RegistryObject<RecipeSerializer<HookRecipe>> HOOK_SERIALIZER = RECIPE_SERIALIZERS
            .register("meat_hook", HookRecipeSerializer::new);
    public static final RegistryObject<RecipeSerializer<ButcherKnifeRecipe>> BUTCHER_KNIFE_SERIALIZER = RECIPE_SERIALIZERS.register("butcher_knife", ButcherKnifeRecipeSerializer::new);

    public static void register(IEventBus modBus) {
        RECIPE_SERIALIZERS.register(modBus);
    }
}
