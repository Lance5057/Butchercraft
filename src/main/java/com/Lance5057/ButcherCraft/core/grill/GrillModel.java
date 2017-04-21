package com.Lance5057.ButcherCraft.core.grill;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Grill - Undefined Created using Tabula 5.1.0
 */
public class GrillModel extends ModelBase {
	public ModelRenderer GrillAshCatch;
	public ModelRenderer GrillSide2;
	public ModelRenderer GrillSide3;
	public ModelRenderer GrillLeg3;
	public ModelRenderer GrillLeg2;
	public ModelRenderer GrillLeg;
	public ModelRenderer GrillBars;
	public ModelRenderer GrillBottom;
	public ModelRenderer GrillSide1;
	public ModelRenderer GrillSide4;

	public GrillModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.GrillSide2 = new ModelRenderer(this, 0, 0);
		this.GrillSide2.setRotationPoint(-8.0F, 9.0F, -8.0F);
		this.GrillSide2.addBox(0.0F, 0.0F, 0.0F, 16, 4, 1, 0.0F);
		this.GrillSide1 = new ModelRenderer(this, 0, 0);
		this.GrillSide1.setRotationPoint(-8.0F, 9.0F, 7.0F);
		this.GrillSide1.addBox(0.0F, 0.0F, 0.0F, 14, 4, 1, 0.0F);
		this.setRotateAngle(GrillSide1, 0.0F, 1.5707963267948966F, 0.0F);
		this.GrillSide4 = new ModelRenderer(this, 0, 0);
		this.GrillSide4.setRotationPoint(7.0F, 9.0F, 7.0F);
		this.GrillSide4.addBox(0.0F, 0.0F, 0.0F, 14, 4, 1, 0.0F);
		this.setRotateAngle(GrillSide4, 0.0F, 1.5707963267948966F, 0.0F);
		this.GrillLeg3 = new ModelRenderer(this, 0, 24);
		this.GrillLeg3.setRotationPoint(0.0F, 13.5F, 0.0F);
		this.GrillLeg3.addBox(-1.0F, 1.0F, 2.5F, 2, 12, 2, 0.0F);
		this.setRotateAngle(GrillLeg3, 0.2617993877991494F, -2.0943951023931953F, 0.0F);
		this.GrillAshCatch = new ModelRenderer(this, 0, 16);
		this.GrillAshCatch.setRotationPoint(0.0F, 18.0F, 0.0F);
		this.GrillAshCatch.addBox(-3.5F, 0.0F, -3.0F, 7, 1, 7, 0.0F);
		this.GrillBars = new ModelRenderer(this, 15, 16);
		this.GrillBars.setRotationPoint(0.0F, 9.5F, 0.0F);
		this.GrillBars.addBox(-7.0F, 0.0F, -7.0F, 14, 0, 14, 0.0F);
		this.GrillLeg2 = new ModelRenderer(this, 0, 24);
		this.GrillLeg2.setRotationPoint(0.0F, 13.5F, 0.0F);
		this.GrillLeg2.addBox(-1.0F, 1.0F, 2.5F, 2, 12, 2, 0.0F);
		this.setRotateAngle(GrillLeg2, 0.2617993877991494F, 2.0943951023931953F, 0.0F);
		this.GrillSide3 = new ModelRenderer(this, 0, 0);
		this.GrillSide3.setRotationPoint(-8.0F, 9.0F, 7.0F);
		this.GrillSide3.addBox(0.0F, 0.0F, 0.0F, 16, 4, 1, 0.0F);
		this.GrillLeg = new ModelRenderer(this, 0, 24);
		this.GrillLeg.setRotationPoint(0.0F, 13.5F, 0.0F);
		this.GrillLeg.addBox(-1.0F, 1.0F, 2.5F, 2, 12, 2, 0.0F);
		this.setRotateAngle(GrillLeg, 0.2617993877991494F, 0.0F, 0.0F);
		this.GrillBottom = new ModelRenderer(this, 0, 0);
		this.GrillBottom.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.GrillBottom.addBox(-7.0F, 0.0F, -7.0F, 14, 2, 14, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.GrillSide2.render(f5);
		this.GrillSide1.render(f5);
		this.GrillSide4.render(f5);
		this.GrillLeg3.render(f5);
		this.GrillAshCatch.render(f5);
		this.GrillBars.render(f5);
		this.GrillLeg2.render(f5);
		this.GrillSide3.render(f5);
		this.GrillLeg.render(f5);
		this.GrillBottom.render(f5);
	}

	public void doRender(int charcoal, ItemStack[] food, int lit) {
		float f5 = 0.0625F;
		this.GrillSide2.render(f5);
		this.GrillSide1.render(f5);
		this.GrillSide4.render(f5);
		this.GrillLeg3.render(f5);
		this.GrillAshCatch.render(f5);
		this.GrillBars.render(f5);
		this.GrillLeg2.render(f5);
		this.GrillSide3.render(f5);
		this.GrillLeg.render(f5);
		this.GrillBottom.render(f5);

		float rot = 0;
		for (int i = 0; i < charcoal; i++) {
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

			GlStateManager.rotate(180, 0, 0, 1);
			GlStateManager.rotate(90, 1, 0, 0);
			GlStateManager.rotate(rot, 0, 0, 1);
			float s = 0.4f;
			GlStateManager.scale(s, s, s);
			GlStateManager.translate(0.5F, -0.0f, 1.75f);

			Minecraft.getMinecraft().getRenderItem().renderItem(new ItemStack(Items.COAL, 1, 1),
					ItemCameraTransforms.TransformType.NONE);

			GlStateManager.popMatrix();

			rot += 90;
		}
		
		rot = 0;
		for(int i = 0; i < food.length; i++)
		{
			GlStateManager.pushMatrix();
			
			GlStateManager.rotate(180, 0, 0, 1);
			GlStateManager.rotate(90, 1, 0, 0);
			GlStateManager.rotate(rot+45, 0, 0, 1);
			float s = 0.4f;
			GlStateManager.scale(s, s, s);
			GlStateManager.translate(0.75F, -0.0f, 1.4f);
			
			Minecraft.getMinecraft().getRenderItem().renderItem(food[i],
					ItemCameraTransforms.TransformType.NONE);
			GlStateManager.popMatrix();
			
			rot += 90;
		}
		
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
