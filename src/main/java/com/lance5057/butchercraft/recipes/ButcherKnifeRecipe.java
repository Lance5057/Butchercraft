package com.lance5057.butchercraft.recipes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class ButcherKnifeRecipe implements Recipe<ButcherKnifeWrapper> {
    private final ResourceLocation id;
    private final Mob entity;
    private final ItemStack output;

    public ButcherKnifeRecipe(ResourceLocation id, Mob entity, ItemStack output) {
        this.id = id;
        this.entity = entity;
        this.output = output;
    }

    @Override
    public boolean matches(ButcherKnifeWrapper wrapper, Level world) {
        return wrapper.getEntity() == this.entity;
    }

    @Override
    public ItemStack assemble(ButcherKnifeWrapper p_77572_1_) {
        return this.getResultItem();
    }

    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        // TODO Auto-generated method stub
        return null;
    }

}
