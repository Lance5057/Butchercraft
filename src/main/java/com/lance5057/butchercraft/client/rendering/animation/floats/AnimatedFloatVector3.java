package com.lance5057.butchercraft.client.rendering.animation.floats;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;

public class AnimatedFloatVector3 {
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

	public static AnimatedFloatVector3 read(JsonObject j) {
		AnimatedFloat x = j.get("x") != null ? AnimatedFloat.read(j.get("x").getAsJsonObject()) : AnimatedFloat.ZERO;

		AnimatedFloat y = j.get("y") != null ? AnimatedFloat.read(j.get("y").getAsJsonObject()) : AnimatedFloat.ZERO;

		AnimatedFloat z = j.get("z") != null ? AnimatedFloat.read(j.get("z").getAsJsonObject()) : AnimatedFloat.ZERO;

		return new AnimatedFloatVector3(x, y, z);
	}

	public static AnimatedFloatVector3 read(FriendlyByteBuf buffer) {
		AnimatedFloat x = AnimatedFloat.read(buffer);
		AnimatedFloat y = AnimatedFloat.read(buffer);
		AnimatedFloat z = AnimatedFloat.read(buffer);

		return new AnimatedFloatVector3(x, y, z);
	}

	public static void write(AnimatedFloatVector3 af, FriendlyByteBuf buffer) {
		AnimatedFloat.write(af.x, buffer);
		AnimatedFloat.write(af.y, buffer);
		AnimatedFloat.write(af.z, buffer);
	}

	public static JsonObject addProperty(AnimatedFloatVector3 af) {
		JsonObject jo = new JsonObject();

		if (af.x != AnimatedFloat.ZERO)
			jo.add("x", AnimatedFloat.addProperty(af.x));
		if (af.y != AnimatedFloat.ZERO)
			jo.add("y", AnimatedFloat.addProperty(af.y));
		if (af.z != AnimatedFloat.ZERO)
			jo.add("z", AnimatedFloat.addProperty(af.z));

		return jo;
	}
}
