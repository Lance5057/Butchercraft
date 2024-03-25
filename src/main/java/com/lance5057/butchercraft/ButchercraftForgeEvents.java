package com.lance5057.butchercraft;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ButchercraftForgeEvents {
	@SubscribeEvent
	public static void giveHoodsToUndead(LivingSpawnEvent.SpecialSpawn event) {
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
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.TYPE_BLACK);
							break;
						case 1:
							e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.BROWN_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ButchercraftItems.BROWN_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.TYPE_BROWN);
							break;
						case 2:
							e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.GOLD_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ButchercraftItems.GOLD_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.TYPE_GOLD);
							break;
						case 3:
							e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.SALT_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ButchercraftItems.SALT_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.TYPE_SALT);
							break;
						case 4:
							e.setItemSlot(EquipmentSlot.HEAD,
									new ItemStack(ButchercraftItems.SPLOTCHED_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS,
									new ItemStack(ButchercraftItems.SPLOTCHED_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.TYPE_WHITE_SPLOTCHED);
							break;
						default:
							e.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ButchercraftItems.WHITE_BUNNY_EARS.get()));
							e.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ButchercraftItems.WHITE_BUNNY_TAIL.get()));
							spawnRabbitArmy(level, e, EntityType.RABBIT, Rabbit.TYPE_WHITE);
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
						Animal ent = (Animal) type.spawn(level, null, null, e.blockPosition()
								.offset(level.getRandom().nextInt(6) - 3, 0, level.getRandom().nextInt(6) - 3), MobSpawnType.EVENT,
								false, false);
						ent.addEffect(new MobEffectInstance(ButchercraftMobEffects.BLOODLUST.get(), 3600));
					}
				}
	}

	private static void spawnRabbitArmy(ServerLevel level, Mob e, EntityType<?> type, int skin) {
		if (level.dimension() == Level.OVERWORLD)
			if (level.canSeeSky(e.blockPosition()))
				if (level.getRandom().nextFloat() <= ButchercraftConfig.HOOD_ARMY_CHANCE.get().floatValue()) {
					int animalsAmount = level.getRandom().nextInt(4) + 2;
					for (int i = 0; i < animalsAmount; i++) {
						Rabbit ent = (Rabbit) type.spawn(level, null, null, e.blockPosition()
								.offset(level.getRandom().nextInt(6) - 3, 0, level.getRandom().nextInt(6) - 3), MobSpawnType.EVENT,
								false, false);
						ent.setRabbitType(skin);
						ent.addEffect(new MobEffectInstance(ButchercraftMobEffects.BLOODLUST.get(), 3600));
					}
				}
	}

	@SubscribeEvent
	public static void bloodyTrail(LivingSpawnEvent.SpecialSpawn event) {
		if (event.getEntity() instanceof Zombie z) {
			for (Player p : event.getLevel().players()) {
				if (p.hasEffect(ButchercraftMobEffects.BLOODTRAIL.get())) {
					z.setTarget(p);
				}
			}
		}
	}
}
