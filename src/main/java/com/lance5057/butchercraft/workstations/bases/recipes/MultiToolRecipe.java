package com.lance5057.butchercraft.workstations.bases.recipes;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.IShapedRecipe;

public class MultiToolRecipe implements IShapedRecipe<WorkstationRecipeWrapper> {
	static int MAX_WIDTH = 5;
	static int MAX_HEIGHT = 5;
	private final RecipeType<?> type;
	private final int recipeWidth;
	private final int recipeHeight;
	private final NonNullList<Ingredient> recipeItems;
	private final NonNullList<AnimatedRecipeItemUse> recipeTools;
//	private final ItemStack recipeOutput;
	private final ResourceLocation id;
	private final String group;
	public MultiToolRecipe(ResourceLocation idIn, String groupIn, int recipeWidthIn, int recipeHeightIn,
			NonNullList<Ingredient> recipeItemsIn, NonNullList<AnimatedRecipeItemUse> recipeToolsIn,
			RecipeType<?> type) {
		this.id = idIn;
		this.group = groupIn;
		this.recipeWidth = recipeWidthIn;
		this.recipeHeight = recipeHeightIn;
		this.recipeItems = recipeItemsIn;
		this.recipeTools = recipeToolsIn;

//		this.recipeOutput = recipeOutputIn;
		this.type = type;
	}

	/**
	 * Expand the max width and height allowed in the deserializer. This should be
	 * called by modders who add custom crafting tables that are larger than the
	 * vanilla 3x3.
	 *
	 * @param width  your max recipe width
	 * @param height your max recipe height
	 */
	public static void setCraftingSize(int width, int height) {
		if (MAX_WIDTH < width)
			MAX_WIDTH = width;
		if (MAX_HEIGHT < height)
			MAX_HEIGHT = height;
	}

	public static NonNullList<Ingredient> deserializeIngredients(String[] pattern, Map<String, Ingredient> keys,
			int patternWidth, int patternHeight) {
		NonNullList<Ingredient> nonnulllist = NonNullList.withSize(patternWidth * patternHeight, Ingredient.EMPTY);
		Set<String> set = Sets.newHashSet(keys.keySet());
		set.remove(" ");

		for (int i = 0; i < pattern.length; ++i) {
			for (int j = 0; j < pattern[i].length(); ++j) {
				String s = pattern[i].substring(j, j + 1);
				Ingredient ingredient = keys.get(s);
				if (ingredient == null) {
					throw new JsonSyntaxException(
							"Pattern references symbol '" + s + "' but it's not defined in the key");
				}

				set.remove(s);
				nonnulllist.set(j + patternWidth * i, ingredient);
			}
		}

		if (!set.isEmpty()) {
			throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
		} else {
			return nonnulllist;
		}
	}

	@VisibleForTesting
	public static String[] shrink(String... toShrink) {
		int i = Integer.MAX_VALUE;
		int j = 0;
		int k = 0;
		int l = 0;

		for (int i1 = 0; i1 < toShrink.length; ++i1) {
			String s = toShrink[i1];
			i = Math.min(i, firstNonSpace(s));
			int j1 = lastNonSpace(s);
			j = Math.max(j, j1);
			if (j1 < 0) {
				if (k == i1) {
					++k;
				}

				++l;
			} else {
				l = 0;
			}
		}

		if (toShrink.length == l) {
			return new String[0];
		} else {
			String[] astring = new String[toShrink.length - l - k];

			for (int k1 = 0; k1 < astring.length; ++k1) {
				astring[k1] = toShrink[k1 + k].substring(i, j + 1);
			}

			return astring;
		}
	}

	private static int firstNonSpace(String str) {
		int i;
		for (i = 0; i < str.length() && str.charAt(i) == ' '; ++i) {
		}

		return i;
	}

	private static int lastNonSpace(String str) {
		int i;
		for (i = str.length() - 1; i >= 0 && str.charAt(i) == ' '; --i) {
		}

		return i;
	}

	public static String[] patternFromJson(JsonArray jsonArr) {
		String[] astring = new String[jsonArr.size()];
		if (astring.length > MAX_HEIGHT) {
			throw new JsonSyntaxException("Invalid pattern: too many rows, " + MAX_HEIGHT + " is maximum");
		} else if (astring.length == 0) {
			throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
		} else {
			for (int i = 0; i < astring.length; ++i) {
				String s = GsonHelper.convertToString(jsonArr.get(i), "pattern[" + i + "]");
				if (s.length() > MAX_WIDTH) {
					throw new JsonSyntaxException("Invalid pattern: too many columns, " + MAX_WIDTH + " is maximum");
				}

				if (i > 0 && astring[0].length() != s.length()) {
					throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
				}

				astring[i] = s;
			}

			return astring;
		}
	}

