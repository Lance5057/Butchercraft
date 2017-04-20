package com.Lance5057.ButcherCraft.core.meatgrinder;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MeatGrinderTileEntity extends TileEntity {

	private String tag = "carcass";
	public String carcassType = "cow";
	public String stage = "skinning";
	public int completion = 0; //100 max

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
		carcassType = custom.getString("carcassType");
		stage = custom.getString("stage");
		completion = custom.getInteger("completion");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		NBTTagCompound custom = new NBTTagCompound();
		custom.setString("carcassType", carcassType);
		custom.setString("stage", stage);
		custom.setInteger("completion", completion);
		compound.setTag(tag, custom);
		
		return compound;
	}
}
