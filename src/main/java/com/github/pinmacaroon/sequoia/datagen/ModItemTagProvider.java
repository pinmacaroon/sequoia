package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.block.ModBlocks;
import com.github.pinmacaroon.sequoia.etc.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.SEQUOIA_PLANKS.asItem());
        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SEQUOIA_LOG.asItem())
                .add(ModBlocks.SEQUOIA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SEQUOIA_LOG.asItem())
                .add(ModBlocks.STRIPPED_SEQUOIA_WOOD.asItem());
        valueLookupBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.PINECONE.asItem());
        valueLookupBuilder(ModTags.Items.SEQUOIA_LOG_LIKES)
                .add(ModBlocks.SEQUOIA_LOG.asItem())
                .add(ModBlocks.STRIPPED_SEQUOIA_LOG.asItem())
                .add(ModBlocks.SEQUOIA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SEQUOIA_WOOD.asItem());
    }
}