	/**
	 * Returns a key json object as a Java HashMap.
	 */
	public static Map<String, Ingredient> deserializeKey(JsonObject json) {
		Map<String, Ingredient> map = Maps.newHashMap();

		for (Entry<String, JsonElement> entry : json.entrySet()) {
			if (entry.getKey().length() != 1) {
				throw new JsonSyntaxException("Invalid key entry: '" + (String) entry.getKey()
						+ "' is an invalid symbol (must be 1 character only).");
			}

			if (" ".equals(entry.getKey())) {
				throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
			}

			map.put(entry.getKey(), Ingredient.fromJson(entry.getValue()));
		}

		map.put(" ", Ingredient.EMPTY);
		return map;
	}

	public static NonNullList<AnimatedRecipeItemUse> deserializeTool(JsonObject json) {
		NonNullList<AnimatedRecipeItemUse> map = NonNullList.create();

		for (Entry<String, JsonElement> entry : json.entrySet()) {
//	    if (entry.getKey().length() != 1) {
//		throw new JsonSyntaxException("Invalid key entry: '" + (String) entry.getKey()
//			+ "' is an invalid symbol (must be 1 character only).");
//	    }
//
//	    if (" ".equals(entry.getKey())) {
//		throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
//	    }

			AnimatedRecipeItemUse r = AnimatedRecipeItemUse.read(entry.getValue().getAsJsonObject());

			map.add(r);
		}

		// map.put(" ", AnimatedRecipeItemUse.EMPTY);
		return map;
	}

	public static ItemStack deserializeItem(JsonObject object) {
		String s = GsonHelper.convertToString(object, "item");
		Item item = Registry.ITEM.getOptional(new ResourceLocation(s)).orElseThrow(() -> {
			return new JsonSyntaxException("Unknown item '" + s + "'");
		});
		if (object.has("data")) {
			throw new JsonParseException("Disallowed data tag found");
		} else {
			int i = GsonHelper.getAsInt(object, "count", 1);
			return net.minecraftforge.common.crafting.CraftingHelper.getItemStack(object, true);
		}
	}

	public ResourceLocation getId() {
		return this.id;
	}

	/**
	 * Recipes with equal group are combined into one button in the recipe book
	 */
	public String getGroup() {
		return this.group;
	}

	/**
	 * Get the result of this recipe, usually for display purposes (e.g. recipe
	 * book). If your recipe has more than one possible result (e.g. it's dynamic
	 * and depends on its inputs), then return an empty stack.
	 */
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}

	public NonNullList<Ingredient> getIngredients() {
		return this.getRecipeItems();
	}

	public NonNullList<AnimatedRecipeItemUse> getToolList() {
		return this.getRecipeTools();
	}

	/**
	 * Used to determine if this recipe can fit in a grid of the given width/height
	 */
	public boolean canFit(int width, int height) {
		return width >= this.recipeWidth && height >= this.recipeHeight;
	}

	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(WorkstationRecipeWrapper inv, Level worldIn) {
		for (int i = 0; i <= this.recipeWidth; ++i) {
			for (int j = 0; j <= this.recipeHeight; ++j) {
				if (this.checkMatch(inv, i, j, true)) {
					return true;
				}

				if (this.checkMatch(inv, i, j, false)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Checks if the region of a crafting inventory is match for the recipe.
	 */
	protected boolean checkMatch(WorkstationRecipeWrapper craftingInventory, int w, int h, boolean p_77573_4_) {
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				int k = i - w;
				int l = j - h;
				Ingredient ingredient = Ingredient.EMPTY;
				if (k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight) {
					if (p_77573_4_) {
						ingredient = this.recipeItems.get(this.recipeWidth - k - 1 + l * this.recipeWidth);
					} else {
						ingredient = this.recipeItems.get(k + l * this.recipeWidth);
					}
				}

				if (!ingredient.test(craftingInventory.getItem(i + j * 5))) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	public ItemStack getCraftingResult(WorkstationRecipeWrapper inv) {
		return this.getRecipeOutput().copy();
	}

	public int getWidth() {
		return this.recipeWidth;
	}

	@Override
	public int getRecipeWidth() {
		return getWidth();
	}

	public int getHeight() {
		return this.recipeHeight;
	}

	@Override
	public int getRecipeHeight() {
		return getHeight();
	}

	@Override
	public RecipeType<?> getType() {
		return type;
	}

	public NonNullList<Ingredient> getRecipeItems() {
		return recipeItems;
	}

	public int getToolListLength() {
		return recipeTools.size();
	}

	public NonNullList<AnimatedRecipeItemUse> getRecipeTools() {
		return recipeTools;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return null;
	}

	@Override
	public ItemStack assemble(WorkstationRecipeWrapper p_77572_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getResultItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
