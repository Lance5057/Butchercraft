package com.lance5057.butchercraft.data.builders;

import org.jetbrains.annotations.Nullable;

import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTagGenerator extends ItemTagsProvider {

	public ItemTagGenerator(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, String modId,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(pGenerator, pBlockTagsProvider, modId, existingFileHelper);
	}

	@Override
	protected void addTags() {
		// Goat
		tag(ButchercraftItemTags.GOAT_RIBS_RAW).add(ButchercraftItems.GOAT_RIBS.get());
		tag(ButchercraftItemTags.GOAT_RIBS_COOKED).add(ButchercraftItems.COOKED_GOAT_RIBS.get());
		tag(ButchercraftItemTags.GOAT_RIBS).addTag(ButchercraftItemTags.GOAT_RIBS_RAW)
				.addTag(ButchercraftItemTags.GOAT_RIBS_COOKED);

		tag(ButchercraftItemTags.GOAT_ROAST_RAW).add(ButchercraftItems.GOAT_ROAST.get());
		tag(ButchercraftItemTags.GOAT_ROAST_COOKED).add(ButchercraftItems.COOKED_GOAT_ROAST.get());
		tag(ButchercraftItemTags.GOAT_ROAST).addTag(ButchercraftItemTags.GOAT_ROAST_RAW)
				.addTag(ButchercraftItemTags.GOAT_ROAST_COOKED);

		tag(ButchercraftItemTags.CUBED_GOAT_RAW).add(ButchercraftItems.CUBED_GOAT.get());
		tag(ButchercraftItemTags.CUBED_GOAT_COOKED).add(ButchercraftItems.COOKED_CUBED_GOAT.get());
		tag(ButchercraftItemTags.CUBED_GOAT).addTag(ButchercraftItemTags.CUBED_GOAT_RAW)
				.addTag(ButchercraftItemTags.CUBED_GOAT_COOKED);

		tag(ButchercraftItemTags.SCRAP_GOAT).add(ButchercraftItems.GOAT_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_GOAT_COOKED).add(ButchercraftItems.COOKED_GOAT_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_GOAT).addTag(ButchercraftItemTags.SCRAP_GOAT_RAW)
				.addTag(ButchercraftItemTags.SCRAP_GOAT_COOKED);

		tag(ButchercraftItemTags.STEW_GOAT).add(ButchercraftItems.GOAT_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_GOAT_COOKED).add(ButchercraftItems.COOKED_GOAT_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_GOAT).addTag(ButchercraftItemTags.STEW_GOAT_RAW)
				.addTag(ButchercraftItemTags.STEW_GOAT_COOKED);

		tag(ButchercraftItemTags.GOAT_RAW).addTag(ButchercraftItemTags.GOAT_RIBS_RAW)
				.addTag(ButchercraftItemTags.GOAT_ROAST_RAW).addTag(ButchercraftItemTags.CUBED_GOAT_RAW)
				.addTag(ButchercraftItemTags.SCRAP_GOAT_RAW).addTag(ButchercraftItemTags.STEW_GOAT_RAW);

		tag(ButchercraftItemTags.GOAT_COOKED).addTag(ButchercraftItemTags.GOAT_RIBS_COOKED)
				.addTag(ButchercraftItemTags.GOAT_ROAST_COOKED).addTag(ButchercraftItemTags.CUBED_GOAT_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_GOAT_COOKED).addTag(ButchercraftItemTags.STEW_GOAT_COOKED);

		tag(ButchercraftItemTags.GOAT).addTag(ButchercraftItemTags.GOAT_COOKED).addTag(ButchercraftItemTags.GOAT_RAW);

		// Cow
		tag(ButchercraftItemTags.BEEF_RIBS_RAW).add(ButchercraftItems.BEEF_RIBS.get());
		tag(ButchercraftItemTags.BEEF_RIBS_COOKED).add(ButchercraftItems.COOKED_BEEF_RIBS.get());
		tag(ButchercraftItemTags.BEEF_RIBS).addTag(ButchercraftItemTags.BEEF_RIBS_RAW)
				.addTag(ButchercraftItemTags.BEEF_RIBS_COOKED);

		tag(ButchercraftItemTags.BEEF_ROAST_RAW).add(ButchercraftItems.BEEF_ROAST.get());
		tag(ButchercraftItemTags.BEEF_ROAST_COOKED).add(ButchercraftItems.COOKED_BEEF_ROAST.get());
		tag(ButchercraftItemTags.BEEF_ROAST).addTag(ButchercraftItemTags.BEEF_ROAST_RAW)
				.addTag(ButchercraftItemTags.BEEF_ROAST_COOKED);

		tag(ButchercraftItemTags.CUBED_BEEF_RAW).add(ButchercraftItems.CUBED_BEEF.get());
		tag(ButchercraftItemTags.CUBED_BEEF_COOKED).add(ButchercraftItems.COOKED_CUBED_BEEF.get());
		tag(ButchercraftItemTags.CUBED_BEEF).addTag(ButchercraftItemTags.CUBED_BEEF_RAW)
				.addTag(ButchercraftItemTags.CUBED_BEEF_COOKED);

		tag(ButchercraftItemTags.SCRAP_BEEF).add(ButchercraftItems.BEEF_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_BEEF_COOKED).add(ButchercraftItems.COOKED_BEEF_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_BEEF).addTag(ButchercraftItemTags.SCRAP_BEEF_RAW)
				.addTag(ButchercraftItemTags.SCRAP_BEEF_COOKED);

		tag(ButchercraftItemTags.STEW_BEEF).add(ButchercraftItems.BEEF_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_BEEF_COOKED).add(ButchercraftItems.COOKED_BEEF_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_BEEF).addTag(ButchercraftItemTags.STEW_BEEF_RAW)
				.addTag(ButchercraftItemTags.STEW_BEEF_COOKED);

		tag(ButchercraftItemTags.BEEF_RAW).addTag(ButchercraftItemTags.BEEF_RIBS_RAW)
				.addTag(ButchercraftItemTags.BEEF_ROAST_RAW).addTag(ButchercraftItemTags.CUBED_BEEF_RAW)
				.addTag(ButchercraftItemTags.SCRAP_BEEF_RAW).addTag(ButchercraftItemTags.STEW_BEEF_RAW);

		tag(ButchercraftItemTags.BEEF_COOKED).addTag(ButchercraftItemTags.BEEF_RIBS_COOKED)
				.addTag(ButchercraftItemTags.BEEF_ROAST_COOKED).addTag(ButchercraftItemTags.CUBED_BEEF_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_BEEF_COOKED).addTag(ButchercraftItemTags.STEW_BEEF_COOKED);

		tag(ButchercraftItemTags.BEEF).addTag(ButchercraftItemTags.BEEF_COOKED).addTag(ButchercraftItemTags.BEEF_RAW);

		// Sheep
		tag(ButchercraftItemTags.MUTTON_RIBS_RAW).add(ButchercraftItems.MUTTON_RIBS.get());
		tag(ButchercraftItemTags.MUTTON_RIBS_COOKED).add(ButchercraftItems.COOKED_MUTTON_RIBS.get());
		tag(ButchercraftItemTags.MUTTON_RIBS).addTag(ButchercraftItemTags.MUTTON_RIBS_RAW)
				.addTag(ButchercraftItemTags.MUTTON_RIBS_COOKED);

		tag(ButchercraftItemTags.MUTTON_ROAST_RAW).add(ButchercraftItems.MUTTON_ROAST.get());
		tag(ButchercraftItemTags.MUTTON_ROAST_COOKED).add(ButchercraftItems.COOKED_MUTTON_ROAST.get());
		tag(ButchercraftItemTags.MUTTON_ROAST).addTag(ButchercraftItemTags.MUTTON_ROAST_RAW)
				.addTag(ButchercraftItemTags.MUTTON_ROAST_COOKED);

		tag(ButchercraftItemTags.CUBED_MUTTON_RAW).add(ButchercraftItems.CUBED_MUTTON.get());
		tag(ButchercraftItemTags.CUBED_MUTTON_COOKED).add(ButchercraftItems.COOKED_CUBED_MUTTON.get());
		tag(ButchercraftItemTags.CUBED_MUTTON).addTag(ButchercraftItemTags.CUBED_MUTTON_RAW)
				.addTag(ButchercraftItemTags.CUBED_MUTTON_COOKED);

		tag(ButchercraftItemTags.SCRAP_MUTTON).add(ButchercraftItems.MUTTON_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_MUTTON_COOKED).add(ButchercraftItems.COOKED_MUTTON_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_MUTTON).addTag(ButchercraftItemTags.SCRAP_MUTTON_RAW)
				.addTag(ButchercraftItemTags.SCRAP_MUTTON_COOKED);

		tag(ButchercraftItemTags.STEW_MUTTON).add(ButchercraftItems.MUTTON_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_MUTTON_COOKED).add(ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_MUTTON).addTag(ButchercraftItemTags.STEW_MUTTON_RAW)
				.addTag(ButchercraftItemTags.STEW_MUTTON_COOKED);

		tag(ButchercraftItemTags.MUTTON_RAW).addTag(ButchercraftItemTags.MUTTON_RIBS_RAW)
				.addTag(ButchercraftItemTags.MUTTON_ROAST_RAW).addTag(ButchercraftItemTags.CUBED_MUTTON_RAW)
				.addTag(ButchercraftItemTags.SCRAP_MUTTON_RAW).addTag(ButchercraftItemTags.STEW_MUTTON_RAW);

		tag(ButchercraftItemTags.MUTTON_COOKED).addTag(ButchercraftItemTags.MUTTON_RIBS_COOKED)
				.addTag(ButchercraftItemTags.MUTTON_ROAST_COOKED).addTag(ButchercraftItemTags.CUBED_MUTTON_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_MUTTON_COOKED).addTag(ButchercraftItemTags.STEW_MUTTON_COOKED);

		tag(ButchercraftItemTags.MUTTON).addTag(ButchercraftItemTags.MUTTON_COOKED)
				.addTag(ButchercraftItemTags.MUTTON_RAW);

		// PIG
		tag(ButchercraftItemTags.PORK_RIBS_RAW).add(ButchercraftItems.PORK_RIBS.get());
		tag(ButchercraftItemTags.PORK_RIBS_COOKED).add(ButchercraftItems.COOKED_PORK_RIBS.get());
		tag(ButchercraftItemTags.PORK_RIBS).addTag(ButchercraftItemTags.PORK_RIBS_RAW)
				.addTag(ButchercraftItemTags.PORK_RIBS_COOKED);

		tag(ButchercraftItemTags.PORK_ROAST_RAW).add(ButchercraftItems.PORK_ROAST.get());
		tag(ButchercraftItemTags.PORK_ROAST_COOKED).add(ButchercraftItems.COOKED_PORK_ROAST.get());
		tag(ButchercraftItemTags.PORK_ROAST).addTag(ButchercraftItemTags.PORK_ROAST_RAW)
				.addTag(ButchercraftItemTags.PORK_ROAST_COOKED);

		tag(ButchercraftItemTags.CUBED_PORK_RAW).add(ButchercraftItems.CUBED_PORK.get());
		tag(ButchercraftItemTags.CUBED_PORK_COOKED).add(ButchercraftItems.COOKED_CUBED_PORK.get());
		tag(ButchercraftItemTags.CUBED_PORK).addTag(ButchercraftItemTags.CUBED_PORK_RAW)
				.addTag(ButchercraftItemTags.CUBED_PORK_COOKED);

		tag(ButchercraftItemTags.SCRAP_PORK).add(ButchercraftItems.PORK_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_PORK_COOKED).add(ButchercraftItems.COOKED_PORK_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_PORK).addTag(ButchercraftItemTags.SCRAP_PORK_RAW)
				.addTag(ButchercraftItemTags.SCRAP_PORK_COOKED);

		tag(ButchercraftItemTags.STEW_PORK).add(ButchercraftItems.PORK_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_PORK_COOKED).add(ButchercraftItems.COOKED_PORK_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_PORK).addTag(ButchercraftItemTags.STEW_PORK_RAW)
				.addTag(ButchercraftItemTags.STEW_PORK_COOKED);

		tag(ButchercraftItemTags.PORK_RAW).addTag(ButchercraftItemTags.PORK_RIBS_RAW)
				.addTag(ButchercraftItemTags.PORK_ROAST_RAW).addTag(ButchercraftItemTags.CUBED_PORK_RAW)
				.addTag(ButchercraftItemTags.SCRAP_PORK_RAW).addTag(ButchercraftItemTags.STEW_PORK_RAW);

		tag(ButchercraftItemTags.PORK_COOKED).addTag(ButchercraftItemTags.PORK_RIBS_COOKED)
				.addTag(ButchercraftItemTags.PORK_ROAST_COOKED).addTag(ButchercraftItemTags.CUBED_PORK_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_PORK_COOKED).addTag(ButchercraftItemTags.STEW_PORK_COOKED);

		tag(ButchercraftItemTags.PORK).addTag(ButchercraftItemTags.PORK_COOKED).addTag(ButchercraftItemTags.PORK_RAW);

		tag(ButchercraftItemTags.MEAT_RAW).addTag(ButchercraftItemTags.GOAT_RAW).addTag(ButchercraftItemTags.BEEF_RAW)
				.addTag(ButchercraftItemTags.MUTTON_RAW).addTag(ButchercraftItemTags.PORK_RAW).addTag(ButchercraftItemTags.CHICKEN_RAW).addTag(ButchercraftItemTags.);

		tag(ButchercraftItemTags.MEAT_COOKED);

//
//		tag(ButchercraftItemTags.GROUND_MEAT_RAW).add(ButchercraftItems.GROUND_BEEF.get(),
//				ButchercraftItems.GROUND_LAMB.get(), ButchercraftItems.GROUND_PORK.get());
//		tag(ButchercraftItemTags.CUBED_MEAT_RAW).add(ButchercraftItems.CUBED_BEEF.get(),
//				ButchercraftItems.CUBED_LAMB.get(), ButchercraftItems.CUBED_PORK.get());
//		tag(ButchercraftItemTags.SCRAP_MEAT_RAW).add(ButchercraftItems.BEEF_SCRAPS.get(),
//				ButchercraftItems.LAMB_SCRAPS.get(), ButchercraftItems.PORK_SCRAPS.get());
//
//		tag(Tags.Items.SLIMEBALLS).add(ButchercraftItems.FAT.get());
//		tag(Tags.Items.STRING).add(ButchercraftItems.SINEW.get()).add(ButchercraftItems.LEATHER_CORD.get());
//
//		tag(ButchercraftItemTags.ROAST_RAW).add(ButchercraftItems.BEEF_ROAST.get(), ButchercraftItems.LAMB_ROAST.get(),
//				ButchercraftItems.PORK_ROAST.get());
//
//		tag(ButchercraftItemTags.RIBS_RAW).add(ButchercraftItems.BEEF_RIBS.get(), ButchercraftItems.LAMB_RIBS.get(),
//				ButchercraftItems.PORK_RIBS.get());
//
//		tag(ButchercraftItemTags.OFFAL).add(ButchercraftItems.HEART.get(), ButchercraftItems.LUNG.get(),
//				ButchercraftItems.KIDNEY.get(), ButchercraftItems.LIVER.get(), ButchercraftItems.BRAIN.get(),
//				ButchercraftItems.TRIPE.get());
//
//		tag(ButchercraftItemTags.GELATIN_PROVIDER).add(ButchercraftItems.COW_HIDE.get(),
//				ButchercraftItems.PIG_HIDE.get(), ButchercraftItems.SHEEP_HIDE.get(), Items.BONE,
//				ButchercraftItems.SINEW.get());
//
//		tag(ButchercraftItemTags.GRINDER_ATTACHMENT).add(ButchercraftItems.EXTRUDER_TIP.get())
//				.add(ButchercraftItems.GRINDER_TIP.get());
//
//		tag(ButchercraftItemTags.SAUSAGE_CASING).add(ButchercraftItems.CASING.get());
//
//		tag(ButchercraftItemTags.COW_CARCASS).add(ButchercraftItems.COW_CARCASS.get());
//		tag(ButchercraftItemTags.CHICKEN_CARCASS).add(ButchercraftItems.CHICKEN_CARCASS.get()).add(Items.CHICKEN);
//		tag(ButchercraftItemTags.GOAT_CARCASS).add(ButchercraftItems.GOAT_CARCASS.get());
//		tag(ButchercraftItemTags.PIG_CARCASS).add(ButchercraftItems.PIG_CARCASS.get());
//		tag(ButchercraftItemTags.RABBIT_CARCASS)
//				.add(ButchercraftItems.BLACK_RABBIT_CARCASS.get(), ButchercraftItems.BROWN_RABBIT_CARCASS.get(),
//						ButchercraftItems.GOLD_RABBIT_CARCASS.get(), ButchercraftItems.SALT_RABBIT_CARCASS.get(),
//						ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.get(), ButchercraftItems.WHITE_RABBIT_CARCASS.get())
//				.add(Items.RABBIT);
//		tag(ButchercraftItemTags.SHEEP_CARCASS).add(ButchercraftItems.SHEEP_CARCASS.get());
//
//		tag(ButchercraftItemTags.BUTCHERABLE).addTag(ButchercraftItemTags.COW_CARCASS)
//				.addTag(ButchercraftItemTags.CHICKEN_CARCASS).addTag(ButchercraftItemTags.GOAT_CARCASS)
//				.addTag(ButchercraftItemTags.PIG_CARCASS).addTag(ButchercraftItemTags.RABBIT_CARCASS)
//				.addTag(ButchercraftItemTags.SHEEP_CARCASS).add(ButchercraftItems.COW_HIDE.get())
//				.add(ButchercraftItems.GOAT_HIDE.get()).add(ButchercraftItems.PIG_HIDE.get())
//				.add(ButchercraftItems.SHEEP_HIDE.get()).add(ButchercraftItems.CHICKEN_HEAD_ITEM.get())
//				.add(ButchercraftItems.SAUSAGE_LINKED.get()).add(ButchercraftItems.BLOOD_SAUSAGE_LINKED.get());

	}
}
