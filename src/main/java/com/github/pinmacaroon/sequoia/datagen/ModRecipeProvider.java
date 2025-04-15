package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.block.ModBlocks;
import com.github.pinmacaroon.sequoia.etc.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }



    private static final List<ItemConvertible> LOG_LIKES = List.of(
            ModBlocks.SEQUOIA_LOG,
            ModBlocks.STRIPPED_SEQUOIA_LOG,
            ModBlocks.SEQUOIA_WOOD,
            ModBlocks.STRIPPED_SEQUOIA_WOOD
    );

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SEQUOIA_WOOD, 1)
                .pattern("ll")
                .pattern("ll")
                .input('l', ModBlocks.SEQUOIA_LOG)
                .criterion(hasItem(ModBlocks.SEQUOIA_LOG), conditionsFromItem(ModBlocks.SEQUOIA_LOG))
                .criterion(hasItem(ModBlocks.SEQUOIA_WOOD), conditionsFromItem(ModBlocks.SEQUOIA_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEQUOIA_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.STRIPPED_SEQUOIA_WOOD, 1)
                .pattern("ll")
                .pattern("ll")
                .input('l', ModBlocks.STRIPPED_SEQUOIA_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_LOG), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_LOG))
                .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_WOOD), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STRIPPED_SEQUOIA_WOOD)));
    }

    public static void offerCustomUpgradeRecipe(Consumer<RecipeJsonProvider> exporter, Item input, RecipeCategory category, Item result, Item template, Item material) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(template), Ingredient.ofItems(input), Ingredient.ofItems(material), category, result
                )
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter, getItemPath(result) + "_smithing");
    }
}
