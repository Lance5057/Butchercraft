package com.lance5057.butchercraft.client;

import com.lance5057.butchercraft.items.CarcassItem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class CarcassItemRenderer extends BlockEntityWithoutLevelRenderer {
	protected static CarcassItemRenderer instance;

	public static CarcassItemRenderer getInstance() {
		if (instance == null) {
			instance = new CarcassItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
					Minecraft.getInstance().getEntityModels());
		}
		return instance;
	}

	public CarcassItemRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {
		super(blockEntityRenderDispatcher, entityModelSet);
	}

	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack ps, MultiBufferSource mbs,
			int packedLight, int overlay) {
		ps.pushPose();
		if (stack.getItem() instanceof BlockItem bi) {
			if (stack.getItem() instanceof CarcassItem ci) {
				
			}
		}
	}

}
