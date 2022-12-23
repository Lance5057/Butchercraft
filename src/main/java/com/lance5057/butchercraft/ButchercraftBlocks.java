package com.lance5057.butchercraft;

import com.lance5057.butchercraft.blocks.BbqRibsBlock;
import com.lance5057.butchercraft.blocks.HashBowlBlock;
import com.lance5057.butchercraft.blocks.HideBlock;
import com.lance5057.butchercraft.blocks.JellyBlock;
import com.lance5057.butchercraft.blocks.PotRoastBlock;
import com.lance5057.butchercraft.blocks.SalisburySteakBlock;
import com.lance5057.butchercraft.workstations.blocks.DryingRackBlock;
import com.lance5057.butchercraft.workstations.blocks.MeatHookBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;

public class ButchercraftBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Butchercraft.MOD_ID);

	public static final RegistryObject<MeatHookBlock> MEAT_HOOK = BLOCKS.register("meat_hook", MeatHookBlock::new);
	public static final RegistryObject<DryingRackBlock> DRYING_RACK = BLOCKS.register("drying_rack", DryingRackBlock::new); 
//	public static final RegistryObject<SkullBlock> COW_SKULL = BLOCKS.register("cow_skull",
//			() -> new SkullBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)));
//	public static final RegistryObject<SkullBlock> PIG_SKULL = BLOCKS.register("pig_skull",
//			() -> new SkullBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)));
//	public static final RegistryObject<SkullBlock> SHEEP_SKULL = BLOCKS.register("sheep_skull",
//			() -> new SkullBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)));

	public static final RegistryObject<Block> BEEF_BLOCK = BLOCKS.register("beef_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> COOKED_BEEF_BLOCK = BLOCKS.register("cooked_beef_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<Block> PORK_BLOCK = BLOCKS.register("pork_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> COOKED_PORK_BLOCK = BLOCKS.register("cooked_pork_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<Block> LAMB_BLOCK = BLOCKS.register("lamb_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> COOKED_LAMB_BLOCK = BLOCKS.register("cooked_lamb_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<HideBlock> COW_HIDE_CARPET = BLOCKS.register("cow_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<HideBlock> PIG_HIDE_CARPET = BLOCKS.register("pig_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_PINK)));
	public static final RegistryObject<HideBlock> SHEEP_HIDE_CARPET = BLOCKS.register("sheep_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.TERRACOTTA_WHITE)));

	// Food Stuff
	public static final RegistryObject<Block> CHEESE_BLOCK = BLOCKS.register("cheese_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_ORANGE).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> BUTTER_BLOCK = BLOCKS.register("butter_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.ICE, MaterialColor.COLOR_YELLOW).friction(0.98F).sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<HashBowlBlock> HASH_FEAST = BLOCKS.register("hash_block",
			() -> new HashBowlBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.HASH, true));
	public static final RegistryObject<PotRoastBlock> POT_ROAST_FEAST = BLOCKS.register("potroast_block",
			() -> new PotRoastBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.POT_ROAST, true));
	public static final RegistryObject<SalisburySteakBlock> SALISBURY_STEAK_FEAST = BLOCKS.register("salisbury_steak_block",
			() -> new SalisburySteakBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.SALISBURY_STEAK, true));
	public static final RegistryObject<BbqRibsBlock> BBQ_RIBS_FEAST = BLOCKS.register("bbq_ribs_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.BBQ_RIBS, true)); 
	public static final RegistryObject<BbqRibsBlock> PULLED_PORK_FEAST = BLOCKS.register("pulled_pork_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.PULLED_PORK_SANDWICH, true)); 
	public static final RegistryObject<BbqRibsBlock> MASHED_POTATO_GRAVY = BLOCKS.register("mashed_potato_gravy_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.MASHED_POTATO_GRAVY, true)); 
	public static final RegistryObject<BbqRibsBlock> RACK_LAMB = BLOCKS.register("rack_lamb_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.RACK_LAMB, true)); 
	public static final RegistryObject<BbqRibsBlock> STIRFRY = BLOCKS.register("stirfry_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.STIRFRY, true)); 
	public static final RegistryObject<BbqRibsBlock> BEEF_WELLINGTON = BLOCKS.register("beef_wellington_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.BEEF_WELLINGTON, true));  
	public static final RegistryObject<BbqRibsBlock> HAGGIS = BLOCKS.register("haggis_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.HAGGIS, true));  
	
	public static final RegistryObject<JellyBlock> JELLY_WHITE = BLOCKS.register("jelly_white_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_WHITE),
					ButchercraftItems.JELLY_WHITE, true));  
	public static final RegistryObject<JellyBlock> JELLY_ORANGE = BLOCKS.register("jelly_orange_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_ORANGE),
					ButchercraftItems.JELLY_ORANGE, true)); 
	public static final RegistryObject<JellyBlock> JELLY_MAGENTA = BLOCKS.register("jelly_magenta_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_MAGENTA),
					ButchercraftItems.JELLY_MAGENTA, true)); 
	public static final RegistryObject<JellyBlock> JELLY_LIGHT_BLUE = BLOCKS.register("jelly_light_blue_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_LIGHT_BLUE),
					ButchercraftItems.JELLY_LIGHT_BLUE, true)); 
	public static final RegistryObject<JellyBlock> JELLY_YELLOW = BLOCKS.register("jelly_yellow_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_YELLOW),
					ButchercraftItems.JELLY_YELLOW, true)); 
	public static final RegistryObject<JellyBlock> JELLY_LIME = BLOCKS.register("jelly_lime_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_LIGHT_GREEN),
					ButchercraftItems.JELLY_LIME, true)); 
	public static final RegistryObject<JellyBlock> JELLY_PINK = BLOCKS.register("jelly_pink_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_PINK),
					ButchercraftItems.JELLY_PINK, true)); 
	public static final RegistryObject<JellyBlock> JELLY_GREY = BLOCKS.register("jelly_grey_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_GRAY),
					ButchercraftItems.JELLY_GREY, true)); 
	public static final RegistryObject<JellyBlock> JELLY_LIGHT_GREY = BLOCKS.register("jelly_light_grey_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_LIGHT_GRAY),
					ButchercraftItems.JELLY_LIGHT_GREY, true)); 
	public static final RegistryObject<JellyBlock> JELLY_CYAN = BLOCKS.register("jelly_cyan_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_CYAN),
					ButchercraftItems.JELLY_CYAN, true)); 
	public static final RegistryObject<JellyBlock> JELLY_PURPLE = BLOCKS.register("jelly_purple_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_PURPLE),
					ButchercraftItems.JELLY_PURPLE, true)); 
	public static final RegistryObject<JellyBlock> JELLY_BLUE = BLOCKS.register("jelly_blue_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_BLUE),
					ButchercraftItems.JELLY_BLUE, true)); 
	public static final RegistryObject<JellyBlock> JELLY_BROWN = BLOCKS.register("jelly_brown_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_BROWN),
					ButchercraftItems.JELLY_BROWN, true)); 
	public static final RegistryObject<JellyBlock> JELLY_GREEN = BLOCKS.register("jelly_green_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_GREEN),
					ButchercraftItems.JELLY_GREEN, true)); 
	public static final RegistryObject<JellyBlock> JELLY_RED = BLOCKS.register("jelly_red_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_RED),
					ButchercraftItems.JELLY_RED, true)); 
	public static final RegistryObject<JellyBlock> JELLY_BLACK = BLOCKS.register("jelly_black_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_BLACK),
					ButchercraftItems.JELLY_BLACK, true)); 
	
	public static final RegistryObject<PieBlock> MEAT_PIE_BLOCK = BLOCKS.register("meat_pie",
			() -> new PieBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.MEAT_PIE_SLICE)); 

	public static void register(IEventBus modBus) {

		BLOCKS.register(modBus);
	}
}
