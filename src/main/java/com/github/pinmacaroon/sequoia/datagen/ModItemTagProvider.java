package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.Sequoia;
import com.github.pinmacaroon.sequoia.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.SEQUOIA_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SEQUOIA_LOG.asItem())
                .add(ModBlocks.SEQUOIA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SEQUOIA_LOG.asItem())
                .add(ModBlocks.STRIPPED_SEQUOIA_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.PINECONE.asItem());
    }
    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(Sequoia.MOD_ID + ":" + id));
    }
}
