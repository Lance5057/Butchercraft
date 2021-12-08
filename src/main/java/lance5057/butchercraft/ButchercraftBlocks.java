package lance5057.butchercraft;

import lance5057.butchercraft.workstations.blocks.BlockHook;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ButchercraftBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
	    Butchercraft.MOD_ID);
    
    public static final RegistryObject<BlockHook> BLOCK_HOOK = BLOCKS.register("hook_block",
	    () -> new BlockHook());

    public static void register(IEventBus modBus) {

	BLOCKS.register(modBus);
    }
}

