package com.lance5057.butchercraft.workstations.recipes;

import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.ButchercraftRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class ButcherKnifeRecipe implements Recipe<ButcherKnifeWrapper> {
    private final ResourceLocation id;
    private final EntityType<?> entity;
    private final ItemStack output;

    public ButcherKnifeRecipe(ResourceLocation id, EntityType<?> entity, ItemStack output) {
        this.id = id;
        this.entity = entity;
        this.output = output;
    }

    public EntityType<?> getEntity() {
        return entity;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Override
    public boolean matches(ButcherKnifeWrapper wrapper, Level world) {
        return wrapper.getEntity() == this.entity;
    }

    @Override
    public ItemStack assemble(ButcherKnifeWrapper pContainer) {
        return this.getResultItem();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
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
        return ButchercraftRecipeSerializers.BUTCHER_KNIFE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ButchercraftRecipes.KNIFE.get();
    }

}
