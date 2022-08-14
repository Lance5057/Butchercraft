package lance5057.butchercraft;

import lance5057.butchercraft.recipes.ButcherKnifeRecipe;
import lance5057.butchercraft.workstations.recipes.RecipeHook;
import lance5057.butchercraft.workstations.recipes.RecipeHookSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ButchercraftRecipes {
    public static final RecipeType<RecipeHook> HOOK = RecipeType.register("recipe_hook");
    public static final RecipeType<ButcherKnifeRecipe> KNIFE = RecipeType.register("recipe_knife");
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister
            .create(ForgeRegistries.RECIPE_SERIALIZERS, Butchercraft.MOD_ID);
    public static final RegistryObject<RecipeSerializer<RecipeHook>> HOOK_SERIALIZER = RECIPE_SERIALIZERS
            .register("hook_serializer", RecipeHookSerializer::new);
}
