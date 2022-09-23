package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.blocks.MeatHookBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Butchercraft.MOD_ID);

	public static final RegistryObject<MeatHookBlock> MEAT_HOOK = BLOCKS.register("meat_hook", MeatHookBlock::new);
	public static final RegistryObject<Block> COW_SKULL = BLOCKS.register("cow_skull",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> BEEF_BLOCK = BLOCKS.register("beef_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_MAGENTA)));
	public static final RegistryObject<Block> COOKED_BEEF_BLOCK = BLOCKS.register("cooked_beef_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_BROWN)));

	public static void register(IEventBus modBus) {

		BLOCKS.register(modBus);
	}
}
