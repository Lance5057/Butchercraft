package lance5057.butchercraft.items;

import java.util.Collection;

import lance5057.butchercraft.recipes.ButcherKnifeRecipe;
import lance5057.butchercraft.recipes.ButcherKnifeWrapper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemButcherknife extends ToolItem {

    public ItemButcherknife(
	    Properties builderIn) {
	super(3, 1.6f, ItemTier.IRON, null, builderIn);
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {

	if (entity instanceof MobEntity) {
	    MobEntity mob = (MobEntity) entity;
	    ButcherKnifeRecipe recipe = this.matchRecipe(player.level, stack, mob);
	    
	    if(recipe != null)
		mob.kill();
	}

	return ActionResultType.PASS;
    }

//    @Override
//    public ActionResultType useOn(ItemUseContext context) {
//	
//
//	if (recipe != null) {
//	    World world = context.getLevel();
//	    context.
//
//	    if (recipe.getRecipeOutput().getItem() instanceof BlockItem) {
//		BlockItem b = (BlockItem) recipe.getRecipeOutput().getItem();
//		to = b.getBlock().getDefaultState();
//
//		for (Entry<Property<?>, Comparable<?>> entry : this.getCommonProperties(origState, state).entrySet()) {
//		    Property property = state.getBlock().getStateContainer().getProperty(entry.getKey().getName());
//		    final Optional<Comparable> propValue = property.parseValue(entry.getValue().toString());
//		    propValue.ifPresent(comparable -> to = to.with(property, comparable));
//		}
//
////		world.setBlockState(pos, to);
////
////		for (int i = 0; i < 5; i++) {
////		    world.addParticle(
////			    new ItemParticleData(ParticleTypes.ITEM, context.getPlayer().getHeldItemOffhand()),
////			    pos.getX() + 0.5f, pos.getY() + 1, pos.getZ() + 0.5f, (world.random.nextFloat() - 0.5f) / 2,
////			    (world.random.nextFloat() - 0.5f) / 2, (world.random.nextFloat() - 0.5f) / 2);
////		}
////		world.playSound(context.getPlayer(), pos, SoundEvents.BLOCK_LANTERN_HIT, SoundCategory.BLOCKS, 1, 1);
//
//		return ActionResultType.sidedSuccess(!world.isClientSide);
//	    }
//	}
//	return ActionResultType.FAIL;
//    }

    private ButcherKnifeRecipe matchRecipe(World world, ItemStack tool, MobEntity entity) {
	if (world != null) {
	    ButcherKnifeRecipe r = world.getRecipeManager().getRecipes().stream()
		    .filter(recipe -> recipe instanceof ButcherKnifeRecipe).map(recipe -> (ButcherKnifeRecipe) recipe)
		    .filter(recipe -> recipe.matches(new ButcherKnifeWrapper(tool, entity), world)).findFirst()
		    .orElse(null);

	    return r;
	}
	return null;
    }

}
