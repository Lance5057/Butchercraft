package lance5057.butchercraft.workstations.blocks;

import lance5057.butchercraft.workstations.tileentities.TileHook;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockHook extends Block {

    public BlockHook() {
        super(Block.Properties.of(Material.METAL).harvestLevel(0).strength(3, 4).harvestTool(ToolType.PICKAXE).air());
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity createTileEntity(BlockState state, BlockGetter world) {
        return new TileHook();
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState blockState, Level world, @Nonnull BlockPos blockPos,
                                 @Nonnull Player playerEntity, @Nonnull InteractionHand hand, @Nonnull BlockHitResult blockRayTraceResult) {
//	if (hand == Hand.MAIN_HAND) {
//	    TileEntity entity = world.getTileEntity(blockPos);
//	    if (entity instanceof SawhorseStationTE) {
//
//		SawhorseStationTE te = ((SawhorseStationTE) entity);
//		if (!playerEntity.isCrouching()) {
//		    boolean success = false;
//		    // Get item in both hands, ignore sent hand
//		    ItemStack heldmain = playerEntity.getHeldItem(Hand.MAIN_HAND);
//		    ItemStack heldoff = playerEntity.getHeldItem(Hand.OFF_HAND);
//
//		    // Try inserting main hand item
//		    if (!(heldmain.getItem() instanceof SawItem)) {
//			te.insertItem(heldmain);
//			success = true;
//		    }
//		    // Try inserting off hand item
//		    if (!(heldoff.getItem() instanceof SawItem)) {
//			te.insertItem(heldoff);
//			success = true;
//		    }
//
//		    // Hit it!
//		    // Try main hand, only try off hand if that fails
//		    if (heldmain.getItem() instanceof SawItem) {
//			te.hammer(playerEntity, heldmain);
//			success = true;
//		    } else if (heldoff.getItem() instanceof SawItem) {
//			te.hammer(playerEntity, heldoff);
//			success = true;
//		    }
//
//		    if (success)
//			return ActionResultType.SUCCESS;
//		} else // If crouching, take item off table
//		{
//		    te.extractItem(playerEntity);
//		    return ActionResultType.SUCCESS;
//		}
//	    }
//	}
        return super.use(blockState, world, blockPos, playerEntity, hand, blockRayTraceResult);

    }
}
