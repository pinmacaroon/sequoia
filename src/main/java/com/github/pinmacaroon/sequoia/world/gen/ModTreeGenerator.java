package com.github.pinmacaroon.sequoia.world.gen;

import com.github.pinmacaroon.sequoia.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

@Deprecated
public class ModTreeGenerator {
    public static void genTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SMALL_SEQUOIA_PK);
    }
}
