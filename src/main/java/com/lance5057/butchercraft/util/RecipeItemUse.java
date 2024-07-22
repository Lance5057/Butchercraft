package com.lance5057.butchercraft.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public record RecipeItemUse(
        int uses,
        Ingredient tool,
        int count,
        boolean damageTool,
        ResourceLocation lootTable
) {

    public static final Codec<RecipeItemUse> CODEC = RecordCodecBuilder.create(
            inst -> inst.group(
                    Codec.INT.fieldOf("uses").forGetter(RecipeItemUse::uses),
                    Ingredient.CODEC_NONEMPTY.fieldOf("tool").forGetter(RecipeItemUse::tool),
                    Codec.INT.fieldOf("count").forGetter(RecipeItemUse::count),
                    Codec.BOOL.fieldOf("damage").forGetter(RecipeItemUse::damageTool),
                    ResourceLocation.CODEC.fieldOf("loot_table").forGetter(RecipeItemUse::lootTable)
            ).apply(inst, RecipeItemUse::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, RecipeItemUse> STREAM_CODEC = StreamCodec.of(RecipeItemUse::write, RecipeItemUse::read);

    public static final RecipeItemUse EMPTY = new RecipeItemUse(0, Ingredient.EMPTY, 1, false, ResourceLocation.fromNamespaceAndPath("", ""));

    private static RecipeItemUse read(RegistryFriendlyByteBuf buffer) {
        int u = buffer.readVarInt();
        //ItemStack stack = buffer.readItemStack();
        Ingredient i = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
        int c = buffer.readVarInt();
        boolean b = buffer.readBoolean();

        ResourceLocation s = buffer.readResourceLocation();

        return new RecipeItemUse(u, i, c, b, s);
    }

    private static void write(RegistryFriendlyByteBuf buffer, RecipeItemUse r) {
        buffer.writeVarInt(r.uses);
        Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, r.tool);
        buffer.writeVarInt(r.count);
        buffer.writeBoolean(r.damageTool);
        buffer.writeResourceLocation(r.lootTable);
    }
}
