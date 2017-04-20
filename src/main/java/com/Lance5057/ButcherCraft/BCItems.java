package com.Lance5057.ButcherCraft;

import com.Lance5057.ButcherCraft.core.ItemCarcass;
import com.Lance5057.ButcherCraft.core.ItemMisc;
import com.Lance5057.ButcherCraft.core.food.ItemButcherFood;
import com.Lance5057.ButcherCraft.core.tools.ItemButcherTool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BCItems {

	public static final CreativeTabs butcherTab = new CreativeTabs("butchercraft.items") {
	    @Override public ItemStack getTabIconItem() {
	        return new ItemStack(Items.COOKED_BEEF);
	    }
	};
	
	//Tools
	public static ItemButcherTool butcherKnife;
	public static ItemButcherTool skinningKnife;
	public static ItemButcherTool boneSaw;
	public static ItemButcherTool spatula;
	
	//Organs
	public static ItemButcherFood brain;
	public static ItemButcherFood brainCooked;
	public static ItemButcherFood heart;
	public static ItemButcherFood heartCooked;
	public static ItemButcherFood kidney;
	public static ItemButcherFood kidneyCooked;
	public static ItemButcherFood liver;
	public static ItemButcherFood liverCooked;
	public static ItemButcherFood lung;
	public static ItemButcherFood lungCooked;
	public static ItemButcherFood stomache;
	public static ItemButcherFood stomacheCooked;
	public static ItemButcherFood tripe;
	public static ItemButcherFood tripeCooked;
	
	//Meat
	public static ItemButcherFood stewMeat;
	public static ItemButcherFood stewMeatCooked;
	public static ItemButcherFood sausage;
	public static ItemButcherFood sausageCooked;
	public static ItemButcherFood roast;
	public static ItemButcherFood roastCooked;
	public static ItemButcherFood ribs;
	public static ItemButcherFood ribsCooked;
	public static ItemButcherFood cubedMeat;
	public static ItemButcherFood cubedMeatCooked;
	public static ItemButcherFood groundMeat;
	public static ItemButcherFood groundMeatCooked;
	public static ItemButcherFood scrapMeat;
	public static ItemButcherFood scrapMeatCooked;
	
	//Food
	public static ItemButcherFood burgerPatty;
	public static ItemButcherFood burgerPattyCooked;
	public static ItemButcherFood burger;
	public static ItemButcherFood kabob;
	public static ItemButcherFood kabobCooked;
	public static ItemButcherFood stew;
	public static ItemButcherFood potRoast;
	public static ItemButcherFood potRoastCooked;
	public static ItemButcherFood sausageInBun;
	
	//Misc
	public static ItemMisc leatherScrap;
	public static ItemMisc leatherCord;
	public static ItemMisc fat;
	public static ItemMisc sinew;
	
	//Carcasses
	public static Item cowCarcass;
	
	public void preInit(FMLPreInitializationEvent e) {
		butcherKnife = new ItemButcherTool("butcherknife");
		skinningKnife = new ItemButcherTool("skinningknife");
		boneSaw = new ItemButcherTool("bonesaw");
		spatula = new ItemButcherTool("spatula");
		
		brain = new ItemButcherFood(3, 0.1F, true, false, "brain");
		brainCooked = new ItemButcherFood(4, 0.2F, true, true, "braincooked");
		heart = new ItemButcherFood(3, 0.1F, true, false, "heart");
		heartCooked = new ItemButcherFood(6, 0.2F, true, true, "heartCooked");
		kidney = new ItemButcherFood(1, 0.1F, true, false, "kidney");
		kidneyCooked = new ItemButcherFood(2, 0.2F, true, true, "kidneyCooked");
		liver = new ItemButcherFood(3, 0.2F, true, false, "liver");
		liverCooked = new ItemButcherFood(6, 0.4F, true, true, "liverCooked");
		lung = new ItemButcherFood(4, 0.2F, true, false, "lung");
		lungCooked = new ItemButcherFood(8, 0.4F, true, true, "lungCooked");
		stomache = new ItemButcherFood(2, 0.1F, true, false, "stomache");
		stomacheCooked = new ItemButcherFood(4, 0.2F, true, true, "stomacheCooked");
		tripe = new ItemButcherFood(3, 0.1F, true, false, "tripe");
		tripeCooked = new ItemButcherFood(6, 0.2F, true, true, "tripeCooked");
		
		stewMeat = new ItemButcherFood(6, 0.2F, true, true, "stewMeat");
		stewMeatCooked = new ItemButcherFood(6, 0.2F, true, true, "stewMeatCooked");
		sausage = new ItemButcherFood(6, 0.2F, true, true, "sausage");
		sausageCooked = new ItemButcherFood(6, 0.2F, true, true, "sausageCooked");
		roast = new ItemButcherFood(6, 0.2F, true, true, "roast");
		roastCooked = new ItemButcherFood(6, 0.2F, true, true, "roastCooked");
		ribs = new ItemButcherFood(6, 0.2F, true, true, "ribs");
		ribsCooked = new ItemButcherFood(6, 0.2F, true, true, "ribsCooked");
		cubedMeat = new ItemButcherFood(6, 0.2F, true, true, "cubedMeat");
		cubedMeatCooked = new ItemButcherFood(6, 0.2F, true, true, "cubedMeatCooked");
		groundMeat = new ItemButcherFood(6, 0.2F, true, true, "groundMeat");
		groundMeatCooked = new ItemButcherFood(6, 0.2F, true, true, "groundMeatCooked");
		scrapMeat = new ItemButcherFood(6, 0.2F, true, true, "scrapMeat");
		scrapMeatCooked = new ItemButcherFood(6, 0.2F, true, true, "scrapMeatCooked");
		
		burgerPatty = new ItemButcherFood(6, 0.2F, true, false, "burgerPatty");
		burgerPattyCooked = new ItemButcherFood(6, 0.2F, true, true, "burgerPattyCooked");
		burger = new ItemButcherFood(6, 0.2F, true, true, "burger");
		kabob = new ItemButcherFood(6, 0.2F, false, false, "kabob");
		kabobCooked = new ItemButcherFood(6, 0.2F, false, true, "kabobCooked");
		stew = new ItemButcherFood(6, 0.2F, false, true, "stew");
		potRoast = new ItemButcherFood(6, 0.2F, false, false, "potRoast");
		potRoastCooked = new ItemButcherFood(6, 0.2F, false, true, "potRoastCooked");
		sausageInBun = new ItemButcherFood(6, 0.2F, false, true, "sausageInBun");
		
		leatherScrap = new ItemMisc("leatherScrap", "itemString");
		leatherCord = new ItemMisc("leatherCord", "itemString");
		fat = new ItemMisc("fat", "slimeball");
		sinew = new ItemMisc("sinew", "itemString");
		
		cowCarcass  = new ItemCarcass("cowcarcass");
	}

	public void init(FMLInitializationEvent e) {
		butcherKnife.setCreativeTab(butcherTab);
		skinningKnife.setCreativeTab(butcherTab);
		boneSaw.setCreativeTab(butcherTab);
		spatula.setCreativeTab(butcherTab);
		
		brain.setCreativeTab(butcherTab);
		brainCooked.setCreativeTab(butcherTab);
		heart.setCreativeTab(butcherTab);
		heartCooked.setCreativeTab(butcherTab);
		kidney.setCreativeTab(butcherTab);
		kidneyCooked.setCreativeTab(butcherTab);
		liver.setCreativeTab(butcherTab);
		liverCooked.setCreativeTab(butcherTab);
		lung.setCreativeTab(butcherTab);
		lungCooked.setCreativeTab(butcherTab);
		stomache.setCreativeTab(butcherTab);
		stomacheCooked.setCreativeTab(butcherTab);
		tripe.setCreativeTab(butcherTab);
		tripeCooked.setCreativeTab(butcherTab);
		
		stewMeat.setCreativeTab(butcherTab);
		stewMeatCooked.setCreativeTab(butcherTab);
		sausage.setCreativeTab(butcherTab);
		sausageCooked.setCreativeTab(butcherTab);
		roast.setCreativeTab(butcherTab);
		roastCooked.setCreativeTab(butcherTab);
		ribs.setCreativeTab(butcherTab);
		ribsCooked.setCreativeTab(butcherTab);
		cubedMeat.setCreativeTab(butcherTab);
		cubedMeatCooked.setCreativeTab(butcherTab);
		groundMeat.setCreativeTab(butcherTab);
		groundMeatCooked.setCreativeTab(butcherTab);
		scrapMeat.setCreativeTab(butcherTab);
		scrapMeatCooked.setCreativeTab(butcherTab);
		
		burgerPatty.setCreativeTab(butcherTab);
		burgerPattyCooked.setCreativeTab(butcherTab);
		burger.setCreativeTab(butcherTab);
		kabob.setCreativeTab(butcherTab);
		kabobCooked.setCreativeTab(butcherTab);
		stew.setCreativeTab(butcherTab);
		potRoast.setCreativeTab(butcherTab);
		potRoastCooked.setCreativeTab(butcherTab);
		sausageInBun.setCreativeTab(butcherTab);
		
		leatherScrap.setCreativeTab(butcherTab);
		leatherCord.setCreativeTab(butcherTab);
		fat.setCreativeTab(butcherTab);
		sinew.setCreativeTab(butcherTab);
		
		cowCarcass.setCreativeTab(butcherTab);
	}

	public void postInit(FMLPostInitializationEvent e) {

	}

}
