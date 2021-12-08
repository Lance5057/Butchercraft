package lance5057.butchercraft.workstations.recipes;

import lance5057.butchercraft.ButchercraftRecipes;
import lance5057.butchercraft.util.RecipeItemUse;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RecipeHook implements IRecipe<RecipeHookWrapper> {

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
    public boolean matches(RecipeHookWrapper p_77569_1_, World p_77569_2_) {
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
    public IRecipeSerializer<?> getSerializer() {
	return ButchercraftRecipes.HOOK_SERIALIZER.get();
    }

    @Override
    public IRecipeType<?> getType() {
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
