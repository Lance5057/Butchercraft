package com.lance5057.butchercraft;

import com.lance5057.butchercraft.capabilities.AnimalCareProvider;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

@EventBusSubscriber(modid = Butchercraft.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ButchercraftModEvents {

	@SubscribeEvent
	public static void registerCaps(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ButchercraftBlockEntities.BUTCHER_BLOCK.get(),
				(object, context) -> object.getHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ButchercraftBlockEntities.GRINDER.get(),
				(object, context) -> object.getHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ButchercraftBlockEntities.MEAT_HOOK.get(),
				(object, context) -> object.getHandler());
		event.registerEntity(AnimalCareProvider.CARE, EntityType.COW, new AnimalCareProvider());
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
