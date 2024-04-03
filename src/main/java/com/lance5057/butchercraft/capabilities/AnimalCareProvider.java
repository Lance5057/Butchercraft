package com.lance5057.butchercraft.capabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class AnimalCareProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

	public static Capability<AnimalCare> CARE = CapabilityManager.get(new CapabilityToken<>(){});

    private AnimalCare AnimalCare = null;
    private final LazyOptional<AnimalCare> opt = LazyOptional.of(this::createAnimalCare);

    @Nonnull
    private AnimalCare createAnimalCare() {
        if (AnimalCare == null) {
            AnimalCare = new AnimalCare();
        }
        return AnimalCare;
    }
    
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == CARE) {
            return opt.cast();
        }
        return LazyOptional.empty();
    }
    
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
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
