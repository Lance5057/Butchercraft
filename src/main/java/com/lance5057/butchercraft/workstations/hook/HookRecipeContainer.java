package com.lance5057.butchercraft.workstations.hook;

import javax.annotation.Nullable;

import api.LanceNestAPI.src.util.recipes.MultiToolRecipeWrapper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

public class HookRecipeContainer extends MultiToolRecipeWrapper {

	private final ItemStack insertedItem;
	@Nullable
	private final Entity entity;

	public HookRecipeContainer(int width, int height, IItemHandler item, ItemStack insertedItem) {
		this(width, height, item, insertedItem, null);
	}

	public HookRecipeContainer(int width, int height, IItemHandler item, ItemStack insertedItem, Entity entity) {
		super(height, height, item);
		this.insertedItem = insertedItem;
		this.entity = entity;
	}

	public ItemStack getInsertedItem() {
		return insertedItem;
	}

	public Entity getEntity() {
		return entity;
	}
}
