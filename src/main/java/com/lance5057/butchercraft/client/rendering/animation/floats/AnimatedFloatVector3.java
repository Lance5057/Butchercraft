package com.lance5057.butchercraft.client.rendering.animation.floats;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class AnimatedFloatVector3 {
	public static final Codec<AnimatedFloatVector3> CODEC = RecordCodecBuilder.create(
			inst -> inst.group(
					AnimatedFloat.CODEC.optionalFieldOf("x", AnimatedFloat.ZERO).forGetter(a -> a.x),
					AnimatedFloat.CODEC.optionalFieldOf("y", AnimatedFloat.ZERO).forGetter(a -> a.y),
					AnimatedFloat.CODEC.optionalFieldOf("z", AnimatedFloat.ZERO).forGetter(a -> a.z)
			).apply(inst, AnimatedFloatVector3::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, AnimatedFloatVector3> STREAM_CODEC = StreamCodec.of(AnimatedFloatVector3::write, AnimatedFloatVector3::read);

	AnimatedFloat x, y, z;

	public static AnimatedFloatVector3 ZERO = new AnimatedFloatVector3(AnimatedFloat.ZERO, AnimatedFloat.ZERO,
			AnimatedFloat.ZERO);
	public static AnimatedFloatVector3 ONE = new AnimatedFloatVector3(AnimatedFloat.ONE, AnimatedFloat.ONE,
			AnimatedFloat.ONE);

	public AnimatedFloatVector3() {
		x = AnimatedFloat.ZERO;
		y = AnimatedFloat.ZERO;
		z = AnimatedFloat.ZERO;
	}

	public AnimatedFloatVector3(AnimatedFloat x, AnimatedFloat y, AnimatedFloat z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public AnimatedFloatVector3 setX(AnimatedFloat in) {
		x = in;
		return this;
	}

	public AnimatedFloatVector3 setY(AnimatedFloat in) {
		y = in;
		return this;
	}

	public AnimatedFloatVector3 setZ(AnimatedFloat in) {
		z = in;
		return this;
	}

	public AnimatedFloatVector3 setAll(AnimatedFloat in) {
		this.x = in;
		this.y = in;
		this.z = in;

		return this;
	}

	public void animate(float time) {
		x.animate(time);
		y.animate(time);
		z.animate(time);
	}

	public AnimatedFloat getX() {
		return x;
	}

	public AnimatedFloat getY() {
		return y;
	}

	public AnimatedFloat getZ() {
		return z;
	}

	public void setMax(float x, float y, float z) {
		this.getX().setMax(x);
		this.getY().setMax(y);
		this.getZ().setMax(z);
	}

	public void setMin(float x, float y, float z) {
		this.getX().setMin(x);
		this.getY().setMin(y);
		this.getZ().setMin(z);
	}

	public void setSpeed(float speed) {
		this.getX().setSpeed(speed);
		this.getY().setSpeed(speed);
		this.getZ().setSpeed(speed);
	}

	private static AnimatedFloatVector3 read(RegistryFriendlyByteBuf buffer) {
		AnimatedFloat x = AnimatedFloat.STREAM_CODEC.decode(buffer);
		AnimatedFloat y = AnimatedFloat.STREAM_CODEC.decode(buffer);
		AnimatedFloat z = AnimatedFloat.STREAM_CODEC.decode(buffer);

		return new AnimatedFloatVector3(x, y, z);
	}

	private static void write(RegistryFriendlyByteBuf buffer, AnimatedFloatVector3 af) {
		AnimatedFloat.STREAM_CODEC.encode(buffer, af.x);
		AnimatedFloat.STREAM_CODEC.encode(buffer, af.y);
		AnimatedFloat.STREAM_CODEC.encode(buffer, af.z);
	}
}
