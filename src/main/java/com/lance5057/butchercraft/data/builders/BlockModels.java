package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.PieBlock;

public class BlockModels extends BlockStateProvider {

	public BlockModels(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Butchercraft.MOD_ID, exFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerStatesAndModels() {
		// TODO Auto-generated method stub
		this.horizontalBlock(ButchercraftBlocks.MEAT_HOOK.get(), models().getExistingFile(modLoc("block/meat_hook")));
		this.simpleBlock(ButchercraftBlocks.DRYING_RACK.get(),
				models().getExistingFile(modLoc("block/drying_rack")));
		
		this.simpleBlock(ButchercraftBlocks.BEEF_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_BEEF_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.PORK_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_PORK_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.LAMB_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.COOKED_LAMB_BLOCK.get());

		this.horizontalBlock(ButchercraftBlocks.COW_HIDE_CARPET.get(),
				models().getExistingFile(modLoc("block/cow_hide_carpet")));
		this.horizontalBlock(ButchercraftBlocks.PIG_HIDE_CARPET.get(),
				models().getExistingFile(modLoc("block/pig_hide_carpet")));
		this.horizontalBlock(ButchercraftBlocks.SHEEP_HIDE_CARPET.get(),
				models().getExistingFile(modLoc("block/sheep_hide_carpet")));

		this.simpleBlock(ButchercraftBlocks.CHEESE_BLOCK.get());
		this.simpleBlock(ButchercraftBlocks.BUTTER_BLOCK.get());
		
//		this.horizontalBlock(ButchercraftBlocks.BBQ_JAR_BLOCK.get(),
//				models().getExistingFile(modLoc("block/bbq_jar_block")));
//		this.horizontalBlock(ButchercraftBlocks.STOCK_JAR_BLOCK.get(),
//				models().getExistingFile(modLoc("block/stock_jar_block")));
//		this.horizontalBlock(ButchercraftBlocks.KETCHUP_JAR_BLOCK.get(),
//				models().getExistingFile(modLoc("block/ketchup_jar_block")));
//		this.horizontalBlock(ButchercraftBlocks.GRAVY_BOAT.get(), models().getExistingFile(modLoc("block/gravy_boat")));

		this.feastBlock(ButchercraftBlocks.HASH_FEAST.get());
		this.feastBlock(ButchercraftBlocks.POT_ROAST_FEAST.get());
		this.feastBlock(ButchercraftBlocks.SALISBURY_STEAK_FEAST.get());
		this.feastBlock(ButchercraftBlocks.BBQ_RIBS_FEAST.get());
		this.feastBlock(ButchercraftBlocks.PULLED_PORK_FEAST.get());
		this.feastBlock(ButchercraftBlocks.MASHED_POTATO_GRAVY.get());
		this.feastBlock(ButchercraftBlocks.RACK_LAMB.get());
		this.feastBlock(ButchercraftBlocks.STIRFRY.get());
		this.feastBlock(ButchercraftBlocks.BEEF_WELLINGTON.get());
		this.feastBlock(ButchercraftBlocks.HAGGIS.get());

		this.jellyBlock(ButchercraftBlocks.JELLY_WHITE.get(), "white");
		this.jellyBlock(ButchercraftBlocks.JELLY_ORANGE.get(), "orange");
		this.jellyBlock(ButchercraftBlocks.JELLY_MAGENTA.get(), "magenta");
		this.jellyBlock(ButchercraftBlocks.JELLY_LIGHT_BLUE.get(), "light_blue");
		this.jellyBlock(ButchercraftBlocks.JELLY_YELLOW.get(), "yellow");
		this.jellyBlock(ButchercraftBlocks.JELLY_LIME.get(), "lime");
		this.jellyBlock(ButchercraftBlocks.JELLY_PINK.get(), "pink");
		this.jellyBlock(ButchercraftBlocks.JELLY_GREY.get(), "grey");
		this.jellyBlock(ButchercraftBlocks.JELLY_LIGHT_GREY.get(), "light_grey");
		this.jellyBlock(ButchercraftBlocks.JELLY_CYAN.get(), "cyan");
		this.jellyBlock(ButchercraftBlocks.JELLY_PURPLE.get(), "purple");
		this.jellyBlock(ButchercraftBlocks.JELLY_BLUE.get(), "blue");
		this.jellyBlock(ButchercraftBlocks.JELLY_BROWN.get(), "brown");
		this.jellyBlock(ButchercraftBlocks.JELLY_GREEN.get(), "green");
		this.jellyBlock(ButchercraftBlocks.JELLY_RED.get(), "red");
		this.jellyBlock(ButchercraftBlocks.JELLY_BLACK.get(), "black");

		this.pieBlock(ButchercraftBlocks.MEAT_PIE_BLOCK.get());
	}

	public void pieBlock(Block block) {
		getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							new ResourceLocation(Butchercraft.MOD_ID,
									"block/" + block.getRegistryName().getPath() + suffix),
							models().existingFileHelper))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void feastBlock(FeastBlock block) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							new ResourceLocation(Butchercraft.MOD_ID,
									"block/" + block.getRegistryName().getPath() + suffix),
							models().existingFileHelper))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void jellyBlock(FeastBlock block, String color) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			ModelFile jellyModel = models()
					.withExistingParent("jelly_" + color + "_block" + suffix, modLoc("block/jelly_block" + suffix))
					.texture("1", new ResourceLocation(Butchercraft.MOD_ID, "block/jelly_" + color));

			return ConfiguredModel.builder().modelFile(jellyModel)
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

}
