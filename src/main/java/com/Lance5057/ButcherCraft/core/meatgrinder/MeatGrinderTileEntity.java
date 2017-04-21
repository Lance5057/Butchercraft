package com.Lance5057.ButcherCraft.core.meatgrinder;

import com.Lance5057.ButcherCraft.BCItems;
import com.Lance5057.ButcherCraft.core.food.ItemButcherFood;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MeatGrinderTileEntity extends TileEntity {

	private String tag = "grinder";
	public String extruderTag = "extruderItem"; // none, sausage, grind
	public ItemStack extruderItem = new ItemStack(Items.AIR);
	public boolean loaded = false;
	public boolean casing = false;
	public String grindItemTag = "grindItem";
	public ItemStack grindItem = new ItemStack(Items.AIR);
	public float handleRot = 0.0F;

	public int completion = 0; // 100 max

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
		extruderItem = new ItemStack(custom.getCompoundTag(extruderTag));
		loaded = custom.getBoolean("loaded");
		casing = custom.getBoolean("casing");
		handleRot = custom.getFloat("handleRot");
		completion = custom.getInteger("completion");
		grindItem = new ItemStack(custom.getCompoundTag(grindItemTag));
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagCompound custom = new NBTTagCompound();
		custom.setTag(extruderTag, extruderItem.serializeNBT());
		custom.setBoolean("loaded", loaded);
		custom.setBoolean("casing", casing);
		custom.setFloat("handleRot", handleRot);
		custom.setInteger("completion", completion);
		custom.setTag(grindItemTag, grindItem.serializeNBT());
		compound.setTag(tag, custom);

		return compound;
	}

	public boolean doGrind(ItemStack item) {
		if (!loaded) {
			if (item.getItem() == BCItems.grindTip) {
				loaded = true;
				extruderItem = item;
				return true;
			}

			if (item.getItem() == BCItems.sausageTip) {
				loaded = true;
				extruderItem = item;
				return true;
			}
		}

		if (loaded) {
			if (handleRot == 0) {
				
				
				if (extruderItem.getItem() == BCItems.grindTip) {
					if(grindItem.getItem() != Items.AIR)
					{
						completion += world.rand.nextInt(20) + 20;
						handleRot = 1;
						if (completion >= 100) {
							completion = 0;
							world.spawnEntity(new EntityItem(world, this.pos.getX(), this.pos.getY(), this.pos.getZ(),
									new ItemStack(BCItems.groundMeat, 1)));
							casing = false;
							grindItem = new ItemStack(Items.AIR);
							handleRot=0;
							return true;
						}
					}
				}

				if (extruderItem.getItem() == BCItems.sausageTip) {
					if (item.getItem() == BCItems.tripe) {
						casing = true;
						return true;
					}

					else if (casing && grindItem.getItem() != Items.AIR) {
						completion += world.rand.nextInt(20) + 20;
						handleRot = 1;
						if (completion >= 100) {
							completion = 0;
							world.spawnEntity(new EntityItem(world, this.pos.getX(), this.pos.getY(), this.pos.getZ(),
									new ItemStack(BCItems.sausage, 1)));
							casing = false;
							grindItem = new ItemStack(Items.AIR);
							handleRot=0;
							return true;
						}
					}
				}
				
				
			}
			 else {
					handleRot += 15;
					if (handleRot >= 360)
						handleRot = 0;
					
					return false;
				}
		}
		
		if(grindItem.getItem() == Items.AIR && (item.getItem() instanceof ItemButcherFood || item.getItem() == Items.BEEF))
		{
			grindItem = item;
			return true;
		}
		
		if(loaded && grindItem.getItem() == Items.AIR && !casing)
		{
			world.spawnEntity(new EntityItem(world, this.pos.getX(), this.pos.getY(), this.pos.getZ(),
					extruderItem));
			extruderItem = new ItemStack(Items.AIR);
			loaded = false;
		}

		
		return false;
	}
}
