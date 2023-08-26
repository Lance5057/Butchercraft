package com.lance5057.butchercraft;

import java.util.function.Consumer;

import org.antlr.v4.runtime.misc.NotNull;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Vector3f;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftFluids {
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister
			.create(ForgeRegistries.Keys.FLUID_TYPES, Butchercraft.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
			Butchercraft.MOD_ID);

	private static ForgeFlowingFluid.Properties fluidProperties() {
		return new ForgeFlowingFluid.Properties(TEST_FLUID_TYPE, TEST_FLUID, TEST_FLUID_FLOWING).block(TEST_FLUID_BLOCK)
				.bucket(TEST_FLUID_BUCKET);
	}

	private static final RegistryObject<FluidType> TEST_FLUID_TYPE = FLUID_TYPES.register("test_fluid",
			() -> new FluidType(FluidType.Properties.create().supportsBoating(true).canHydrate(true)) {
				@Override
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation STILL = new ResourceLocation("block/water_still"),
								FLOW = new ResourceLocation("block/water_flow"),
								OVERLAY = new ResourceLocation("block/obsidian"),
								VIEW_OVERLAY = new ResourceLocation("textures/block/obsidian.png");

						@Override
						public ResourceLocation getStillTexture() {
							return STILL;
						}

						@Override
						public ResourceLocation getFlowingTexture() {
							return FLOW;
						}

						@Override
						public ResourceLocation getOverlayTexture() {
							return OVERLAY;
						}

						@Override
						public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
							return VIEW_OVERLAY;
						}

						@Override
						public int getTintColor() {
							return 0xAF7FFFD4;
						}

						@Override
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
								int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
							return new Vector3f((color >> 16 & 0xFF) / 255F, (color >> 8 & 0xFF) / 255F,
									(color & 0xFF) / 255F);
						}

						@Override
						public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance,
								float partialTick, float nearDistance, float farDistance, FogShape shape) {
							nearDistance = -8F;
							farDistance = 24F;

							if (farDistance > renderDistance) {
								farDistance = renderDistance;
								shape = FogShape.CYLINDER;
							}

							RenderSystem.setShaderFogStart(nearDistance);
							RenderSystem.setShaderFogEnd(farDistance);
							RenderSystem.setShaderFogShape(shape);
						}
					});
				}
			});

	private static final RegistryObject<FlowingFluid> TEST_FLUID = FLUIDS.register("test_fluid",
			() -> new ForgeFlowingFluid.Source(fluidProperties()));
	private static final RegistryObject<Fluid> TEST_FLUID_FLOWING = FLUIDS.register("test_fluid_flowing",
			() -> new ForgeFlowingFluid.Flowing(fluidProperties()));
	private static final RegistryObject<LiquidBlock> TEST_FLUID_BLOCK = ButchercraftBlocks.BLOCKS
			.register("test_fluid_block", () -> new LiquidBlock(TEST_FLUID,
					BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	private static final RegistryObject<Item> TEST_FLUID_BUCKET = ButchercraftItems.ITEMS.register("test_fluid_bucket",
			() -> new BucketItem(TEST_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static void register(IEventBus modBus) {
		FLUID_TYPES.register(modBus);
		FLUIDS.register(modBus);
	}
}
