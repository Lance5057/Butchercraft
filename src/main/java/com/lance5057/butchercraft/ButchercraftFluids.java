package com.lance5057.butchercraft;

import java.util.function.Consumer;

import org.antlr.v4.runtime.misc.NotNull;
import org.joml.Vector3f;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ButchercraftFluids {
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister
			.create(NeoForgeRegistries.Keys.FLUID_TYPES, Butchercraft.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID,
			Butchercraft.MOD_ID);

	private static BaseFlowingFluid.Properties blood() {
		return new BaseFlowingFluid.Properties(BLOOD_FLUID_TYPE, BLOOD_FLUID, BLOOD_FLUID_FLOWING)
				.block(ButchercraftBlocks.BLOOD_FLUID_BLOCK).bucket(ButchercraftItems.BLOOD_FLUID_BUCKET);
	}

//	private static ForgeFlowingFluid.Properties tanning() {
//		return new ForgeFlowingFluid.Properties(TANNING_FLUID_TYPE, TANNING_FLUID, TANNING_FLUID_FLOWING)
//				.block(ButchercraftBlocks.TANNING_FLUID_BLOCK).bucket(ButchercraftItems.TANNING_FLUID_BUCKET);
//	}

	public static final DeferredHolder<FluidType, FluidType> BLOOD_FLUID_TYPE = FLUID_TYPES.register("blood_fluid",
			() -> new FluidType(FluidType.Properties.create().supportsBoating(true).canHydrate(true).density(2000)
					.viscosity(3000).fallDistanceModifier(0F).canExtinguish(true)) {
				@Override
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation STILL = new ResourceLocation("block/water_still"),
								FLOW = new ResourceLocation("block/water_flow"),
								OVERLAY = new ResourceLocation("block/water_still"),
								VIEW_OVERLAY = new ResourceLocation("textures/block/water_still.png");

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
							return 0xAF540a04;
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
							nearDistance = -48F;
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

	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> BLOOD_FLUID = FLUIDS.register("blood_fluid",
			() -> new BaseFlowingFluid.Source(blood()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> BLOOD_FLUID_FLOWING = FLUIDS.register("blood_fluid_flowing",
			() -> new BaseFlowingFluid.Flowing(blood()));

//	public static final RegistryObject<FluidType> TANNING_FLUID_TYPE = FLUID_TYPES.register("tanning_fluid",
//			() -> new FluidType(FluidType.Properties.create().supportsBoating(true).canHydrate(true).density(2000)
//					.viscosity(3000).fallDistanceModifier(0F).canExtinguish(true)) {
//				@Override
//				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
//					consumer.accept(new IClientFluidTypeExtensions() {
//						private static final ResourceLocation STILL = new ResourceLocation("block/water_still"),
//								FLOW = new ResourceLocation("block/water_flow"),
//								OVERLAY = new ResourceLocation("block/water_still"),
//								VIEW_OVERLAY = new ResourceLocation("textures/block/water_still.png");
//
//						@Override
//						public ResourceLocation getStillTexture() {
//							return STILL;
//						}
//
//						@Override
//						public ResourceLocation getFlowingTexture() {
//							return FLOW;
//						}
//
//						@Override
//						public ResourceLocation getOverlayTexture() {
//							return OVERLAY;
//						}
//
//						@Override
//						public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
//							return VIEW_OVERLAY;
//						}
//
//						@Override
//						public int getTintColor() {
//							return 0xAF9a5126;
//						}
//
//						@Override
//						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
//								int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
//							int color = this.getTintColor();
//							return new Vector3f((color >> 16 & 0xFF) / 255F, (color >> 8 & 0xFF) / 255F,
//									(color & 0xFF) / 255F);
//						}
//
//						@Override
//						public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance,
//								float partialTick, float nearDistance, float farDistance, FogShape shape) {
//							nearDistance = -48F;
//							farDistance = 24F;
//
//							if (farDistance > renderDistance) {
//								farDistance = renderDistance;
//								shape = FogShape.CYLINDER;
//							}
//
//							RenderSystem.setShaderFogStart(nearDistance);
//							RenderSystem.setShaderFogEnd(farDistance);
//							RenderSystem.setShaderFogShape(shape);
//						}
//					});
//				}
//			});
//
//	public static final RegistryObject<FlowingFluid> TANNING_FLUID = FLUIDS.register("tanning_fluid",
//			() -> new ForgeFlowingFluid.Source(tanning()));
//	public static final RegistryObject<Fluid> TANNING_FLUID_FLOWING = FLUIDS.register("tanning_fluid_flowing",
//			() -> new ForgeFlowingFluid.Flowing(tanning()));

	public static void register(IEventBus modBus) {
		FLUID_TYPES.register(modBus);
		FLUIDS.register(modBus);
	}
}
