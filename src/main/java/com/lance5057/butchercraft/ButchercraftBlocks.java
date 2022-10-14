package com.lance5057.butchercraft;

import com.lance5057.butchercraft.blocks.HashBowlBlock;
import com.lance5057.butchercraft.blocks.HideBlock;
import com.lance5057.butchercraft.blocks.JarBlock;
import com.lance5057.butchercraft.items.ButchercraftItems;
import com.lance5057.butchercraft.workstations.blocks.MeatHookBlock;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Butchercraft.MOD_ID);

	public static final RegistryObject<MeatHookBlock> MEAT_HOOK = BLOCKS.register("meat_hook", MeatHookBlock::new);
//	public static final RegistryObject<SkullBlock> COW_SKULL = BLOCKS.register("cow_skull",
//			() -> new SkullBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)));
//	public static final RegistryObject<SkullBlock> PIG_SKULL = BLOCKS.register("pig_skull",
//			() -> new SkullBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)));
//	public static final RegistryObject<SkullBlock> SHEEP_SKULL = BLOCKS.register("sheep_skull",
//			() -> new SkullBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)));

	public static final RegistryObject<Block> BEEF_BLOCK = BLOCKS.register("beef_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> COOKED_BEEF_BLOCK = BLOCKS.register("cooked_beef_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN)));

	public static final RegistryObject<Block> PORK_BLOCK = BLOCKS.register("pork_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> COOKED_PORK_BLOCK = BLOCKS.register("cooked_pork_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN)));

	public static final RegistryObject<Block> LAMB_BLOCK = BLOCKS.register("lamb_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> COOKED_LAMB_BLOCK = BLOCKS.register("cooked_lamb_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN)));

	public static final RegistryObject<HideBlock> COW_HIDE_CARPET = BLOCKS.register("cow_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<HideBlock> PIG_HIDE_CARPET = BLOCKS.register("pig_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_PINK)));
	public static final RegistryObject<HideBlock> SHEEP_HIDE_CARPET = BLOCKS.register("sheep_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.TERRACOTTA_WHITE)));

	// Food Stuff
	public static final RegistryObject<JarBlock> STOCK_JAR_BLOCK = BLOCKS.register("stock_jar_block",
			() -> new JarBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<JarBlock> BBQ_JAR_BLOCK = BLOCKS.register("bbq_jar_block",
			() -> new JarBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<JarBlock> KETCHUP_JAR_BLOCK = BLOCKS.register("ketchup_jar_block",
			() -> new JarBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<JarBlock> GRAVY_BOAT = BLOCKS.register("gravy_boat",
			() -> new JarBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN)));

	public static final RegistryObject<HashBowlBlock> HASH_FEAST = BLOCKS.register("hash_block",
			() -> new HashBowlBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ButchercraftItems.HASH, true));

	public static void register(IEventBus modBus) {

		BLOCKS.register(modBus);
	}
}
