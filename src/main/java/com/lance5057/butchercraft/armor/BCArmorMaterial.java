package com.lance5057.butchercraft.armor;

import java.util.function.Supplier;

import com.lance5057.butchercraft.ButchercraftItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum BCArmorMaterial {

	WOOL("butchercraft:wool", 5, new int[] { 1, 1, 1, 1 }, 5, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(ItemTags.WOOL);
	}), PAPER("butchercraft:paper", 3, new int[] { 1, 1, 1, 1 }, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(Items.PAPER);
	}), BUNNY_BLACK("butchercraft:bunny_black", 3, new int[] { 0, 0, 0, 0 }, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(Items.RABBIT_HIDE);
	}), BUNNY_BROWN("butchercraft:bunny_brown", 3, new int[] { 0, 0, 0, 0 }, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(Items.RABBIT_HIDE);
	}), BUNNY_SPLOTCHED("butchercraft:bunny_splotched", 3, new int[] { 0, 0, 0, 0 }, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(Items.RABBIT_HIDE);
	}), BUNNY_GOLD("butchercraft:bunny_gold", 3, new int[] { 0, 0, 0, 0 }, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(Items.RABBIT_HIDE);
	}), BUNNY_SALT("butchercraft:bunny_salt", 3, new int[] { 0, 0, 0, 0 }, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(Items.RABBIT_HIDE);
	}), BUNNY_WHITE("butchercraft:bunny_white", 3, new int[] { 0, 0, 0, 0 }, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(Items.RABBIT_HIDE);
	}), PIG_HOOD("butchercraft:pig_hood", 3, new int[] { 1, 1, 1, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(ButchercraftItems.PIG_HIDE.get());
	}), GOAT_HOOD("butchercraft:goat_hood", 3, new int[] { 1, 1, 1, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(ButchercraftItems.GOAT_HIDE.get());
	}), COW_HOOD("butchercraft:cow_hood", 3, new int[] { 1, 1, 1, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(ButchercraftItems.COW_HIDE.get());
	}), SHEEP_HOOD("butchercraft:sheep_hood", 3, new int[] { 1, 1, 1, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(ButchercraftItems.SHEEP_HIDE.get());
	}), CHICKEN_MASK("butchercraft:chicken_mask", 3, new int[] { 1, 1, 1, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(Items.FEATHER);
	});

	private static final int[] HEALTH_PER_SLOT = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	@SuppressWarnings("deprecation")
	private final LazyLoadedValue<Ingredient> repairIngredient;

	BCArmorMaterial(String name, int durability, int[] protection, int enchantability, SoundEvent sound,
			float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durability;
		this.slotProtections = protection;
		this.enchantmentValue = enchantability;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
	}

	public int getDurabilityForType(ArmorItem.Type type) {
		return HEALTH_PER_SLOT[type.getSlot().getIndex()] * this.durabilityMultiplier;
	}

	public int getDefenseForType(ArmorItem.Type type) {
		return this.slotProtections[type.getSlot().getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public SoundEvent getEquipSound() {
		return this.sound;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
