package com.lance5057.butchercraft;

import com.mojang.serialization.Codec;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ButchercraftLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Butchercraft.MOD_ID);

    public static void register(IEventBus bus) {
        GLM.register(bus);
    }
}
