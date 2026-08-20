package com.lance5057.butchercraft.workstations.bases.recipes;

import net.minecraft.world.item.ItemStack;

public class ProcessingContainer extends EmptyInventory {

	private final ItemStack insertedItem;

	public ProcessingContainer(ItemStack insertedItem) {

        this.insertedItem = insertedItem;
    }

	public ItemStack getInsertedItem() {
		return insertedItem;
	}
}
