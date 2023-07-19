package com.lance5057.butchercraft.workstations.grinder;

import com.google.gson.JsonObject;

import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

public class GrinderRecipeSerializer implements RecipeSerializer<GrinderRecipe> {
	@Override
	public GrinderRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
		String s = GsonHelper.getAsString(pJson, "group", "");
		Ingredient ingredient;
		if (GsonHelper.isArrayNode(pJson, "ingredient")) {
			ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(pJson, "ingredient"));
		} else {
			ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pJson, "ingredient"));
		}

		if (!pJson.has("result"))
			throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
		ItemStack itemstack;
		if (pJson.get("result").isJsonObject())
			itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));
		else {
			String s1 = GsonHelper.getAsString(pJson, "result");
			ResourceLocation resourcelocation = new ResourceLocation(s1);
			itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
				return new IllegalStateException("Item: " + s1 + " does not exist");
			}));
		}

		int g = GsonHelper.getAsInt(pJson, "grinds");
		return new GrinderRecipe(pRecipeId, s, ingredient, itemstack, g);
	}

	public GrinderRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
		String s = pBuffer.readUtf();
		Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
		ItemStack itemstack = pBuffer.readItem();
		int g = pBuffer.readInt();
		return new GrinderRecipe(pRecipeId, s, ingredient, itemstack, g);
	}

	public void toNetwork(FriendlyByteBuf pBuffer, GrinderRecipe pRecipe) {
		pBuffer.writeUtf(pRecipe.getGroup());
		pRecipe.ingredient.toNetwork(pBuffer);
		pBuffer.writeItem(pRecipe.result);
		pBuffer.writeInt(pRecipe.grinds);
	}
}