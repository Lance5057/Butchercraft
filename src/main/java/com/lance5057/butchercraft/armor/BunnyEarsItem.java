package com.lance5057.butchercraft.armor;

import com.lance5057.butchercraft.armor.models.BunnyEarsModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class BunnyEarsItem extends TemptArmor implements IClientItemExtensions {
	public BunnyEarsItem(Holder<ArmorMaterial> pMaterial, Properties pProperties) { 
		super(pMaterial, Type.HELMET, pProperties);
	}

	@Override
	public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
		EntityModelSet models = Minecraft.getInstance().getEntityModels();
		ModelPart root = models.bakeLayer(BunnyEarsModel.LAYER_LOCATION);
		return new BunnyEarsModel(root);
	}

}
