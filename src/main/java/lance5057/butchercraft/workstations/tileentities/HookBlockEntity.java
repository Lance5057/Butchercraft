package lance5057.butchercraft.workstations.tileentities;

import lance5057.butchercraft.ButchercraftBlockEntities;
import lance5057.butchercraft.workstations.recipes.HookRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HookBlockEntity extends BlockEntity {
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

    public HookBlockEntity(BlockPos pPos, BlockState pState) {
        super(ButchercraftBlockEntities.HOOK_TILE_ENTITY.get(), pPos, pState);
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

    private HookRecipe matchRecipe(ItemStack stackInSlot) {
        if (this.level != null) {
            return level.getRecipeManager().getRecipes().stream().filter(recipe -> recipe instanceof HookRecipe)
                    .map(recipe -> (HookRecipe) recipe).filter(recipe -> recipe.matches(stackInSlot)).findFirst()
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
                HookRecipe r = matchRecipe(stack);
                return r != null && super.isItemValid(slot, stack);
            }
        };
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

    // External extract handler
    public void extractItem(Player playerEntity) {
        handler.ifPresent(inventory -> {
            this.extractItem(playerEntity, inventory);
        });
    }

    // External insert handler
    public void insertItem(ItemStack heldItem) {
        handler.ifPresent(inventory -> {
            this.insertItem(inventory, heldItem);
        });
    }

    public void updateInventory() {
        requestModelDataUpdate();
        this.setChanged();
        if (this.getLevel() != null) {
            this.getLevel().sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }

}
