package lance5057.butchercraft.workstations.recipes;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class HookRecipeSerializer extends ForgeRegistryEntry<RecipeSerializer<?>>
        implements RecipeSerializer<HookRecipe> {

    @Override
    public HookRecipe fromJson(ResourceLocation p_199425_1_, JsonObject p_199425_2_) {
        return null;
    }

    @Nullable
    @Override
    public HookRecipe fromNetwork(ResourceLocation p_199426_1_, FriendlyByteBuf p_199426_2_) {
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf p_199427_1_, HookRecipe p_199427_2_) {

    }
}