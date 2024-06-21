package com.lance5057.butchercraft;

import com.lance5057.butchercraft.armor.models.ApronModel;
import com.lance5057.butchercraft.armor.models.BootsModel;
import com.lance5057.butchercraft.armor.models.BunnyEarsModel;
import com.lance5057.butchercraft.armor.models.BunnyTailModel;
import com.lance5057.butchercraft.armor.models.ChickenMaskModel;
import com.lance5057.butchercraft.armor.models.CowHoodModel;
import com.lance5057.butchercraft.armor.models.GlovesModel;
import com.lance5057.butchercraft.armor.models.GoatHoodModel;
import com.lance5057.butchercraft.armor.models.MaskModel;
import com.lance5057.butchercraft.armor.models.PaperHatModel;
import com.lance5057.butchercraft.armor.models.PigHoodModel;
import com.lance5057.butchercraft.armor.models.SheepHoodModel;
import com.lance5057.butchercraft.capabilities.AnimalCare;
import com.lance5057.butchercraft.capabilities.AnimalCareProvider;
import com.lance5057.butchercraft.client.block_models.ChickenHeadModel;
import com.lance5057.butchercraft.client.block_models.ChickenSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.CowHeadModel;
import com.lance5057.butchercraft.client.block_models.CowSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.GoatHeadModel;
import com.lance5057.butchercraft.client.block_models.GoatSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.PigHeadModel;
import com.lance5057.butchercraft.client.block_models.PigSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.RabbitHeadModel;
import com.lance5057.butchercraft.client.block_models.RabbitSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.SheepHeadModel;
import com.lance5057.butchercraft.client.block_models.SheepSkullHeadModel;
import com.lance5057.butchercraft.entity.ai.AngryAnimalAttackGoal;
import com.lance5057.butchercraft.entity.ai.AngryAnimalTargetGoal;
import com.lance5057.butchercraft.entity.ai.ClothingTemptGoal;

