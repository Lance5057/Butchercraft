package com.lance5057.butchercraft;

import com.lance5057.butchercraft.loot.ButcheringKnifeModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftLootModifiers {
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, Butchercraft.MOD_ID);

    public static final RegistryObject<ButcheringKnifeModifier.Serializer> BUTCHERING_KNIFE = GLM.register("butchering_knife", ButcheringKnifeModifier.Serializer::new);

    public static void register(IEventBus bus) {
        GLM.register(bus);
    }
}
