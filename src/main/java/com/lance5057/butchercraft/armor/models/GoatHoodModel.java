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

public class GoatHoodModel extends HumanoidModel<LivingEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(Butchercraft.MOD_ID, "goat_hood"), "main");

	public GoatHoodModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createLayer(CubeDeformation deformation) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head2 = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(12, 55)
						.addBox(-2.49F, -13, -6F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(12, 55)
						.addBox(0.49F, -13, -6F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(2, 61).mirror()
						.addBox(2.5F, -9, -6F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(2, 61)
						.addBox(-5.5F, -9, -6F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 52)
						.addBox(0.0F, 0F, -10F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.3882F, -3.7717F));

		Head2.addOrReplaceChild("HeadMain", CubeListBuilder.create().texOffs(34, 46).addBox(-3.5F, -6.5416F, 6.0904F,
				5.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 7F, -10F, 0.9599F, 0.0F, 0.0F));

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