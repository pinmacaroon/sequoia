package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SEQUOIA_LOG);
        addDrop(ModBlocks.SEQUOIA_WOOD);
        addDrop(ModBlocks.STRIPPED_SEQUOIA_LOG);
        addDrop(ModBlocks.STRIPPED_SEQUOIA_WOOD);
        addDrop(ModBlocks.SEQUOIA_PLANKS);
        addDrop(ModBlocks.PINECONE);
        addDrop(ModBlocks.SEQUOIA_STAIRS);
        addDrop(ModBlocks.SEQUOIA_SLAB, slabDrops(ModBlocks.SEQUOIA_SLAB));
        addDrop(ModBlocks.SEQUOIA_FENCE_GATE);
        addDrop(ModBlocks.SEQUOIA_FENCE);
        addDrop(ModBlocks.SEQUOIA_BUTTON);
        addDrop(ModBlocks.SEQUOIA_TRAPDOOR);
        addDrop(ModBlocks.SEQUOIA_PRESSURE_PLATE);
        addDrop(ModBlocks.SEQUOIA_DOOR, doorDrops(ModBlocks.SEQUOIA_DOOR));
        addDrop(ModBlocks.SEQUOIA_LEAVES,leavesDrops(ModBlocks.SEQUOIA_LEAVES, ModBlocks.PINECONE, 0.005f));
    }
}
