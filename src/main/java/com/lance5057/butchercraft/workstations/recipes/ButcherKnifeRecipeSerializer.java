package com.lance5057.butchercraft.workstations.recipes;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

public class ButcherKnifeRecipeSerializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<ButcherKnifeRecipe> {
    @Override
    public ButcherKnifeRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        final EntityType<?> entity = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(pSerializedRecipe.get("entity").getAsString()));
        final ItemStack output = ShapedRecipe.itemStackFromJson(pSerializedRecipe.getAsJsonObject("result"));
        return new ButcherKnifeRecipe(pRecipeId, entity, output);
    }

    @Nullable
    @Override
    public ButcherKnifeRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        final EntityType<?> entity = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(pBuffer.readUtf()));
        final ItemStack output = pBuffer.readItem();
        return new ButcherKnifeRecipe(pRecipeId, entity, output);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, ButcherKnifeRecipe pRecipe) {
        pBuffer.writeUtf(pRecipe.getEntity().getRegistryName().toString());
        pBuffer.writeItem(pRecipe.getOutput());
    }
}
