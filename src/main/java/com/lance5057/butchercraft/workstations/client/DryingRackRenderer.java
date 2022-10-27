package com.lance5057.butchercraft.workstations.client;

import com.lance5057.butchercraft.workstations.blockentities.DryingRackBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class DryingRackRenderer implements BlockEntityRenderer<DryingRackBlockEntity> {

	public DryingRackRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(DryingRackBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		LazyOptional<IItemHandler> itemInteractionHandler = pBlockEntity
				.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);

		itemInteractionHandler.ifPresent(inv -> {
			for (int i = 0; i < DryingRackBlockEntity.NUM_SLOTS; i++) {
				ItemStack item = inv.getStackInSlot(i);

				if (!item.isEmpty()) {
					BakedModel bakedmodel = itemRenderer.getModel(item, pBlockEntity.getLevel(), null, 0);
					pPoseStack.pushPose();
					pPoseStack.translate(0.26f, 1 + (i % 2), 0.16);
					pPoseStack.mulPose(new Quaternion(-90, 0, 0, true));
					float uniscale = 0.2f;
					pPoseStack.scale(uniscale, uniscale, uniscale);
					itemRenderer.render(item, ItemTransforms.TransformType.GROUND, false, pPoseStack, pBufferSource,
							pPackedLight, pPackedOverlay, bakedmodel);
					pPoseStack.popPose();
				}
			}
		});
	}

}
