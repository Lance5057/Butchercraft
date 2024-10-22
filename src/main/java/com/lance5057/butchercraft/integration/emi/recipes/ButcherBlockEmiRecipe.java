package com.lance5057.butchercraft.integration.emi.recipes;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.integration.emi.EMIPlugin;
import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;
import com.lance5057.butchercraft.workstations.butcherblock.ButcherBlockRecipe;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ButcherBlockEmiRecipe implements EmiRecipe {
	private final List<EmiIngredient> inputs;
	private final List<EmiIngredient> catalysts;
	private final List<EmiStack> outputs;
	private final ResourceLocation id;

	public ButcherBlockEmiRecipe(ButcherBlockRecipe recipe, ResourceLocation id) {
		this.inputs = List.of(EmiIngredient.of(recipe.carcass()));
		this.catalysts = recipe.tools().stream().map(AnimatedRecipeItemUse::tool).map(EmiIngredient::of).toList();
		List<EmiStack> outputs = Lists.newArrayList();
		recipe.jei().stream().map(EmiIngredient::of).map(EmiIngredient::getEmiStacks).forEach(outputs::addAll);
		this.outputs = outputs;
		this.id = id;
	}

	@Override
	public EmiRecipeCategory getCategory() {
		return EMIPlugin.BUTCHER_BLOCK_CATEGORY;
	}

	@Override
	public @Nullable ResourceLocation getId() {
		return id;
	}

	@Override
	public List<EmiIngredient> getInputs() {
		return inputs;
	}

	@Override
	public List<EmiIngredient> getCatalysts() {
		return catalysts;
	}

	@Override
	public List<EmiStack> getOutputs() {
		return outputs;
	}

	@Override
	public int getDisplayWidth() {
		return 144;
	}

	@Override
	public int getDisplayHeight() {
		return 144;
	}

	@Override
	public void addWidgets(WidgetHolder widgets) {
		widgets.addTexture(ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/gui/jei.png"), 0, 0, 144, 144, 108, 78);

		int offset = 2;
		int width = (16 + offset);
		int placementW = 0;
		int height = (16 + offset);
		int placementH = 0;
		int c = 0;

		widgets.addSlot(this.inputs.getFirst(), (this.getDisplayWidth() / 2 - 9), 39).drawBack(false);

		for (EmiIngredient a : this.catalysts) {
			widgets.addSlot(a, placementW, placementH).drawBack(false);

			placementW += width;
			c++;
			if (c > 7) {
				placementH += height;
				placementW = 0;
				c = 0;
			}
		}

		c = 0;
		placementW = 0;
		placementH = 0;

		for (EmiStack i : this.outputs) {
			widgets.addSlot(i, placementW, 72 + placementH + 18).drawBack(false).recipeContext(this);

			placementW += width;
			c++;
			if (c > 7) {
				placementH += height;
				placementW = 0;
				c = 0;
			}
		}
	}
}
