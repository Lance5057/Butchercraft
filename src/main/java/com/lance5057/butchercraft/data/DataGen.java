package com.lance5057.butchercraft.data;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.data.builders.Advancements;
import com.lance5057.butchercraft.data.builders.BlockModels;
import com.lance5057.butchercraft.data.builders.BlockTagGenerator;
import com.lance5057.butchercraft.data.builders.ButchercraftEntityTypeTagsProvider;
import com.lance5057.butchercraft.data.builders.ButchercraftLootTableProvider;
import com.lance5057.butchercraft.data.builders.EnglishLoc;
import com.lance5057.butchercraft.data.builders.ItemModels;
import com.lance5057.butchercraft.data.builders.ItemTagGenerator;
import com.lance5057.butchercraft.data.builders.PoiTagGenerator;
import com.lance5057.butchercraft.data.builders.recipes.ButchercraftRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		Butchercraft.logger.info("Data Generator Started!");

		DataGenerator generator = event.getGenerator();

		final Advancements advancements = new Advancements(generator, event.getExistingFileHelper());
		generator.addProvider(true, advancements);
		generator.addProvider(true, new ItemModels(generator, event.getExistingFileHelper()));
		generator.addProvider(true, new BlockModels(generator, event.getExistingFileHelper()));
		generator.addProvider(true, new EnglishLoc(generator));

		BlockTagGenerator btg = new BlockTagGenerator(generator, Butchercraft.MOD_ID, event.getExistingFileHelper());
		generator.addProvider(true, btg);
		generator.addProvider(true, new ItemTagGenerator(generator, btg, Butchercraft.MOD_ID, event.getExistingFileHelper()));

		generator.addProvider(true, new ButchercraftRecipeProvider(generator));
		generator.addProvider(true, new ButchercraftLootTableProvider(generator));
		generator.addProvider(true, new ButchercraftEntityTypeTagsProvider(generator, event.getExistingFileHelper()));
		generator.addProvider(true, new PoiTagGenerator(generator, event.getExistingFileHelper()));
	}
}
