package com.lance5057.butchercraft.workstations.recipes;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;

public class HookRecipeWrapper implements Container {

    protected final IItemHandlerModifiable inv;

    public HookRecipeWrapper(IItemHandlerModifiable i) {
        this.inv = i;
    }

    @Override
    public void clearContent() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getContainerSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ItemStack getItem(int p_70301_1_) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_70304_1_) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setItem(int p_70299_1_, ItemStack p_70299_2_) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setChanged() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean stillValid(Player p_70300_1_) {
        // TODO Auto-generated method stub
        return false;
    }

}
