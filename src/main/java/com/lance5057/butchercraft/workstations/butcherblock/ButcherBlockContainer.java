package com.lance5057.butchercraft.workstations.butcherblock;

import com.lance5057.butchercraft.workstations.bases.recipes.EmptyInventory;

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
