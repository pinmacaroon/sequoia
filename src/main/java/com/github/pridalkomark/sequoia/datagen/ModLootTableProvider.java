package com.github.pridalkomark.sequoia.datagen;

import com.github.pridalkomark.sequoia.block.ModBlocks;
import com.github.pridalkomark.sequoia.item.ModItems;
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
        addDrop(ModBlocks.SEQUOIA_LEAVES,leavesDrops(ModBlocks.SEQUOIA_LEAVES, ModBlocks.PINECONE, 0.005f));
    }
}
