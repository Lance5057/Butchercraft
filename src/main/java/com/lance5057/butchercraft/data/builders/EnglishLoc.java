package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.items.ButchercraftItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class EnglishLoc extends LanguageProvider {

    public EnglishLoc(DataGenerator gen) {
        super(gen, Butchercraft.MOD_ID, "en_us");

    }

    @Override
    protected void addTranslations() {
        Butchercraft.logger.info("\tEN_US Localization");

        this.add("itemGroup.butchercraft.items", "Butchercraft Items");

        this.add(ButchercraftItems.BONE_SAW.get(), "Bone Saw");
    }

}