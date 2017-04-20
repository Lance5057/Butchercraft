package com.Lance5057.ButcherCraft.core.meathook.carcassRenderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelCow - Either Mojang or a mod author
 * Created using Tabula 5.1.0
 */
public class ModelCowHooked extends ModelBase {
    public ModelRenderer Body_Cow;
    public ModelRenderer Head_Cow;
    public ModelRenderer Udder_Cow;
    public ModelRenderer LegLB_Cow;
    public ModelRenderer LegRB_Cow;
    public ModelRenderer LegRF_Cow;
    public ModelRenderer LegLF_Cow;
    public ModelRenderer HornL_Cow;
    public ModelRenderer HornR_Cow;

    public ModelCowHooked() {
        normalMode();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body_Cow.render(f5);
    }
    
    public void doRender()
    {
    	this.Body_Cow.render(0.0625F);
    }
    
    public void meatMode()
    {
    	this.textureWidth = 64;
        this.textureHeight = 32;
        this.LegLB_Cow = new ModelRenderer(this, 0, 16);
        this.LegLB_Cow.setRotationPoint(4.0F, 5.0F, -7.0F);
        this.LegLB_Cow.addBox(-2.1F, -6.0F, 1.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegLB_Cow, 0.04434609527920614F, 0.0F, 0.0F);
        this.LegRB_Cow = new ModelRenderer(this, 0, 16);
        this.LegRB_Cow.setRotationPoint(-4.0F, 5.0F, -7.0F);
        this.LegRB_Cow.addBox(-1.9F, -6.0F, 1.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegRB_Cow, 0.04434609527920614F, 0.0F, 0.0F);
        this.HornR_Cow = new ModelRenderer(this, 22, 0);
        this.HornR_Cow.setRotationPoint(-5.0F, -5.0F, -3.0F);
        this.HornR_Cow.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.LegLF_Cow = new ModelRenderer(this, 0, 16);
        this.LegLF_Cow.setRotationPoint(4.0F, -8.0F, -7.0F);
        this.LegLF_Cow.addBox(-2.1F, -9.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegLF_Cow, -2.141592653589793F, 0.0F, 0.0F);
        this.Head_Cow = new ModelRenderer(this, 0, 0);
        this.Head_Cow.setRotationPoint(0.0F, -11.0F, 0.0F);
        this.Head_Cow.addBox(-4.0F, 0.0F, -3.0F, 8, 8, 6, 0.0F);
        this.setRotateAngle(Head_Cow, -0.3853981633974483F, 0.0F, 0.0F);
        this.HornL_Cow = new ModelRenderer(this, 22, 0);
        this.HornL_Cow.setRotationPoint(4.0F, -5.0F, -3.0F);
        this.HornL_Cow.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.Body_Cow = new ModelRenderer(this, 18, 4);
        this.Body_Cow.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Body_Cow.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.setRotateAngle(Body_Cow, 3.141592653589793F, 0.0F, 0.0F);
        this.LegRF_Cow = new ModelRenderer(this, 0, 16);
        this.LegRF_Cow.setRotationPoint(-4.0F, -8.0F, -7.0F);
        this.LegRF_Cow.addBox(-1.9F, -9.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegRF_Cow, -2.141592653589793F, 0.0F, 0.0F);
        this.Udder_Cow = new ModelRenderer(this, 52, 0);
        this.Udder_Cow.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Udder_Cow.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
        this.Body_Cow.addChild(this.LegLB_Cow);
        this.Body_Cow.addChild(this.LegRB_Cow);
        this.Head_Cow.addChild(this.HornR_Cow);
        this.Body_Cow.addChild(this.LegLF_Cow);
        this.Body_Cow.addChild(this.Head_Cow);
        this.Head_Cow.addChild(this.HornL_Cow);
        this.Body_Cow.addChild(this.LegRF_Cow);
        this.Body_Cow.addChild(this.Udder_Cow);
    }
    
    public void normalMode()
    {
    	this.textureWidth = 64;
        this.textureHeight = 32;
        this.LegLB_Cow = new ModelRenderer(this, 0, 16);
        this.LegLB_Cow.setRotationPoint(4.0F, 5.0F, -7.0F);
        this.LegLB_Cow.addBox(-2.1F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegLB_Cow, 0.24434609527920614F, 0.0F, 0.0F);
        this.LegRB_Cow = new ModelRenderer(this, 0, 16);
        this.LegRB_Cow.setRotationPoint(-4.0F, 5.0F, -7.0F);
        this.LegRB_Cow.addBox(-1.9F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegRB_Cow, 0.24434609527920614F, 0.0F, 0.0F);
        this.HornR_Cow = new ModelRenderer(this, 22, 0);
        this.HornR_Cow.setRotationPoint(-5.0F, -5.0F, -3.0F);
        this.HornR_Cow.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.LegLF_Cow = new ModelRenderer(this, 0, 16);
        this.LegLF_Cow.setRotationPoint(4.0F, -8.0F, -7.0F);
        this.LegLF_Cow.addBox(-2.1F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegLF_Cow, -3.141592653589793F, 0.0F, 0.0F);
        this.Head_Cow = new ModelRenderer(this, 0, 0);
        this.Head_Cow.setRotationPoint(0.0F, -11.0F, 0.0F);
        this.Head_Cow.addBox(-4.0F, -4.0F, -5.0F, 8, 8, 6, 0.0F);
        this.setRotateAngle(Head_Cow, -0.7853981633974483F, 0.0F, 0.0F);
        this.HornL_Cow = new ModelRenderer(this, 22, 0);
        this.HornL_Cow.setRotationPoint(4.0F, -5.0F, -3.0F);
        this.HornL_Cow.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.Body_Cow = new ModelRenderer(this, 18, 4);
        this.Body_Cow.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Body_Cow.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.setRotateAngle(Body_Cow, 3.141592653589793F, 0.0F, 0.0F);
        this.LegRF_Cow = new ModelRenderer(this, 0, 16);
        this.LegRF_Cow.setRotationPoint(-4.0F, -8.0F, -7.0F);
        this.LegRF_Cow.addBox(-1.9F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegRF_Cow, -3.141592653589793F, 0.0F, 0.0F);
        this.Udder_Cow = new ModelRenderer(this, 52, 0);
        this.Udder_Cow.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Udder_Cow.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
        this.Body_Cow.addChild(this.LegLB_Cow);
        this.Body_Cow.addChild(this.LegRB_Cow);
        this.Head_Cow.addChild(this.HornR_Cow);
        this.Body_Cow.addChild(this.LegLF_Cow);
        this.Body_Cow.addChild(this.Head_Cow);
        this.Head_Cow.addChild(this.HornL_Cow);
        this.Body_Cow.addChild(this.LegRF_Cow);
        this.Body_Cow.addChild(this.Udder_Cow);
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
