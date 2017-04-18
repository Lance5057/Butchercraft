package com.Lance5057.ButcherCraft.core.meathook;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class MeatHookTESR extends TileEntitySpecialRenderer<MeatHookTileEntity>{
	@Override
    public void renderTileEntityAt(MeatHookTileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
        GlStateManager.pushMatrix();

        // Translate to the location of our tile entity
        GlStateManager.translate(x, y, z);
        GlStateManager.disableRescaleNormal();
        
        

        GlStateManager.popMatrix();

    }
}
