package com.lance5057.butchercraft.armor;

import java.util.List;
import java.util.Map;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BCArmorMaterial {
	private static final Map<ArmorItem.Type, Integer> ZERO = Map.of(ArmorItem.Type.HELMET, 0, ArmorItem.Type.CHESTPLATE,
			0, ArmorItem.Type.LEGGINGS, 0, ArmorItem.Type.BOOTS, 0, ArmorItem.Type.BODY, 0);
	private static final Map<ArmorItem.Type, Integer> ONE = Map.of(ArmorItem.Type.HELMET, 1, ArmorItem.Type.CHESTPLATE,
			1, ArmorItem.Type.LEGGINGS, 1, ArmorItem.Type.BOOTS, 1, ArmorItem.Type.BODY, 1);

	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister
			.create(Registries.ARMOR_MATERIAL, Butchercraft.MOD_ID);

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> WOOL = ARMOR_MATERIALS
			.register("wool",
					() -> new ArmorMaterial(ONE, 5, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(ItemTags.WOOL),
							List.of(new ArmorMaterial.Layer(
									ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "wool"), "", true)),
							0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PAPER = ARMOR_MATERIALS
			.register("paper",
					() -> new ArmorMaterial(ONE, 10, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.PAPER),
							List.of(new ArmorMaterial.Layer(
									ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "paper"), "", true)),
							0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BUNNY_BLACK = ARMOR_MATERIALS.register(
			"bunny_black",
			() -> new ArmorMaterial(ZERO, 10, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.RABBIT_HIDE),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "bunny_black"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BUNNY_BROWN = ARMOR_MATERIALS.register(
			"bunny_brown",
			() -> new ArmorMaterial(ZERO, 10, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.RABBIT_HIDE),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "bunny_brown"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BUNNY_SPLOTCHED = ARMOR_MATERIALS.register(
			"bunny_splotched",
			() -> new ArmorMaterial(ZERO, 10, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.RABBIT_HIDE),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "bunny_splotched"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BUNNY_GOLD = ARMOR_MATERIALS.register("bunny_gold",
			() -> new ArmorMaterial(ZERO, 10, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.RABBIT_HIDE),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "bunny_gold"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BUNNY_SALT = ARMOR_MATERIALS.register("bunny_salt",
			() -> new ArmorMaterial(ZERO, 10, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.RABBIT_HIDE),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "bunny_salt"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BUNNY_WHITE = ARMOR_MATERIALS.register(
			"bunny_white",
			() -> new ArmorMaterial(ZERO, 10, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.RABBIT_HIDE),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "bunny_white"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PIG_HOOD = ARMOR_MATERIALS.register("pig_hood",
			() -> new ArmorMaterial(ONE, 10, SoundEvents.ARMOR_EQUIP_LEATHER,
					() -> Ingredient.of(ButchercraftItems.PIG_HIDE.get()),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "pig_hood"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> GOAT_HOOD = ARMOR_MATERIALS.register("goat_hood",
			() -> new ArmorMaterial(ONE, 10, SoundEvents.ARMOR_EQUIP_LEATHER,
					() -> Ingredient.of(ButchercraftItems.GOAT_HIDE.get()),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "goat_hood"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> COW_HOOD = ARMOR_MATERIALS.register("cow_hood",
			() -> new ArmorMaterial(ONE, 10, SoundEvents.ARMOR_EQUIP_LEATHER,
					() -> Ingredient.of(ButchercraftItems.COW_HIDE.get()),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "cow_hood"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> SHEEP_HOOD = ARMOR_MATERIALS.register("sheep_hood",
			() -> new ArmorMaterial(ONE, 10, SoundEvents.ARMOR_EQUIP_LEATHER,
					() -> Ingredient.of(ButchercraftItems.SHEEP_HIDE.get()),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "sheep_hood"), "", true)),
					0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CHICKEN_MASK = ARMOR_MATERIALS.register(
			"chicken_mask",
			() -> new ArmorMaterial(ONE, 10, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.FEATHER),
					List.of(new ArmorMaterial.Layer(
							ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "chicken_mask"), "", true)),
					0.0F, 0.0F));

	public static void register(IEventBus modBus) {
		ARMOR_MATERIALS.register(modBus);
	}
}
