// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class GoatHead<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "goathead"), "main");
	private final ModelPart Head;

	public GoatHead(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(12, 55).addBox(-1.99F, -13.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(0.99F, -13.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 61).mirror().addBox(3.0F, -8.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 61).addBox(-5.0F, -8.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 52).addBox(0.5F, 0.0F, -4.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(34, 46).addBox(-3.0F, -4.0F, -8.0F, 5.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, 2.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition HeadMain = Head.addOrReplaceChild("HeadMain", CubeListBuilder.create().texOffs(34, 46).addBox(-3.0F, -4.0F, -8.0F, 5.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, 2.0F, 0.9599F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}