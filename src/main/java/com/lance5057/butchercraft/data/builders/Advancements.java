package com.lance5057.butchercraft.data.builders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.function.Consumer;
import vectorwing.farmersdelight.common.registry.ModItems;

public class Advancements extends AdvancementProvider {
	private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
	private final DataGenerator dataGenerator;

	private Advancement root;

	private Advancement hook;

	private Advancement butcherknife;
	private Advancement skinningknife;
	private Advancement gutknife;
	private Advancement bonesaw;

	private Advancement cow;
	private Advancement pig;
	private Advancement sheep;

	private Advancement whole_cow;
	private Advancement whole_pig;
	private Advancement whole_sheep;

	private Advancement everything;
	private Advancement everything_plus;

	private Advancement heart;
	private Advancement cannibalism;

	public Advancements(@Nonnull DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, existingFileHelper);
		this.dataGenerator = dataGenerator;
	}

	@Override
	protected void registerAdvancements(@NotNull Consumer<Advancement> consumer, @NotNull ExistingFileHelper fileHelper) {
		root = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BUTCHER_KNIFE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.root.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.root.desc"),
						new ResourceLocation("butchercraft:textures/background.png"), FrameType.TASK, false, false,
						true))
				.addCriterion("tick", InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BUTCHER_KNIFE.get()))
				.save(consumer, Butchercraft.MOD_ID + ":root");

		hook = Advancement.Builder.advancement().parent(root)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.HOOK_BLOCK_ITEM.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.hook.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.hook.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("hook",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.HOOK_BLOCK_ITEM.get()))
				.save(consumer, Butchercraft.MOD_ID + ":hook");

