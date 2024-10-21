package com.lance5057.butchercraft;

import com.lance5057.butchercraft.armor.models.ApronModel;
import com.lance5057.butchercraft.armor.models.BootsModel;
import com.lance5057.butchercraft.armor.models.BunnyEarsModel;
import com.lance5057.butchercraft.armor.models.BunnyTailModel;
import com.lance5057.butchercraft.armor.models.ChickenMaskModel;
import com.lance5057.butchercraft.armor.models.CowHoodModel;
import com.lance5057.butchercraft.armor.models.GlovesModel;
import com.lance5057.butchercraft.armor.models.GoatHoodModel;
import com.lance5057.butchercraft.armor.models.MaskModel;
import com.lance5057.butchercraft.armor.models.PaperHatModel;
import com.lance5057.butchercraft.armor.models.PigHoodModel;
import com.lance5057.butchercraft.armor.models.SheepHoodModel;
import com.lance5057.butchercraft.client.ArmPoses;
import com.lance5057.butchercraft.client.block_models.ChickenHeadModel;
import com.lance5057.butchercraft.client.block_models.ChickenSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.CowHeadModel;
import com.lance5057.butchercraft.client.block_models.CowSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.GoatHeadModel;
import com.lance5057.butchercraft.client.block_models.GoatSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.PigHeadModel;
import com.lance5057.butchercraft.client.block_models.PigSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.RabbitHeadModel;
import com.lance5057.butchercraft.client.block_models.RabbitSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.SheepHeadModel;
import com.lance5057.butchercraft.client.block_models.SheepSkullHeadModel;

