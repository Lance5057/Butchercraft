package com.lance5057.butchercraft.armor;

import java.util.function.Consumer;

import com.lance5057.butchercraft.armor.models.GlovesModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class GlovesItem extends ArmorItem {
	public GlovesItem(ArmorMaterial pMaterial, Properties pProperties) {
		super(pMaterial, Type.CHESTPLATE, pProperties);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {

			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot,
					HumanoidModel<?> defaultModel) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(GlovesModel.LAYER_LOCATION);
				return new GlovesModel(root);
			}

		});
	}

}
