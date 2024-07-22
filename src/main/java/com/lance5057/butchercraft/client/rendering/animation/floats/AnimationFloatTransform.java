package com.lance5057.butchercraft.client.rendering.animation.floats;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class AnimationFloatTransform {
	public static final Codec<AnimationFloatTransform> CODEC = RecordCodecBuilder.create(
			inst -> inst.group(
					AnimatedFloatVector3.CODEC.fieldOf("location").forGetter(a -> a.loc),
					AnimatedFloatVector3.CODEC.fieldOf("scale").forGetter(a -> a.scale),
					AnimatedFloatVector3.CODEC.fieldOf("rotation").forGetter(a -> a.rot)
			).apply(inst, AnimationFloatTransform::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, AnimationFloatTransform> STREAM_CODEC = StreamCodec.of(AnimationFloatTransform::write, AnimationFloatTransform::read);

	AnimatedFloatVector3 loc, scale, rot;


	public static AnimationFloatTransform ZERO = new AnimationFloatTransform(AnimatedFloatVector3.ZERO,
			AnimatedFloatVector3.ZERO, AnimatedFloatVector3.ZERO);
	public static AnimationFloatTransform ONE = new AnimationFloatTransform(AnimatedFloatVector3.ONE,
			AnimatedFloatVector3.ONE, AnimatedFloatVector3.ONE);
	
	public AnimationFloatTransform() {
		loc = AnimatedFloatVector3.ZERO;
		rot = AnimatedFloatVector3.ZERO;
		scale = AnimatedFloatVector3.ONE;
	}

	public AnimationFloatTransform(AnimatedFloatVector3 l, AnimatedFloatVector3 s, AnimatedFloatVector3 r) {
		loc = l;
		scale = s;
		rot = r;
	}

	public void animate(float time) {
		loc.animate(time);
		scale.animate(time);
		rot.animate(time);
	}

	public AnimationFloatTransform setLocation(AnimatedFloatVector3 in) {
		loc = in;

		return this;
	}

	public AnimationFloatTransform setRotation(AnimatedFloatVector3 in) {
		rot = in;

		return this;
	}

	public AnimationFloatTransform setScale(AnimatedFloatVector3 in) {
		scale = in;

		return this;
	}

	public AnimatedFloatVector3 getLocation() {
		return loc;
	}

	public AnimatedFloatVector3 getScale() {
		return scale;
	}

	public AnimatedFloatVector3 getRotation() {
		return rot;
	}

	private static AnimationFloatTransform read(RegistryFriendlyByteBuf buffer) {
		AnimatedFloatVector3 l = AnimatedFloatVector3.STREAM_CODEC.decode(buffer);
		AnimatedFloatVector3 r = AnimatedFloatVector3.STREAM_CODEC.decode(buffer);
		AnimatedFloatVector3 s = AnimatedFloatVector3.STREAM_CODEC.decode(buffer);

		return new AnimationFloatTransform(l, s, r);
	}

	private static void write(RegistryFriendlyByteBuf buffer, AnimationFloatTransform af) {
		AnimatedFloatVector3.STREAM_CODEC.encode(buffer, af.loc);
		AnimatedFloatVector3.STREAM_CODEC.encode(buffer, af.rot);
		AnimatedFloatVector3.STREAM_CODEC.encode(buffer, af.scale);
	}
}
