package com.lance5057.butchercraft.workstations.recipes;

import com.lance5057.butchercraft.ButchercraftRecipeSerializers;
import com.lance5057.butchercraft.ButchercraftRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;

public class HookRecipe implements Recipe<Container> {

    private final ResourceLocation id;
    private final Ingredient input;
    private final Ingredient recipeTools;
    private int butcheringStage;
    private LootTable butcheringDrops;
    private String group;

    public HookRecipe(ResourceLocation idIn, Ingredient input, Ingredient tools, int butcheringStage, LootTable butcheringDrops, String group) {
        id = idIn;
        this.input = input;
        recipeTools = tools;
        this.butcheringStage = butcheringStage;
        this.butcheringDrops = butcheringDrops;
        this.group = group;
    }

    public Ingredient getRecipeTools() {
        return recipeTools;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return false;
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        // unused
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        // does nuffin
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ButchercraftRecipeSerializers.HOOK_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ButchercraftRecipes.HOOK;
    }

    public Ingredient getInput() {
        return input;
    }

    public boolean matches(ItemStack stackInSlot, ItemStack butcheringTool) {
        return getInput().test(stackInSlot) && recipeTools.test(butcheringTool);
    }

    public int getButcheringStage() {
        return butcheringStage;
    }

    public LootTable getButcheringDrops() {
        return butcheringDrops;
    }
}
