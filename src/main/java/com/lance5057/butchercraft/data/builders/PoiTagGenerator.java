package com.lance5057.butchercraft.data.builders;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.entity.ButchercraftVillagers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class PoiTagGenerator extends IntrinsicHolderTagsProvider<PoiType> {
	public PoiTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(pOutput, ForgeRegistries.Keys.POI_TYPES, pLookupProvider, poiType -> ForgeRegistries.POI_TYPES.getResourceKey(poiType).orElseThrow(), Butchercraft.MOD_ID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider pProvider) {
		 this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(ButchercraftVillagers.SLAUGHTER_POI.get());
	}
}
