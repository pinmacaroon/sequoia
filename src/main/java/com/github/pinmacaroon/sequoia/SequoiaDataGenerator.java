package com.github.pinmacaroon.sequoia;

import com.github.pinmacaroon.sequoia.datagen.*;
import com.github.pinmacaroon.sequoia.world.ModConfiguredFeatures;
import com.github.pinmacaroon.sequoia.world.ModPlacedFeatures;
import com.github.pinmacaroon.sequoia.world.biome.ModBiomes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class SequoiaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		//HUGE shout out to anonymus discord user for fixing our cursed datagen

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagProvider::new);

		// ModWorldGenerator should run after
		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModAdvancementGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);

	}
}
