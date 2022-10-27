package com.lance5057.butchercraft.data.builders;

import org.jetbrains.annotations.NotNull;

import com.lance5057.butchercraft.ButchercraftBlocks;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftBlockLootTables extends BlockLoot {
	@Override
	protected void addTables() {
		dropSelf(ButchercraftBlocks.MEAT_HOOK.get());
		dropSelf(ButchercraftBlocks.DRYING_RACK.get());

//        dropSelf(ButchercraftBlocks.COW_SKULL.get());
//        dropSelf(ButchercraftBlocks.PIG_SKULL.get());
//        dropSelf(ButchercraftBlocks.SHEEP_SKULL.get());

		dropSelf(ButchercraftBlocks.BEEF_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_BEEF_BLOCK.get());
		dropSelf(ButchercraftBlocks.PORK_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_PORK_BLOCK.get());
		dropSelf(ButchercraftBlocks.LAMB_BLOCK.get());
		dropSelf(ButchercraftBlocks.COOKED_LAMB_BLOCK.get());

		dropSelf(ButchercraftBlocks.COW_HIDE_CARPET.get());
		dropSelf(ButchercraftBlocks.PIG_HIDE_CARPET.get());
		dropSelf(ButchercraftBlocks.SHEEP_HIDE_CARPET.get());

		dropSelf(ButchercraftBlocks.BBQ_JAR_BLOCK.get());
		dropSelf(ButchercraftBlocks.STOCK_JAR_BLOCK.get());
		dropSelf(ButchercraftBlocks.KETCHUP_JAR_BLOCK.get());
		dropSelf(ButchercraftBlocks.GRAVY_BOAT.get());

		this.dropOther(ButchercraftBlocks.HASH_FEAST.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.POT_ROAST_FEAST.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.SALISBURY_STEAK_FEAST.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.BBQ_RIBS_FEAST.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.PULLED_PORK_FEAST.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.MASHED_POTATO_GRAVY.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.RACK_LAMB.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.STIRFRY.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.BEEF_WELLINGTON.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.HAGGIS.get(), Items.BOWL);
		
		this.dropOther(ButchercraftBlocks.JELLY_WHITE.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_ORANGE.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_MAGENTA.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_LIGHT_BLUE.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_YELLOW.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_LIME.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_PINK.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_GREY.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_LIGHT_GREY.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_CYAN.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_PURPLE.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_BLUE.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_BROWN.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_GREEN.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_RED.get(), Items.BOWL);
		this.dropOther(ButchercraftBlocks.JELLY_BLACK.get(), Items.BOWL);
		
		this.dropOther(ButchercraftBlocks.MEAT_PIE_BLOCK.get(), Items.AIR);
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return ButchercraftBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
	}
}
