package com.lance5057.butchercraft.data.builders;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.client.BlacklistedModel;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimatedFloat;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimatedFloatVector3;
import com.lance5057.butchercraft.client.rendering.animation.floats.AnimationFloatTransform;
import com.lance5057.butchercraft.items.ButchercraftItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ButchercraftRecipeProvider extends RecipeProvider {

	public ButchercraftRecipeProvider(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
		MeatHookRecipeBuilder.shapedRecipe(ButchercraftItems.COW_CARCASS.get()).tool(
				Ingredient.of(ButchercraftItems.SKINNING_KNIFE.get()), 6, true,
				new ResourceLocation(Butchercraft.MOD_ID, "recipes/meat_hook/cow"),
				new BlacklistedModel(Items.DIAMOND_SWORD,
						new AnimationFloatTransform().setRotation(
								new AnimatedFloatVector3().setY(new AnimatedFloat(0, 360, 0, 0.1f, true, false)))))
				.save(consumer, new ResourceLocation(Butchercraft.MOD_ID, "cowtest"));
	}

}
