package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(ModBlocks.SEQUOIA_LOG, TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.STRIPPED_SEQUOIA_LOG, TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SEQUOIA_LEAVES);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SEQUOIA_PLANKS)
            .stairs(ModBlocks.SEQUOIA_STAIRS)
            .slab(ModBlocks.SEQUOIA_SLAB)
            .pressurePlate(ModBlocks.SEQUOIA_PRESSURE_PLATE)
            .button(ModBlocks.SEQUOIA_BUTTON)
            .fence(ModBlocks.SEQUOIA_FENCE)
            .fenceGate(ModBlocks.SEQUOIA_FENCE_GATE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SEQUOIA_WOOD)
                .wall(ModBlocks.SEQUOIA_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.SEQUOIA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SEQUOIA_TRAPDOOR);

        blockStateModelGenerator.registerTintableCrossBlockState(
                ModBlocks.SEQUOIA_SAPLING,
                BlockStateModelGenerator.CrossType.NOT_TINTED
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
