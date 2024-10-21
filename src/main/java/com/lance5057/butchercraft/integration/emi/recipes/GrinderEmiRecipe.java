package com.lance5057.butchercraft.integration.emi.recipes;

import com.lance5057.butchercraft.Butchercraft;
import com.lance5057.butchercraft.ButchercraftItems;
import com.lance5057.butchercraft.integration.emi.EMIPlugin;
import com.lance5057.butchercraft.tags.ButchercraftItemTags;
import com.lance5057.butchercraft.workstations.grinder.GrinderRecipe;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GrinderEmiRecipe implements EmiRecipe {
	private final List<EmiIngredient> inputs;
	private final List<EmiIngredient> catalysts;
	private final List<EmiStack> outputs;
	private final ResourceLocation id;

	private final int grinds;
	private final int count;

	public GrinderEmiRecipe(GrinderRecipe recipe, ResourceLocation id) {
		this.inputs = List.of(EmiIngredient.of(recipe.ingredient()));
		List<EmiIngredient> catalysts = Lists.newArrayList();
		catalysts.add(EmiIngredient.of(recipe.attachment()));
		if (recipe.attachment().test(ButchercraftItems.EXTRUDER_TIP.toStack())) {
			catalysts.add(EmiIngredient.of(ButchercraftItemTags.SAUSAGE_CASING));
		}
		this.catalysts = catalysts;
		this.outputs = List.of(EmiStack.of(recipe.result()));
		this.id = id;

		this.grinds = recipe.grinds();
		this.count = recipe.count();
	}

	@Override
	public EmiRecipeCategory getCategory() {
		return EMIPlugin.GRINDER_CATEGORY;
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
		return 138;
	}

	@Override
	public int getDisplayHeight() {
		return 77;
	}

	@Override
	public void addWidgets(WidgetHolder widgets) {
		widgets.addTexture(ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "textures/gui/jei.png"), 0, 0, 138, 77, 0, 0);
		widgets.addText(Component.literal("x" + this.grinds), this.getDisplayWidth() / 2 - 57, 65, 0xFFFFFF, false);
		widgets.addText(Component.literal("x" + this.count), this.getDisplayWidth() / 2 + 1, 18, 0xFFFFFF, false);

		widgets.addSlot(this.inputs.getFirst(), this.getDisplayWidth() / 2 - 18, 10).drawBack(false);
		widgets.addSlot(this.catalysts.getFirst(), this.getDisplayWidth() / 2 + 26, 49).drawBack(false);
		if (this.catalysts.size() > 1) {
			widgets.addSlot(this.catalysts.getLast(), this.getDisplayWidth() / 2 + 26, 27).drawBack(false);
		}

		widgets.addSlot(this.outputs.getFirst(), this.getDisplayWidth() / 2  + 50, 49).drawBack(false).recipeContext(this);
	}
}
