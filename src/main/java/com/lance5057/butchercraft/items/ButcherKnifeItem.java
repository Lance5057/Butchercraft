package com.lance5057.butchercraft.items;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.tags.ButchercraftEntityTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ButcherKnifeItem extends KnifeItem {

	public ButcherKnifeItem(Properties builderIn) {
		super(builderIn);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
			InteractionHand hand) {

		if (entity instanceof net.minecraftforge.common.IForgeShearable target) {
			if (entity.level.isClientSide)
				return net.minecraft.world.InteractionResult.SUCCESS;
			BlockPos pos = new BlockPos(entity.getX(), entity.getY(), entity.getZ());
			if (target.isShearable(stack, entity.level, pos)) {
				java.util.List<ItemStack> drops = target.onSheared(player, stack, entity.level, pos,
						net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(
								net.minecraft.world.item.enchantment.Enchantments.BLOCK_FORTUNE, stack));
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


		final ResourceLocation lootTableLocation = new ResourceLocation(Butchercraft.MOD_ID,
				"butcher_knife/" + ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).getPath());
		if (player.getServer() != null) {
			final LootTable lootTable = player.getServer().getLootTables().get(lootTableLocation);
			if (entity.getType().is(ButchercraftEntityTags.CARCASSES) && entity instanceof Mob mob
					&& lootTable != LootTable.EMPTY) {
				entity.level.playSound(null, entity.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 1.0F, 1.0F);
				mob.lootTable = lootTableLocation;
				entity.setLastHurtByPlayer(player);
				entity.hurt(DamageSource.playerAttack(player), 99999);
				return InteractionResult.SUCCESS;
			}
		}

		return InteractionResult.PASS;
	}

	@Override
	public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
			TooltipFlag pIsAdvanced) {
		pTooltipComponents.add(Component.literal("  ")
				.append(Component.translatable(Butchercraft.MOD_ID + ".butcherknife.rightclick"))
				.withStyle(ChatFormatting.DARK_PURPLE));
	}
}
