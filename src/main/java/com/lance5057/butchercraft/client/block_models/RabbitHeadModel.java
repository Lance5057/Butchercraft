package com.lance5057.butchercraft.client.block_models;

import com.lance5057.butchercraft.Butchercraft;

import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class RabbitHeadModel extends SkullModel {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "rabbithead"), "main");

	public RabbitHeadModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(32, 0).mirror()
						.addBox(-2.5F, -4.0F, -2.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-0.5F, 0.0F, 0.0F));

		head.addOrReplaceChild("earRight",
				CubeListBuilder.create().texOffs(58, 0).mirror()
						.addBox(-2.5F, -9.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.0F, -0.2618F, 0.0F));

		head.addOrReplaceChild("earLeft",
				CubeListBuilder.create().texOffs(52, 0).mirror()
						.addBox(0.5F, -9.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.0F, 0.2618F, 0.0F));

		head.addOrReplaceChild("nose",
				CubeListBuilder.create().texOffs(32, 9).mirror()
						.addBox(-0.5F, -2.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}