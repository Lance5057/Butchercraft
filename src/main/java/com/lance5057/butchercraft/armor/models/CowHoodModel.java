package com.lance5057.butchercraft.armor.models;

import com.lance5057.butchercraft.Butchercraft;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class CowHoodModel extends HumanoidModel<LivingEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "cow_hood"), "main");

	public CowHoodModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createLayer(CubeDeformation deformation) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.35F)).texOffs(24, 2)
						.addBox(-6.0F, -10.0F, -0.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 2)
						.addBox(5.0F, -10.0F, -0.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.0F, 0.6F, -0.2618F, 0.0F, 0.0F));

//		head.addOrReplaceChild("head",
//				CubeListBuilder.create().texOffs(0, 0)
//						.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.1F)).texOffs(16, 16)
//						.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)),
//				PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		body.addOrReplaceChild("body_3", CubeListBuilder.create().texOffs(0, 37).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 4.0F,
				6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		body.addOrReplaceChild("body_1", CubeListBuilder.create().texOffs(0, 20).addBox(-10.0F, -1.0F, 0.0F, 20.0F,
				16.0F, 0.1F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.2618F, 0.0F, 0.0F));

		return meshdefinition;
	}
}