package lance5057.butchercraft.workstations.recipes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RecipeHookSerializer extends ForgeRegistryEntry<RecipeSerializer<?>>
	    implements RecipeSerializer<RecipeHook> {

	@Override
	public RecipeHook fromJson(ResourceLocation p_199425_1_, JsonObject p_199425_2_) {
		return null;
	}

	@Nullable
	@Override
	public RecipeHook fromNetwork(ResourceLocation p_199426_1_, FriendlyByteBuf p_199426_2_) {
		return null;
	}

	@Override
	public void toNetwork(FriendlyByteBuf p_199427_1_, RecipeHook p_199427_2_) {

	}
}