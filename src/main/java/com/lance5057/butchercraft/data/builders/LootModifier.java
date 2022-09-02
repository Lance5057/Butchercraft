package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftLootModifiers;
import com.lance5057.butchercraft.items.ButchercraftItems;
import com.lance5057.butchercraft.loot.ButcheringKnifeModifier;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
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
						MatchTool.toolMatches(ItemPredicate.Builder.item().of(ButchercraftItems.BUTCHER_KNIFE.get())).build()},
						new ItemStack(ButchercraftItems.COW_CARCASS.get()), EntityType.COW));
    }


}
