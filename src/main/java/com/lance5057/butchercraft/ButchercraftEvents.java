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
import com.lance5057.butchercraft.client.block_models.CowHeadModel;
import com.lance5057.butchercraft.client.block_models.CowSkullHeadModel;
import com.lance5057.butchercraft.client.block_models.GoatHeadModel;
import com.lance5057.butchercraft.client.block_models.PigHeadModel;
import com.lance5057.butchercraft.client.block_models.RabbitHeadModel;
import com.lance5057.butchercraft.client.block_models.SheepHeadModel;
import com.lance5057.butchercraft.entity.ai.ClothingTemptGoal;

import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ButchercraftEvents {

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
		Level level = event.getChild().level;

		if (level instanceof ServerLevel) {
			ServerLevel server = (ServerLevel) level;

			if (event.getChild() instanceof Cow) {
				Cow baby = (Cow) event.getChild();
				Cow pA = (Cow) event.getParentA();
				Cow pB = (Cow) event.getParentB();

				baby.setAge((int) (AgeableMob.BABY_START_AGE
						* ButchercraftConfig.getInstance().general.ageMultiplier.get()));
				pA.setAge((int) (6000 * ButchercraftConfig.getInstance().general.breedingMultiplier.get()));
				pB.setAge((int) (6000 * ButchercraftConfig.getInstance().general.breedingMultiplier.get()));

				float pAN = pA.getCapability(AnimalCareProvider.CARE).map(i -> i.getNutrition())
						.orElse(ButchercraftConfig.getInstance().general.wildlifeBaseNutrition.get()); // TODO
				// config
				float pBN = pB.getCapability(AnimalCareProvider.CARE).map(i -> i.getNutrition())
						.orElse(ButchercraftConfig.getInstance().general.wildlifeBaseNutrition.get());

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
		event.registerLayerDefinition(CowSkullHeadModel.LAYER_LOCATION, () -> CowSkullHeadModel.createBodyLayer());
		event.registerLayerDefinition(ChickenHeadModel.LAYER_LOCATION, () -> ChickenHeadModel.createBodyLayer());
		event.registerLayerDefinition(SheepHeadModel.LAYER_LOCATION, () -> SheepHeadModel.createBodyLayer());
		event.registerLayerDefinition(PigHeadModel.LAYER_LOCATION, () -> PigHeadModel.createBodyLayer());
		event.registerLayerDefinition(GoatHeadModel.LAYER_LOCATION, () -> GoatHeadModel.createBodyLayer());
		event.registerLayerDefinition(RabbitHeadModel.LAYER_LOCATION, () -> RabbitHeadModel.createBodyLayer());
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
				switch (event.getEntity().level.random.nextInt(3)) {
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
		}
		if (e instanceof Cow p) {
			p.goalSelector.addGoal(4,
					new ClothingTemptGoal(p, 1.5D, Ingredient.of(ButchercraftItems.COW_HOOD.get()), false));
		}
		if (e instanceof Sheep p) {
			p.goalSelector.addGoal(4,
					new ClothingTemptGoal(p, 1.5D, Ingredient.of(ButchercraftItems.SHEEP_HOOD.get()), false));
		}
		if (e instanceof Goat p) {
			p.goalSelector.addGoal(4,
					new ClothingTemptGoal(p, 1.5D, Ingredient.of(ButchercraftItems.GOAT_HOOD.get()), false));
		}
		if (e instanceof Chicken p) {
			p.goalSelector.addGoal(4,
					new ClothingTemptGoal(p, 1.5D, Ingredient.of(ButchercraftItems.CHICKEN_MASK.get()), false));
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
		}
	}
}
