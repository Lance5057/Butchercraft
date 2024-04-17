package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

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

		tag(ButchercraftItemTags.SCRAP_GOAT_RAW).add(ButchercraftItems.GOAT_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_GOAT_COOKED).add(ButchercraftItems.COOKED_GOAT_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_GOAT).addTag(ButchercraftItemTags.SCRAP_GOAT_RAW)
				.addTag(ButchercraftItemTags.SCRAP_GOAT_COOKED);

		tag(ButchercraftItemTags.STEW_GOAT_RAW).add(ButchercraftItems.GOAT_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_GOAT_COOKED).add(ButchercraftItems.COOKED_GOAT_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_GOAT).addTag(ButchercraftItemTags.STEW_GOAT_RAW)
				.addTag(ButchercraftItemTags.STEW_GOAT_COOKED);

		tag(ButchercraftItemTags.GROUND_GOAT_RAW).add(ButchercraftItems.GROUND_GOAT.get());
		tag(ButchercraftItemTags.GROUND_GOAT_COOKED).add(ButchercraftItems.COOKED_GROUND_GOAT.get());
		tag(ButchercraftItemTags.GROUND_GOAT).addTag(ButchercraftItemTags.GROUND_GOAT_COOKED)
				.addTag(ButchercraftItemTags.GROUND_GOAT_RAW);

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

		tag(ButchercraftItemTags.SCRAP_BEEF_RAW).add(ButchercraftItems.BEEF_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_BEEF_COOKED).add(ButchercraftItems.COOKED_BEEF_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_BEEF).addTag(ButchercraftItemTags.SCRAP_BEEF_RAW)
				.addTag(ButchercraftItemTags.SCRAP_BEEF_COOKED);

		tag(ButchercraftItemTags.STEW_BEEF_RAW).add(ButchercraftItems.BEEF_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_BEEF_COOKED).add(ButchercraftItems.COOKED_BEEF_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_BEEF).addTag(ButchercraftItemTags.STEW_BEEF_RAW)
				.addTag(ButchercraftItemTags.STEW_BEEF_COOKED);

		tag(ButchercraftItemTags.GROUND_BEEF_RAW).add(ButchercraftItems.GROUND_BEEF.get());
		tag(ButchercraftItemTags.GROUND_BEEF_COOKED).add(ButchercraftItems.COOKED_GROUND_BEEF.get());
		tag(ButchercraftItemTags.GROUND_BEEF).addTag(ButchercraftItemTags.GROUND_BEEF_COOKED)
				.addTag(ButchercraftItemTags.GROUND_BEEF_RAW);

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

		tag(ButchercraftItemTags.SCRAP_MUTTON_RAW).add(ButchercraftItems.MUTTON_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_MUTTON_COOKED).add(ButchercraftItems.COOKED_MUTTON_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_MUTTON).addTag(ButchercraftItemTags.SCRAP_MUTTON_RAW)
				.addTag(ButchercraftItemTags.SCRAP_MUTTON_COOKED);

		tag(ButchercraftItemTags.STEW_MUTTON_RAW).add(ButchercraftItems.MUTTON_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_MUTTON_COOKED).add(ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_MUTTON).addTag(ButchercraftItemTags.STEW_MUTTON_RAW)
				.addTag(ButchercraftItemTags.STEW_MUTTON_COOKED);

		tag(ButchercraftItemTags.GROUND_MUTTON_RAW).add(ButchercraftItems.GROUND_MUTTON.get());
		tag(ButchercraftItemTags.GROUND_MUTTON_COOKED).add(ButchercraftItems.COOKED_GROUND_MUTTON.get());
		tag(ButchercraftItemTags.GROUND_MUTTON).addTag(ButchercraftItemTags.GROUND_MUTTON_COOKED)
				.addTag(ButchercraftItemTags.GROUND_MUTTON_RAW);

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

		tag(ButchercraftItemTags.SCRAP_PORK_RAW).add(ButchercraftItems.PORK_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_PORK_COOKED).add(ButchercraftItems.COOKED_PORK_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_PORK).addTag(ButchercraftItemTags.SCRAP_PORK_RAW)
				.addTag(ButchercraftItemTags.SCRAP_PORK_COOKED);

		tag(ButchercraftItemTags.STEW_PORK_RAW).add(ButchercraftItems.PORK_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_PORK_COOKED).add(ButchercraftItems.COOKED_PORK_STEW_MEAT.get());
		tag(ButchercraftItemTags.STEW_PORK).addTag(ButchercraftItemTags.STEW_PORK_RAW)
				.addTag(ButchercraftItemTags.STEW_PORK_COOKED);

		tag(ButchercraftItemTags.GROUND_PORK_RAW).add(ButchercraftItems.GROUND_PORK.get());
		tag(ButchercraftItemTags.GROUND_PORK_COOKED).add(ButchercraftItems.COOKED_GROUND_PORK.get());
		tag(ButchercraftItemTags.GROUND_PORK).addTag(ButchercraftItemTags.GROUND_PORK_COOKED)
				.addTag(ButchercraftItemTags.GROUND_PORK_RAW);

		tag(ButchercraftItemTags.PORK_RAW).addTag(ButchercraftItemTags.PORK_RIBS_RAW)
				.addTag(ButchercraftItemTags.PORK_ROAST_RAW).addTag(ButchercraftItemTags.CUBED_PORK_RAW)
				.addTag(ButchercraftItemTags.SCRAP_PORK_RAW).addTag(ButchercraftItemTags.STEW_PORK_RAW);

		tag(ButchercraftItemTags.PORK_COOKED).addTag(ButchercraftItemTags.PORK_RIBS_COOKED)
				.addTag(ButchercraftItemTags.PORK_ROAST_COOKED).addTag(ButchercraftItemTags.CUBED_PORK_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_PORK_COOKED).addTag(ButchercraftItemTags.STEW_PORK_COOKED);

		tag(ButchercraftItemTags.PORK).addTag(ButchercraftItemTags.PORK_COOKED).addTag(ButchercraftItemTags.PORK_RAW);

		// CHICKEN
		tag(ButchercraftItemTags.CHICKEN_BREAST_RAW).add(ButchercraftItems.CHICKEN_BREAST.get());
		tag(ButchercraftItemTags.CHICKEN_BREAST_COOKED).add(ButchercraftItems.COOKED_CHICKEN_BREAST.get());
		tag(ButchercraftItemTags.CHICKEN_BREAST).addTag(ButchercraftItemTags.CHICKEN_BREAST_RAW)
				.addTag(ButchercraftItemTags.CHICKEN_BREAST_COOKED);

		tag(ButchercraftItemTags.CHICKEN_THIGH_RAW).add(ButchercraftItems.CHICKEN_THIGH.get());
		tag(ButchercraftItemTags.CHICKEN_THIGH_COOKED).add(ButchercraftItems.COOKED_CHICKEN_THIGH.get());
		tag(ButchercraftItemTags.CHICKEN_THIGH).addTag(ButchercraftItemTags.CHICKEN_THIGH_RAW)
				.addTag(ButchercraftItemTags.CHICKEN_THIGH_COOKED);

		tag(ButchercraftItemTags.CHICKEN_LEG_RAW).add(ButchercraftItems.CHICKEN_LEG.get());
		tag(ButchercraftItemTags.CHICKEN_LEG_COOKED).add(ButchercraftItems.COOKED_CHICKEN_LEG.get());
		tag(ButchercraftItemTags.CHICKEN_LEG).addTag(ButchercraftItemTags.CHICKEN_LEG_RAW)
				.addTag(ButchercraftItemTags.CHICKEN_LEG_COOKED);

		tag(ButchercraftItemTags.CHICKEN_WING_RAW).add(ButchercraftItems.CHICKEN_WING.get());
		tag(ButchercraftItemTags.CHICKEN_WING_COOKED).add(ButchercraftItems.COOKED_CHICKEN_WING.get());
		tag(ButchercraftItemTags.CHICKEN_WING).addTag(ButchercraftItemTags.CHICKEN_WING_RAW)
				.addTag(ButchercraftItemTags.CHICKEN_WING_COOKED);

		tag(ButchercraftItemTags.CUBED_CHICKEN_RAW).add(ButchercraftItems.CUBED_CHICKEN.get());
		tag(ButchercraftItemTags.CUBED_CHICKEN_COOKED).add(ButchercraftItems.COOKED_CUBED_CHICKEN.get());
		tag(ButchercraftItemTags.CUBED_CHICKEN).addTag(ButchercraftItemTags.CUBED_CHICKEN_RAW)
				.addTag(ButchercraftItemTags.CUBED_CHICKEN_COOKED);

		tag(ButchercraftItemTags.SCRAP_CHICKEN_RAW).add(ButchercraftItems.CHICKEN_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_CHICKEN_COOKED).add(ButchercraftItems.COOKED_CHICKEN_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_CHICKEN).addTag(ButchercraftItemTags.SCRAP_CHICKEN_RAW)
				.addTag(ButchercraftItemTags.SCRAP_CHICKEN_COOKED);

		tag(ButchercraftItemTags.GROUND_CHICKEN_RAW).add(ButchercraftItems.GROUND_CHICKEN.get());
		tag(ButchercraftItemTags.GROUND_CHICKEN_COOKED).add(ButchercraftItems.COOKED_GROUND_CHICKEN.get());
		tag(ButchercraftItemTags.GROUND_CHICKEN).addTag(ButchercraftItemTags.GROUND_CHICKEN_COOKED)
				.addTag(ButchercraftItemTags.GROUND_CHICKEN_RAW);

		tag(ButchercraftItemTags.STEW_CHICKEN_RAW).add(ButchercraftItems.STEW_CHICKEN.get());
		tag(ButchercraftItemTags.STEW_CHICKEN_COOKED).add(ButchercraftItems.COOKED_STEW_CHICKEN.get());
		tag(ButchercraftItemTags.STEW_CHICKEN).addTag(ButchercraftItemTags.STEW_CHICKEN_RAW)
				.addTag(ButchercraftItemTags.STEW_CHICKEN_COOKED);

		tag(ButchercraftItemTags.CHICKEN_RAW).addTag(ButchercraftItemTags.CHICKEN_BREAST_RAW)
				.addTag(ButchercraftItemTags.CHICKEN_THIGH_RAW).addTag(ButchercraftItemTags.CHICKEN_LEG_RAW)
				.addTag(ButchercraftItemTags.CHICKEN_WING_RAW).addTag(ButchercraftItemTags.CUBED_CHICKEN_RAW)
				.addTag(ButchercraftItemTags.SCRAP_CHICKEN_RAW).addTag(ButchercraftItemTags.STEW_CHICKEN_RAW);

		tag(ButchercraftItemTags.CHICKEN_COOKED).addTag(ButchercraftItemTags.CHICKEN_BREAST_COOKED)
				.addTag(ButchercraftItemTags.CHICKEN_THIGH_COOKED).addTag(ButchercraftItemTags.CHICKEN_LEG_COOKED)
				.addTag(ButchercraftItemTags.CHICKEN_WING_COOKED).addTag(ButchercraftItemTags.CUBED_CHICKEN_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_CHICKEN_COOKED).addTag(ButchercraftItemTags.STEW_CHICKEN_COOKED);

		tag(ButchercraftItemTags.CHICKEN).addTag(ButchercraftItemTags.CHICKEN_COOKED)
				.addTag(ButchercraftItemTags.CHICKEN_RAW);

		// RABBIT
		tag(ButchercraftItemTags.RABBIT_SADDLE_RAW).add(ButchercraftItems.RABBIT_SADDLE.get());
		tag(ButchercraftItemTags.RABBIT_SADDLE_COOKED).add(ButchercraftItems.COOKED_RABBIT_SADDLE.get());
		tag(ButchercraftItemTags.RABBIT_SADDLE).addTag(ButchercraftItemTags.RABBIT_SADDLE_RAW)
				.addTag(ButchercraftItemTags.RABBIT_SADDLE_COOKED);

		tag(ButchercraftItemTags.RABBIT_THIGH_RAW).add(ButchercraftItems.RABBIT_THIGH.get());
		tag(ButchercraftItemTags.RABBIT_THIGH_COOKED).add(ButchercraftItems.COOKED_RABBIT_THIGH.get());
		tag(ButchercraftItemTags.RABBIT_THIGH).addTag(ButchercraftItemTags.RABBIT_THIGH_RAW)
				.addTag(ButchercraftItemTags.RABBIT_THIGH_COOKED);

		tag(ButchercraftItemTags.RABBIT_LEG_RAW).add(ButchercraftItems.RABBIT_LEG.get());
		tag(ButchercraftItemTags.RABBIT_LEG_COOKED).add(ButchercraftItems.COOKED_RABBIT_LEG.get());
		tag(ButchercraftItemTags.RABBIT_LEG).addTag(ButchercraftItemTags.RABBIT_LEG_RAW)
				.addTag(ButchercraftItemTags.RABBIT_LEG_COOKED);

		tag(ButchercraftItemTags.CUBED_RABBIT_RAW).add(ButchercraftItems.CUBED_RABBIT.get());
		tag(ButchercraftItemTags.CUBED_RABBIT_COOKED).add(ButchercraftItems.COOKED_CUBED_RABBIT.get());
		tag(ButchercraftItemTags.CUBED_RABBIT).addTag(ButchercraftItemTags.CUBED_RABBIT_RAW)
				.addTag(ButchercraftItemTags.CUBED_RABBIT_COOKED);

		tag(ButchercraftItemTags.SCRAP_RABBIT_RAW).add(ButchercraftItems.RABBIT_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_RABBIT_COOKED).add(ButchercraftItems.COOKED_RABBIT_SCRAPS.get());
		tag(ButchercraftItemTags.SCRAP_RABBIT).addTag(ButchercraftItemTags.SCRAP_RABBIT_RAW)
				.addTag(ButchercraftItemTags.SCRAP_RABBIT_COOKED);

		tag(ButchercraftItemTags.STEW_RABBIT_RAW).add(ButchercraftItems.STEW_RABBIT.get());
		tag(ButchercraftItemTags.STEW_RABBIT_COOKED).add(ButchercraftItems.COOKED_STEW_RABBIT.get());
		tag(ButchercraftItemTags.STEW_RABBIT).addTag(ButchercraftItemTags.STEW_RABBIT_RAW)
				.addTag(ButchercraftItemTags.STEW_RABBIT_COOKED);

		tag(ButchercraftItemTags.GROUND_RABBIT_RAW).add(ButchercraftItems.GROUND_RABBIT.get());
		tag(ButchercraftItemTags.GROUND_RABBIT_COOKED).add(ButchercraftItems.COOKED_GROUND_RABBIT.get());
		tag(ButchercraftItemTags.GROUND_RABBIT).addTag(ButchercraftItemTags.GROUND_RABBIT_COOKED)
				.addTag(ButchercraftItemTags.GROUND_RABBIT_RAW);

		tag(ButchercraftItemTags.RABBIT_RAW).addTag(ButchercraftItemTags.RABBIT_SADDLE_RAW)
				.addTag(ButchercraftItemTags.RABBIT_THIGH_RAW).addTag(ButchercraftItemTags.RABBIT_LEG_RAW)
				.addTag(ButchercraftItemTags.CUBED_RABBIT_RAW).addTag(ButchercraftItemTags.SCRAP_RABBIT_RAW)
				.addTag(ButchercraftItemTags.STEW_RABBIT_RAW);

		tag(ButchercraftItemTags.RABBIT_COOKED).addTag(ButchercraftItemTags.RABBIT_SADDLE_COOKED)
				.addTag(ButchercraftItemTags.RABBIT_THIGH_COOKED).addTag(ButchercraftItemTags.RABBIT_LEG_COOKED)
				.addTag(ButchercraftItemTags.CUBED_RABBIT_COOKED).addTag(ButchercraftItemTags.SCRAP_RABBIT_COOKED)
				.addTag(ButchercraftItemTags.STEW_RABBIT_COOKED);

		tag(ButchercraftItemTags.RABBIT).addTag(ButchercraftItemTags.RABBIT_COOKED)
				.addTag(ButchercraftItemTags.RABBIT_RAW);

		tag(ButchercraftItemTags.MEAT_RAW).addTag(ButchercraftItemTags.GOAT_RAW).addTag(ButchercraftItemTags.BEEF_RAW)
				.addTag(ButchercraftItemTags.MUTTON_RAW).addTag(ButchercraftItemTags.PORK_RAW)
				.addTag(ButchercraftItemTags.CHICKEN_RAW).addTag(ButchercraftItemTags.RABBIT_RAW);

		tag(ButchercraftItemTags.MEAT_COOKED).addTag(ButchercraftItemTags.GOAT_COOKED)
				.addTag(ButchercraftItemTags.BEEF_COOKED).addTag(ButchercraftItemTags.MUTTON_COOKED)
				.addTag(ButchercraftItemTags.PORK_COOKED).addTag(ButchercraftItemTags.CHICKEN_COOKED)
				.addTag(ButchercraftItemTags.RABBIT_COOKED);

		tag(ButchercraftItemTags.MEAT).addTag(ButchercraftItemTags.GOAT).addTag(ButchercraftItemTags.BEEF)
				.addTag(ButchercraftItemTags.MUTTON).addTag(ButchercraftItemTags.PORK)
				.addTag(ButchercraftItemTags.CHICKEN).addTag(ButchercraftItemTags.RABBIT);

		tag(ButchercraftItemTags.GROUND_MEAT_RAW).addTag(ButchercraftItemTags.GROUND_BEEF)
				.addTag(ButchercraftItemTags.GROUND_MUTTON).addTag(ButchercraftItemTags.GROUND_PORK)
				.addTag(ButchercraftItemTags.GROUND_CHICKEN).addTag(ButchercraftItemTags.GROUND_RABBIT)
				.addTag(ButchercraftItemTags.GROUND_GOAT);

		tag(ButchercraftItemTags.CUBED_MEAT_RAW).addTag(ButchercraftItemTags.CUBED_BEEF)
				.addTag(ButchercraftItemTags.CUBED_MUTTON).addTag(ButchercraftItemTags.CUBED_PORK)
				.addTag(ButchercraftItemTags.CUBED_CHICKEN).addTag(ButchercraftItemTags.CUBED_RABBIT)
				.addTag(ButchercraftItemTags.CUBED_GOAT);

		tag(ButchercraftItemTags.SCRAP_MEAT_RAW).addTag(ButchercraftItemTags.SCRAP_BEEF_RAW)
				.addTag(ButchercraftItemTags.SCRAP_MUTTON_RAW).addTag(ButchercraftItemTags.SCRAP_PORK_RAW)
				.addTag(ButchercraftItemTags.SCRAP_CHICKEN_RAW).addTag(ButchercraftItemTags.SCRAP_RABBIT_RAW)
				.addTag(ButchercraftItemTags.SCRAP_RABBIT_RAW);

		tag(ButchercraftItemTags.SCRAP_MEAT_COOKED).addTag(ButchercraftItemTags.SCRAP_BEEF_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_MUTTON_COOKED).addTag(ButchercraftItemTags.SCRAP_PORK_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_CHICKEN_COOKED).addTag(ButchercraftItemTags.SCRAP_RABBIT_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_RABBIT_COOKED);

		tag(ButchercraftItemTags.SCRAP_MEAT).addTag(ButchercraftItemTags.SCRAP_MEAT_COOKED)
				.addTag(ButchercraftItemTags.SCRAP_MEAT_RAW);

		tag(ButchercraftItemTags.ROAST_RAW).addTag(ButchercraftItemTags.BEEF_ROAST)
				.addTag(ButchercraftItemTags.MUTTON_ROAST).addTag(ButchercraftItemTags.PORK_ROAST)
				.addTag(ButchercraftItemTags.GOAT_ROAST);

		tag(ButchercraftItemTags.RIBS_RAW).addTag(ButchercraftItemTags.BEEF_RIBS)
				.addTag(ButchercraftItemTags.MUTTON_RIBS).addTag(ButchercraftItemTags.PORK_RIBS)
				.addTag(ButchercraftItemTags.GOAT_RIBS);

		tag(Tags.Items.SLIMEBALLS).add(ButchercraftItems.FAT.get());
		tag(Tags.Items.STRING).add(ButchercraftItems.SINEW.get()).add(ButchercraftItems.LEATHER_CORD.get());

		tag(ButchercraftItemTags.HEART_RAW).add(ButchercraftItems.HEART.get());
		tag(ButchercraftItemTags.HEART_COOKED).add(ButchercraftItems.COOKED_HEART.get());
		tag(ButchercraftItemTags.HEART).addTag(ButchercraftItemTags.HEART_RAW)
				.addTag(ButchercraftItemTags.HEART_COOKED);

		tag(ButchercraftItemTags.LUNG_RAW).add(ButchercraftItems.LUNG.get());
		tag(ButchercraftItemTags.LUNG_COOKED).add(ButchercraftItems.COOKED_LUNG.get());
		tag(ButchercraftItemTags.LUNG).addTag(ButchercraftItemTags.LUNG_RAW).addTag(ButchercraftItemTags.LUNG_COOKED);

		tag(ButchercraftItemTags.KIDNEY_RAW).add(ButchercraftItems.KIDNEY.get());
		tag(ButchercraftItemTags.KIDNEY_COOKED).add(ButchercraftItems.COOKED_KIDNEY.get());
		tag(ButchercraftItemTags.KIDNEY).addTag(ButchercraftItemTags.KIDNEY_RAW)
				.addTag(ButchercraftItemTags.KIDNEY_COOKED);

		tag(ButchercraftItemTags.LIVER_RAW).add(ButchercraftItems.LIVER.get());
		tag(ButchercraftItemTags.LIVER_COOKED).add(ButchercraftItems.COOKED_LIVER.get());
		tag(ButchercraftItemTags.LIVER).addTag(ButchercraftItemTags.LIVER_RAW)
				.addTag(ButchercraftItemTags.LIVER_COOKED);

		tag(ButchercraftItemTags.BRAIN_RAW).add(ButchercraftItems.BRAIN.get());
		tag(ButchercraftItemTags.BRAIN_COOKED).add(ButchercraftItems.COOKED_BRAIN.get());
		tag(ButchercraftItemTags.BRAIN).addTag(ButchercraftItemTags.BRAIN_RAW)
				.addTag(ButchercraftItemTags.BRAIN_COOKED);

		tag(ButchercraftItemTags.STOMACH_RAW).add(ButchercraftItems.STOMACH.get());
		tag(ButchercraftItemTags.STOMACH_COOKED).add(ButchercraftItems.COOKED_STOMACH.get());
		tag(ButchercraftItemTags.STOMACH).addTag(ButchercraftItemTags.STOMACH_RAW)
				.addTag(ButchercraftItemTags.STOMACH_COOKED);

		tag(ButchercraftItemTags.TRIPE_RAW).add(ButchercraftItems.TRIPE.get());
		tag(ButchercraftItemTags.TRIPE_COOKED).add(ButchercraftItems.COOKED_TRIPE.get());
		tag(ButchercraftItemTags.TRIPE).addTag(ButchercraftItemTags.TRIPE_RAW)
				.addTag(ButchercraftItemTags.TRIPE_COOKED);

		tag(ButchercraftItemTags.OFFAL).addTag(ButchercraftItemTags.HEART).addTag(ButchercraftItemTags.LUNG)
				.addTag(ButchercraftItemTags.KIDNEY).addTag(ButchercraftItemTags.LIVER)
				.addTag(ButchercraftItemTags.BRAIN).addTag(ButchercraftItemTags.TRIPE);

		tag(ButchercraftItemTags.OFFAL_RAW).addTag(ButchercraftItemTags.HEART_RAW).addTag(ButchercraftItemTags.LUNG_RAW)
				.addTag(ButchercraftItemTags.KIDNEY_RAW).addTag(ButchercraftItemTags.LIVER_RAW)
				.addTag(ButchercraftItemTags.BRAIN_RAW).addTag(ButchercraftItemTags.TRIPE_RAW);

		tag(ButchercraftItemTags.GELATIN_PROVIDER).add(ButchercraftItems.COW_HIDE.get(),
				ButchercraftItems.PIG_HIDE.get(), ButchercraftItems.SHEEP_HIDE.get(), Items.BONE,
				ButchercraftItems.SINEW.get(), Items.RABBIT_HIDE);

		tag(ButchercraftItemTags.GRINDER_ATTACHMENT).add(ButchercraftItems.EXTRUDER_TIP.get())
				.add(ButchercraftItems.GRINDER_TIP.get());

		tag(ButchercraftItemTags.SAUSAGE_CASING).add(ButchercraftItems.CASING.get());

		tag(ButchercraftItemTags.SAUSAGE_COOKED).add(ButchercraftItems.COOKED_SAUSAGE.get());
		tag(ButchercraftItemTags.SAUSAGE_RAW).add(ButchercraftItems.SAUSAGE.get());

		tag(ButchercraftItemTags.BLOOD_SAUSAGE_COOKED).add(ButchercraftItems.COOKED_BLOOD_SAUSAGE.get());
		tag(ButchercraftItemTags.BLOOD_SAUSAGE_RAW).add(ButchercraftItems.BLOOD_SAUSAGE.get());

		tag(ButchercraftItemTags.SAUSAGE).addTag(ButchercraftItemTags.SAUSAGE_COOKED)
				.addTag(ButchercraftItemTags.SAUSAGE_RAW).addTag(ButchercraftItemTags.BLOOD_SAUSAGE_COOKED)
				.addTag(ButchercraftItemTags.BLOOD_SAUSAGE_RAW);

		tag(ButchercraftItemTags.COW_CARCASS).add(ButchercraftItems.COW_CARCASS.get());
		tag(ButchercraftItemTags.CHICKEN_CARCASS).add(ButchercraftItems.CHICKEN_CARCASS.get()).add(Items.CHICKEN);
		tag(ButchercraftItemTags.GOAT_CARCASS).add(ButchercraftItems.GOAT_CARCASS.get());
		tag(ButchercraftItemTags.PIG_CARCASS).add(ButchercraftItems.PIG_CARCASS.get());
		tag(ButchercraftItemTags.RABBIT_CARCASS)
				.add(ButchercraftItems.BLACK_RABBIT_CARCASS.get(), ButchercraftItems.BROWN_RABBIT_CARCASS.get(),
						ButchercraftItems.GOLD_RABBIT_CARCASS.get(), ButchercraftItems.SALT_RABBIT_CARCASS.get(),
						ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.get(), ButchercraftItems.WHITE_RABBIT_CARCASS.get())
				.add(Items.RABBIT);
		tag(ButchercraftItemTags.SHEEP_CARCASS).add(ButchercraftItems.SHEEP_CARCASS.get());

	}
}
