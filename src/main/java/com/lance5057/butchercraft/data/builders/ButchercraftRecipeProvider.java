package com.lance5057.butchercraft.data.builders;

import com.google.common.collect.Sets;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

public abstract class ButchercraftRecipeProvider implements DataProvider {
    private DataGenerator generator;

    public ButchercraftRecipeProvider(DataGenerator dataGenerator) {
        this.generator = dataGenerator;
    }

    @Override
    public void run(HashCache pCache) {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        registerRecipes(finishedRecipe -> {
            if (!set.add(finishedRecipe.getId())) {
                throw new IllegalStateException("Duplicate recipe " + finishedRecipe.getId());
            }
            else {
                RecipeProvider.saveRecipe(pCache, finishedRecipe.serializeRecipe(), path.resolve("data/" + finishedRecipe.getId().getNamespace() + "/recipes/" + finishedRecipe.getId().getPath() + ".json"));
//                JsonObject jsonobject = finishedRecipe.serializeAdvancement();
//                if (jsonobject != null) {
//                    saveAdvancement(pCache, jsonobject, path.resolve("data/" + finishedRecipe.getId().getNamespace() + "/advancements/" + finishedRecipe.getAdvancementId().getPath() + ".json"));
//                }

            }
        });
    }

    public abstract void registerRecipes(Consumer<FinishedRecipe> recipes);
}
