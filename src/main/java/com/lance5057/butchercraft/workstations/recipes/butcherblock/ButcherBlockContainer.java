package com.lance5057.butchercraft.workstations.recipes.butcherblock;

import com.lance5057.butchercraft.workstations.recipes.EmptyInventory;

import net.minecraft.world.item.ItemStack;

public class ButcherBlockContainer extends EmptyInventory {

	private final ItemStack insertedItem;

	public ButcherBlockContainer(ItemStack insertedItem) {

        this.insertedItem = insertedItem;
    }

	public ItemStack getInsertedItem() {
		return insertedItem;
	}
}
