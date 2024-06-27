package com.lance5057.butchercraft;

import com.lance5057.butchercraft.workstations.butcherblock.ButcherBlockBlockEntity;
import com.lance5057.butchercraft.workstations.grinder.GrinderBlockEntity;
import com.lance5057.butchercraft.workstations.hook.MeatHookBlockEntity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ButchercraftBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(Registries.BLOCK_ENTITY_TYPE, Butchercraft.MOD_ID);

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MeatHookBlockEntity>> MEAT_HOOK = BLOCK_ENTITIES.register(
			"meat_hook",
			() -> BlockEntityType.Builder.of(MeatHookBlockEntity::new, ButchercraftBlocks.MEAT_HOOK.get()).build(null));

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ButcherBlockBlockEntity>> BUTCHER_BLOCK = BLOCK_ENTITIES
			.register("butcher_block", () -> BlockEntityType.Builder
					.of(ButcherBlockBlockEntity::new, ButchercraftBlocks.BUTCHER_BLOCK.get()).build(null));

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrinderBlockEntity>> GRINDER = BLOCK_ENTITIES.register("grinder",
			() -> BlockEntityType.Builder.of(GrinderBlockEntity::new, ButchercraftBlocks.GRINDER.get()).build(null));

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SkullBlockEntity>> SKULL = BLOCK_ENTITIES
			.register("skull",
					() -> BlockEntityType.Builder.of(SkullBlockEntity::new, ButchercraftBlocks.COW_HEAD.get(),
							ButchercraftBlocks.COW_SKULL_HEAD.get(), ButchercraftBlocks.CHICKEN_HEAD.get(),
							ButchercraftBlocks.CHICKEN_SKULL_HEAD.get(), ButchercraftBlocks.SHEEP_HEAD.get(),
							ButchercraftBlocks.SHEEP_SKULL_HEAD.get(), ButchercraftBlocks.PIG_HEAD.get(),
							ButchercraftBlocks.PIG_SKULL_HEAD.get(), ButchercraftBlocks.GOAT_HEAD.get(),
							ButchercraftBlocks.GOAT_SKULL_HEAD.get(), ButchercraftBlocks.RABBIT_BLACK_HEAD.get(),
							ButchercraftBlocks.RABBIT_BROWN_HEAD.get(), ButchercraftBlocks.RABBIT_GOLD_HEAD.get(),
							ButchercraftBlocks.RABBIT_SALT_HEAD.get(), ButchercraftBlocks.RABBIT_SPLOTCHED_HEAD.get(),
							ButchercraftBlocks.RABBIT_WHITE_HEAD.get(), ButchercraftBlocks.RABBIT_SKULL_HEAD.get())
							.build(null));

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SkullBlockEntity>> WALL_SKULL = BLOCK_ENTITIES.register(
			"wall_skull",
			() -> BlockEntityType.Builder.of(SkullBlockEntity::new, ButchercraftBlocks.COW_HEAD_WALL.get(),
					ButchercraftBlocks.COW_SKULL_HEAD_WALL.get(), ButchercraftBlocks.CHICKEN_HEAD_WALL.get(),
					ButchercraftBlocks.CHICKEN_SKULL_HEAD_WALL.get(), ButchercraftBlocks.SHEEP_HEAD_WALL.get(),
					ButchercraftBlocks.SHEEP_SKULL_HEAD_WALL.get(), ButchercraftBlocks.PIG_HEAD_WALL.get(),
					ButchercraftBlocks.PIG_SKULL_HEAD_WALL.get(), ButchercraftBlocks.GOAT_HEAD_WALL.get(),
					ButchercraftBlocks.GOAT_SKULL_HEAD_WALL.get(), ButchercraftBlocks.RABBIT_BLACK_HEAD_WALL.get(),
					ButchercraftBlocks.RABBIT_BROWN_HEAD_WALL.get(), ButchercraftBlocks.RABBIT_GOLD_HEAD_WALL.get(),
					ButchercraftBlocks.RABBIT_SALT_HEAD_WALL.get(), ButchercraftBlocks.RABBIT_SPLOTCHED_HEAD_WALL.get(),
					ButchercraftBlocks.RABBIT_WHITE_HEAD_WALL.get(), ButchercraftBlocks.RABBIT_SKULL_HEAD_WALL.get())
					.build(null));

	public static void register(IEventBus modBus) {
		BLOCK_ENTITIES.register(modBus);
	}

}
