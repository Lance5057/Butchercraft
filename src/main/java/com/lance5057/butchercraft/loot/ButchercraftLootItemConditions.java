package com.lance5057.butchercraft.loot;

import com.lance5057.butchercraft.Butchercraft;
import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.DeferredRegister;

public class ButchercraftLootItemConditions {
    private static final DeferredRegister<LootItemConditionType> LOOT_ITEM_CONDITIONS = DeferredRegister.create(Registry.LOOT_CONDITION_TYPE.key(), Butchercraft.MOD_ID);
}
