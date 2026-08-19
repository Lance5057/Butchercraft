package com.lance5057.butchercraft.items;

import java.util.List;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftConfig;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.ButchercraftMobEffects;
import com.lance5057.butchercraft.tags.ButchercraftEntityTags;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.neoforged.neoforge.common.IShearable;

public class ButcherKnifeItem extends KnifeItem {

	public ButcherKnifeItem(Properties builderIn) {
		super(builderIn);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
			InteractionHand hand) {

		if (entity.hasEffect(ButchercraftMobEffects.BLOODLUST))
			return InteractionResult.FAIL;
		if (entity instanceof IShearable target) {
			if (entity.level().isClientSide)
				return net.minecraft.world.InteractionResult.SUCCESS;
			BlockPos pos = new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ());
			if (target.isShearable(player, stack, entity.level(), pos)) {
				java.util.List<ItemStack> drops = target.onSheared(player, stack, entity.level(), pos);
				java.util.Random rand = new java.util.Random();
				drops.forEach(d -> {
					net.minecraft.world.entity.item.ItemEntity ent = entity.spawnAtLocation(d, 1.0F);
					ent.setDeltaMovement(
							ent.getDeltaMovement().add((double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F),
									(double) (rand.nextFloat() * 0.05F),
									(double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
				});
			}
		}

		if (!entity.level().isClientSide) {

			if (entity.getType().is(ButchercraftEntityTags.CARCASSES) && entity instanceof Mob mob) {
				if (entity.getType().is(ButchercraftEntityTags.HOSTILE)) {
					if (mob.getHealth() < ButchercraftConfig.HOSTILE_HEALTH.get()) {
						return killAndDrop(player, mob);
					}
				} else
					return killAndDrop(player, mob);
			}
		}

		return InteractionResult.CONSUME;
	}

	public InteractionResult killAndDrop(Player player, Mob mob) {
		if (!mob.isBaby()) {
			if (!mob.isDeadOrDying()) {
				player.level().playSound(null, mob.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP,
						SoundSource.PLAYERS, 1.0F, 1.0F);
				mob.lootTable = BuiltInLootTables.EMPTY;

				ItemStack carcass = new ItemStack(ButchercraftItems.CARCASS.get());

				CompoundTag tag = new CompoundTag();
				mob.save(tag);

				carcass.set(DataComponents.ENTITY_DATA, CustomData.of(tag));

				mob.spawnAtLocation(carcass);
				mob.setLastHurtByPlayer(player);
				mob.hurt(player.damageSources().playerAttack(player), 99999);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.CONSUME;
	}

//	boolean specialCases(Player player, Mob mob) {
//		if (mob instanceof Rabbit r) {
//
//			switch (r.getVariant()) {
//			case BLACK:
//				rabbitDrop(player, mob, "_black");
//				return true;
//			case BROWN:
//				rabbitDrop(player, mob, "_brown");
//				return true;
//			case GOLD:
//				rabbitDrop(player, mob, "_gold");
//				return true;
//			case SALT:
//				rabbitDrop(player, mob, "_salt");
//				return true;
//			case WHITE:
//				rabbitDrop(player, mob, "_white");
//				return true;
//			case WHITE_SPLOTCHED:
//				rabbitDrop(player, mob, "_splotched");
//				return true;
//			}
//			return false;
//
//		}
//		return false;
//	}
//
//	private void rabbitDrop(Player player, Mob mob, String type) {
//		final ResourceKey<LootTable> lootTableLocation = ResourceKey.create(Registries.LOOT_TABLE,
//				ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
//						"butcher_knife/" + BuiltInRegistries.ENTITY_TYPE.getKey(mob.getType()).getPath() + type));
//		final LootTable lootTable = player.getServer().reloadableRegistries().getLootTable(lootTableLocation);
//
//		if (lootTable != LootTable.EMPTY) {
//			killAndDrop(player, lootTableLocation, mob);
//		}
//	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
			TooltipFlag tooltipFlag) {
		tooltipComponents.add(
				Component.literal("").append(Component.translatable(Butchercraft.MOD_ID + ".butcherknife.rightclick"))
						.withStyle(ChatFormatting.DARK_PURPLE));
	}
}
