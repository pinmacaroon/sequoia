package com.github.pinmacaroon.sequoia.world;

import com.github.pinmacaroon.sequoia.Sequoia;
import com.github.pinmacaroon.sequoia.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_SEQUOIA = registerKey("sequoia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEDIUM_SEQUOIA = registerKey("medium_sequoia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINECONE_SCATTER = registerKey("pinecone_scatter");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, SMALL_SEQUOIA, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SEQUOIA_LOG),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.of(ModBlocks.SEQUOIA_LEAVES),
                new SpruceFoliagePlacer(
                        UniformIntProvider.create(2, 3),
                        UniformIntProvider.create(0, 2),
                        UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2))
                .ignoreVines().build());

        register(context, MEDIUM_SEQUOIA, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SEQUOIA_LOG),
                new GiantTrunkPlacer(13, 2, 10),
                BlockStateProvider.of(ModBlocks.SEQUOIA_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(5, 9)),
                new TwoLayersFeatureSize(2, 0, 2))
                .ignoreVines()
                .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL))))
                .build());

        register(context, PINECONE_SCATTER, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(
                        ModBlocks.PINECONE
                                .getDefaultState()
                                .rotate(
                                        BlockRotation.random(Random.create())
                                )
                )
        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Sequoia.MOD_ID, name));
    }

    private static <
            FC extends FeatureConfig,
            F extends Feature<FC>
            > void register(Registerable<ConfiguredFeature<?, ?>> context,
                            RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration
    ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
