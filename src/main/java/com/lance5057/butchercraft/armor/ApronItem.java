package com.lance5057.butchercraft.armor;

import java.util.function.Consumer;

import com.lance5057.butchercraft.armor.models.ApronModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class ApronItem extends ArmorItem {
	public ApronItem(Holder<ArmorMaterial> pMaterial, Properties pProperties) {
		super(pMaterial, Type.LEGGINGS, pProperties);
		
		
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {

			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
					EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(ApronModel.LAYER_LOCATION);
				return new ApronModel(root);
			}

		});
	}

}
