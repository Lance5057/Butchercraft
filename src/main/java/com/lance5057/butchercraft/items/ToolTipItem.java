package com.lance5057.butchercraft.items;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class ToolTipItem extends Item {
	String tooltip;

	public ToolTipItem(Properties properties, String tt) {
		super(properties);
		this.tooltip = tt;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
			TooltipFlag tooltipFlag) {
		tooltipComponents.add(
				Component.literal("").append(Component.translatable(tooltip)).withStyle(ChatFormatting.DARK_PURPLE));
	}
}
