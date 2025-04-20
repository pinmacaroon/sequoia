package com.github.pinmacaroon.sequoia.block;

import com.github.pinmacaroon.sequoia.Sequoia;
import com.github.pinmacaroon.sequoia.world.SequoiaSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final WoodType SEQUIA_WOOD_TYPE = new WoodType("sequoia", BlockSetType.OAK);
    //public static final BlockSetType SEQUIA_WOOD_TYPE = new BlockSetType("sequoia", BlockSetType.OAK);
    //TODO custom BlockSetType for sequia ples

    public static final Block SEQUOIA_LOG = registerBlock(
            "sequoia_log",
            new PillarBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_LOG)
                            .strength(2f)
            )
    );
    public static final Block SEQUOIA_WOOD = registerBlock(
            "sequoia_wood",
            new PillarBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_WOOD)
                            .strength(2f)
            )
    );
    public static final Block STRIPPED_SEQUOIA_LOG = registerBlock(
            "stripped_sequoia_log",
            new PillarBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.STRIPPED_OAK_LOG)
                            .strength(2f)
            )
    );
    public static final Block STRIPPED_SEQUOIA_WOOD = registerBlock(
            "stripped_sequoia_wood",
            new PillarBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.STRIPPED_OAK_WOOD)
                            .strength(2f)
            )
    );
    public static final Block SEQUOIA_PLANKS = registerBlock(
            "sequoia_planks",
            new Block(
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_PLANKS)
                            .strength(2f)
            )
    );
    public static final Block SEQUOIA_LEAVES = registerBlock(
            "sequoia_leaves",
            new LeavesBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_LEAVES)
                            .nonOpaque()
            )
    );
    public static final Block SEQUOIA_SLAB = registerBlock(
            "sequoia_slab",
            new SlabBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_SLAB)
                            .strength(2f)
            )
    );
    public static final Block SEQUOIA_STAIRS = registerBlock(
            "sequoia_stairs",
            new StairsBlock(
                    SEQUOIA_PLANKS.getDefaultState(),
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_SLAB)
                            .strength(2f)
            )
    );
    public static final Block SEQUOIA_FENCE = registerBlock(
            "sequoia_fence",
            new FenceBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_FENCE)
                            .strength(2f)
            )
    );
    public static final Block SEQUOIA_FENCE_GATE = registerBlock(
            "sequoia_fence_gate",
            new FenceGateBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_FENCE)
                            .strength(2f),
                    SEQUIA_WOOD_TYPE
            )
    );
    public static final Block SEQUOIA_DOOR = registerBlock(
            "sequoia_door",
            new DoorBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_FENCE)
                            .strength(2f),
                    BlockSetType.OAK
            )
    );
    public static final Block SEQUOIA_PRESSURE_PLATE = registerBlock(
            "sequoia_pressure_plate",
            new PressurePlateBlock(
                    PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_FENCE)
                            .strength(2f),
                    BlockSetType.OAK
            )
    );
    public static final Block SEQUOIA_TRAPDOOR = registerBlock(
            "sequoia_trapdoor",
            new TrapdoorBlock(
                    FabricBlockSettings
                            .copyOf(Blocks.OAK_FENCE)
                            .strength(2f),
                    BlockSetType.OAK
            )
    );
    public static final Block SEQUOIA_BUTTON = registerBlock(
            "sequoia_button",
            createWoodenButtonBlock(BlockSetType.OAK)
    );

    //credit: potato_archivist
    public static final Block PINECONE = registerBlock(
            "pinecone",
            new ConditionalFallingBlock(
                    FabricBlockSettings
                            .create()
                            .strength(3f)
                            .sounds(BlockSoundGroup.WOOD),
                    SEQUOIA_LEAVES,
                    true,
                    true
            )
    );

    public static final Block SEQUOIA_SAPLING = registerBlock(
            "sequoia_sapling",
            new SaplingBlock(
                    new SequoiaSaplingGenerator(),
                    FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
            )
    );

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

    public static ButtonBlock createWoodenButtonBlock(BlockSetType blockSetType, FeatureFlag... requiredFeatures) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY);
        if (requiredFeatures.length > 0) {
            settings = settings.requires(requiredFeatures);
        }

        return new ButtonBlock(settings, blockSetType, 30, true);
    }
}
