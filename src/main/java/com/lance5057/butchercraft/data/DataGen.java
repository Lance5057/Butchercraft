package com.lance5057.butchercraft.data;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.data.builders.EnglishLoc;
import com.lance5057.butchercraft.data.builders.ItemModels;
import com.lance5057.butchercraft.data.builders.ItemTagGenerator;
import com.lance5057.butchercraft.data.builders.Loot;
import com.lance5057.butchercraft.data.builders.Recipes;

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

        generator.addProvider(new ItemModels(generator, event.getExistingFileHelper()));
        generator.addProvider(new EnglishLoc(generator));
        generator.addProvider(new ItemTagGenerator(generator, Butchercraft.MOD_ID, event.getExistingFileHelper()));
        generator.addProvider(new Recipes(generator));
        
        generator.addProvider(new Loot(generator));
    }
}