import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ButchercraftModEvents {

	public static void registerCaps(RegisterCapabilitiesEvent event) {
		event.register(AnimalCare.class);
	}

	public static void attachCaps(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Cow) {
			if (!event.getObject().getCapability(AnimalCareProvider.CARE).isPresent()) {
				event.addCapability(new ResourceLocation(Butchercraft.MOD_ID, "animalcare"), new AnimalCareProvider());
			}
		}

	}

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

				float pAN = pA.getCapability(AnimalCareProvider.CARE).map(i -> i.getNutrition())
						.orElse(ButchercraftConfig.WILDLIFE_NUTRITION.get().floatValue()); // TODO
				// config
				float pBN = pB.getCapability(AnimalCareProvider.CARE).map(i -> i.getNutrition())
						.orElse(ButchercraftConfig.WILDLIFE_NUTRITION.get().floatValue());

				if (pAN + pBN >= 2) {
					baby.getCapability(AnimalCareProvider.CARE).ifPresent(i -> i.setNutrition(0.9f));
					Cow baby2 = (Cow) baby.getType().spawn(server, null, event.getCausedByPlayer(), pA.blockPosition(),
							MobSpawnType.BREEDING, true, false);
					baby2.setBaby(true);
					baby2.getCapability(AnimalCareProvider.CARE).ifPresent(i -> i.setNutrition(0.9f));
				} else {
					float bred = Math.max(pAN, pBN) + Math.min(pAN, pBN) / 2;
					baby.getCapability(AnimalCareProvider.CARE).ifPresent(i -> i.setNutrition(bred));
				}
			}
		}
	}

	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(PaperHatModel.LAYER_LOCATION, () -> LayerDefinition
				.create(PaperHatModel.createLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(ApronModel.LAYER_LOCATION,
				() -> LayerDefinition.create(ApronModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(GlovesModel.LAYER_LOCATION, () -> LayerDefinition
				.create(GlovesModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(BootsModel.LAYER_LOCATION,
				() -> LayerDefinition.create(BootsModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(MaskModel.LAYER_LOCATION,
				() -> LayerDefinition.create(MaskModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 32, 32));
		event.registerLayerDefinition(BunnyEarsModel.LAYER_LOCATION, () -> LayerDefinition
				.create(BunnyEarsModel.createLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 16, 16));
		event.registerLayerDefinition(BunnyTailModel.LAYER_LOCATION, () -> LayerDefinition
				.create(BunnyTailModel.createLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 16, 16));
		event.registerLayerDefinition(PigHoodModel.LAYER_LOCATION, () -> LayerDefinition
				.create(PigHoodModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 64));
		event.registerLayerDefinition(GoatHoodModel.LAYER_LOCATION, () -> LayerDefinition
				.create(GoatHoodModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 64));
		event.registerLayerDefinition(CowHoodModel.LAYER_LOCATION, () -> LayerDefinition
				.create(CowHoodModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 64));
		event.registerLayerDefinition(SheepHoodModel.LAYER_LOCATION, () -> LayerDefinition
				.create(SheepHoodModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 64));
		event.registerLayerDefinition(ChickenMaskModel.LAYER_LOCATION, () -> LayerDefinition
				.create(ChickenMaskModel.createLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 32));

		event.registerLayerDefinition(CowHeadModel.LAYER_LOCATION, () -> CowHeadModel.createBodyLayer());
		event.registerLayerDefinition(ChickenHeadModel.LAYER_LOCATION, () -> ChickenHeadModel.createBodyLayer());
		event.registerLayerDefinition(SheepHeadModel.LAYER_LOCATION, () -> SheepHeadModel.createBodyLayer());
		event.registerLayerDefinition(PigHeadModel.LAYER_LOCATION, () -> PigHeadModel.createBodyLayer());
		event.registerLayerDefinition(GoatHeadModel.LAYER_LOCATION, () -> GoatHeadModel.createBodyLayer());
		event.registerLayerDefinition(RabbitHeadModel.LAYER_LOCATION, () -> RabbitHeadModel.createBodyLayer());

		event.registerLayerDefinition(CowSkullHeadModel.LAYER_LOCATION, () -> CowSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(SheepSkullHeadModel.LAYER_LOCATION, () -> SheepSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(PigSkullHeadModel.LAYER_LOCATION, () -> PigSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(ChickenSkullHeadModel.LAYER_LOCATION,
				() -> ChickenSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(GoatSkullHeadModel.LAYER_LOCATION, () -> GoatSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(RabbitSkullHeadModel.LAYER_LOCATION,
				() -> RabbitSkullHeadModel.createBodyLayer());
	}

	public static void cancelInteractions(PlayerInteractEvent.EntityInteractSpecific event) {
		if (event.getTarget() instanceof Villager v) {
			if (event.getEntity().hasEffect(ButchercraftMobEffects.STINKY.get())
					|| event.getEntity().hasEffect(ButchercraftMobEffects.BLOODY.get())) {
				v.setUnhappyCounter(40);
				if (!v.level().isClientSide()) {
					v.playSound(SoundEvents.VILLAGER_NO, 1, v.getVoicePitch());
				}
				event.setCancellationResult(InteractionResult.FAIL);
				event.setCanceled(true);
			}
		}
	}

	public static void cancelEat(LivingEntityUseItemEvent.Start event) {
		if (event.getEntity().hasEffect(ButchercraftMobEffects.STINKY.get())) {
			ItemStack stack = event.getItem();
			if (stack.getFoodProperties(event.getEntity()) != null || stack.getItem() instanceof PotionItem
					|| stack.getItem() instanceof MilkBucketItem) {
				event.getEntity().addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100));
				event.setCanceled(true);
			}
		}
	}

	public static void dirtyHands(LivingEntityUseItemEvent.Finish event) {
		if (event.getEntity().hasEffect(ButchercraftMobEffects.DIRTY.get())) {
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

				event.setCanceled(true);
			}
		}
	}

	public static void buffZombie(LivingHurtEvent event) {
		if (event.getSource().getDirectEntity() instanceof Zombie z) {
			if (event.getEntity().hasEffect(ButchercraftMobEffects.BLOODY.get())) {
				z.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0));
				z.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
			}
		}
	}

	// Hood Tempt Goals
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

	@SubscribeEvent
	public static void existingEntityAttributes(EntityAttributeModificationEvent event) {
		if (!event.has(EntityType.PIG, Attributes.ATTACK_DAMAGE)) {
			event.add(EntityType.PIG, Attributes.ATTACK_DAMAGE, 3);
		}
		if (!event.has(EntityType.COW, Attributes.ATTACK_DAMAGE)) {
			event.add(EntityType.COW, Attributes.ATTACK_DAMAGE, 4);
		}
		if (!event.has(EntityType.SHEEP, Attributes.ATTACK_DAMAGE)) {
			event.add(EntityType.SHEEP, Attributes.ATTACK_DAMAGE, 3);
		}
		if (!event.has(EntityType.GOAT, Attributes.ATTACK_DAMAGE)) {
			event.add(EntityType.GOAT, Attributes.ATTACK_DAMAGE, 4);
		}
		if (!event.has(EntityType.RABBIT, Attributes.ATTACK_DAMAGE)) {
			event.add(EntityType.RABBIT, Attributes.ATTACK_DAMAGE, 1);
		}
		if (!event.has(EntityType.CHICKEN, Attributes.ATTACK_DAMAGE)) {
			event.add(EntityType.CHICKEN, Attributes.ATTACK_DAMAGE, 2);
		}
	}

	@SubscribeEvent
	public static void buildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			event.accept(ButchercraftItems.COW_HEAD_ITEM::get);
			event.accept(ButchercraftItems.COW_SKULL_HEAD_ITEM::get);
			event.accept(ButchercraftItems.SHEEP_HEAD_ITEM::get);
			event.accept(ButchercraftItems.SHEEP_SKULL_HEAD_ITEM::get);
			event.accept(ButchercraftItems.PIG_HEAD_ITEM::get);
			event.accept(ButchercraftItems.PIG_SKULL_HEAD_ITEM::get);
			event.accept(ButchercraftItems.GOAT_HEAD_ITEM::get);
			event.accept(ButchercraftItems.GOAT_SKULL_HEAD_ITEM::get);
			event.accept(ButchercraftItems.CHICKEN_HEAD_ITEM::get);
			event.accept(ButchercraftItems.CHICKEN_SKULL_HEAD_ITEM::get);
			event.accept(ButchercraftItems.RABBIT_BROWN_HEAD_ITEM::get);
			event.accept(ButchercraftItems.RABBIT_BLACK_HEAD_ITEM::get);
			event.accept(ButchercraftItems.RABBIT_GOLD_HEAD_ITEM::get);
			event.accept(ButchercraftItems.RABBIT_SALT_HEAD_ITEM::get);
			event.accept(ButchercraftItems.RABBIT_SPLOTCHED_HEAD_ITEM::get);
			event.accept(ButchercraftItems.RABBIT_WHITE_HEAD_ITEM::get);
			event.accept(ButchercraftItems.RABBIT_SKULL_HEAD_ITEM::get);
		}

		// TODO: filter out heads + skulls
		if (event.getTabKey() == ButchercraftItems.BUTCHER_TAB.getKey()) {
			ButchercraftItems.ITEMS.getEntries().forEach(obj -> {
				event.accept(obj::get);
			});
		}
	}

}
