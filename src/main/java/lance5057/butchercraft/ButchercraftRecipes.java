package lance5057.butchercraft;

import lance5057.butchercraft.recipes.ButcherKnifeRecipe;
import lance5057.butchercraft.workstations.recipes.RecipeHook;
import lance5057.butchercraft.workstations.recipes.RecipeHookSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ButchercraftRecipes {
    private static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister
	    .create(ForgeRegistries.RECIPE_SERIALIZERS, Butchercraft.MOD_ID);
    
    public static final RegistryObject<IRecipeSerializer<RecipeHook>> HOOK_SERIALIZER = RECIPE_SERIALIZERS
	    .register("hook_serializer", RecipeHookSerializer::new);

    public static final IRecipeType<RecipeHook> HOOK = IRecipeType.register("recipe_hook");
    public static final IRecipeType<ButcherKnifeRecipe> KNIFE = IRecipeType.register("recipe_knife");
}
