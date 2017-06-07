package com.Lance5057.ButcherCraft;

import com.Lance5057.ButcherCraft.core.ItemCarcass;
import com.Lance5057.ButcherCraft.core.ItemMisc;
import com.Lance5057.ButcherCraft.core.food.ItemButcherFood;
import com.Lance5057.ButcherCraft.core.tools.ItemButcherTool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
	public static ItemButcherTool grindTip;
	public static ItemButcherTool sausageTip;
	
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
		grindTip = new ItemButcherTool("grindtip");
		sausageTip = new ItemButcherTool("sausagetip");
		
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
		
		leatherScrap = new ItemMisc("leatherScrap", "string");
		leatherCord = new ItemMisc("leatherCord", "string");
		fat = new ItemMisc("fat", "slimeball");
		sinew = new ItemMisc("sinew", "string");
		
		cowCarcass  = new ItemCarcass("cowcarcass");
	}

	public void init(FMLInitializationEvent e) {
		butcherKnife.setCreativeTab(butcherTab);
		skinningKnife.setCreativeTab(butcherTab);
		boneSaw.setCreativeTab(butcherTab);
		spatula.setCreativeTab(butcherTab);
		grindTip.setCreativeTab(butcherTab);
		sausageTip.setCreativeTab(butcherTab);
		
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
		GameRegistry.addSmelting(brain, new ItemStack(brainCooked), 0F);
		GameRegistry.addSmelting(heart, new ItemStack(heartCooked), 0F);
		GameRegistry.addSmelting(kidney, new ItemStack(kidneyCooked), 0F);
		GameRegistry.addSmelting(liver, new ItemStack(liverCooked), 0F);
		GameRegistry.addSmelting(lung, new ItemStack(lungCooked), 0F);
		GameRegistry.addSmelting(stomache, new ItemStack(stomacheCooked), 0F);
		GameRegistry.addSmelting(tripe, new ItemStack(tripeCooked), 0F);
		
		GameRegistry.addSmelting(stewMeat, new ItemStack(stewMeatCooked), 0F);
		GameRegistry.addSmelting(sausage, new ItemStack(sausageCooked), 0F);
		GameRegistry.addSmelting(roast, new ItemStack(roastCooked), 0F);
		GameRegistry.addSmelting(ribs, new ItemStack(ribsCooked), 0F);
		GameRegistry.addSmelting(cubedMeat, new ItemStack(cubedMeatCooked), 0F);
		GameRegistry.addSmelting(groundMeat, new ItemStack(groundMeatCooked), 0F);
		GameRegistry.addSmelting(scrapMeat, new ItemStack(scrapMeatCooked), 0F);
		
		GameRegistry.addSmelting(burgerPatty, new ItemStack(burgerPattyCooked), 0F);
		GameRegistry.addSmelting(kabob, new ItemStack(kabobCooked), 0F);
		GameRegistry.addSmelting(potRoast, new ItemStack(potRoastCooked), 0F);
		
		GameRegistry.addShapelessRecipe(new ItemStack(this.sausageInBun,1), this.sausageCooked, Items.BREAD);
		GameRegistry.addShapelessRecipe(new ItemStack(this.burger,1), this.burgerPattyCooked, Items.BREAD);
		GameRegistry.addShapelessRecipe(new ItemStack(this.kabob,1), this.cubedMeat,this.cubedMeat, Items.CARROT,Items.POTATO, Items.STICK);
		
		GameRegistry.addRecipe(new ItemStack(this.potRoast,1),
			     "---",
			     "prc",
			     "c-p",
			     'p', Items.POTATO,
			     'c', Items.CARROT,
			     'r', this.roast
			     );
		GameRegistry.addRecipe(new ItemStack(this.stew,1),
			     "---",
			     "psm",
			     "mbp",
			     'p', Items.POTATO,
			     'm', Blocks.BROWN_MUSHROOM,
			     's', this.stewMeatCooked,
			     'b', Items.BOWL
			     );
		GameRegistry.addRecipe(new ItemStack(this.stew,1),
			     "---",
			     "psm",
			     "mbp",
			     'p', Items.POTATO,
			     'm', Blocks.RED_MUSHROOM,
			     's', this.stewMeatCooked,
			     'b', Items.BOWL
			     );

	}

}
