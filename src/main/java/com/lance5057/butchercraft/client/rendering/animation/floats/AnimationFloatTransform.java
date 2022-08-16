package com.lance5057.butchercraft.client.rendering.animation.floats;

import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;

public class AnimationFloatTransform {
	AnimatedFloatVector3 loc, scale, rot;


	public static AnimationFloatTransform ZERO = new AnimationFloatTransform(AnimatedFloatVector3.zero,
			AnimatedFloatVector3.zero, AnimatedFloatVector3.zero);
	
	public AnimationFloatTransform() {
		loc = AnimatedFloatVector3.zero;
		rot = AnimatedFloatVector3.zero;
		scale = AnimatedFloatVector3.zero;
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
