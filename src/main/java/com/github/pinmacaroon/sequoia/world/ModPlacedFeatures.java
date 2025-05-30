package com.github.pinmacaroon.sequoia.world;

import com.github.pinmacaroon.sequoia.Sequoia;
import com.github.pinmacaroon.sequoia.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> SMALL_SEQUOIA_PK = registerKey("small_sequoia");
    public static final RegistryKey<PlacedFeature> MEDIUM_SEQUOIA_PK = registerKey("medium_sequoia");
    public static final RegistryKey<PlacedFeature> PINECONE_SCATTER_PK = registerKey("pinecone_scatter");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SMALL_SEQUOIA_PK, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_SEQUOIA),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.2f, 2),
                        ModBlocks.SEQUOIA_SAPLING));

        register(context, MEDIUM_SEQUOIA_PK, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MEDIUM_SEQUOIA),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 1),
                        ModBlocks.SEQUOIA_SAPLING));

        /*register(context, PINECONE_SCATTER_PK, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINECONE_SCATTER),
                VegetationPlacedFeatures.modifiers(2));*/
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Sequoia.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
