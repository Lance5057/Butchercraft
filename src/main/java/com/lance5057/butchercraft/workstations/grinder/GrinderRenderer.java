package com.lance5057.butchercraft.workstations.grinder;

import com.lance5057.butchercraft.Butchercraft;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.renderable.BakedModelRenderable;
import net.minecraftforge.client.model.renderable.IRenderable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

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

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		LazyOptional<IItemHandler> itemInteractionHandler = pBlockEntity
				.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);

		itemInteractionHandler.ifPresent(inv -> {
			ItemStack item = inv.getStackInSlot(1);

			if (!item.isEmpty()) {
				BakedModel bakedmodel = itemRenderer.getModel(item, pBlockEntity.getLevel(), null, 0);
				pPoseStack.pushPose();

				pPoseStack.translate(0.5f, 0.225f, 0.075f);

				pPoseStack.mulPose(new Quaternion(-90, 0, 0, true));

				float uniscale = 1f;
				pPoseStack.scale(uniscale, uniscale, uniscale);
				itemRenderer.render(item, ItemTransforms.TransformType.GROUND, false, pPoseStack, pBufferSource,
						pPackedLight, pPackedOverlay, bakedmodel);
				pPoseStack.popPose();
			}
		});

		timer++;
	}

}
