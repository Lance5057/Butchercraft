package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemModels extends ModelProvider<ItemModelBuilder> {
	private final ExistingFileHelper fh;

	public ItemModels(DataGenerator generator, ExistingFileHelper fh) {
		super(generator, Butchercraft.MOD_ID, ITEM_FOLDER, ItemModelBuilder::new, fh);
		this.fh = fh;
	}

	@Override
	public String getName() {
		return "Butchercraft item models";
	}

	@Override
	protected void registerModels() {
		Butchercraft.logger.info("/tItem Models - ");

		forItem(ButchercraftItems.BONE_SAW, "bonesaw");
		forItem(ButchercraftItems.BUTCHER_KNIFE, "butcherknife");
		forItem(ButchercraftItems.GUT_KNIFE, "gutknife");
		forItem(ButchercraftItems.FAT, "fat");
		// forItem(ButchercraftItems.GRINDER_TIP, "grindtip");
		forItem(ButchercraftItems.LEATHER_CORD, "leathercord");
		forItem(ButchercraftItems.LEATHER_SCRAP, "leatherscrap");
		// forItem(ButchercraftItems.EXTRUDER_TIP, "sausagetip");
		forItem(ButchercraftItems.SINEW, "sinew");
		forItem(ButchercraftItems.SKINNING_KNIFE, "skinningknife");
		// forItem(ButchercraftItems.SPATULA, "spatula");
		forItem(ButchercraftItems.HORN, "horn");
		forItem(ButchercraftItems.LARD, "lard");
		forItem(ButchercraftItems.GELATIN, "gelatin");
//		forItem(ButchercraftItems.SOAP, "soap");

		// forItem(ButchercraftItems.COW_CARCASS, "cow_carcass");
		getBuilder(ButchercraftItems.COW_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/cow")));
		getBuilder(ButchercraftItems.PIG_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/pig")));
		getBuilder(ButchercraftItems.SHEEP_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/sheep")));

		forItem(ButchercraftItems.BRAIN, "brain");
		forItem(ButchercraftItems.COOKED_BRAIN, "cooked_brain");
		forItem(ButchercraftItems.HEART, "heart");
		forItem(ButchercraftItems.COOKED_HEART, "cooked_heart");
		forItem(ButchercraftItems.KIDNEY, "kidney");
		forItem(ButchercraftItems.COOKED_KIDNEY, "cooked_kidney");
		forItem(ButchercraftItems.LIVER, "liver");
		forItem(ButchercraftItems.COOKED_LIVER, "cooked_liver");
		forItem(ButchercraftItems.LUNG, "lung");
		forItem(ButchercraftItems.COOKED_LUNG, "cooked_lung");
		forItem(ButchercraftItems.STOMACHE, "stomach");
		forItem(ButchercraftItems.COOKED_STOMACHE, "cooked_stomach");
		forItem(ButchercraftItems.TRIPE, "tripe");
		forItem(ButchercraftItems.COOKED_TRIPE, "cooked_tripe");
		forItem(ButchercraftItems.BEEF_TONGUE, "tongue");
		forItem(ButchercraftItems.COOKED_BEEF_TONGUE, "cooked_tongue");

		forItem(ButchercraftItems.BEEF_STEW_MEAT, "stew_beef");
		forItem(ButchercraftItems.COOKED_BEEF_STEW_MEAT, "cooked_stew_beef");
		forItem(ButchercraftItems.BEEF_ROAST, "roast");
		forItem(ButchercraftItems.COOKED_BEEF_ROAST, "cooked_roast");
		forItem(ButchercraftItems.BEEF_RIBS, "ribs");
		forItem(ButchercraftItems.COOKED_BEEF_RIBS, "cooked_ribs");
		forItem(ButchercraftItems.BEEF_RIB, "beef_rib");
		forItem(ButchercraftItems.COOKED_BEEF_RIB, "cooked_beef_rib");
		forItem(ButchercraftItems.CUBED_BEEF, "cubed_beef");
		forItem(ButchercraftItems.COOKED_CUBED_BEEF, "cooked_cubed_beef");
		forItem(ButchercraftItems.GROUND_BEEF, "ground_beef");
		forItem(ButchercraftItems.COOKED_GROUND_BEEF, "cooked_ground_beef");
		forItem(ButchercraftItems.BEEF_SCRAPS, "beef_scraps");
		forItem(ButchercraftItems.COOKED_BEEF_SCRAPS, "cooked_beef_scraps");
		forItem(ButchercraftItems.OXTAIL, "oxtail");
		forItem(ButchercraftItems.COOKED_OXTAIL, "cooked_oxtail");
		forItem(ButchercraftItems.BEEF_JERKY, "beef_jerky");

		forItem(ButchercraftItems.PORK_STEW_MEAT, "stew_pork");
		forItem(ButchercraftItems.COOKED_PORK_STEW_MEAT, "cooked_stew_pork");
		forItem(ButchercraftItems.PORK_ROAST, "roast");
		forItem(ButchercraftItems.COOKED_PORK_ROAST, "cooked_roast");
		forItem(ButchercraftItems.PORK_RIBS, "pork_ribs");
		forItem(ButchercraftItems.COOKED_PORK_RIBS, "cooked_pork_ribs");
		forItem(ButchercraftItems.PORK_RIB, "pork_rib");
		forItem(ButchercraftItems.COOKED_PORK_RIB, "cooked_pork_rib");
		forItem(ButchercraftItems.CUBED_PORK, "cubed_pork");
		forItem(ButchercraftItems.COOKED_CUBED_PORK, "cooked_cubed_pork");
		forItem(ButchercraftItems.GROUND_PORK, "ground_pork");
		forItem(ButchercraftItems.COOKED_GROUND_PORK, "cooked_ground_pork");
		forItem(ButchercraftItems.PORK_SCRAPS, "pork_scraps");
		forItem(ButchercraftItems.COOKED_PORK_SCRAPS, "cooked_pork_scraps");
		forItem(ButchercraftItems.BACON, "bacon");
		forItem(ButchercraftItems.COOKED_BACON, "cooked_bacon");
		forItem(ButchercraftItems.PORK_JERKY, "pork_jerky");

//		getBuilder(ButchercraftItems.PIG_HOOVES.getId().getPath())
//				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/pig_foot")));

		forItem(ButchercraftItems.LAMB_STEW_MEAT, "stew_lamb");
		forItem(ButchercraftItems.COOKED_LAMB_STEW_MEAT, "cooked_stew_lamb");
		forItem(ButchercraftItems.LAMB_ROAST, "roast");
		forItem(ButchercraftItems.COOKED_LAMB_ROAST, "cooked_roast");
		forItem(ButchercraftItems.LAMB_RIBS, "lamb_ribs");
		forItem(ButchercraftItems.COOKED_LAMB_RIBS, "cooked_lamb_ribs");
		forItem(ButchercraftItems.LAMB_RIB, "lamb_rib");
		forItem(ButchercraftItems.COOKED_LAMB_RIB, "cooked_lamb_rib");
		forItem(ButchercraftItems.CUBED_LAMB, "cubed_lamb");
		forItem(ButchercraftItems.COOKED_CUBED_LAMB, "cooked_cubed_lamb");
		forItem(ButchercraftItems.GROUND_LAMB, "ground_lamb");
		forItem(ButchercraftItems.COOKED_GROUND_LAMB, "cooked_ground_lamb");
		forItem(ButchercraftItems.LAMB_SCRAPS, "lamb_scraps");
		forItem(ButchercraftItems.COOKED_LAMB_SCRAPS, "cooked_lamb_scraps");
		forItem(ButchercraftItems.LAMB_JERKY, "lamb_jerky");

		forItem(ButchercraftItems.SAUSAGE, "sausage");
		forItem(ButchercraftItems.COOKED_SAUSAGE, "sausagecooked");

		forItem(ButchercraftItems.LAMB_STEW, "lamb_stew");
		forItem(ButchercraftItems.PORK_STEW, "pork_stew");

		forItem(ButchercraftItems.SAUSAGE_ROLL, "sausage_roll");
		forItem(ButchercraftItems.SOS, "sos");
		forItem(ButchercraftItems.LIVER_ONIONS, "liver_onions");
		forItem(ButchercraftItems.FRIES, "frenchfries");
		forItem(ButchercraftItems.FRIED_FISH, "friedfish");
		forItem(ButchercraftItems.CHICKEN_FRIED_STEAK, "chickenfriedsteak");
		forItem(ButchercraftItems.PORK_TENDERLOIN, "pork_tenderloin");
		forItem(ButchercraftItems.FRIED_CHICKEN, "friedchicken");
		forItem(ButchercraftItems.STUFFED_HEART, "stuffedheart");
		forItem(ButchercraftItems.FRIED_BRAINS, "friedbrains");
		forItem(ButchercraftItems.OXTAIL_SOUP, "oxtail_soup");

		forBlockItem(ButchercraftItems.HOOK_BLOCK_ITEM, "hook");
		forBlockItem(ButchercraftItems.DRYING_RACK_BLOCK_ITEM, "drying_rack");

		forBlockItem(ButchercraftItems.BEEF_BLOCK_ITEM, "beef_block");
		forBlockItem(ButchercraftItems.COOKED_BEEF_BLOCK_ITEM, "cooked_beef_block");
		forBlockItem(ButchercraftItems.PORK_BLOCK_ITEM, "pork_block");
		forBlockItem(ButchercraftItems.COOKED_PORK_BLOCK_ITEM, "cooked_pork_block");
		forBlockItem(ButchercraftItems.LAMB_BLOCK_ITEM, "lamb_block");
		forBlockItem(ButchercraftItems.COOKED_LAMB_BLOCK_ITEM, "cooked_lamb_block");

		forBlockItem(ButchercraftItems.COW_HIDE, "cow_hide");
		forBlockItem(ButchercraftItems.PIG_HIDE, "pig_hide");
		forBlockItem(ButchercraftItems.SHEEP_HIDE, "sheep_hide");

		forItem(ButchercraftItems.BBQ_JAR_ITEM, "bbq");
		forItem(ButchercraftItems.STOCK_JAR_ITEM, "broth");
		forItem(ButchercraftItems.KETCHUP_JAR_ITEM, "ketchup");
		forItem(ButchercraftItems.GRAVY_ITEM, "gravy");

		forBlockItem(ButchercraftItems.HASH_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/hash_block_stage0"));
		forItem(ButchercraftItems.HASH, "hash");

		forBlockItem(ButchercraftItems.POT_ROAST_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/potroast_block_stage0"));
		forItem(ButchercraftItems.POT_ROAST, "pot_roast");

		forBlockItem(ButchercraftItems.SALISBURY_STEAK_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/salisbury_steak_block_stage0"));
		forItem(ButchercraftItems.SALISBURY_STEAK, "salisbury_steak");

		forBlockItem(ButchercraftItems.BBQ_RIBS_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/bbq_ribs_block_stage0"));
		forItem(ButchercraftItems.BBQ_RIBS, "bbq_ribs");

		forBlockItem(ButchercraftItems.MEAT_PIE_BLOCK_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/meat_pie"));
		forItem(ButchercraftItems.MEAT_PIE_SLICE, "meat_pie_slice");

		forBlockItem(ButchercraftItems.PULLED_PORK_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/pulled_pork_block_stage0"));
		forItem(ButchercraftItems.PULLED_PORK_SANDWICH, "pulled_pork_sandwich");

		forBlockItem(ButchercraftItems.MASHED_POTATO_GRAVY_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/mashed_potato_gravy_block_stage0"));
		forItem(ButchercraftItems.MASHED_POTATO_GRAVY, "mashed_potato_gravy");

		forBlockItem(ButchercraftItems.RACK_LAMB_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/rack_lamb_block_stage0"));
		forItem(ButchercraftItems.RACK_LAMB, "rack_lamb");

		forBlockItem(ButchercraftItems.BEEF_WELLINGTON_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/beef_wellington_block_stage0"));
		forItem(ButchercraftItems.BEEF_WELLINGTON, "beef_wellington");

		forBlockItem(ButchercraftItems.HAGGIS_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/haggis_block_stage0"));
		forItem(ButchercraftItems.HAGGIS, "haggis");

		forBlockItem(ButchercraftItems.STIRFRY_FEAST_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/stirfry_block_stage0"));
		forItem(ButchercraftItems.STIRFRY, "stirfry");

		this.jellyBlock(ButchercraftItems.JELLY_WHITE_FEAST_ITEM, "white");
		this.jellyBlock(ButchercraftItems.JELLY_ORANGE_FEAST_ITEM, "orange");
		this.jellyBlock(ButchercraftItems.JELLY_MAGENTA_FEAST_ITEM, "magenta");
		this.jellyBlock(ButchercraftItems.JELLY_LIGHT_BLUE_FEAST_ITEM, "light_blue");
		this.jellyBlock(ButchercraftItems.JELLY_YELLOW_FEAST_ITEM, "yellow");
		this.jellyBlock(ButchercraftItems.JELLY_LIME_FEAST_ITEM, "lime");
		this.jellyBlock(ButchercraftItems.JELLY_PINK_FEAST_ITEM, "pink");
		this.jellyBlock(ButchercraftItems.JELLY_GREY_FEAST_ITEM, "grey");
		this.jellyBlock(ButchercraftItems.JELLY_LIGHT_GREY_FEAST_ITEM, "light_grey");
		this.jellyBlock(ButchercraftItems.JELLY_CYAN_FEAST_ITEM, "cyan");
		this.jellyBlock(ButchercraftItems.JELLY_PURPLE_FEAST_ITEM, "purple");
		this.jellyBlock(ButchercraftItems.JELLY_BLUE_FEAST_ITEM, "blue");
		this.jellyBlock(ButchercraftItems.JELLY_BROWN_FEAST_ITEM, "brown");
		this.jellyBlock(ButchercraftItems.JELLY_GREEN_FEAST_ITEM, "green");
		this.jellyBlock(ButchercraftItems.JELLY_RED_FEAST_ITEM, "red");
		this.jellyBlock(ButchercraftItems.JELLY_BLACK_FEAST_ITEM, "black");
		
		forItem(ButchercraftItems.JELLY_WHITE, "jelly_white");
		forItem(ButchercraftItems.JELLY_ORANGE, "jelly_orange");
		forItem(ButchercraftItems.JELLY_MAGENTA, "jelly_magenta");
		forItem(ButchercraftItems.JELLY_LIGHT_BLUE, "jelly_light_blue");
		forItem(ButchercraftItems.JELLY_YELLOW, "jelly_yellow");
		forItem(ButchercraftItems.JELLY_LIME, "jelly_lime");
		forItem(ButchercraftItems.JELLY_PINK, "jelly_pink");
		forItem(ButchercraftItems.JELLY_GREY, "jelly_grey");
		forItem(ButchercraftItems.JELLY_LIGHT_GREY, "jelly_light_grey");
		forItem(ButchercraftItems.JELLY_CYAN, "jelly_cyan");
		forItem(ButchercraftItems.JELLY_PURPLE, "jelly_purple");
		forItem(ButchercraftItems.JELLY_BLUE, "jelly_blue");
		forItem(ButchercraftItems.JELLY_BROWN, "jelly_brown");
		forItem(ButchercraftItems.JELLY_GREEN, "jelly_green");
		forItem(ButchercraftItems.JELLY_RED, "jelly_red");
		forItem(ButchercraftItems.JELLY_BLACK, "jelly_black");
	}

	public void forItem(RegistryObject<? extends Item> item, String name) {
		this.singleTexture(item.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/" + name));
	}

	public void forMaterialItem(RegistryObject<? extends Item> item, String name) {
		this.singleTexture(item.getId().getPath(), mcLoc("item/handheld"), "layer0",
				modLoc("item/material/" + name + "/" + item.getId().getPath()));
	}

	public void forBlockItem(RegistryObject<? extends BlockItem> item, String name) {
		getBuilder(item.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID,
						"block/" + ForgeRegistries.BLOCKS.getKey(item.get().getBlock()).getPath())));
	}

	public void forBlockItem(RegistryObject<? extends BlockItem> item, ResourceLocation modelLocation) {
		getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(modelLocation));
	}

	public void forBlockItem(RegistryObject<? extends BlockItem> item, ResourceLocation modelLocation, String key,
			ResourceLocation texture) {
		getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(modelLocation)).texture(key,
				texture);
	}

	public void jellyBlock(RegistryObject<? extends BlockItem> item, String color) {
		ModelFile jellyModel = new ModelFile.UncheckedModelFile(modLoc("block/jelly_block_stage0"));

		getBuilder(item.getId().getPath()).parent(jellyModel).texture("1",
				new ResourceLocation(Butchercraft.MOD_ID, "block/jelly_" + color));
	}

}