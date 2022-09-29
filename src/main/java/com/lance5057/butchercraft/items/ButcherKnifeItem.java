package com.lance5057.butchercraft.items;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.tags.ButchercraftEntityTags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootTable;

public class ButcherKnifeItem extends KnifeItem {

	public ButcherKnifeItem(Properties builderIn) {
		super(builderIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
			InteractionHand hand) {
		final ResourceLocation lootTableLocation = new ResourceLocation(Butchercraft.MOD_ID,
				"butcher_knife/" + entity.getType().getRegistryName().getPath());
		if (player.getServer() != null) {
			final LootTable lootTable = player.getServer().getLootTables().get(lootTableLocation);
			if (entity.getType().is(ButchercraftEntityTags.CARCASSES) && entity instanceof Mob mob
					&& lootTable != LootTable.EMPTY) {
				mob.lootTable = lootTableLocation;
				entity.setLastHurtByPlayer(player);
				entity.hurt(DamageSource.playerAttack(player), 99999);
				return InteractionResult.SUCCESS;
			}
		}

		return InteractionResult.PASS;
	}
}
