package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.block.ModBlocks;
import com.github.pinmacaroon.sequoia.etc.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SEQUOIA_LOG)
                .add(ModBlocks.SEQUOIA_WOOD)
                .add(ModBlocks.STRIPPED_SEQUOIA_LOG)
                .add(ModBlocks.STRIPPED_SEQUOIA_WOOD);

        valueLookupBuilder(BlockTags.FENCES)
                .add(ModBlocks.SEQUOIA_FENCE);

        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SEQUOIA_FENCE_GATE);

        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.SEQUOIA_FENCE);

        valueLookupBuilder(BlockTags.LEAVES)
                .add(ModBlocks.SEQUOIA_LEAVES);

        valueLookupBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.SEQUOIA_LEAVES);

        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.PINECONE)
                .add(ModBlocks.SEQUOIA_PRESSURE_PLATE)
                .add(ModBlocks.SEQUOIA_TRAPDOOR)
                .add(ModBlocks.SEQUOIA_DOOR)
                .add(ModBlocks.STRIPPED_SEQUOIA_LOG)
                .add(ModBlocks.STRIPPED_SEQUOIA_WOOD)
                .add(ModBlocks.SEQUOIA_LOG)
                .add(ModBlocks.SEQUOIA_PLANKS)
                .add(ModBlocks.SEQUOIA_STAIRS)
                .add(ModBlocks.SEQUOIA_SLAB)
                .add(ModBlocks.SEQUOIA_FENCE)
                .add(ModBlocks.SEQUOIA_FENCE_GATE)
                .add(ModBlocks.SEQUOIA_SAPLING)
                .add(ModBlocks.SEQUOIA_BUTTON)
                .add(ModBlocks.SEQUOIA_WALL);

        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.SEQUOIA_BUTTON);

        valueLookupBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.SEQUOIA_BUTTON);

        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.SEQUOIA_PRESSURE_PLATE);

        valueLookupBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.SEQUOIA_PRESSURE_PLATE);

        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.SEQUOIA_DOOR);

        valueLookupBuilder(BlockTags.DOORS)
                .add(ModBlocks.SEQUOIA_DOOR);

        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.SEQUOIA_TRAPDOOR);

        valueLookupBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.SEQUOIA_TRAPDOOR);

        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.SEQUOIA_STAIRS);

        valueLookupBuilder(BlockTags.STAIRS)
                .add(ModBlocks.SEQUOIA_STAIRS);

        valueLookupBuilder(BlockTags.SLABS)
                .add(ModBlocks.SEQUOIA_SLAB);

        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.SEQUOIA_SLAB);

        valueLookupBuilder(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.SEQUOIA_SAPLING);

        valueLookupBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.SEQUOIA_SAPLING);

        valueLookupBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(ModBlocks.SEQUOIA_LOG);

        valueLookupBuilder(BlockTags.SNAPS_GOAT_HORN)
                .add(ModBlocks.SEQUOIA_LOG);

        valueLookupBuilder(ModTags.Block.SEQUOIA_LOGS)
                .add(ModBlocks.SEQUOIA_LOG)
                .add(ModBlocks.STRIPPED_SEQUOIA_LOG)
                .add(ModBlocks.SEQUOIA_WOOD)
                .add(ModBlocks.STRIPPED_SEQUOIA_WOOD);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(ModBlocks.SEQUOIA_PLANKS);
    }
}
