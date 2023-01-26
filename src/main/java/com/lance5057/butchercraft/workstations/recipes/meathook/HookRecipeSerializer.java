package com.lance5057.butchercraft.workstations.recipes.meathook;

import com.google.gson.JsonObject;
import com.lance5057.butchercraft.workstations.recipes.AnimatedRecipeItemUse;
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
		final Ingredient carcass = Ingredient.fromJson(pSerializedRecipe.get("carcass"));
		return new HookRecipe(pRecipeId, group, carcass, recipeItemUses);
	}

	public HookRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
		String group = buffer.readUtf();
		Ingredient carcassIn = Ingredient.fromNetwork(buffer);
		int listSize = buffer.readVarInt();

		NonNullList<AnimatedRecipeItemUse> tools = NonNullList.withSize(listSize, AnimatedRecipeItemUse.EMPTY);
		tools.replaceAll(ignored -> AnimatedRecipeItemUse.read(buffer));
		return new HookRecipe(recipeId, group, carcassIn, tools);
	}

	public void toNetwork(FriendlyByteBuf buffer, HookRecipe recipe) {
		buffer.writeUtf(recipe.getGroup());

		recipe.getCarcassIn().toNetwork(buffer);

		buffer.writeVarInt(recipe.getRecipeToolsIn().size());

		recipe.getRecipeToolsIn().forEach(riu -> AnimatedRecipeItemUse.write(riu, buffer));
	}
}