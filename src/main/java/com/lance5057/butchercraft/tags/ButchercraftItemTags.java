package com.lance5057.butchercraft.tags;

import com.lance5057.butchercraft.Butchercraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ButchercraftItemTags {
	public static final TagKey<Item> COW_CARCASS = butcherTag("cow_carcass");
	public static final TagKey<Item> PIG_CARCASS = butcherTag("pig_carcass");
	public static final TagKey<Item> SHEEP_CARCASS = butcherTag("sheep_carcass");
	public static final TagKey<Item> CHICKEN_CARCASS = butcherTag("chicken_carcass");
	public static final TagKey<Item> RABBIT_CARCASS = butcherTag("rabbit_carcass");
	public static final TagKey<Item> GOAT_CARCASS = butcherTag("goat_carcass");

	// Generic Meat
	public static final TagKey<Item> MEAT = neoforgeItemTag("meat");
	public static final TagKey<Item> MEAT_RAW = neoforgeItemTag("meat/raw");
	public static final TagKey<Item> MEAT_COOKED = neoforgeItemTag("meat/cooked");

	public static final TagKey<Item> SCRAP_MEAT = neoforgeItemTag("meat/scrap");
	public static final TagKey<Item> SCRAP_MEAT_RAW = neoforgeItemTag("meat/scrap/raw");
	public static final TagKey<Item> SCRAP_MEAT_COOKED = neoforgeItemTag("meat/scrap/cooked");

	public static final TagKey<Item> ROAST = neoforgeItemTag("meat/roast");
	public static final TagKey<Item> ROAST_RAW = neoforgeItemTag("meat/roast/raw");
	public static final TagKey<Item> ROAST_COOKED = neoforgeItemTag("meat/roast/cooked");

	public static final TagKey<Item> RIBS = neoforgeItemTag("meat/ribs");
	public static final TagKey<Item> RIBS_RAW = neoforgeItemTag("meat/ribs/raw");
	public static final TagKey<Item> RIBS_COOKED = neoforgeItemTag("meat/ribs/cooked");

	public static final TagKey<Item> CUBED_MEAT = neoforgeItemTag("meat/cubed");
	public static final TagKey<Item> CUBED_MEAT_RAW = neoforgeItemTag("meat/cubed/raw");
	public static final TagKey<Item> CUBED_MEAT_COOKED = neoforgeItemTag("meat/cubed/cooked");

	public static final TagKey<Item> STEW_MEAT = neoforgeItemTag("meat/stew");
	public static final TagKey<Item> STEW_MEAT_RAW = neoforgeItemTag("meat/stew/raw");
	public static final TagKey<Item> STEW_MEAT_COOKED = neoforgeItemTag("meat/stew/cooked");

	public static final TagKey<Item> GROUND_MEAT = neoforgeItemTag("ground_meat");
	public static final TagKey<Item> GROUND_MEAT_RAW = neoforgeItemTag("ground_meat/raw");
	public static final TagKey<Item> GROUND_MEAT_COOKED = neoforgeItemTag("ground_meat/cooked");

	// Beef
	public static final TagKey<Item> BEEF = neoforgeItemTag("beef");
	public static final TagKey<Item> SCRAP_BEEF = neoforgeItemTag("beef/scrap");
	public static final TagKey<Item> BEEF_ROAST = neoforgeItemTag("beef/roast");
	public static final TagKey<Item> BEEF_RIBS = neoforgeItemTag("beef/ribs");
	public static final TagKey<Item> CUBED_BEEF = neoforgeItemTag("beef/cubed");
	public static final TagKey<Item> STEW_BEEF = neoforgeItemTag("beef/stew");
	public static final TagKey<Item> GROUND_BEEF = neoforgeItemTag("beef/ground");
	public static final TagKey<Item> OXTAIL = neoforgeItemTag("beef/oxtail");

	public static final TagKey<Item> BEEF_RAW = neoforgeItemTag("beef/raw");
	public static final TagKey<Item> SCRAP_BEEF_RAW = neoforgeItemTag("beef/scrap/raw");
	public static final TagKey<Item> BEEF_ROAST_RAW = neoforgeItemTag("beef/roast/raw");
	public static final TagKey<Item> BEEF_RIBS_RAW = neoforgeItemTag("beef/ribs/raw");
	public static final TagKey<Item> CUBED_BEEF_RAW = neoforgeItemTag("beef/cubed/raw");
	public static final TagKey<Item> STEW_BEEF_RAW = neoforgeItemTag("beef/stew/raw");
	public static final TagKey<Item> GROUND_BEEF_RAW = neoforgeItemTag("beef/ground/raw");
	public static final TagKey<Item> OXTAIL_RAW = neoforgeItemTag("beef/oxtail/raw");

	public static final TagKey<Item> BEEF_COOKED = neoforgeItemTag("beef/cooked");
	public static final TagKey<Item> SCRAP_BEEF_COOKED = neoforgeItemTag("beef/scrap/cooked");
	public static final TagKey<Item> BEEF_ROAST_COOKED = neoforgeItemTag("beef/roast/cooked");
	public static final TagKey<Item> BEEF_RIBS_COOKED = neoforgeItemTag("beef/ribs/cooked");
	public static final TagKey<Item> CUBED_BEEF_COOKED = neoforgeItemTag("beef/cubed/cooked");
	public static final TagKey<Item> STEW_BEEF_COOKED = neoforgeItemTag("beef/stew/cooked");
	public static final TagKey<Item> GROUND_BEEF_COOKED = neoforgeItemTag("beef/ground/cooked");
	public static final TagKey<Item> OXTAIL_COOKED = neoforgeItemTag("beef/oxtail/cooked");

	// Pork
	public static final TagKey<Item> PORK = neoforgeItemTag("pork");
	public static final TagKey<Item> SCRAP_PORK = neoforgeItemTag("pork/scrap");
	public static final TagKey<Item> PORK_ROAST = neoforgeItemTag("pork/roast");
	public static final TagKey<Item> PORK_RIBS = neoforgeItemTag("pork/ribs");
	public static final TagKey<Item> CUBED_PORK = neoforgeItemTag("pork/cubed");
	public static final TagKey<Item> STEW_PORK = neoforgeItemTag("pork/stew");
	public static final TagKey<Item> GROUND_PORK = neoforgeItemTag("pork/ground");

	public static final TagKey<Item> PORK_RAW = neoforgeItemTag("pork/raw");
	public static final TagKey<Item> SCRAP_PORK_RAW = neoforgeItemTag("pork/scrap/raw");
	public static final TagKey<Item> PORK_ROAST_RAW = neoforgeItemTag("pork/roast/raw");
	public static final TagKey<Item> PORK_RIBS_RAW = neoforgeItemTag("pork/ribs/raw");
	public static final TagKey<Item> CUBED_PORK_RAW = neoforgeItemTag("pork/cubed/raw");
	public static final TagKey<Item> STEW_PORK_RAW = neoforgeItemTag("pork/stew/raw");
	public static final TagKey<Item> GROUND_PORK_RAW = neoforgeItemTag("pork/ground/raw");

	public static final TagKey<Item> PORK_COOKED = neoforgeItemTag("pork/cooked");
	public static final TagKey<Item> SCRAP_PORK_COOKED = neoforgeItemTag("pork/scrap/cooked");
	public static final TagKey<Item> PORK_ROAST_COOKED = neoforgeItemTag("pork/roast/cooked");
	public static final TagKey<Item> PORK_RIBS_COOKED = neoforgeItemTag("pork/ribs/cooked");
	public static final TagKey<Item> CUBED_PORK_COOKED = neoforgeItemTag("pork/cubed/cooked");
	public static final TagKey<Item> STEW_PORK_COOKED = neoforgeItemTag("pork/stew/cooked");
	public static final TagKey<Item> GROUND_PORK_COOKED = neoforgeItemTag("pork/ground/cooked");

	// Mutton
	public static final TagKey<Item> MUTTON = neoforgeItemTag("mutton");
	public static final TagKey<Item> SCRAP_MUTTON = neoforgeItemTag("mutton/scrap");
	public static final TagKey<Item> MUTTON_ROAST = neoforgeItemTag("mutton/roast");
	public static final TagKey<Item> MUTTON_RIBS = neoforgeItemTag("mutton/ribs");
	public static final TagKey<Item> CUBED_MUTTON = neoforgeItemTag("mutton/cubed");
	public static final TagKey<Item> STEW_MUTTON = neoforgeItemTag("mutton/stew");
	public static final TagKey<Item> GROUND_MUTTON = neoforgeItemTag("mutton/ground");

	public static final TagKey<Item> MUTTON_RAW = neoforgeItemTag("mutton/raw");
	public static final TagKey<Item> SCRAP_MUTTON_RAW = neoforgeItemTag("mutton/scrap/raw");
	public static final TagKey<Item> MUTTON_ROAST_RAW = neoforgeItemTag("mutton/roast/raw");
	public static final TagKey<Item> MUTTON_RIBS_RAW = neoforgeItemTag("mutton/ribs/raw");
	public static final TagKey<Item> CUBED_MUTTON_RAW = neoforgeItemTag("mutton/cubed/raw");
	public static final TagKey<Item> STEW_MUTTON_RAW = neoforgeItemTag("mutton/stew/raw");
	public static final TagKey<Item> GROUND_MUTTON_RAW = neoforgeItemTag("mutton/ground/raw");

	public static final TagKey<Item> MUTTON_COOKED = neoforgeItemTag("mutton/cooked");
	public static final TagKey<Item> SCRAP_MUTTON_COOKED = neoforgeItemTag("mutton/scrap/cooked");
	public static final TagKey<Item> MUTTON_ROAST_COOKED = neoforgeItemTag("mutton/roast/cooked");
	public static final TagKey<Item> MUTTON_RIBS_COOKED = neoforgeItemTag("mutton/ribs/cooked");
	public static final TagKey<Item> CUBED_MUTTON_COOKED = neoforgeItemTag("mutton/cubed/cooked");
	public static final TagKey<Item> STEW_MUTTON_COOKED = neoforgeItemTag("mutton/stew/cooked");
	public static final TagKey<Item> GROUND_MUTTON_COOKED = neoforgeItemTag("mutton/ground/cooked");

	// goat
	public static final TagKey<Item> GOAT = neoforgeItemTag("goat");
	public static final TagKey<Item> SCRAP_GOAT = neoforgeItemTag("goat/scrap");
	public static final TagKey<Item> GOAT_ROAST = neoforgeItemTag("goat/roast");
	public static final TagKey<Item> GOAT_RIBS = neoforgeItemTag("goat/ribs");
	public static final TagKey<Item> CUBED_GOAT = neoforgeItemTag("goat/cubed");
	public static final TagKey<Item> STEW_GOAT = neoforgeItemTag("goat/stew");
	public static final TagKey<Item> GROUND_GOAT = neoforgeItemTag("goat/ground");

	public static final TagKey<Item> GOAT_RAW = neoforgeItemTag("goat/raw");
	public static final TagKey<Item> SCRAP_GOAT_RAW = neoforgeItemTag("goat/scrap/raw");
	public static final TagKey<Item> GOAT_ROAST_RAW = neoforgeItemTag("goat/roast/raw");
	public static final TagKey<Item> GOAT_RIBS_RAW = neoforgeItemTag("goat/ribs/raw");
	public static final TagKey<Item> CUBED_GOAT_RAW = neoforgeItemTag("goat/cubed/raw");
	public static final TagKey<Item> STEW_GOAT_RAW = neoforgeItemTag("goat/stew/raw");
	public static final TagKey<Item> GROUND_GOAT_RAW = neoforgeItemTag("goat/ground/raw");

	public static final TagKey<Item> GOAT_COOKED = neoforgeItemTag("goat/cooked");
	public static final TagKey<Item> SCRAP_GOAT_COOKED = neoforgeItemTag("goat/scrap/cooked");
	public static final TagKey<Item> GOAT_ROAST_COOKED = neoforgeItemTag("goat/roast/cooked");
	public static final TagKey<Item> GOAT_RIBS_COOKED = neoforgeItemTag("goat/ribs/cooked");
	public static final TagKey<Item> CUBED_GOAT_COOKED = neoforgeItemTag("goat/cubed/cooked");
	public static final TagKey<Item> STEW_GOAT_COOKED = neoforgeItemTag("goat/stew/cooked");
	public static final TagKey<Item> GROUND_GOAT_COOKED = neoforgeItemTag("goat/ground/cooked");

	// Chicken
	public static final TagKey<Item> CHICKEN = neoforgeItemTag("chicken");
	public static final TagKey<Item> SCRAP_CHICKEN = neoforgeItemTag("chicken/scrap");
	public static final TagKey<Item> CUBED_CHICKEN = neoforgeItemTag("chicken/cubed");
	public static final TagKey<Item> STEW_CHICKEN = neoforgeItemTag("chicken/stew");
	public static final TagKey<Item> CHICKEN_BREAST = neoforgeItemTag("chicken/breast");
	public static final TagKey<Item> CHICKEN_THIGH = neoforgeItemTag("chicken/thigh");
	public static final TagKey<Item> CHICKEN_LEG = neoforgeItemTag("chicken/leg");
	public static final TagKey<Item> CHICKEN_WING = neoforgeItemTag("chicken/wing");
	public static final TagKey<Item> GROUND_CHICKEN = neoforgeItemTag("chicken/ground");

	public static final TagKey<Item> CHICKEN_RAW = neoforgeItemTag("chicken/raw");
	public static final TagKey<Item> SCRAP_CHICKEN_RAW = neoforgeItemTag("chicken/scrap/raw");
	public static final TagKey<Item> CUBED_CHICKEN_RAW = neoforgeItemTag("chicken/cubed/raw");
	public static final TagKey<Item> STEW_CHICKEN_RAW = neoforgeItemTag("chicken/stew/raw");
	public static final TagKey<Item> CHICKEN_BREAST_RAW = neoforgeItemTag("chicken/breast/raw");
	public static final TagKey<Item> CHICKEN_THIGH_RAW = neoforgeItemTag("chicken/thigh/raw");
	public static final TagKey<Item> CHICKEN_LEG_RAW = neoforgeItemTag("chicken/leg/raw");
	public static final TagKey<Item> CHICKEN_WING_RAW = neoforgeItemTag("chicken/wing/raw");
	public static final TagKey<Item> GROUND_CHICKEN_RAW = neoforgeItemTag("chicken/ground/raw");

	public static final TagKey<Item> CHICKEN_COOKED = neoforgeItemTag("chicken/cooked");
	public static final TagKey<Item> SCRAP_CHICKEN_COOKED = neoforgeItemTag("chicken/scrap/cooked");
	public static final TagKey<Item> CUBED_CHICKEN_COOKED = neoforgeItemTag("chicken/cubed/cooked");
	public static final TagKey<Item> STEW_CHICKEN_COOKED = neoforgeItemTag("chicken/stew/cooked");
	public static final TagKey<Item> CHICKEN_BREAST_COOKED = neoforgeItemTag("chicken/breast/cooked");
	public static final TagKey<Item> CHICKEN_THIGH_COOKED = neoforgeItemTag("chicken/thigh/cooked");
	public static final TagKey<Item> CHICKEN_LEG_COOKED = neoforgeItemTag("chicken/leg/cooked");
	public static final TagKey<Item> CHICKEN_WING_COOKED = neoforgeItemTag("chicken/wing/cooked");
	public static final TagKey<Item> GROUND_CHICKEN_COOKED = neoforgeItemTag("chicken/ground/cooked");

	// Chicken
	public static final TagKey<Item> RABBIT = neoforgeItemTag("rabbit");
	public static final TagKey<Item> SCRAP_RABBIT = neoforgeItemTag("rabbit/scrap");
	public static final TagKey<Item> CUBED_RABBIT = neoforgeItemTag("rabbit/cubed");
	public static final TagKey<Item> STEW_RABBIT = neoforgeItemTag("rabbit/stew");
	public static final TagKey<Item> RABBIT_SADDLE = neoforgeItemTag("rabbit/saddle");
	public static final TagKey<Item> RABBIT_THIGH = neoforgeItemTag("rabbit/thigh");
	public static final TagKey<Item> RABBIT_LEG = neoforgeItemTag("rabbit/leg");
	public static final TagKey<Item> GROUND_RABBIT = neoforgeItemTag("rabbit/ground");

	public static final TagKey<Item> RABBIT_RAW = neoforgeItemTag("rabbit/raw");
	public static final TagKey<Item> SCRAP_RABBIT_RAW = neoforgeItemTag("rabbit/scrap/raw");
	public static final TagKey<Item> CUBED_RABBIT_RAW = neoforgeItemTag("rabbit/cubed/raw");
	public static final TagKey<Item> STEW_RABBIT_RAW = neoforgeItemTag("rabbit/stew/raw");
	public static final TagKey<Item> RABBIT_SADDLE_RAW = neoforgeItemTag("rabbit/saddle/raw");
	public static final TagKey<Item> RABBIT_THIGH_RAW = neoforgeItemTag("rabbit/thigh/raw");
	public static final TagKey<Item> RABBIT_LEG_RAW = neoforgeItemTag("rabbit/leg/raw");
	public static final TagKey<Item> GROUND_RABBIT_RAW = neoforgeItemTag("rabbit/ground/raw");

	public static final TagKey<Item> RABBIT_COOKED = neoforgeItemTag("rabbit/cooked");
	public static final TagKey<Item> SCRAP_RABBIT_COOKED = neoforgeItemTag("rabbit/scrap/cooked");
	public static final TagKey<Item> CUBED_RABBIT_COOKED = neoforgeItemTag("rabbit/cubed/cooked");
	public static final TagKey<Item> STEW_RABBIT_COOKED = neoforgeItemTag("rabbit/stew/cooked");
	public static final TagKey<Item> RABBIT_SADDLE_COOKED = neoforgeItemTag("rabbit/saddle/cooked");
	public static final TagKey<Item> RABBIT_THIGH_COOKED = neoforgeItemTag("rabbit/thigh/cooked");
	public static final TagKey<Item> RABBIT_LEG_COOKED = neoforgeItemTag("rabbit/leg/cooked");
	public static final TagKey<Item> GROUND_RABBIT_COOKED = neoforgeItemTag("rabbit/ground/cooked");

	// Guts
	public static final TagKey<Item> OFFAL = neoforgeItemTag("offal");
	public static final TagKey<Item> OFFAL_RAW = neoforgeItemTag("offal/raw");
	public static final TagKey<Item> OFFAL_COOKED = neoforgeItemTag("offal/cooked");

	public static final TagKey<Item> TRIPE = neoforgeItemTag("tripe");
	public static final TagKey<Item> TRIPE_RAW = neoforgeItemTag("tripe/raw");
	public static final TagKey<Item> TRIPE_COOKED = neoforgeItemTag("tripe/cooked");

	public static final TagKey<Item> STOMACH = neoforgeItemTag("stomach");
	public static final TagKey<Item> STOMACH_RAW = neoforgeItemTag("stomach/raw");
	public static final TagKey<Item> STOMACH_COOKED = neoforgeItemTag("stomach/cooked");

	public static final TagKey<Item> LUNG = neoforgeItemTag("lung");
	public static final TagKey<Item> LUNG_RAW = neoforgeItemTag("lung/raw");
	public static final TagKey<Item> LUNG_COOKED = neoforgeItemTag("lung/cooked");

	public static final TagKey<Item> LIVER = neoforgeItemTag("liver");
	public static final TagKey<Item> LIVER_RAW = neoforgeItemTag("liver/raw");
	public static final TagKey<Item> LIVER_COOKED = neoforgeItemTag("liver/cooked");

	public static final TagKey<Item> KIDNEY = neoforgeItemTag("kidney");
	public static final TagKey<Item> KIDNEY_RAW = neoforgeItemTag("kidney/raw");
	public static final TagKey<Item> KIDNEY_COOKED = neoforgeItemTag("kidney/cooked");

	public static final TagKey<Item> HEART = neoforgeItemTag("heart");
	public static final TagKey<Item> HEART_RAW = neoforgeItemTag("heart/raw");
	public static final TagKey<Item> HEART_COOKED = neoforgeItemTag("heart/cooked");

	public static final TagKey<Item> BRAIN = neoforgeItemTag("brain");
	public static final TagKey<Item> BRAIN_RAW = neoforgeItemTag("brain/raw");
	public static final TagKey<Item> BRAIN_COOKED = neoforgeItemTag("brain/cooked");

	public static final TagKey<Item> TONGUE = neoforgeItemTag("tongue");
	public static final TagKey<Item> TONGUE_RAW = neoforgeItemTag("tongue/raw");
	public static final TagKey<Item> TONGUE_COOKED = neoforgeItemTag("tongue/cooked");

	public static final TagKey<Item> SAUSAGE = neoforgeItemTag("sausage");
	public static final TagKey<Item> SAUSAGE_RAW = neoforgeItemTag("sausage/raw");
	public static final TagKey<Item> SAUSAGE_COOKED = neoforgeItemTag("sausage/cooked");

	public static final TagKey<Item> BLOOD_SAUSAGE = neoforgeItemTag("blood_sausage");
	public static final TagKey<Item> BLOOD_SAUSAGE_RAW = neoforgeItemTag("blood_sausage/raw");
	public static final TagKey<Item> BLOOD_SAUSAGE_COOKED = neoforgeItemTag("blood_sausage/cooked");

	public static final TagKey<Item> GELATIN = neoforgeItemTag("gelatin");
	public static final TagKey<Item> GELATIN_PROVIDER = butcherTag("gelatin_provider");

	public static final TagKey<Item> HORN = neoforgeItemTag("horn");
	public static final TagKey<Item> FAT = neoforgeItemTag("fat");
	public static final TagKey<Item> LEATHER_SCRAP = neoforgeItemTag("leather_scrap");

	public static final TagKey<Item> GRINDER_ATTACHMENT = butcherTag("grinder_attachment");
	public static final TagKey<Item> SAUSAGE_CASING = butcherTag("sausage_casing");

	public static final TagKey<Item> BUNNY_EARS = butcherTag("bunny_ears");
	public static final TagKey<Item> BUNNY_TAILS = butcherTag("bunny_tails");
	public static final TagKey<Item> TAXIDERMY = butcherTag("taxidermy");

	public static final TagKey<Item> KNIFE = neoforgeItemTag("tools/knife");
	public static final TagKey<Item> VILLAGER_JOB_SITES = neoforgeItemTag("villager_job_sites");

	public static TagKey<Item> neoforgeItemTag(String tag) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", tag));
	}

	public static TagKey<Item> butcherTag(String tag) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, tag));
	}

}
