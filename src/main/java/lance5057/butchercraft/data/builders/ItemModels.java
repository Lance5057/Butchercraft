package lance5057.butchercraft.data.builders;

import lance5057.butchercraft.Butchercraft;
import lance5057.butchercraft.ButchercraftItems;
import lance5057.butchercraft.animals.cow.FoodsCow;
import lance5057.butchercraft.animals.cow.ItemsCow;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

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

	forItem(ButchercraftItems.boneSaw, "bonesaw");
	forItem(ButchercraftItems.butcherKnife, "butcherknife");
	forItem(ButchercraftItems.fat, "fat");
	forItem(ButchercraftItems.grindTip, "grindtip");
	forItem(ButchercraftItems.leatherCord, "leathercord");
	forItem(ButchercraftItems.leatherScrap, "leatherscrap");
	forItem(ButchercraftItems.sausageTip, "sausagetip");
	forItem(ButchercraftItems.sinew, "sinew");
	forItem(ButchercraftItems.skinningKnife, "skinningknife");
	forItem(ButchercraftItems.spatula, "spatula");

	forItem(ItemsCow.COW_CARCASS, "cow_carcass");
	
	forItem(ItemsCow.COW_BRAIN, "brain");
	forItem(ItemsCow.COW_COOKED_BRAIN, "cooked_brain");
	forItem(ItemsCow.COW_HEART, "heart");
	forItem(ItemsCow.COW_COOKED_HEART, "cooked_heart");
	forItem(ItemsCow.COW_KIDNEY, "kidney");
	forItem(ItemsCow.COW_COOKED_KIDNEY, "cooked_kidney");
	forItem(ItemsCow.COW_LIVER, "liver");
	forItem(ItemsCow.COW_COOKED_LIVER, "cooked_liver");
	forItem(ItemsCow.COW_LUNG, "lung");
	forItem(ItemsCow.COW_COOKED_LUNG, "cooked_lung");
	forItem(ItemsCow.COW_STOMACHE, "stomach");
	forItem(ItemsCow.COW_COOKED_STOMACHE, "cooked_stomach");
	forItem(ItemsCow.COW_TRIPE, "tripe");
	forItem(ItemsCow.COW_COOKED_TRIPE, "cooked_tripe");

	forItem(ItemsCow.BEEF_STEWMEAT, "stew_beef");
	forItem(ItemsCow.COOKED_BEEF_STEWMEAT, "cooked_stew_beef");
	forItem(ItemsCow.BEEF_ROAST, "roast");
	forItem(ItemsCow.COOKED_BEEF_ROAST, "cooked_roast");
	forItem(ItemsCow.BEEF_RIBS, "ribs");
	forItem(ItemsCow.COOKED_BEEF_RIBS, "cooked_ribs");
	forItem(ItemsCow.CUBED_BEEF, "cubed_beef");
	forItem(ItemsCow.COOKED_CUBED_BEEF, "cooked_cubed_beef");
	forItem(ItemsCow.GROUND_BEEF, "ground_beef");
	forItem(ItemsCow.COOKED_GROUND_BEEF, "cooked_ground_beef");
	forItem(ItemsCow.BEEF_SCRAPS, "beef_scraps");
	forItem(ItemsCow.COOKED_BEEF_SCRAPS, "cooked_beef_scraps");
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