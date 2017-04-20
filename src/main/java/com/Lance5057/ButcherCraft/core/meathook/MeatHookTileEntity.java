package com.Lance5057.ButcherCraft.core.meathook;

import com.Lance5057.ButcherCraft.BCItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class MeatHookTileEntity extends TileEntity {

	private String tag = "carcass";
	public String carcassType = "none";
	public int curStage = 0; // "start", "skinning", "deoffal", "delimb",
								// "butcher"};

	public int completion = 0; // 100 max

	public int completionRate = 25;

	public void addCarcass(Item carcass) {
		if (carcass == BCItems.cowCarcass)
			carcassType = "cow";

		curStage = 0;
		markDirty();

		if (this.world != null) {
			IBlockState state = world.getBlockState(getPos());
			world.notifyBlockUpdate(getPos(), state, state, 3);
		}
	}

	public void useTool(Item tool, EntityPlayer player) {
		if (carcassType != "none") {
			switch (curStage) {
			case 0:
				int leather = world.rand.nextInt(4) + 8;
				int scrap = leather - 16 * 2;
				stageProgression(player, tool, BCItems.skinningKnife, "te.meathook.skinningMessage",
						new ItemStack(Items.LEATHER, leather),
						new ItemStack(BCItems.leatherScrap, scrap),
						new ItemStack(BCItems.fat, world.rand.nextInt(8)+4),
						new ItemStack(BCItems.sinew, world.rand.nextInt(8)+4));
				break;

			case 1:
				stageProgression(player, tool, Items.AIR, "te.meathook.deoffalMessage",
						new ItemStack(BCItems.heart, 1),
						new ItemStack(BCItems.kidney, 2),
						new ItemStack(BCItems.liver, 1),
						new ItemStack(BCItems.stomache, 4),
						new ItemStack(BCItems.lung, 2),
						new ItemStack(BCItems.tripe, 8));
				break;
				
			case 2:
				stageProgression(player, tool, BCItems.boneSaw, "te.meathook.delimbMessage",
						new ItemStack(BCItems.brain, 1),
						new ItemStack(Blocks.SKULL, 1),
						new ItemStack(BCItems.leatherScrap, world.rand.nextInt(4)),
						new ItemStack(BCItems.scrapMeat, world.rand.nextInt(8)),
						new ItemStack(Items.BONE, 4));
				break;
				
			case 3:
				stageProgression(player, tool, BCItems.butcherKnife, "te.meathook.butcherMessage",
						new ItemStack(BCItems.scrapMeat, world.rand.nextInt(16)),
						new ItemStack(BCItems.ribs, 4),
						new ItemStack(BCItems.roast, world.rand.nextInt(8)+4),
						new ItemStack(BCItems.stewMeat, world.rand.nextInt(8)+4),
						new ItemStack(BCItems.cubedMeat, world.rand.nextInt(8)+4),
						new ItemStack(Items.BEEF, world.rand.nextInt(8)+4),
						new ItemStack(Items.BONE, world.rand.nextInt(8)+8));
				break;
			}
		}
		markDirty();

		if (this.world != null) {
			IBlockState state = world.getBlockState(getPos());
			world.notifyBlockUpdate(getPos(), state, state, 3);
		}
	}

	private void stageProgression(EntityPlayer player, Item curTool, Item reqTool, String message,
			ItemStack... returns) {
		if (curTool == reqTool) {
			completion = completion + completionRate + this.world.rand.nextInt(completionRate);

			if (completion >= 100) {
				completion = 0;
				curStage++;

				for (int i = 0; i < returns.length; i++)
					world.spawnEntity(
							new EntityItem(world, this.pos.getX(), this.pos.getY(), this.pos.getZ(), returns[i]));
				
				if(curStage > 3)
				{
					curStage = 0;
					carcassType = "none";
				}
			}
		} else {
			player.sendMessage(new TextComponentTranslation(message));
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

		NBTTagCompound custom = (NBTTagCompound) compound.getTag(tag);
		carcassType = custom.getString("carcassType");
		curStage = custom.getInteger("stage");
		completion = custom.getInteger("completion");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagCompound custom = new NBTTagCompound();
		custom.setString("carcassType", carcassType);
		custom.setInteger("stage", curStage);
		custom.setInteger("completion", completion);
		compound.setTag(tag, custom);

		return compound;
	}
}
