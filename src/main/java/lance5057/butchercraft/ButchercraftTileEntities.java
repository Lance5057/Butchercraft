package lance5057.butchercraft;

import lance5057.butchercraft.workstations.tileentities.TileHook;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ButchercraftTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister
	    .create(ForgeRegistries.TILE_ENTITIES, Butchercraft.MOD_ID);

    public static final RegistryObject<TileEntityType<TileHook>> HOOK_TILE_ENTITY = TILE_ENTITIES.register(
	    "hook_tile_entity",
	    () -> TileEntityType.Builder.of(TileHook::new, ButchercraftBlocks.BLOCK_HOOK.get()).build(null));

    public static void register(IEventBus modBus) {
	TILE_ENTITIES.register(modBus);
    }
}
