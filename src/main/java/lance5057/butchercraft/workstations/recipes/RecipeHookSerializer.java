package lance5057.butchercraft.workstations.recipes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RecipeHookSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
	    implements IRecipeSerializer<RecipeHook> {
	@Nonnull
	@Override
	public RecipeHook fromJson(@Nonnull ResourceLocation recipeId, JsonObject json) {

	    return new RecipeHook(result, s, null, recipeTools);
	}

	@Nullable
	@Override
	public RecipeHook fromNetwork(@Nonnull ResourceLocation recipeId, PacketBuffer buffer) {

	    return new RecipeHook(result, s, null, recipeTools);
	}

	@Override
	public void toNetwork(PacketBuffer buffer, RecipeHook recipe) {


	}
    }