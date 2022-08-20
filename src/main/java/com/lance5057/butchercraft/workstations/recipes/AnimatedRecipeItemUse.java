package com.lance5057.butchercraft.workstations.recipes;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.util.RecipeItemUse;

import net.minecraft.core.Vec3i;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public class AnimatedRecipeItemUse extends RecipeItemUse {

	public final List<BlacklistedModel> model;

	public static final AnimatedRecipeItemUse EMPTY = new AnimatedRecipeItemUse(RecipeItemUse.EMPTY, BlacklistedModel.empty);

	public AnimatedRecipeItemUse(int uses, Ingredient tool, int count, boolean damage, ResourceLocation loottable,
			BlacklistedModel... model) {
		super(uses, tool, count, damage, loottable);

		this.model = List.of(model);
	}

	public AnimatedRecipeItemUse(RecipeItemUse riu, BlacklistedModel... model) {
		super(riu.uses, riu.tool, riu.count, riu.damageTool, riu.lootTable);

		this.model = List.of(model);
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
		RecipeItemUse.write(r, buffer);

		buffer.writeInt(r.model.size());

		for (int i = 0; i < r.model.size(); i++)
			BlacklistedModel.write(r.model.get(i), buffer);
	}

	public static JsonObject addProperty(AnimatedRecipeItemUse recipeItemUse) {
		JsonObject o = RecipeItemUse.addProperty(recipeItemUse);

		if (recipeItemUse.model != null && !recipeItemUse.model.isEmpty()) {
			JsonArray ja = new JsonArray();
			for (int i = 0; i < recipeItemUse.model.size(); i++)
				ja.add(BlacklistedModel.addProperty(recipeItemUse.model.get(i)));

			o.add("models", ja);
		}

		return o;
	}

	public Vec3i getToolList() {
		// TODO Auto-generated method stub
		return null;
	}
}
