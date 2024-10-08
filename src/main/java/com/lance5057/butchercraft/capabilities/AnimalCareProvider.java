package com.lance5057.butchercraft.capabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lance5057.butchercraft.Butchercraft;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;

public class AnimalCareProvider implements ICapabilityProvider<Cow, Void, AnimalCare>, INBTSerializable<CompoundTag> {

    public static final EntityCapability<AnimalCare, Void> CARE = EntityCapability.createVoid(
            new ResourceLocation(Butchercraft.MOD_ID, "animalcare"),
            AnimalCare.class
    );

    private AnimalCare AnimalCare = null;

    @Nullable
    @Override
    public AnimalCare getCapability(Cow cow, Void ctx) {
        return createAnimalCare();
    }

    @Nonnull
    private AnimalCare createAnimalCare() {
        if (AnimalCare == null) {
            AnimalCare = new AnimalCare();
        }
        return AnimalCare;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createAnimalCare().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
    	createAnimalCare().loadNBTData(nbt);
    }

}
