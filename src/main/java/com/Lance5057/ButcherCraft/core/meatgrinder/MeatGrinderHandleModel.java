package com.Lance5057.ButcherCraft.core.meatgrinder;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * MeatGrinderHandle - Undefined
 * Created using Tabula 5.1.0
 */
public class MeatGrinderHandleModel extends ModelBase {
    public ModelRenderer Bolt;
    public ModelRenderer Handle1;
    public ModelRenderer Handle2;
    public ModelRenderer Handle3;
    public ModelRenderer Knob;

    public MeatGrinderHandleModel() {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.Bolt = new ModelRenderer(this, 0, 0);
        this.Bolt.setRotationPoint(-2.0F, -2F, -2.0F);
        this.Bolt.addBox(0.0F, 0.0F, 0.0F, 2, 4, 4, 0.0F);
        this.Handle1 = new ModelRenderer(this, 0, 8);
        this.Handle1.setRotationPoint(-2.0F, 2.0F, 2.0F);
        this.Handle1.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(Handle1, 1.5707963267948966F, 0.0F, 0.0F);
        this.Handle2 = new ModelRenderer(this, 12, 0);
        this.Handle2.setRotationPoint(0.5F, 1.0F, 0.5F);
        this.Handle2.addBox(0.0F, -1.0F, -1.0F, 1, 10, 1, 0.0F);
        this.setRotateAngle(Handle2, 0.0F, 0.0F, 0.4363323129985824F);
        this.Handle3 = new ModelRenderer(this, 0, 12);
        this.Handle3.setRotationPoint(-0.8F, 9.8F, 0.0F);
        this.Handle3.addBox(0.0F, -1.0F, -1.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(Handle3, 0.0F, 0.0F, -0.4363323129985824F);
        this.Knob = new ModelRenderer(this, 6, 10);
        this.Knob.setRotationPoint(-1.8F, -0.5F, -0.5F);
        this.Knob.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Bolt.addChild(this.Handle1);
        this.Handle1.addChild(this.Handle2);
        this.Handle2.addChild(this.Handle3);
        this.Handle3.addChild(this.Knob);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Bolt.render(f5);
    }
    
    public void doRender(float rot)
    {
    	GlStateManager.translate(0.5f, 1.0f, 0f);
    	GlStateManager.rotate(rot, 1, 0, 0);
    	this.Bolt.render(0.0625F);
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
