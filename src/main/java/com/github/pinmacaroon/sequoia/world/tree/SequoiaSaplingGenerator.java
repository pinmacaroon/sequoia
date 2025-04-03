package com.github.pinmacaroon.sequoia.world.tree;

import com.github.pinmacaroon.sequoia.world.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SequoiaSaplingGenerator {
    public static final SaplingGenerator SEQUOIA =
            new SaplingGenerator("sequoia", 0f,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.SEQUOIA_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}
