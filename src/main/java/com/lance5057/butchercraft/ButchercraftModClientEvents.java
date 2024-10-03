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
import net.minecraft.core.component.DataComponents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ButchercraftModClientEvents {
	@SubscribeEvent
	public static void registerColorHandlers(RegisterColorHandlersEvent.Item event) {
		event.register((stack, tintIndex) -> {
			return stack.has(DataComponents.DYED_COLOR) ? stack.get(DataComponents.DYED_COLOR).rgb() : 0xFFFFFF;
		}, ButchercraftItems.SHEEP_HOOD);
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
}
