package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.items.ButchercraftItems;
import com.lance5057.butchercraft.loot.ButcheringKnifeModifier;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifier extends GlobalLootModifierProvider {

	public LootModifier(DataGenerator gen, String modid) {
		super(gen, modid);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void start() {
		add("butcherknife",
				new ButcheringKnifeModifier(new LootItemCondition[] { MatchTool
						.toolMatches(ItemPredicate.Builder.item().of(ButchercraftItems.BUTCHER_KNIFE.get())).build() },
						ButchercraftItems.COW_CARCASS.get(), 1, EntityType.COW));
	}
}
