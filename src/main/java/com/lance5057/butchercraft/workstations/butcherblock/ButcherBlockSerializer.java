package com.lance5057.butchercraft.workstations.butcherblock;

import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ButcherBlockSerializer implements RecipeSerializer<ButcherBlockRecipe> {
	public static final Codec<ButcherBlockRecipe> CODEC = RecordCodecBuilder.create(
			inst -> inst.group(
					ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(ButcherBlockRecipe::group),
					Ingredient.CODEC_NONEMPTY.fieldOf("carcass").forGetter(ButcherBlockRecipe::carcass),
					NonNullList.codecOf(AnimatedRecipeItemUse.CODEC).fieldOf("tools").forGetter(ButcherBlockRecipe::tools),
					NonNullList.codecOf(Ingredient.CODEC_NONEMPTY).fieldOf("jei").forGetter(ButcherBlockRecipe::jei)
			).apply(inst, ButcherBlockRecipe::new)
	);

	@Override
	public Codec<ButcherBlockRecipe> codec() {
		return CODEC;
	}

	@Override
	public ButcherBlockRecipe fromNetwork(FriendlyByteBuf buffer) {
		String group = buffer.readUtf();
		Ingredient carcassIn = Ingredient.fromNetwork(buffer);
		int listSize = buffer.readVarInt();

		NonNullList<AnimatedRecipeItemUse> tools = NonNullList.withSize(listSize, AnimatedRecipeItemUse.EMPTY);
		tools.replaceAll(ignored -> AnimatedRecipeItemUse.read(buffer));

		int jeiSize = buffer.readVarInt();
		NonNullList<Ingredient> jei = NonNullList.withSize(jeiSize, Ingredient.EMPTY);
		jei.replaceAll(ignored -> Ingredient.fromNetwork(buffer));
		return new ButcherBlockRecipe(group, carcassIn, tools, jei);
	}

	@Override
	public void toNetwork(FriendlyByteBuf buffer, ButcherBlockRecipe recipe) {
		buffer.writeUtf(recipe.getGroup());

		recipe.carcass().toNetwork(buffer);

		buffer.writeVarInt(recipe.tools().size());

		recipe.tools().forEach(riu -> AnimatedRecipeItemUse.write(riu, buffer));

		buffer.writeVarInt(recipe.jei().size());

		recipe.jei().forEach(i -> i.toNetwork(buffer));
	}
}
