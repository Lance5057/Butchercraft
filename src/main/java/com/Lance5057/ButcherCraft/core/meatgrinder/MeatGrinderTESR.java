package com.Lance5057.ButcherCraft.core.meatgrinder;

import com.Lance5057.ButcherCraft.Butchercraft;
import com.Lance5057.ButcherCraft.core.meathook.carcassRenderers.ModelCowHooked;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class MeatGrinderTESR extends TileEntitySpecialRenderer<MeatGrinderTileEntity> {

	public final ResourceLocation texture = new ResourceLocation(Butchercraft.MODID, "models/meatgrinder.png");
	public final ResourceLocation handleTexture = new ResourceLocation(Butchercraft.MODID, "models/meatgrinderhandle.png");

	public final MeatGrinderModel grinder = new MeatGrinderModel();
	public final MeatGrinderHandleModel handle = new MeatGrinderHandleModel();

	@Override
	public void renderTileEntityAt(MeatGrinderTileEntity te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		GlStateManager.pushMatrix();

		GlStateManager.translate(x, y, z);
		GlStateManager.disableRescaleNormal();

		GlStateManager.rotate(180, 1, 0, 0);
		GlStateManager.translate(0.5, -1.5, -0.5);

		bindTexture(texture);
		grinder.doRender(te.extruderItem, te.casing, te.loaded, te.completion, te.grindItem);
		
		GlStateManager.translate(-1F, 0F, 0F);
		
		bindTexture(handleTexture);
		handle.doRender(te.handleRot);
		
		GlStateManager.popMatrix();
	}
}
