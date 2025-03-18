package com.github.pinmacaroon.sequoia.world.biome.surface;

import com.github.pinmacaroon.sequoia.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule PODZOL = makeStateRule(Blocks.PODZOL);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel,
                PODZOL), DIRT);

        return MaterialRules.sequence(/*
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.SEQUOIA_FOREST),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, makeStateRule(Blocks.STONE))),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, makeStateRule(Blocks.STONE))),*/

                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
