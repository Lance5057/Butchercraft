package com.lance5057.butchercraft.workstations.hook.recipes;

import com.lance5057.butchercraft.Butchercraft;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import api.LanceNestAPI.src.recipes.AnimatedRecipeItemUse;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class HookRecipeSerializer implements RecipeSerializer<HookRecipe> {
	public static final MapCodec<HookRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst
			.group(Codec.STRING.optionalFieldOf("group", "").forGetter(HookRecipe::getGroup),
					Ingredient.CODEC_NONEMPTY.fieldOf("carcass").forGetter(HookRecipe::getIngredientIn),
					ResourceLocation.CODEC.optionalFieldOf("entity", Butchercraft.NONE)
							.forGetter(HookRecipe::getEntity),
					NonNullList.codecOf(AnimatedRecipeItemUse.CODEC).fieldOf("tools").forGetter(HookRecipe::getTools))
			.apply(inst, HookRecipe::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, HookRecipe> STREAM_CODEC = StreamCodec
			.of(HookRecipeSerializer::write, HookRecipeSerializer::read);

	@Override
	public MapCodec<HookRecipe> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, HookRecipe> streamCodec() {
		return STREAM_CODEC;
	}

	private static HookRecipe read(RegistryFriendlyByteBuf buffer) {
		String group = buffer.readUtf();
		Ingredient carcass = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
		int listSize = buffer.readVarInt();

		NonNullList<AnimatedRecipeItemUse> tools = NonNullList.withSize(listSize, AnimatedRecipeItemUse.EMPTY);
		tools.replaceAll(ignored -> AnimatedRecipeItemUse.STREAM_CODEC.decode(buffer));

//		int jeiSize = buffer.readVarInt();
//		NonNullList<Ingredient> jei = NonNullList.withSize(jeiSize, Ingredient.EMPTY);
//		jei.replaceAll(ignored -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));

		ResourceLocation entity = ResourceLocation.parse(buffer.readUtf());
		return new HookRecipe(group, carcass, entity, tools);
	}

	private static void write(RegistryFriendlyByteBuf buffer, HookRecipe recipe) {
		buffer.writeUtf(recipe.getGroup());

		Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.getIngredientIn());

		buffer.writeVarInt(recipe.getTools().size());

		recipe.getTools().forEach(riu -> AnimatedRecipeItemUse.STREAM_CODEC.encode(buffer, riu));

//		buffer.writeVarInt(recipe.getJei().size());
//
//		recipe.getJei().forEach(i -> Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, i));

		buffer.writeUtf(recipe.entity.toString());
	}
}