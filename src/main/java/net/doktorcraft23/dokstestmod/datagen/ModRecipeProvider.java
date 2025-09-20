package net.doktorcraft23.dokstestmod.datagen;

import net.doktorcraft23.dokstestmod.block.ModBlocks;
import net.doktorcraft23.dokstestmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MECHANIUM_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.MECHANIUM_FRAGMENT.get())
                .unlockedBy("has_mechanium_fragment", has(ModItems.MECHANIUM_FRAGMENT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.URANIUM_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.URANIUM_INGOT.get())
                .unlockedBy("has_uranium_ingot", has(ModItems.URANIUM_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('A', ModItems.MECHANIUM_FRAGMENT.get())
                .define('B', Items.DIAMOND_BLOCK)
                .define('C', Items.NETHER_STAR)
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COIN.get())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('A', ModItems.URANIUM_INGOT.get())
                .define('B', Items.GOLD_BLOCK)
                .define('C', Items.DIAMOND)
                .unlockedBy("has_uranium_ingot", has(ModItems.URANIUM_INGOT))
                .save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MECHANIUM_FRAGMENT.get(), 9)
                .requires(ModBlocks.MECHANIUM_BLOCK)
                .unlockedBy("has_mechanium_block", has(ModBlocks.MECHANIUM_BLOCK))
                .save(recipeOutput, "dokstestmod:mechanium_fragment_from_mechanium_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MECHANIUM_FRAGMENT.get(), 9)
                .requires(ModBlocks.MAGIC_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK))
                .save(recipeOutput, "dokstestmod:mechanium_fragment_from_magic_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK)
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK))
                .save(recipeOutput, "dokstestmod:steel_ingot_from_steel_block");

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 9)
                .requires(ModBlocks.URANIUM_BLOCK)
                .unlockedBy("has_uranium_block", has(ModBlocks.URANIUM_BLOCK))
                .save(recipeOutput, "dokstestmod:uranium_ingot_from_uranium_block");
    }
}
