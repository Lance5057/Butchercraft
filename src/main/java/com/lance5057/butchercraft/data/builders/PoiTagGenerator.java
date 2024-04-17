package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.entity.ButchercraftVillagers;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class PoiTagGenerator extends PoiTypeTagsProvider {

	public PoiTagGenerator(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
		super(pGenerator, Butchercraft.MOD_ID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addTags() {
		 this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(ButchercraftVillagers.SLAUGHTER_POI.get());
	}
}
