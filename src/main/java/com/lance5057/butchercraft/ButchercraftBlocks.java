package com.lance5057.butchercraft;

import com.lance5057.butchercraft.blocks.HideBlock;
import com.lance5057.butchercraft.workstations.butcherblock.ButcherBlockBlock;
import com.lance5057.butchercraft.workstations.grinder.GrinderBlock;
import com.lance5057.butchercraft.workstations.hook.MeatHookBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
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

	public static final RegistryObject<ButcherBlockBlock> BUTCHER_BLOCK = BLOCKS.register("butcher_block",
			ButcherBlockBlock::new);

	public static final RegistryObject<GrinderBlock> GRINDER = BLOCKS.register("grinder", GrinderBlock::new);

	public static final RegistryObject<Block> BEEF_BLOCK = BLOCKS.register("beef_block", () -> new Block(
			BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> COOKED_BEEF_BLOCK = BLOCKS.register("cooked_beef_block", () -> new Block(
			BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<Block> PORK_BLOCK = BLOCKS.register("pork_block", () -> new Block(
			BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> COOKED_PORK_BLOCK = BLOCKS.register("cooked_pork_block", () -> new Block(
			BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<Block> LAMB_BLOCK = BLOCKS.register("lamb_block", () -> new Block(
			BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> COOKED_LAMB_BLOCK = BLOCKS.register("cooked_lamb_block", () -> new Block(
			BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<HideBlock> COW_HIDE_CARPET = BLOCKS.register("cow_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<HideBlock> PIG_HIDE_CARPET = BLOCKS.register("pig_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_PINK)));
	public static final RegistryObject<HideBlock> SHEEP_HIDE_CARPET = BLOCKS.register("sheep_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.TERRACOTTA_WHITE)));

	// Food Stuff

	public static void register(IEventBus modBus) {

		BLOCKS.register(modBus);
	}
}
