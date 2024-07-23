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

public class ChickenMaskModel extends HumanoidModel<LivingEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "chicken_mask"), "main");

	public ChickenMaskModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createLayer(CubeDeformation deformation) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.0F, -6.0F, -7.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(14, 4)
						.addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(14, 0)
						.addBox(-2.0F, -4.0F, -8.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition mask_r1 = bb_main.addOrReplaceChild("mask_r1",
				CubeListBuilder.create().texOffs(40, 0).mirror()
						.addBox(-2.0503F, -10.5F, 6.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, -3.5F, -1.5F, -2.8567F, -0.274F, 2.3166F));

		PartDefinition mask_r2 = bb_main.addOrReplaceChild("mask_r2",
				CubeListBuilder.create().texOffs(40, 0).mirror()
						.addBox(-1.116F, -10.0F, 6.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, -3.5F, -1.0F, -3.1416F, -0.3927F, 3.1416F));

		PartDefinition mask_r3 = bb_main.addOrReplaceChild("mask_r3",
				CubeListBuilder.create().texOffs(40, 0).mirror()
						.addBox(-3.067F, -11F, 6.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, -3.5F, -1.0F, -2.7489F, 0.0F, 1.5708F));

		PartDefinition mask_r4 = bb_main.addOrReplaceChild("mask_r4",
				CubeListBuilder.create().texOffs(40, 0).mirror()
						.addBox(-3.067F, -11F, -6.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.0F, -3.5F, -1.0F, -0.3927F, 0.0F, 1.5708F));

		PartDefinition mask_r5 = bb_main.addOrReplaceChild("mask_r5",
				CubeListBuilder.create().texOffs(40, 0).mirror()
						.addBox(-1.116F, -10F, -6.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.0F, -3.5F, -1.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition mask_r6 = bb_main.addOrReplaceChild("mask_r6",
				CubeListBuilder.create().texOffs(40, 0).mirror()
						.addBox(-2.0503F, -10.5F, -6.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.0F, -3.5F, -1.5F, -0.2849F, -0.274F, 0.8249F));

		return meshdefinition;
	}
}