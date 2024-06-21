package com.lance5057.butchercraft.data.builders;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.ButchercraftMobEffects;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EffectsChangedTrigger;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MobEffectsPredicate;
import net.minecraft.advancements.critereon.PlayerInteractTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class Advancements implements ForgeAdvancementProvider.AdvancementGenerator {
	private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

	private Advancement root;

	private Advancement hook;
	private Advancement butcher_block;

	private Advancement blood;
	private Advancement barn_wood;

	private Advancement butcherknife;
	private Advancement skinningknife;
	private Advancement gutknife;
	private Advancement bonesaw;

	private Advancement stink;
	private Advancement bloody;
	private Advancement trail;
	private Advancement hands;

	private Advancement soap;
	private Advancement apron;
	private Advancement gloves;
	private Advancement boots;
	private Advancement mask;
	private Advancement hat;

	private Advancement grinder;
	private Advancement extruder;
	private Advancement grinder_tip;
	private Advancement sausage;

	private Advancement cow;
	private Advancement pig;
	private Advancement sheep;
	private Advancement rabbit;
	private Advancement chicken;
	private Advancement goat;

	private Advancement bunny_equip;
	private Advancement taxadermy;

	private Advancement whole_cow;
	private Advancement whole_pig;
	private Advancement whole_sheep;
	private Advancement whole_goat;
	private Advancement whole_chicken;
	private Advancement whole_rabbit;

	private Advancement everything;
	private Advancement everything_plus;

	private Advancement heart;
	private Advancement cannibalism;



	@Override
	public void generate(@NotNull HolderLookup.Provider registries, @NotNull Consumer<Advancement> consumer, @NotNull ExistingFileHelper existingFileHelper) {
		root = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BUTCHER_KNIFE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.root.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.root.desc"),
						new ResourceLocation("butchercraft:textures/background.png"), FrameType.TASK, false, false,
						true))
				.addCriterion("tick",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BUTCHER_KNIFE.get()))
				.save(consumer, Butchercraft.MOD_ID + ":root");

		butcherknife = Advancement.Builder.advancement().parent(root)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BUTCHER_KNIFE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.butcherknife.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.butcherknife.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("butcherknife",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BUTCHER_KNIFE.get()))
				.save(consumer, Butchercraft.MOD_ID + ":butcherknife");

		skinningknife = Advancement.Builder.advancement().parent(root)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.SKINNING_KNIFE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.skinningknife.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.skinningknife.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("skinningknife",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.SKINNING_KNIFE.get()))
				.save(consumer, Butchercraft.MOD_ID + ":skinningknife");

		gutknife = Advancement.Builder.advancement().parent(root)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.GUT_KNIFE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.gutknife.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.gutknife.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("gutknife",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.GUT_KNIFE.get()))
				.save(consumer, Butchercraft.MOD_ID + ":gutknife");

		bonesaw = Advancement.Builder.advancement().parent(root)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BONE_SAW.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.bonesaw.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.bonesaw.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("bonesaw",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BONE_SAW.get()))
				.save(consumer, Butchercraft.MOD_ID + ":bonesaw");

		hook = Advancement.Builder.advancement().parent(butcherknife)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.HOOK_BLOCK_ITEM.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.hook.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.hook.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("hook",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.HOOK_BLOCK_ITEM.get()))
				.save(consumer, Butchercraft.MOD_ID + ":hook");

		blood = Advancement.Builder.advancement().parent(butcherknife)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BLOOD_FLUID_BUCKET.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.blood.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.blood.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("blood",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BLOOD_FLUID_BUCKET.get()))
				.save(consumer, Butchercraft.MOD_ID + ":blood");

		stink = Advancement.Builder.advancement().parent(blood)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BEAK.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.stink.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.stink.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("stink",
						EffectsChangedTrigger.TriggerInstance
								.hasEffects(MobEffectsPredicate.effects().and(ButchercraftMobEffects.STINKY.get())))
				.save(consumer, Butchercraft.MOD_ID + ":stink");

		bloody = Advancement.Builder.advancement().parent(blood)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BLOOD_FLUID_BOTTLE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.bloody.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.bloody.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("bloody",
						EffectsChangedTrigger.TriggerInstance
								.hasEffects(MobEffectsPredicate.effects().and(ButchercraftMobEffects.BLOODY.get())))
				.save(consumer, Butchercraft.MOD_ID + ":bloody");

		trail = Advancement.Builder.advancement().parent(blood)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BLOOD_SAUSAGE_LINKED.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.trail.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.trail.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("trail",
						EffectsChangedTrigger.TriggerInstance
								.hasEffects(MobEffectsPredicate.effects().and(ButchercraftMobEffects.BLOODTRAIL.get())))
				.save(consumer, Butchercraft.MOD_ID + ":trail");

		hands = Advancement.Builder.advancement().parent(blood)
				.display(new DisplayInfo(new ItemStack(Items.DIRT),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.hands.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.hands.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("hands",
						EffectsChangedTrigger.TriggerInstance
								.hasEffects(MobEffectsPredicate.effects().and(ButchercraftMobEffects.DIRTY.get())))
				.save(consumer, Butchercraft.MOD_ID + ":hands");

		soap = Advancement.Builder.advancement().parent(blood)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.SOAP.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.soap.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.soap.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("soap", InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.SOAP.get()))
				.save(consumer, Butchercraft.MOD_ID + ":soap");

		apron = Advancement.Builder.advancement().parent(bloody)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.APRON.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.apron.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.apron.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("apron", InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.APRON.get()))
				.save(consumer, Butchercraft.MOD_ID + ":apron");

		gloves = Advancement.Builder.advancement().parent(hands)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.GLOVES.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.gloves.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.gloves.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("gloves", InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.GLOVES.get()))
				.save(consumer, Butchercraft.MOD_ID + ":gloves");

		boots = Advancement.Builder.advancement().parent(trail)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BOOTS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.boots.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.boots.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("boots", InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BOOTS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":boots");

		mask = Advancement.Builder.advancement().parent(stink)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.MASK.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.mask.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.mask.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("mask", InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.MASK.get()))
				.save(consumer, Butchercraft.MOD_ID + ":mask");

		hat = Advancement.Builder.advancement().parent(root)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.PAPER_HAT.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.hat.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.hat.desc"), null, FrameType.GOAL,
						true, true, true))
				.addCriterion("hat", InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.PAPER_HAT.get()))
				.save(consumer, Butchercraft.MOD_ID + ":hat");

		barn_wood = Advancement.Builder.advancement().parent(blood)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.barn_wood.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.barn_wood.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("barn_wood",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BARN_WOOD_BLOCK_ITEM.get()))
				.save(consumer, Butchercraft.MOD_ID + ":barn_wood");

		butcher_block = Advancement.Builder.advancement().parent(butcherknife)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BUTCHER_BLOCK_BLOCK_ITEM.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.butcherblock.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.butcherblock.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("butcherblock",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.HOOK_BLOCK_ITEM.get()))
				.save(consumer, Butchercraft.MOD_ID + ":butcherblock");

		cow = Advancement.Builder.advancement().parent(hook)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.COW_CARCASS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.cow.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.cow.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("cow",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.COW_CARCASS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":cow");

		pig = Advancement.Builder.advancement().parent(hook)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.PIG_CARCASS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.pig.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.pig.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("pig",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.PIG_CARCASS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":pig");

		sheep = Advancement.Builder.advancement().parent(hook)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.SHEEP_CARCASS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.sheep.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.sheep.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("sheep",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.SHEEP_CARCASS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":sheep");

		goat = Advancement.Builder.advancement().parent(hook)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.GOAT_CARCASS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.goat.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.goat.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("goat",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.GOAT_CARCASS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":goat");

		rabbit = Advancement.Builder.advancement().parent(butcher_block)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BROWN_RABBIT_CARCASS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.rabbit.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.rabbit.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("rabbit", InventoryChangeTrigger.TriggerInstance.hasItems(
						ButchercraftItems.BROWN_RABBIT_CARCASS.get(), ButchercraftItems.BLACK_RABBIT_CARCASS.get(),
						ButchercraftItems.GOLD_RABBIT_CARCASS.get(), ButchercraftItems.SALT_RABBIT_CARCASS.get(),
						ButchercraftItems.SPLOTCHED_RABBIT_CARCASS.get(), ButchercraftItems.WHITE_RABBIT_CARCASS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":rabbit");

		chicken = Advancement.Builder.advancement().parent(butcher_block)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.CHICKEN_CARCASS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.chicken.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.chicken.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("chicken",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.CHICKEN_CARCASS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":chicken");

		grinder = Advancement.Builder.advancement().parent(root)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.GRINDER_BLOCK_ITEM.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.grinder.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.grinder.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("grinder",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.GRINDER_BLOCK_ITEM.get()))
				.save(consumer, Butchercraft.MOD_ID + ":grinder");
		
		grinder_tip = Advancement.Builder.advancement().parent(grinder)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.GRINDER_TIP.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.grinder_tip.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.grinder_tip.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("grinder_tip",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.GRINDER_TIP.get()))
				.save(consumer, Butchercraft.MOD_ID + ":grinder_tip");
		
		extruder = Advancement.Builder.advancement().parent(grinder)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.EXTRUDER_TIP.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.extruder.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.extruder.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("extruder",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.EXTRUDER_TIP.get()))
				.save(consumer, Butchercraft.MOD_ID + ":extruder");

		sausage = Advancement.Builder.advancement().parent(extruder)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.SAUSAGE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.sausage.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.sausage.desc"), null, FrameType.GOAL,
						true, true, false))
				.addCriterion("blood_sausage",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BLOOD_SAUSAGE_LINKED.get()))
				.addCriterion("sausage",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.SAUSAGE_LINKED.get()))
				.save(consumer, Butchercraft.MOD_ID + ":sausage");

		bunny_equip = Advancement.Builder.advancement().parent(rabbit)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.WHITE_BUNNY_TAIL.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.bunny_equip.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.bunny_equip.desc"), null,
						FrameType.GOAL, true, true, true))
				.addCriterion("bunny_equip_ears",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ButchercraftItemTags.BUNNY_EARS).build()))
				.addCriterion("bunny_equip_tail",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ButchercraftItemTags.BUNNY_TAILS).build()))
				.save(consumer, Butchercraft.MOD_ID + ":bunny_equip");

		taxadermy = Advancement.Builder.advancement().parent(root)
				.display(new DisplayInfo(new ItemStack(Items.HAY_BLOCK),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.taxadermy.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.taxadermy.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("taxadermy",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ButchercraftItemTags.TAXIDERMY).build()))
				.save(consumer, Butchercraft.MOD_ID + ":taxadermy");

		whole_cow = Advancement.Builder.advancement().parent(cow)
				.display(new DisplayInfo(new ItemStack(Items.COOKED_BEEF),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_cow.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_cow.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_cow_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_RIBS.get()))
				.addCriterion("whole_cow_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_ROAST.get()))
				.addCriterion("whole_cow_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_SCRAPS.get()))
				.addCriterion("whole_cow_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_STEW_MEAT.get()))
				.addCriterion("whole_cow_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_BEEF.get()))
				.addCriterion("whole_cow_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_BEEF.get()))
				.save(consumer, Butchercraft.MOD_ID + ":whole_cow");

		whole_pig = Advancement.Builder.advancement().parent(pig)
				.display(new DisplayInfo(new ItemStack(Items.COOKED_PORKCHOP),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_pig.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_pig.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_pig_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_RIBS.get()))
				.addCriterion("whole_pig_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_ROAST.get()))
				.addCriterion("whole_pig_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_SCRAPS.get()))
				.addCriterion("whole_pig_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_STEW_MEAT.get()))
				.addCriterion("whole_pig_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_PORK.get()))
				.addCriterion("whole_pig_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_PORK.get()))
				.save(consumer, Butchercraft.MOD_ID + ":whole_pig");

		whole_sheep = Advancement.Builder.advancement().parent(sheep)
				.display(new DisplayInfo(new ItemStack(Items.COOKED_MUTTON),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_sheep.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_sheep.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_sheep_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_RIBS.get()))
				.addCriterion("whole_sheep_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_ROAST.get()))
				.addCriterion("whole_sheep_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_SCRAPS.get()))
				.addCriterion("whole_sheep_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get()))
				.addCriterion("whole_sheep_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_MUTTON.get()))
				.addCriterion("whole_sheep_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_MUTTON.get()))
				.save(consumer, Butchercraft.MOD_ID + ":whole_sheep");

		whole_rabbit = Advancement.Builder.advancement().parent(rabbit)
				.display(new DisplayInfo(new ItemStack(Items.COOKED_RABBIT),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_rabbit.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_rabbit.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_rabbit_leg",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_RABBIT_LEG.get()))
				.addCriterion("whole_rabbit_saddle",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_RABBIT_SADDLE.get()))
				.addCriterion("whole_rabbit_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_RABBIT.get()))
				.addCriterion("whole_rabbit_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_RABBIT_SCRAPS.get()))
				.addCriterion("whole_rabbit_thigh",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_RABBIT_THIGH.get()))
				.addCriterion("whole_rabbit_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_STEW_RABBIT.get()))
				.addCriterion("whole_rabbit_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_RABBIT.get()))
				.save(consumer, Butchercraft.MOD_ID + ":whole_rabbit");

		whole_chicken = Advancement.Builder.advancement().parent(chicken)
				.display(new DisplayInfo(new ItemStack(Items.COOKED_CHICKEN),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_chicken.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_chicken.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_chicken_breast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CHICKEN_BREAST.get()))
				.addCriterion("whole_chicken_leg",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CHICKEN_LEG.get()))
				.addCriterion("whole_chicken_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CHICKEN_SCRAPS.get()))
				.addCriterion("whole_chicken_thigh",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CHICKEN_THIGH.get()))
				.addCriterion("whole_chicken_wing",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CHICKEN_WING.get()))
				.addCriterion("whole_chicken_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_CHICKEN.get()))
				.addCriterion("whole_chicken_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_STEW_CHICKEN.get()))
				.addCriterion("whole_chicken_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_CHICKEN.get()))
				.save(consumer, Butchercraft.MOD_ID + ":whole_chicken");

		whole_goat = Advancement.Builder.advancement().parent(goat)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.COOKED_GOAT_CHOP.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_goat.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_goat.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_goat_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_RIBS.get()))
				.addCriterion("whole_goat_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_ROAST.get()))
				.addCriterion("whole_goat_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_SCRAPS.get()))
				.addCriterion("whole_goat_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get()))
				.addCriterion("whole_goat_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_MUTTON.get()))
				.addCriterion("whole_goat_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_MUTTON.get()))
				.save(consumer, Butchercraft.MOD_ID + ":whole_goat");

		everything = Advancement.Builder.advancement().parent(butcherknife)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.SAUSAGE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.everything.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.everything.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_cow_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_RIBS.get()))
				.addCriterion("whole_cow_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_ROAST.get()))
				.addCriterion("whole_cow_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_SCRAPS.get()))
				.addCriterion("whole_cow_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_STEW_MEAT.get()))
				.addCriterion("whole_cow_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_BEEF.get()))
				.addCriterion("whole_cow_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_BEEF.get()))
				.addCriterion("whole_pig_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_RIBS.get()))
				.addCriterion("whole_pig_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_ROAST.get()))
				.addCriterion("whole_pig_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_SCRAPS.get()))
				.addCriterion("whole_pig_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_STEW_MEAT.get()))
				.addCriterion("whole_pig_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_PORK.get()))
				.addCriterion("whole_pig_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_PORK.get()))
				.addCriterion("whole_sheep_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_RIBS.get()))
				.addCriterion("whole_sheep_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_ROAST.get()))
				.addCriterion("whole_sheep_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_SCRAPS.get()))
				.addCriterion("whole_sheep_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get()))
				.addCriterion("whole_sheep_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_MUTTON.get()))
				.addCriterion("whole_sheep_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_MUTTON.get()))
				.save(consumer, Butchercraft.MOD_ID + ":everything");

		everything_plus = Advancement.Builder.advancement().parent(everything)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.COOKED_TRIPE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.everything_plus.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.everything_plus.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_cow_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_RIBS.get()))
				.addCriterion("whole_cow_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_ROAST.get()))
				.addCriterion("whole_cow_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_SCRAPS.get()))
				.addCriterion("whole_cow_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_STEW_MEAT.get()))
				.addCriterion("whole_cow_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_BEEF.get()))
				.addCriterion("whole_cow_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_BEEF.get()))
				.addCriterion("whole_pig_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_RIBS.get()))
				.addCriterion("whole_pig_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_ROAST.get()))
				.addCriterion("whole_pig_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_SCRAPS.get()))
				.addCriterion("whole_pig_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_STEW_MEAT.get()))
				.addCriterion("whole_pig_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_PORK.get()))
				.addCriterion("whole_pig_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_PORK.get()))
				.addCriterion("whole_sheep_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_RIBS.get()))
				.addCriterion("whole_sheep_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_ROAST.get()))
				.addCriterion("whole_sheep_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_SCRAPS.get()))
				.addCriterion("whole_sheep_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_MUTTON_STEW_MEAT.get()))
				.addCriterion("whole_sheep_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_MUTTON.get()))
				.addCriterion("whole_sheep_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_MUTTON.get()))
				.addCriterion("everything_plus_brain",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BRAIN.get()))
				.addCriterion("everything_plus_heart",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_HEART.get()))
				.addCriterion("everything_plus_kidney",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_KIDNEY.get()))
				.addCriterion("everything_plus_liver",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LIVER.get()))
				.addCriterion("everything_plus_lung",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LUNG.get()))
				.addCriterion("everything_plus_stomach",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_STOMACH.get()))
				.addCriterion("everything_plus_tripe",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_TRIPE.get()))
				.save(consumer, Butchercraft.MOD_ID + ":everything_plus");

		DisplayInfo dheart = new DisplayInfo(new ItemStack(ButchercraftItems.HEART.get()),
				Component.translatable(Butchercraft.MOD_ID + ".advancement.heart.name"),
				Component.translatable(Butchercraft.MOD_ID + ".advancement.heart.desc"), null, FrameType.CHALLENGE,
				true, true, true);

		// Challenges
		heart = Advancement.Builder.advancement().parent(root).display(dheart)
				.addCriterion("heart", ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.HEART.get()))
				.save(consumer, Butchercraft.MOD_ID + ":heart");

		cannibalism = Advancement.Builder.advancement().parent(root)
				.display(new DisplayInfo(new ItemStack(Items.PLAYER_HEAD),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.cannibalism.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.cannibalism.desc"), null,
						FrameType.CHALLENGE, true, true, true))
				.addCriterion("cannibalism",
						PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(ContextAwarePredicate.ANY,
								ItemPredicate.Builder.item().of(ButchercraftItems.BUTCHER_KNIFE.get()),
								EntityPredicate.wrap(EntityPredicate.Builder.entity().of(EntityType.PLAYER).build())))
				.save(consumer, Butchercraft.MOD_ID + ":cannibalism");
	}
}
