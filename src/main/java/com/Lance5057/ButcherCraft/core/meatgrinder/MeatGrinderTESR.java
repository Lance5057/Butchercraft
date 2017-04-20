package com.Lance5057.ButcherCraft.core.meatgrinder;

import com.Lance5057.ButcherCraft.Butchercraft;
import com.Lance5057.ButcherCraft.core.meathook.carcassRenderers.ModelCowHooked;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class MeatGrinderTESR extends TileEntitySpecialRenderer<MeatGrinderTileEntity> {

	public final ResourceLocation texture = new ResourceLocation(Butchercraft.MODID, "models/Hook.png");

	public final MeatGrinderModel hook = new MeatGrinderModel();

	// carcasses
	public final ModelCowHooked cow = new ModelCowHooked();
	public final ResourceLocation cowTexture = new ResourceLocation(Butchercraft.MODID, "models/cowHooked.png");


	@Override
	public void renderTileEntityAt(MeatGrinderTileEntity te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		GlStateManager.pushMatrix();

		GlStateManager.translate(x, y, z);
		GlStateManager.disableRescaleNormal();

		GlStateManager.rotate(180, 1, 0, 0);
		GlStateManager.translate(0.5, -1.5, -0.75);

		bindTexture(texture);
		// only the last part matters
		hook.doRender();
		if (te.carcassType.compareTo("cow") == 0)
		{
			GlStateManager.translate(0, 2, 0.4);
			
			bindTexture(cowTexture);
			cow.doRender();
		}
		GlStateManager.popMatrix();
	}
}
