package com.lance5057.butchercraft.workstations.recipes.butcherblock;

import com.google.gson.JsonObject;
import com.lance5057.butchercraft.workstations.recipes.AnimatedRecipeItemUse;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ButcherBlockSerializer extends ForgeRegistryEntry<RecipeSerializer<?>>
		implements RecipeSerializer<ButcherBlockRecipe> {

	@Override
	public ButcherBlockRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
		String group = GsonHelper.getAsString(pSerializedRecipe, "group", "");
		NonNullList<AnimatedRecipeItemUse> recipeItemUses = NonNullList.create();
		pSerializedRecipe.getAsJsonArray("tools")
				.forEach(jsonElement -> recipeItemUses.add(AnimatedRecipeItemUse.read(jsonElement.getAsJsonObject())));
		final Ingredient carcass = Ingredient.fromJson(pSerializedRecipe.get("carcass"));
		return new ButcherBlockRecipe(pRecipeId, group, carcass, recipeItemUses);
	}

	public ButcherBlockRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
		String group = buffer.readUtf();
		Ingredient carcassIn = Ingredient.fromNetwork(buffer);
		int listSize = buffer.readVarInt();

		NonNullList<AnimatedRecipeItemUse> tools = NonNullList.withSize(listSize, AnimatedRecipeItemUse.EMPTY);
		tools.replaceAll(ignored -> AnimatedRecipeItemUse.read(buffer));
		return new ButcherBlockRecipe(recipeId, group, carcassIn, tools);
	}

	public void toNetwork(FriendlyByteBuf buffer, ButcherBlockRecipe recipe) {
		buffer.writeUtf(recipe.getGroup());

		recipe.getCarcassIn().toNetwork(buffer);

		buffer.writeVarInt(recipe.getRecipeToolsIn().size());

		recipe.getRecipeToolsIn().forEach(riu -> AnimatedRecipeItemUse.write(riu, buffer));
	}
}
