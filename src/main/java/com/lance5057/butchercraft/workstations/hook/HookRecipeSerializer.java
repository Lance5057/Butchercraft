package com.lance5057.butchercraft.workstations.hook;

import com.lance5057.butchercraft.workstations.bases.recipes.AnimatedRecipeItemUse;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class HookRecipeSerializer implements RecipeSerializer<HookRecipe> {
	public static final Codec<HookRecipe> CODEC = RecordCodecBuilder.create(
			inst -> inst.group(
					ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(HookRecipe::group),
					Ingredient.CODEC_NONEMPTY.fieldOf("carcass").forGetter(HookRecipe::carcass),
					NonNullList.codecOf(AnimatedRecipeItemUse.CODEC).fieldOf("tools").forGetter(HookRecipe::tools),
					NonNullList.codecOf(Ingredient.CODEC_NONEMPTY).fieldOf("jei").forGetter(HookRecipe::jei)
			).apply(inst, HookRecipe::new)
	);

	@Override
	public Codec<HookRecipe> codec() {
		return CODEC;
	}

	@Override
	public HookRecipe fromNetwork(FriendlyByteBuf buffer) {
		String group = buffer.readUtf();
		Ingredient carcass = Ingredient.fromNetwork(buffer);
		int listSize = buffer.readVarInt();

		NonNullList<AnimatedRecipeItemUse> tools = NonNullList.withSize(listSize, AnimatedRecipeItemUse.EMPTY);
		tools.replaceAll(ignored -> AnimatedRecipeItemUse.read(buffer));

		int jeiSize = buffer.readVarInt();
		NonNullList<Ingredient> jei = NonNullList.withSize(jeiSize, Ingredient.EMPTY);
		jei.replaceAll(ignored -> Ingredient.fromNetwork(buffer));
		return new HookRecipe(group, carcass, tools, jei);
	}

	@Override
	public void toNetwork(FriendlyByteBuf buffer, HookRecipe recipe) {
		buffer.writeUtf(recipe.getGroup());

		recipe.getCarcassIn().toNetwork(buffer);

		buffer.writeVarInt(recipe.getRecipeToolsIn().size());

		recipe.getRecipeToolsIn().forEach(riu -> AnimatedRecipeItemUse.write(riu, buffer));

		buffer.writeVarInt(recipe.getDummyList().size());

		recipe.getDummyList().forEach(i -> i.toNetwork(buffer));
	}
}