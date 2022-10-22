package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.ButchercraftBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ButchercraftBlockLootTables extends BlockLoot {
	@Override
	protected void addTables() {
		dropSelf(ButchercraftBlocks.MEAT_HOOK.get());

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
		
		this.dropOther(ButchercraftBlocks.MEAT_PIE_BLOCK.get(), Items.AIR);
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return ButchercraftBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
	}
}
