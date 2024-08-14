package com.lance5057.butchercraft.data.builders;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.tags.ButchercraftEntityTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ButchercraftEntityTypeTagsProvider extends EntityTypeTagsProvider {

	public ButchercraftEntityTypeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, ExistingFileHelper existingFileHelper) {
		super(pOutput, pLookupProvider, Butchercraft.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider pProvider) {
		tag(ButchercraftEntityTags.CARCASSES).add(EntityType.COW, EntityType.SHEEP, EntityType.PIG, EntityType.GOAT,
				EntityType.RABBIT, EntityType.CHICKEN);
	}

}
