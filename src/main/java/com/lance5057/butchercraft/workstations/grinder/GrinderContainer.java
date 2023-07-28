package com.lance5057.butchercraft.workstations.grinder;

import com.lance5057.butchercraft.workstations.bases.recipes.EmptyInventory;

import net.minecraft.world.item.ItemStack;

public class GrinderContainer extends EmptyInventory {

	private final ItemStack insertedItem;
	private final ItemStack insertedItem2;
	private final ItemStack attachment;

	public GrinderContainer(ItemStack insertedItem, ItemStack insertedItem2, ItemStack attachment) {

		this.insertedItem = insertedItem;
		this.insertedItem2 = insertedItem2;
		this.attachment = attachment;
	}

	public ItemStack getInsertedItem() {
		return insertedItem;
	}
	
	public ItemStack getInsertedItem2() {
		return insertedItem2;
	}
	
	public ItemStack getAttachment() {
		return attachment;
	}
}
