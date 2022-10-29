package com.lance5057.butchercraft.data.builders;

import org.jetbrains.annotations.Nullable;

import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTagGenerator extends ItemTagsProvider {

	public ItemTagGenerator(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, String modId,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(pGenerator, pBlockTagsProvider, modId, existingFileHelper);
	}

	@Override
	protected void addTags() {
		tag(ButchercraftItemTags.ANY_MEAT_RAW).add(ButchercraftItems.BEEF_RIB.get(), ButchercraftItems.BEEF_RIBS.get(),
				ButchercraftItems.BEEF_ROAST.get(), ButchercraftItems.BEEF_SCRAPS.get(),
				ButchercraftItems.BEEF_STEW_MEAT.get(), ButchercraftItems.CUBED_BEEF.get(),
				ButchercraftItems.GROUND_BEEF.get(), ButchercraftItems.PORK_RIB.get(),
				ButchercraftItems.PORK_RIBS.get(), ButchercraftItems.PORK_ROAST.get(),
				ButchercraftItems.PORK_SCRAPS.get(), ButchercraftItems.PORK_STEW_MEAT.get(),
				ButchercraftItems.CUBED_PORK.get(), ButchercraftItems.GROUND_PORK.get(), ButchercraftItems.BACON.get(),
				ButchercraftItems.LAMB_RIB.get(), ButchercraftItems.LAMB_RIBS.get(), ButchercraftItems.LAMB_ROAST.get(),
				ButchercraftItems.LAMB_SCRAPS.get(), ButchercraftItems.LAMB_STEW_MEAT.get(),
				ButchercraftItems.CUBED_LAMB.get(), ButchercraftItems.GROUND_LAMB.get());

		tag(ButchercraftItemTags.ANY_MEAT_COOKED).add(ButchercraftItems.COOKED_BEEF_RIB.get(),
				ButchercraftItems.COOKED_BEEF_RIBS.get(), ButchercraftItems.COOKED_BEEF_ROAST.get(),
				ButchercraftItems.COOKED_BEEF_SCRAPS.get(), ButchercraftItems.COOKED_BEEF_STEW_MEAT.get(),
				ButchercraftItems.COOKED_CUBED_BEEF.get(), ButchercraftItems.COOKED_GROUND_BEEF.get(),
				ButchercraftItems.COOKED_PORK_RIB.get(), ButchercraftItems.COOKED_PORK_RIBS.get(),
				ButchercraftItems.COOKED_PORK_ROAST.get(), ButchercraftItems.COOKED_PORK_SCRAPS.get(),
				ButchercraftItems.COOKED_PORK_STEW_MEAT.get(), ButchercraftItems.COOKED_CUBED_PORK.get(),
				ButchercraftItems.COOKED_GROUND_PORK.get(), ButchercraftItems.COOKED_BACON.get(),
				ButchercraftItems.COOKED_LAMB_RIB.get(), ButchercraftItems.COOKED_LAMB_RIBS.get(),
				ButchercraftItems.COOKED_LAMB_ROAST.get(), ButchercraftItems.COOKED_LAMB_SCRAPS.get(),
				ButchercraftItems.COOKED_LAMB_STEW_MEAT.get(), ButchercraftItems.COOKED_CUBED_LAMB.get(),
				ButchercraftItems.COOKED_GROUND_LAMB.get());

		tag(ButchercraftItemTags.ANY_BEEF_RAW).add(ButchercraftItems.BEEF_RIB.get(), ButchercraftItems.BEEF_RIBS.get(),
				ButchercraftItems.BEEF_ROAST.get(), ButchercraftItems.BEEF_SCRAPS.get(),
				ButchercraftItems.BEEF_STEW_MEAT.get(), ButchercraftItems.CUBED_BEEF.get(),
				ButchercraftItems.GROUND_BEEF.get());

		tag(ButchercraftItemTags.ANY_PORK_RAW).add(ButchercraftItems.PORK_RIB.get(), ButchercraftItems.PORK_RIBS.get(),
				ButchercraftItems.PORK_ROAST.get(), ButchercraftItems.PORK_SCRAPS.get(),
				ButchercraftItems.PORK_STEW_MEAT.get(), ButchercraftItems.CUBED_PORK.get(),
				ButchercraftItems.GROUND_PORK.get(), ButchercraftItems.BACON.get());

		tag(ButchercraftItemTags.ANY_LAMB_RAW).add(ButchercraftItems.LAMB_RIB.get(), ButchercraftItems.LAMB_RIBS.get(),
				ButchercraftItems.LAMB_ROAST.get(), ButchercraftItems.LAMB_SCRAPS.get(),
				ButchercraftItems.LAMB_STEW_MEAT.get(), ButchercraftItems.CUBED_LAMB.get(),
				ButchercraftItems.GROUND_LAMB.get());

		tag(ButchercraftItemTags.ANY_BEEF_COOKED).add(ButchercraftItems.COOKED_BEEF_RIB.get(),
				ButchercraftItems.COOKED_BEEF_RIBS.get(), ButchercraftItems.COOKED_BEEF_ROAST.get(),
				ButchercraftItems.COOKED_BEEF_SCRAPS.get(), ButchercraftItems.COOKED_BEEF_STEW_MEAT.get(),
				ButchercraftItems.COOKED_CUBED_BEEF.get(), ButchercraftItems.COOKED_GROUND_BEEF.get());

		tag(ButchercraftItemTags.ANY_PORK_COOKED).add(ButchercraftItems.COOKED_PORK_RIB.get(),
				ButchercraftItems.COOKED_PORK_RIBS.get(), ButchercraftItems.COOKED_PORK_ROAST.get(),
				ButchercraftItems.COOKED_PORK_SCRAPS.get(), ButchercraftItems.COOKED_PORK_STEW_MEAT.get(),
				ButchercraftItems.COOKED_CUBED_PORK.get(), ButchercraftItems.COOKED_GROUND_PORK.get(),
				ButchercraftItems.COOKED_BACON.get());

		tag(ButchercraftItemTags.ANY_LAMB_COOKED).add(ButchercraftItems.COOKED_LAMB_RIB.get(),
				ButchercraftItems.COOKED_LAMB_RIBS.get(), ButchercraftItems.COOKED_LAMB_ROAST.get(),
				ButchercraftItems.COOKED_LAMB_SCRAPS.get(), ButchercraftItems.COOKED_LAMB_STEW_MEAT.get(),
				ButchercraftItems.COOKED_CUBED_LAMB.get(), ButchercraftItems.COOKED_GROUND_LAMB.get());

		tag(ButchercraftItemTags.ANY_GROUND_MEAT_RAW).add(ButchercraftItems.GROUND_BEEF.get(),
				ButchercraftItems.GROUND_LAMB.get(), ButchercraftItems.GROUND_PORK.get());
		
		tag(ButchercraftItemTags.ANY_SCRAP_MEAT_RAW).add(ButchercraftItems.BEEF_SCRAPS.get(),
				ButchercraftItems.LAMB_SCRAPS.get(), ButchercraftItems.PORK_SCRAPS.get());

		tag(Tags.Items.SLIMEBALLS).add(ButchercraftItems.FAT.get());
		tag(Tags.Items.STRING).add(ButchercraftItems.SINEW.get()).add(ButchercraftItems.LEATHER_SCRAP.get());
		
		tag(ButchercraftItemTags.ANY_ROAST_RAW).add(ButchercraftItems.BEEF_ROAST.get(),
				ButchercraftItems.LAMB_ROAST.get(), ButchercraftItems.PORK_ROAST.get());
	}
}
