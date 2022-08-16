package com.lance5057.butchercraft.workstations.blockentities;

import com.lance5057.butchercraft.ButchercraftBlockEntities;
import com.lance5057.butchercraft.workstations.recipes.HookRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MeatHookBlockEntity extends BlockEntity {
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

    public MeatHookBlockEntity(BlockPos pPos, BlockState pState) {
        super(ButchercraftBlockEntities.MEAT_HOOK.get(), pPos, pState);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (side != Direction.DOWN)
            if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
                return handler.cast();
            }
        return super.getCapability(cap, side);
    }

    // Attempt to find a recipe that matches the tool and the item in its inventory
    private HookRecipe matchRecipe(ItemStack butcheringTool) {
        if (this.level != null) {
            return level.getRecipeManager().getRecipes().stream().filter(recipe -> recipe instanceof HookRecipe)
                    .map(recipe -> (HookRecipe) recipe).filter(recipe -> recipe.matches(getInsertedItem(), butcheringTool)).findFirst()
                    .orElse(null);
        }
        return null;
    }

    private IItemHandler createHandler() {
        return new ItemStackHandler(1) {
            @Override
            protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
                return stack.getMaxStackSize();
            }

            @Override
            protected void onContentsChanged(int slot) {
                updateInventory();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                // Item is only valid if it can find a recipe that uses the inserted item
                boolean recipeWithInputExists = false;
                if (level != null) {
                    recipeWithInputExists = level.getRecipeManager().getRecipes().stream().filter(recipe -> recipe instanceof HookRecipe)
                            .map(recipe -> (HookRecipe) recipe)
                            .anyMatch(hookRecipe -> hookRecipe.getInput().test(stack));
                }
                return recipeWithInputExists && super.isItemValid(slot, stack);
            }
        };
    }

    public ItemStack getInsertedItem() {
        return handler.map(inventory-> inventory.getStackInSlot(0)).orElse(ItemStack.EMPTY);
    }

    public void extractInsertItem(Player playerEntity, InteractionHand hand) {
        handler.ifPresent(inventory -> {
            ItemStack held = playerEntity.getItemInHand(hand);
            if (!held.isEmpty()) {
                insertItem(inventory, held);
            }
            else {
                extractItem(playerEntity, inventory);
            }
        });
        updateInventory();
    }

    public void extractItem(Player playerEntity, IItemHandler inventory) {
        if (!inventory.getStackInSlot(0).isEmpty()) {
            ItemStack itemStack = inventory.extractItem(0, inventory.getStackInSlot(0).getCount(), false);
            playerEntity.addItem(itemStack);
        }
        updateInventory();
    }

    public void insertItem(IItemHandler inventory, ItemStack heldItem) {
        if (inventory.isItemValid(0, heldItem))
            if (!inventory.insertItem(0, heldItem, true).equals(heldItem, false)) {
                final int leftover = inventory.insertItem(0, heldItem.copy(), false).getCount();
                heldItem.setCount(leftover);
            }
        updateInventory();
    }

    public boolean isEmpty() {
        return handler.map(inventory -> inventory.getStackInSlot(0).isEmpty()).orElse(false);
    }

    // External extract handler
    public void extractItem(Player playerEntity) {
        handler.ifPresent(inventory -> this.extractItem(playerEntity, inventory));
    }

    // External insert handler
    public void insertItem(ItemStack heldItem) {
        handler.ifPresent(inventory -> this.insertItem(inventory, heldItem));
    }

    public void updateInventory() {
        requestModelDataUpdate();
        this.setChanged();
        if (this.getLevel() != null) {
            this.getLevel().sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }

    public void useTool(ItemStack butcheringTool, Player playerEntity) {
        if (level != null && !level.isClientSide()) {
            final LootContext pContext = new LootContext.Builder((ServerLevel) level)
                    .withParameter(LootContextParams.TOOL, butcheringTool)
                    .withParameter(LootContextParams.THIS_ENTITY, playerEntity)
                    .withRandom(level.getRandom())
                    .withLuck(playerEntity.getLuck() + EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, butcheringTool))
                    .create(LootContextParamSets.EMPTY);
            final HookRecipe hookRecipe = matchRecipe(butcheringTool);
            if (hookRecipe != null) {
                hookRecipe.getButcheringDrops().getRandomItems(pContext).forEach(itemStack -> new ItemEntity(level, getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(), itemStack));
            }
        }
    }
}
