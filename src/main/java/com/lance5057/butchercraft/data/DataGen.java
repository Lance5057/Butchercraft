package com.lance5057.butchercraft.data;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.data.builders.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		Butchercraft.logger.info("Data Generator Started!");

		DataGenerator generator = event.getGenerator();

		final Advancements advancements = new Advancements(generator);
        generator.addProvider(advancements);
		generator.addProvider(new ItemModels(generator, event.getExistingFileHelper()));
		generator.addProvider(new BlockModels(generator, event.getExistingFileHelper()));
		generator.addProvider(new EnglishLoc(generator));
		
		BlockTagGenerator btg = new BlockTagGenerator(generator, Butchercraft.MOD_ID, event.getExistingFileHelper());
		generator.addProvider(btg);
		generator.addProvider(new ItemTagGenerator(generator, btg, Butchercraft.MOD_ID, event.getExistingFileHelper()));
		
		generator.addProvider(new ButchercraftRecipeProvider(generator));
		generator.addProvider(new ButchercraftLootTableProvider(generator));
		generator.addProvider(new ButchercraftEntityTypeTagsProvider(generator, event.getExistingFileHelper()));
	}
}
