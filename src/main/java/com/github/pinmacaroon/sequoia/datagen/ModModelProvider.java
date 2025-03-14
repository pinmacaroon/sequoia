package com.github.pinmacaroon.sequoia.datagen;

import com.github.pinmacaroon.sequoia.block.ModBlocks;
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
        blockStateModelGenerator.registerLog(ModBlocks.SEQUOIA_LOG)
                .log(ModBlocks.SEQUOIA_LOG).wood(ModBlocks.SEQUOIA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SEQUOIA_LOG)
                .log(ModBlocks.STRIPPED_SEQUOIA_LOG).wood(ModBlocks.STRIPPED_SEQUOIA_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SEQUOIA_LEAVES);

        BlockStateModelGenerator.BlockTexturePool sequoiaPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(
                        ModBlocks.SEQUOIA_PLANKS
                );
        sequoiaPool.stairs(ModBlocks.SEQUOIA_STAIRS);
        sequoiaPool.slab(ModBlocks.SEQUOIA_SLAB);
        sequoiaPool.pressurePlate(ModBlocks.SEQUOIA_PRESSURE_PLATE);
        sequoiaPool.button(ModBlocks.SEQUOIA_BUTTON);
        sequoiaPool.fence(ModBlocks.SEQUOIA_FENCE);
        sequoiaPool.fenceGate(ModBlocks.SEQUOIA_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.SEQUOIA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SEQUOIA_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
