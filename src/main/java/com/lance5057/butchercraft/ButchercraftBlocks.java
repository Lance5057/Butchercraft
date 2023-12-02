package com.lance5057.butchercraft;

import com.lance5057.butchercraft.blocks.AnimalHeadBlock;
import com.lance5057.butchercraft.blocks.AnimalWallHeadBlock;
import com.lance5057.butchercraft.blocks.HideBlock;
import com.lance5057.butchercraft.blocks.TaxidermyBlock;
import com.lance5057.butchercraft.workstations.butcherblock.ButcherBlockBlock;
import com.lance5057.butchercraft.workstations.grinder.GrinderBlock;
import com.lance5057.butchercraft.workstations.hook.MeatHookBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSkullBlock;
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
	public static final RegistryObject<HideBlock> GOAT_HIDE_CARPET = BLOCKS.register("goat_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.TERRACOTTA_WHITE)));

	public static final RegistryObject<TaxidermyBlock> COW_BLOCK = BLOCKS.register("cow_block",
			() -> new TaxidermyBlock());
	public static final RegistryObject<TaxidermyBlock> PIG_BLOCK = BLOCKS.register("pig_block",
			() -> new TaxidermyBlock());
	public static final RegistryObject<TaxidermyBlock> SHEEP_BLOCK = BLOCKS.register("sheep_block",
			() -> new TaxidermyBlock());
	public static final RegistryObject<TaxidermyBlock> GOAT_BLOCK = BLOCKS.register("goat_block",
			() -> new TaxidermyBlock());
	public static final RegistryObject<TaxidermyBlock> RABBIT_BLOCK = BLOCKS.register("rabbit_block",
			() -> new TaxidermyBlock());
	public static final RegistryObject<TaxidermyBlock> CHICKEN_BLOCK = BLOCKS.register("chicken_block",
			() -> new TaxidermyBlock());

	public static final RegistryObject<LiquidBlock> BLOOD_FLUID_BLOCK = ButchercraftBlocks.BLOCKS
			.register("blood_fluid_block", () -> new LiquidBlock(ButchercraftFluids.BLOOD_FLUID,
					BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));

	public static final RegistryObject<AnimalHeadBlock> COW_HEAD = BLOCKS.register("cow_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.COW,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> COW_HEAD_WALL = BLOCKS.register("cow_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.COW,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F).dropsLike(COW_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> CHICKEN_HEAD = BLOCKS.register("chicken_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.CHICKEN,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> CHICKEN_HEAD_WALL = BLOCKS.register("chicken_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.CHICKEN,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F).dropsLike(CHICKEN_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> GOAT_HEAD = BLOCKS.register("goat_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.GOAT,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> GOAT_HEAD_WALL = BLOCKS.register("goat_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.GOAT,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F).dropsLike(GOAT_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> PIG_HEAD = BLOCKS.register("pig_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.PIG,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> PIG_HEAD_WALL = BLOCKS.register("pig_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.PIG,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F).dropsLike(PIG_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> SHEEP_HEAD = BLOCKS.register("sheep_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.SHEEP,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> SHEEP_HEAD_WALL = BLOCKS.register("sheep_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.SHEEP,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F).dropsLike(SHEEP_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> RABBIT_BROWN_HEAD = BLOCKS.register("rabbit_brown_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_BROWN,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> RABBIT_BROWN_HEAD_WALL = BLOCKS.register(
			"rabbit_brown_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_BROWN, BlockBehaviour.Properties
					.of(Material.DECORATION).strength(1.0F).dropsLike(RABBIT_BROWN_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> RABBIT_BLACK_HEAD = BLOCKS.register("rabbit_black_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_BLACK,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> RABBIT_BLACK_HEAD_WALL = BLOCKS.register(
			"rabbit_black_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_BLACK, BlockBehaviour.Properties
					.of(Material.DECORATION).strength(1.0F).dropsLike(RABBIT_BLACK_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> RABBIT_GOLD_HEAD = BLOCKS.register("rabbit_gold_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_GOLD,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> RABBIT_GOLD_HEAD_WALL = BLOCKS.register("rabbit_gold_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_GOLD, BlockBehaviour.Properties
					.of(Material.DECORATION).strength(1.0F).dropsLike(RABBIT_GOLD_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> RABBIT_SALT_HEAD = BLOCKS.register("rabbit_salt_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_SALT,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> RABBIT_SALT_HEAD_WALL = BLOCKS.register("rabbit_salt_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_SALT, BlockBehaviour.Properties
					.of(Material.DECORATION).strength(1.0F).dropsLike(RABBIT_SALT_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> RABBIT_SPLOTCHED_HEAD = BLOCKS.register("rabbit_splotched_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_SPLOTCHED,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> RABBIT_SPLOTCHED_HEAD_WALL = BLOCKS.register(
			"rabbit_splotched_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_SPLOTCHED, BlockBehaviour.Properties
					.of(Material.DECORATION).strength(1.0F).dropsLike(RABBIT_SPLOTCHED_HEAD.get())));

	public static final RegistryObject<AnimalHeadBlock> RABBIT_WHITE_HEAD = BLOCKS.register("rabbit_white_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_WHITE,
					BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
	public static final RegistryObject<WallSkullBlock> RABBIT_WHITE_HEAD_WALL = BLOCKS.register(
			"rabbit_white_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_WHITE, BlockBehaviour.Properties
					.of(Material.DECORATION).strength(1.0F).dropsLike(RABBIT_WHITE_HEAD.get())));

	public static final RegistryObject<Block> BARN_WOOD_BLOCK = BLOCKS.register("barn_wood_block", () -> new Block(
			BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(3.0F)));
	public static final RegistryObject<StairBlock> BARN_WOOD_STAIRS = BLOCKS.register("barn_wood_stairs",
			() -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties
					.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(3.0F)));
	public static final RegistryObject<SlabBlock> BARN_WOOD_SLAB = BLOCKS.register("barn_wood_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED)
					.sound(SoundType.WOOD).strength(3.0F)));
	public static final RegistryObject<DoorBlock> BARN_WOOD_DOOR = BLOCKS.register("barn_wood_door",
			() -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED)
					.sound(SoundType.WOOD).strength(3.0F).noOcclusion()));
	public static final RegistryObject<TrapDoorBlock> BARN_WOOD_TRAPDOOR = BLOCKS.register("barn_wood_trapdoor",
			() -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED)
					.sound(SoundType.WOOD).strength(3.0F).noOcclusion()));

	public static final RegistryObject<Block> TRIMMED_BARN_WOOD_BLOCK = BLOCKS.register("trimmed_barn_wood_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD)
					.strength(3.0F)));

	public static void register(IEventBus modBus) {

		BLOCKS.register(modBus);
	}
}
