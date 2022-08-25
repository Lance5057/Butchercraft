package com.lance5057.butchercraft.workstations.client;

import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.client.rendering.RenderUtil;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimationFloatTransform;
import com.lance5057.butchercraft.workstations.blockentities.MeatHookBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;

public class MeatHookRenderer implements BlockEntityRenderer<MeatHookBlockEntity> {
	int timer = 0;
	AnimationFloatTransform ghost;

	public MeatHookRenderer(BlockEntityRendererProvider.Context cxt) {
		ghost = new AnimationFloatTransform();
	}

	@Override
	public void render(MeatHookBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

		if (pBlockEntity.getCurrentTool() != null) {
			for (BlacklistedModel b : pBlockEntity.getCurrentTool().model)
				RenderUtil.loadModel(pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, b, timer);
		}

		timer++;
	}

	public boolean shouldRenderOffScreen(MeatHookBlockEntity pBlockEntity) {
		return true;
	}

	public int getViewDistance() {
		return 64;
	}

	public boolean shouldRender(MeatHookBlockEntity pBlockEntity, Vec3 pCameraPos) {
		//return Vec3.atCenterOf(pBlockEntity.getBlockPos()).closerThan(pCameraPos, (double) this.getViewDistance());
		return true;
	}

}
