package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.blockentities.ButcherBlockBlockEntity;
import com.lance5057.butchercraft.workstations.blockentities.DryingRackBlockEntity;
import com.lance5057.butchercraft.workstations.blockentities.MeatHookBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, Butchercraft.MOD_ID);

	public static final RegistryObject<BlockEntityType<MeatHookBlockEntity>> MEAT_HOOK = BLOCK_ENTITIES.register(
			"meat_hook",
			() -> BlockEntityType.Builder.of(MeatHookBlockEntity::new, ButchercraftBlocks.MEAT_HOOK.get()).build(null));

	public static final RegistryObject<BlockEntityType<DryingRackBlockEntity>> DRYING_RACK = BLOCK_ENTITIES
			.register("drying_rack", () -> BlockEntityType.Builder
					.of(DryingRackBlockEntity::new, ButchercraftBlocks.DRYING_RACK.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<ButcherBlockBlockEntity>> BUTCHER_BLOCK = BLOCK_ENTITIES.register(
			"butcher_block",
			() -> BlockEntityType.Builder.of(ButcherBlockBlockEntity::new, ButchercraftBlocks.BUTCHER_BLOCK.get()).build(null));

	public static void register(IEventBus modBus) {
		BLOCK_ENTITIES.register(modBus);
	}

}
