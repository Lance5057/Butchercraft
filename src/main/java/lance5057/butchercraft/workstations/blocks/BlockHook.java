package lance5057.butchercraft.workstations.blocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lance5057.butchercraft.workstations.tileentities.TileHook;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

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
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
	return new TileHook();
    }

    @Nonnull
    @Override
    public ActionResultType use(@Nonnull BlockState blockState, World world, @Nonnull BlockPos blockPos,
	    @Nonnull PlayerEntity playerEntity, @Nonnull Hand hand, @Nonnull BlockRayTraceResult blockRayTraceResult) {
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
