package com.Lance5057.ButcherCraft.core.meathook;

import com.Lance5057.ButcherCraft.Butchercraft;
import com.Lance5057.ButcherCraft.core.meathook.carcassRenderers.ModelCowHooked;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class MeatHookTESR extends TileEntitySpecialRenderer<MeatHookTileEntity> {

	public final ResourceLocation texture = new ResourceLocation(Butchercraft.MODID, "models/Hook.png");

	public final MeatHookModel hook = new MeatHookModel();

	// carcasses
	public final ModelCowHooked cow = new ModelCowHooked();
	public final ResourceLocation cowTexture = new ResourceLocation(Butchercraft.MODID, "models/cowHooked.png");
	public final ResourceLocation cowSkinnedTexture = new ResourceLocation(Butchercraft.MODID,
			"models/cowHookedSkinned.png");
	public final ResourceLocation cowSkinnedDelimbedTexture = new ResourceLocation(Butchercraft.MODID,
			"models/cowHookedSkinnedDelimbed.png");

	@Override
	public void renderTileEntityAt(MeatHookTileEntity te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		GlStateManager.pushMatrix();

		GlStateManager.translate(x, y, z);
		GlStateManager.disableRescaleNormal();

		GlStateManager.rotate(180, 1, 0, 0);
		GlStateManager.translate(0.5, -1.5, -0.75);

		bindTexture(texture);
		// only the last part matters
		hook.doRender();
		if (te.carcassType.compareTo("cow") == 0) {
			GlStateManager.translate(0, 2, 0.4);

			if (te.curStage == 0)
			{
				cow.normalMode();
				bindTexture(cowTexture);
			}
			else if (te.curStage >= 1 && te.curStage < 3)
				bindTexture(cowSkinnedTexture);
			else if (te.curStage == 3)
			{
				GlStateManager.translate(0.0, -0.3, -0.0);
				cow.meatMode();
				bindTexture(cowSkinnedDelimbedTexture);
			}
			cow.doRender();
		}
		GlStateManager.popMatrix();
	}
}
