package lance5057.butchercraft.items;

import java.util.Collection;

import lance5057.butchercraft.recipes.ButcherKnifeRecipe;
import lance5057.butchercraft.recipes.ButcherKnifeWrapper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemButcherknife extends DiggerItem {

    public ItemButcherknife(
	    Properties builderIn) {
	super(3, 1.6f, Tiers.IRON, null, builderIn);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {

	if (entity instanceof Mob) {
	    Mob mob = (Mob) entity;
	    ButcherKnifeRecipe recipe = this.matchRecipe(player.level, stack, mob);
	    
	    if(recipe != null)
		mob.kill();
	}

	return InteractionResult.PASS;
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

    private ButcherKnifeRecipe matchRecipe(Level world, ItemStack tool, Mob entity) {
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
