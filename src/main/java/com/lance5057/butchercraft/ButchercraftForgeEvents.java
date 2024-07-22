package com.lance5057.butchercraft;

import java.util.Optional;

import com.lance5057.butchercraft.capabilities.AnimalCareProvider;
import com.lance5057.butchercraft.entity.ai.AngryAnimalAttackGoal;
import com.lance5057.butchercraft.entity.ai.AngryAnimalTargetGoal;
import com.lance5057.butchercraft.entity.ai.ClothingTemptGoal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.BabyEntitySpawnEvent;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ButchercraftForgeEvents {
	@SubscribeEvent
	public static void giveHoodsToUndead(FinalizeSpawnEvent event) {
		if (event.getLevel() instanceof ServerLevel level) {
			if (level.getRandom().nextFloat() <= ButchercraftConfig.HOOD_SPAWN_CHANCE.get().floatValue()) {
				Mob e = event.getEntity();
				if (e instanceof Zombie || e instanceof Skeleton) {
					int choice = event.getLevel().getRandom().nextInt(6);

					switch (choice) {
					case 0:
						e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.COW_HOOD.get()));
						spawnArmy(level, e, EntityType.COW);
						break;
					case 1:
						e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.GOAT_HOOD.get()));
						spawnArmy(level, e, EntityType.GOAT);
						break;
					case 2:
						e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.PIG_HOOD.get()));
						spawnArmy(level, e, EntityType.PIG);
						break;
					case 3:
						e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.SHEEP_HOOD.get()));
						spawnArmy(level, e, EntityType.SHEEP);
						break;
					case 4:
						e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.CHICKEN_MASK.get()));
						spawnArmy(level, e, EntityType.CHICKEN);
						break;
					default: {
						int rabbit = event.getLevel().getRandom().nextInt(6);
						switch (rabbit) {
						case 0:
							e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.BLACK_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ButchercraftItems.BLACK_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.Variant.BLACK);
							break;
						case 1:
							e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.BROWN_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ButchercraftItems.BROWN_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.Variant.BROWN);
							break;
						case 2:
							e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.GOLD_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ButchercraftItems.GOLD_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.Variant.GOLD);
							break;
						case 3:
							e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.SALT_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ButchercraftItems.SALT_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.Variant.SALT);
							break;
						case 4:
							e.setItemSlot(EquipmentSlot.HEAD,
									new ItemStack(ButchercraftItems.SPLOTCHED_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS,
									new ItemStack(ButchercraftItems.SPLOTCHED_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.Variant.WHITE_SPLOTCHED);
							break;
						default:
							e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.WHITE_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ButchercraftItems.WHITE_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.Variant.WHITE);
							break;
						}

					}
					}
				}
			}
		}
	}

	private static void spawnArmy(ServerLevel level, Mob e, EntityType<?> type) {
		if (level.dimension() == Level.OVERWORLD)
			if (level.canSeeSky(e.blockPosition()))
				if (level.getRandom().nextFloat() <= ButchercraftConfig.HOOD_ARMY_CHANCE.get().floatValue()) {
					int animalsAmount = level.getRandom().nextInt(4) + 2;
					for (int i = 0; i < animalsAmount; i++) {
						Animal ent = (Animal) type.spawn(level, e.blockPosition().offset(level.getRandom().nextInt(6) - 3, 0, level.getRandom().nextInt(6) - 3), MobSpawnType.EVENT);
						ent.addEffect(new MobEffectInstance(ButchercraftMobEffects.BLOODLUST.getDelegate(), 3600));
					}
				}
	}

	private static void spawnRabbitArmy(ServerLevel level, Mob e, EntityType<?> type, Rabbit.Variant skin) {
		if (level.dimension() == Level.OVERWORLD)
			if (level.canSeeSky(e.blockPosition()))
				if (level.getRandom().nextFloat() <= ButchercraftConfig.HOOD_ARMY_CHANCE.get().floatValue()) {
					int animalsAmount = level.getRandom().nextInt(4) + 2;
					for (int i = 0; i < animalsAmount; i++) {
						Rabbit ent = (Rabbit) type.spawn(level, e.blockPosition().offset(level.getRandom().nextInt(6) - 3, 0, level.getRandom().nextInt(6) - 3), MobSpawnType.EVENT);
						ent.setVariant(skin);
						ent.addEffect(new MobEffectInstance(ButchercraftMobEffects.BLOODLUST.getDelegate(), 3600));
					}
				}
	}

	@SubscribeEvent
	public static void bloodyTrail(FinalizeSpawnEvent event) {
		if (event.getEntity() instanceof Zombie z) {
			for (Player p : event.getLevel().players()) {
				if (p.hasEffect(ButchercraftMobEffects.BLOODTRAIL.getDelegate())) {
					z.setTarget(p);
				}
			}
		}
	}

	@SubscribeEvent
	public static void breedEvent(BabyEntitySpawnEvent event) {
		Level level = event.getChild().level();

		if (level instanceof ServerLevel) {
			ServerLevel server = (ServerLevel) level;

			if (event.getChild() instanceof Cow) {
				Cow baby = (Cow) event.getChild();
				Cow pA = (Cow) event.getParentA();
				Cow pB = (Cow) event.getParentB();

				baby.setAge((int) (AgeableMob.BABY_START_AGE * ButchercraftConfig.AGE_MULTIPLIER.get()));
				pA.setAge((int) (6000 * ButchercraftConfig.BREEDING_MULTIPLIER.get()));
				pB.setAge((int) (6000 * ButchercraftConfig.BREEDING_MULTIPLIER.get()));

				float pAN = Optional.ofNullable(pA.getCapability(AnimalCareProvider.CARE)).map(i -> i.getNutrition())
						.orElse(ButchercraftConfig.WILDLIFE_NUTRITION.get().floatValue()); // TODO
				// config
				float pBN = Optional.ofNullable(pB.getCapability(AnimalCareProvider.CARE)).map(i -> i.getNutrition())
						.orElse(ButchercraftConfig.WILDLIFE_NUTRITION.get().floatValue());

				if (pAN + pBN >= 2) {
					Optional.ofNullable(baby.getCapability(AnimalCareProvider.CARE)).ifPresent(i -> i.setNutrition(0.9f));
					Cow baby2 = (Cow) baby.getType().spawn(server, null, event.getCausedByPlayer(), pA.blockPosition(),
							MobSpawnType.BREEDING, true, false);
					baby2.setBaby(true);
					Optional.ofNullable(baby2.getCapability(AnimalCareProvider.CARE)).ifPresent(i -> i.setNutrition(0.9f));
				} else {
					float bred = Math.max(pAN, pBN) + Math.min(pAN, pBN) / 2;
					Optional.ofNullable(baby.getCapability(AnimalCareProvider.CARE)).ifPresent(i -> i.setNutrition(bred));
				}
			}
		}
	}

	@SubscribeEvent
	public static void cancelInteractions(PlayerInteractEvent.EntityInteractSpecific event) {
		if (event.getTarget() instanceof Villager v) {
			if (event.getEntity().hasEffect(ButchercraftMobEffects.STINKY.getDelegate())
					|| event.getEntity().hasEffect(ButchercraftMobEffects.BLOODY.getDelegate())) {
				v.setUnhappyCounter(40);
				if (!v.level().isClientSide()) {
					v.playSound(SoundEvents.VILLAGER_NO, 1, v.getVoicePitch());
				}
				event.setCancellationResult(InteractionResult.FAIL);
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public static void cancelEat(LivingEntityUseItemEvent.Start event) {
		if (event.getEntity().hasEffect(ButchercraftMobEffects.STINKY.getDelegate())) {
			ItemStack stack = event.getItem();
			if (stack.getFoodProperties(event.getEntity()) != null || stack.getItem() instanceof PotionItem
					|| stack.getItem() instanceof MilkBucketItem) {
				event.getEntity().addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100));
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public static void dirtyHands(LivingEntityUseItemEvent.Finish event) {
		if (event.getEntity().hasEffect(ButchercraftMobEffects.DIRTY.getDelegate())) {
			ItemStack stack = event.getItem();
			if (stack.getFoodProperties(event.getEntity()) != null || stack.getItem() instanceof PotionItem
					|| stack.getItem() instanceof MilkBucketItem) {
				switch (event.getEntity().level().random.nextInt(3)) {
					case 0:
						event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, 600));
					case 1:
						event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600));
					default:
						event.getEntity().addEffect(new MobEffectInstance(MobEffects.HUNGER, 600));
				}

				// TODO?
				//event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public static void buffZombie(LivingDamageEvent.Pre event) {
		if (event.getSource().getDirectEntity() instanceof Zombie z) {
			if (event.getEntity().hasEffect(ButchercraftMobEffects.BLOODY.getDelegate())) {
				z.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0));
				z.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
			}
		}
	}

	// Hood Tempt Goals
	@SubscribeEvent
	public static void EntityJoined(EntityJoinLevelEvent event) {
		Entity e = event.getEntity();
		if (e instanceof Pig p) {
			p.goalSelector.addGoal(4,
					new ClothingTemptGoal(p, 1.5D, Ingredient.of(ButchercraftItems.PIG_HOOD.get()), false));
			p.targetSelector.addGoal(2, new AngryAnimalTargetGoal(p));
			p.goalSelector.addGoal(2, new AngryAnimalAttackGoal(p, 1, false));
		}
		if (e instanceof Cow p) {
			p.goalSelector.addGoal(4,
					new ClothingTemptGoal(p, 1.5D, Ingredient.of(ButchercraftItems.COW_HOOD.get()), false));
			p.targetSelector.addGoal(2, new AngryAnimalTargetGoal(p));
			p.goalSelector.addGoal(2, new AngryAnimalAttackGoal(p, 1, false));
		}
		if (e instanceof Sheep p) {
			p.goalSelector.addGoal(4,
					new ClothingTemptGoal(p, 1.5D, Ingredient.of(ButchercraftItems.SHEEP_HOOD.get()), false));
			p.targetSelector.addGoal(2, new AngryAnimalTargetGoal(p));
			p.goalSelector.addGoal(2, new AngryAnimalAttackGoal(p, 1, false));
		}
		if (e instanceof Goat p) {
			p.goalSelector.addGoal(4,
					new ClothingTemptGoal(p, 1.5D, Ingredient.of(ButchercraftItems.GOAT_HOOD.get()), false));
			p.targetSelector.addGoal(2, new AngryAnimalTargetGoal(p));
			p.goalSelector.addGoal(2, new AngryAnimalAttackGoal(p, 1, false));
		}
		if (e instanceof Chicken p) {
			p.goalSelector.addGoal(4,
					new ClothingTemptGoal(p, 1.5D, Ingredient.of(ButchercraftItems.CHICKEN_MASK.get()), false));
			p.targetSelector.addGoal(2, new AngryAnimalTargetGoal(p));
			p.goalSelector.addGoal(2, new AngryAnimalAttackGoal(p, 1, false));
		}
		if (e instanceof Rabbit p) {
			p.goalSelector.addGoal(4, new ClothingTemptGoal(p, 1.5D,
					Ingredient.of(ButchercraftItems.BLACK_BUNNY_EARS.get(), ButchercraftItems.BROWN_BUNNY_EARS.get(),
							ButchercraftItems.GOLD_BUNNY_EARS.get(), ButchercraftItems.SALT_BUNNY_EARS.get(),
							ButchercraftItems.SPLOTCHED_BUNNY_EARS.get(), ButchercraftItems.WHITE_BUNNY_EARS.get(),
							ButchercraftItems.BLACK_BUNNY_TAIL.get(), ButchercraftItems.BROWN_BUNNY_TAIL.get(),
							ButchercraftItems.GOLD_BUNNY_TAIL.get(), ButchercraftItems.SALT_BUNNY_TAIL.get(),
							ButchercraftItems.SPLOTCHED_BUNNY_TAIL.get(), ButchercraftItems.WHITE_BUNNY_TAIL.get()),
					false));
			p.targetSelector.addGoal(2, new AngryAnimalTargetGoal(p));
		}
	}
}
