package com.lance5057.butchercraft.util;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public class RecipeItemUse {

    public static final String USES_FIELD = "uses";
    public static final String TOOL_FIELD = "tool";
    public static final String COUNT_FIELD = "count";
    public static final String DAMAGE_FIELD = "damage";
    public static final String LOOT_TABLE_FIELD = "loot_table";
    public static final RecipeItemUse EMPTY = new RecipeItemUse(0, Ingredient.EMPTY, 1, false, new ResourceLocation(""));
    public final int uses;
    public final Ingredient tool;
    public final int count;
    public final boolean damageTool;
    public final ResourceLocation lootTable;

    public RecipeItemUse(int uses, Ingredient tool, int count, boolean damage, ResourceLocation lootTable) {
        this.uses = uses;
        this.tool = tool;
        this.count = count;
        this.damageTool = damage;
        this.lootTable = lootTable;
    }

    public static RecipeItemUse read(JsonObject j) {
        int use = j.get(USES_FIELD).getAsInt();
        Ingredient i = Ingredient.fromJson(j.getAsJsonObject(TOOL_FIELD));
        int c = j.get(COUNT_FIELD).getAsInt();
        // ItemStack stack = ShapedRecipe.deserializeItem(j.getAsJsonObject("tool"));
        boolean b = j.get(DAMAGE_FIELD).getAsBoolean();

        String s = j.get(LOOT_TABLE_FIELD).getAsString();
        final ResourceLocation result = new ResourceLocation(s);

        return new RecipeItemUse(use, i, c, b, result);
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
        o.add(TOOL_FIELD, r.tool.toJson());
        o.addProperty(COUNT_FIELD, r.count);
        o.addProperty(DAMAGE_FIELD, r.damageTool);
        o.addProperty(LOOT_TABLE_FIELD, r.lootTable.toString());


        return o;
    }
}
