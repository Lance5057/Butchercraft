package com.lance5057.butchercraft.client;

import com.lance5057.butchercraft.client.rendering.animation.floats.AnimationFloatTransform;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public record BlacklistedModel(
		ResourceLocation rc,
		boolean isBlock,
		AnimationFloatTransform transform
) {
	public static final Codec<BlacklistedModel> CODEC = RecordCodecBuilder.create(
			inst -> inst.group(
					ResourceLocation.CODEC.fieldOf("location").forGetter(BlacklistedModel::rc),
					Codec.BOOL.optionalFieldOf("IsBlock", false).forGetter(BlacklistedModel::isBlock),
					AnimationFloatTransform.CODEC.fieldOf("animation").forGetter(BlacklistedModel::transform)
			).apply(inst, BlacklistedModel::new)
	);

	public static BlacklistedModel empty = new BlacklistedModel(ResourceLocation.fromNamespaceAndPath("", ""),
			true, AnimationFloatTransform.ZERO);
	
//	public BlacklistedModel(BlockState block)
//	{
//		ModelLoaderRegistry.
//		this.rc = block.
//		isBlock = true;
//	}
	
	public BlacklistedModel(Item item, AnimationFloatTransform anim)
	{
		this(BuiltInRegistries.ITEM.getKey(item), false, anim);
	}

	public static BlacklistedModel read(FriendlyByteBuf buffer) {
		ResourceLocation rc = ResourceLocation.parse(buffer.readUtf());

		boolean block = buffer.readBoolean();
		
		AnimationFloatTransform t = AnimationFloatTransform.read(buffer);

		return new BlacklistedModel(rc, block, t);
	}

	public static void write(BlacklistedModel bm, FriendlyByteBuf buffer) {
		buffer.writeUtf(bm.rc.toString());
		buffer.writeBoolean(bm.isBlock);
		AnimationFloatTransform.write(bm.transform, buffer);
	}
}
