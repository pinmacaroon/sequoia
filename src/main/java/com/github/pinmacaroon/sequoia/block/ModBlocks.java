package com.github.pinmacaroon.sequoia.block;

import com.github.pinmacaroon.sequoia.Sequoia;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final WoodType SEQUIA_WOOD_TYPE = new WoodType("sequoia", BlockSetType.OAK);
    // use .setType() to get set

    public static final Block SEQUOIA_LOG = registerBlock(
            "sequoia_log",
            AbstractBlock.Settings
                    .copy(Blocks.OAK_LOG),
            PillarBlock::new
    );
    public static final Block SEQUOIA_WOOD = registerBlock(
            "sequoia_wood",
            AbstractBlock.Settings
                    .copy(Blocks.OAK_WOOD),
            PillarBlock::new
    );
    public static final Block STRIPPED_SEQUOIA_LOG = registerBlock(
            "stripped_sequoia_log",
            AbstractBlock.Settings
                    .copy(Blocks.STRIPPED_OAK_LOG),
            PillarBlock::new
    );
    public static final Block STRIPPED_SEQUOIA_WOOD = registerBlock(
            "stripped_sequoia_wood",
            AbstractBlock.Settings
                    .copy(Blocks.STRIPPED_OAK_WOOD),
            PillarBlock::new
    );
    public static final Block SEQUOIA_PLANKS = registerBlock(
            "sequoia_planks",
            AbstractBlock.Settings
                    .copy(Blocks.OAK_PLANKS),
            Block::new
    );
    public static final Block SEQUOIA_LEAVES = registerBlock(
            "sequoia_leaves",
            AbstractBlock.Settings
                    .copy(Blocks.OAK_LEAVES)
                    .nonOpaque(),
            settings -> new UntintedParticleLeavesBlock(
                    0.01F,
                    ParticleTypes.PALE_OAK_LEAVES, //TODO get someone to make the leaves falling particle thing
                    settings
            )
    );
    public static final Block SEQUOIA_SLAB = registerBlock(
            "sequoia_slab",
            AbstractBlock.Settings
                    .copy(Blocks.OAK_SLAB),
            SlabBlock::new
    );
    public static final Block SEQUOIA_STAIRS = registerBlock(
            "sequoia_stairs",
            AbstractBlock.Settings.copy(Blocks.OAK_STAIRS),
            settings -> new StairsBlock(SEQUOIA_PLANKS.getDefaultState(), settings)
    );
    public static final Block SEQUOIA_FENCE = registerBlock(
            "sequoia_fence", AbstractBlock.Settings.copy(Blocks.OAK_FENCE), FenceBlock::new
    );
    public static final Block SEQUOIA_WALL = registerBlock(
            "sequoia_wall", AbstractBlock.Settings.copy(Blocks.OAK_FENCE), WallBlock::new
    );
    public static final Block SEQUOIA_FENCE_GATE = registerBlock(
            "sequoia_fence_gate",
            AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE),
            settings -> new FenceGateBlock(SEQUIA_WOOD_TYPE, settings)
    );
    public static final Block SEQUOIA_DOOR = registerBlock(
            "sequoia_door",
            AbstractBlock.Settings.copy(Blocks.OAK_DOOR),
            settings -> new DoorBlock(SEQUIA_WOOD_TYPE.setType(), settings)
    );
    public static final Block SEQUOIA_PRESSURE_PLATE = registerBlock(
            "sequoia_pressure_plate",
            AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE),
            settings -> new PressurePlateBlock(SEQUIA_WOOD_TYPE.setType(), settings)
    );
    public static final Block SEQUOIA_TRAPDOOR = registerBlock(
            "sequoia_trapdoor",
            AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR),
            settings -> new TrapdoorBlock(SEQUIA_WOOD_TYPE.setType(), settings)
    );
    public static final Block SEQUOIA_BUTTON = registerBlock(
            "sequoia_button",
            AbstractBlock.Settings
                    .create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            settings -> createWoodenButtonBlock(SEQUIA_WOOD_TYPE.setType(), settings)
    );

    //credit: potato_archivist
    public static final Block PINECONE = registerBlock(
            "pinecone",
            AbstractBlock.Settings
                    .create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD),
            settings -> new ConditionalFallingBlock(
                    settings,
                    BlockTags.LEAVES,
                    true,
                    true
            )
    );

    public static final Block SEQUOIA_SAPLING = registerBlock(
            "sequoia_sapling",
            AbstractBlock.Settings.copy(Blocks.DARK_OAK_SAPLING),
            settings -> new SaplingBlock(ModSaplings.SEQUOIA_SAPLING_GENERATOR, settings)
    );

    public static final Block BI_FLAG = registerBlock(
            "bi_flag",
            AbstractBlock.Settings
                    .create()
                    .burnable()
                    .noCollision()
                    .nonOpaque(),
            FlagBlock::new
    );

    private static Block registerBlockPrecise(String name,
                                  Function<AbstractBlock.Settings, Block> blockFactory,
                                  AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Sequoia.MOD_ID, name));;
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Sequoia.MOD_ID, name));

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Block registerBlock(String name,
                                       AbstractBlock.Settings settings,
                                       Function<AbstractBlock.Settings, Block> blockFactory) {
        return registerBlockPrecise(name, blockFactory, settings, true);
    }

    public static void registerModBlocks() {
        Sequoia.LOGGER.info("Registering blocks for " + Sequoia.MOD_ID);
    }

    public static ButtonBlock createWoodenButtonBlock(BlockSetType blockSetType, AbstractBlock.Settings settings, FeatureFlag... requiredFeatures) {
        return new ButtonBlock(
                blockSetType,
                30,
                (requiredFeatures.length > 0)
                        ? settings.requires(requiredFeatures)
                        : settings
        );
    }
}
