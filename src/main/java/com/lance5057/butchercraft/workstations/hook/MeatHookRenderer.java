package com.lance5057.butchercraft.workstations.hook;

import com.lance5057.butchercraft.client.rendering.RenderUtil;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimationFloatTransform;
import com.mojang.blaze3d.vertex.PoseStack;
import org.joml.Quaternionf;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
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
		if (pBlockEntity.hasLevel()) {
			pPoseStack.pushPose();
			pPoseStack.translate(0.5f, -1, 0.5f);
			Quaternionf q = pBlockEntity.getBlockState().getValue(HorizontalDirectionalBlock.FACING).getRotation();
			
			pPoseStack.mulPose(q);
			pPoseStack.mulPose(RenderUtil.createQuaternion(-90,0,0,true));
			
			pPoseStack.translate(-0.5f, 0, -0.5f);
			
			pBlockEntity.getCurrentTool().ifPresent(animatedRecipeItemUse -> animatedRecipeItemUse.model().forEach(
					b -> RenderUtil.loadModel(pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, b, timer)));
			pPoseStack.popPose();
			timer++;
		}
	}

	@Override
	public boolean shouldRenderOffScreen(MeatHookBlockEntity pBlockEntity) {
		return true;
	}

	@Override
	public int getViewDistance() {
		return 64;
	}

	@Override
	public boolean shouldRender(MeatHookBlockEntity pBlockEntity, Vec3 pCameraPos) {
		// return Vec3.atCenterOf(pBlockEntity.getBlockPos()).closerThan(pCameraPos,
		// (double) this.getViewDistance());
		return true;
	}

}
