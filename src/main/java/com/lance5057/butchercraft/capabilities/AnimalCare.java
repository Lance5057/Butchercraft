package com.lance5057.butchercraft.capabilities;

import net.minecraft.nbt.CompoundTag;

public class AnimalCare {

	float nutrition;
	float contentment;
	
	public AnimalCare()
	{
		nutrition = 0.3f;
		contentment = 0f;
	}

	public float getNutrition() {
		return nutrition;
	}

	public void setNutrition(float n) {
		nutrition = n;
	}

	public float getContentment() {
		return contentment;
	}

	public void setContentment(float c) {
		contentment = c;
	}
	
	public void saveNBTData(CompoundTag compound) {
        compound.putFloat("nutrition", nutrition);
        compound.putFloat("contentment", contentment);
    }

    public void loadNBTData(CompoundTag compound) {
    	nutrition = compound.getFloat("nutrition");
    	contentment = compound.getFloat("contentment");
    }

}
