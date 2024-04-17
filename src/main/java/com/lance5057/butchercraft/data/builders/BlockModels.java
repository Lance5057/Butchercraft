package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockModels extends BlockStateProvider {

	public BlockModels(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Butchercraft.MOD_ID, exFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerStatesAndModels() {
		// TODO Auto-generated method stub
		this.horizontalBlock(ButchercraftBlocks.MEAT_HOOK.get(), models().getExistingFile(modLoc("block/meat_hook")));

		this.simpleBlock(ButchercraftBlocks.BUTCHER_BLOCK.get(),
				models().getExistingFile(modLoc("block/butcher_block")));
		this.horizontalBlock(ButchercraftBlocks.GRINDER.get(), models().getExistingFile(modLoc("block/grinder")));

		this.simpleBlock(ButchercraftBlocks.BEEF_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_BEEF_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.PORK_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_PORK_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.MUTTON_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_MUTTON_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.GOAT_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_GOAT_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.CHICKEN_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_CHICKEN_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.RABBIT_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_RABBIT_BLOCK.get());

		this.axisBlock(ButchercraftBlocks.SAUSAGE_BLOCK.get());
		this.axisBlock(ButchercraftBlocks.BLOOD_SAUSAGE_BLOCK.get());
		this.axisBlock(ButchercraftBlocks.COOKED_BLOOD_SAUSAGE_BLOCK.get());
		this.axisBlock(ButchercraftBlocks.COOKED_SAUSAGE_BLOCK.get());

		horizontalBlock(ButchercraftBlocks.COW_HIDE_CARPET.get(),
				models().getExistingFile(modLoc("block/cow_hide_carpet")));
		horizontalBlock(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(),
				models().withExistingParent("sheep_hide", modLoc("block/cow_hide_carpet"))
						.texture("0", "butchercraft:block/sheep_hide")
						.texture("particle", "butchercraft:block/sheep_hide"));
		horizontalBlock(ButchercraftBlocks.GOAT_HIDE_CARPET.get(),
				models().withExistingParent("goat_hide", modLoc("block/cow_hide_carpet"))
						.texture("0", "butchercraft:block/goat_hide")
						.texture("particle", "butchercraft:block/goat_hide"));
		horizontalBlock(ButchercraftBlocks.PIG_HIDE_CARPET.get(),
				models().withExistingParent("pig_hide", modLoc("block/cow_hide_carpet"))
						.texture("0", "butchercraft:block/pig_hide")
						.texture("particle", "butchercraft:block/pig_hide"));

//		getVariantBuilder(ButchercraftBlocks.COW_HIDE_CARPET.get()).partialState().addModels(ConfiguredModel.)
//        .forAllStates(state -> ConfiguredModel.builder()
//                .modelFile(models().getExistingFile(modLoc("block/cow_hide_carpet")))
//                .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
//                .build());

		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_COW_BLOCK.get(),
				models().getExistingFile(modLoc("block/cow")));
		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_PIG_BLOCK.get(),
				models().getExistingFile(modLoc("block/pig")));
		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_SHEEP_BLOCK.get(),
				models().getExistingFile(modLoc("block/sheep")));
		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_GOAT_BLOCK.get(),
				models().getExistingFile(modLoc("block/goat")));
		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_CHICKEN_BLOCK.get(),
				models().getExistingFile(modLoc("block/chicken")));

		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_BLACK_RABBIT_BLOCK.get(),
				models().withExistingParent("taxidermy_black_rabbit", modLoc("block/rabbit")).texture("0",
						mcLoc("entity/rabbit/black")));
		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_BROWN_RABBIT_BLOCK.get(),
				models().withExistingParent("taxidermy_brown_rabbit", modLoc("block/rabbit")).texture("0",
						mcLoc("entity/rabbit/brown")));
		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_GOLD_RABBIT_BLOCK.get(),
				models().withExistingParent("taxidermy_gold_rabbit", modLoc("block/rabbit")).texture("0",
						mcLoc("entity/rabbit/gold")));
		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_SALT_RABBIT_BLOCK.get(),
				models().withExistingParent("taxidermy_salt_rabbit", modLoc("block/rabbit")).texture("0",
						mcLoc("entity/rabbit/salt")));
		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_SPLOTCHED_RABBIT_BLOCK.get(),
				models().withExistingParent("taxidermy_splotched_rabbit", modLoc("block/rabbit")).texture("0",
						mcLoc("entity/rabbit/white_splotched")));
		this.horizontalBlock(ButchercraftBlocks.TAXIDERMY_WHITE_RABBIT_BLOCK.get(),
				models().withExistingParent("taxidermy_white_rabbit", modLoc("block/rabbit")).texture("0",
						mcLoc("entity/rabbit/white")));

		this.simpleBlock(ButchercraftBlocks.BARN_WOOD_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.TRIMMED_BARN_WOOD_BLOCK.get());
		this.slabBlock(ButchercraftBlocks.BARN_WOOD_SLAB.get(), modLoc("block/barn_wood_block"),
				modLoc("block/barn_wood_block"));
		this.stairsBlock(ButchercraftBlocks.BARN_WOOD_STAIRS.get(), modLoc("block/barn_wood_block"));
		this.doorBlock(ButchercraftBlocks.BARN_WOOD_DOOR.get(), modLoc("block/barn_door_bottom"),
				modLoc("block/barn_door_top"));
		this.trapdoorBlock(ButchercraftBlocks.BARN_WOOD_TRAPDOOR.get(), modLoc("block/barn_trapdoor"), false);
		this.fenceBlock(ButchercraftBlocks.BARN_WOOD_FENCE.get(), modLoc("block/barn_wood_block"));
		this.fenceGateBlock(ButchercraftBlocks.BARN_WOOD_FENCE_GATE.get(), modLoc("block/barn_wood_block"));

