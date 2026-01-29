package com.github.pinmacaroon.sequoia.block;

import com.github.pinmacaroon.sequoia.Sequoia;
import com.github.pinmacaroon.sequoia.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplings {
    public static final SaplingGenerator SEQUOIA_SAPLING_GENERATOR = new SaplingGenerator(
            "sequoia",
            Optional.of(ModConfiguredFeatures.MEDIUM_SEQUOIA),
            Optional.of(ModConfiguredFeatures.SMALL_SEQUOIA),
            Optional.empty()
    );

    public static void initialize(){
        Sequoia.LOGGER.info("im so sapling folks call me lil tree");
    }
}
