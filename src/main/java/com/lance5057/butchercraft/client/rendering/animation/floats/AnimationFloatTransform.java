package com.lance5057.butchercraft.client.rendering.animation.floats;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.FriendlyByteBuf;

public class AnimationFloatTransform {
	public static final Codec<AnimationFloatTransform> CODEC = RecordCodecBuilder.create(
			inst -> inst.group(
					AnimatedFloatVector3.CODEC.fieldOf("location").forGetter(a -> a.loc),
					AnimatedFloatVector3.CODEC.fieldOf("scale").forGetter(a -> a.scale),
					AnimatedFloatVector3.CODEC.fieldOf("rotation").forGetter(a -> a.rot)
			).apply(inst, AnimationFloatTransform::new)
	);

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

	public static AnimationFloatTransform read(JsonObject j) {
		AnimatedFloatVector3 location = AnimatedFloatVector3.read(j.get("location").getAsJsonObject());
		AnimatedFloatVector3 rotation = AnimatedFloatVector3.read(j.get("rotation").getAsJsonObject());
		AnimatedFloatVector3 scale = AnimatedFloatVector3.read(j.get("scale").getAsJsonObject());

		return new AnimationFloatTransform(location,scale, rotation);
	}

	public static AnimationFloatTransform read(FriendlyByteBuf buffer) {
		AnimatedFloatVector3 l = AnimatedFloatVector3.read(buffer);
		AnimatedFloatVector3 r = AnimatedFloatVector3.read(buffer);
		AnimatedFloatVector3 s = AnimatedFloatVector3.read(buffer);

		return new AnimationFloatTransform(l, s, r);
	}

	public static void write(AnimationFloatTransform af, FriendlyByteBuf buffer) {
		AnimatedFloatVector3.write(af.loc, buffer);
		AnimatedFloatVector3.write(af.rot, buffer);
		AnimatedFloatVector3.write(af.scale, buffer);
	}

	public static JsonObject addProperty(AnimationFloatTransform af) {
		JsonObject jo = new JsonObject();
		jo.add("location", AnimatedFloatVector3.addProperty(af.loc));
		jo.add("rotation", AnimatedFloatVector3.addProperty(af.rot));
		jo.add("scale", AnimatedFloatVector3.addProperty(af.scale));

		return jo;
	}
}
