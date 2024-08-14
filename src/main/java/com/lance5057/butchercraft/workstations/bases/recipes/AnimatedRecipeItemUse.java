package com.lance5057.butchercraft.workstations.bases.recipes;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.util.RecipeItemUse;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.Util;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public record AnimatedRecipeItemUse(
		int uses,
		Ingredient tool,
		int count,
		boolean damageTool,
		ResourceLocation lootTable,
		List<BlacklistedModel> model
) {

	public static final Codec<AnimatedRecipeItemUse> CODEC = RecordCodecBuilder.create(
			inst -> inst.group(
					Codec.INT.fieldOf("uses").forGetter(AnimatedRecipeItemUse::uses),
					Ingredient.CODEC_NONEMPTY.fieldOf("tool").forGetter(AnimatedRecipeItemUse::tool),
					Codec.INT.fieldOf("count").forGetter(AnimatedRecipeItemUse::count),
					Codec.BOOL.fieldOf("damage").forGetter(AnimatedRecipeItemUse::damageTool),
					ResourceLocation.CODEC.fieldOf("loot_table").forGetter(AnimatedRecipeItemUse::lootTable),
					Codec.list(BlacklistedModel.CODEC).fieldOf("models").forGetter(AnimatedRecipeItemUse::model)
			).apply(inst, AnimatedRecipeItemUse::new)
	);

	public static final AnimatedRecipeItemUse EMPTY = new AnimatedRecipeItemUse(RecipeItemUse.EMPTY, BlacklistedModel.empty);

	public AnimatedRecipeItemUse(RecipeItemUse riu, BlacklistedModel... model) {
		this(riu.uses(), riu.tool(), riu.count(), riu.damageTool(), riu.lootTable(), List.of(model));
	}

	public static AnimatedRecipeItemUse read(JsonObject j) {
		RecipeItemUse riu = RecipeItemUse.read(j);

		BlacklistedModel[] b = null;
		if (j.get("models") != null) {
			JsonArray ja = j.get("models").getAsJsonArray();

			b = new BlacklistedModel[ja.size()];

			if (ja != null) {
				for (int i = 0; i < ja.size(); i++) {
					b[i] = BlacklistedModel.read(ja.get(i).getAsJsonObject());
				}
			}
		}

		// BlacklistedModel b = BlacklistedModel.read(j.getAsJsonObject("model"));

		return new AnimatedRecipeItemUse(riu, b);
	}

	public static AnimatedRecipeItemUse read(FriendlyByteBuf buffer) {
		RecipeItemUse riu = RecipeItemUse.read(buffer);

		int size = buffer.readInt();

		BlacklistedModel[] b = new BlacklistedModel[size];

		for (int i = 0; i < size; i++)
			b[i] = BlacklistedModel.read(buffer);

		return new AnimatedRecipeItemUse(riu, b);
	}

	public static void write(AnimatedRecipeItemUse r, FriendlyByteBuf buffer) {
		buffer.writeVarInt(r.uses);
		r.tool.toNetwork(buffer);
		buffer.writeVarInt(r.count);
		buffer.writeBoolean(r.damageTool);
		buffer.writeResourceLocation(r.lootTable);

		buffer.writeInt(r.model.size());

		for (int i = 0; i < r.model.size(); i++)
			BlacklistedModel.write(r.model.get(i), buffer);
	}

	public static JsonObject addProperty(AnimatedRecipeItemUse recipeItemUse) {
		JsonObject o = new JsonObject();

		o.addProperty(RecipeItemUse.USES_FIELD, recipeItemUse.uses);
		o.add(RecipeItemUse.TOOL_FIELD, Util.getOrThrow(Ingredient.CODEC.encodeStart(JsonOps.INSTANCE, recipeItemUse.tool), JsonParseException::new));
		o.addProperty(RecipeItemUse.COUNT_FIELD, recipeItemUse.count);
		o.addProperty(RecipeItemUse.DAMAGE_FIELD, recipeItemUse.damageTool);
		o.addProperty(RecipeItemUse.LOOT_TABLE_FIELD, recipeItemUse.lootTable.toString());

		if (recipeItemUse.model != null && !recipeItemUse.model.isEmpty()) {
			JsonArray ja = new JsonArray();
			for (int i = 0; i < recipeItemUse.model.size(); i++)
				ja.add(BlacklistedModel.addProperty(recipeItemUse.model.get(i)));

			o.add("models", ja);
		}

		return o;
	}
}
