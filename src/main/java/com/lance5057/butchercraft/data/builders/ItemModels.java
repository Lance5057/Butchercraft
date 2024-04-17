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
		forItem(ButchercraftItems.BLOOD_FLUID_BUCKET, "blood_bucket");
		forItem(ButchercraftItems.BLOOD_FLUID_BOTTLE, "blood_bottle");

		// forItem(ButchercraftItems.COW_CARCASS, "cow_carcass");
		getBuilder(ButchercraftItems.COW_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/cow")));
		getBuilder(ButchercraftItems.PIG_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/pig")));
		getBuilder(ButchercraftItems.SHEEP_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/sheep")));
		getBuilder(ButchercraftItems.GOAT_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/goat")));
		getBuilder(ButchercraftItems.CHICKEN_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/chicken")));

		getBuilder(ButchercraftItems.BLACK_RABBIT_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/black"));
		getBuilder(ButchercraftItems.BROWN_RABBIT_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/brown"));
		getBuilder(ButchercraftItems.GOLD_RABBIT_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/gold"));
		getBuilder(ButchercraftItems.SALT_RABBIT_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/salt"));
		getBuilder(ButchercraftItems.WHITE_RABBIT_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/white"));
		getBuilder(ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/white_splotched"));

		getBuilder(ButchercraftItems.TAXIDERMY_COW_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/cow")));
		getBuilder(ButchercraftItems.TAXIDERMY_PIG_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/pig")));
		getBuilder(ButchercraftItems.TAXIDERMY_SHEEP_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/sheep")));
		getBuilder(ButchercraftItems.TAXIDERMY_GOAT_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/goat")));
		getBuilder(ButchercraftItems.TAXIDERMY_CHICKEN_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/chicken")));

		getBuilder(ButchercraftItems.TAXIDERMY_BLACK_RABBIT_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")));
		getBuilder(ButchercraftItems.TAXIDERMY_BLACK_RABBIT_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/black"));
		getBuilder(ButchercraftItems.TAXIDERMY_BROWN_RABBIT_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/brown"));
		getBuilder(ButchercraftItems.TAXIDERMY_GOLD_RABBIT_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/gold"));
		getBuilder(ButchercraftItems.TAXIDERMY_SALT_RABBIT_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/salt"));
		getBuilder(ButchercraftItems.TAXIDERMY_WHITE_RABBIT_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/white"));
		getBuilder(ButchercraftItems.TAXIDERMY_SPLOTCHED_RABBIT_ITEM_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/rabbit")))
				.texture("0", mcLoc("entity/rabbit/white_splotched"));

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
		forItem(ButchercraftItems.STOMACH, "stomach");
		forItem(ButchercraftItems.COOKED_STOMACH, "cooked_stomach");
		forItem(ButchercraftItems.TRIPE, "tripe");
		forItem(ButchercraftItems.COOKED_TRIPE, "cooked_tripe");
		forItem(ButchercraftItems.TONGUE, "tongue");
		forItem(ButchercraftItems.COOKED_TONGUE, "cooked_tongue");
		forItem(ButchercraftItems.WATTLE, "wattle");
		forItem(ButchercraftItems.COOKED_WATTLE, "cooked_wattle");
		forItem(ButchercraftItems.EYEBALL, "eyeball");
		forItem(ButchercraftItems.COOKED_EYEBALL, "cooked_eyeball");
		forItem(ButchercraftItems.BEAK, "beak");

		forItem(ButchercraftItems.BEEF_STEW_MEAT, "stew_beef");
		forItem(ButchercraftItems.COOKED_BEEF_STEW_MEAT, "cooked_stew_beef");
		forItem(ButchercraftItems.BEEF_ROAST, "beef_roast");
		forItem(ButchercraftItems.COOKED_BEEF_ROAST, "cooked_beef_roast");
		forItem(ButchercraftItems.BEEF_RIBS, "ribs");
		forItem(ButchercraftItems.COOKED_BEEF_RIBS, "cooked_ribs");
		forItem(ButchercraftItems.CUBED_BEEF, "cubed_beef");
		forItem(ButchercraftItems.COOKED_CUBED_BEEF, "cooked_cubed_beef");
		forItem(ButchercraftItems.GROUND_BEEF, "ground_beef");
		forItem(ButchercraftItems.COOKED_GROUND_BEEF, "cooked_ground_beef");
		forItem(ButchercraftItems.BEEF_SCRAPS, "beef_scraps");
		forItem(ButchercraftItems.COOKED_BEEF_SCRAPS, "cooked_beef_scraps");
		forItem(ButchercraftItems.OXTAIL, "oxtail");
		forItem(ButchercraftItems.COOKED_OXTAIL, "cooked_oxtail");

		forItem(ButchercraftItems.PORK_STEW_MEAT, "stew_pork");
		forItem(ButchercraftItems.COOKED_PORK_STEW_MEAT, "cooked_stew_pork");
		forItem(ButchercraftItems.PORK_ROAST, "pork_roast");
		forItem(ButchercraftItems.COOKED_PORK_ROAST, "cooked_pork_roast");
		forItem(ButchercraftItems.PORK_RIBS, "pork_ribs");
		forItem(ButchercraftItems.COOKED_PORK_RIBS, "cooked_pork_ribs");
		forItem(ButchercraftItems.CUBED_PORK, "cubed_pork");
		forItem(ButchercraftItems.COOKED_CUBED_PORK, "cooked_cubed_pork");
		forItem(ButchercraftItems.GROUND_PORK, "ground_pork");
		forItem(ButchercraftItems.COOKED_GROUND_PORK, "cooked_ground_pork");
		forItem(ButchercraftItems.PORK_SCRAPS, "pork_scraps");
		forItem(ButchercraftItems.COOKED_PORK_SCRAPS, "cooked_pork_scraps");

		forItem(ButchercraftItems.SAUSAGE_LINKED, "linked_sausage");
		forItem(ButchercraftItems.SAUSAGE, "sausage");
		forItem(ButchercraftItems.COOKED_SAUSAGE, "cooked_sausage");

		forItem(ButchercraftItems.BLOOD_SAUSAGE_MIX, "blood_sausage_mix");
		forItem(ButchercraftItems.BLOOD_SAUSAGE_LINKED, "linked_blood_sausage");
		forItem(ButchercraftItems.BLOOD_SAUSAGE, "blood_sausage");
		forItem(ButchercraftItems.COOKED_BLOOD_SAUSAGE, "cooked_blood_sausage");

//		getBuilder(ButchercraftItems.PIG_HOOVES.getId().getPath())
//				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/pig_foot")));

		forItem(ButchercraftItems.MUTTON_STEW_MEAT, "stew_lamb");
		forItem(ButchercraftItems.COOKED_MUTTON_STEW_MEAT, "cooked_stew_lamb");
		forItem(ButchercraftItems.MUTTON_ROAST, "lamb_roast");
		forItem(ButchercraftItems.COOKED_MUTTON_ROAST, "cooked_lamb_roast");
		forItem(ButchercraftItems.MUTTON_RIBS, "lamb_ribs");
		forItem(ButchercraftItems.COOKED_MUTTON_RIBS, "cooked_lamb_ribs");
		forItem(ButchercraftItems.CUBED_MUTTON, "cubed_lamb");
		forItem(ButchercraftItems.COOKED_CUBED_MUTTON, "cooked_cubed_lamb");
		forItem(ButchercraftItems.GROUND_MUTTON, "ground_lamb");
		forItem(ButchercraftItems.COOKED_GROUND_MUTTON, "cooked_ground_lamb");
		forItem(ButchercraftItems.MUTTON_SCRAPS, "lamb_scraps");
		forItem(ButchercraftItems.COOKED_MUTTON_SCRAPS, "cooked_lamb_scraps");

		forItem(ButchercraftItems.GOAT_CHOP, "goat_steak");
		forItem(ButchercraftItems.COOKED_GOAT_CHOP, "cooked_goat_steak");
		forItem(ButchercraftItems.GOAT_STEW_MEAT, "stew_goat");
		forItem(ButchercraftItems.COOKED_GOAT_STEW_MEAT, "cooked_stew_goat");
		forItem(ButchercraftItems.GOAT_ROAST, "goat_roast");
		forItem(ButchercraftItems.COOKED_GOAT_ROAST, "cooked_goat_roast");
		forItem(ButchercraftItems.GOAT_RIBS, "goat_ribs");
		forItem(ButchercraftItems.COOKED_GOAT_RIBS, "cooked_goat_ribs");
		forItem(ButchercraftItems.CUBED_GOAT, "cubed_goat");
		forItem(ButchercraftItems.COOKED_CUBED_GOAT, "cooked_cubed_goat");
		forItem(ButchercraftItems.GROUND_GOAT, "ground_goat");
		forItem(ButchercraftItems.COOKED_GROUND_GOAT, "cooked_ground_goat");
		forItem(ButchercraftItems.GOAT_SCRAPS, "goat_scraps");
		forItem(ButchercraftItems.COOKED_GOAT_SCRAPS, "cooked_goat_scraps");

		forItem(ButchercraftItems.CHICKEN_BREAST, "chicken_breast");
		forItem(ButchercraftItems.CHICKEN_LEG, "chicken_leg");
		forItem(ButchercraftItems.CHICKEN_SCRAPS, "chicken_scraps");
		forItem(ButchercraftItems.CHICKEN_THIGH, "chicken_thigh");
		forItem(ButchercraftItems.CHICKEN_WING, "chicken_wing");
		forItem(ButchercraftItems.CUBED_CHICKEN, "cubed_chicken");
		forItem(ButchercraftItems.GROUND_CHICKEN, "ground_chicken");
		forItem(ButchercraftItems.STEW_CHICKEN, "stew_chicken");
		forItem(ButchercraftItems.COOKED_CHICKEN_BREAST, "cooked_chicken_breast");
		forItem(ButchercraftItems.COOKED_CHICKEN_LEG, "cooked_chicken_leg");
		forItem(ButchercraftItems.COOKED_CHICKEN_SCRAPS, "cooked_chicken_scraps");
		forItem(ButchercraftItems.COOKED_CHICKEN_THIGH, "cooked_chicken_thigh");
		forItem(ButchercraftItems.COOKED_CHICKEN_WING, "cooked_chicken_wing");
		forItem(ButchercraftItems.COOKED_CUBED_CHICKEN, "cooked_cubed_chicken");
		forItem(ButchercraftItems.COOKED_GROUND_CHICKEN, "cooked_ground_chicken");
		forItem(ButchercraftItems.COOKED_STEW_CHICKEN, "cooked_stew_chicken");

		forItem(ButchercraftItems.RABBIT_SADDLE, "rabbit_saddle");
		forItem(ButchercraftItems.RABBIT_LEG, "rabbit_front_leg");
		forItem(ButchercraftItems.RABBIT_SCRAPS, "rabbit_scraps");
		forItem(ButchercraftItems.RABBIT_THIGH, "rabbit_thigh");
		forItem(ButchercraftItems.CUBED_RABBIT, "cubed_rabbit");
		forItem(ButchercraftItems.GROUND_RABBIT, "ground_rabbit");
		forItem(ButchercraftItems.STEW_RABBIT, "stew_rabbit");
		forItem(ButchercraftItems.COOKED_RABBIT_SADDLE, "cooked_rabbit_saddle");
		forItem(ButchercraftItems.COOKED_RABBIT_LEG, "cooked_rabbit_front_leg");
		forItem(ButchercraftItems.COOKED_RABBIT_SCRAPS, "cooked_rabbit_scraps");
		forItem(ButchercraftItems.COOKED_RABBIT_THIGH, "cooked_rabbit_thigh");
		forItem(ButchercraftItems.COOKED_CUBED_RABBIT, "cooked_cubed_rabbit");
		forItem(ButchercraftItems.COOKED_GROUND_RABBIT, "cooked_ground_rabbit");
		forItem(ButchercraftItems.COOKED_STEW_RABBIT, "cooked_stew_rabbit");

		getBuilder(ButchercraftItems.EXTRUDER_TIP.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				new ResourceLocation(Butchercraft.MOD_ID, "item/extruder_tip_item"), fh));
		getBuilder(ButchercraftItems.GRINDER_TIP.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				new ResourceLocation(Butchercraft.MOD_ID, "item/grinder_tip_item"), fh));

		forBlockItem(ButchercraftItems.HOOK_BLOCK_ITEM, "hook");
		forBlockItem(ButchercraftItems.GRINDER_BLOCK_ITEM, "grinder");
		forBlockItem(ButchercraftItems.BUTCHER_BLOCK_BLOCK_ITEM, "butcher_block");

		forBlockItem(ButchercraftItems.BEEF_BLOCK_ITEM, "beef_block");
		forBlockItem(ButchercraftItems.COOKED_BEEF_BLOCK_ITEM, "cooked_beef_block");
		forBlockItem(ButchercraftItems.PORK_BLOCK_ITEM, "pork_block");
		forBlockItem(ButchercraftItems.COOKED_PORK_BLOCK_ITEM, "cooked_pork_block");
		forBlockItem(ButchercraftItems.MUTTON_BLOCK_ITEM, "lamb_block");
		forBlockItem(ButchercraftItems.COOKED_MUTTON_BLOCK_ITEM, "cooked_lamb_block");
		forBlockItem(ButchercraftItems.RABBIT_BLOCK_ITEM, "rabbit_block");
		forBlockItem(ButchercraftItems.COOKED_RABBIT_BLOCK_ITEM, "cooked_rabbit_block");
		forBlockItem(ButchercraftItems.CHICKEN_BLOCK_ITEM, "chicken_block");
		forBlockItem(ButchercraftItems.COOKED_CHICKEN_BLOCK_ITEM, "cooked_chicken_block");
		forBlockItem(ButchercraftItems.GOAT_BLOCK_ITEM, "goat_block");
		forBlockItem(ButchercraftItems.COOKED_GOAT_BLOCK_ITEM, "cooked_goat_block");

		forBlockItem(ButchercraftItems.SAUSAGE_BLOCK_ITEM, "sausage_block");
		forBlockItem(ButchercraftItems.BLOOD_SAUSAGE_BLOCK_ITEM, "blood_sausage_block");
		forBlockItem(ButchercraftItems.COOKED_SAUSAGE_BLOCK_ITEM, "cooked_sausage_block");
		forBlockItem(ButchercraftItems.COOKED_BLOOD_SAUSAGE_BLOCK_ITEM, "cooked_blood_sausage_block");

		forBlockItem(ButchercraftItems.COW_HIDE, "cow_hide");
		forBlockItem(ButchercraftItems.PIG_HIDE, "pig_hide");
		forBlockItem(ButchercraftItems.SHEEP_HIDE, "sheep_hide");
		forBlockItem(ButchercraftItems.GOAT_HIDE, "goat_hide");

		forItem(ButchercraftItems.PAPER_HAT, "paper_hat");
		forItem(ButchercraftItems.CASING, "casing");
		forItem(ButchercraftItems.SOAP, "soap");

		forItem(ButchercraftItems.APRON, "apron");
		forItem(ButchercraftItems.BOOTS, "boots");
		forItem(ButchercraftItems.MASK, "mask");
		forItem(ButchercraftItems.GLOVES, "gloves");

		forItem(ButchercraftItems.BLACK_BUNNY_EARS, "black_bunny_ears");
		forItem(ButchercraftItems.BROWN_BUNNY_EARS, "brown_bunny_ears");
		forItem(ButchercraftItems.WHITE_BUNNY_EARS, "white_bunny_ears");
		forItem(ButchercraftItems.GOLD_BUNNY_EARS, "gold_bunny_ears");
		forItem(ButchercraftItems.SPLOTCHED_BUNNY_EARS, "splotched_bunny_ears");
		forItem(ButchercraftItems.SALT_BUNNY_EARS, "salt_bunny_ears");

		forItem(ButchercraftItems.BLACK_BUNNY_TAIL, "black_bunny_tail");
		forItem(ButchercraftItems.BROWN_BUNNY_TAIL, "brown_bunny_tail");
		forItem(ButchercraftItems.WHITE_BUNNY_TAIL, "white_bunny_tail");
		forItem(ButchercraftItems.GOLD_BUNNY_TAIL, "gold_bunny_tail");
		forItem(ButchercraftItems.SPLOTCHED_BUNNY_TAIL, "splotched_bunny_tail");
		forItem(ButchercraftItems.SALT_BUNNY_TAIL, "salt_bunny_tail");

		forBlockItem(ButchercraftItems.BARN_WOOD_BLOCK_ITEM, "barn_wood");
		forBlockItem(ButchercraftItems.TRIMMED_BARN_WOOD_ITEM, "trimmed_barn_wood");
		forItem(ButchercraftItems.BARN_WOOD_DOOR_ITEM, "barn_wood_door");
		forBlockItem(ButchercraftItems.BARN_WOOD_SLAB_ITEM, "barn_wood_slab");
		forBlockItem(ButchercraftItems.BARN_WOOD_STAIRS_ITEM, "barn_wood_stairs");
		forBlockItem(ButchercraftItems.BARN_WOOD_TRAPDOOR_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/barn_wood_trapdoor_bottom"));
		forBlockItem(ButchercraftItems.BARN_WOOD_FENCE_GATE_ITEM, "barn_wood_fence_gate");
		forBlockItem(ButchercraftItems.BARN_WOOD_FENCE_ITEM,
				new ResourceLocation(Butchercraft.MOD_ID, "block/barn_wood_fence_inventory"));

		getBuilder(ButchercraftItems.COW_HEAD_ITEM.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/cow_head"), fh));
		getBuilder(ButchercraftItems.COW_SKULL_HEAD_ITEM.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/cow_skull_head"), fh));
		getBuilder(ButchercraftItems.PIG_HEAD_ITEM.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/pig_head"), fh));
		getBuilder(ButchercraftItems.SHEEP_HEAD_ITEM.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/sheep_head"), fh));
		getBuilder(ButchercraftItems.GOAT_HEAD_ITEM.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/goat_head"), fh));
		getBuilder(ButchercraftItems.CHICKEN_HEAD_ITEM.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/chicken_head"), fh));

		getBuilder(ButchercraftItems.RABBIT_BLACK_HEAD_ITEM.getId().getPath())
				.parent(new ModelFile.ExistingModelFile(modLoc("item/rabbit_head"), existingFileHelper))
				.texture("0", mcLoc("entity/rabbit/black"));
		getBuilder(ButchercraftItems.RABBIT_BROWN_HEAD_ITEM.getId().getPath())
				.parent(new ModelFile.ExistingModelFile(modLoc("item/rabbit_head"), existingFileHelper))
				.texture("0", mcLoc("entity/rabbit/brown"));
		getBuilder(ButchercraftItems.RABBIT_GOLD_HEAD_ITEM.getId().getPath())
				.parent(new ModelFile.ExistingModelFile(modLoc("item/rabbit_head"), existingFileHelper))
				.texture("0", mcLoc("entity/rabbit/gold"));
		getBuilder(ButchercraftItems.RABBIT_SALT_HEAD_ITEM.getId().getPath())
				.parent(new ModelFile.ExistingModelFile(modLoc("item/rabbit_head"), existingFileHelper))
				.texture("0", mcLoc("entity/rabbit/salt"));
		getBuilder(ButchercraftItems.RABBIT_SPLOTCHED_HEAD_ITEM.getId().getPath())
				.parent(new ModelFile.ExistingModelFile(modLoc("item/rabbit_head"), existingFileHelper))
				.texture("0", mcLoc("entity/rabbit/white_splotched"));
		getBuilder(ButchercraftItems.RABBIT_WHITE_HEAD_ITEM.getId().getPath())
				.parent(new ModelFile.ExistingModelFile(modLoc("item/rabbit_head"), existingFileHelper))
				.texture("0", mcLoc("entity/rabbit/white"));

//		forBlockItem(ButchercraftItems.TRIMMED_BARN_WOOD_ITEM, "trimmed_barn_wood");

		getBuilder(ButchercraftItems.CHICKEN_MASK.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				new ResourceLocation(Butchercraft.MOD_ID, "item/chicken_mask_model"), fh));
		getBuilder(ButchercraftItems.PIG_HOOD.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/pig_hood_model"), fh));
		getBuilder(ButchercraftItems.COW_HOOD.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/cow_hood_model"), fh));
		getBuilder(ButchercraftItems.GOAT_HOOD.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/goat_hood_model"), fh));
		getBuilder(ButchercraftItems.SHEEP_HOOD.getId().getPath()).parent(
				new ModelFile.ExistingModelFile(new ResourceLocation(Butchercraft.MOD_ID, "item/sheep_hood_model"), fh));

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

}