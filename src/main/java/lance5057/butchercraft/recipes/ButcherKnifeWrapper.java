package lance5057.butchercraft.recipes;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ButcherKnifeWrapper implements IInventory {

    protected MobEntity entity;
    protected ItemStack tool;

    public ButcherKnifeWrapper(ItemStack tool, MobEntity entity) {
	this.tool = tool;
	this.entity = entity;
    }
    
    public MobEntity getEntity()
    {
	return entity;
    }
    
    public ItemStack getTool()
    {
	return tool;
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
    public boolean stillValid(PlayerEntity p_70300_1_) {
	// TODO Auto-generated method stub
	return false;
    }

}