//		trimmedBlock(ButchercraftBlocks.TRIMMED_BARN_WOOD_BLOCK.get(), modLoc("block/trimmed_barn_wood_block"));
//		this.directionalBlock(ButchercraftBlocks.BEND_TRIMMED_BARN_WOOD_BLOCK.get(),
//				models().withExistingParent("bend_trimmed_barn_wood_block", mcLoc("block/cube_directional"))
//						.texture("up", modLoc("block/bend_trimmed_barn_wood_block")));
//		this.directionalBlock(ButchercraftBlocks.CORNER_TRIMMED_BARN_WOOD_BLOCK.get(),
//				models().withExistingParent("corner_trimmed_barn_wood_block", mcLoc("block/cube_directional"))
//						.texture("up", modLoc("block/corner_trimmed_barn_wood_block")));
//		this.simpleBlock(ButchercraftBlocks.FULL_TRIMMED_BARN_WOOD_BLOCK.get());
//		this.directionalBlock(ButchercraftBlocks.PIPE_TRIMMED_BARN_WOOD_BLOCK.get(),
//				models().withExistingParent("pipe_trimmed_barn_wood_block", mcLoc("block/cube_directional"))
//						.texture("up", modLoc("block/pipe_trimmed_barn_wood_block")));
//		;
//		this.directionalBlock(ButchercraftBlocks.T_TRIMMED_BARN_WOOD_BLOCK.get(),
//				models().withExistingParent("t_trimmed_barn_wood_block", mcLoc("block/cube_directional")).texture("up",
//						modLoc("block/t_trimmed_barn_wood_block")));
//
//		this.simpleBlock(ButchercraftBlocks.INNER_TRIMMED_BARN_WOOD_BLOCK.get());
	}

//	private void trimmedBlock(Block block, ResourceLocation rc) {
//		getVariantBuilder(block).forAllStates(state -> {
//			Direction dir = state.getValue(BlockStateProperties.FACING);
//			return ConfiguredModel.builder()
//					.modelFile(models()
//							.getExistingFile(modLoc("block/barn_wood/trimmed_barn_wood_block_" + dir.toString())))
//					.build();
//
//		});
//
//	}
}
