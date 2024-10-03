package com.lance5057.butchercraft;

import java.util.Map;

import com.lance5057.butchercraft.blocks.AnimalHeadBlock;
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
import com.lance5057.butchercraft.workstations.butcherblock.ButcherBlockRenderer;
import com.lance5057.butchercraft.workstations.grinder.GrinderRenderer;
import com.lance5057.butchercraft.workstations.hook.MeatHookRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.MerchantScreen;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = Butchercraft.MOD_ID)
public class ButchercraftClient {

	// @SubscribeEvent
	public static void setBERenderers() {
		BlockEntityRenderers.register(ButchercraftBlockEntities.MEAT_HOOK.get(), MeatHookRenderer::new);
		BlockEntityRenderers.register(ButchercraftBlockEntities.GRINDER.get(), GrinderRenderer::new);
		BlockEntityRenderers.register(ButchercraftBlockEntities.BUTCHER_BLOCK.get(), ButcherBlockRenderer::new);

		BlockEntityRenderers.register(ButchercraftBlockEntities.SKULL.get(), SkullBlockRenderer::new);
		BlockEntityRenderers.register(ButchercraftBlockEntities.WALL_SKULL.get(), SkullBlockRenderer::new);
	}

	@SubscribeEvent
	public static void RegisterExtraModels(ModelEvent.RegisterAdditional event) {
		Map<ResourceLocation, Resource> rrs = Minecraft.getInstance().getResourceManager()
				.listResources("models/meathook", (p_215600_) -> {
					return p_215600_.getPath().endsWith(".json");
				});

		rrs.forEach((rl, r) -> {
			String s = rl.toString();

			s = s.substring(s.indexOf('/') + 1, s.indexOf('.'));

			ModelResourceLocation rl2 = ModelResourceLocation
					.standalone(ResourceLocation.fromNamespaceAndPath(rl.getNamespace(), s));

			event.register(rl2);
		});
	}

	@SubscribeEvent
	public static void registerSkulls(EntityRenderersEvent.CreateSkullModels event) {
		event.registerSkullModel(AnimalHeadBlock.Types.COW,
				new SkullModel(event.getEntityModelSet().bakeLayer(CowHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.CHICKEN,
				new SkullModel(event.getEntityModelSet().bakeLayer(ChickenHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.GOAT,
				new SkullModel(event.getEntityModelSet().bakeLayer(GoatHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.PIG,
				new SkullModel(event.getEntityModelSet().bakeLayer(PigHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.SHEEP,
				new SkullModel(event.getEntityModelSet().bakeLayer(SheepHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.COW_SKULL,
				new SkullModel(event.getEntityModelSet().bakeLayer(CowSkullHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.CHICKEN_SKULL,
				new SkullModel(event.getEntityModelSet().bakeLayer(ChickenSkullHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.GOAT_SKULL,
				new SkullModel(event.getEntityModelSet().bakeLayer(GoatSkullHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.PIG_SKULL,
				new SkullModel(event.getEntityModelSet().bakeLayer(PigSkullHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.SHEEP_SKULL,
				new SkullModel(event.getEntityModelSet().bakeLayer(SheepSkullHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.RABBIT_SKULL,
				new SkullModel(event.getEntityModelSet().bakeLayer(RabbitSkullHeadModel.LAYER_LOCATION)));

		event.registerSkullModel(AnimalHeadBlock.Types.RABBIT_BLACK,
				new SkullModel(event.getEntityModelSet().bakeLayer(RabbitHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.RABBIT_BROWN,
				new SkullModel(event.getEntityModelSet().bakeLayer(RabbitHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.RABBIT_GOLD,
				new SkullModel(event.getEntityModelSet().bakeLayer(RabbitHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.RABBIT_SALT,
				new SkullModel(event.getEntityModelSet().bakeLayer(RabbitHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.RABBIT_SPLOTCHED,
				new SkullModel(event.getEntityModelSet().bakeLayer(RabbitHeadModel.LAYER_LOCATION)));
		event.registerSkullModel(AnimalHeadBlock.Types.RABBIT_WHITE,
				new SkullModel(event.getEntityModelSet().bakeLayer(RabbitHeadModel.LAYER_LOCATION)));

		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.COW,
				ResourceLocation.withDefaultNamespace("textures/entity/cow/cow.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.CHICKEN,
				ResourceLocation.withDefaultNamespace("textures/entity/chicken.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.GOAT,
				ResourceLocation.withDefaultNamespace("textures/entity/goat/goat.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.PIG,
				ResourceLocation.withDefaultNamespace("textures/entity/pig/pig.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.SHEEP,
				ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.COW_SKULL,
				ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/entity/cow.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.CHICKEN_SKULL,
				ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/entity/chicken.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.GOAT_SKULL,
				ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/entity/goat.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.PIG_SKULL,
				ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/entity/pig.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.RABBIT_SKULL,
				ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/entity/rabbit.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.SHEEP_SKULL,
				ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/entity/sheep.png"));

		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.RABBIT_BLACK,
				ResourceLocation.withDefaultNamespace("textures/entity/rabbit/black.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.RABBIT_BROWN,
				ResourceLocation.withDefaultNamespace("textures/entity/rabbit/brown.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.RABBIT_GOLD,
				ResourceLocation.withDefaultNamespace("textures/entity/rabbit/gold.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.RABBIT_SALT,
				ResourceLocation.withDefaultNamespace("textures/entity/rabbit/salt.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.RABBIT_SPLOTCHED,
				ResourceLocation.withDefaultNamespace("textures/entity/rabbit/white_splotched.png"));
		SkullBlockRenderer.SKIN_BY_TYPE.put(AnimalHeadBlock.Types.RABBIT_WHITE,
				ResourceLocation.withDefaultNamespace("textures/entity/rabbit/white.png"));
	}

}
