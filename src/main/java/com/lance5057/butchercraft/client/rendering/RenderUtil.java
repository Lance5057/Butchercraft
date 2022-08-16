package com.lance5057.butchercraft.client.rendering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockElementFace;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ForgeHooksClient;

public class RenderUtil {

	public static int argbToHex(int r, int g, int b, int a) {
		return (a << 24) | (r << 16) | (g << 8) | (b);
	}

	public static void renderItemCustomColor(ItemStack stack, int color, PoseStack ms,
			MultiBufferSource buffers, int light, int overlay, @Nullable BakedModel model) {
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

	public static CompendiumModelPart.Cube cube = new CompendiumModelPart.Cube(1, 1, new Vector3f(0, 0, 0),
			new Vector3f(1, 1, 1), new Vector3f(0, 0, 0), false,
			new BlockElementFace(Direction.UP, -1, "textures/blank.png",
					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
			new BlockElementFace(Direction.DOWN, -1, "textures/blank.png",
					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
			new BlockElementFace(Direction.NORTH, -1, "textures/blank.png",
					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
			new BlockElementFace(Direction.SOUTH, -1, "textures/blank.png",
					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
			new BlockElementFace(Direction.WEST, -1, "textures/blank.png",
					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
			new BlockElementFace(Direction.EAST, -1, "textures/blank.png",
					new BlockFaceUV(new float[] { 0, 0, 1, 1 }, 0)),
			null);
	
	public static CompendiumModelPart debugPart = new CompendiumModelPart(new ArrayList<CompendiumModelPart.Cube>(List.of(cube)), Collections.emptyMap());
}
