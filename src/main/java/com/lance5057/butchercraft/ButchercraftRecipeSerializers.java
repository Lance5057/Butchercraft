package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.butcherblock.ButcherBlockSerializer;
import com.lance5057.butchercraft.workstations.grinder.GrinderRecipeSerializer;
import com.lance5057.butchercraft.workstations.hook.HookRecipe;
import com.lance5057.butchercraft.workstations.hook.HookRecipeSerializer;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ButchercraftRecipeSerializers {
	private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister
			.create(Registries.RECIPE_SERIALIZER, Butchercraft.MOD_ID);

	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<HookRecipe>> HOOK_SERIALIZER = RECIPE_SERIALIZERS
			.register("meat_hook", HookRecipeSerializer::new);

	public static final DeferredHolder<RecipeSerializer<?>, ButcherBlockSerializer> BUTCHER_BLOCK_SERIALIZER = RECIPE_SERIALIZERS
			.register("butcher_block", ButcherBlockSerializer::new);

	public static final DeferredHolder<RecipeSerializer<?>, GrinderRecipeSerializer> GRINDER_SERIALIZER = RECIPE_SERIALIZERS
			.register("grinder", GrinderRecipeSerializer::new);

	public static void register(IEventBus modBus) {
		RECIPE_SERIALIZERS.register(modBus);
	}
}
