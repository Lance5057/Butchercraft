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
		this.simpleBlock(ButchercraftBlocks.LAMB_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_LAMB_BLOCK.get());

		horizontalBlock(ButchercraftBlocks.COW_HIDE_CARPET.get(), models().getExistingFile(modLoc("block/cow_hide_carpet")));
		horizontalBlock(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(), models().withExistingParent("sheep_hide", modLoc("block/cow_hide_carpet"))
				.texture("0", "butchercraft:block/sheep_hide")
				.texture("particle", "butchercraft:block/sheep_hide")); 
		horizontalBlock(ButchercraftBlocks.GOAT_HIDE_CARPET.get(), models().withExistingParent("goat_hide", modLoc("block/cow_hide_carpet"))
				.texture("0", "butchercraft:block/goat_hide")
				.texture("particle", "butchercraft:block/goat_hide")); 
		horizontalBlock(ButchercraftBlocks.PIG_HIDE_CARPET.get(), models().withExistingParent("pig_hide", modLoc("block/cow_hide_carpet"))
				.texture("0", "butchercraft:block/pig_hide")
				.texture("particle", "butchercraft:block/pig_hide")); 

//		getVariantBuilder(ButchercraftBlocks.COW_HIDE_CARPET.get()).partialState().addModels(ConfiguredModel.)
//        .forAllStates(state -> ConfiguredModel.builder()
//                .modelFile(models().getExistingFile(modLoc("block/cow_hide_carpet")))
//                .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
//                .build());

		this.horizontalBlock(ButchercraftBlocks.COW_BLOCK.get(), models().getExistingFile(modLoc("block/cow")));
		this.horizontalBlock(ButchercraftBlocks.PIG_BLOCK.get(), models().getExistingFile(modLoc("block/pig")));
		this.horizontalBlock(ButchercraftBlocks.SHEEP_BLOCK.get(), models().getExistingFile(modLoc("block/sheep")));
		this.horizontalBlock(ButchercraftBlocks.GOAT_BLOCK.get(), models().getExistingFile(modLoc("block/goat")));
		this.horizontalBlock(ButchercraftBlocks.CHICKEN_BLOCK.get(), models().getExistingFile(modLoc("block/chicken")));
		this.horizontalBlock(ButchercraftBlocks.RABBIT_BLOCK.get(), models().getExistingFile(modLoc("block/rabbit")));

	}

//	private void hideModel(String animal, HideBlock block) {
//		ModelFile normal = models().withExistingParent(animal + "_hide", modLoc("block/cow_hide_carpet"))
//				.texture("0", "butchercraft:block/" + animal + "_hide")
//				.texture("particle", "butchercraft:block/" + animal + "_hide");
//		ModelFile up = models().withExistingParent(animal + "_hide_up", modLoc("block/cow_hide_carpet_up"))
//				.texture("0", "butchercraft:block/" + animal + "_hide")
//				.texture("particle", "butchercraft:block/" + animal + "_hide");
//		ModelFile up_moar = models().withExistingParent(animal + "_hide_up", modLoc("block/cow_hide_carpet_up"))
//				.texture("0", "butchercraft:block/" + animal + "_hide")
//				.texture("particle", "butchercraft:block/" + animal + "_hide");
//		;
//
//		VariantBlockStateBuilder builder = getVariantBuilder(block);
//
//		for (Direction dir : BlockStateProperties.HORIZONTAL_FACING.getPossibleValues()) {
//			builder.partialState().with(BlockStateProperties.HORIZONTAL_FACING, dir).with(HideBlock.LIFT, 0)
//					.modelForState().modelFile(normal).rotationY((int) dir.toYRot() + 180).addModel()
//
//					.partialState().with(BlockStateProperties.HORIZONTAL_FACING, dir).with(HideBlock.LIFT, 1)
//					.modelForState().modelFile(up).rotationY((int) dir.toYRot() + 180).addModel()
//
//					.partialState().with(BlockStateProperties.HORIZONTAL_FACING, dir).with(HideBlock.LIFT, 2)
//					.modelForState().modelFile(up_moar).rotationY((int) dir.toYRot() + 180).addModel();
//		}
//	}
}
