package com.lance5057.butchercraft.data.builders;

import java.util.Collections;

import org.jetbrains.annotations.NotNull;

import com.lance5057.butchercraft.ButchercraftBlocks;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftBlockLootTables extends BlockLootSubProvider {
	protected ButchercraftBlockLootTables() {
		super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		dropSelf(ButchercraftBlocks.MEAT_HOOK.get());

		dropSelf(ButchercraftBlocks.BUTCHER_BLOCK.get());
		dropSelf(ButchercraftBlocks.GRINDER.get());

//        dropSelf(ButchercraftBlocks.COW_SKULL.get());
//        dropSelf(ButchercraftBlocks.PIG_SKULL.get());
//        dropSelf(ButchercraftBlocks.SHEEP_SKULL.get());

		dropSelf(ButchercraftBlocks.BEEF_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_BEEF_BLOCK.get());
		dropSelf(ButchercraftBlocks.PORK_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_PORK_BLOCK.get());
		dropSelf(ButchercraftBlocks.MUTTON_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_MUTTON_BLOCK.get());
		dropSelf(ButchercraftBlocks.GOAT_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_GOAT_BLOCK.get());
		dropSelf(ButchercraftBlocks.RABBIT_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_RABBIT_BLOCK.get());
		dropSelf(ButchercraftBlocks.CHICKEN_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_CHICKEN_BLOCK.get());
		dropSelf(ButchercraftBlocks.SAUSAGE_BLOCK.get());
		dropSelf(ButchercraftBlocks.BLOOD_SAUSAGE_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_BLOOD_SAUSAGE_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_SAUSAGE_BLOCK.get());

		dropSelf(ButchercraftBlocks.COW_HIDE_CARPET.get());
		dropSelf(ButchercraftBlocks.PIG_HIDE_CARPET.get());
		dropSelf(ButchercraftBlocks.SHEEP_HIDE_CARPET.get());
		dropSelf(ButchercraftBlocks.GOAT_HIDE_CARPET.get());

		dropSelf(ButchercraftBlocks.TAXIDERMY_COW_BLOCK.get());
		dropSelf(ButchercraftBlocks.TAXIDERMY_SHEEP_BLOCK.get());
		dropSelf(ButchercraftBlocks.TAXIDERMY_PIG_BLOCK.get());
		dropSelf(ButchercraftBlocks.TAXIDERMY_GOAT_BLOCK.get());
		dropSelf(ButchercraftBlocks.TAXIDERMY_CHICKEN_BLOCK.get());

		dropSelf(ButchercraftBlocks.TAXIDERMY_BLACK_RABBIT_BLOCK.get());
		dropSelf(ButchercraftBlocks.TAXIDERMY_BROWN_RABBIT_BLOCK.get());
		dropSelf(ButchercraftBlocks.TAXIDERMY_GOLD_RABBIT_BLOCK.get());
		dropSelf(ButchercraftBlocks.TAXIDERMY_SALT_RABBIT_BLOCK.get());
		dropSelf(ButchercraftBlocks.TAXIDERMY_SPLOTCHED_RABBIT_BLOCK.get());
		dropSelf(ButchercraftBlocks.TAXIDERMY_WHITE_RABBIT_BLOCK.get());

		dropSelf(ButchercraftBlocks.BARN_WOOD_BLOCK.get());
		dropSelf(ButchercraftBlocks.BARN_WOOD_DOOR.get());
		dropSelf(ButchercraftBlocks.BARN_WOOD_SLAB.get());
		dropSelf(ButchercraftBlocks.BARN_WOOD_STAIRS.get());

		dropSelf(ButchercraftBlocks.COW_HEAD.get());
		dropSelf(ButchercraftBlocks.COW_SKULL_HEAD.get());
		dropSelf(ButchercraftBlocks.SHEEP_HEAD.get());
		dropSelf(ButchercraftBlocks.SHEEP_SKULL_HEAD.get());
		dropSelf(ButchercraftBlocks.CHICKEN_HEAD.get());
		dropSelf(ButchercraftBlocks.CHICKEN_SKULL_HEAD.get());
		dropSelf(ButchercraftBlocks.PIG_HEAD.get());
		dropSelf(ButchercraftBlocks.PIG_SKULL_HEAD.get());
		dropSelf(ButchercraftBlocks.GOAT_HEAD.get());
		dropSelf(ButchercraftBlocks.GOAT_SKULL_HEAD.get());

		dropSelf(ButchercraftBlocks.RABBIT_BLACK_HEAD.get());
		dropSelf(ButchercraftBlocks.RABBIT_BROWN_HEAD.get());
		dropSelf(ButchercraftBlocks.RABBIT_GOLD_HEAD.get());
		dropSelf(ButchercraftBlocks.RABBIT_SALT_HEAD.get());
		dropSelf(ButchercraftBlocks.RABBIT_SPLOTCHED_HEAD.get());
		dropSelf(ButchercraftBlocks.RABBIT_WHITE_HEAD.get());
		dropSelf(ButchercraftBlocks.RABBIT_SKULL_HEAD.get());

		dropSelf(ButchercraftBlocks.BARN_WOOD_BLOCK.get());
		createDoorTable(ButchercraftBlocks.BARN_WOOD_DOOR.get());
		createSlabItemTable(ButchercraftBlocks.BARN_WOOD_SLAB.get());
		dropSelf(ButchercraftBlocks.BARN_WOOD_STAIRS.get());
		dropSelf(ButchercraftBlocks.BARN_WOOD_TRAPDOOR.get());
		dropSelf(ButchercraftBlocks.BARN_WOOD_FENCE.get());
		dropSelf(ButchercraftBlocks.BARN_WOOD_FENCE_GATE.get());

		dropSelf(ButchercraftBlocks.TRIMMED_BARN_WOOD_BLOCK.get());
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return ButchercraftBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
	}
}
