package com.lance5057.butchercraft.workstations.recipes.meathook;

import com.lance5057.butchercraft.workstations.recipes.EmptyInventory;

import net.minecraft.world.item.ItemStack;

public class HookRecipeContainer extends EmptyInventory {

    private final ItemStack insertedItem;

    public HookRecipeContainer(ItemStack insertedItem) {

        this.insertedItem = insertedItem;
    }

    public ItemStack getInsertedItem() {
        return insertedItem;
    }
}
