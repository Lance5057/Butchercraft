package lance5057.butchercraft;

import lance5057.butchercraft.animals.cow.ItemsCow;
import lance5057.butchercraft.items.ItemButcherknife;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ButchercraftItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Butchercraft.MOD_ID);    public static final CreativeModeTab GROUP_ITEMS = new CreativeModeTab("butchercraft.items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ButchercraftItems.butcherKnife.get());
        }
    };
    ItemsCow cow = new ItemsCow();

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }    public static final RegistryObject<Item> butcherKnife = ITEMS.register("butcher_knife",
            () -> new ItemButcherknife(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> skinningKnife = ITEMS.register("skinning_knife",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> boneSaw = ITEMS.register("bone_saw",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> spatula = ITEMS.register("spatula",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> grindTip = ITEMS.register("grinder_tip",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> sausageTip = ITEMS.register("extruder_tip",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));

    public static final RegistryObject<Item> leatherScrap = ITEMS.register("leather_crap",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> leatherCord = ITEMS.register("leather_cord",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> fat = ITEMS.register("fat",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));
    public static final RegistryObject<Item> sinew = ITEMS.register("sinew",
            () -> new Item(new Item.Properties().tab(ButchercraftItems.GROUP_ITEMS)));




}
