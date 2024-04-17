package com.lance5057.butchercraft.workstations.grinder;

import com.lance5057.butchercraft.workstations.bases.recipes.EmptyInventory;
import net.minecraft.world.item.ItemStack;

public class GrinderContainer extends EmptyInventory {

	private final ItemStack insertedItem;
	private final ItemStack attachment;

	public GrinderContainer(ItemStack insertedItem, ItemStack attachment) {

		this.insertedItem = insertedItem;
		this.attachment = attachment;
	}

	public ItemStack getInsertedItem() {
		return insertedItem;
	}
	
	public ItemStack getAttachment() {
		return attachment;
	}
}
