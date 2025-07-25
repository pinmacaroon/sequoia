package com.github.pinmacaroon.sequoia;

import com.github.pinmacaroon.sequoia.block.ModBlocks;
import com.github.pinmacaroon.sequoia.etc.ModParticles;
import com.github.pinmacaroon.sequoia.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sequoia implements ModInitializer {
	public static final String MOD_ID = "sequoia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info(MOD_ID + " is initializing!");
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModParticles.registerModParticles();

		Sequoia.LOGGER.info("Registering strippable blocks for " + Sequoia.MOD_ID);
		StrippableBlockRegistry.register(ModBlocks.SEQUOIA_LOG, ModBlocks.STRIPPED_SEQUOIA_LOG);
		StrippableBlockRegistry.register(ModBlocks.SEQUOIA_WOOD, ModBlocks.STRIPPED_SEQUOIA_WOOD);

		Sequoia.LOGGER.info("Registering flammable blocks for " + Sequoia.MOD_ID);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SEQUOIA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SEQUOIA_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SEQUOIA_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BI_FLAG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SEQUOIA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SEQUOIA_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SEQUOIA_LEAVES, 30, 60);
	}
}