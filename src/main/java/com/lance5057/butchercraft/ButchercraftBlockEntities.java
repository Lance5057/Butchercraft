package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.butcherblock.ButcherBlockBlockEntity;
import com.lance5057.butchercraft.workstations.grinder.GrinderBlockEntity;
import com.lance5057.butchercraft.workstations.hook.MeatHookBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Butchercraft.MOD_ID);

	public static final RegistryObject<BlockEntityType<MeatHookBlockEntity>> MEAT_HOOK = BLOCK_ENTITIES.register(
			"meat_hook",
			() -> BlockEntityType.Builder.of(MeatHookBlockEntity::new, ButchercraftBlocks.MEAT_HOOK.get()).build(null));

	public static final RegistryObject<BlockEntityType<ButcherBlockBlockEntity>> BUTCHER_BLOCK = BLOCK_ENTITIES
			.register("butcher_block", () -> BlockEntityType.Builder
					.of(ButcherBlockBlockEntity::new, ButchercraftBlocks.BUTCHER_BLOCK.get()).build(null));

	public static final RegistryObject<BlockEntityType<GrinderBlockEntity>> GRINDER = BLOCK_ENTITIES.register("grinder",
			() -> BlockEntityType.Builder.of(GrinderBlockEntity::new, ButchercraftBlocks.GRINDER.get()).build(null));

	public static final RegistryObject<BlockEntityType<SkullBlockEntity>> SKULL = BLOCK_ENTITIES.register("skull",
			() -> BlockEntityType.Builder.of(SkullBlockEntity::new, ButchercraftBlocks.COW_HEAD.get(),
					ButchercraftBlocks.COW_HEAD_WALL.get()).build(null));

	public static void register(IEventBus modBus) {
		BLOCK_ENTITIES.register(modBus);
	}

}
