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
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
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

	public static AnimatedRecipeItemUse read(RegistryFriendlyByteBuf buffer) {
		RecipeItemUse riu = RecipeItemUse.read(buffer);

		int size = buffer.readInt();

		BlacklistedModel[] b = new BlacklistedModel[size];

		for (int i = 0; i < size; i++)
			b[i] = BlacklistedModel.read(buffer);

		return new AnimatedRecipeItemUse(riu, b);
	}

	public static void write(AnimatedRecipeItemUse r, RegistryFriendlyByteBuf buffer) {
		buffer.writeVarInt(r.uses);
		Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, r.tool);
		buffer.writeVarInt(r.count);
		buffer.writeBoolean(r.damageTool);
		buffer.writeResourceLocation(r.lootTable);

		buffer.writeInt(r.model.size());

		for (int i = 0; i < r.model.size(); i++)
			BlacklistedModel.write(r.model.get(i), buffer);
	}
}
