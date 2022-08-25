package com.lance5057.butchercraft.client.rendering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimationFloatTransform;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockElement;
import net.minecraft.client.renderer.block.model.BlockElementFace;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.registries.ForgeRegistries;

public class RenderUtil {

	public static int argbToHex(int r, int g, int b, int a) {
		return (a << 24) | (r << 16) | (g << 8) | (b);
	}

	public static void renderItemCustomColor(ItemStack stack, int color, PoseStack ms, MultiBufferSource buffers,
			int light, int overlay, @Nullable BakedModel model) {
		ms.pushPose();
		{
			if (model == null) {
				ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
				model = itemRenderer.getModel(stack, null, null, 0);
			}
			model = ForgeHooksClient.handleCameraTransforms(ms, model, ItemTransforms.TransformType.NONE, false);
			ms.translate(-0.5D, -0.5D, -0.5D);

			if (!model.isCustomRenderer() && (stack.getItem() != Items.TRIDENT)) {
				RenderType rendertype = ItemBlockRenderTypes.getRenderType(stack, true);
				VertexConsumer ivertexbuilder = ItemRenderer.getFoilBufferDirect(buffers, rendertype, true,
						stack.hasFoil());
				renderBakedItemModel(model, stack, color, light, overlay, ms, ivertexbuilder);
			} else {

			}
		}
		ms.popPose();
	}

	// [VanillaCopy] ItemRenderer with custom color
	private static void renderBakedItemModel(BakedModel model, ItemStack stack, int color, int light, int overlay,
			PoseStack ms, VertexConsumer buffer) {
		Random random = new Random();
		long i = 42L;

		for (Direction direction : Direction.values()) {
			random.setSeed(42L);
			renderBakedItemQuads(ms, buffer, color, model.getQuads((BlockState) null, direction, random), stack, light,
					overlay);
		}

		random.setSeed(42L);
		renderBakedItemQuads(ms, buffer, color, model.getQuads((BlockState) null, (Direction) null, random), stack,
				light, overlay);
	}

	// [VanillaCopy] ItemRenderer, with custom color + alpha support
	private static void renderBakedItemQuads(PoseStack ms, VertexConsumer buffer, int color, List<BakedQuad> quads,
			ItemStack stack, int light, int overlay) {
		PoseStack.Pose matrixstack$entry = ms.last();

		for (BakedQuad bakedquad : quads) {
			int i = color;

			float f = (float) (i >> 16 & 255) / 255.0F;
			float f1 = (float) (i >> 8 & 255) / 255.0F;
			float f2 = (float) (i & 255) / 255.0F;
			float alpha = ((color >> 24) & 0xFF) / 255.0F;
			buffer.putBulkData(matrixstack$entry, bakedquad, f, f1, f2, alpha, light, overlay, true);
		}

	}

//	public static CompendiumModelPart.Cube cube = new CompendiumModelPart.Cube(1, 1, new Vector3f(0, 0, 0),
//			new Vector3f(1, 1, 1), new Vector3f(0, 0, 0), false,
//			new BlockElementFace(Direction.UP, -1, "textures/blank.png",
//					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
//			new BlockElementFace(Direction.DOWN, -1, "textures/blank.png",
//					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
//			new BlockElementFace(Direction.NORTH, -1, "textures/blank.png",
//					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
//			new BlockElementFace(Direction.SOUTH, -1, "textures/blank.png",
//					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
//			new BlockElementFace(Direction.WEST, -1, "textures/blank.png",
//					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
//			new BlockElementFace(Direction.EAST, -1, "textures/blank.png",
//					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
//			null);
//
//	public static CompendiumModelPart debugPart = new CompendiumModelPart(
//			new ArrayList<CompendiumModelPart.Cube>(List.of(cube)), Collections.emptyMap());

	public static void loadModel(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
			int combinedOverlayIn, BlacklistedModel model, float timer) {

		if (model.isBlock) {
			UnbakedModel um = ForgeModelBakery.instance().getModelOrMissing(model.rc);
			if (um instanceof BlockModel) {
				BlockModel bm = (BlockModel) um;

				blockModel(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, bm, model.blacklist,
						model.transform, timer);

			}
		} else {
			Item item = ForgeRegistries.ITEMS.getValue(model.rc);
			itemModel(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, item, model.blacklist,
					model.transform, timer);
		}
	}

