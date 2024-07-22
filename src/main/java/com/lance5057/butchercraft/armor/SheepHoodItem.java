package com.lance5057.butchercraft.armor;

import com.lance5057.butchercraft.armor.models.SheepHoodModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class SheepHoodItem extends ArmorItem implements IClientItemExtensions {
	public SheepHoodItem(Holder<ArmorMaterial> pMaterial, Properties pProperties) {
		super(pMaterial, Type.HELMET, pProperties);
	}

	@Override
	public int getColor(ItemStack pStack) {
		CompoundTag compoundtag = pStack.getTagElement("display");
		return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : 0xFFFFFF;
	}

	@Override
	public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
		EntityModelSet models = Minecraft.getInstance().getEntityModels();
		ModelPart root = models.bakeLayer(SheepHoodModel.LAYER_LOCATION);
		original.body.visible = true;

		return new SheepHoodModel(root);
	}

}