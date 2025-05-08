package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.block.ModBlocks;
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
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.SEQUOIA_LEAVES);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.SEQUOIA_LEAVES);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.PINECONE)
                .add(ModBlocks.SEQUOIA_BUTTON);
        //getOrCreateTagBuilder(BlockTags.SNAPS_GOAT_HORN) //TODO fix block tags, diff vanilla and local block tag-sets
    }
}
