package com.github.pridalkomark.sequoia;

import com.github.pridalkomark.sequoia.block.ModBlocks;
import com.github.pridalkomark.sequoia.item.ModItems;
import com.github.pridalkomark.sequoia.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.FireBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sequoia implements ModInitializer {
	public static final String MOD_ID = "sequoia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info(MOD_ID + " is initializing!");
		ModWorldGeneration.genModWorldGen();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		StrippableBlockRegistry.register(ModBlocks.SEQUOIA_LOG, ModBlocks.STRIPPED_SEQUOIA_LOG);
		StrippableBlockRegistry.register(ModBlocks.SEQUOIA_WOOD, ModBlocks.STRIPPED_SEQUOIA_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SEQUOIA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SEQUOIA_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SEQUOIA_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SEQUOIA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SEQUOIA_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SEQUOIA_LEAVES, 30, 60);
	}
}