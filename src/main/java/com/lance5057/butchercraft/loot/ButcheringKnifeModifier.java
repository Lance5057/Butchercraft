package com.lance5057.butchercraft.loot;

import com.google.gson.JsonObject;
import com.lance5057.butchercraft.data.builders.ButcherKnifeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class ButcheringKnifeModifier extends LootModifier {
	private final ItemStack output;
	private final EntityType<?> entityType;

	/**
	 * Constructs a LootModifier.
	 *
	 * @param conditionsIn the ILootConditions that need to be matched before the
	 *                     loot is modified.
	 */
	public ButcheringKnifeModifier(LootItemCondition[] conditionsIn, ItemStack output, EntityType<?> entityType) {
		super(conditionsIn);
		this.output = output;
		this.entityType = entityType;
	}

	@NotNull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		if (Arrays.stream(conditions).allMatch(lootItemCondition -> lootItemCondition.test(context))) {
			generatedLoot = List.of(output);
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<ButcheringKnifeModifier> {
		@Override
		public ButcheringKnifeModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] lootItemConditions) {
			ItemStack output = ShapedRecipe.itemStackFromJson(object.getAsJsonObject("result"));
			EntityType<?> mobType = EntityType.byString(object.get("entity_type").getAsString()).orElseThrow();

			return new ButcheringKnifeModifier(lootItemConditions, output, mobType);
		}

		@Override
		public JsonObject write(ButcheringKnifeModifier instance) {
			JsonObject jsonObject = makeConditions(instance.conditions);
			jsonObject.add("result", ButcherKnifeRecipeBuilder.serializeItemstack(instance.output));
			jsonObject.addProperty("entity_type", instance.entityType.getRegistryName().toString());
			return jsonObject;
		}
	}
}
