package com.lance5057.butchercraft.items;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftBlocks;
import com.lance5057.butchercraft.animals.cow.FoodsCow;
import com.lance5057.butchercraft.animals.cow.FoodsGeneric;
import com.lance5057.butchercraft.animals.cow.FoodsPig;
import com.lance5057.butchercraft.animals.cow.FoodsSheep;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Butchercraft.MOD_ID);

	public static final CreativeModeTab BUTCHER_TAB = new CreativeModeTab("butchercraft.items") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ButchercraftItems.BUTCHER_KNIFE.get());
		}
	};

	// BEEF
	public static final RegistryObject<Item> COOKED_BEEF_SCRAPS = ITEMS.register("cooked_beef_scraps",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.COOKED_BEEF_SCRAPS)));
	public static final RegistryObject<Item> BEEF_SCRAPS = ITEMS.register("beef_scraps",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.BEEF_SCRAPS)));
	public static final RegistryObject<Item> COOKED_GROUND_BEEF = ITEMS.register("cooked_ground_beef",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.COOKED_GROUND_BEEF)));
	public static final RegistryObject<Item> GROUND_BEEF = ITEMS.register("ground_beef",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.GROUND_BEEF)));
	public static final RegistryObject<Item> COOKED_CUBED_BEEF = ITEMS.register("cooked_cubed_beef",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.COOKED_CUBED_BEEF)));
	public static final RegistryObject<Item> CUBED_BEEF = ITEMS.register("cubed_beef",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.CUBED_BEEF)));
	public static final RegistryObject<Item> COOKED_BEEF_RIBS = ITEMS.register("cooked_beef_ribs",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.COOKED_BEEF_RIBS)));
	public static final RegistryObject<Item> BEEF_RIBS = ITEMS.register("beef_ribs",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.BEEF_RIBS)));
	public static final RegistryObject<Item> COOKED_BEEF_RIB = ITEMS.register("cooked_beef_rib",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.COOKED_BEEF_RIB)));
	public static final RegistryObject<Item> BEEF_RIB = ITEMS.register("beef_rib",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.BEEF_RIB)));
	public static final RegistryObject<Item> COOKED_BEEF_ROAST = ITEMS.register("cooked_beef_roast",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.COOKED_ROAST)));
	public static final RegistryObject<Item> BEEF_ROAST = ITEMS.register("beef_roast",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.ROAST)));
	public static final RegistryObject<Item> COOKED_BEEF_STEW_MEAT = ITEMS.register("cooked_beef_stewmeat",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.COOKED_BEEF_STEWMEAT)));
	public static final RegistryObject<Item> BEEF_STEW_MEAT = ITEMS.register("beef_stewmeat",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.BEEF_STEWMEAT)));
	public static final RegistryObject<Item> OXTAIL = ITEMS.register("oxtail",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.OXTAIL)));
	public static final RegistryObject<Item> COOKED_OXTAIL = ITEMS.register("cooked_oxtail",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.COOKED_OXTAIL)));
	public static final RegistryObject<Item> BEEF_TONGUE = ITEMS.register("tongue",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.BEEF_TONGUE)));
	public static final RegistryObject<Item> COOKED_BEEF_TONGUE = ITEMS.register("cooked_tongue",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.COOKED_BEEF_TONGUE)));
	
	// PORK
	public static final RegistryObject<Item> COOKED_PORK_SCRAPS = ITEMS.register("cooked_pork_scraps",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.COOKED_PORK_SCRAPS)));
	public static final RegistryObject<Item> PORK_SCRAPS = ITEMS.register("pork_scraps",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.PORK_SCRAPS)));
	public static final RegistryObject<Item> COOKED_GROUND_PORK = ITEMS.register("cooked_ground_pork",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.COOKED_GROUND_PORK)));
	public static final RegistryObject<Item> GROUND_PORK = ITEMS.register("ground_pork",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.GROUND_PORK)));
	public static final RegistryObject<Item> COOKED_CUBED_PORK = ITEMS.register("cooked_cubed_pork",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.COOKED_CUBED_PORK)));
	public static final RegistryObject<Item> CUBED_PORK = ITEMS.register("cubed_pork",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.CUBED_PORK)));
	public static final RegistryObject<Item> COOKED_PORK_RIBS = ITEMS.register("cooked_pork_ribs",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.COOKED_PORK_RIBS)));
	public static final RegistryObject<Item> PORK_RIBS = ITEMS.register("pork_ribs",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.PORK_RIBS)));
	public static final RegistryObject<Item> COOKED_PORK_RIB = ITEMS.register("cooked_pork_rib",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.COOKED_PORK_RIB)));
	public static final RegistryObject<Item> PORK_RIB = ITEMS.register("pork_rib",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.PORK_RIB)));
	public static final RegistryObject<Item> COOKED_PORK_ROAST = ITEMS.register("cooked_pork_roast",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.COOKED_ROAST)));
	public static final RegistryObject<Item> PORK_ROAST = ITEMS.register("pork_roast",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.ROAST)));
	public static final RegistryObject<Item> COOKED_PORK_STEW_MEAT = ITEMS.register("cooked_pork_stewmeat",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.COOKED_PORK_STEWMEAT)));
	public static final RegistryObject<Item> PORK_STEW_MEAT = ITEMS.register("pork_stewmeat",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.PORK_STEWMEAT)));
	public static final RegistryObject<Item> COOKED_BACON = ITEMS.register("cooked_bacon",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.COOKED_BACON)));
	public static final RegistryObject<Item> BACON = ITEMS.register("bacon",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.BACON)));

	// LAMB
	public static final RegistryObject<Item> COOKED_LAMB_SCRAPS = ITEMS.register("cooked_lamb_scraps",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.COOKED_LAMB_SCRAPS)));
	public static final RegistryObject<Item> LAMB_SCRAPS = ITEMS.register("lamb_scraps",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.LAMB_SCRAPS)));
	public static final RegistryObject<Item> COOKED_GROUND_LAMB = ITEMS.register("cooked_ground_lamb",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.COOKED_GROUND_LAMB)));
	public static final RegistryObject<Item> GROUND_LAMB = ITEMS.register("ground_lamb",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.GROUND_LAMB)));
	public static final RegistryObject<Item> COOKED_CUBED_LAMB = ITEMS.register("cooked_cubed_lamb",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.COOKED_CUBED_LAMB)));
	public static final RegistryObject<Item> CUBED_LAMB = ITEMS.register("cubed_lamb",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.CUBED_LAMB)));
	public static final RegistryObject<Item> COOKED_LAMB_RIBS = ITEMS.register("cooked_lamb_ribs",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.COOKED_LAMB_RIBS)));
	public static final RegistryObject<Item> LAMB_RIBS = ITEMS.register("lamb_ribs",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.LAMB_RIBS)));
	public static final RegistryObject<Item> COOKED_LAMB_RIB = ITEMS.register("cooked_lamb_rib",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.COOKED_LAMB_RIB)));
	public static final RegistryObject<Item> LAMB_RIB = ITEMS.register("lamb_rib",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.LAMB_RIB)));
	public static final RegistryObject<Item> COOKED_LAMB_ROAST = ITEMS.register("cooked_lamb_roast",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.COOKED_ROAST)));
	public static final RegistryObject<Item> LAMB_ROAST = ITEMS.register("lamb_roast",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.ROAST)));
	public static final RegistryObject<Item> COOKED_LAMB_STEW_MEAT = ITEMS.register("cooked_lamb_stewmeat",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.COOKED_LAMB_STEWMEAT)));
	public static final RegistryObject<Item> LAMB_STEW_MEAT = ITEMS.register("lamb_stewmeat",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.LAMB_STEWMEAT)));

	public static final RegistryObject<Item> SAUSAGE = ITEMS.register("sausage",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.SAUSAGE)));
	public static final RegistryObject<Item> COOKED_SAUSAGE = ITEMS.register("cooked_sausage",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.COOKED_SAUSAGE)));

	// OFFAL
	public static final RegistryObject<Item> COOKED_TRIPE = ITEMS.register("cooked_tripe",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.COOKED_TRIPE)));
	public static final RegistryObject<Item> TRIPE = ITEMS.register("tripe",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.TRIPE)));
	public static final RegistryObject<Item> COOKED_STOMACHE = ITEMS.register("cooked_stomache",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.COOKED_STOMACHE)));
	public static final RegistryObject<Item> STOMACHE = ITEMS.register("stomache",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.STOMACHE)));
	public static final RegistryObject<Item> COOKED_LUNG = ITEMS.register("cooked_lung",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.COOKED_LUNG)));
	public static final RegistryObject<Item> LUNG = ITEMS.register("lung",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.LUNG)));
	public static final RegistryObject<Item> COOKED_LIVER = ITEMS.register("cooked_liver",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.COOKED_LIVER)));
	public static final RegistryObject<Item> LIVER = ITEMS.register("liver",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.LIVER)));
	public static final RegistryObject<Item> COOKED_KIDNEY = ITEMS.register("cooked_kidney",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.COOKED_KIDNEY)));
	public static final RegistryObject<Item> KIDNEY = ITEMS.register("kidney",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.KIDNEY)));
	public static final RegistryObject<Item> COOKED_HEART = ITEMS.register("cooked_heart",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.COOKED_HEART)));
	public static final RegistryObject<Item> HEART = ITEMS.register("heart",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.HEART)));
	public static final RegistryObject<Item> COOKED_BRAIN = ITEMS.register("cooked_brain",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.COOKED_BRAIN)));
	public static final RegistryObject<Item> BRAIN = ITEMS.register("brain",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsGeneric.BRAIN)));

	public static final RegistryObject<CarcassItem> COW_CARCASS = ITEMS.register("cow_carcass",
			() -> new CarcassItem(new Item.Properties().tab(BUTCHER_TAB).stacksTo(1)));
	public static final RegistryObject<CarcassItem> SHEEP_CARCASS = ITEMS.register("sheep_carcass",
			() -> new CarcassItem(new Item.Properties().tab(BUTCHER_TAB).stacksTo(1)));
	public static final RegistryObject<CarcassItem> PIG_CARCASS = ITEMS.register("pig_carcass",
			() -> new CarcassItem(new Item.Properties().tab(BUTCHER_TAB).stacksTo(1)));
	
	public static final RegistryObject<BlockItem> COW_HIDE = ITEMS.register("cow_hide",
			() -> new BlockItem(ButchercraftBlocks.COW_HIDE_CARPET.get(),new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> PIG_HIDE = ITEMS.register("pig_hide",
			() -> new BlockItem(ButchercraftBlocks.PIG_HIDE_CARPET.get(),new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> SHEEP_HIDE = ITEMS.register("sheep_hide",
			() -> new BlockItem(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(),new Item.Properties().tab(BUTCHER_TAB)));
	
	public static final RegistryObject<Item> BUTCHER_KNIFE = ITEMS.register("butcher_knife",
			() -> new ButcherKnifeItem(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB).durability(250)));

	public static final RegistryObject<Item> SKINNING_KNIFE = ITEMS.register("skinning_knife",
			() -> new KnifeItem(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB).durability(250)));
	public static final RegistryObject<Item> BONE_SAW = ITEMS.register("bone_saw",
			() -> new KnifeItem(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB).durability(250)));
	public static final RegistryObject<Item> GUT_KNIFE = ITEMS.register("gut_knife",
			() -> new KnifeItem(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB).durability(250)));
