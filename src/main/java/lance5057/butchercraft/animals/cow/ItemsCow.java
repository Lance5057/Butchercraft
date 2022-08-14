package lance5057.butchercraft.animals.cow;

import lance5057.butchercraft.ButchercraftItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;


public class ItemsCow {
    public static final RegistryObject<Item> COW_CARCASS = ButchercraftItems.ITEMS.register("cow_carcass",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));

    public static final RegistryObject<Item> COW_BRAIN = ButchercraftItems.ITEMS.register("cow_brain",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.BRAIN)));
    public static final RegistryObject<Item> COW_COOKED_BRAIN = ButchercraftItems.ITEMS.register("cooked_cow_brain",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_BRAIN)));
    public static final RegistryObject<Item> COW_HEART = ButchercraftItems.ITEMS.register("cow_heart",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.HEART)));
    public static final RegistryObject<Item> COW_COOKED_HEART = ButchercraftItems.ITEMS.register("cooked_cow_heart",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_HEART)));
    public static final RegistryObject<Item> COW_KIDNEY = ButchercraftItems.ITEMS.register("cow_kidney",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.KIDNEY)));
    public static final RegistryObject<Item> COW_COOKED_KIDNEY = ButchercraftItems.ITEMS.register("cooked_cow_kidney",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_KIDNEY)));
    public static final RegistryObject<Item> COW_LIVER = ButchercraftItems.ITEMS.register("cow_liver",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.LIVER)));
    public static final RegistryObject<Item> COW_COOKED_LIVER = ButchercraftItems.ITEMS.register("cooked_cow_liver",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_LIVER)));
    public static final RegistryObject<Item> COW_LUNG = ButchercraftItems.ITEMS.register("cow_lung",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.LUNG)));
    public static final RegistryObject<Item> COW_COOKED_LUNG = ButchercraftItems.ITEMS.register("cooked_cow_lung",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_LUNG)));
    public static final RegistryObject<Item> COW_STOMACHE = ButchercraftItems.ITEMS.register("cow_stomache",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.STOMACHE)));
    public static final RegistryObject<Item> COW_COOKED_STOMACHE = ButchercraftItems.ITEMS.register(
            "cooked_cow_stomache",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_STOMACHE)));
    public static final RegistryObject<Item> COW_TRIPE = ButchercraftItems.ITEMS.register("cow_tripe",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.TRIPE)));
    public static final RegistryObject<Item> COW_COOKED_TRIPE = ButchercraftItems.ITEMS.register("cooked_cow_tripe",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_TRIPE)));

    public static final RegistryObject<Item> BEEF_STEWMEAT = ButchercraftItems.ITEMS.register("beef_stewmeat",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.BEEF_STEWMEAT)));
    public static final RegistryObject<Item> COOKED_BEEF_STEWMEAT = ButchercraftItems.ITEMS
            .register("cooked_beef_stewmeat", () -> new Item(
                    new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_BEEF_STEWMEAT)));
    public static final RegistryObject<Item> BEEF_ROAST = ButchercraftItems.ITEMS.register("beef_roast",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.ROAST)));
    public static final RegistryObject<Item> COOKED_BEEF_ROAST = ButchercraftItems.ITEMS.register("cooked_beef_roast",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_ROAST)));
    public static final RegistryObject<Item> BEEF_RIBS = ButchercraftItems.ITEMS.register("beef_ribs",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.BEEF_RIBS)));
    public static final RegistryObject<Item> COOKED_BEEF_RIBS = ButchercraftItems.ITEMS.register("cooked_beef_ribs",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_BEEF_RIBS)));
    public static final RegistryObject<Item> CUBED_BEEF = ButchercraftItems.ITEMS.register("cubed_beef",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.CUBED_BEEF)));
    public static final RegistryObject<Item> COOKED_CUBED_BEEF = ButchercraftItems.ITEMS.register("cooked_cubed_beef",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_CUBED_BEEF)));
    public static final RegistryObject<Item> GROUND_BEEF = ButchercraftItems.ITEMS.register("ground_beef",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.GROUND_BEEF)));
    public static final RegistryObject<Item> COOKED_GROUND_BEEF = ButchercraftItems.ITEMS.register("cooked_ground_beef",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_GROUND_BEEF)));
    public static final RegistryObject<Item> BEEF_SCRAPS = ButchercraftItems.ITEMS.register("beef_scraps",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.BEEF_SCRAPS)));
    public static final RegistryObject<Item> COOKED_BEEF_SCRAPS = ButchercraftItems.ITEMS.register("cooked_beef_scraps",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS).food(FoodsCow.COOKED_BEEF_SCRAPS)));

}
