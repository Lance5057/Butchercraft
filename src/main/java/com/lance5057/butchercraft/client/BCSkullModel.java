package com.lance5057.butchercraft.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BCSkullModel extends SkullModelBase {
	private final ModelPart root;
	protected final ModelPart head;

	public BCSkullModel(ModelPart pRoot) {
		this.root = pRoot;
		this.head = pRoot.getChild("head");
	}

	public static MeshDefinition createHeadModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
		return meshdefinition;
	}

	@Override
	public void setupAnim(float p_103811_, float p_103812_, float p_103813_) {
		this.head.yRot = p_103812_ * ((float) Math.PI / 180F);
		this.head.xRot = p_103813_ * ((float) Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
	}

}
