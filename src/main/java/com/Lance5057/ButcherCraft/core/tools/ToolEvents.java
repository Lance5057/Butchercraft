package com.Lance5057.ButcherCraft.core.tools;

import com.Lance5057.ButcherCraft.BCItems;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ToolEvents {
	public ToolEvents() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void DropCarcassEvent(LivingDropsEvent e) {
		//Did the player kill it?
		if (e.getSource() != null && e.getSource().getEntity() instanceof EntityPlayer) {
			EntityPlayer player = ((EntityPlayer) e.getSource().getEntity());
			if (player != null) {
				
				//Did the player use a butcher knife?
				ItemStack holding = player.inventory.getStackInSlot(player.inventory.currentItem);
				if (holding != null && holding.getItem() == BCItems.butcherKnife) {
					
					//What creature is it?
					if (e.getEntity() instanceof EntityCow) {
						e.getDrops().clear();
						e.getEntityLiving().entityDropItem(new ItemStack(BCItems.cowCarcass), 0);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void SlaughterEvent(LivingHurtEvent e)
	{
		//Did the player hurt it?
				if (e.getSource() != null && e.getSource().getEntity() instanceof EntityPlayer) {
					EntityPlayer player = ((EntityPlayer) e.getSource().getEntity());
					if (player != null) {
						
						//Did the player use a butcher knife?
						ItemStack holding = player.inventory.getStackInSlot(player.inventory.currentItem);
						if (holding != null && holding.getItem() == BCItems.butcherKnife) {
							
							//What creature is it?
							if (e.getEntity() instanceof EntityCow) {
								e.getEntityLiving().setHealth(0);
								holding.damageItem(1, player);
							}
						}
					}
				}
	}
}
