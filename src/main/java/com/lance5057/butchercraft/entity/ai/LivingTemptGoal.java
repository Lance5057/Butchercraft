package com.lance5057.butchercraft.entity.ai;

import java.util.EnumSet;

import javax.annotation.Nullable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.item.crafting.Ingredient;

public class LivingTemptGoal extends Goal {
	private static final TargetingConditions TEMP_TARGETING = TargetingConditions.forNonCombat().range(10.0D)
			.ignoreLineOfSight();
	private final TargetingConditions targetingConditions;
	protected final PathfinderMob mob;
	private final double speedModifier;
	private double px;
	private double py;
	private double pz;
	private double pRotX;
	private double pRotY;
	@Nullable
	protected LivingEntity entity;
	private int calmDown;
	private boolean isRunning;
	public final Ingredient items;
	private final boolean canScare;

	public LivingTemptGoal(PathfinderMob pMob, double pSpeedModifier, Ingredient pItems, boolean pCanScare) {
		this.mob = pMob;
		this.speedModifier = pSpeedModifier;
		this.items = pItems;
		this.canScare = pCanScare;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		this.targetingConditions = TEMP_TARGETING.copy().selector(this::shouldFollow);
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state
	 * necessary for execution in this method as well.
	 */
	public boolean canUse() {
		if (this.calmDown > 0) {
			--this.calmDown;
			return false;
		} else {
			this.entity = this.mob.level.getNearestEntity(LivingEntity.class, this.targetingConditions, this.mob, mob.getX(), mob.getY(), mob.getZ(), mob.getBoundingBox().inflate(5));
			return this.entity != null;
		}
	}

	public boolean shouldFollow(LivingEntity p_148139_) {
		return this.items.test(p_148139_.getMainHandItem()) || this.items.test(p_148139_.getOffhandItem());
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean canContinueToUse() {
		if (this.canScare()) {
			if (this.mob.distanceToSqr(this.entity) < 36.0D) {
				if (this.entity.distanceToSqr(this.px, this.py, this.pz) > 0.010000000000000002D) {
					return false;
				}

				if (Math.abs((double) this.entity.getXRot() - this.pRotX) > 5.0D
						|| Math.abs((double) this.entity.getYRot() - this.pRotY) > 5.0D) {
					return false;
				}
			} else {
				this.px = this.entity.getX();
				this.py = this.entity.getY();
				this.pz = this.entity.getZ();
			}

			this.pRotX = (double) this.entity.getXRot();
			this.pRotY = (double) this.entity.getYRot();
		}

		return this.canUse();
	}

	protected boolean canScare() {
		return this.canScare;
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void start() {
		this.px = this.entity.getX();
		this.py = this.entity.getY();
		this.pz = this.entity.getZ();
		this.isRunning = true;
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by
	 * another one
	 */
	public void stop() {
		this.entity = null;
		this.mob.getNavigation().stop();
		this.calmDown = reducedTickDelay(100);
		this.isRunning = false;
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	public void tick() {
		this.mob.getLookControl().setLookAt(this.entity, (float) (this.mob.getMaxHeadYRot() + 20),
				(float) this.mob.getMaxHeadXRot());
		if (this.mob.distanceToSqr(this.entity) < 6.25D) {
			this.mob.getNavigation().stop();
		} else {
			this.mob.getNavigation().moveTo(this.entity, this.speedModifier);
		}

	}

	/**
	 * @see #isRunning
	 */
	public boolean isRunning() {
		return this.isRunning;
	}
}