//	public static final RegistryObject<Item> SPATULA = ITEMS.register("spatula",
//			() -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
//	public static final RegistryObject<Item> GRINDER_TIP = ITEMS.register("grinder_tip",
//			() -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
//	public static final RegistryObject<Item> EXTRUDER_TIP = ITEMS.register("extruder_tip",
//			() -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
	public static final RegistryObject<Item> LEATHER_SCRAP = ITEMS.register("leather_scrap",
			() -> new Item(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB)));

	public static final RegistryObject<Item> LEATHER_CORD = ITEMS.register("leather_cord",
			() -> new Item(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB)));
	public static final RegistryObject<Item> FAT = ITEMS.register("fat",
			() -> new Item(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB)));
	public static final RegistryObject<Item> SINEW = ITEMS.register("sinew",
			() -> new Item(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB)));
	public static final RegistryObject<Item> HORN = ITEMS.register("horn",
			() -> new Item(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB)));

	public static final RegistryObject<BlockItem> HOOK_BLOCK_ITEM = ITEMS.register("meat_hook_item",
			() -> new BlockItem(ButchercraftBlocks.MEAT_HOOK.get(), new Item.Properties().tab(BUTCHER_TAB)));

//	public static final RegistryObject<BlockItem> COW_SKULL = ITEMS.register("cow_skull_item",
//			() -> new BlockItem(ButchercraftBlocks.COW_SKULL.get(), new Item.Properties().tab(BUTCHER_TAB)));
//	public static final RegistryObject<BlockItem> PIG_SKULL = ITEMS.register("pig_skull_item",
//			() -> new BlockItem(ButchercraftBlocks.PIG_SKULL.get(), new Item.Properties().tab(BUTCHER_TAB)));
//	public static final RegistryObject<BlockItem> SHEEP_SKULL = ITEMS.register("sheep_skull_item",
//			() -> new BlockItem(ButchercraftBlocks.SHEEP_SKULL.get(), new Item.Properties().tab(BUTCHER_TAB)));
	
	public static final RegistryObject<BlockItem> BEEF_BLOCK_ITEM = ITEMS.register("beef_block_item",
			() -> new BlockItem(ButchercraftBlocks.BEEF_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> COOKED_BEEF_BLOCK_ITEM = ITEMS.register("cooked_beef_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_BEEF_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	
	public static final RegistryObject<BlockItem> PORK_BLOCK_ITEM = ITEMS.register("pork_block_item",
			() -> new BlockItem(ButchercraftBlocks.PORK_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> COOKED_PORK_BLOCK_ITEM = ITEMS.register("cooked_pork_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_PORK_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	
	public static final RegistryObject<BlockItem> LAMB_BLOCK_ITEM = ITEMS.register("lamb_block_item",
			() -> new BlockItem(ButchercraftBlocks.LAMB_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> COOKED_LAMB_BLOCK_ITEM = ITEMS.register("cooked_lamb_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_LAMB_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	
//	public static final RegistryObject<Item> PIG_HOOVES = ITEMS.register("pig_hooves", () -> new Item(new Item.Properties().tab(BUTCHER_TAB)));

	public static void register(IEventBus modBus) {
		ITEMS.register(modBus);
	}
}
