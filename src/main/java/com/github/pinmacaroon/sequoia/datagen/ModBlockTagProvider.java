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
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SEQUOIA_LOG)
                .add(ModBlocks.SEQUOIA_WOOD)
                .add(ModBlocks.STRIPPED_SEQUOIA_LOG)
                .add(ModBlocks.STRIPPED_SEQUOIA_WOOD);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.SEQUOIA_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SEQUOIA_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.SEQUOIA_FENCE);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.SEQUOIA_LEAVES);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.SEQUOIA_LEAVES);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
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
                .add(ModBlocks.SEQUOIA_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.SEQUOIA_BUTTON);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.SEQUOIA_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.SEQUOIA_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.SEQUOIA_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.SEQUOIA_DOOR);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.SEQUOIA_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.SEQUOIA_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.SEQUOIA_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.SEQUOIA_STAIRS);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.SEQUOIA_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.SEQUOIA_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.SEQUOIA_SLAB);

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.SEQUOIA_SAPLING);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.SEQUOIA_SAPLING);

        getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(ModBlocks.SEQUOIA_LOG);

        getOrCreateTagBuilder(BlockTags.SNAPS_GOAT_HORN)
                .add(ModBlocks.SEQUOIA_LOG);

        getOrCreateTagBuilder(ModTags.Block.SEQUOIA_LOGS)
                .add(ModBlocks.SEQUOIA_LOG)
                .add(ModBlocks.STRIPPED_SEQUOIA_LOG)
                .add(ModBlocks.SEQUOIA_WOOD)
                .add(ModBlocks.STRIPPED_SEQUOIA_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.SEQUOIA_PLANKS);
    }
}
