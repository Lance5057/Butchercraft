package com.lance5057.butchercraft.workstations.recipes;

import java.util.Map;

import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class HookRecipeSerializer extends ForgeRegistryEntry<RecipeSerializer<?>>
		implements RecipeSerializer<HookRecipe> {

	@Override
	public HookRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
//		final Ingredient carcassInput = Ingredient.fromJson(pSerializedRecipe.get("carcass"));
//		final Ingredient butcheringTool = Ingredient.fromJson(pSerializedRecipe.getAsJsonObject("tool"));
//		final int butcheringStage = pSerializedRecipe.get("stage").getAsInt();
//		// TODO Deserialize this properly
//		final LootTable butcheringDrops = LootTable.EMPTY;
//		final String group = pSerializedRecipe.get("group").getAsString();

		String s = GsonHelper.getAsString(pSerializedRecipe, "group", "");
		Map<String, Ingredient> map = HookRecipe.deserializeKey(GsonHelper.getAsJsonObject(pSerializedRecipe, "key"));
		String[] astring = HookRecipe
				.shrink(HookRecipe.patternFromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "pattern")));
		int i = astring[0].length();
		int j = astring.length;
		NonNullList<Ingredient> nonnulllist = HookRecipe.deserializeIngredients(astring, map, i, j);

		NonNullList<AnimatedRecipeItemUse> nonnulllistTools = HookRecipe
				.deserializeTool(GsonHelper.getAsJsonObject(pSerializedRecipe, "tools"));

		return new HookRecipe(pRecipeId, s, j, j, nonnulllist, nonnulllistTools);
	}

	public HookRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
		String group = buffer.readUtf(32767);

		NonNullList<Ingredient> ingredients = NonNullList.withSize(1, Ingredient.EMPTY);

		ingredients.set(0, Ingredient.fromNetwork(buffer));

		int h = buffer.readVarInt();

		NonNullList<AnimatedRecipeItemUse> tools = NonNullList.withSize(h, AnimatedRecipeItemUse.EMPTY);

		for (int k = 0; k < tools.size(); ++k) {
			tools.set(k, AnimatedRecipeItemUse.read(buffer));
		}

		return new HookRecipe(recipeId, group, h, h, ingredients, tools);
	}

	public void toNetwork(FriendlyByteBuf buffer, HookRecipe recipe) {
		buffer.writeUtf(recipe.getGroup());

		for (Ingredient ingredient : recipe.getRecipeItems()) {
			ingredient.toNetwork(buffer);
		}

		buffer.writeVarInt(recipe.getToolListLength());

		for (AnimatedRecipeItemUse riu : recipe.getRecipeTools())
			AnimatedRecipeItemUse.write(riu, buffer);
	}
}