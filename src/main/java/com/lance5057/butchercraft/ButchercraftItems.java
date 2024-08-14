package com.lance5057.butchercraft;

import com.lance5057.butchercraft.armor.ApronItem;
import com.lance5057.butchercraft.armor.BCArmorMaterial;
import com.lance5057.butchercraft.armor.BootsItem;
import com.lance5057.butchercraft.armor.BunnyEarsItem;
import com.lance5057.butchercraft.armor.BunnyTailItem;
import com.lance5057.butchercraft.armor.ChickenMaskItem;
import com.lance5057.butchercraft.armor.CowHoodItem;
import com.lance5057.butchercraft.armor.GlovesItem;
import com.lance5057.butchercraft.armor.GoatHoodItem;
import com.lance5057.butchercraft.armor.MaskItem;
import com.lance5057.butchercraft.armor.PaperHatItem;
import com.lance5057.butchercraft.armor.PigHoodItem;
import com.lance5057.butchercraft.armor.SheepHoodItem;
import com.lance5057.butchercraft.food.FoodsChicken;
import com.lance5057.butchercraft.food.FoodsCow;
import com.lance5057.butchercraft.food.FoodsGeneric;
import com.lance5057.butchercraft.food.FoodsPig;
import com.lance5057.butchercraft.food.FoodsRabbit;
import com.lance5057.butchercraft.food.FoodsSheep;
import com.lance5057.butchercraft.items.ButcherKnifeItem;
import com.lance5057.butchercraft.items.CarcassItem;
import com.lance5057.butchercraft.items.KnifeItem;
import com.lance5057.butchercraft.items.SoapItem;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ButchercraftItems {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
			Butchercraft.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Butchercraft.MOD_ID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BUTCHER_TAB = CREATIVE_MODE_TABS.register("items",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.butchercraft.items"))
					.icon(() -> new ItemStack(ButchercraftItems.BUTCHER_KNIFE.get()))
					.build());

	// BEEF
	public static final DeferredItem<Item> COOKED_BEEF_SCRAPS = ITEMS.register("cooked_beef_scraps",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_BEEF_SCRAPS)));
	public static final DeferredItem<Item> BEEF_SCRAPS = ITEMS.register("beef_scraps",
			() -> new Item(new Item.Properties().food(FoodsCow.BEEF_SCRAPS)));
	public static final DeferredItem<Item> COOKED_GROUND_BEEF = ITEMS.register("cooked_ground_beef",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_GROUND_BEEF)));
	public static final DeferredItem<Item> GROUND_BEEF = ITEMS.register("ground_beef",
			() -> new Item(new Item.Properties().food(FoodsCow.GROUND_BEEF)));
	public static final DeferredItem<Item> COOKED_CUBED_BEEF = ITEMS.register("cooked_cubed_beef",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_CUBED_BEEF)));
	public static final DeferredItem<Item> CUBED_BEEF = ITEMS.register("cubed_beef",
			() -> new Item(new Item.Properties().food(FoodsCow.CUBED_BEEF)));
	public static final DeferredItem<Item> COOKED_BEEF_RIBS = ITEMS.register("cooked_beef_ribs",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_BEEF_RIBS)));
	public static final DeferredItem<Item> BEEF_RIBS = ITEMS.register("beef_ribs",
			() -> new Item(new Item.Properties().food(FoodsCow.BEEF_RIBS)));
	public static final DeferredItem<Item> COOKED_BEEF_ROAST = ITEMS.register("cooked_beef_roast",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_ROAST)));
	public static final DeferredItem<Item> BEEF_ROAST = ITEMS.register("beef_roast",
			() -> new Item(new Item.Properties().food(FoodsCow.ROAST)));
	public static final DeferredItem<Item> COOKED_BEEF_STEW_MEAT = ITEMS.register("cooked_beef_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_BEEF_STEWMEAT)));
	public static final DeferredItem<Item> BEEF_STEW_MEAT = ITEMS.register("beef_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsCow.BEEF_STEWMEAT)));
	public static final DeferredItem<Item> OXTAIL = ITEMS.register("oxtail",
			() -> new Item(new Item.Properties().food(FoodsCow.OXTAIL)));
	public static final DeferredItem<Item> COOKED_OXTAIL = ITEMS.register("cooked_oxtail",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_OXTAIL)));
	public static final DeferredItem<Item> TONGUE = ITEMS.register("tongue",
			() -> new Item(new Item.Properties().food(FoodsCow.BEEF_TONGUE)));
	public static final DeferredItem<Item> COOKED_TONGUE = ITEMS.register("cooked_tongue",
			() -> new Item(new Item.Properties().food(FoodsCow.COOKED_BEEF_TONGUE)));

	// PORK
	public static final DeferredItem<Item> COOKED_PORK_SCRAPS = ITEMS.register("cooked_pork_scraps",
			() -> new Item(new Item.Properties().food(FoodsPig.COOKED_PORK_SCRAPS)));
	public static final DeferredItem<Item> PORK_SCRAPS = ITEMS.register("pork_scraps",
			() -> new Item(new Item.Properties().food(FoodsPig.PORK_SCRAPS)));
	public static final DeferredItem<Item> COOKED_GROUND_PORK = ITEMS.register("cooked_ground_pork",
			() -> new Item(new Item.Properties().food(FoodsPig.COOKED_GROUND_PORK)));
	public static final DeferredItem<Item> GROUND_PORK = ITEMS.register("ground_pork",
			() -> new Item(new Item.Properties().food(FoodsPig.GROUND_PORK)));
	public static final DeferredItem<Item> COOKED_CUBED_PORK = ITEMS.register("cooked_cubed_pork",
			() -> new Item(new Item.Properties().food(FoodsPig.COOKED_CUBED_PORK)));
	public static final DeferredItem<Item> CUBED_PORK = ITEMS.register("cubed_pork",
			() -> new Item(new Item.Properties().food(FoodsPig.CUBED_PORK)));
	public static final DeferredItem<Item> COOKED_PORK_RIBS = ITEMS.register("cooked_pork_ribs",
			() -> new Item(new Item.Properties().food(FoodsPig.COOKED_PORK_RIBS)));
	public static final DeferredItem<Item> PORK_RIBS = ITEMS.register("pork_ribs",
			() -> new Item(new Item.Properties().food(FoodsPig.PORK_RIBS)));
	public static final DeferredItem<Item> COOKED_PORK_ROAST = ITEMS.register("cooked_pork_roast",
			() -> new Item(new Item.Properties().food(FoodsPig.COOKED_ROAST)));
	public static final DeferredItem<Item> PORK_ROAST = ITEMS.register("pork_roast",
			() -> new Item(new Item.Properties().food(FoodsPig.ROAST)));
	public static final DeferredItem<Item> COOKED_PORK_STEW_MEAT = ITEMS.register("cooked_pork_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsPig.COOKED_PORK_STEWMEAT)));
	public static final DeferredItem<Item> PORK_STEW_MEAT = ITEMS.register("pork_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsPig.PORK_STEWMEAT)));

	// MUTTON
	public static final DeferredItem<Item> COOKED_MUTTON_SCRAPS = ITEMS.register("cooked_lamb_scraps",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_MUTTON_SCRAPS)));
	public static final DeferredItem<Item> MUTTON_SCRAPS = ITEMS.register("lamb_scraps",
			() -> new Item(new Item.Properties().food(FoodsSheep.MUTTON_SCRAPS)));
	public static final DeferredItem<Item> COOKED_GROUND_MUTTON = ITEMS.register("cooked_ground_lamb",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_GROUND_MUTTON)));
	public static final DeferredItem<Item> GROUND_MUTTON = ITEMS.register("ground_lamb",
			() -> new Item(new Item.Properties().food(FoodsSheep.GROUND_MUTTON)));
	public static final DeferredItem<Item> COOKED_CUBED_MUTTON = ITEMS.register("cooked_cubed_lamb",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_CUBED_MUTTON)));
	public static final DeferredItem<Item> CUBED_MUTTON = ITEMS.register("cubed_lamb",
			() -> new Item(new Item.Properties().food(FoodsSheep.CUBED_MUTTON)));
	public static final DeferredItem<Item> COOKED_MUTTON_RIBS = ITEMS.register("cooked_lamb_ribs",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_MUTTON_RIBS)));
	public static final DeferredItem<Item> MUTTON_RIBS = ITEMS.register("lamb_ribs",
			() -> new Item(new Item.Properties().food(FoodsSheep.MUTTON_RIBS)));
	public static final DeferredItem<Item> COOKED_MUTTON_ROAST = ITEMS.register("cooked_lamb_roast",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_ROAST)));
	public static final DeferredItem<Item> MUTTON_ROAST = ITEMS.register("lamb_roast",
			() -> new Item(new Item.Properties().food(FoodsSheep.ROAST)));
	public static final DeferredItem<Item> COOKED_MUTTON_STEW_MEAT = ITEMS.register("cooked_lamb_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_MUTTON_STEWMEAT)));
	public static final DeferredItem<Item> MUTTON_STEW_MEAT = ITEMS.register("lamb_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsSheep.MUTTON_STEWMEAT)));

	// GOAT
	public static final DeferredItem<Item> COOKED_GOAT_CHOP = ITEMS.register("cooked_goat_chop",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_MUTTON_SCRAPS)));
	public static final DeferredItem<Item> GOAT_CHOP = ITEMS.register("goat_chop",
			() -> new Item(new Item.Properties().food(FoodsSheep.MUTTON_SCRAPS)));
	public static final DeferredItem<Item> COOKED_GOAT_SCRAPS = ITEMS.register("cooked_goat_scraps",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_MUTTON_SCRAPS)));
	public static final DeferredItem<Item> GOAT_SCRAPS = ITEMS.register("goat_scraps",
			() -> new Item(new Item.Properties().food(FoodsSheep.MUTTON_SCRAPS)));
	public static final DeferredItem<Item> COOKED_GROUND_GOAT = ITEMS.register("cooked_ground_goat",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_GROUND_MUTTON)));
	public static final DeferredItem<Item> GROUND_GOAT = ITEMS.register("ground_goat",
			() -> new Item(new Item.Properties().food(FoodsSheep.GROUND_MUTTON)));
	public static final DeferredItem<Item> COOKED_CUBED_GOAT = ITEMS.register("cooked_cubed_goat",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_CUBED_MUTTON)));
	public static final DeferredItem<Item> CUBED_GOAT = ITEMS.register("cubed_goat",
			() -> new Item(new Item.Properties().food(FoodsSheep.CUBED_MUTTON)));
	public static final DeferredItem<Item> COOKED_GOAT_RIBS = ITEMS.register("cooked_goat_ribs",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_MUTTON_RIBS)));
	public static final DeferredItem<Item> GOAT_RIBS = ITEMS.register("goat_ribs",
			() -> new Item(new Item.Properties().food(FoodsSheep.MUTTON_RIBS)));
	public static final DeferredItem<Item> COOKED_GOAT_ROAST = ITEMS.register("cooked_goat_roast",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_ROAST)));
	public static final DeferredItem<Item> GOAT_ROAST = ITEMS.register("goat_roast",
			() -> new Item(new Item.Properties().food(FoodsSheep.ROAST)));
	public static final DeferredItem<Item> COOKED_GOAT_STEW_MEAT = ITEMS.register("cooked_goat_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsSheep.COOKED_MUTTON_STEWMEAT)));
	public static final DeferredItem<Item> GOAT_STEW_MEAT = ITEMS.register("goat_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsSheep.MUTTON_STEWMEAT)));

	// Chicken
	public static final DeferredItem<Item> CHICKEN_BREAST = ITEMS.register("chicken_breast",
			() -> new Item(new Item.Properties().food(FoodsChicken.BREAST)));
	public static final DeferredItem<Item> CUBED_CHICKEN = ITEMS.register("cubed_chicken",
			() -> new Item(new Item.Properties().food(FoodsChicken.CUBED)));
	public static final DeferredItem<Item> GROUND_CHICKEN = ITEMS.register("ground_chicken",
			() -> new Item(new Item.Properties().food(FoodsChicken.GROUND)));
	public static final DeferredItem<Item> CHICKEN_LEG = ITEMS.register("chicken_leg",
			() -> new Item(new Item.Properties().food(FoodsChicken.LEG)));
	public static final DeferredItem<Item> CHICKEN_SCRAPS = ITEMS.register("chicken_scraps",
			() -> new Item(new Item.Properties().food(FoodsChicken.SCRAPS)));
	public static final DeferredItem<Item> CHICKEN_THIGH = ITEMS.register("chicken_thigh",
			() -> new Item(new Item.Properties().food(FoodsChicken.THIGH)));
	public static final DeferredItem<Item> CHICKEN_WING = ITEMS.register("chicken_wing",
			() -> new Item(new Item.Properties().food(FoodsChicken.WING)));
	public static final DeferredItem<Item> STEW_CHICKEN = ITEMS.register("chicken_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsChicken.STEW)));
	public static final DeferredItem<Item> COOKED_STEW_CHICKEN = ITEMS.register("cooked_chicken_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsChicken.COOKED_STEW)));
	public static final DeferredItem<Item> COOKED_CHICKEN_BREAST = ITEMS.register("cooked_chicken_breast",
			() -> new Item(new Item.Properties().food(FoodsChicken.COOKED_BREAST)));
	public static final DeferredItem<Item> COOKED_CUBED_CHICKEN = ITEMS.register("cooked_cubed_chicken",
			() -> new Item(new Item.Properties().food(FoodsChicken.COOKED_CUBED)));
	public static final DeferredItem<Item> COOKED_GROUND_CHICKEN = ITEMS.register("cooked_ground_chicken",
			() -> new Item(new Item.Properties().food(FoodsChicken.COOKED_GROUND)));
	public static final DeferredItem<Item> COOKED_CHICKEN_LEG = ITEMS.register("cooked_chicken_leg",
			() -> new Item(new Item.Properties().food(FoodsChicken.COOKED_LEG)));
	public static final DeferredItem<Item> COOKED_CHICKEN_SCRAPS = ITEMS.register("cooked_chicken_scraps",
			() -> new Item(new Item.Properties().food(FoodsChicken.COOKED_SCRAPS)));
	public static final DeferredItem<Item> COOKED_CHICKEN_THIGH = ITEMS.register("cooked_chicken_thigh",
			() -> new Item(new Item.Properties().food(FoodsChicken.COOKED_THIGH)));
	public static final DeferredItem<Item> COOKED_CHICKEN_WING = ITEMS.register("cooked_chicken_wing",
			() -> new Item(new Item.Properties().food(FoodsChicken.COOKED_WING)));

	// Rabbit
	public static final DeferredItem<Item> RABBIT_SADDLE = ITEMS.register("rabbit_saddle",
			() -> new Item(new Item.Properties().food(FoodsRabbit.SADDLE)));
	public static final DeferredItem<Item> CUBED_RABBIT = ITEMS.register("cubed_rabbit",
			() -> new Item(new Item.Properties().food(FoodsRabbit.CUBED)));
	public static final DeferredItem<Item> GROUND_RABBIT = ITEMS.register("ground_rabbit",
			() -> new Item(new Item.Properties().food(FoodsRabbit.GROUND)));
	public static final DeferredItem<Item> RABBIT_LEG = ITEMS.register("rabbit_leg",
			() -> new Item(new Item.Properties().food(FoodsRabbit.LEG)));
	public static final DeferredItem<Item> RABBIT_SCRAPS = ITEMS.register("rabbit_scraps",
			() -> new Item(new Item.Properties().food(FoodsRabbit.SCRAPS)));
	public static final DeferredItem<Item> RABBIT_THIGH = ITEMS.register("rabbit_thigh",
			() -> new Item(new Item.Properties().food(FoodsRabbit.THIGH)));
	public static final DeferredItem<Item> STEW_RABBIT = ITEMS.register("rabbit_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsRabbit.STEW)));
	public static final DeferredItem<Item> COOKED_RABBIT_SADDLE = ITEMS.register("cooked_rabbit_saddle",
			() -> new Item(new Item.Properties().food(FoodsRabbit.COOKED_SADDLE)));
	public static final DeferredItem<Item> COOKED_CUBED_RABBIT = ITEMS.register("cooked_cubed_rabbit",
			() -> new Item(new Item.Properties().food(FoodsRabbit.COOKED_CUBED)));
	public static final DeferredItem<Item> COOKED_GROUND_RABBIT = ITEMS.register("cooked_ground_rabbit",
			() -> new Item(new Item.Properties().food(FoodsRabbit.COOKED_GROUND)));
	public static final DeferredItem<Item> COOKED_RABBIT_LEG = ITEMS.register("cooked_rabbit_leg",
			() -> new Item(new Item.Properties().food(FoodsRabbit.COOKED_LEG)));
	public static final DeferredItem<Item> COOKED_RABBIT_SCRAPS = ITEMS.register("cooked_rabbit_scraps",
			() -> new Item(new Item.Properties().food(FoodsRabbit.COOKED_SCRAPS)));
	public static final DeferredItem<Item> COOKED_RABBIT_THIGH = ITEMS.register("cooked_rabbit_thigh",
			() -> new Item(new Item.Properties().food(FoodsRabbit.COOKED_THIGH)));
	public static final DeferredItem<Item> COOKED_STEW_RABBIT = ITEMS.register("cooked_rabbit_stewmeat",
			() -> new Item(new Item.Properties().food(FoodsRabbit.COOKED_STEW)));

	// OFFAL
	public static final DeferredItem<Item> COOKED_TRIPE = ITEMS.register("cooked_tripe",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_TRIPE)));
	public static final DeferredItem<Item> TRIPE = ITEMS.register("tripe",
			() -> new Item(new Item.Properties().food(FoodsGeneric.TRIPE)));
	public static final DeferredItem<Item> COOKED_STOMACH = ITEMS.register("cooked_stomach",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_STOMACH)));
	public static final DeferredItem<Item> STOMACH = ITEMS.register("stomach",
			() -> new Item(new Item.Properties().food(FoodsGeneric.STOMACH)));
	public static final DeferredItem<Item> COOKED_LUNG = ITEMS.register("cooked_lung",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_LUNG)));
	public static final DeferredItem<Item> LUNG = ITEMS.register("lung",
			() -> new Item(new Item.Properties().food(FoodsGeneric.LUNG)));
	public static final DeferredItem<Item> COOKED_LIVER = ITEMS.register("cooked_liver",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_LIVER)));
	public static final DeferredItem<Item> LIVER = ITEMS.register("liver",
			() -> new Item(new Item.Properties().food(FoodsGeneric.LIVER)));
	public static final DeferredItem<Item> COOKED_KIDNEY = ITEMS.register("cooked_kidney",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_KIDNEY)));
	public static final DeferredItem<Item> KIDNEY = ITEMS.register("kidney",
			() -> new Item(new Item.Properties().food(FoodsGeneric.KIDNEY)));
	public static final DeferredItem<Item> COOKED_HEART = ITEMS.register("cooked_heart",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_HEART)));
	public static final DeferredItem<Item> HEART = ITEMS.register("heart",
			() -> new Item(new Item.Properties().food(FoodsGeneric.HEART)));
	public static final DeferredItem<Item> COOKED_BRAIN = ITEMS.register("cooked_brain",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_BRAIN)));
	public static final DeferredItem<Item> BRAIN = ITEMS.register("brain",
			() -> new Item(new Item.Properties().food(FoodsGeneric.BRAIN)));
	public static final DeferredItem<Item> EYEBALL = ITEMS.register("eyeball",
			() -> new Item(new Item.Properties().food(FoodsGeneric.EYEBALL)));
	public static final DeferredItem<Item> COOKED_EYEBALL = ITEMS.register("cooked_eyeball",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_EYEBALL)));
	public static final DeferredItem<Item> WATTLE = ITEMS.register("wattle",
			() -> new Item(new Item.Properties().food(FoodsChicken.WATTLE)));
	public static final DeferredItem<Item> COOKED_WATTLE = ITEMS.register("cooked_wattle",
			() -> new Item(new Item.Properties().food(FoodsChicken.COOKED_WATTLE)));

	public static final DeferredItem<Item> CASING = ITEMS.register("casing",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> BEAK = ITEMS.register("beak",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<CarcassItem> COW_CARCASS = ITEMS.register("cow_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CarcassItem> SHEEP_CARCASS = ITEMS.register("sheep_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CarcassItem> PIG_CARCASS = ITEMS.register("pig_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CarcassItem> CHICKEN_CARCASS = ITEMS.register("chicken_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CarcassItem> GOAT_CARCASS = ITEMS.register("goat_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));

	public static final DeferredItem<CarcassItem> BLACK_RABBIT_CARCASS = ITEMS.register("black_rabbit_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CarcassItem> BROWN_RABBIT_CARCASS = ITEMS.register("brown_rabbit_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CarcassItem> SPLOTCHED_RABBIT_CARCASS = ITEMS.register(
			"splotched_rabbit_carcass", () -> new CarcassItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CarcassItem> GOLD_RABBIT_CARCASS = ITEMS.register("gold_rabbit_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CarcassItem> SALT_RABBIT_CARCASS = ITEMS.register("salt_rabbit_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CarcassItem> WHITE_RABBIT_CARCASS = ITEMS.register("white_rabbit_carcass",
			() -> new CarcassItem(new Item.Properties().stacksTo(1)));

	public static final DeferredItem<BunnyTailItem> BLACK_BUNNY_TAIL = ITEMS.register("black_bunny_tail",
			() -> new BunnyTailItem(BCArmorMaterial.BUNNY_BLACK, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(3))));
	public static final DeferredItem<BunnyTailItem> BROWN_BUNNY_TAIL = ITEMS.register("brown_bunny_tail",
			() -> new BunnyTailItem(BCArmorMaterial.BUNNY_BROWN, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(3))));
	public static final DeferredItem<BunnyTailItem> SPLOTCHED_BUNNY_TAIL = ITEMS.register("splotched_bunny_tail",
			() -> new BunnyTailItem(BCArmorMaterial.BUNNY_SPLOTCHED, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(3))));
	public static final DeferredItem<BunnyTailItem> GOLD_BUNNY_TAIL = ITEMS.register("gold_bunny_tail",
			() -> new BunnyTailItem(BCArmorMaterial.BUNNY_GOLD, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(3))));
	public static final DeferredItem<BunnyTailItem> SALT_BUNNY_TAIL = ITEMS.register("salt_bunny_tail",
			() -> new BunnyTailItem(BCArmorMaterial.BUNNY_SALT, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(3))));
	public static final DeferredItem<BunnyTailItem> WHITE_BUNNY_TAIL = ITEMS.register("white_bunny_tail",
			() -> new BunnyTailItem(BCArmorMaterial.BUNNY_WHITE, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(3))));

	public static final DeferredItem<BunnyEarsItem> BLACK_BUNNY_EARS = ITEMS.register("black_bunny_ears",
			() -> new BunnyEarsItem(BCArmorMaterial.BUNNY_BLACK, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));
	public static final DeferredItem<BunnyEarsItem> BROWN_BUNNY_EARS = ITEMS.register("brown_bunny_ears",
			() -> new BunnyEarsItem(BCArmorMaterial.BUNNY_BROWN, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));
	public static final DeferredItem<BunnyEarsItem> SPLOTCHED_BUNNY_EARS = ITEMS.register("splotched_bunny_ears",
			() -> new BunnyEarsItem(BCArmorMaterial.BUNNY_SPLOTCHED, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));
	public static final DeferredItem<BunnyEarsItem> GOLD_BUNNY_EARS = ITEMS.register("gold_bunny_ears",
			() -> new BunnyEarsItem(BCArmorMaterial.BUNNY_GOLD, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));
	public static final DeferredItem<BunnyEarsItem> SALT_BUNNY_EARS = ITEMS.register("salt_bunny_ears",
			() -> new BunnyEarsItem(BCArmorMaterial.BUNNY_SALT, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));
	public static final DeferredItem<BunnyEarsItem> WHITE_BUNNY_EARS = ITEMS.register("white_bunny_ears",
			() -> new BunnyEarsItem(BCArmorMaterial.BUNNY_WHITE, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));

	public static final DeferredItem<PigHoodItem> PIG_HOOD = ITEMS.register("pig_hood",
			() -> new PigHoodItem(BCArmorMaterial.PIG_HOOD, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));
	public static final DeferredItem<CowHoodItem> COW_HOOD = ITEMS.register("cow_hood",
			() -> new CowHoodItem(BCArmorMaterial.COW_HOOD, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));
	public static final DeferredItem<SheepHoodItem> SHEEP_HOOD = ITEMS.register("sheep_hood",
			() -> new SheepHoodItem(BCArmorMaterial.SHEEP_HOOD, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));
	public static final DeferredItem<GoatHoodItem> GOAT_HOOD = ITEMS.register("goat_hood",
			() -> new GoatHoodItem(BCArmorMaterial.GOAT_HOOD, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));
	public static final DeferredItem<ChickenMaskItem> CHICKEN_MASK = ITEMS.register("chicken_mask",
			() -> new ChickenMaskItem(BCArmorMaterial.CHICKEN_MASK, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(3))));

	public static final DeferredItem<BlockItem> COW_HIDE = ITEMS.register("cow_hide",
			() -> new BlockItem(ButchercraftBlocks.COW_HIDE_CARPET.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> PIG_HIDE = ITEMS.register("pig_hide",
			() -> new BlockItem(ButchercraftBlocks.PIG_HIDE_CARPET.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> SHEEP_HIDE = ITEMS.register("sheep_hide",
			() -> new BlockItem(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GOAT_HIDE = ITEMS.register("goat_hide",
			() -> new BlockItem(ButchercraftBlocks.GOAT_HIDE_CARPET.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> TAXIDERMY_COW_ITEM_BLOCK = ITEMS.register("taxidermy_cow_item_block",
			() -> new BlockItem(ButchercraftBlocks.TAXIDERMY_COW_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> TAXIDERMY_PIG_ITEM_BLOCK = ITEMS.register("taxidermy_pig_item_block",
			() -> new BlockItem(ButchercraftBlocks.TAXIDERMY_PIG_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> TAXIDERMY_SHEEP_ITEM_BLOCK = ITEMS
			.register("taxidermy_sheep_item_block", () -> new BlockItem(ButchercraftBlocks.TAXIDERMY_SHEEP_BLOCK.get(),
					new Item.Properties()));
	public static final DeferredItem<BlockItem> TAXIDERMY_GOAT_ITEM_BLOCK = ITEMS.register(
			"taxidermy_goat_item_block",
			() -> new BlockItem(ButchercraftBlocks.TAXIDERMY_GOAT_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> TAXIDERMY_CHICKEN_ITEM_BLOCK = ITEMS.register(
			"taxidermy_chicken_item_block", () -> new BlockItem(ButchercraftBlocks.TAXIDERMY_CHICKEN_BLOCK.get(),
					new Item.Properties()));

	public static final DeferredItem<BlockItem> TAXIDERMY_BLACK_RABBIT_ITEM_BLOCK = ITEMS.register(
			"taxidermy_black_rabbit_item_block",
			() -> new BlockItem(ButchercraftBlocks.TAXIDERMY_BLACK_RABBIT_BLOCK.get(),
					new Item.Properties()));
	public static final DeferredItem<BlockItem> TAXIDERMY_BROWN_RABBIT_ITEM_BLOCK = ITEMS.register(
			"taxidermy_brown_rabbit_item_block",
			() -> new BlockItem(ButchercraftBlocks.TAXIDERMY_BROWN_RABBIT_BLOCK.get(),
					new Item.Properties()));
	public static final DeferredItem<BlockItem> TAXIDERMY_GOLD_RABBIT_ITEM_BLOCK = ITEMS.register(
			"taxidermy_gold_rabbit_item_block",
			() -> new BlockItem(ButchercraftBlocks.TAXIDERMY_GOLD_RABBIT_BLOCK.get(),
					new Item.Properties()));
	public static final DeferredItem<BlockItem> TAXIDERMY_SALT_RABBIT_ITEM_BLOCK = ITEMS.register(
			"taxidermy_salt_rabbit_item_block",
			() -> new BlockItem(ButchercraftBlocks.TAXIDERMY_SALT_RABBIT_BLOCK.get(),
					new Item.Properties()));
	public static final DeferredItem<BlockItem> TAXIDERMY_WHITE_RABBIT_ITEM_BLOCK = ITEMS.register(
			"taxidermy_white_rabbit_item_block",
			() -> new BlockItem(ButchercraftBlocks.TAXIDERMY_WHITE_RABBIT_BLOCK.get(),
					new Item.Properties()));
	public static final DeferredItem<BlockItem> TAXIDERMY_SPLOTCHED_RABBIT_ITEM_BLOCK = ITEMS.register(
			"taxidermy_splotched_rabbit_item_block",
			() -> new BlockItem(ButchercraftBlocks.TAXIDERMY_SPLOTCHED_RABBIT_BLOCK.get(),
					new Item.Properties()));

	public static final DeferredItem<Item> BUTCHER_KNIFE = ITEMS.register("butcher_knife",
			() -> new ButcherKnifeItem(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/.durability(250)));
	public static final DeferredItem<Item> SKINNING_KNIFE = ITEMS.register("skinning_knife",
			() -> new KnifeItem(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/.durability(250)));
	public static final DeferredItem<Item> BONE_SAW = ITEMS.register("bone_saw",
			() -> new KnifeItem(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/.durability(250)));
	public static final DeferredItem<Item> GUT_KNIFE = ITEMS.register("gut_knife",
			() -> new KnifeItem(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/.durability(250)));

	public static final DeferredItem<Item> LEATHER_SCRAP = ITEMS.register("leather_scrap",
			() -> new Item(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/));
	public static final DeferredItem<Item> LEATHER_CORD = ITEMS.register("leather_cord",
			() -> new Item(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/));
	public static final DeferredItem<Item> FAT = ITEMS.register("fat",
			() -> new Item(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/));
	public static final DeferredItem<Item> SINEW = ITEMS.register("sinew",
			() -> new Item(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/));
	public static final DeferredItem<Item> HORN = ITEMS.register("horn",
			() -> new Item(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/));
	public static final DeferredItem<Item> LARD = ITEMS.register("lard",
			() -> new Item(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/));
	public static final DeferredItem<Item> GELATIN = ITEMS.register("gelatin",
			() -> new Item(new Item.Properties()/*.tab(ButchercraftItems.BUTCHER_TAB)*/));

	public static final DeferredItem<BlockItem> HOOK_BLOCK_ITEM = ITEMS.register("meat_hook_item",
			() -> new BlockItem(ButchercraftBlocks.MEAT_HOOK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> BUTCHER_BLOCK_BLOCK_ITEM = ITEMS.register("butcher_block_block_item",
			() -> new BlockItem(ButchercraftBlocks.BUTCHER_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> GRINDER_BLOCK_ITEM = ITEMS.register("grinder_block_item",
			() -> new BlockItem(ButchercraftBlocks.GRINDER.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> BEEF_BLOCK_ITEM = ITEMS.register("beef_block_item",
			() -> new BlockItem(ButchercraftBlocks.BEEF_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> COOKED_BEEF_BLOCK_ITEM = ITEMS.register("cooked_beef_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_BEEF_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> PORK_BLOCK_ITEM = ITEMS.register("pork_block_item",
			() -> new BlockItem(ButchercraftBlocks.PORK_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> COOKED_PORK_BLOCK_ITEM = ITEMS.register("cooked_pork_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_PORK_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> MUTTON_BLOCK_ITEM = ITEMS.register("lamb_block_item",
			() -> new BlockItem(ButchercraftBlocks.MUTTON_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> COOKED_MUTTON_BLOCK_ITEM = ITEMS.register("cooked_lamb_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_MUTTON_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> RABBIT_BLOCK_ITEM = ITEMS.register("rabbit_block_item",
			() -> new BlockItem(ButchercraftBlocks.RABBIT_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> COOKED_RABBIT_BLOCK_ITEM = ITEMS.register("cooked_rabbit_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_RABBIT_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> CHICKEN_BLOCK_ITEM = ITEMS.register("chicken_block_item",
			() -> new BlockItem(ButchercraftBlocks.CHICKEN_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> COOKED_CHICKEN_BLOCK_ITEM = ITEMS.register(
			"cooked_chicken_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_CHICKEN_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> GOAT_BLOCK_ITEM = ITEMS.register("goat_block_item",
			() -> new BlockItem(ButchercraftBlocks.GOAT_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> COOKED_GOAT_BLOCK_ITEM = ITEMS.register("cooked_goat_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_GOAT_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> SAUSAGE_BLOCK_ITEM = ITEMS.register("sausage_block_item",
			() -> new BlockItem(ButchercraftBlocks.SAUSAGE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> COOKED_SAUSAGE_BLOCK_ITEM = ITEMS.register(
			"cooked_sausage_block_item",
			() -> new BlockItem(ButchercraftBlocks.COOKED_SAUSAGE_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> BLOOD_SAUSAGE_BLOCK_ITEM = ITEMS.register("blood_sausage_block_item",
			() -> new BlockItem(ButchercraftBlocks.BLOOD_SAUSAGE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> COOKED_BLOOD_SAUSAGE_BLOCK_ITEM = ITEMS.register(
			"cooked_blood_sausage_block_item", () -> new BlockItem(ButchercraftBlocks.COOKED_BLOOD_SAUSAGE_BLOCK.get(),
					new Item.Properties()));

	public static final DeferredItem<Item> SAUSAGE_LINKED = ITEMS.register("sausage_linked",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> SAUSAGE = ITEMS.register("sausage",
			() -> new Item(new Item.Properties().food(FoodsGeneric.SAUSAGE)));
	public static final DeferredItem<Item> COOKED_SAUSAGE = ITEMS.register("cooked_sausage",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_SAUSAGE)));

	public static final DeferredItem<Item> BLOOD_SAUSAGE_MIX = ITEMS.register("blood_sausage_mix",
			() -> new Item(new Item.Properties().food(FoodsGeneric.SAUSAGE)));
	public static final DeferredItem<Item> BLOOD_SAUSAGE_LINKED = ITEMS.register("blood_sausage_linked",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_SAUSAGE = ITEMS.register("blood_sausage",
			() -> new Item(new Item.Properties().food(FoodsGeneric.SAUSAGE)));
	public static final DeferredItem<Item> COOKED_BLOOD_SAUSAGE = ITEMS.register("cooked_blood_sausage",
			() -> new Item(new Item.Properties().food(FoodsGeneric.COOKED_BLOOD_SAUSAGE)));

	// Armor
	public static final DeferredItem<Item> MASK = ITEMS.register("mask",
			() -> new MaskItem(BCArmorMaterial.WOOL, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(5))));
	public static final DeferredItem<Item> PAPER_HAT = ITEMS.register("paper_hat",
			() -> new PaperHatItem(BCArmorMaterial.PAPER, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(5))));
	public static final DeferredItem<Item> APRON = ITEMS.register("apron",
			() -> new ApronItem(BCArmorMaterial.WOOL, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
	public static final DeferredItem<Item> GLOVES = ITEMS.register("gloves",
			() -> new GlovesItem(BCArmorMaterial.WOOL, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(3))));
	public static final DeferredItem<Item> BOOTS = ITEMS.register("boots",
			() -> new BootsItem(BCArmorMaterial.WOOL, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(3))));

	public static final DeferredItem<Item> EXTRUDER_TIP = ITEMS.register("extruder_tip",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> GRINDER_TIP = ITEMS.register("grinder_tip",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<SoapItem> SOAP = ITEMS.register("soap",
			() -> new SoapItem(new Item.Properties()));

	public static final DeferredItem<Item> BLOOD_FLUID_BUCKET = ITEMS.register("blood_fluid_bucket",
			() -> new BucketItem(ButchercraftFluids.BLOOD_FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
	public static final DeferredItem<Item> BLOOD_FLUID_BOTTLE = ITEMS.register("blood_fluid_bottle",
			() -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));

//	public static final DeferredItem<Item> TANNING_FLUID_BUCKET = ITEMS.register("tanning_fluid_bucket",
//			() -> new BucketItem(ButchercraftFluids.TANNING_FLUID,
//					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> COW_HEAD_ITEM = ITEMS.register("cow_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.COW_HEAD.get(),
					ButchercraftBlocks.COW_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));
	public static final DeferredItem<Item> COW_SKULL_HEAD_ITEM = ITEMS.register("cow_skull_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.COW_SKULL_HEAD.get(),
					ButchercraftBlocks.COW_SKULL_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> SHEEP_HEAD_ITEM = ITEMS.register("sheep_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.SHEEP_HEAD.get(),
					ButchercraftBlocks.SHEEP_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));
	public static final DeferredItem<Item> SHEEP_SKULL_HEAD_ITEM = ITEMS.register("sheep_skull_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.SHEEP_SKULL_HEAD.get(),
					ButchercraftBlocks.SHEEP_SKULL_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> PIG_HEAD_ITEM = ITEMS.register("pig_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.PIG_HEAD.get(),
					ButchercraftBlocks.PIG_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));
	public static final DeferredItem<Item> PIG_SKULL_HEAD_ITEM = ITEMS.register("pig_skull_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.PIG_SKULL_HEAD.get(),
					ButchercraftBlocks.PIG_SKULL_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> GOAT_HEAD_ITEM = ITEMS.register("goat_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.GOAT_HEAD.get(),
					ButchercraftBlocks.GOAT_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));
	public static final DeferredItem<Item> GOAT_SKULL_HEAD_ITEM = ITEMS.register("goat_skull_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.GOAT_SKULL_HEAD.get(),
					ButchercraftBlocks.GOAT_SKULL_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> CHICKEN_HEAD_ITEM = ITEMS.register("chicken_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.CHICKEN_HEAD.get(),
					ButchercraftBlocks.CHICKEN_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));
	public static final DeferredItem<Item> CHICKEN_SKULL_HEAD_ITEM = ITEMS.register("chicken_skull_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.CHICKEN_SKULL_HEAD.get(),
					ButchercraftBlocks.CHICKEN_SKULL_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> RABBIT_BROWN_HEAD_ITEM = ITEMS.register("rabbit_brown_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.RABBIT_BROWN_HEAD.get(),
					ButchercraftBlocks.RABBIT_BROWN_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> RABBIT_BLACK_HEAD_ITEM = ITEMS.register("rabbit_black_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.RABBIT_BLACK_HEAD.get(),
					ButchercraftBlocks.RABBIT_BLACK_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> RABBIT_GOLD_HEAD_ITEM = ITEMS.register("rabbit_gold_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.RABBIT_GOLD_HEAD.get(),
					ButchercraftBlocks.RABBIT_GOLD_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> RABBIT_SALT_HEAD_ITEM = ITEMS.register("rabbit_salt_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.RABBIT_SALT_HEAD.get(),
					ButchercraftBlocks.RABBIT_SALT_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> RABBIT_SPLOTCHED_HEAD_ITEM = ITEMS.register("rabbit_splotched_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.RABBIT_SPLOTCHED_HEAD.get(),
					ButchercraftBlocks.RABBIT_SPLOTCHED_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> RABBIT_WHITE_HEAD_ITEM = ITEMS.register("rabbit_white_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.RABBIT_WHITE_HEAD.get(),
					ButchercraftBlocks.RABBIT_WHITE_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<Item> RABBIT_SKULL_HEAD_ITEM = ITEMS.register("rabbit_skull_head_item",
			() -> new StandingAndWallBlockItem(ButchercraftBlocks.RABBIT_SKULL_HEAD.get(),
					ButchercraftBlocks.RABBIT_SKULL_HEAD_WALL.get(),
					(new Item.Properties()).rarity(Rarity.UNCOMMON), Direction.DOWN));

	public static final DeferredItem<BlockItem> BARN_WOOD_BLOCK_ITEM = ITEMS.register("barn_wood_block_item",
			() -> new BlockItem(ButchercraftBlocks.BARN_WOOD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BARN_WOOD_DOOR_ITEM = ITEMS.register("barn_wood_door_item",
			() -> new BlockItem(ButchercraftBlocks.BARN_WOOD_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BARN_WOOD_SLAB_ITEM = ITEMS.register("barn_wood_slab_item",
			() -> new BlockItem(ButchercraftBlocks.BARN_WOOD_SLAB.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BARN_WOOD_STAIRS_ITEM = ITEMS.register("barn_wood_stairs_item",
			() -> new BlockItem(ButchercraftBlocks.BARN_WOOD_STAIRS.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BARN_WOOD_TRAPDOOR_ITEM = ITEMS.register("barn_wood_trapdoor_item",
			() -> new BlockItem(ButchercraftBlocks.BARN_WOOD_TRAPDOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BARN_WOOD_FENCE_ITEM = ITEMS.register("barn_wood_fence_item",
			() -> new BlockItem(ButchercraftBlocks.BARN_WOOD_FENCE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BARN_WOOD_FENCE_GATE_ITEM = ITEMS.register(
			"barn_wood_fence_gate_item",
			() -> new BlockItem(ButchercraftBlocks.BARN_WOOD_FENCE_GATE.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> TRIMMED_BARN_WOOD_ITEM = ITEMS.register("trimmed_barn_wood_item",
			() -> new BlockItem(ButchercraftBlocks.TRIMMED_BARN_WOOD_BLOCK.get(),
					new Item.Properties()));

//	public static final DeferredItem<Item> RAWHIDE = ITEMS.register("rawhide",
//			() -> new Item(new Item.Properties()));
//	public static final DeferredItem<Item> SOAKED_HIDE = ITEMS.register("soaked_hide",
//			() -> new Item(new Item.Properties()));
//	public static final DeferredItem<Item> TANNING_SOLUTION = ITEMS.register("tanning_solution",
//			() -> new Item(new Item.Properties()));

	public static void register(IEventBus modBus) {
		CREATIVE_MODE_TABS.register(modBus);
		ITEMS.register(modBus);
	}
}
