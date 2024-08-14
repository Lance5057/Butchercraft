package com.lance5057.butchercraft.workstations.grinder;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class GrinderRecipeSerializer implements RecipeSerializer<GrinderRecipe> {
	private static final MapCodec<GrinderRecipe> CODEC = RecordCodecBuilder.mapCodec(
			inst -> inst.group(
					Codec.STRING.optionalFieldOf("group", "").forGetter(GrinderRecipe::group),
					Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(GrinderRecipe::ingredient),
					Codec.INT.fieldOf("ingredientCount").forGetter(GrinderRecipe::count),
					Ingredient.CODEC_NONEMPTY.fieldOf("attachment").forGetter(GrinderRecipe::attachment),
					ItemStack.CODEC.fieldOf("result").forGetter(GrinderRecipe::result),
					Codec.INT.fieldOf("grinds").forGetter(GrinderRecipe::grinds)
			).apply(inst, GrinderRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, GrinderRecipe> STREAM_CODEC = StreamCodec.of(GrinderRecipeSerializer::write, GrinderRecipeSerializer::read);

	@Override
	public MapCodec<GrinderRecipe> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, GrinderRecipe> streamCodec() {
		return STREAM_CODEC;
	}

	private static GrinderRecipe read(RegistryFriendlyByteBuf pBuffer) {
		String s = pBuffer.readUtf();
		Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);
		int c = pBuffer.readInt();
		Ingredient attachment = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);
		ItemStack itemstack = ItemStack.STREAM_CODEC.decode(pBuffer);
		int g = pBuffer.readInt();
		return new GrinderRecipe(s, ingredient, c, attachment, itemstack, g);
	}

	private static void write(RegistryFriendlyByteBuf pBuffer, GrinderRecipe pRecipe) {
		pBuffer.writeUtf(pRecipe.getGroup());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.ingredient());
		pBuffer.writeInt(pRecipe.count());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.attachment());
		ItemStack.STREAM_CODEC.encode(pBuffer, pRecipe.result());
		pBuffer.writeInt(pRecipe.grinds());
	}
}