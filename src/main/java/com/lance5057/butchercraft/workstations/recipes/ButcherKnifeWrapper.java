package com.lance5057.butchercraft.workstations.recipes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.crafting.Ingredient;

public class ButcherKnifeWrapper extends EmptyInventory {

    protected EntityType<?> entity;
    protected Ingredient tool;

    public ButcherKnifeWrapper(Ingredient tool, EntityType<?> entity) {
        this.tool = tool;
        this.entity = entity;
    }

    public EntityType getEntity() {
        return entity;
    }

    public Ingredient getTool() {
        return tool;
    }

}
