package com.lance5057.butchercraft.items;

import java.util.List;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftConfig;
import com.lance5057.butchercraft.ButchercraftMobEffects;
import com.lance5057.butchercraft.armor.ApronItem;
import com.lance5057.butchercraft.armor.BootsItem;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;

public class CarcassItem extends Item {

	public CarcassItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
		if (!pLevel.isClientSide && pLevel.getRandom().nextInt() % ButchercraftConfig.CARCASS_EFFECT_CHANCE.get() == 0)
			if (pEntity instanceof Player p) {
				ItemStack boots = p.getInventory().getArmor(0);
				if (boots.getItem() instanceof BootsItem)

					boots.hurtAndBreak(1, p, EquipmentSlot.FEET);
				else
					p.addEffect(new MobEffectInstance(ButchercraftMobEffects.BLOODTRAIL, 3600, 0, false, false, true));

				ItemStack apron = p.getInventory().getArmor(1);
				if (apron.getItem() instanceof ApronItem)
					apron.hurtAndBreak(1, p, EquipmentSlot.LEGS);
				else
					p.addEffect(new MobEffectInstance(ButchercraftMobEffects.BLOODY, 3600, 0, false, false, true));
			}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
			TooltipFlag tooltipFlag) {
		CustomData customdata = stack.getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY);
		if (!customdata.isEmpty()) {
			EntityType<?> type = customdata.read(BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("id")).result()
					.orElse(EntityType.ARROW);
			tooltipComponents
					.add(Component.literal("").append(type.getDescriptionId()).withStyle(ChatFormatting.DARK_PURPLE));
		}

	}
}
