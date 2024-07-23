package com.lance5057.butchercraft.workstations.butcherblock;

import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ButcherBlockSerializer implements RecipeSerializer<ButcherBlockRecipe> {
	public static final MapCodec<ButcherBlockRecipe> CODEC = RecordCodecBuilder.mapCodec(
			inst -> inst.group(
					Codec.STRING.optionalFieldOf("group", "").forGetter(ButcherBlockRecipe::group),
					Ingredient.CODEC_NONEMPTY.fieldOf("carcass").forGetter(ButcherBlockRecipe::carcass),
					NonNullList.codecOf(AnimatedRecipeItemUse.CODEC).fieldOf("tools").forGetter(ButcherBlockRecipe::tools),
					NonNullList.codecOf(Ingredient.CODEC_NONEMPTY).fieldOf("jei").forGetter(ButcherBlockRecipe::jei)
			).apply(inst, ButcherBlockRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ButcherBlockRecipe> STREAM_CODEC = StreamCodec.of(ButcherBlockSerializer::write, ButcherBlockSerializer::read);

	@Override
	public MapCodec<ButcherBlockRecipe> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, ButcherBlockRecipe> streamCodec() {
		return STREAM_CODEC;
	}

	private static ButcherBlockRecipe read(RegistryFriendlyByteBuf buffer) {
		String group = buffer.readUtf();
		Ingredient carcassIn = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
		int listSize = buffer.readVarInt();

		NonNullList<AnimatedRecipeItemUse> tools = NonNullList.withSize(listSize, AnimatedRecipeItemUse.EMPTY);
		tools.replaceAll(ignored -> AnimatedRecipeItemUse.STREAM_CODEC.decode(buffer));

		int jeiSize = buffer.readVarInt();
		NonNullList<Ingredient> jei = NonNullList.withSize(jeiSize, Ingredient.EMPTY);
		jei.replaceAll(ignored -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
		return new ButcherBlockRecipe(group, carcassIn, tools, jei);
	}

	private static void write(RegistryFriendlyByteBuf buffer, ButcherBlockRecipe recipe) {
		buffer.writeUtf(recipe.getGroup());

		Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.carcass());

		buffer.writeVarInt(recipe.tools().size());

		recipe.tools().forEach(riu -> AnimatedRecipeItemUse.STREAM_CODEC.encode(buffer, riu));

		buffer.writeVarInt(recipe.jei().size());

		recipe.jei().forEach(i -> Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, i));
	}
}