	public static void blockModel(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
			int combinedOverlayIn, BlockModel bm, List<Integer> blacklist, AnimationFloatTransform transform,
			float timer) {
		matrixStackIn.pushPose();
		{
			List<CompendiumModelPart> currentModel = convert(bm, blacklist);

			matrixStackIn.translate(transform.getLocation().getX().animate(timer) / 16,
					transform.getLocation().getY().animate(timer) / 16,
					transform.getLocation().getZ().animate(timer) / 16);
			matrixStackIn.mulPose(new Quaternion(transform.getRotation().getX().animate(timer),
					transform.getRotation().getY().animate(timer), transform.getRotation().getZ().animate(timer),
					true));
			matrixStackIn.scale(1f + transform.getScale().getX().animate(timer),
					1f + transform.getScale().getY().animate(timer), 1f + transform.getScale().getZ().animate(timer));
			for (CompendiumModelPart b : currentModel) {
				b.render(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
			}
		}
		matrixStackIn.popPose();

	}

	public static void itemModel(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
			int combinedOverlayIn, Item item, List<Integer> blacklist, AnimationFloatTransform transform, float timer) {
		matrixStackIn.pushPose();
		{
			ItemStack stack = new ItemStack(item);
			ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
			BakedModel bakedmodel = itemRenderer.getModel(stack, null, null, 0);
			// List<CompendiumModelPart> currentModel = convert(bm, blacklist);

			matrixStackIn.translate(
					transform.getLocation().getX().getOffset() + transform.getLocation().getX().animate(timer) / 16,
					transform.getLocation().getY().getOffset() + transform.getLocation().getY().animate(timer) / 16,
					transform.getLocation().getZ().getOffset() + transform.getLocation().getZ().animate(timer) / 16);
			matrixStackIn.mulPose(new Quaternion(
					transform.getRotation().getX().getOffset() + transform.getRotation().getX().animate(timer),
					transform.getRotation().getY().getOffset() + transform.getRotation().getY().animate(timer),
					transform.getRotation().getZ().getOffset() + transform.getRotation().getZ().animate(timer), true));
			matrixStackIn.scale(1f + transform.getScale().getX().animate(timer),
					1f + transform.getScale().getY().animate(timer), 1f + transform.getScale().getZ().animate(timer));
			itemRenderer.render(stack, ItemTransforms.TransformType.GROUND, false, matrixStackIn, bufferIn,
					combinedLightIn, combinedOverlayIn, bakedmodel);

//			RenderUtil.renderItemCustomColor(stack, RenderUtil.argbToHex(255, 0, 0, 255), matrixStackIn, bufferIn, combinedLightIn,
//				combinedOverlayIn, bakedmodel);
		}
		matrixStackIn.popPose();

	}

	public static List<CompendiumModelPart> convert(BlockModel bm, List<Integer> blacklist) {

		List<CompendiumModelPart> mpl = new ArrayList<CompendiumModelPart>();

		for (int i = 0; i < bm.getElements().size(); i++) {
			if (!blacklist.contains(i)) {
				BlockElement e = bm.getElements().get(i);
				List<CompendiumModelPart.Cube> cubeList = new ArrayList<CompendiumModelPart.Cube>();

				CompendiumModelPart.Cube cube = new CompendiumModelPart.Cube(1, 1, e.from, e.to, new Vector3f(0, 0, 0),
						false, e.faces.getOrDefault(Direction.UP, null), e.faces.getOrDefault(Direction.DOWN, null),
						e.faces.getOrDefault(Direction.NORTH, null), e.faces.getOrDefault(Direction.SOUTH, null),
						e.faces.getOrDefault(Direction.WEST, null), e.faces.getOrDefault(Direction.EAST, null),
						bm.textureMap);
				cubeList.add(cube);

				CompendiumModelPart mp = new CompendiumModelPart(cubeList, Collections.emptyMap());

				if (e.rotation != null) {
					switch (e.rotation.axis) {
					case X:
						mp.setRotation(e.rotation.angle, 0, 0);
						break;
					case Y:
						mp.setRotation(0, e.rotation.angle, 0);
						break;
					case Z:
						mp.setRotation(0, 0, e.rotation.angle);
						break;
					default:
						mp.setRotation(0, 0, 0);
						break;
					}
				}

				mpl.add(mp);
			}
		}
		return mpl;
	}
}
