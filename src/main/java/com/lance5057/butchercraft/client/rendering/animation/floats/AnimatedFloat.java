package com.lance5057.butchercraft.client.rendering.animation.floats;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;

public class AnimatedFloat {
	float i;
	float iMax;
	float iMin;
	float offset;
	float speed;
	boolean add = true;
	boolean loop = false;
	boolean pingpong = false;

	public static AnimatedFloat ZERO = new AnimatedFloat(0, 0, 0);
	public static AnimatedFloat ONE = new AnimatedFloat(1,1,1);

	public AnimatedFloat(float iMax) {
		this(-iMax, iMax, 1);
	}

	public AnimatedFloat(float iMax, float speed) {
		this(-iMax, iMax, speed);
	}

	public AnimatedFloat(float iMin, float iMax, float speed) {
		this.iMin = iMin;
		this.iMax = iMax;
		this.speed = speed;
	}

	public AnimatedFloat(float iMin, float iMax, float offset, float speed, boolean loop, boolean pingpong) {
		this.iMin = iMin;
		this.iMax = iMax;
		this.speed = speed;
		this.offset = offset;
		this.loop = loop;
		this.pingpong = pingpong;
	}

	public float animate(float time) {
		float mod = this.iMax - this.iMin;

		if (mod == 0)
			return 0;

		float t = ((time * speed) % mod);
		if (pingpong) {
			float t2 = ((time * speed) % (mod * 2));

			if (t2 >= mod) {
				t = mod - t;
			}
		}

		if (!loop) {
			if (t + speed >= iMax)
				speed = 0;
		}
		
		if(speed == 0)
			return iMax;
		return t + iMin;

//		if (add) {
//			i += speed;
//			if (i >= iMax) {
//				if (loop)
//					i = iMin;
//				else if (pingpong)
//					add = false;
//				else
//					i = iMax;
//			}
//		} else {
//			i -= speed;
//			if (i <= iMin) {
//				if (pingpong)
//					add = true;
//				else
//					i = iMax;
//			}
//		}
	}

	public float getMax() {
		return iMax;
	}

	public float getOffset() {
		return offset;
	}

	public void setMax(float m) {
		this.iMax = m;
	}

	public void setMin(float m) {
		this.iMin = m;
	}

	public void setSpeed(float s) {
		this.speed = s;
	}

	public static AnimatedFloat read(JsonObject j) {
		float min = j.get("min") != null ? j.get("min").getAsFloat() : 0;
		float max = j.get("max") != null ? j.get("max").getAsFloat() : 0;
		float offset = j.get("offset") != null ? j.get("offset").getAsFloat() : 0;
		float speed = j.get("speed") != null ? j.get("speed").getAsFloat() : 0;
		boolean loop = j.get("loop") != null ? j.get("loop").getAsBoolean() : false;
		boolean pingpong = j.get("pingpong") != null ? j.get("pingpong").getAsBoolean() : false;

		return new AnimatedFloat(min, max, offset, speed, loop, pingpong);
	}

	public static AnimatedFloat read(FriendlyByteBuf buffer) {
		float min = buffer.readFloat();
		float max = buffer.readFloat();
		float offset = buffer.readFloat();
		float speed = buffer.readFloat();
		boolean loop = buffer.readBoolean();
		boolean pingpong = buffer.readBoolean();

		return new AnimatedFloat(min, max, offset, speed, loop, pingpong);
	}

	public static void write(AnimatedFloat af, FriendlyByteBuf buffer) {
		buffer.writeFloat(af.iMin);
		buffer.writeFloat(af.iMax);
		buffer.writeFloat(af.offset);
		buffer.writeFloat(af.speed);
		buffer.writeBoolean(af.loop);
		buffer.writeBoolean(af.pingpong);
	}

	public static JsonObject addProperty(AnimatedFloat af) {
		JsonObject jo = new JsonObject();

		if (af.iMin != 0)
			jo.addProperty("min", af.iMin);
		if (af.iMax != 0)
			jo.addProperty("max", af.iMax);
		if (af.offset != 0)
			jo.addProperty("offset", af.offset);
		if (af.speed != 0)
			jo.addProperty("speed", af.speed);
		if (af.loop)
			jo.addProperty("loop", af.loop);
		if (af.pingpong)
			jo.addProperty("pingpong", af.pingpong);

		return jo;
	}
}