import com.lance5057.butchercraft.client.rendering.RenderUtil;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ButchercraftModClientEvents {
//	@SubscribeEvent
//	public static void registerColorHandlers(RegisterColorHandlersEvent.Item event) {
//		event.register((stack, tintIndex) -> {
//			return stack.has(DataComponents.DYED_COLOR) ? stack.get(DataComponents.DYED_COLOR).rgb() : 0xFFFFFF;
//		}, ButchercraftItems.SHEEP_HOOD);
//	}

	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(PaperHatModel.LAYER_LOCATION, () -> LayerDefinition
				.create(PaperHatModel.createLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(ApronModel.LAYER_LOCATION,
				() -> LayerDefinition.create(ApronModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(GlovesModel.LAYER_LOCATION, () -> LayerDefinition
				.create(GlovesModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(BootsModel.LAYER_LOCATION,
				() -> LayerDefinition.create(BootsModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(MaskModel.LAYER_LOCATION,
				() -> LayerDefinition.create(MaskModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(BunnyEarsModel.LAYER_LOCATION, () -> LayerDefinition
				.create(BunnyEarsModel.createLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 16, 16));
		event.registerLayerDefinition(BunnyTailModel.LAYER_LOCATION, () -> LayerDefinition
				.create(BunnyTailModel.createLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 16, 16));
		event.registerLayerDefinition(PigHoodModel.LAYER_LOCATION, () -> LayerDefinition
				.create(PigHoodModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 64));
		event.registerLayerDefinition(GoatHoodModel.LAYER_LOCATION, () -> LayerDefinition
				.create(GoatHoodModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 64));
		event.registerLayerDefinition(CowHoodModel.LAYER_LOCATION, () -> LayerDefinition
				.create(CowHoodModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 64));
		event.registerLayerDefinition(SheepHoodModel.LAYER_LOCATION, () -> LayerDefinition
				.create(SheepHoodModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 64));
		event.registerLayerDefinition(ChickenMaskModel.LAYER_LOCATION, () -> LayerDefinition
				.create(ChickenMaskModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 32));

		event.registerLayerDefinition(CowHeadModel.LAYER_LOCATION, () -> CowHeadModel.createBodyLayer());
		event.registerLayerDefinition(ChickenHeadModel.LAYER_LOCATION, () -> ChickenHeadModel.createBodyLayer());
		event.registerLayerDefinition(SheepHeadModel.LAYER_LOCATION, () -> SheepHeadModel.createBodyLayer());
		event.registerLayerDefinition(PigHeadModel.LAYER_LOCATION, () -> PigHeadModel.createBodyLayer());
		event.registerLayerDefinition(GoatHeadModel.LAYER_LOCATION, () -> GoatHeadModel.createBodyLayer());
		event.registerLayerDefinition(RabbitHeadModel.LAYER_LOCATION, () -> RabbitHeadModel.createBodyLayer());

		event.registerLayerDefinition(CowSkullHeadModel.LAYER_LOCATION, () -> CowSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(SheepSkullHeadModel.LAYER_LOCATION, () -> SheepSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(PigSkullHeadModel.LAYER_LOCATION, () -> PigSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(ChickenSkullHeadModel.LAYER_LOCATION,
				() -> ChickenSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(GoatSkullHeadModel.LAYER_LOCATION, () -> GoatSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(RabbitSkullHeadModel.LAYER_LOCATION,
				() -> RabbitSkullHeadModel.createBodyLayer());
	}

	@SubscribeEvent
	public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(ApronModel.LAYER_LOCATION);
				return new ApronModel(root);
			}

		}, ButchercraftItems.APRON);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(BootsModel.LAYER_LOCATION);
				return new BootsModel(root);
			}
		}, ButchercraftItems.BOOTS);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(BunnyEarsModel.LAYER_LOCATION);
				return new BunnyEarsModel(root);
			}
		}, ButchercraftItems.BLACK_BUNNY_EARS, ButchercraftItems.BROWN_BUNNY_EARS, ButchercraftItems.GOLD_BUNNY_EARS, ButchercraftItems.SALT_BUNNY_EARS, ButchercraftItems.SPLOTCHED_BUNNY_EARS, ButchercraftItems.WHITE_BUNNY_EARS);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(BunnyTailModel.LAYER_LOCATION);
				return new BunnyTailModel(root);
			}
		}, ButchercraftItems.BLACK_BUNNY_TAIL, ButchercraftItems.BROWN_BUNNY_TAIL, ButchercraftItems.GOLD_BUNNY_TAIL, ButchercraftItems.SALT_BUNNY_TAIL, ButchercraftItems.SPLOTCHED_BUNNY_TAIL, ButchercraftItems.WHITE_BUNNY_TAIL);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(ChickenMaskModel.LAYER_LOCATION);
				original.body.visible = true;
				return new ChickenMaskModel(root);
			}
		}, ButchercraftItems.CHICKEN_MASK);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(CowHoodModel.LAYER_LOCATION);
				original.body.visible = true;
				return new CowHoodModel(root);
			}
		}, ButchercraftItems.COW_HOOD);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(GlovesModel.LAYER_LOCATION);
				return new GlovesModel(root);
			}
		}, ButchercraftItems.GLOVES);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(GoatHoodModel.LAYER_LOCATION);
				original.body.visible = true;
				return new GoatHoodModel(root);
			}
		}, ButchercraftItems.GOAT_HOOD);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(MaskModel.LAYER_LOCATION);
				return new MaskModel(root);
			}
		}, ButchercraftItems.MASK);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(PaperHatModel.LAYER_LOCATION);
				return new PaperHatModel(root);
			}
		}, ButchercraftItems.PAPER_HAT);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(PigHoodModel.LAYER_LOCATION);
				original.body.visible = true;

				return new PigHoodModel(root);
			}
		}, ButchercraftItems.PIG_HOOD);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
														  EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(SheepHoodModel.LAYER_LOCATION);
				original.body.visible = true;

				return new SheepHoodModel(root);
			}
		}, ButchercraftItems.SHEEP_HOOD);

		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel.ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand,
													ItemStack itemStack) {
				if (!itemStack.isEmpty()) {
					if (entityLiving.getUsedItemHand() == hand && entityLiving.getUseItemRemainingTicks() > 0) {
						return ArmPoses.SOAP_ENUM_PROXY.getValue();
					}
				}
				return HumanoidModel.ArmPose.ITEM;
			}

			@Override
			public boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm,
												   ItemStack itemInHand, float partialTick, float equipProcess, float swingProcess) {
				float f = player.getUseItemRemainingTicks() - partialTick + 1.0F;
				int i = arm == HumanoidArm.RIGHT ? 1 : -1;
				float i2 = arm == HumanoidArm.RIGHT ? -0.5f : 0.5f;
				poseStack.translate(i * 0.56F, -0.52F, -0.72F);
				float f2 = Mth.abs(Mth.cos(f / 8.0F * (float) Math.PI) * 0.5F);
				if (player.getUseItem() == itemInHand && player.isUsingItem()) {

					poseStack.mulPose(RenderUtil.createQuaternion(0, 90, 0, true));
					poseStack.translate(0.0, f2, i2);

				}
				return true;
			}
		}, ButchercraftItems.SOAP);

		event.registerFluidType(new IClientFluidTypeExtensions() {
			private final ResourceLocation STILL = ResourceLocation.withDefaultNamespace("block/water_still");
			private final ResourceLocation FLOW = ResourceLocation.withDefaultNamespace("block/water_flow");
			private final ResourceLocation OVERLAY = ResourceLocation.withDefaultNamespace("block/water_still");
			private final ResourceLocation VIEW_OVERLAY = ResourceLocation.withDefaultNamespace("textures/block/water_still.png");

			@Override
			public ResourceLocation getStillTexture() {
				return STILL;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return FLOW;
			}

			@Override
			public ResourceLocation getOverlayTexture() {
				return OVERLAY;
			}

			@Override
			public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
				return VIEW_OVERLAY;
			}

			@Override
			public int getTintColor() {
				return 0xAF540A04;
			}

			@Override
			public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
													int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
				int color = this.getTintColor();
				return new Vector3f((color >> 16 & 0xFF) / 255F, (color >> 8 & 0xFF) / 255F, (color & 0xFF) / 255F);
			}

			@Override
			public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance,
										float partialTick, float nearDistance, float farDistance, FogShape shape) {
				nearDistance = -48F;
				farDistance = 24F;

				if (farDistance > renderDistance) {
					farDistance = renderDistance;
					shape = FogShape.CYLINDER;
				}

				RenderSystem.setShaderFogStart(nearDistance);
				RenderSystem.setShaderFogEnd(farDistance);
				RenderSystem.setShaderFogShape(shape);
			}
		}, ButchercraftFluids.BLOOD.TYPE);
	}
}
