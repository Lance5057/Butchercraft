package com.lance5057.butchercraft;

import com.lance5057.butchercraft.food.FoodsCow;
import com.lance5057.butchercraft.food.FoodsGeneric;
import com.lance5057.butchercraft.food.FoodsPig;
import com.lance5057.butchercraft.food.FoodsSheep;
import com.lance5057.butchercraft.items.ButcherKnifeItem;
import com.lance5057.butchercraft.items.CarcassItem;
import com.lance5057.butchercraft.items.KnifeItem;

import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModItems;

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
	public static final RegistryObject<Item> BEEF_JERKY = ITEMS.register("beef_jerky",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsCow.BEEF_JERKY)));

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
	public static final RegistryObject<Item> PORK_JERKY = ITEMS.register("pork_jerky",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsPig.PORK_JERKY)));

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
	public static final RegistryObject<Item> LAMB_JERKY = ITEMS.register("lamb_jerky",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB).food(FoodsSheep.LAMB_JERKY)));

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
	public static final RegistryObject<CarcassItem> CHICKEN_CARCASS = ITEMS.register("chicken_carcass",
			() -> new CarcassItem(new Item.Properties().tab(BUTCHER_TAB).stacksTo(1)));

	public static final RegistryObject<BlockItem> COW_HIDE = ITEMS.register("cow_hide",
			() -> new BlockItem(ButchercraftBlocks.COW_HIDE_CARPET.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> PIG_HIDE = ITEMS.register("pig_hide",
			() -> new BlockItem(ButchercraftBlocks.PIG_HIDE_CARPET.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> SHEEP_HIDE = ITEMS.register("sheep_hide",
			() -> new BlockItem(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(), new Item.Properties().tab(BUTCHER_TAB)));

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
	public static final RegistryObject<Item> LARD = ITEMS.register("lard",
			() -> new Item(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB)));
	public static final RegistryObject<Item> GELATIN = ITEMS.register("gelatin",
			() -> new Item(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB)));
//	public static final RegistryObject<Item> SOAP = ITEMS.register("soap",
//			() -> new Item(new Item.Properties().tab(ButchercraftItems.BUTCHER_TAB)));

	public static final RegistryObject<BlockItem> HOOK_BLOCK_ITEM = ITEMS.register("meat_hook_item",
			() -> new BlockItem(ButchercraftBlocks.MEAT_HOOK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> DRYING_RACK_BLOCK_ITEM = ITEMS.register("drying_rack_item",
			() -> new BlockItem(ButchercraftBlocks.DRYING_RACK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> BUTCHER_BLOCK_BLOCK_ITEM = ITEMS.register("butcher_block_block_item",
			() -> new BlockItem(ButchercraftBlocks.BUTCHER_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	
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

	public static final RegistryObject<Item> STOCK_JAR_ITEM = ITEMS.register("stock_jar_item",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> GRAVY_ITEM = ITEMS.register("gravy_boat_item",
			() -> new Item(new Item.Properties().tab(BUTCHER_TAB)));
	
	public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
			() -> new Item(new Item.Properties().food(FoodsGeneric.CHEESE).stacksTo(64).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
			() -> new Item(new Item.Properties().food(FoodsGeneric.BUTTER).stacksTo(64).tab(BUTCHER_TAB)));
	
	public static final RegistryObject<BlockItem> CHEESE_BLOCK_ITEM = ITEMS.register("cheese_block_item",
			() -> new BlockItem(ButchercraftBlocks.CHEESE_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> BUTTER_BLOCK_ITEM = ITEMS.register("butter_block_item",
			() -> new BlockItem(ButchercraftBlocks.BUTTER_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));

	public static final RegistryObject<Item> PORK_STEW = ITEMS.register("pork_stew", () -> new Item(
			new Item.Properties().food(FoodValues.BEEF_STEW).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> LAMB_STEW = ITEMS.register("lamb_stew", () -> new Item(
			new Item.Properties().food(FoodValues.BEEF_STEW).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));

	public static final RegistryObject<Item> SAUSAGE_ROLL = ITEMS.register("sausage_roll",
			() -> new Item(new Item.Properties().food(FoodsGeneric.SAUSAGE_ROLL).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> SOS = ITEMS.register("sos",
			() -> new Item(new Item.Properties().food(FoodsGeneric.SOS).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> LIVER_ONIONS = ITEMS.register("liver_onions",
			() -> new Item(new Item.Properties().food(FoodsGeneric.LIVERONION).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> FRIES = ITEMS.register("fries",
			() -> new Item(new Item.Properties().food(Foods.BAKED_POTATO).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> FRIED_FISH = ITEMS.register("fried_fish",
			() -> new Item(new Item.Properties().food(Foods.COOKED_SALMON).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> CHICKEN_FRIED_STEAK = ITEMS.register("chicken_fried_steak",
			() -> new Item(new Item.Properties().food(FoodsGeneric.CHICKEN_FRIED_STEAK).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> PORK_TENDERLOIN = ITEMS.register("pork_tenderloin",
			() -> new Item(new Item.Properties().food(FoodsGeneric.CHICKEN_FRIED_STEAK).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> FRIED_CHICKEN = ITEMS.register("fried_chicken",
			() -> new Item(new Item.Properties().food(Foods.COOKED_CHICKEN).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> STUFFED_HEART = ITEMS.register("stuffed_heart",
			() -> new Item(new Item.Properties().food(FoodsGeneric.STUFFED_HEART).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> FRIED_BRAINS = ITEMS.register("fried_brains",
			() -> new Item(new Item.Properties().food(FoodsGeneric.FRIED_BRAIN).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> OXTAIL_SOUP = ITEMS.register("oxtail_soup",
			() -> new Item(new Item.Properties().food(FoodValues.BEEF_STEW).stacksTo(16).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> GRILLED_CHEESE = ITEMS.register("grilled_cheese",
			() -> new Item(new Item.Properties().food(FoodsGeneric.GRILLED_CHEESE).stacksTo(16).tab(BUTCHER_TAB)));

	public static final RegistryObject<Item> HASH = ITEMS.register("hash", () -> new Item(
			new Item.Properties().food(Foods.BAKED_POTATO).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> POT_ROAST = ITEMS.register("potroast", () -> new Item(
			new Item.Properties().food(FoodValues.BEEF_STEW).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> SALISBURY_STEAK = ITEMS.register("salisbury_steak", () -> new Item(
			new Item.Properties().food(Foods.COOKED_BEEF).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> BBQ_RIBS = ITEMS.register("bbq_ribs", () -> new Item(new Item.Properties()
			.food(FoodsCow.COOKED_BEEF_RIBS).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> MEAT_PIE_SLICE = ITEMS.register("meat_pie_slice",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_GROUND_BEEF).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> PULLED_PORK_SANDWICH = ITEMS.register("pulled_pork_sandwich",
			() -> new Item(new Item.Properties().food(FoodValues.HAMBURGER).craftRemainder(Items.BREAD).stacksTo(4)
					.tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> MASHED_POTATO_GRAVY = ITEMS.register("mashed_potato_gravy",
			() -> new Item(new Item.Properties().food(FoodsGeneric.POTATO_GRAVY).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> RACK_LAMB = ITEMS.register("rack_lamb",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_BEEF_RIBS).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> STIRFRY = ITEMS.register("stirfry", () -> new Item(new Item.Properties()
			.food(FoodsGeneric.STIRFRY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> BEEF_WELLINGTON = ITEMS.register("beef_wellington",
			() -> new Item(new Item.Properties().food(FoodsGeneric.WELLINGTON).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> HAGGIS = ITEMS.register("haggis", () -> new Item(
			new Item.Properties().food(FoodsGeneric.HAGGIS).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));

	public static final RegistryObject<Item> JELLY_WHITE = ITEMS.register("jelly_white", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_ORANGE = ITEMS.register("jelly_orange", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_MAGENTA = ITEMS.register("jelly_magenta", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_LIGHT_BLUE = ITEMS.register("jelly_light_blue", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_YELLOW = ITEMS.register("jelly_yellow", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_LIME = ITEMS.register("jelly_lime", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_PINK = ITEMS.register("jelly_pink", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_GREY = ITEMS.register("jelly_grey", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_LIGHT_GREY = ITEMS.register("jelly_light_grey", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_CYAN = ITEMS.register("jelly_cyan", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_PURPLE = ITEMS.register("jelly_purple", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_BLUE = ITEMS.register("jelly_blue", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_BROWN = ITEMS.register("jelly_brown", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_GREEN = ITEMS.register("jelly_green", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_RED = ITEMS.register("jelly_red", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));
	public static final RegistryObject<Item> JELLY_BLACK = ITEMS.register("jelly_black", () -> new Item(
			new Item.Properties().food(FoodsGeneric.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(BUTCHER_TAB)));

	public static final RegistryObject<BlockItem> HASH_FEAST_ITEM = ITEMS.register("hash_block_item",
			() -> new BlockItem(ButchercraftBlocks.HASH_FEAST.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> POT_ROAST_FEAST_ITEM = ITEMS.register("pot_roast_block_item",
			() -> new BlockItem(ButchercraftBlocks.POT_ROAST_FEAST.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> SALISBURY_STEAK_FEAST_ITEM = ITEMS
			.register("salisbury_steak_block_item", () -> new BlockItem(ButchercraftBlocks.SALISBURY_STEAK_FEAST.get(),
					new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> BBQ_RIBS_FEAST_ITEM = ITEMS.register("bbq_ribs_block_item",
			() -> new BlockItem(ButchercraftBlocks.BBQ_RIBS_FEAST.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> MEAT_PIE_BLOCK_ITEM = ITEMS.register("meat_pie_block_item",
			() -> new BlockItem(ButchercraftBlocks.MEAT_PIE_BLOCK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> PULLED_PORK_FEAST_ITEM = ITEMS.register("pulled_pork_block_item",
			() -> new BlockItem(ButchercraftBlocks.PULLED_PORK_FEAST.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> MASHED_POTATO_GRAVY_FEAST_ITEM = ITEMS.register(
			"mashed_potato_gravy_block_item",
			() -> new BlockItem(ButchercraftBlocks.MASHED_POTATO_GRAVY.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> RACK_LAMB_FEAST_ITEM = ITEMS.register("rack_lamb_block_item",
			() -> new BlockItem(ButchercraftBlocks.RACK_LAMB.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> STIRFRY_FEAST_ITEM = ITEMS.register("stirfry_block_item",
			() -> new BlockItem(ButchercraftBlocks.STIRFRY.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> BEEF_WELLINGTON_FEAST_ITEM = ITEMS.register(
			"beef_wellington_block_item",
			() -> new BlockItem(ButchercraftBlocks.BEEF_WELLINGTON.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> HAGGIS_FEAST_ITEM = ITEMS.register("haggis_block_item",
			() -> new BlockItem(ButchercraftBlocks.HAGGIS.get(), new Item.Properties().tab(BUTCHER_TAB)));

	public static final RegistryObject<BlockItem> JELLY_WHITE_FEAST_ITEM = ITEMS.register("jelly_white_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_WHITE.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_ORANGE_FEAST_ITEM = ITEMS.register("jelly_orange_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_ORANGE.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_MAGENTA_FEAST_ITEM = ITEMS.register("jelly_magenta_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_MAGENTA.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_LIGHT_BLUE_FEAST_ITEM = ITEMS.register(
			"jelly_light_blue_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_LIGHT_BLUE.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_YELLOW_FEAST_ITEM = ITEMS.register("jelly_yellow_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_YELLOW.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_LIME_FEAST_ITEM = ITEMS.register("jelly_lime_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_LIME.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_PINK_FEAST_ITEM = ITEMS.register("jelly_pink_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_PINK.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_GREY_FEAST_ITEM = ITEMS.register("jelly_grey_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_GREY.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_LIGHT_GREY_FEAST_ITEM = ITEMS.register(
			"jelly_light_grey_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_LIGHT_GREY.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_CYAN_FEAST_ITEM = ITEMS.register("jelly_cyan_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_CYAN.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_PURPLE_FEAST_ITEM = ITEMS.register("jelly_purple_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_PURPLE.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_BLUE_FEAST_ITEM = ITEMS.register("jelly_blue_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_BLUE.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_BROWN_FEAST_ITEM = ITEMS.register("jelly_brown_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_BROWN.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_GREEN_FEAST_ITEM = ITEMS.register("jelly_green_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_GREEN.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_RED_FEAST_ITEM = ITEMS.register("jelly_red_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_RED.get(), new Item.Properties().tab(BUTCHER_TAB)));
	public static final RegistryObject<BlockItem> JELLY_BLACK_FEAST_ITEM = ITEMS.register("jelly_black_block_item",
			() -> new BlockItem(ButchercraftBlocks.JELLY_BLACK.get(), new Item.Properties().tab(BUTCHER_TAB)));

	public static void register(IEventBus modBus) {
		ITEMS.register(modBus);
	}
}
