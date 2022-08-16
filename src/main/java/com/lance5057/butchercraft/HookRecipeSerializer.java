package com.lance5057.butchercraft;

import com.google.gson.JsonObject;
import com.lance5057.butchercraft.workstations.recipes.HookRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.storage.loot.Deserializers;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class HookRecipeSerializer extends ForgeRegistryEntry<RecipeSerializer<?>>
        implements RecipeSerializer<HookRecipe> {

    @Override
    public HookRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        final Ingredient carcassInput = Ingredient.fromJson(pSerializedRecipe.get("carcass"));
        final Ingredient butcheringTool = Ingredient.fromJson(pSerializedRecipe.getAsJsonObject("tool"));
        final int butcheringStage = pSerializedRecipe.get("stage").getAsInt();
        final LootTable butcheringDrops = LootTable.EMPTY;
        final String group = pSerializedRecipe.get("group").getAsString();
        return new HookRecipe(pRecipeId, carcassInput, butcheringTool, butcheringStage, butcheringDrops, group);
    }

    @Override
    public HookRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, HookRecipe pRecipe) {
        pRecipe.getInput().toNetwork(pBuffer);
        pRecipe.getRecipeTools().toNetwork(pBuffer);
        pBuffer.writeUtf(pRecipe.getGroup());
    }
}