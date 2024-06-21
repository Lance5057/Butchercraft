package com.lance5057.butchercraft.items;

import com.lance5057.butchercraft.client.rendering.RenderUtil;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class SoapItem extends Item {

	public SoapItem(Properties pProperties) {
		super(pProperties);
		// TODO Auto-generated constructor stub
	}

	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
		if (!pLevel.isClientSide)
			pEntityLiving.curePotionEffects(pStack); // FORGE - move up so stack.shrink does not turn stack into air
		if (pEntityLiving instanceof ServerPlayer serverplayer) {
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
			serverplayer.awardStat(Stats.ITEM_USED.get(this));
		}

		if (pEntityLiving instanceof Player && !((Player) pEntityLiving).getAbilities().instabuild) {
			pStack.shrink(1);
		}

		return pStack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getUseDuration(ItemStack pStack) {
		return 32;
	}

	/**
	 * Returns the action that specifies what animation to play when the item is
	 * being used.
	 */
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.CUSTOM;
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when
	 * this item is used on a Block, see {@link #onItemUseFirst}.
	 */
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
//		pLevel.addParticle(ParticleTypes.BUBBLE_POP, pPlayer.getX() + 0.25f + pLevel.random.nextDouble() / 2,
//				pPlayer.getY() + 0.5f + pLevel.random.nextDouble(),
//				pPlayer.getZ() + 0.25f + pLevel.random.nextDouble() / 2, 0, 0, 0);
		return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
	}

	@Override
	public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

		if (pEntity instanceof Player p) {
			if (pIsSelected || p.getInventory().getItem(Inventory.SLOT_OFFHAND).is(pStack.getItem())) {
				if (p.getUseItemRemainingTicks() > 0) {
					for (int i = 0; i < 10; i++) {
						pLevel.addParticle(ParticleTypes.BUBBLE_POP, p.getX() + pLevel.random.nextFloat() - 0.5f,
								p.getY() + (pLevel.random.nextFloat() * 2), p.getZ() + pLevel.random.nextFloat() - 0.5f,
								0, 0, 0);
						pLevel.addParticle(ParticleTypes.BUBBLE, p.getX() + pLevel.random.nextFloat() - 0.5f,
								p.getY() + (pLevel.random.nextFloat() * 2), p.getZ() + pLevel.random.nextFloat() - 0.5f,
								0, 0, 0);
					}
				}
			}
		}
	}

	@Override
	public void initializeClient(
			java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {

		consumer.accept(new IClientItemExtensions() {

			private static final HumanoidModel.ArmPose EXAMPLE_POSE = HumanoidModel.ArmPose.create("EXAMPLE", false,
					(model, entity, arm) -> {
						float f = entity.getUseItemRemainingTicks();
						float f2 = Mth.abs(Mth.cos(f / 6.0F * (float) Math.PI) * 1.5F);
						if (arm == HumanoidArm.RIGHT) {

							model.rightArm.yRot = -45;
							model.rightArm.xRot = (float) (f2 - 45);
							model.leftArm.xRot = -135;
						} else {
							model.leftArm.yRot = 45;
							model.leftArm.xRot = (float) (f2 - 45);
							model.rightArm.xRot = -135;
						}
					});

			@Override
			public HumanoidModel.ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand,
					ItemStack itemStack) {
				if (!itemStack.isEmpty()) {
					if (entityLiving.getUsedItemHand() == hand && entityLiving.getUseItemRemainingTicks() > 0) {
						return EXAMPLE_POSE;
					}
				}
				return HumanoidModel.ArmPose.ITEM;
			}

			@Override
			public boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm,
					ItemStack itemInHand, float partialTick, float equipProcess, float swingProcess) {
				float f = player.getUseItemRemainingTicks() - partialTick + 1.0F;
				int i = arm == HumanoidArm.RIGHT ? 1 : -1;
				float i2 = arm == HumanoidArm.RIGHT ? -0.5f : 0.5f;
				poseStack.translate(i * 0.56F, -0.52F, -0.72F);
				float f2 = Mth.abs(Mth.cos(f / 8.0F * (float) Math.PI) * 0.5F);
				if (player.getUseItem() == itemInHand && player.isUsingItem()) {

					poseStack.mulPose(RenderUtil.createQuaternion(0, 90, 0, true));
					poseStack.translate(0.0, f2, i2);

				}
				return true;
			}
		});
	}
}
