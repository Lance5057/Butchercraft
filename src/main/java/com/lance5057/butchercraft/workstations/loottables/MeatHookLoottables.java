package com.lance5057.butchercraft.workstations.loottables;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.items.ButchercraftItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MeatHookLoottables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

    private final ResourceLocation skinCowLootTable = new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/skin_cow");
    private final ResourceLocation deoffalCow = new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/deoffal_cow");
    private final ResourceLocation delimbCow = new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/delimb_cow");
    private final ResourceLocation butcherCow = new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/butcher_cow");

    @Override
    public void accept(BiConsumer<ResourceLocation, Builder> t) {
        // TODO Auto-generated method stub
        t.accept(this.skinCowLootTable,
                LootTable.lootTable()
                        .withPool(createPoolWithItem(Items.LEATHER)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(8f, 12f))))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ButchercraftItems.LEATHER_SCRAP.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(8, 16)))))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ButchercraftItems.FAT.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ButchercraftItems.SINEW.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12))))));
        t.accept(this.deoffalCow,
                LootTable.lootTable()
                        .withPool(createPoolWithItem(ButchercraftItems.COW_HEART.get()))
                        .withPool(createPoolWithItem(ButchercraftItems.COW_KIDNEY.get())
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))))
						.withPool(createPoolWithItem(ButchercraftItems.COW_LIVER.get()))
						.withPool(createPoolWithItem(ButchercraftItems.COW_STOMACHE.get())
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(4))))
						.withPool(createPoolWithItem(ButchercraftItems.COW_LUNG.get())
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))))
						.withPool(createPoolWithItem(ButchercraftItems.COW_TRIPE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(8)))));
		t.accept(this.delimbCow,
				LootTable.lootTable()
						.withPool(createPoolWithItem(ButchercraftItems.COW_BRAIN.get()))
						.withPool(createPoolWithItem(ButchercraftItems.COW_SKULL.get())
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
						.withPool(createPoolWithItem(ButchercraftItems.LEATHER_SCRAP.get())
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 4))))
						.withPool(createPoolWithItem(ButchercraftItems.BEEF_SCRAPS.get())
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 8))))
						.withPool(createPoolWithItem(Items.BONE)
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(4)))));
		t.accept(this.butcherCow,
				LootTable.lootTable()
						.withPool(createPoolWithItem(ButchercraftItems.BEEF_SCRAPS.get())
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 16))))
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(ButchercraftItems.BEEF_RIBS.get())
										.apply(SetItemCountFunction.setCount(ConstantValue.exactly(4)))))
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(ButchercraftItems.BEEF_ROAST.get())
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12)))))
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(ButchercraftItems.BEEF_STEW_MEAT.get())
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12)))))
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(ButchercraftItems.CUBED_BEEF.get())
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12)))))
						.withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.BEEF)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12)))))
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(Items.BONE)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 12))))));
    }

    @NotNull
    private static LootPool.Builder createPoolWithItem(Item item) {
        return LootPool.lootPool().add(LootItem.lootTableItem(item));
    }
}