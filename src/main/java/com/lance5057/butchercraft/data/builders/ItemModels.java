package com.lance5057.butchercraft.data.builders;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.items.ButchercraftItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ItemModels extends ModelProvider<ItemModelBuilder> {
    private final ExistingFileHelper fh;

    public ItemModels(DataGenerator generator, ExistingFileHelper fh) {
        super(generator, Butchercraft.MOD_ID, ITEM_FOLDER, ItemModelBuilder::new, fh);
        this.fh = fh;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void registerModels() {
        Butchercraft.logger.info("/tItem Models - ");

        forItem(ButchercraftItems.BONE_SAW, "bonesaw");
        forItem(ButchercraftItems.BUTCHER_KNIFE, "butcherknife");
        forItem(ButchercraftItems.FAT, "fat");
        forItem(ButchercraftItems.GRINDER_TIP, "grindtip");
        forItem(ButchercraftItems.LEATHER_CORD, "leathercord");
        forItem(ButchercraftItems.LEATHER_SCRAP, "leatherscrap");
        forItem(ButchercraftItems.EXTRUDER_TIP, "sausagetip");
        forItem(ButchercraftItems.SINEW, "sinew");
        forItem(ButchercraftItems.SKINNING_KNIFE, "skinningknife");
        forItem(ButchercraftItems.SPATULA, "spatula");

        forItem(ButchercraftItems.COW_CARCASS, "cow_carcass");

        forItem(ButchercraftItems.COW_BRAIN, "brain");
        forItem(ButchercraftItems.COW_COOKED_BRAIN, "cooked_brain");
        forItem(ButchercraftItems.COW_HEART, "heart");
        forItem(ButchercraftItems.COW_COOKED_HEART, "cooked_heart");
        forItem(ButchercraftItems.COW_KIDNEY, "kidney");
        forItem(ButchercraftItems.COW_COOKED_KIDNEY, "cooked_kidney");
        forItem(ButchercraftItems.COW_LIVER, "liver");
        forItem(ButchercraftItems.COW_COOKED_LIVER, "cooked_liver");
        forItem(ButchercraftItems.COW_LUNG, "lung");
        forItem(ButchercraftItems.COW_COOKED_LUNG, "cooked_lung");
        forItem(ButchercraftItems.COW_STOMACHE, "stomach");
        forItem(ButchercraftItems.COW_COOKED_STOMACHE, "cooked_stomach");
        forItem(ButchercraftItems.COW_TRIPE, "tripe");
        forItem(ButchercraftItems.COW_COOKED_TRIPE, "cooked_tripe");

        forItem(ButchercraftItems.BEEF_STEWMEAT, "stew_beef");
        forItem(ButchercraftItems.COOKED_BEEF_STEWMEAT, "cooked_stew_beef");
        forItem(ButchercraftItems.BEEF_ROAST, "roast");
        forItem(ButchercraftItems.COOKED_BEEF_ROAST, "cooked_roast");
        forItem(ButchercraftItems.BEEF_RIBS, "ribs");
        forItem(ButchercraftItems.COOKED_BEEF_RIBS, "cooked_ribs");
        forItem(ButchercraftItems.CUBED_BEEF, "cubed_beef");
        forItem(ButchercraftItems.COOKED_CUBED_BEEF, "cooked_cubed_beef");
        forItem(ButchercraftItems.GROUND_BEEF, "ground_beef");
        forItem(ButchercraftItems.COOKED_GROUND_BEEF, "cooked_ground_beef");
        forItem(ButchercraftItems.BEEF_SCRAPS, "beef_scraps");
        forItem(ButchercraftItems.COOKED_BEEF_SCRAPS, "cooked_beef_scraps");
    }

    public void forItem(RegistryObject<? extends Item> item, String name) {
        this.singleTexture(item.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/" + name));
    }

    public void forMaterialItem(RegistryObject<? extends Item> item, String name) {
        this.singleTexture(item.getId().getPath(), mcLoc("item/handheld"), "layer0",
                modLoc("item/material/" + name + "/" + item.getId().getPath()));
    }

    public void forBlockItem(RegistryObject<? extends BlockItem> item, String name) {
        getBuilder(item.getId().getPath())
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Butchercraft.MOD_ID,
                        "block/" + item.get().getBlock().getRegistryName().getPath())));
    }

    public void forBlockItem(RegistryObject<? extends BlockItem> item, ResourceLocation modelLocation) {
        getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(modelLocation));
    }

    public void forBlockItem(RegistryObject<? extends BlockItem> item, ResourceLocation modelLocation, String key,
                             ResourceLocation texture) {
        getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(modelLocation)).texture(key,
                texture);
    }

}