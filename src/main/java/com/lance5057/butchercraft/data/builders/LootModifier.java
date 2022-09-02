package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftLootModifiers;
import com.lance5057.butchercraft.items.ButchercraftItems;
import com.lance5057.butchercraft.loot.ButcheringKnifeModifier;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifier extends GlobalLootModifierProvider {

    public LootModifier(DataGenerator gen) {
        super(gen, Butchercraft.MOD_ID);
    }

    @Override
    protected void start() {
        add("butcher_cow",
				ButchercraftLootModifiers.BUTCHERING_KNIFE.get(),
				new ButcheringKnifeModifier(new LootItemCondition[]{

                        LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().of(EntityType.COW)).build(),
						LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.KILLER, EntityPredicate.Builder.entity().equipment(new EntityEquipmentPredicate(ItemPredicate.ANY, ItemPredicate.ANY, ItemPredicate.ANY, ItemPredicate.ANY, ItemPredicate.Builder.item().of(ButchercraftItems.BUTCHER_KNIFE.get()).build(), ItemPredicate.ANY))).build()},
						new ItemStack(ButchercraftItems.COW_CARCASS.get()), EntityType.COW));
    }


}
