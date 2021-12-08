package lance5057.butchercraft.recipes;

import net.minecraft.entity.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ButcherKnifeRecipe implements IRecipe<ButcherKnifeWrapper> {
    private final ResourceLocation id;
    private final MobEntity entity;
    private final ItemStack output;

    public ButcherKnifeRecipe(ResourceLocation id, MobEntity entity, ItemStack output) {
	this.id = id;
	this.entity = entity;
	this.output = output;
    }

    @Override
    public boolean matches(ButcherKnifeWrapper wrapper, World world) {
	if (wrapper.getEntity() == this.entity) {
	    return true;
	}
	return false;
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
    public IRecipeSerializer<?> getSerializer() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public IRecipeType<?> getType() {
	// TODO Auto-generated method stub
	return null;
    }

}
