package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.Sequoia;
import com.github.pinmacaroon.sequoia.block.ModBlocks;
import com.github.pinmacaroon.sequoia.etc.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
        return new RecipeGenerator(wrapperLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEQUOIA_PLANKS, 4)
                        .input(ModTags.Items.SEQUOIA_LOG_LIKES)
                        .criterion(hasItem(ModBlocks.SEQUOIA_LOG), conditionsFromItem(ModBlocks.SEQUOIA_LOG))
                        .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_LOG), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_LOG))
                        .criterion(hasItem(ModBlocks.SEQUOIA_WOOD), conditionsFromItem(ModBlocks.SEQUOIA_WOOD))
                        .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_WOOD), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_WOOD))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEQUOIA_WOOD, 3)
                        .pattern("ll")
                        .pattern("ll")
                        .input('l', ModBlocks.SEQUOIA_LOG)
                        .criterion(hasItem(ModBlocks.SEQUOIA_LOG), conditionsFromItem(ModBlocks.SEQUOIA_LOG))
                        .criterion(hasItem(ModBlocks.SEQUOIA_WOOD), conditionsFromItem(ModBlocks.SEQUOIA_WOOD))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEQUOIA_WALL, 6)
                        .pattern("lll")
                        .pattern("lll")
                        .input('l', ModTags.Items.SEQUOIA_LOG_LIKES)
                        .criterion(hasItem(ModBlocks.SEQUOIA_LOG), conditionsFromItem(ModBlocks.SEQUOIA_LOG))
                        .criterion(hasItem(ModBlocks.SEQUOIA_WOOD), conditionsFromItem(ModBlocks.SEQUOIA_WOOD))
                        .criterion(hasItem(ModBlocks.SEQUOIA_WALL), conditionsFromItem(ModBlocks.SEQUOIA_WALL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_SEQUOIA_WOOD, 1)
                        .pattern("ll")
                        .pattern("ll")
                        .input('l', ModBlocks.STRIPPED_SEQUOIA_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_LOG), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_LOG))
                        .criterion(hasItem(ModBlocks.STRIPPED_SEQUOIA_WOOD), conditionsFromItem(ModBlocks.STRIPPED_SEQUOIA_WOOD))
                        .offerTo(exporter);

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEQUOIA_SLAB, Ingredient.ofItem(
                        ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_SLAB), conditionsFromItem(ModBlocks.SEQUOIA_SLAB))
                        .offerTo(exporter);

                createTrapdoorRecipe(ModBlocks.SEQUOIA_TRAPDOOR, Ingredient.ofItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_TRAPDOOR), conditionsFromItem(ModBlocks.SEQUOIA_TRAPDOOR))
                        .offerTo(exporter);

                createDoorRecipe(ModBlocks.SEQUOIA_DOOR, Ingredient.ofItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_DOOR), conditionsFromItem(ModBlocks.SEQUOIA_DOOR))
                        .offerTo(exporter);

                createStairsRecipe(ModBlocks.SEQUOIA_STAIRS, Ingredient.ofItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_STAIRS), conditionsFromItem(ModBlocks.SEQUOIA_STAIRS))
                        .offerTo(exporter);

                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.SEQUOIA_PRESSURE_PLATE,
                        Ingredient.ofItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PRESSURE_PLATE), conditionsFromItem(ModBlocks.SEQUOIA_PRESSURE_PLATE))
                        .offerTo(exporter);

                createFenceRecipe(ModBlocks.SEQUOIA_FENCE, Ingredient.ofItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_FENCE), conditionsFromItem(ModBlocks.SEQUOIA_FENCE))
                        .offerTo(exporter);

                createFenceGateRecipe(ModBlocks.SEQUOIA_FENCE_GATE, Ingredient.ofItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_FENCE_GATE), conditionsFromItem(ModBlocks.SEQUOIA_FENCE_GATE))
                        .offerTo(exporter);

                createButtonRecipe(ModBlocks.SEQUOIA_BUTTON, Ingredient.ofItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_PLANKS), conditionsFromItem(ModBlocks.SEQUOIA_PLANKS))
                        .criterion(hasItem(ModBlocks.SEQUOIA_BUTTON), conditionsFromItem(ModBlocks.SEQUOIA_BUTTON))
                        .offerTo(exporter);



                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BI_FLAG, 1)
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
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return Sequoia.MOD_ID + "RecipeProvider";
    }
}
