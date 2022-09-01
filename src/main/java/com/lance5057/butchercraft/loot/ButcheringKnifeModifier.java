package com.lance5057.butchercraft.loot;

import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class ButcheringKnifeModifier extends LootModifier {
	private final Item output;
	private final int count;
	private final EntityType<?> entityType;

	/**
	 * Constructs a LootModifier.
	 *
	 * @param conditionsIn the ILootConditions that need to be matched before the
	 *                     loot is modified.
	 */
	public ButcheringKnifeModifier(LootItemCondition[] conditionsIn, Item output, int count, EntityType<?> entityType) {
		super(conditionsIn);
		this.output = output;
		this.count = count;
		this.entityType = entityType;
	}

	@NotNull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		if (Arrays.stream(conditions).allMatch(lootItemCondition -> lootItemCondition.test(context))) {
			generatedLoot = List.of(new ItemStack(output, count));
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<ButcheringKnifeModifier> {
		@Override
		public ButcheringKnifeModifier read(ResourceLocation location, JsonObject object,
				LootItemCondition[] lootItemConditions) {
			Item item = Registry.ITEM.getOptional(new ResourceLocation(object.get("item").getAsString())).orElseThrow();
			int count = object.has("count") ? object.get("count").getAsInt() : 1;
			EntityType<?> mobType = EntityType.byString(object.get("entity_type").getAsString()).orElseThrow();

			return new ButcheringKnifeModifier(lootItemConditions, item, count, mobType);
		}

		@Override
		public JsonObject write(ButcheringKnifeModifier instance) {
			JsonObject jsonObject = makeConditions(instance.conditions);
			jsonObject.addProperty("item", Registry.ITEM.getKey(instance.output).toString());
			if (instance.count > 1) {
				jsonObject.addProperty("count", instance.count);
			}
			jsonObject.addProperty("entity_type", instance.entityType.getRegistryName().toString());
			return jsonObject;
		}
	}
}
