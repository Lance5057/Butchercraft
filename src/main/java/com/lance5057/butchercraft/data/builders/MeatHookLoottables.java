package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.items.ButchercraftItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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

import static com.lance5057.butchercraft.items.ButchercraftItems.*;
import static net.minecraft.world.item.Items.*;

public class MeatHookLoottables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

    public static final ResourceLocation SKIN_COW = new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/skin_cow");
    public static final ResourceLocation DEOFFAL_COW = new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/deoffal_cow");
    public static final ResourceLocation DELIMB_COW = new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/delimb_cow");
    public static final ResourceLocation BUTCHER_COW = new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/butcher_cow");
    public static final ResourceLocation SKIN_PIG = new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/skin_pig");
    public static final ResourceLocation DISEMBOWEL_PIG = new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/disembowel_pig");
    public static final ResourceLocation BISECT_PIG = new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/bisect_pig");
    public static final ResourceLocation BUTCHER_PIG = new ResourceLocation(Butchercraft.MOD_ID, "meat_hook/butcher_pig");

    @Override
    public void accept(BiConsumer<ResourceLocation, Builder> t) {
        t.accept(SKIN_COW,
                LootTable.lootTable()
                        .withPool(createPoolWithItem(LEATHER, 8, 12))
                        .withPool(createPoolWithItem(LEATHER_SCRAP.get(), 8, 16))
                        .withPool(createPoolWithItem(FAT.get(), 4, 12))
                        .withPool(createPoolWithItem(SINEW.get(), 4, 12)));
        t.accept(DEOFFAL_COW,
                LootTable.lootTable()
                        .withPool(createPoolWithItem(HEART.get()))
                        .withPool(createPoolWithItem(KIDNEY.get(), 2))
                        .withPool(createPoolWithItem(LIVER.get()))
                        .withPool(createPoolWithItem(STOMACHE.get(), 4))
                        .withPool(createPoolWithItem(LUNG.get(), 2))
                        .withPool(createPoolWithItem(TRIPE.get(), 8)));
        t.accept(DELIMB_COW,
                LootTable.lootTable()
                        .withPool(createPoolWithItem(BRAIN.get()))
                        .withPool(createPoolWithItem(COW_SKULL.get()))
                        .withPool(createPoolWithItem(LEATHER_SCRAP.get(), 0, 4))
                        .withPool(createPoolWithItem(BEEF_SCRAPS.get(), 0, 8))
                        .withPool(createPoolWithItem(BEEF_STEW_MEAT.get(), 24))
                        .withPool(createPoolWithItem(BONE, 4)));
        t.accept(BUTCHER_COW,
                LootTable.lootTable()
                        .withPool(createPoolWithItem(BEEF_SCRAPS.get(), 29))
                        .withPool(createPoolWithItem(BEEF_RIBS.get(), 6))
                        .withPool(createPoolWithItem(BEEF_ROAST.get(), 21))
                        .withPool(createPoolWithItem(CUBED_BEEF.get(), 9))
                        .withPool(createPoolWithItem(BEEF, 81))
                        .withPool(createPoolWithItem(BONE, 4, 12)));

        t.accept(SKIN_PIG,
                // TODO Replace with Pig Hide?
                LootTable.lootTable()
                        .withPool(createPoolWithItem(LEATHER, 8, 12))
                        .withPool(createPoolWithItem(FAT.get(), 4, 12))
                        .withPool(createPoolWithItem(SINEW.get(), 4, 12)));
        t.accept(DISEMBOWEL_PIG,
                LootTable.lootTable()
                        .withPool(createPoolWithItem(HEART.get()))
                        .withPool(createPoolWithItem(KIDNEY.get(), 2))
                        .withPool(createPoolWithItem(LIVER.get()))
                        .withPool(createPoolWithItem(STOMACHE.get()))
                        .withPool(createPoolWithItem(LUNG.get(), 2))
                        .withPool(createPoolWithItem(TRIPE.get(), 8))
                        .withPool(createPoolWithItem(SINEW.get(), 4, 12)));
        t.accept(BISECT_PIG,
                LootTable.lootTable()
                        .withPool(createPoolWithItem(ButchercraftItems.PIG_HOOVES.get()))
                        .withPool(createPoolWithItem(SINEW.get(), 0, 8))
                        .withPool(createPoolWithItem(PORK_STEW_MEAT.get(), 10))
                        .withPool(createPoolWithItem(BONE, 4)));
        t.accept(BUTCHER_PIG,
                LootTable.lootTable()
                        .withPool(createPoolWithItem(PORK_SCRAPS.get(), 10))
                        .withPool(createPoolWithItem(PORK_RIBS.get(), 6))
                        .withPool(createPoolWithItem(PORK_ROAST.get(), 10))
                        .withPool(createPoolWithItem(CUBED_PORK.get(), 4))
                        .withPool(createPoolWithItem(BACON.get(), 11))
                        .withPool(createPoolWithItem(PORKCHOP, 14))
                        .withPool(createPoolWithItem(BONE, 12)));

    }

    @NotNull
    private static LootPool.Builder createPoolWithItem(Item item, int count) {
        return LootPool.lootPool().add(LootItem.lootTableItem(item)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(count)));
    }

    @NotNull
    private static LootPool.Builder createPoolWithItem(Item item, int min, int max) {
        return LootPool.lootPool().add(LootItem.lootTableItem(item)).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)));
    }

    @NotNull
    private static LootPool.Builder createPoolWithItem(Item item) {
        return LootPool.lootPool().add(LootItem.lootTableItem(item));
    }
}