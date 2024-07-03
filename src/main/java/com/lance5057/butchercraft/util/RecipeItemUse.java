package com.lance5057.butchercraft.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.Util;
import net.minecraft.network.FriendlyByteBuf;
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

    public static final String USES_FIELD = "uses";
    public static final String TOOL_FIELD = "tool";
    public static final String COUNT_FIELD = "count";
    public static final String DAMAGE_FIELD = "damage";
    public static final String LOOT_TABLE_FIELD = "loot_table";

    public static final RecipeItemUse EMPTY = new RecipeItemUse(0, Ingredient.EMPTY, 1, false, new ResourceLocation(""));

    public static RecipeItemUse read(JsonObject j) {
        return Util.getOrThrow(CODEC.decode(JsonOps.INSTANCE, j), JsonParseException::new).getFirst();
    }

    public static RecipeItemUse read(FriendlyByteBuf buffer) {
        int u = buffer.readVarInt();
        //ItemStack stack = buffer.readItemStack();
        Ingredient i = Ingredient.fromNetwork(buffer);
        int c = buffer.readVarInt();
        boolean b = buffer.readBoolean();

        ResourceLocation s = buffer.readResourceLocation();

        return new RecipeItemUse(u, i, c, b, s);
    }

    public static void write(RecipeItemUse r, FriendlyByteBuf buffer) {
        buffer.writeVarInt(r.uses);
        r.tool.toNetwork(buffer);
        buffer.writeVarInt(r.count);
        buffer.writeBoolean(r.damageTool);
        buffer.writeResourceLocation(r.lootTable);
    }

    public static JsonObject addProperty(RecipeItemUse r) {
        JsonObject o = new JsonObject();

        o.addProperty(USES_FIELD, r.uses);
        o.add(TOOL_FIELD, Util.getOrThrow(Ingredient.CODEC.encodeStart(JsonOps.INSTANCE, r.tool), JsonParseException::new));
        o.addProperty(COUNT_FIELD, r.count);
        o.addProperty(DAMAGE_FIELD, r.damageTool);
        o.addProperty(LOOT_TABLE_FIELD, r.lootTable.toString());


        return o;
    }
}
