package com.lance5057.butchercraft.data.builders;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.entity.ButchercraftVillagers;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class PoiTagGenerator extends IntrinsicHolderTagsProvider<PoiType> {
	public PoiTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(pOutput, Registries.POINT_OF_INTEREST_TYPE, pLookupProvider, poiType -> BuiltInRegistries.POINT_OF_INTEREST_TYPE.getResourceKey(poiType).orElseThrow(), Butchercraft.MOD_ID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider pProvider) {
		 this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(ButchercraftVillagers.SLAUGHTER_POI.get());
	}
}
