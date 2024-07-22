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
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ButchercraftBlocks {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Butchercraft.MOD_ID);

	public static final DeferredBlock<MeatHookBlock> MEAT_HOOK = BLOCKS.register("meat_hook", MeatHookBlock::new);

	public static final DeferredBlock<ButcherBlockBlock> BUTCHER_BLOCK = BLOCKS.register("butcher_block",
			ButcherBlockBlock::new);

	public static final DeferredBlock<GrinderBlock> GRINDER = BLOCKS.register("grinder", GrinderBlock::new);

	public static final DeferredBlock<Block> BEEF_BLOCK = BLOCKS.register("beef_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final DeferredBlock<Block> COOKED_BEEF_BLOCK = BLOCKS.register("cooked_beef_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final DeferredBlock<Block> PORK_BLOCK = BLOCKS.register("pork_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final DeferredBlock<Block> COOKED_PORK_BLOCK = BLOCKS.register("cooked_pork_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final DeferredBlock<Block> MUTTON_BLOCK = BLOCKS.register("mutton_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final DeferredBlock<Block> COOKED_MUTTON_BLOCK = BLOCKS.register("cooked_mutton_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final DeferredBlock<Block> GOAT_BLOCK = BLOCKS.register("goat_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final DeferredBlock<Block> COOKED_GOAT_BLOCK = BLOCKS.register("cooked_goat_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final DeferredBlock<Block> RABBIT_BLOCK = BLOCKS.register("rabbit_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final DeferredBlock<Block> COOKED_RABBIT_BLOCK = BLOCKS.register("cooked_rabbit_block",
			() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_BROWN)
					.sound(SoundType.SLIME_BLOCK)));

	public static final DeferredBlock<Block> CHICKEN_BLOCK = BLOCKS.register("chicken_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_RED).sound(SoundType.SLIME_BLOCK)));
	public static final DeferredBlock<Block> COOKED_CHICKEN_BLOCK = BLOCKS.register("cooked_chicken_block",
			() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_BROWN)
					.sound(SoundType.SLIME_BLOCK)));

	public static final DeferredBlock<RotatedPillarBlock> SAUSAGE_BLOCK = BLOCKS.register("sausage_block",
			() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_RED)
					.sound(SoundType.SLIME_BLOCK)));
	public static final DeferredBlock<RotatedPillarBlock> COOKED_SAUSAGE_BLOCK = BLOCKS
			.register("cooked_sausage_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties
					.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final DeferredBlock<RotatedPillarBlock> BLOOD_SAUSAGE_BLOCK = BLOCKS.register("blood_sausage_block",
			() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_RED)
					.sound(SoundType.SLIME_BLOCK)));
	public static final DeferredBlock<RotatedPillarBlock> COOKED_BLOOD_SAUSAGE_BLOCK = BLOCKS
			.register("cooked_blood_sausage_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties
					.ofFullCopy(Blocks.SPONGE).mapColor(MapColor.COLOR_BROWN).sound(SoundType.SLIME_BLOCK)));

	public static final DeferredBlock<HideBlock> COW_HIDE_CARPET = BLOCKS.register("cow_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(MapColor.COLOR_BROWN)));
	public static final DeferredBlock<HideBlock> PIG_HIDE_CARPET = BLOCKS.register("pig_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(MapColor.COLOR_PINK)));
	public static final DeferredBlock<HideBlock> SHEEP_HIDE_CARPET = BLOCKS.register("sheep_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(MapColor.TERRACOTTA_WHITE)));
	public static final DeferredBlock<HideBlock> GOAT_HIDE_CARPET = BLOCKS.register("goat_hide_carpet",
			() -> new HideBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(MapColor.TERRACOTTA_WHITE)));

	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_COW_BLOCK = BLOCKS.register("taxidermy_cow_block",
			() -> new TaxidermyBlock());
	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_PIG_BLOCK = BLOCKS.register("taxidermy_pig_block",
			() -> new TaxidermyBlock());
	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_SHEEP_BLOCK = BLOCKS.register("taxidermy_sheep_block",
			() -> new TaxidermyBlock());
	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_GOAT_BLOCK = BLOCKS.register("taxidermy_goat_block",
			() -> new TaxidermyBlock());
	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_CHICKEN_BLOCK = BLOCKS
			.register("taxidermy_chicken_block", () -> new TaxidermyBlock());

	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_BLACK_RABBIT_BLOCK = BLOCKS
			.register("taxidermy_black_rabbit_block", () -> new TaxidermyBlock());
	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_BROWN_RABBIT_BLOCK = BLOCKS
			.register("taxidermy_brown_rabbit_block", () -> new TaxidermyBlock());
	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_WHITE_RABBIT_BLOCK = BLOCKS
			.register("taxidermy_white_rabbit_block", () -> new TaxidermyBlock());
	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_GOLD_RABBIT_BLOCK = BLOCKS
			.register("taxidermy_gold_rabbit_block", () -> new TaxidermyBlock());
	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_SPLOTCHED_RABBIT_BLOCK = BLOCKS
			.register("taxidermy_splotched_rabbit_block", () -> new TaxidermyBlock());
	public static final DeferredBlock<TaxidermyBlock> TAXIDERMY_SALT_RABBIT_BLOCK = BLOCKS
			.register("taxidermy_salt_rabbit_block", () -> new TaxidermyBlock());

	public static final DeferredBlock<LiquidBlock> BLOOD_FLUID_BLOCK = ButchercraftBlocks.BLOCKS
			.register("blood_fluid_block", () -> new LiquidBlock(ButchercraftFluids.BLOOD_FLUID.get(),
					BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
//	public static final DeferredBlock<LiquidBlock> TANNING_FLUID_BLOCK = ButchercraftBlocks.BLOCKS
//			.register("tanning_fluid_block", () -> new LiquidBlock(ButchercraftFluids.TANNING_FLUID,
//					BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));

	public static final DeferredBlock<AnimalHeadBlock> COW_HEAD = BLOCKS.register("cow_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.COW,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> COW_HEAD_WALL = BLOCKS.register("cow_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.COW,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(COW_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> COW_SKULL_HEAD = BLOCKS.register("cow_skull_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.COW_SKULL,
					BlockBehaviour.Properties.ofFullCopy(Blocks.SKELETON_SKULL).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> COW_SKULL_HEAD_WALL = BLOCKS.register("cow_skull_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.COW_SKULL,
					BlockBehaviour.Properties.ofFullCopy(Blocks.SKELETON_WALL_SKULL).strength(1.0F).lootFrom(COW_SKULL_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> CHICKEN_HEAD = BLOCKS.register("chicken_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.CHICKEN,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> CHICKEN_HEAD_WALL = BLOCKS.register("chicken_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.CHICKEN,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(CHICKEN_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> CHICKEN_SKULL_HEAD = BLOCKS.register("chicken_skull_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.CHICKEN_SKULL,
					BlockBehaviour.Properties.ofFullCopy(Blocks.SKELETON_SKULL).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> CHICKEN_SKULL_HEAD_WALL = BLOCKS.register(
			"chicken_skull_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.CHICKEN_SKULL, BlockBehaviour.Properties
					.ofFullCopy(Blocks.SKELETON_WALL_SKULL).strength(1.0F).lootFrom(CHICKEN_SKULL_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> GOAT_HEAD = BLOCKS.register("goat_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.GOAT,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> GOAT_HEAD_WALL = BLOCKS.register("goat_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.GOAT,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(GOAT_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> GOAT_SKULL_HEAD = BLOCKS.register("goat_skull_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.GOAT_SKULL,
					BlockBehaviour.Properties.ofFullCopy(Blocks.SKELETON_SKULL).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> GOAT_SKULL_HEAD_WALL = BLOCKS.register("goat_skull_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.GOAT_SKULL,
					BlockBehaviour.Properties.ofFullCopy(Blocks.SKELETON_WALL_SKULL).strength(1.0F).lootFrom(GOAT_SKULL_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> PIG_HEAD = BLOCKS.register("pig_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.PIG,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> PIG_HEAD_WALL = BLOCKS.register("pig_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.PIG,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(PIG_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> PIG_SKULL_HEAD = BLOCKS.register("pig_skull_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.PIG_SKULL,
					BlockBehaviour.Properties.ofFullCopy(Blocks.SKELETON_SKULL).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> PIG_SKULL_HEAD_WALL = BLOCKS.register("pig_skull_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.PIG_SKULL,
					BlockBehaviour.Properties.ofFullCopy(Blocks.SKELETON_WALL_SKULL).strength(1.0F).lootFrom(PIG_SKULL_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> SHEEP_HEAD = BLOCKS.register("sheep_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.SHEEP,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> SHEEP_HEAD_WALL = BLOCKS.register("sheep_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.SHEEP,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(SHEEP_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> SHEEP_SKULL_HEAD = BLOCKS.register("sheep_skull_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.SHEEP_SKULL,
					BlockBehaviour.Properties.ofFullCopy(Blocks.SKELETON_SKULL).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> SHEEP_SKULL_HEAD_WALL = BLOCKS.register("sheep_skull_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.SHEEP_SKULL, BlockBehaviour.Properties
					.ofFullCopy(Blocks.SKELETON_WALL_SKULL).strength(1.0F).lootFrom(SHEEP_SKULL_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> RABBIT_BROWN_HEAD = BLOCKS.register("rabbit_brown_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_BROWN,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> RABBIT_BROWN_HEAD_WALL = BLOCKS.register(
			"rabbit_brown_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_BROWN, BlockBehaviour.Properties
					.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(RABBIT_BROWN_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> RABBIT_BLACK_HEAD = BLOCKS.register("rabbit_black_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_BLACK,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> RABBIT_BLACK_HEAD_WALL = BLOCKS.register(
			"rabbit_black_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_BLACK, BlockBehaviour.Properties
					.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(RABBIT_BLACK_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> RABBIT_GOLD_HEAD = BLOCKS.register("rabbit_gold_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_GOLD,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> RABBIT_GOLD_HEAD_WALL = BLOCKS.register("rabbit_gold_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_GOLD, BlockBehaviour.Properties
					.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(RABBIT_GOLD_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> RABBIT_SALT_HEAD = BLOCKS.register("rabbit_salt_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_SALT,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> RABBIT_SALT_HEAD_WALL = BLOCKS.register("rabbit_salt_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_SALT, BlockBehaviour.Properties
					.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(RABBIT_SALT_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> RABBIT_SPLOTCHED_HEAD = BLOCKS.register("rabbit_splotched_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_SPLOTCHED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> RABBIT_SPLOTCHED_HEAD_WALL = BLOCKS.register(
			"rabbit_splotched_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_SPLOTCHED, BlockBehaviour.Properties
					.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(RABBIT_SPLOTCHED_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> RABBIT_WHITE_HEAD = BLOCKS.register("rabbit_white_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_WHITE,
					BlockBehaviour.Properties.ofFullCopy(Blocks.PLAYER_HEAD).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> RABBIT_WHITE_HEAD_WALL = BLOCKS.register(
			"rabbit_white_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_WHITE, BlockBehaviour.Properties
					.ofFullCopy(Blocks.PLAYER_WALL_HEAD).strength(1.0F).lootFrom(RABBIT_WHITE_HEAD)));

	public static final DeferredBlock<AnimalHeadBlock> RABBIT_SKULL_HEAD = BLOCKS.register("rabbit_skull_head",
			() -> new AnimalHeadBlock(AnimalHeadBlock.Types.RABBIT_SKULL,
					BlockBehaviour.Properties.ofFullCopy(Blocks.SKELETON_SKULL).strength(1.0F)));
	public static final DeferredBlock<WallSkullBlock> RABBIT_SKULL_HEAD_WALL = BLOCKS.register(
			"rabbit_skull_head_wall",
			() -> new AnimalWallHeadBlock(AnimalHeadBlock.Types.RABBIT_SKULL, BlockBehaviour.Properties
					.ofFullCopy(Blocks.SKELETON_WALL_SKULL).strength(1.0F).lootFrom(RABBIT_SKULL_HEAD)));

	private static final BlockSetType BARN_WOOD_SET = BlockSetType.register(new BlockSetType("barn_wood"));
	private static final WoodType BARN_WOOD_TYPE = WoodType.register(new WoodType("barn_wood", BARN_WOOD_SET));

	public static final DeferredBlock<Block> BARN_WOOD_BLOCK = BLOCKS.register("barn_wood_block", () -> new Block(
			BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(3.0F)));
	public static final DeferredBlock<StairBlock> BARN_WOOD_STAIRS = BLOCKS.register("barn_wood_stairs",
			() -> new StairBlock(BARN_WOOD_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties
					.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(3.0F)));
	public static final DeferredBlock<SlabBlock> BARN_WOOD_SLAB = BLOCKS.register("barn_wood_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_RED)
					.sound(SoundType.WOOD).strength(3.0F)));
	public static final DeferredBlock<FenceBlock> BARN_WOOD_FENCE = BLOCKS.register("barn_wood_fence",
			() -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_RED)
					.sound(SoundType.WOOD).strength(3.0F)));
	public static final DeferredBlock<FenceGateBlock> BARN_WOOD_FENCE_GATE = BLOCKS.register("barn_wood_fence_gate",
			() -> new FenceGateBlock(BARN_WOOD_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_RED)
					.sound(SoundType.WOOD).strength(3.0F)));
	public static final DeferredBlock<DoorBlock> BARN_WOOD_DOOR = BLOCKS.register("barn_wood_door",
			() -> new DoorBlock(BARN_WOOD_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_RED)
					.sound(SoundType.WOOD).strength(3.0F).noOcclusion()));
	public static final DeferredBlock<TrapDoorBlock> BARN_WOOD_TRAPDOOR = BLOCKS.register("barn_wood_trapdoor",
			() -> new TrapDoorBlock(BARN_WOOD_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_RED)
					.sound(SoundType.WOOD).strength(3.0F).noOcclusion()));

	public static final DeferredBlock<Block> TRIMMED_BARN_WOOD_BLOCK = BLOCKS.register("trimmed_barn_wood_block",
			() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD)
					.strength(3.0F)));

	public static void register(IEventBus modBus) {

		BLOCKS.register(modBus);
	}
}
