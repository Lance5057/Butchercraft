package com.lance5057.butchercraft.client.rendering;

import org.joml.Quaternionf;

import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimationFloatTransform;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.renderable.BakedModelRenderable;
import net.neoforged.neoforge.client.model.renderable.IRenderable;

public class RenderUtil {

	public static Quaternionf createQuaternion(float x, float y, float z, boolean degrees) {
		if (degrees) {
			x *= (float) (Math.PI / 180.0);
			y *= (float) (Math.PI / 180.0);
			z *= (float) (Math.PI / 180.0);
		}

		float f = Mth.sin(0.5F * x);
		float g = Mth.cos(0.5F * x);
		float h = Mth.sin(0.5F * y);
		float i = Mth.cos(0.5F * y);
		float j = Mth.sin(0.5F * z);
		float k = Mth.cos(0.5F * z);

		return new Quaternionf(
				f * i * k + g * h * j,
				g * h * k - f * i * j,
				f * h * k + g * i * j,
				g * i * k - f * h * j
		);
	}

	public static void loadModel(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
			int combinedOverlayIn, BlacklistedModel model, float timer) {

		if (model.isBlock()) {
			IRenderable<ModelData> bm = BakedModelRenderable.of(ModelResourceLocation.standalone(model.rc())).withModelDataContext();
			blockModel(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, bm,
					model.transform(), timer);

		} else

		{
			Item item = BuiltInRegistries.ITEM.get(model.rc());
			itemModel(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, item,
					model.transform(), timer);
		}
	}

	public static void blockModel(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
			int combinedOverlayIn, IRenderable<ModelData> bm,
			AnimationFloatTransform transform, float timer) {
		matrixStackIn.pushPose();
		{

			matrixStackIn.translate(transform.getLocation().getX().animate(timer) / 16,
					transform.getLocation().getY().animate(timer) / 16,
					transform.getLocation().getZ().animate(timer) / 16);
			matrixStackIn.mulPose(createQuaternion(transform.getRotation().getX().animate(timer),
					transform.getRotation().getY().animate(timer), transform.getRotation().getZ().animate(timer),
					true));
			matrixStackIn.scale(1+transform.getScale().getX().animate(timer),
					1+transform.getScale().getY().animate(timer), 1+transform.getScale().getZ().animate(timer));

			bm.render(matrixStackIn, bufferIn, texture -> RenderType.entityTranslucent(texture), combinedLightIn,
					combinedOverlayIn, timer, ModelData.EMPTY);

		}
		matrixStackIn.popPose();

	}

	public static void itemModel(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
			int combinedOverlayIn, Item item, AnimationFloatTransform transform, float timer) {
		matrixStackIn.pushPose();
		{
			ItemStack stack = new ItemStack(item);
			ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
			BakedModel bakedmodel = itemRenderer.getModel(stack, null, null, 0);

			matrixStackIn.translate(
					(transform.getLocation().getX().getOffset() + transform.getLocation().getX().animate(timer) / 16),
					(transform.getLocation().getY().getOffset() + transform.getLocation().getY().animate(timer) / 16),
					(transform.getLocation().getZ().getOffset() + transform.getLocation().getZ().animate(timer) / 16));

			matrixStackIn.mulPose(createQuaternion(
					transform.getRotation().getX().getOffset() + transform.getRotation().getX().animate(timer),
					transform.getRotation().getY().getOffset() + transform.getRotation().getY().animate(timer),
					transform.getRotation().getZ().getOffset() + transform.getRotation().getZ().animate(timer), true));

			matrixStackIn.scale(transform.getScale().getX().animate(timer),
					transform.getScale().getY().animate(timer), transform.getScale().getZ().animate(timer));

			itemRenderer.render(stack, ItemDisplayContext.NONE, false, matrixStackIn, bufferIn,
					combinedLightIn, combinedOverlayIn, bakedmodel);
		}
		matrixStackIn.popPose();

	}
}
