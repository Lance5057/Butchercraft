package com.lance5057.butchercraft.fluids;

import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;

public class BloodFluidType extends FluidType implements IClientFluidTypeExtensions {
	private final ResourceLocation STILL = ResourceLocation.withDefaultNamespace("block/water_still");
	private final ResourceLocation FLOW = ResourceLocation.withDefaultNamespace("block/water_flow");
	private final ResourceLocation OVERLAY = ResourceLocation.withDefaultNamespace("block/water_still");
	private final ResourceLocation VIEW_OVERLAY = ResourceLocation
			.withDefaultNamespace("textures/block/water_still.png");

	public BloodFluidType(Properties properties) {
		super(properties);
	}

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
		return new Vector3f((color >> 16 & 0xFF) / 255F, (color >> 8 & 0xFF) / 255F, (color & 0xFF) / 255F);
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
}
