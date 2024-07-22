package com.lance5057.butchercraft.items;

import java.util.List;

import javax.annotation.Nullable;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftMobEffects;
import com.lance5057.butchercraft.tags.ButchercraftEntityTags;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.common.IShearable;

public class ButcherKnifeItem extends KnifeItem {

	public ButcherKnifeItem(Properties builderIn) {
		super(builderIn);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
			InteractionHand hand) {

		if (entity.hasEffect(ButchercraftMobEffects.BLOODLUST.getDelegate()))
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

		if (player.getServer() != null) {

			if (entity.getType().is(ButchercraftEntityTags.CARCASSES) && entity instanceof Mob mob) {
				if (!specialCases(player, mob)) {
					final ResourceKey<LootTable> lootTableLocation = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
							"butcher_knife/" + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).getPath()));
					final LootTable lootTable = player.getServer().reloadableRegistries().getLootTable(lootTableLocation);

					if (lootTable != LootTable.EMPTY) {
						killAndDrop(player, lootTableLocation, mob);
					}
				}
				return InteractionResult.SUCCESS;
			}
		}

		return InteractionResult.PASS;
	}

	private void killAndDrop(Player player, final ResourceKey<LootTable> lootTableLocation, Mob mob) {
		player.level().playSound(null, mob.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 1.0F,
				1.0F);
		mob.lootTable = lootTableLocation;
		mob.setLastHurtByPlayer(player);
		mob.hurt(player.damageSources().playerAttack(player), 99999);
	}

	boolean specialCases(Player player, Mob mob) {
		if (mob instanceof Rabbit r) {

			switch (r.getVariant()) {
			case BLACK:
				rabbitDrop(player, mob, "_black");
				return true;
			case BROWN:
				rabbitDrop(player, mob, "_brown");
				return true;
			case GOLD:
				rabbitDrop(player, mob, "_gold");
				return true;
			case SALT:
				rabbitDrop(player, mob, "_salt");
				return true;
			case WHITE:
				rabbitDrop(player, mob, "_white");
				return true;
			case WHITE_SPLOTCHED:
				rabbitDrop(player, mob, "_splotched");
				return true;
			}
			return false;

		}
		return false;
	}

	private void rabbitDrop(Player player, Mob mob, String type) {
		final ResourceKey<LootTable> lootTableLocation = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID,
				"butcher_knife/" + BuiltInRegistries.ENTITY_TYPE.getKey(mob.getType()).getPath() + type));
		final LootTable lootTable = player.getServer().reloadableRegistries().getLootTable(lootTableLocation);

		if (lootTable != LootTable.EMPTY) {
			killAndDrop(player, lootTableLocation, mob);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		tooltipComponents.add(
				Component.literal("  ").append(Component.translatable(Butchercraft.MOD_ID + ".butcherknife.rightclick"))
						.withStyle(ChatFormatting.DARK_PURPLE));
	}
}
