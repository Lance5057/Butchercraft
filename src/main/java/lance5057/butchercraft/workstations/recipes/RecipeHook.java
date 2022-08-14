package lance5057.butchercraft.workstations.recipes;

import lance5057.butchercraft.ButchercraftRecipes;
import lance5057.butchercraft.util.RecipeItemUse;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class RecipeHook implements Recipe<RecipeHookWrapper> {

    private final ResourceLocation id;
    private final Ingredient input;
    private final String group;
    private final NonNullList<RecipeItemUse> recipeTools;

    public RecipeHook(ResourceLocation idIn, String groupIn, Ingredient input, NonNullList<RecipeItemUse> tools) {
        id = idIn;
        this.input = input;
        group = groupIn;
        recipeTools = tools;
    }

    @Override
    public boolean matches(RecipeHookWrapper p_77569_1_, Level p_77569_2_) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ItemStack assemble(RecipeHookWrapper p_77572_1_) {
        // unused
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
        return ButchercraftRecipes.HOOK_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ButchercraftRecipes.HOOK;
    }

    public Ingredient getInput() {
        return input;
    }

    public String getGroup() {
        return group;
    }

    public RecipeItemUse getRecipeTools(int stage) {
        return recipeTools.get(stage);
    }

    public boolean matches(ItemStack stackInSlot) {
        return getInput().test(stackInSlot);
    }
}
