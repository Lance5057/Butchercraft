package com.lance5057.butchercraft.workstations.grinder;

import com.lance5057.butchercraft.workstations.bases.recipes.EmptyInventory;

import net.minecraft.world.item.ItemStack;

public class GrinderContainer extends EmptyInventory {

	private final ItemStack insertedItem;

	public GrinderContainer(ItemStack insertedItem) {

        this.insertedItem = insertedItem;
    }

	public ItemStack getInsertedItem() {
		return insertedItem;
	}
}
