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
        
        this.add(COOKED_PORK_SCRAPS.get(), "Cooked Pork Straps");
        this.add(PORK_SCRAPS.get(), "Raw Pork Scraps");
        this.add(COOKED_GROUND_PORK.get(), "Cooked Ground Pork");
        this.add(GROUND_PORK.get(), "Raw Ground Pork");
        this.add(COOKED_CUBED_PORK.get(), "Cooked Cubed Pork");
        this.add(CUBED_PORK.get(), "Raw Cubed Pork");
        this.add(COOKED_PORK_RIBS.get(), "Cooked Pork Ribs");
        this.add(PORK_RIBS.get(), "Raw Pork Ribs");
        this.add(COOKED_PORK_ROAST.get(), "Cooked Pork Roast");
        this.add(PORK_ROAST.get(), "Raw Pork Roast");
        this.add(PORK_STEW_MEAT.get(), "Raw Pork Stew Meat");
        this.add(COOKED_PORK_STEWMEAT.get(), "Cooked Pork Stew Meat");
        
        this.add(COOKED_LAMB_SCRAPS.get(), "Cooked Lamb Straps");
        this.add(LAMB_SCRAPS.get(), "Raw Lamb Scraps");
        this.add(COOKED_GROUND_LAMB.get(), "Cooked Ground Lamb");
        this.add(GROUND_LAMB.get(), "Raw Ground Lamb");
        this.add(COOKED_CUBED_LAMB.get(), "Cooked Cubed Lamb");
        this.add(CUBED_LAMB.get(), "Raw Cubed Lamb");
        this.add(COOKED_LAMB_RIBS.get(), "Cooked Lamb Ribs");
        this.add(LAMB_RIBS.get(), "Raw Lamb Ribs");
        this.add(COOKED_LAMB_ROAST.get(), "Cooked Lamb Roast");
        this.add(LAMB_ROAST.get(), "Raw Lamb Roast");
        this.add(LAMB_STEW_MEAT.get(), "Raw Lamb Stew Meat");
        this.add(COOKED_LAMB_STEWMEAT.get(), "Cooked Lamb Stew Meat");
        
        this.add(COOKED_TRIPE.get(), "Cooked Tripe");
        this.add(TRIPE.get(), "Raw Tripe");
        this.add(COOKED_STOMACHE.get(), "Cooked Stomach");
        this.add(STOMACHE.get(), "Raw Stomach");
        this.add(COOKED_LUNG.get(), "Cooked Lung");
        this.add(LUNG.get(), "Raw Lung");
        this.add(COOKED_LIVER.get(), "Cooked Liver");
        this.add(LIVER.get(), "Raw Liver");
        this.add(COOKED_KIDNEY.get(), "Cooked Kidney");
        this.add(KIDNEY.get(), "Raw Kidney");
        this.add(COOKED_HEART.get(), "Cooked Heart");
        this.add(HEART.get(), "Raw Heart");
        this.add(COOKED_BRAIN.get(), "Cooked Brain");
        this.add(BRAIN.get(), "Raw Brain");
        
        this.add(COW_CARCASS.get(), "Carcass");
        
        this.add(BUTCHER_KNIFE.get(), "Butcher Knife");
        this.add(SKINNING_KNIFE.get(), "Skinning Knife");
        this.add(BONE_SAW.get(), "Bone Saw");
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