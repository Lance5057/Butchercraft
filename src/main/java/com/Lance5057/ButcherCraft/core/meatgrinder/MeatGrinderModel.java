package com.Lance5057.ButcherCraft.core.meatgrinder;

import com.Lance5057.ButcherCraft.BCItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * MeatGrinder - Undefined Created using Tabula 5.1.0
 */
public class MeatGrinderModel extends ModelBase {
	public ModelRenderer TubeEnd;
	public ModelRenderer Tube;
	public ModelRenderer SausageTip;
	public ModelRenderer Base;
	public ModelRenderer BaseAttach;
	public ModelRenderer Funnel;
	public ModelRenderer Funnel_1;
	public ModelRenderer Funnel_2;
	public ModelRenderer GrindTip;
	public ModelRenderer Sausage;
	public ModelRenderer Meat;
	public ModelRenderer SausageEnd;

	public MeatGrinderModel() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.Funnel = new ModelRenderer(this, 20, 18);
		this.Funnel.setRotationPoint(-7.0F, 13.0F, -1.5F);
		this.Funnel.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.SausageTip = new ModelRenderer(this, 50, 0);
		this.SausageTip.setRotationPoint(4.5F, 15.5F, -1.0F);
		this.SausageTip.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
		this.BaseAttach = new ModelRenderer(this, 16, 11);
		this.BaseAttach.setRotationPoint(-8.0F, 19.0F, -1.0F);
		this.BaseAttach.addBox(0.0F, 0.0F, 0.0F, 8, 3, 2, 0.0F);
		this.Funnel_2 = new ModelRenderer(this, 16, 16);
		this.Funnel_2.setRotationPoint(-8.0F, 11.0F, -2.5F);
		this.Funnel_2.addBox(0.0F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.setRotationPoint(-8.0F, 22.0F, -2.5F);
		this.Base.addBox(0.0F, 0.0F, 0.0F, 12, 2, 5, 0.0F);
		this.GrindTip = new ModelRenderer(this, 52, 4);
		this.GrindTip.setRotationPoint(3.7F, 14.0F, -2.5F);
		this.GrindTip.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Tube = new ModelRenderer(this, 0, 22);
		this.Tube.setRotationPoint(-8.0F, 14.0F, -2.5F);
		this.Tube.addBox(0.0F, 0.0F, 0.0F, 12, 5, 5, 0.0F);
		this.SausageEnd = new ModelRenderer(this, 60, 30);
		this.SausageEnd.setRotationPoint(9.0F, 1.0F, 1.0F);
		this.SausageEnd.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.Meat = new ModelRenderer(this, 44, 16);
		this.Meat.setRotationPoint(3.7F, 14.5F, -2.0F);
		this.Meat.addBox(0.0F, 0.0F, 0.0F, 6, 4, 4, 0.0F);
		this.TubeEnd = new ModelRenderer(this, 0, 10);
		this.TubeEnd.setRotationPoint(2.5F, 13.5F, -3.0F);
		this.TubeEnd.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Funnel_1 = new ModelRenderer(this, 18, 17);
		this.Funnel_1.setRotationPoint(-7.5F, 12.0F, -2.0F);
		this.Funnel_1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
		this.Sausage = new ModelRenderer(this, 40, 26);
		this.Sausage.setRotationPoint(4.5F, 15.0F, -1.5F);
		this.Sausage.addBox(0.0F, 0.0F, 0.0F, 9, 3, 3, 0.0F);
		this.Sausage.addChild(this.SausageEnd);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.Funnel.render(f5);
		this.SausageTip.render(f5);
		this.BaseAttach.render(f5);
		this.Funnel_2.render(f5);
		this.Base.render(f5);
		this.GrindTip.render(f5);
		this.Tube.render(f5);
		this.Meat.render(f5);
		this.TubeEnd.render(f5);
		this.Funnel_1.render(f5);
		this.Sausage.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void doRender(ItemStack extruder, boolean casing, boolean loaded, int completion, ItemStack grindItem) {
		float f5 = 0.0625F;
		this.Funnel.render(f5);
		this.BaseAttach.render(f5);
		this.Funnel_2.render(f5);
		this.Base.render(f5);
		this.Tube.render(f5);
		this.TubeEnd.render(f5);
		this.Funnel_1.render(f5);

		if (extruder.getItem() == BCItems.grindTip) {
			this.GrindTip.render(f5);
			if (completion > 0)
				renderMeat(completion, Meat, f5);
		}
		if (extruder.getItem() == BCItems.sausageTip) {
			this.SausageTip.render(f5);
			if (casing)
				this.Sausage.render(f5);
		}
		if(grindItem.getItem() != Items.AIR)
		{
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			
			GlStateManager.rotate(180, 0, 0, 1);
			float s = 0.4f;
			GlStateManager.scale(s, s, s);
			GlStateManager.translate(0.9F, -1.5f - (((float)completion/100)), 0);
			
			Minecraft.getMinecraft().getRenderItem().renderItem(grindItem, ItemCameraTransforms.TransformType.NONE);
			GlStateManager.popMatrix();
		}
	}
	
	public void renderMeat(float completion, ModelRenderer meat, float f5)
	{
		GlStateManager.pushMatrix();
		float comp = completion/150;
		GlStateManager.translate(comp-0.6F, 0F, 0F);
		meat.render(f5);
		GlStateManager.popMatrix();
	}
}
