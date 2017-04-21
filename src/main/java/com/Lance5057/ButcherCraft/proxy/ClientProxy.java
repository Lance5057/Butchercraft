package com.Lance5057.ButcherCraft.proxy;

import com.Lance5057.ButcherCraft.BCBlocks;
import com.Lance5057.ButcherCraft.BCItems;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        
        BCBlocks.meatHook.initModel();
        BCBlocks.meatGrinder.initModel();
        BCBlocks.grill.initModel();
        
        registerItemRenderer(BCItems.butcherKnife, 0);
        registerItemRenderer(BCItems.skinningKnife, 0);
        registerItemRenderer(BCItems.spatula, 0);
        registerItemRenderer(BCItems.boneSaw, 0);
        registerItemRenderer(BCItems.grindTip, 0);
        registerItemRenderer(BCItems.sausageTip, 0);
        
        registerItemRenderer(BCItems.brain, 0);
        registerItemRenderer(BCItems.brainCooked, 0);
        registerItemRenderer(BCItems.heart, 0);
        registerItemRenderer(BCItems.heartCooked, 0);
        registerItemRenderer(BCItems.kidney, 0);
        registerItemRenderer(BCItems.kidneyCooked, 0);
        registerItemRenderer(BCItems.liver, 0);
		registerItemRenderer(BCItems.liverCooked, 0);
		registerItemRenderer(BCItems.lung, 0);
		registerItemRenderer(BCItems.lungCooked, 0);
		registerItemRenderer(BCItems.stomache, 0);
		registerItemRenderer(BCItems.stomacheCooked, 0);
		registerItemRenderer(BCItems.tripe, 0);
		registerItemRenderer(BCItems.tripeCooked, 0);
		
		registerItemRenderer(BCItems.stewMeat, 0);
		registerItemRenderer(BCItems.stewMeatCooked, 0);
		registerItemRenderer(BCItems.sausage, 0);
		registerItemRenderer(BCItems.sausageCooked, 0);
		registerItemRenderer(BCItems.roast, 0);
		registerItemRenderer(BCItems.roastCooked, 0);
		registerItemRenderer(BCItems.ribs, 0);
		registerItemRenderer(BCItems.ribsCooked, 0);
		registerItemRenderer(BCItems.cubedMeat, 0);
		registerItemRenderer(BCItems.cubedMeatCooked, 0);
		registerItemRenderer(BCItems.groundMeat, 0);
		registerItemRenderer(BCItems.groundMeatCooked, 0);
		registerItemRenderer(BCItems.scrapMeat, 0);
		registerItemRenderer(BCItems.scrapMeatCooked, 0);
		
		registerItemRenderer(BCItems.burgerPatty, 0);
		registerItemRenderer(BCItems.burgerPattyCooked, 0);
		registerItemRenderer(BCItems.burger, 0);
		registerItemRenderer(BCItems.kabob, 0);
		registerItemRenderer(BCItems.kabobCooked, 0);
		registerItemRenderer(BCItems.stew, 0);
		registerItemRenderer(BCItems.potRoast, 0);
		registerItemRenderer(BCItems.potRoastCooked, 0);
		registerItemRenderer(BCItems.sausageInBun, 0);
		
		registerItemRenderer(BCItems.fat, 0);
		registerItemRenderer(BCItems.leatherCord, 0);
		registerItemRenderer(BCItems.leatherScrap, 0);
		registerItemRenderer(BCItems.sinew, 0);
		
		registerItemRenderer(BCItems.cowCarcass, 0);
		
		registerBlockRenderer(BCBlocks.meatHook, 0);
		registerBlockRenderer(BCBlocks.meatGrinder, 0);
		registerBlockRenderer(BCBlocks.grill, 0);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }
    
	public void registerItemRenderer(Item item, int meta)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public void registerBlockRenderer(Block block, int meta)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Item.getItemFromBlock(block).getRegistryName(), "inventory"));
	}
}