//		butcherknife = Advancement.Builder.advancement().parent(hook)
//				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BUTCHER_KNIFE.get()),
//						Component.translatable(Butchercraft.MOD_ID + ".advancement.butcherknife.name"),
//						Component.translatable(Butchercraft.MOD_ID + ".advancement.butcherknife.desc"), null,
//						FrameType.TASK, true, true, false))
//				.addCriterion("butcherknife",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BUTCHER_KNIFE.get()))
//				.save(consumer, Butchercraft.MOD_ID + ":butcherknife");

		skinningknife = Advancement.Builder.advancement().parent(hook)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.SKINNING_KNIFE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.skinningknife.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.skinningknife.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("skinningknife",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.SKINNING_KNIFE.get()))
				.save(consumer, Butchercraft.MOD_ID + ":skinningknife");

		gutknife = Advancement.Builder.advancement().parent(hook)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.GUT_KNIFE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.gutknife.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.gutknife.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("gutknife",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.GUT_KNIFE.get()))
				.save(consumer, Butchercraft.MOD_ID + ":gutknife");

		bonesaw = Advancement.Builder.advancement().parent(hook)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.BONE_SAW.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.bonesaw.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.bonesaw.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("bonesaw",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.BONE_SAW.get()))
				.save(consumer, Butchercraft.MOD_ID + ":bonesaw");

		cow = Advancement.Builder.advancement().parent(butcherknife)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.COW_CARCASS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.cow.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.cow.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("cow",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.COW_CARCASS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":cow");

		pig = Advancement.Builder.advancement().parent(butcherknife)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.PIG_CARCASS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.pig.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.pig.desc"), null, FrameType.TASK,
						true, true, false))
				.addCriterion("pig",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.PIG_CARCASS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":pig");

		sheep = Advancement.Builder.advancement().parent(butcherknife)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.SHEEP_CARCASS.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.sheep.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.sheep.desc"), null,
						FrameType.TASK, true, true, false))
				.addCriterion("sheep",
						InventoryChangeTrigger.TriggerInstance.hasItems(ButchercraftItems.SHEEP_CARCASS.get()))
				.save(consumer, Butchercraft.MOD_ID + ":sheep");

		whole_cow = Advancement.Builder.advancement().parent(cow)
				.display(new DisplayInfo(new ItemStack(Items.COOKED_BEEF),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_cow.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_cow.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_cow_rib",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_RIB.get()))
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
				.addCriterion("whole_pig_rib",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_RIB.get()))
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
				.addCriterion("whole_pig_bacon",
						ConsumeItemTrigger.TriggerInstance.usedItem(ModItems.COOKED_BACON.get()))
				.save(consumer, Butchercraft.MOD_ID + ":whole_pig");

		whole_sheep = Advancement.Builder.advancement().parent(sheep)
				.display(new DisplayInfo(new ItemStack(Items.COOKED_MUTTON),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_sheep.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.whole_sheep.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_sheep_rib",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_RIB.get()))
				.addCriterion("whole_sheep_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_RIBS.get()))
				.addCriterion("whole_sheep_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_ROAST.get()))
				.addCriterion("whole_sheep_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_SCRAPS.get()))
				.addCriterion("whole_sheep_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_STEW_MEAT.get()))
				.addCriterion("whole_sheep_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_LAMB.get()))
				.addCriterion("whole_sheep_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_LAMB.get()))
				.save(consumer, Butchercraft.MOD_ID + ":whole_sheep");

		everything = Advancement.Builder.advancement().parent(whole_sheep).parent(whole_cow).parent(whole_pig)
				.display(new DisplayInfo(new ItemStack(ModItems.COOKED_BACON.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.everything.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.everything.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_cow_rib",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_RIB.get()))
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
				.addCriterion("whole_pig_rib",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_RIB.get()))
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
				.addCriterion("whole_sheep_rib",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_RIB.get()))
				.addCriterion("whole_sheep_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_RIBS.get()))
				.addCriterion("whole_sheep_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_ROAST.get()))
				.addCriterion("whole_sheep_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_SCRAPS.get()))
				.addCriterion("whole_sheep_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_STEW_MEAT.get()))
				.addCriterion("whole_sheep_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_LAMB.get()))
				.addCriterion("whole_sheep_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_LAMB.get()))
				.addCriterion("whole_pig_bacon",
						ConsumeItemTrigger.TriggerInstance.usedItem(ModItems.COOKED_BACON.get()))
				.save(consumer, Butchercraft.MOD_ID + ":everything");

		everything_plus = Advancement.Builder.advancement().parent(everything)
				.display(new DisplayInfo(new ItemStack(ButchercraftItems.COOKED_TRIPE.get()),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.everything_plus.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.everything_plus.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.addCriterion("whole_cow_rib",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_BEEF_RIB.get()))
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
				.addCriterion("whole_pig_rib",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_PORK_RIB.get()))
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
				.addCriterion("whole_sheep_rib",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_RIB.get()))
				.addCriterion("whole_sheep_ribs",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_RIBS.get()))
				.addCriterion("whole_sheep_roast",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_ROAST.get()))
				.addCriterion("whole_sheep_scraps",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_SCRAPS.get()))
				.addCriterion("whole_sheep_stew",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_LAMB_STEW_MEAT.get()))
				.addCriterion("whole_sheep_cubed",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_CUBED_LAMB.get()))
				.addCriterion("whole_sheep_ground",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_GROUND_LAMB.get()))
				.addCriterion("whole_pig_bacon",
						ConsumeItemTrigger.TriggerInstance.usedItem(ModItems.COOKED_BACON.get()))
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
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_STOMACHE.get()))
				.addCriterion("everything_plus_tripe",
						ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.COOKED_TRIPE.get()))
				.save(consumer, Butchercraft.MOD_ID + ":everything_plus");

		DisplayInfo dheart = new DisplayInfo(new ItemStack(ButchercraftItems.HEART.get()),
				Component.translatable(Butchercraft.MOD_ID + ".advancement.heart.name"),
				Component.translatable(Butchercraft.MOD_ID + ".advancement.heart.desc"), null, FrameType.CHALLENGE,
				true, true, true);
		dheart.setLocation(0, 32);

		// Challenges
		heart = Advancement.Builder.advancement().parent(butcherknife).display(dheart)
				.addCriterion("heart", ConsumeItemTrigger.TriggerInstance.usedItem(ButchercraftItems.HEART.get()))
				.save(consumer, Butchercraft.MOD_ID + ":heart");

		cannibalism = Advancement.Builder.advancement().parent(butcherknife)
				.display(new DisplayInfo(new ItemStack(Items.PLAYER_HEAD),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.cannibalism.name"),
						Component.translatable(Butchercraft.MOD_ID + ".advancement.cannibalism.desc"), null,
						FrameType.CHALLENGE, true, true, true))
				.addCriterion("cannibalism",
						PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(EntityPredicate.Composite.ANY,
								ItemPredicate.Builder.item().of(ButchercraftItems.BUTCHER_KNIFE.get()),
								EntityPredicate.Composite
										.wrap(EntityPredicate.Builder.entity().of(EntityType.PLAYER).build())))
				.save(consumer, Butchercraft.MOD_ID + ":cannibalism");
	}

	@Override
	public String getName() {
		return "Butchercraft Advancements";
	}
}
