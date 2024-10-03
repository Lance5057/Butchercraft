package com.lance5057.butchercraft.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.neoforged.neoforge.client.IArmPoseTransformer;

public class ArmPoses {
	public static void soap(HumanoidModel<?> model, LivingEntity entity, HumanoidArm arm) {
		float f = entity.getUseItemRemainingTicks();
		float f2 = Mth.abs(Mth.cos(f / 6.0F * (float) Math.PI) * 1.5F);
		if (arm == HumanoidArm.RIGHT) {
			model.rightArm.yRot = -45;
			model.rightArm.xRot = f2 - 45;
			model.leftArm.xRot = -135;
		} else {
			model.leftArm.yRot = 45;
			model.leftArm.xRot = f2 - 45;
			model.rightArm.xRot = -135;
		}
	};

	public static final EnumProxy<HumanoidModel.ArmPose> SOAP_ENUM_PROXY = new EnumProxy<>(HumanoidModel.ArmPose.class,
			true, (IArmPoseTransformer) ArmPoses::soap);

}
