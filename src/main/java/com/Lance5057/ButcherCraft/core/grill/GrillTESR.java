package com.Lance5057.ButcherCraft.core.grill;

import com.Lance5057.ButcherCraft.Butchercraft;
import com.Lance5057.ButcherCraft.core.meathook.carcassRenderers.ModelCowHooked;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;

public class GrillTESR extends TileEntitySpecialRenderer<GrillTileEntity> {

	public final ResourceLocation texture = new ResourceLocation(Butchercraft.MODID, "models/grill.png");

	public final GrillModel grill = new GrillModel();
	
	@Override
	public void renderTileEntityAt(GrillTileEntity te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		GlStateManager.pushMatrix();

		GlStateManager.translate(x, y, z);
		GlStateManager.disableRescaleNormal();

		GlStateManager.rotate(180, 1, 0, 0);
		GlStateManager.translate(0.5, -1.5, -0.5);

		bindTexture(texture);
		grill.doRender(te.charcoal, te.food, te.timer);
		
		GlStateManager.popMatrix();
	}
}
