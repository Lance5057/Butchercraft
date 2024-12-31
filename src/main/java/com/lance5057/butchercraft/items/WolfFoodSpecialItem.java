package com.lance5057.butchercraft.items;

import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class WolfFoodSpecialItem extends Item {

	Holder<MobEffect> effect;

	public WolfFoodSpecialItem(Properties properties, Holder<MobEffect> effect) {
		super(properties);
		this.effect = effect;
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget,
			InteractionHand usedHand) {
		if (interactionTarget instanceof Wolf w) {
			w.addEffect(new MobEffectInstance(effect, 12000, 1));
			stack.shrink(1);
			w.isShaking = true;
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
