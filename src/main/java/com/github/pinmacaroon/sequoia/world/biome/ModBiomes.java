package com.github.pinmacaroon.sequoia.world.biome;

import com.github.pinmacaroon.sequoia.Sequoia;
import com.github.pinmacaroon.sequoia.world.ModPlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

public class ModBiomes {
    public static final RegistryKey<Biome> SEQUOIA_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(Sequoia.MOD_ID, "sequoia_forest"));

    public static void bootstrap(Registerable<Biome> context){
        context.register(SEQUOIA_FOREST, sequoiaForest(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome sequoiaForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 8, 4, 4));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 4));

        //DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));


        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // PLEASE PLEASE DO NOT CHANGE ANYTHING BELOW THIS LINE
        // WHEN I WROTE THIS, ONLY GOD AND I KNEW HOW IT WORKS
        // NOW ONLY GOD KNOWS
        //
        // pin
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        globalOverworldGeneration(biomeBuilder);

        //RAW_GENERATION

        //LAKES

        //LOCAL_MODIFICATIONS

        //UNDERGROUND_STRUCTURES

        //SURFACE_STRUCTURES

        //STRONGHOLDS

        //UNDERGROUND_ORES

        //UNDERGROUND_DECORATION

        //FLUID_SPRINGS

        //VEGETAL_DECORATION

        //TOP_LAYER_MODIFICATION

        //???OTHER????

        DefaultBiomeFeatures.addMossyRocks(biomeBuilder);

        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);

        biomeBuilder.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.SMALL_SEQUOIA_PK
        );

        biomeBuilder.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.MEDIUM_SEQUOIA_PK
        );

        DefaultBiomeFeatures.addDefaultFlowers(biomeBuilder);
        DefaultBiomeFeatures.addGiantTaigaGrass(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);
        DefaultBiomeFeatures.addSweetBerryBushes(biomeBuilder);

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // now you are free to goof around, have fun >w<
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.5f)
                .temperature(0.6f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x79a9e8)
                        .waterFogColor(0x5d85ba)
                        .skyColor(0x8cbeff)
                        .grassColor(0xb6e665)
                        .foliageColor(0x55b045)                                                                         //doesnt affect our foliage B-)
                        .fogColor(0xd1d1d1)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }

}
