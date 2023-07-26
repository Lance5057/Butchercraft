package com.lance5057.butchercraft.workstations.grinder;

import com.lance5057.butchercraft.Butchercraft;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.renderable.BakedModelRenderable;
import net.minecraftforge.client.model.renderable.IRenderable;

public class GrinderRenderer implements BlockEntityRenderer<GrinderBlockEntity> {
	int timer = 0;

	ResourceLocation rc = new ResourceLocation(Butchercraft.MOD_ID, "meathook/grinder_handle");
	IRenderable<ModelData> model;

	public GrinderRenderer(BlockEntityRendererProvider.Context cxt) {
		model = BakedModelRenderable.of(rc).withModelDataContext();
	}

	@Override
	public void render(GrinderBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		// model = BakedModelRenderable.of(rc).withModelDataContext();
		pPoseStack.pushPose();
		pPoseStack.translate(0.5f, 1, 0.5f);
		Quaternion q = pBlockEntity.getBlockState().getValue(HorizontalDirectionalBlock.FACING).getRotation();

		pPoseStack.mulPose(q);
		pPoseStack.mulPose(new Quaternion(-90, 180, 0, true));

		pPoseStack.mulPose(new Quaternion(0, 0, pBlockEntity.getGrind() * 45, true));

		pPoseStack.translate(-0.5f, -1, -0.5f);
		model.render(pPoseStack, pBufferSource, texture -> RenderType.entityTranslucent(texture), pPackedLight,
				pPackedOverlay, pPartialTick, ModelData.EMPTY);
		pPoseStack.popPose();
		timer++;
	}

}
