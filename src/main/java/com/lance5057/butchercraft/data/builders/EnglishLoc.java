package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftBlocks;
import com.lance5057.butchercraft.ButchercraftItems;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnglishLoc extends LanguageProvider {

	public EnglishLoc(PackOutput output) {
		super(output, Butchercraft.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		Butchercraft.logger.info("\tEN_US Localization");

		this.add("itemGroup.butchercraft.items", "Butchercraft Items");
		this.add("Butchercraft.jei.hook", "Meat Hook");
		this.add("Butchercraft.jei.butcherblock", "Butcher Block");
		this.add("Butchercraft.jei.grinder", "Meat Grinder");
		
		this.add(Butchercraft.MOD_ID + ".tooltip.grinder_tip", "For the Meat Grinder");

		this.add(ButchercraftItems.COOKED_BEEF_SCRAPS.get(), "Cooked Beef Scraps");
		this.add(ButchercraftItems.BEEF_SCRAPS.get(), "Raw Beef Scraps");
		this.add(ButchercraftItems.COOKED_GROUND_BEEF.get(), "Cooked Ground Beef");
		this.add(ButchercraftItems.GROUND_BEEF.get(), "Raw Ground Beef");
		this.add(ButchercraftItems.COOKED_CUBED_BEEF.get(), "Cooked Cubed Beef");
		this.add(ButchercraftItems.CUBED_BEEF.get(), "Raw Cubed Beef");
		this.add(ButchercraftItems.COOKED_BEEF_RIBS.get(), "Cooked Beef Ribs");
		this.add(ButchercraftItems.BEEF_RIBS.get(), "Raw Beef Ribs");
		this.add(ButchercraftItems.COOKED_BEEF_ROAST.get(), "Cooked Beef Roast");
		this.add(ButchercraftItems.BEEF_ROAST.get(), "Raw Beef Roast");

		this.add(ButchercraftItems.BEEF_STEW_MEAT.get(), "Raw Beef Stew Meat");
		this.add(ButchercraftItems.COOKED_BEEF_STEW_MEAT.get(), "Cooked Beef Stew Meat");
		this.add(ButchercraftItems.OXTAIL.get(), "Raw Oxtail");
		this.add(ButchercraftItems.COOKED_OXTAIL.get(), "Cooked Oxtail");

		this.add(ButchercraftItems.COOKED_PORK_SCRAPS.get(), "Cooked Pork Scraps");
		this.add(ButchercraftItems.PORK_SCRAPS.get(), "Raw Pork Scraps");
		this.add(ButchercraftItems.COOKED_GROUND_PORK.get(), "Cooked Ground Pork");
		this.add(ButchercraftItems.GROUND_PORK.get(), "Raw Ground Pork");
		this.add(ButchercraftItems.COOKED_CUBED_PORK.get(), "Cooked Cubed Pork");
		this.add(ButchercraftItems.CUBED_PORK.get(), "Raw Cubed Pork");
		this.add(ButchercraftItems.COOKED_PORK_RIBS.get(), "Cooked Pork Ribs");
		this.add(ButchercraftItems.PORK_RIBS.get(), "Raw Pork Ribs");
		this.add(ButchercraftItems.COOKED_PORK_ROAST.get(), "Cooked Pork Roast");
		this.add(ButchercraftItems.PORK_ROAST.get(), "Raw Pork Roast");
		this.add(ButchercraftItems.PORK_STEW_MEAT.get(), "Raw Pork Stew Meat");
		this.add(ButchercraftItems.COOKED_PORK_STEW_MEAT.get(), "Cooked Pork Stew Meat");

		this.add(ButchercraftItems.COOKED_MUTTON_SCRAPS.get(), "Cooked Mutton Scraps");
		this.add(ButchercraftItems.MUTTON_SCRAPS.get(), "Raw Mutton Scraps");
		this.add(ButchercraftItems.COOKED_GROUND_MUTTON.get(), "Cooked Ground Mutton");
		this.add(ButchercraftItems.GROUND_MUTTON.get(), "Raw Ground Mutton");
		this.add(ButchercraftItems.COOKED_CUBED_MUTTON.get(), "Cooked Cubed Mutton");
		this.add(ButchercraftItems.CUBED_MUTTON.get(), "Raw Cubed Mutton");
		this.add(ButchercraftItems.COOKED_MUTTON_RIBS.get(), "Cooked Mutton Ribs");
		this.add(ButchercraftItems.MUTTON_RIBS.get(), "Raw Mutton Ribs");
		this.add(ButchercraftItems.COOKED_MUTTON_ROAST.get(), "Cooked Mutton Roast");
		this.add(ButchercraftItems.MUTTON_ROAST.get(), "Raw Mutton Roast");
		this.add(ButchercraftItems.MUTTON_STEW_MEAT.get(), "Raw Mutton Stew Meat");
		this.add(ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get(), "Cooked Mutton Stew Meat");

		this.add(ButchercraftItems.COOKED_TRIPE.get(), "Cooked Intestines");
		this.add(ButchercraftItems.TRIPE.get(), "Raw Intestines");
		this.add(ButchercraftItems.COOKED_STOMACH.get(), "Cooked Stomach");
		this.add(ButchercraftItems.STOMACH.get(), "Raw Stomach");
		this.add(ButchercraftItems.COOKED_LUNG.get(), "Cooked Lung");
		this.add(ButchercraftItems.LUNG.get(), "Raw Lung");
		this.add(ButchercraftItems.COOKED_LIVER.get(), "Cooked Liver");
		this.add(ButchercraftItems.LIVER.get(), "Raw Liver");
		this.add(ButchercraftItems.COOKED_KIDNEY.get(), "Cooked Kidney");
		this.add(ButchercraftItems.KIDNEY.get(), "Raw Kidney");
		this.add(ButchercraftItems.COOKED_HEART.get(), "Cooked Heart");
		this.add(ButchercraftItems.HEART.get(), "Raw Heart");
		this.add(ButchercraftItems.COOKED_BRAIN.get(), "Cooked Brain");
		this.add(ButchercraftItems.BRAIN.get(), "Raw Brain");
		this.add(ButchercraftItems.COOKED_TONGUE.get(), "Cooked Tongue");
		this.add(ButchercraftItems.TONGUE.get(), "Raw Tongue");

		this.add(ButchercraftItems.COW_CARCASS.get(), "Cow Carcass");
		this.add(ButchercraftItems.PIG_CARCASS.get(), "Pig Carcass");
		this.add(ButchercraftItems.SHEEP_CARCASS.get(), "Sheep Carcass");

		this.add(ButchercraftItems.BEEF_BLOCK_ITEM.get(), "Raw Beef Block");
		this.add(ButchercraftItems.PORK_BLOCK_ITEM.get(), "Raw Pork Block");
		this.add(ButchercraftItems.MUTTON_BLOCK_ITEM.get(), "Raw Mutton Block");

		this.add(ButchercraftItems.COOKED_BEEF_BLOCK_ITEM.get(), "Cooked Beef Block");
		this.add(ButchercraftItems.COOKED_PORK_BLOCK_ITEM.get(), "Cooked Pork Block");
		this.add(ButchercraftItems.COOKED_MUTTON_BLOCK_ITEM.get(), "Cooked Mutton Block");

		this.add(ButchercraftItems.BUTCHER_KNIFE.get(), "Butcher Knife");
		this.add(ButchercraftItems.SKINNING_KNIFE.get(), "Skinning Knife");
		this.add(ButchercraftItems.BONE_SAW.get(), "Bone Saw");
		this.add(ButchercraftItems.GUT_KNIFE.get(), "Gutting Knife");

		this.add(ButchercraftItems.COW_HIDE.get(), "Cow Hide");
		this.add(ButchercraftItems.PIG_HIDE.get(), "Pig Hide");
		this.add(ButchercraftItems.SHEEP_HIDE.get(), "Sheep Hide");
		this.add(ButchercraftItems.GOAT_HIDE.get(), "Goat Hide");

		this.add(ButchercraftItems.HORN.get(), "Horn");

		this.add(ButchercraftItems.LEATHER_SCRAP.get(), "Leather Scrap");
		this.add(ButchercraftItems.LEATHER_CORD.get(), "Leather Cord");

		this.add(ButchercraftItems.FAT.get(), "Fat");
		this.add(ButchercraftItems.SINEW.get(), "Sinew");
		this.add(ButchercraftItems.LARD.get(), "Lard");
		this.add(ButchercraftItems.GELATIN.get(), "Gelatin");

		this.add(ButchercraftItems.HOOK_BLOCK_ITEM.get(), "Meat Hook");
		this.add(ButchercraftItems.GRINDER_BLOCK_ITEM.get(), "Meat Grinder");
		this.add(ButchercraftItems.EXTRUDER_TIP.get(), "Extruder Tip");
		this.add(ButchercraftItems.GRINDER_TIP.get(), "Grinder Tip");

		this.add(ButchercraftItems.BUTCHER_BLOCK_BLOCK_ITEM.get(), "Butcher Block");

		this.add(ButchercraftItems.GOAT_CARCASS.get(), "Goat Carcass");
		this.add(ButchercraftItems.CHICKEN_CARCASS.get(), "Chicken Carcass");
		this.add(ButchercraftItems.BLACK_RABBIT_CARCASS.get(), "Black Rabbit Carcass");
		this.add(ButchercraftItems.BROWN_RABBIT_CARCASS.get(), "Brown Rabbit Carcass");
		this.add(ButchercraftItems.GOLD_RABBIT_CARCASS.get(), "Gold Rabbit Carcass");
		this.add(ButchercraftItems.SALT_RABBIT_CARCASS.get(), "Salt Rabbit Carcass");
		this.add(ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.get(), "Splotched Rabbit Carcass");
		this.add(ButchercraftItems.WHITE_RABBIT_CARCASS.get(), "White Rabbit Carcass");

		this.add(ButchercraftBlocks.SAUSAGE_BLOCK.get(), "Sausage Block");
		this.add(ButchercraftBlocks.COOKED_SAUSAGE_BLOCK.get(), "Cooked Sausage Block");
		this.add(ButchercraftBlocks.BLOOD_SAUSAGE_BLOCK.get(), "Blood Sausage Block");
		this.add(ButchercraftBlocks.COOKED_BLOOD_SAUSAGE_BLOCK.get(), "Cooked Blood Sausage Block");
		this.add(ButchercraftBlocks.RABBIT_BLOCK.get(), "Rabbit Block");
		this.add(ButchercraftBlocks.COOKED_RABBIT_BLOCK.get(), "Cooked Rabbit Block");
		this.add(ButchercraftBlocks.CHICKEN_BLOCK.get(), "Chicken Block");
		this.add(ButchercraftBlocks.COOKED_CHICKEN_BLOCK.get(), "Cooked Chicken Block");
		this.add(ButchercraftBlocks.GOAT_BLOCK.get(), "Goat Block");
		this.add(ButchercraftBlocks.COOKED_GOAT_BLOCK.get(), "Cooked Goat Block");

		this.add(ButchercraftBlocks.TAXIDERMY_BLACK_RABBIT_BLOCK.get(), "Taxidermied Black Rabbit");
		this.add(ButchercraftBlocks.TAXIDERMY_BROWN_RABBIT_BLOCK.get(), "Taxidermied Brown Rabbit");
		this.add(ButchercraftBlocks.TAXIDERMY_GOLD_RABBIT_BLOCK.get(), "Taxidermied Gold Rabbit");
		this.add(ButchercraftBlocks.TAXIDERMY_SALT_RABBIT_BLOCK.get(), "Taxidermied Salt Rabbit");
		this.add(ButchercraftBlocks.TAXIDERMY_SPLOTCHED_RABBIT_BLOCK.get(), "Taxidermied Splotched Rabbit");
		this.add(ButchercraftBlocks.TAXIDERMY_WHITE_RABBIT_BLOCK.get(), "Taxidermied White Rabbit");

		this.add(ButchercraftItems.RABBIT_BLACK_HEAD_ITEM.get(), "Black Rabbit Head");
		this.add(ButchercraftItems.RABBIT_BROWN_HEAD_ITEM.get(), "Brown Rabbit Head");
		this.add(ButchercraftItems.RABBIT_GOLD_HEAD_ITEM.get(), "Gold Rabbit Head");
		this.add(ButchercraftItems.RABBIT_SALT_HEAD_ITEM.get(), "Salt Rabbit Head");
		this.add(ButchercraftItems.RABBIT_SPLOTCHED_HEAD_ITEM.get(), "Splotched Rabbit Head");
		this.add(ButchercraftItems.RABBIT_WHITE_HEAD_ITEM.get(), "White Rabbit Head");
		this.add(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM.get(), "Rabbit Skull");
		this.add(ButchercraftItems.COW_HEAD_ITEM.get(), "Cow Head");
		this.add(ButchercraftItems.COW_SKULL_HEAD_ITEM.get(), "Cow Skull");
		this.add(ButchercraftItems.SHEEP_HEAD_ITEM.get(), "Sheep Head");
		this.add(ButchercraftItems.SHEEP_SKULL_HEAD_ITEM.get(), "Sheep Skull");
		this.add(ButchercraftItems.PIG_HEAD_ITEM.get(), "Pig Head");
		this.add(ButchercraftItems.PIG_SKULL_HEAD_ITEM.get(), "Pig Skull");
		this.add(ButchercraftItems.GOAT_HEAD_ITEM.get(), "Goat Head");
		this.add(ButchercraftItems.GOAT_SKULL_HEAD_ITEM.get(), "Goat Skull");
		this.add(ButchercraftItems.CHICKEN_HEAD_ITEM.get(), "Chicken Head");
		this.add(ButchercraftItems.CHICKEN_SKULL_HEAD_ITEM.get(), "Chicken Skull");

		this.add(ButchercraftBlocks.TAXIDERMY_CHICKEN_BLOCK.get(), "Taxidermied Chicken");
		this.add(ButchercraftBlocks.TAXIDERMY_COW_BLOCK.get(), "Taxidermied Cow");
		this.add(ButchercraftBlocks.TAXIDERMY_GOAT_BLOCK.get(), "Taxidermied Goat");
		this.add(ButchercraftBlocks.TAXIDERMY_PIG_BLOCK.get(), "Taxidermied Pig");
		this.add(ButchercraftBlocks.TAXIDERMY_SHEEP_BLOCK.get(), "Taxidermied Sheep");

		this.add(ButchercraftItems.GOAT_CHOP.get(), "Raw Chevon Chop");
		this.add(ButchercraftItems.COOKED_GOAT_CHOP.get(), "Cooked Chevon Chop");
		this.add(ButchercraftItems.GOAT_RIBS.get(), "Raw Chevon Ribs");
		this.add(ButchercraftItems.GOAT_ROAST.get(), "Raw Chevon Roast");
		this.add(ButchercraftItems.GOAT_SCRAPS.get(), "Raw Chevon Scraps");
		this.add(ButchercraftItems.GOAT_STEW_MEAT.get(), "Raw Chevon Stew Meat");
		this.add(ButchercraftItems.CUBED_GOAT.get(), "Raw Cubed Chevon");
		this.add(ButchercraftItems.GROUND_GOAT.get(), "Raw Ground Chevon");
		this.add(ButchercraftItems.COOKED_GOAT_RIBS.get(), "Cooked Chevon Ribs");
		this.add(ButchercraftItems.COOKED_GOAT_ROAST.get(), "Cooked Chevon Roast");
		this.add(ButchercraftItems.COOKED_GOAT_SCRAPS.get(), "Cooked Chevon Scraps");
		this.add(ButchercraftItems.COOKED_GOAT_STEW_MEAT.get(), "Cooked Chevon Stew Meat");
		this.add(ButchercraftItems.COOKED_CUBED_GOAT.get(), "Cooked Cubed Chevon");
		this.add(ButchercraftItems.COOKED_GROUND_GOAT.get(), "Cooked Ground Chevon");

		this.add(ButchercraftItems.CHICKEN_BREAST.get(), "Raw Chicken Breast");
		this.add(ButchercraftItems.CHICKEN_LEG.get(), "Raw Chicken Leg");
		this.add(ButchercraftItems.CHICKEN_SCRAPS.get(), "Raw Chicken Scraps");
		this.add(ButchercraftItems.CHICKEN_WING.get(), "Raw Chicken Wing");
		this.add(ButchercraftItems.CHICKEN_THIGH.get(), "Raw Chicken Thigh");
		this.add(ButchercraftItems.CUBED_CHICKEN.get(), "Raw Cubed Chicken");
		this.add(ButchercraftItems.GROUND_CHICKEN.get(), "Raw Ground Chicken");
		this.add(ButchercraftItems.STEW_CHICKEN.get(), "Raw Stew Chicken");
		this.add(ButchercraftItems.COOKED_CHICKEN_BREAST.get(), "Cooked Chicken Breast");
		this.add(ButchercraftItems.COOKED_CHICKEN_LEG.get(), "Cooked Chicken Leg");
		this.add(ButchercraftItems.COOKED_CHICKEN_SCRAPS.get(), "Cooked Chicken Scraps");
		this.add(ButchercraftItems.COOKED_CHICKEN_WING.get(), "Cooked Chicken Wing");
		this.add(ButchercraftItems.COOKED_CHICKEN_THIGH.get(), "Cooked Chicken Thigh");
		this.add(ButchercraftItems.COOKED_CUBED_CHICKEN.get(), "Cooked Cubed Chicken");
		this.add(ButchercraftItems.COOKED_GROUND_CHICKEN.get(), "Cooked Ground Chicken");
		this.add(ButchercraftItems.COOKED_STEW_CHICKEN.get(), "Cooked Stew Chicken");

		this.add(ButchercraftItems.RABBIT_LEG.get(), "Raw Rabbit Leg");
		this.add(ButchercraftItems.RABBIT_SADDLE.get(), "Raw Rabbit Saddle");
		this.add(ButchercraftItems.RABBIT_SCRAPS.get(), "Raw Rabbit Scrap");
		this.add(ButchercraftItems.RABBIT_THIGH.get(), "Raw Rabbit Thigh");
		this.add(ButchercraftItems.CUBED_RABBIT.get(), "Raw Cubed Rabbit");
		this.add(ButchercraftItems.GROUND_RABBIT.get(), "Raw Ground Rabbit");
		this.add(ButchercraftItems.STEW_RABBIT.get(), "Raw Stew Rabbit");
		this.add(ButchercraftItems.COOKED_RABBIT_LEG.get(), "Cooked Rabbit Leg");
		this.add(ButchercraftItems.COOKED_RABBIT_SADDLE.get(), "Cooked Rabbit Saddle");
		this.add(ButchercraftItems.COOKED_RABBIT_SCRAPS.get(), "Cooked Rabbit Scrap");
		this.add(ButchercraftItems.COOKED_RABBIT_THIGH.get(), "Cooked Rabbit Thigh");
		this.add(ButchercraftItems.COOKED_CUBED_RABBIT.get(), "Cooked Cubed Rabbit");
		this.add(ButchercraftItems.COOKED_GROUND_RABBIT.get(), "Cooked Ground Rabbit");
		this.add(ButchercraftItems.COOKED_STEW_RABBIT.get(), "Cooked Stew Rabbit");

		this.add(ButchercraftItems.EYEBALL.get(), "Eyeball");
		this.add(ButchercraftItems.COOKED_EYEBALL.get(), "Cooked Eyeball");
		this.add(ButchercraftItems.WATTLE.get(), "Wattle");
		this.add(ButchercraftItems.COOKED_WATTLE.get(), "Cooked Wattle");
		this.add(ButchercraftItems.CASING.get(), "Casing");
		this.add(ButchercraftItems.BEAK.get(), "Beak");

		this.add(ButchercraftItems.BLACK_BUNNY_EARS.get(), "Black Bunny Ears");
		this.add(ButchercraftItems.BROWN_BUNNY_EARS.get(), "Brown Bunny Ears");
		this.add(ButchercraftItems.GOLD_BUNNY_EARS.get(), "Gold Bunny Ears");
		this.add(ButchercraftItems.SALT_BUNNY_EARS.get(), "Salt Bunny Ears");
		this.add(ButchercraftItems.SPLOTCHED_BUNNY_EARS.get(), "Splotched Bunny Ears");
		this.add(ButchercraftItems.WHITE_BUNNY_EARS.get(), "White Bunny Ears");

		this.add(ButchercraftItems.BLACK_BUNNY_TAIL.get(), "Black Bunny Tail");
		this.add(ButchercraftItems.BROWN_BUNNY_TAIL.get(), "Brown Bunny Tail");
		this.add(ButchercraftItems.GOLD_BUNNY_TAIL.get(), "Gold Bunny Tail");
		this.add(ButchercraftItems.SALT_BUNNY_TAIL.get(), "Salt Bunny Tail");
		this.add(ButchercraftItems.SPLOTCHED_BUNNY_TAIL.get(), "Splotched Bunny Tail");
		this.add(ButchercraftItems.WHITE_BUNNY_TAIL.get(), "White Bunny Tail");

		this.add(ButchercraftItems.COW_HOOD.get(), "Cow Hood");
		this.add(ButchercraftItems.GOAT_HOOD.get(), "Goat Hood");
		this.add(ButchercraftItems.PIG_HOOD.get(), "Pig Hood");
		this.add(ButchercraftItems.SHEEP_HOOD.get(), "Sheep Hood");
		this.add(ButchercraftItems.CHICKEN_MASK.get(), "Chicken Mask");

		this.add(ButchercraftItems.SAUSAGE_LINKED.get(), "Linked Sausage");
		this.add(ButchercraftItems.SAUSAGE.get(), "Raw Sausage");
		this.add(ButchercraftItems.COOKED_SAUSAGE.get(), "Cooked Sausage");

		this.add(ButchercraftItems.BLOOD_SAUSAGE_LINKED.get(), "Linked Blood Sausage");
		this.add(ButchercraftItems.BLOOD_SAUSAGE_MIX.get(), "Blood Sausage Mix");
		this.add(ButchercraftItems.BLOOD_SAUSAGE.get(), "Raw Blood Sausage");
		this.add(ButchercraftItems.COOKED_BLOOD_SAUSAGE.get(), "Cooked Blood Sausage");

		this.add(ButchercraftItems.MASK.get(), "Butcher's Mask");
		this.add(ButchercraftItems.PAPER_HAT.get(), "Paper Hat");
		this.add(ButchercraftItems.APRON.get(), "Butcher's Apron");
		this.add(ButchercraftItems.GLOVES.get(), "Butcher's Gloves");
		this.add(ButchercraftItems.BOOTS.get(), "Butcher's Boots");

		this.add(ButchercraftItems.SOAP.get(), "Soap");

		this.add(ButchercraftItems.BLOOD_FLUID_BOTTLE.get(), "Bottle of Blood");
		this.add(ButchercraftItems.BLOOD_FLUID_BUCKET.get(), "Bucket of Blood");

		this.add(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get(), "Barn Wood");
		this.add(ButchercraftItems.BARN_WOOD_DOOR_ITEM.get(), "Barn Wood Door");
		this.add(ButchercraftItems.BARN_WOOD_FENCE_GATE_ITEM.get(), "Barn Wood Fence Gate");
		this.add(ButchercraftItems.BARN_WOOD_FENCE_ITEM.get(), "Barn Wood Fence");
		this.add(ButchercraftItems.BARN_WOOD_SLAB_ITEM.get(), "Barn Wood Slab");
		this.add(ButchercraftItems.BARN_WOOD_STAIRS_ITEM.get(), "Barn Wood Stairs");
		this.add(ButchercraftItems.BARN_WOOD_TRAPDOOR_ITEM.get(), "Barn Wood Trapdoor");
		this.add(ButchercraftItems.TRIMMED_BARN_WOOD_ITEM.get(), "Trimmed Barn Wood (CTM)");

		this.add(ButchercraftBlocks.BLOOD_FLUID_BLOCK.get(), "Blood");

		// Advancements
		this.add(Butchercraft.MOD_ID + ".advancement.root.name", "Butchercraft");
		this.add(Butchercraft.MOD_ID + ".advancement.root.desc", "Welcome to Butchercraft!");

		this.add(Butchercraft.MOD_ID + ".advancement.hook.name", "On the hook");
		this.add(Butchercraft.MOD_ID + ".advancement.hook.desc", "Craft a Meat Hook");

		this.add(Butchercraft.MOD_ID + ".advancement.butcherknife.name", "Baker and Candlestick maker.");
		this.add(Butchercraft.MOD_ID + ".advancement.butcherknife.desc", "Craft a Butcher Knife");

		this.add(Butchercraft.MOD_ID + ".advancement.skinningknife.name", "A very close shave.");
		this.add(Butchercraft.MOD_ID + ".advancement.skinningknife.desc", "Craft a Skinning Knife");

		this.add(Butchercraft.MOD_ID + ".advancement.gutknife.name", "You've got guts kid.");
		this.add(Butchercraft.MOD_ID + ".advancement.gutknife.desc", "Craft a Gutting Knife");

		this.add(Butchercraft.MOD_ID + ".advancement.bonesaw.name", "Skeleton's Nightmare.");
		this.add(Butchercraft.MOD_ID + ".advancement.bonesaw.desc", "Craft a Bone Saw");

		this.add(Butchercraft.MOD_ID + ".advancement.cow.name", "Where's the Beef?");
		this.add(Butchercraft.MOD_ID + ".advancement.cow.desc", "Use a Butcher Knife on a Cow (Right Click)");

		this.add(Butchercraft.MOD_ID + ".advancement.pig.name", "The Other White Meat");
		this.add(Butchercraft.MOD_ID + ".advancement.pig.desc", "Use a Butcher Knife on a Pig (Right Click)");

		this.add(Butchercraft.MOD_ID + ".advancement.sheep.name", "Me Thinks it's Mutton-tastic");
		this.add(Butchercraft.MOD_ID + ".advancement.sheep.desc", "Use a Butcher Knife on a Sheep (Right Click)");

		this.add(Butchercraft.MOD_ID + ".advancement.whole_cow.name", "Everything but the Moo.");
		this.add(Butchercraft.MOD_ID + ".advancement.whole_cow.desc", "Eat every edible Cooked Beef item.");

		this.add(Butchercraft.MOD_ID + ".advancement.whole_pig.name", "Everything but the Oink.");
		this.add(Butchercraft.MOD_ID + ".advancement.whole_pig.desc", "Eat every edible Cooked Pork item.");

		this.add(Butchercraft.MOD_ID + ".advancement.whole_sheep.name", "Everything but the Bleat.");
		this.add(Butchercraft.MOD_ID + ".advancement.whole_sheep.desc", "Eat every edible Cooked Mutton item.");

		this.add(Butchercraft.MOD_ID + ".advancement.everything.name", "A Little Bit of Everything");
		this.add(Butchercraft.MOD_ID + ".advancement.everything.desc", "Eat all Cooked Meat.");

		this.add(Butchercraft.MOD_ID + ".advancement.everything_plus.name", "I said everything!");
		this.add(Butchercraft.MOD_ID + ".advancement.everything_plus.desc", "Eat all Cooked Edible Parts.");

		this.add(Butchercraft.MOD_ID + ".advancement.heart.name", "Eat your heart out.");
		this.add(Butchercraft.MOD_ID + ".advancement.heart.desc", "Eat a raw Heart.");

		this.add(Butchercraft.MOD_ID + ".advancement.cannibalism.name", "This isn't RimWorld...");
		this.add(Butchercraft.MOD_ID + ".advancement.cannibalism.desc", "Try to butcher a human.");

		this.add(Butchercraft.MOD_ID + ".advancement.bunny_equip.name", "Leotard and Hosery not included!");
		this.add(Butchercraft.MOD_ID + ".advancement.bunny_equip.desc", "Equip Bunny Ears and a Tail.");

		this.add(Butchercraft.MOD_ID + ".advancement.taxadermy.name", "No thanks, I'm stuffed.");
		this.add(Butchercraft.MOD_ID + ".advancement.taxadermy.desc", "Taxidermy a Carcass.");

		this.add(Butchercraft.MOD_ID + ".advancement.hat.name", "How may I take your order?");
		this.add(Butchercraft.MOD_ID + ".advancement.hat.desc", "Make a Paper Hat");

		this.add(Butchercraft.MOD_ID + ".advancement.grinder.name", "Twisted Fun Factory");
		this.add(Butchercraft.MOD_ID + ".advancement.grinder.desc", "Make a Meat Grinder");

		this.add(Butchercraft.MOD_ID + ".advancement.extruder.name", "3..2..1..");
		this.add(Butchercraft.MOD_ID + ".advancement.extruder.desc", "Make an Extruder Tip");

		this.add(Butchercraft.MOD_ID + ".advancement.grinder_tip.name", "The Daily Grind");
		this.add(Butchercraft.MOD_ID + ".advancement.grinder_tip.desc", "Make a Grinder Tip");

		this.add(Butchercraft.MOD_ID + ".advancement.sausage.name", "Let's Sausage!");
		this.add(Butchercraft.MOD_ID + ".advancement.sausage.desc", "Make a Sausage");

		this.add(Butchercraft.MOD_ID + ".advancement.goat.name", "Greatest Of All Time?");
		this.add(Butchercraft.MOD_ID + ".advancement.goat.desc", "Use a Butcher Knife on a Goat (Right Click)");

		this.add(Butchercraft.MOD_ID + ".advancement.whole_goat.name", "Everything but the Scream.");
		this.add(Butchercraft.MOD_ID + ".advancement.whole_goat.desc", "Eat every edible cooked chevon item.");

		this.add(Butchercraft.MOD_ID + ".advancement.hands.name", "Ya Filthy Animal");
		this.add(Butchercraft.MOD_ID + ".advancement.hands.desc", "Get the Dirty Hands Effect");

		this.add(Butchercraft.MOD_ID + ".advancement.bloody.name", "Blood On Your Hands");
		this.add(Butchercraft.MOD_ID + ".advancement.bloody.desc", "Get the Blood Splattered Effect");

		this.add(Butchercraft.MOD_ID + ".advancement.trail.name", "You Can't Hide");
		this.add(Butchercraft.MOD_ID + ".advancement.trail.desc", "Get the Bloody Trail Effect");

		this.add(Butchercraft.MOD_ID + ".advancement.stink.name", "Stink, Stank, Stunk");
		this.add(Butchercraft.MOD_ID + ".advancement.stink.desc", "Get the Pungent Reek Effect");

		this.add(Butchercraft.MOD_ID + ".advancement.gloves.name", "Clean Hands, Safe Hands");
		this.add(Butchercraft.MOD_ID + ".advancement.gloves.desc", "Make Gloves to prevent the Dirty Hands Effect");

		this.add(Butchercraft.MOD_ID + ".advancement.apron.name", "Kiss the Cook!");
		this.add(Butchercraft.MOD_ID + ".advancement.apron.desc",
				"Make an Apron to prevent the Blood Splattered Effect");

		this.add(Butchercraft.MOD_ID + ".advancement.boots.name", "Made for Walking");
		this.add(Butchercraft.MOD_ID + ".advancement.boots.desc",
				"Make Rubber Boots to prevent the Bloody Trail Effect");

		this.add(Butchercraft.MOD_ID + ".advancement.mask.name", "Wear a Mask!");
		this.add(Butchercraft.MOD_ID + ".advancement.mask.desc", "Make a Mask to prevent the Pungent Reek Effect");

		this.add(Butchercraft.MOD_ID + ".advancement.soap.name", "You Stink. Take a Bath.");
		this.add(Butchercraft.MOD_ID + ".advancement.soap.desc", "Make some Soap");

		this.add(Butchercraft.MOD_ID + ".advancement.chicken.name", "Winner Winner");
		this.add(Butchercraft.MOD_ID + ".advancement.chicken.desc", "Use a Butcher Knife on a Chicken (Right Click)");

		this.add(Butchercraft.MOD_ID + ".advancement.whole_chicken.name", "Everything but the Cluck.");
		this.add(Butchercraft.MOD_ID + ".advancement.whole_chicken.desc", "Eat every edible Cooked Chicken item.");

		this.add(Butchercraft.MOD_ID + ".advancement.rabbit.name", "Bopped on the Head");
		this.add(Butchercraft.MOD_ID + ".advancement.rabbit.desc", "Use a Butcher Knife on a Rabbit (Right Click)");

		this.add(Butchercraft.MOD_ID + ".advancement.whole_rabbit.name", "Everything but the Squeak.");
		this.add(Butchercraft.MOD_ID + ".advancement.whole_rabbit.desc", "Eat every edible Cooked Rabbit item.");

		this.add(Butchercraft.MOD_ID + ".advancement.butcherblock.name", "Chopping Block");
		this.add(Butchercraft.MOD_ID + ".advancement.butcherblock.desc", "Make a Butcher Block.");

		this.add(Butchercraft.MOD_ID + ".advancement.blood.name", "For the Blood God!");
		this.add(Butchercraft.MOD_ID + ".advancement.blood.desc", "Aquire a Bucket of Blood");
		
		this.add(Butchercraft.MOD_ID + ".advancement.barn_wood.name", "Target Practice");
		this.add(Butchercraft.MOD_ID + ".advancement.barn_wood.desc", "Make some Barn Wood");

		this.add(Butchercraft.MOD_ID + ".butcherknife.rightclick", "Right click to slaughter.");
		
		this.add("effect." + Butchercraft.MOD_ID + ".pungent_reek", "Pungent Reek");
		this.add("effect." + Butchercraft.MOD_ID + ".dirty_hands", "Dirty Hands");
		this.add("effect." + Butchercraft.MOD_ID + ".blood_splatter", "Bloody");
		this.add("effect." + Butchercraft.MOD_ID + ".blood_trail", "Blood Trail");
	}

}