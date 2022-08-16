package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.blocks.MeatHookBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Butchercraft.MOD_ID);

    public static final RegistryObject<MeatHookBlock> MEAT_HOOK = BLOCKS.register("meat_hook",
            MeatHookBlock::new);

    public static void register(IEventBus modBus) {

        BLOCKS.register(modBus);
    }
}
