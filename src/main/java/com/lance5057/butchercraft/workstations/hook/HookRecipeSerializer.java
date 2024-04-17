package com.lance5057.butchercraft.workstations.hook;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class HookRecipeSerializer implements RecipeSerializer<HookRecipe> {

	@Override
	public HookRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
		String group = GsonHelper.getAsString(pSerializedRecipe, "group", "");
		NonNullList<AnimatedRecipeItemUse> recipeItemUses = NonNullList.create();
		pSerializedRecipe.getAsJsonArray("tools").forEach(jsonElement -> recipeItemUses.add(AnimatedRecipeItemUse.read(jsonElement.getAsJsonObject())));
		NonNullList<Ingredient> jei = itemsFromJson(pSerializedRecipe.getAsJsonArray("jei"));
		
		final Ingredient carcass = Ingredient.fromJson(pSerializedRecipe.get("carcass"));
		return new HookRecipe(pRecipeId, group, carcass, recipeItemUses, jei);
	}
	
	private static NonNullList<Ingredient> itemsFromJson(JsonArray pIngredientArray) {
		NonNullList<Ingredient> nonnulllist = NonNullList.create();

		for (int i = 0; i < pIngredientArray.size(); ++i) {
			Ingredient ingredient = Ingredient.fromJson(pIngredientArray.get(i));
			nonnulllist.add(ingredient);
		}

		return nonnulllist;
	}

	public HookRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
		String group = buffer.readUtf();
		Ingredient carcassIn = Ingredient.fromNetwork(buffer);
		int listSize = buffer.readVarInt();

		NonNullList<AnimatedRecipeItemUse> tools = NonNullList.withSize(listSize, AnimatedRecipeItemUse.EMPTY);
		tools.replaceAll(ignored -> AnimatedRecipeItemUse.read(buffer));
		
		int jeiSize = buffer.readVarInt();
		NonNullList<Ingredient> jei = NonNullList.withSize(jeiSize, Ingredient.EMPTY);
		jei.replaceAll(ignored -> Ingredient.fromNetwork(buffer));
		return new HookRecipe(recipeId, group, carcassIn, tools, jei);
	}

	public void toNetwork(FriendlyByteBuf buffer, HookRecipe recipe) {
		buffer.writeUtf(recipe.getGroup());

		recipe.getCarcassIn().toNetwork(buffer);

		buffer.writeVarInt(recipe.getRecipeToolsIn().size());

		recipe.getRecipeToolsIn().forEach(riu -> AnimatedRecipeItemUse.write(riu, buffer));
		
		buffer.writeVarInt(recipe.getDummyList().size());
		
		recipe.getDummyList().forEach(i -> i.toNetwork(buffer));
	}
}