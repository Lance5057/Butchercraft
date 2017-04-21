package com.Lance5057.ButcherCraft.core.grill;

import com.Lance5057.ButcherCraft.Butchercraft;
import com.Lance5057.ButcherCraft.core.ItemCarcass;
import com.Lance5057.ButcherCraft.core.meatgrinder.MeatGrinderTileEntity;
import com.Lance5057.ButcherCraft.core.tools.ItemButcherTool;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GrillBlock extends Block implements ITileEntityProvider {

	public GrillBlock(Material materialIn) {
		super(materialIn);
		setUnlocalizedName(Butchercraft.MODID + ".grillblock");
		setRegistryName("grillblock");
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		GameRegistry.registerTileEntity(GrillTileEntity.class, Butchercraft.MODID + "_grillblock");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new GrillTileEntity();
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ClientRegistry.bindTileEntitySpecialRenderer(GrillTileEntity.class, new GrillTESR());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		return false;
	}

	@Override
	public boolean isBlockNormalCube(IBlockState blockState) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState blockState) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(pos);
			if (te instanceof GrillTileEntity) {
				GrillTileEntity grinder = (GrillTileEntity) te;
				ItemStack item = player.getHeldItem(hand);
				if (grinder.doGrill(item)) {
					int stackSize = item.getCount()-1;
					if(stackSize > 0)
						item.setCount(stackSize);
					else
						item = new ItemStack(Items.AIR);
					
					player.inventory.setInventorySlotContents(player.inventory.currentItem, item);
					player.openContainer.detectAndSendChanges();
				}
				
				te.markDirty();

				if (te.getWorld() != null) {
					IBlockState bState = world.getBlockState(te.getPos());
					world.notifyBlockUpdate(te.getPos(), bState, bState, 3);
				}
			}
		}
		return true;
	}

}
