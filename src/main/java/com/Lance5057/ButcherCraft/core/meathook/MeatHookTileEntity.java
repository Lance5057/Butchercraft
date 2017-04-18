package com.Lance5057.ButcherCraft.core.meathook;

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

public class MeatHookTileEntity extends TileEntity {

	private ItemStack stack;
	private String tag = "carcass";

	public ItemStack getStack() {
		return stack;
	}

	public void setStack(ItemStack stack) {
		this.stack = stack;
		markDirty();
		World world = Minecraft.getMinecraft().world;
		if (world != null) {
			IBlockState state = world.getBlockState(getPos());
			world.notifyBlockUpdate(getPos(), state, state, 3);
		}
	}

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
		if (compound.hasKey(tag)) {
			stack = new ItemStack(compound.getCompoundTag(tag));
		} else {
			stack = null;
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		if (stack != null) {
			NBTTagCompound tagCompound = new NBTTagCompound();
			stack.writeToNBT(tagCompound);
			compound.setTag(tag, tagCompound);
		}
		return compound;
	}
}
