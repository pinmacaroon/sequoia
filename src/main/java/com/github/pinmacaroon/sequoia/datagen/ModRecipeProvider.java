package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.block.ModBlocks;
import com.github.pinmacaroon.sequoia.etc.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    public static void offerCustomUpgradeRecipe(Consumer<RecipeJsonProvider> exporter, Item input, RecipeCategory category, Item result, Item template, Item material) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(template), Ingredient.ofItems(input), Ingredient.ofItems(material), category, result
                )
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter, getItemPath(result) + "_smithing");
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEQUOIA_PLANKS, 4)
                .input(ModTags.Items.SEQUOIA_LOG_LIKES)
                .criterion(hasItem(ModBlocks.SEQUOIA_LOG), conditionsFromItem(ModBlocks.SEQUOIA_LOG))
                .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_LOG), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_LOG))
                .criterion(hasItem(ModBlocks.SEQUOIA_WOOD), conditionsFromItem(ModBlocks.SEQUOIA_WOOD))
                .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_WOOD), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_WOOD))
                .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_PLANKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEQUOIA_WOOD, 1)
                .pattern("ll")
                .pattern("ll")
                .input('l', ModBlocks.SEQUOIA_LOG)
                .criterion(hasItem(ModBlocks.SEQUOIA_LOG), conditionsFromItem(ModBlocks.SEQUOIA_LOG))
                .criterion(hasItem(ModBlocks.SEQUOIA_WOOD), conditionsFromItem(ModBlocks.SEQUOIA_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_SEQUOIA_WOOD, 1)
                .pattern("ll")
                .pattern("ll")
                .input('l', ModBlocks.STRIPPED_SEQUOIA_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_LOG), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_LOG))
                .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_WOOD), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STRIPPED_SEQUOIA_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEQUOIA_SLAB, 6)
                .pattern("lll")
                .input('l', ModBlocks.SEQUOIA_PLANKS)
                .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                .criterion(hasItem(ModBlocks.SEQUOIA_SLAB), conditionsFromItem(ModBlocks.SEQUOIA_SLAB))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SEQUOIA_TRAPDOOR, 2)
                .pattern("lll")
                .pattern("lll")
                .input('l', ModBlocks.SEQUOIA_PLANKS)
                .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                .criterion(hasItem(ModBlocks.SEQUOIA_TRAPDOOR), conditionsFromItem(ModBlocks.SEQUOIA_TRAPDOOR))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_TRAPDOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SEQUOIA_DOOR, 3)
                .pattern("ll")
                .pattern("ll")
                .pattern("ll")
                .input('l', ModBlocks.SEQUOIA_PLANKS)
                .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                .criterion(hasItem(ModBlocks.SEQUOIA_DOOR), conditionsFromItem(ModBlocks.SEQUOIA_DOOR))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_DOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SEQUOIA_STAIRS, 4)
                .pattern("l  ")
                .pattern("ll ")
                .pattern("lll")
                .input('l', ModBlocks.SEQUOIA_PLANKS)
                .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                .criterion(hasItem(ModBlocks.SEQUOIA_STAIRS), conditionsFromItem(ModBlocks.SEQUOIA_STAIRS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SEQUOIA_PRESSURE_PLATE, 1)
                .pattern("ll")
                .input('l', ModBlocks.SEQUOIA_PLANKS)
                .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                .criterion(hasItem(ModBlocks.SEQUOIA_PRESSURE_PLATE), conditionsFromItem(ModBlocks.SEQUOIA_PRESSURE_PLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_PRESSURE_PLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SEQUOIA_FENCE, 3)
                .pattern("lsl")
                .pattern("lsl")
                .input('l', ModBlocks.SEQUOIA_PLANKS)
                .input('s', Items.STICK)
                .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                .criterion(hasItem(ModBlocks.SEQUOIA_FENCE), conditionsFromItem(ModBlocks.SEQUOIA_FENCE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_FENCE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SEQUOIA_FENCE_GATE, 1)
                .pattern("sls")
                .pattern("sls")
                .input('l', ModBlocks.SEQUOIA_PLANKS)
                .input('s', Items.STICK)
                .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                .criterion(hasItem(ModBlocks.SEQUOIA_FENCE_GATE), conditionsFromItem(ModBlocks.SEQUOIA_FENCE_GATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_FENCE_GATE)));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SEQUOIA_BUTTON, 1)
                .input(ModBlocks.SEQUOIA_PLANKS)
                .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                .criterion(hasItem(ModBlocks.SEQUOIA_BUTTON), conditionsFromItem(ModBlocks.SEQUOIA_BUTTON))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_BUTTON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BI_FLAG, 1)
                .pattern("sp")
                .pattern("sm")
                .pattern("sb")
                .input('p', Blocks.PURPLE_WOOL)
                .input('m', Blocks.MAGENTA_WOOL)
                .input('b', Blocks.BLUE_WOOL)
                .input('s', Items.STICK)
                .criterion(hasItem(Blocks.PURPLE_WOOL), conditionsFromItem(Blocks.PURPLE_WOOL))
                .criterion(hasItem(Blocks.MAGENTA_WOOL), conditionsFromItem(Blocks.MAGENTA_WOOL))
                .criterion(hasItem(Blocks.BLUE_WOOL), conditionsFromItem(Blocks.BLUE_WOOL))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModBlocks.BI_FLAG), conditionsFromItem(ModBlocks.BI_FLAG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BI_FLAG)));
    }
}
