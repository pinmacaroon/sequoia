package com.github.pridalkomark.sequoia.datagen;

import com.github.pridalkomark.sequoia.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(ModBlocks.SEQUOIA_LOG).log(ModBlocks.SEQUOIA_LOG).wood(ModBlocks.SEQUOIA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SEQUOIA_LOG).log(ModBlocks.STRIPPED_SEQUOIA_LOG).wood(ModBlocks.STRIPPED_SEQUOIA_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SEQUOIA_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SEQUOIA_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
