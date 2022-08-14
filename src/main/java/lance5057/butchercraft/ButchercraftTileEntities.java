package lance5057.butchercraft;

import lance5057.butchercraft.workstations.tileentities.TileHook;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftTileEntities {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITIES, Butchercraft.MOD_ID);

    public static void register(IEventBus modBus) {
        TILE_ENTITIES.register(modBus);
    }

    public static final RegistryObject<BlockEntityType<TileHook>> HOOK_TILE_ENTITY = TILE_ENTITIES.register(
            "hook_tile_entity",
            () -> BlockEntityType.Builder.of(TileHook::new, ButchercraftBlocks.BLOCK_HOOK.get()).build(null));


}
