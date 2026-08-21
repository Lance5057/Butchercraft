package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.butcherblock.ButcherBlockRecipe;
import com.lance5057.butchercraft.workstations.grinder.GrinderRecipe;
import com.lance5057.butchercraft.workstations.hook.HookRecipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ButchercraftRecipes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister
			.create(Registries.RECIPE_TYPE, Butchercraft.MOD_ID);
	public static final DeferredHolder<RecipeType<?>, RecipeType<HookRecipe>> HOOK = createRecipeType("meat_hook");

	public static final DeferredHolder<RecipeType<?>, RecipeType<ButcherBlockRecipe>> BUTCHER_BLOCK = createRecipeType(
			"butcher_block");

	public static final DeferredHolder<RecipeType<?>, RecipeType<GrinderRecipe>> GRINDER = createRecipeType("grinder");

	private static <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> createRecipeType(String name) {
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
