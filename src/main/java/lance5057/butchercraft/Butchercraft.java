package lance5057.butchercraft;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Butchercraft.MOD_ID)
public class Butchercraft {

    public final static String MOD_ID = "butchercraft";
    public static final String VERSION = "2.0a";

    public static Logger logger = LogManager.getLogger();

    private final ButchercraftBlocks blocks;
    private final ButchercraftItems items;

    public Butchercraft() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ButchercraftConfig.initialize());
        ButchercraftConfig.loadConfig(ButchercraftConfig.getInstance().getSpec(),
                FMLPaths.CONFIGDIR.get().resolve("compendium-common.toml"));

        blocks = new ButchercraftBlocks();
        items = new ButchercraftItems();

        ButchercraftBlocks.register(modEventBus);
        ButchercraftItems.register(modEventBus);
    }


}
