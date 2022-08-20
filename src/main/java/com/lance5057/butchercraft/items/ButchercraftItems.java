package com.lance5057.butchercraft.items;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftBlocks;
import com.lance5057.butchercraft.animals.cow.FoodsCow;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Butchercraft.MOD_ID);

    public static final CreativeModeTab GROUP_ITEMS = new CreativeModeTab("butchercraft.items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ButchercraftItems.BUTCHER_KNIFE.get());
        }
    };

    public static final RegistryObject<Item> COOKED_BEEF_SCRAPS = ITEMS.register("cooked_beef_scraps",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_BEEF_SCRAPS)));
    public static final RegistryObject<Item> BEEF_SCRAPS = ITEMS.register("beef_scraps",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.BEEF_SCRAPS)));
    public static final RegistryObject<Item> COOKED_GROUND_BEEF = ITEMS.register("cooked_ground_beef",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_GROUND_BEEF)));
    public static final RegistryObject<Item> GROUND_BEEF = ITEMS.register("ground_beef",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.GROUND_BEEF)));
    public static final RegistryObject<Item> COOKED_CUBED_BEEF = ITEMS.register("cooked_cubed_beef",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_CUBED_BEEF)));
    public static final RegistryObject<Item> CUBED_BEEF = ITEMS.register("cubed_beef",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.CUBED_BEEF)));
    public static final RegistryObject<Item> COOKED_BEEF_RIBS = ITEMS.register("cooked_beef_ribs",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_BEEF_RIBS)));
    public static final RegistryObject<Item> BEEF_RIBS = ITEMS.register("beef_ribs",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.BEEF_RIBS)));
    public static final RegistryObject<Item> COOKED_BEEF_ROAST = ITEMS.register("cooked_beef_roast",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_ROAST)));
    public static final RegistryObject<Item> BEEF_ROAST = ITEMS.register("beef_roast",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.ROAST)));
    public static final RegistryObject<Item> COOKED_BEEF_STEWMEAT = ITEMS
            .register("cooked_beef_stewmeat", () -> new Item(
                    new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_BEEF_STEWMEAT)));
    public static final RegistryObject<Item> BEEF_STEWMEAT = ITEMS.register("beef_stewmeat",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.BEEF_STEWMEAT)));
    public static final RegistryObject<Item> COW_COOKED_TRIPE = ITEMS.register("cooked_cow_tripe",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_TRIPE)));
    public static final RegistryObject<Item> COW_TRIPE = ITEMS.register("cow_tripe",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.TRIPE)));
    public static final RegistryObject<Item> COW_COOKED_STOMACHE = ITEMS.register(
            "cooked_cow_stomache",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_STOMACHE)));
    public static final RegistryObject<Item> COW_STOMACHE = ITEMS.register("cow_stomache",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.STOMACHE)));
    public static final RegistryObject<Item> COW_COOKED_LUNG = ITEMS.register("cooked_cow_lung",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_LUNG)));
    public static final RegistryObject<Item> COW_LUNG = ITEMS.register("cow_lung",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.LUNG)));
    public static final RegistryObject<Item> COW_COOKED_LIVER = ITEMS.register("cooked_cow_liver",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_LIVER)));
    public static final RegistryObject<Item> COW_LIVER = ITEMS.register("cow_liver",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.LIVER)));
    public static final RegistryObject<Item> COW_COOKED_KIDNEY = ITEMS.register("cooked_cow_kidney",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_KIDNEY)));
    public static final RegistryObject<Item> COW_KIDNEY = ITEMS.register("cow_kidney",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.KIDNEY)));
    public static final RegistryObject<Item> COW_COOKED_HEART = ITEMS.register("cooked_cow_heart",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_HEART)));
    public static final RegistryObject<Item> COW_HEART = ITEMS.register("cow_heart",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.HEART)));
    public static final RegistryObject<Item> COW_COOKED_BRAIN = ITEMS.register("cooked_cow_brain",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.COOKED_BRAIN)));
    public static final RegistryObject<Item> COW_BRAIN = ITEMS.register("cow_brain",
            () -> new Item(new Item.Properties().tab(GROUP_ITEMS).food(FoodsCow.BRAIN)));
    public static final RegistryObject<CarcassItem> COW_CARCASS = ITEMS.register("cow_carcass",
            () -> new CarcassItem(new Item.Properties().tab(GROUP_ITEMS)));
    public static final RegistryObject<Item> BUTCHER_KNIFE = ITEMS.register("butcher_knife",
            () -> new ButcherKnifeItem(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));

    public static final RegistryObject<Item> SKINNING_KNIFE = ITEMS.register("skinning_knife",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> BONE_SAW = ITEMS.register("bone_saw",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> SPATULA = ITEMS.register("spatula",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> GRINDER_TIP = ITEMS.register("grinder_tip",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> EXTRUDER_TIP = ITEMS.register("extruder_tip",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> LEATHER_SCRAP = ITEMS.register("leather_scrap",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));

    public static final RegistryObject<Item> LEATHER_CORD = ITEMS.register("leather_cord",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> FAT = ITEMS.register("fat",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> SINEW = ITEMS.register("sinew",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));

    public static final RegistryObject<BlockItem> HOOK_BLOCK_ITEM = ITEMS.register("meat_hook", () -> new BlockItem(ButchercraftBlocks.MEAT_HOOK.get(), new Item.Properties().tab(GROUP_ITEMS)));

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }
}
