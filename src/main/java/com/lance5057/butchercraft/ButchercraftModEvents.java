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

import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

@Mod.EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ButchercraftModEvents {

	@SubscribeEvent
	public static void registerCaps(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ButchercraftBlockEntities.BUTCHER_BLOCK.get(), (object, context) -> object.getHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ButchercraftBlockEntities.GRINDER.get(), (object, context) -> object.getHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ButchercraftBlockEntities.MEAT_HOOK.get(), (object, context) -> object.getHandler());
		event.registerEntity(AnimalCareProvider.CARE, EntityType.COW, new AnimalCareProvider());
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
