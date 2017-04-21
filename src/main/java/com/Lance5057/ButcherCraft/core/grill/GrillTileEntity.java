package com.Lance5057.ButcherCraft.core.grill;

import com.Lance5057.ButcherCraft.BCItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class GrillTileEntity extends TileEntity implements ITickable {

	private String tag = "grill";

	public int size = 4;

	public ItemStack[] food = { new ItemStack(Items.AIR), new ItemStack(Items.AIR), new ItemStack(Items.AIR),
			new ItemStack(Items.AIR) };

	public int charcoal = 0;
	public int timer = -1; // 1600

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		this.readFromNBT(packet.getNbtCompound());
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		NBTTagCompound custom = (NBTTagCompound) compound.getTag(tag);
		for (int i = 0; i < size; i++) {
			food[i] = new ItemStack(custom.getCompoundTag("food_" + i));
		}

		charcoal = custom.getInteger("charcoal");
		timer = custom.getInteger("timer");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagCompound custom = new NBTTagCompound();
		for (int i = 0; i < size; i++) {
			custom.setTag("food_" + i, food[i].serializeNBT());
		}

		custom.setInteger("charcoal", charcoal);
		custom.setInteger("timer", timer);
		compound.setTag(tag, custom);

		return compound;
	}

	public boolean doGrill(ItemStack item) {
		if (charcoal < 4 && item.getItem() == Items.COAL && item.getItemDamage() == 1) {
			charcoal++;
			return true;
		} else if (charcoal == 4 && item.getItem() == Items.FLINT_AND_STEEL && timer <= 0) {
			timer = 1600;
		}

		ItemStack result = FurnaceRecipes.instance().getSmeltingResult(item);
		if (item.getItem() instanceof ItemFood && result.getItem() != Items.AIR) {
			for (int i = 0; i < food.length; i++) {
				if (food[i].getItem() == Items.AIR) {
					food[i] = item;
					return true;
				}

			}
		}
		return false;
	}

	@Override
	public void update() {
		if (!world.isRemote) {
			if (timer > 0) {
				timer--;
				
			} else if (timer == 0) {
				for (int i = 0; i < 4; i++) {

					food[i] = FurnaceRecipes.instance().getSmeltingResult(food[i]);
					world.spawnEntity(
							new EntityItem(world, this.pos.getX(), this.pos.getY(), this.pos.getZ(), food[i]));
					food[i] = new ItemStack(Items.AIR);
				}
				timer = -1;
				charcoal = 0;

				markDirty();

				if (getWorld() != null) {
					IBlockState state = world.getBlockState(getPos());
					world.notifyBlockUpdate(getPos(), state, state, 3);
				}
			}
		}
		else
		{
			if(timer > 0)
			{
				getWorld().spawnParticle(EnumParticleTypes.FLAME,
						this.getPos().getX() + 0.2 + getWorld().rand.nextDouble() / 1.5, this.getPos().getY() + 0.75,
						this.getPos().getZ() + 0.2 + getWorld().rand.nextDouble() / 1.5, 0.0,
						getWorld().rand.nextDouble() / 100, 0.0);
			}
		}
	}
}
