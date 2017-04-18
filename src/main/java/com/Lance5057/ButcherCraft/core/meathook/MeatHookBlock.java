package com.Lance5057.ButcherCraft.core.meathook;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MeatHookBlock extends Block implements ITileEntityProvider {

	public MeatHookBlock(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}

}
