package com.lance5057.butchercraft.workstations.grinder;

import com.lance5057.butchercraft.Butchercraft;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.renderable.BakedModelRenderable;
import net.minecraftforge.client.model.renderable.IRenderable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.joml.Quaternionf;

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
		Quaternionf q = pBlockEntity.getBlockState().getValue(HorizontalDirectionalBlock.FACING).getRotation();

		pPoseStack.translate(0.5, 0.23, 0.5);
		
		pPoseStack.mulPose(q);
		pPoseStack.mulPose(new Quaternionf(0, 0, 180, 1));
		pPoseStack.translate(0, 0.34, 0);

		float g = pBlockEntity.getGrind();
		float mg = pBlockEntity.getMaxGrind();
		float r = mg == 0 ? 1 : 360 / (mg + 1);
		pPoseStack.mulPose(new Quaternionf(0, g * r, 0, 1));
		pPoseStack.translate(-0.5, 0, -0.05);
		model.render(pPoseStack, pBufferSource, texture -> RenderType.entityTranslucent(texture), pPackedLight,
				pPackedOverlay, pPartialTick, ModelData.EMPTY);
		pPoseStack.popPose();

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		LazyOptional<IItemHandler> itemInteractionHandler = pBlockEntity
				.getCapability(ForgeCapabilities.ITEM_HANDLER);

		itemInteractionHandler.ifPresent(inv -> {
			ItemStack input = inv.getStackInSlot(0);
			ItemStack tip = inv.getStackInSlot(1);
			ItemStack casing = inv.getStackInSlot(2);

			float t = mg == 0 ? 1 : -0.3f / (mg);
			renderRotatedItem(pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, q, itemRenderer,
					input, 0.5, 1.5 + (g * t), 0.175, 0, 90, 0, 1, 1, 1);
			renderRotatedItem(pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, q, itemRenderer,
					tip, 0.5, 1.22, 0.925, 90, 0, 0, 1, 1, 1);
			renderRotatedItem(pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, q, itemRenderer,
					casing, 0.5, 1.11, 0.9 - (g * t), 0, 90, 0, 1, 1, 2.1f);
		});

		timer++;
	}

	private void renderRotatedItem(GrinderBlockEntity pBlockEntity, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, Quaternionf q,
			ItemRenderer itemRenderer, ItemStack input, double xt, double yt, double zt, float xr, float yr, float zr,
			float xs, float ys, float zs) {
		if (!input.isEmpty()) {
			BakedModel bakedmodel = itemRenderer.getModel(input, pBlockEntity.getLevel(), null, 0);
			pPoseStack.pushPose();
			pPoseStack.translate(0.5f, -1, 0.5f);

			pPoseStack.mulPose(q);
			pPoseStack.mulPose(new Quaternionf(-90, 0, 0, 1));
			pPoseStack.translate(-0.5f, 0, -0.5f);

			pPoseStack.translate(xt, yt, zt);

			pPoseStack.mulPose(new Quaternionf(xr, yr, zr, 1));
			pPoseStack.scale(xs, ys, zs);
			float uniscale = 1f;
			pPoseStack.scale(uniscale, uniscale, uniscale);
			itemRenderer.render(input, ItemDisplayContext.GROUND, false, pPoseStack, pBufferSource,
					pPackedLight, pPackedOverlay, bakedmodel);
			pPoseStack.popPose();
		}
	}

}
