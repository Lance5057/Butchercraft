package com.lance5057.butchercraft.workstations.grinder;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class GrinderRecipeSerializer implements RecipeSerializer<GrinderRecipe> {
	private static final Codec<GrinderRecipe> CODEC = RecordCodecBuilder.create(
			inst -> inst.group(
					ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(GrinderRecipe::group),
					Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(GrinderRecipe::ingredient),
					Codec.INT.fieldOf("ingredientCount").forGetter(GrinderRecipe::count),
					Ingredient.CODEC_NONEMPTY.fieldOf("attachment").forGetter(GrinderRecipe::attachment),
					ItemStack.CODEC.fieldOf("result").forGetter(GrinderRecipe::result),
					Codec.INT.fieldOf("grinds").forGetter(GrinderRecipe::grinds)
			).apply(inst, GrinderRecipe::new)
	);

	@Override
	public Codec<GrinderRecipe> codec() {
		return CODEC;
	}

	public GrinderRecipe fromNetwork(FriendlyByteBuf pBuffer) {
		String s = pBuffer.readUtf();
		Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
		int c = pBuffer.readInt();
		Ingredient attachment = Ingredient.fromNetwork(pBuffer);
		ItemStack itemstack = pBuffer.readItem();
		int g = pBuffer.readInt();
		return new GrinderRecipe(s, ingredient, c, attachment, itemstack, g);
	}

	public void toNetwork(FriendlyByteBuf pBuffer, GrinderRecipe pRecipe) {
		pBuffer.writeUtf(pRecipe.getGroup());
		pRecipe.ingredient().toNetwork(pBuffer);
		pBuffer.writeInt(pRecipe.count());
		pRecipe.attachment().toNetwork(pBuffer);
		pBuffer.writeItem(pRecipe.result());
		pBuffer.writeInt(pRecipe.grinds());
	}
}