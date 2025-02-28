package com.github.pridalkomark.sequoia.block;

import com.github.pridalkomark.sequoia.Sequoia;
import com.github.pridalkomark.sequoia.world.tree.SequoiaSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SEQUOIA_LOG = registerBlock("sequoia_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(3f)));
    public static final Block SEQUOIA_WOOD = registerBlock("sequoia_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(3f)));
    public static final Block STRIPPED_SEQUOIA_LOG = registerBlock("stripped_sequoia_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final Block STRIPPED_SEQUOIA_WOOD = registerBlock("stripped_sequoia_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(3f)));
    public static final Block SEQUOIA_PLANKS = registerBlock("sequoia_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(3f)));
    public static final Block SEQUOIA_LEAVES = registerBlock("sequoia_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(3f).nonOpaque()));

    //TODO custom falling block class pls pridalkomark do it :3
    public static final Block PINECONE = registerBlock("pinecone", new FallingBlock(FabricBlockSettings.create().strength(3f).sounds(BlockSoundGroup.WOOD)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Sequoia.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Sequoia.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Sequoia.LOGGER.info("registering blocks for " + Sequoia.MOD_ID);
    }
}
