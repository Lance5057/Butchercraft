package com.lance5057.butchercraft.client;

import java.util.function.Function;

import com.lance5057.butchercraft.ButchercraftItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

public class CarcassItemRenderer extends BlockEntityWithoutLevelRenderer {
	protected static CarcassItemRenderer instance;
	private final EntityRenderDispatcher entityRenderer;

	public static CarcassItemRenderer getInstance() {
		if (instance == null) {
			instance = new CarcassItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
					Minecraft.getInstance().getEntityModels());
		}
		return instance;
	}

	public CarcassItemRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {

		super(blockEntityRenderDispatcher, entityModelSet);
		this.entityRenderer = Minecraft.getInstance().getEntityRenderDispatcher();
	}

	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack ps, MultiBufferSource mbs,
			int packedLight, int overlay) {

		if (stack.is(ButchercraftItems.CARCASS)) {
			if (stack.has(DataComponents.ENTITY_DATA)) {
				CustomData d = stack.get(DataComponents.ENTITY_DATA);
				if (!d.isEmpty()) {
					Entity ent = EntityType.loadEntityRecursive(d.copyTag(), Minecraft.getInstance().level,
							Function.identity());

					if (ent != null) {
						ps.pushPose();
						float f = 0.53125F;
						float f1 = Math.max(ent.getBbWidth(), ent.getBbHeight());
						if ((double) f1 > 1.0) {
							f /= f1;
						}
						f *= 3;

						switch (displayContext) {
						case ItemDisplayContext.GUI:
							ps.translate(0.8F, 0.5F, 0.0F);
							ps.mulPose(Axis.YP.rotationDegrees(90.0F));
							break;

						case ItemDisplayContext.THIRD_PERSON_RIGHT_HAND:
							ps.translate(0.0F, 0.5F, 0.0F);
							ps.mulPose(Axis.YP.rotationDegrees(45.0F));
							break;
							
						case ItemDisplayContext.THIRD_PERSON_LEFT_HAND:
							ps.translate(1.0F, 0.5F, 0.0F);
							ps.mulPose(Axis.YP.rotationDegrees(-45.0F));
							break;
							
						case ItemDisplayContext.FIRST_PERSON_RIGHT_HAND:
							ps.translate(0.0F, -0.1F, -1.0F);
							ps.mulPose(Axis.YP.rotationDegrees(0.0F));
							break;
							
						case ItemDisplayContext.FIRST_PERSON_LEFT_HAND:
							ps.translate(-1.0F, -0.1F, 0.0F);
							ps.mulPose(Axis.YP.rotationDegrees(90.0F));
							break;
							
						case ItemDisplayContext.FIXED:
							ps.translate(0.5F, -0.5F, 0.5F);
							ps.mulPose(Axis.YP.rotationDegrees(90.0F));
							break;
							
						default:
							break;

						}

						ps.scale(f, f, f);
						entityRenderer.render(ent, 0, 0, 0, 0, 0, ps, mbs, packedLight);
						ps.popPose();
					}

				}
			}
		}
	}

}
