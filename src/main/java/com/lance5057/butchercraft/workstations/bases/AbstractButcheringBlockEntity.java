package com.lance5057.butchercraft.workstations.bases;

import api.LanceNestAPI.src.blockentities.MultiToolRecipeStation;
import api.LanceNestAPI.src.recipes.multitoolrecipe.MultiToolRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractButcheringBlockEntity<V extends MultiToolRecipe> extends MultiToolRecipeStation<V> {

	public AbstractButcheringBlockEntity(int slots, int width, int height, BlockEntityType<?> tileEntityTypeIn,
			BlockPos pos, BlockState state) {
		super(slots, width, height, tileEntityTypeIn, pos, state);
	}

}
