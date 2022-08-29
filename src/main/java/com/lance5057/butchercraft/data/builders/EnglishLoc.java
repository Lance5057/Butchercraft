package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.lance5057.butchercraft.items.ButchercraftItems.*;

public class EnglishLoc extends LanguageProvider {

    public EnglishLoc(DataGenerator gen) {
        super(gen, Butchercraft.MOD_ID, "en_us");

    }

    @Override
    protected void addTranslations() {
        Butchercraft.logger.info("\tEN_US Localization");

        this.add("itemGroup.butchercraft.items", "Butchercraft Items");

        this.add(BONE_SAW.get(), "Bone Saw");
        this.add(COOKED_BEEF_SCRAPS.get(), "Cooked Beef Straps");
        this.add(BEEF_SCRAPS.get(), "Raw Beef Scraps");
        this.add(COOKED_GROUND_BEEF.get(), "Cooked Ground Beef");
        this.add(GROUND_BEEF.get(), "Raw Ground Beef");
        this.add(COOKED_CUBED_BEEF.get(), "Cooked Cubed Beef");
        this.add(CUBED_BEEF.get(), "Raw Cubed Beef");
        this.add(COOKED_BEEF_RIBS.get(), "Cooked Beef Ribs");
        this.add(BEEF_RIBS.get(), "Raw Beef Ribs");
        this.add(COOKED_BEEF_ROAST.get(), "Cooked Beef Roast");
        this.add(BEEF_ROAST.get(), "Raw Beef Roast");
        this.add(SAUSAGE.get(), "Raw Sausage");
        this.add(COOKED_SAUSAGE.get(), "Cooked Sausage");
        this.add(BEEF_STEW_MEAT.get(), "Raw Beef Stew Meat");
        this.add(COOKED_BEEF_STEWMEAT.get(), "Cooked Beef Stew Meat");
        this.add(COW_COOKED_TRIPE.get(), "Cooked Cow Tripe");
        this.add(COW_TRIPE.get(), "Raw Cow Tripe");
        this.add(COW_COOKED_STOMACHE.get(), "Cooked Cow Stomach");
        this.add(COW_STOMACHE.get(), "Raw Cow Stomach");
        this.add(COW_COOKED_LUNG.get(), "Cooked Cow Lung");
        this.add(COW_LUNG.get(), "Raw Cow Lung");
        this.add(COW_COOKED_LIVER.get(), "Cooked Cow Liver");
        this.add(COW_LIVER.get(), "Raw Cow Liver");
        this.add(COW_COOKED_KIDNEY.get(), "Cooked Cow Kidney");
        this.add(COW_KIDNEY.get(), "Raw Cow Kidney");
        this.add(COW_COOKED_HEART.get(), "Cooked Cow Heart");
        this.add(COW_HEART.get(), "Raw Cow Heart");
        this.add(COW_COOKED_BRAIN.get(), "Cooked Cow Brain");
        this.add(COW_BRAIN.get(), "Raw Cow Brain");
        this.add(COW_CARCASS.get(), "Cow Carcass");
        this.add(BUTCHER_KNIFE.get(), "Butcher Knife");
        this.add(SKINNING_KNIFE.get(), "Skinning Knife");
        this.add(SPATULA.get(), "Spatula");
        this.add(GRINDER_TIP.get(), "Grinder Tip");
        this.add(EXTRUDER_TIP.get(), "Extruder Tip");
        this.add(LEATHER_SCRAP.get(), "Leather Scrap");
        this.add(LEATHER_CORD.get(), "Leather Cord");
        this.add(FAT.get(), "Fat");
        this.add(SINEW.get(), "Sinew");
        this.add(HOOK_BLOCK_ITEM.get(), "Meat Hook");
        this.add(COW_SKULL.get(), "Cow Skull");
    }

}