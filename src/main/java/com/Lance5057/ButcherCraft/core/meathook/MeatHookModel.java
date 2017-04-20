package com.Lance5057.ButcherCraft.core.meathook;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelCow - Either Mojang or a mod author
 * Created using Tabula 5.1.0
 */
public class MeatHookModel extends ModelBase {
    public ModelRenderer HookBase;
    public ModelRenderer HookSideR;
    public ModelRenderer HookSideL;
    public ModelRenderer HookCenter;
    public ModelRenderer HookL;
    public ModelRenderer HookR;

    public MeatHookModel() {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.HookBase = new ModelRenderer(this, 0, 0);
        this.HookBase.setRotationPoint(0.0F, 8.0F, 4.0F);
        this.HookBase.addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
        this.HookL = new ModelRenderer(this, 4, -4);
        this.HookL.setRotationPoint(4.0F, 4.0F, -1.5F);
        this.HookL.addBox(-0.5F, 0.0F, -0.5F, 0, 6, 4, 0.0F);
        this.HookSideL = new ModelRenderer(this, 0, 0);
        this.HookSideL.setRotationPoint(0.0F, 1.6F, 0.0F);
        this.HookSideL.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
        this.setRotateAngle(HookSideL, 0.0F, 0.0F, -1.1344640137963142F);
        this.HookCenter = new ModelRenderer(this, 0, 0);
        this.HookCenter.setRotationPoint(6.0F, 4.5F, 0.0F);
        this.HookCenter.addBox(-0.5F, 0.0F, -0.5F, 1, 12, 1, 0.0F);
        this.setRotateAngle(HookCenter, 0.0F, 0.0F, 1.5707963267948966F);
        this.HookSideR = new ModelRenderer(this, 0, 0);
        this.HookSideR.setRotationPoint(0.0F, 1.6F, 0.0F);
        this.HookSideR.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
        this.setRotateAngle(HookSideR, 0.0F, 0.0F, 1.1344640137963142F);
        this.HookR = new ModelRenderer(this, 4, -4);
        this.HookR.setRotationPoint(-4.0F, 4.0F, -1.5F);
        this.HookR.addBox(-0.5F, 0.0F, -0.5F, 0, 6, 4, 0.0F);
        this.HookBase.addChild(this.HookL);
        this.HookBase.addChild(this.HookSideL);
        this.HookBase.addChild(this.HookCenter);
        this.HookBase.addChild(this.HookSideR);
        this.HookBase.addChild(this.HookR);
    }

    public void doRender() { 
        this.HookBase.render(0.0625F);
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
