package lance5057.butchercraft.util;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public class RecipeItemUse {

    public static RecipeItemUse EMPTY = new RecipeItemUse(0, Ingredient.EMPTY, 1, false, new ResourceLocation(""));
    public final int uses;
    public final Ingredient tool;
    public final int count;
    public final boolean damageTool;
    public final ResourceLocation loottable;

    public RecipeItemUse(int uses, Ingredient tool, int count, boolean damage, ResourceLocation loottable) {
        this.uses = uses;
        this.tool = tool;
        this.count = count;
        this.damageTool = damage;
        this.loottable = loottable;
    }

    public static RecipeItemUse read(JsonObject j) {
        int use = j.get("Uses").getAsInt();
        Ingredient i = Ingredient.fromJson(j.getAsJsonObject("Tool"));
        int c = j.get("Count").getAsInt();
        // ItemStack stack = ShapedRecipe.deserializeItem(j.getAsJsonObject("tool"));
        boolean b = j.get("Damage").getAsBoolean();

        String s = j.get("loottable").getAsString();
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
        buffer.writeResourceLocation(r.loottable);
    }

    public static JsonObject addProperty(RecipeItemUse r) {
        JsonObject o = new JsonObject();

        o.addProperty("Uses", r.uses);
        o.add("Tool", r.tool.toJson());
        o.addProperty("Count", r.count);
        o.addProperty("Damage", r.damageTool);
        o.addProperty("Loottable", r.loottable.toString());


        return o;
    }
}
