package com.lance5057.butchercraft.data.builders;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftFluids;
import com.lance5057.butchercraft.tags.ButchercraftFluidTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ButchercraftFluidTagGenerator extends FluidTagsProvider {

	public ButchercraftFluidTagGenerator(PackOutput output, CompletableFuture<Provider> provider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, provider, Butchercraft.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		tag(ButchercraftFluidTags.BLOOD).add(ButchercraftFluids.BLOOD.FLUID.get());
	}

}
