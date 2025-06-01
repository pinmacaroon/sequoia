package com.github.pinmacaroon.sequoia.item;

import com.github.pinmacaroon.sequoia.Sequoia;
import com.github.pinmacaroon.sequoia.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItems {
    //public static final Item PINE_CONE = registerItem("pine_cone", new Item(new FabricItemSettings()));
    //public static final Item BIFLAG = registerItem("biflag", new Item(new FabricItemSettings()));

    private static void addItemsToBuildingBlockItemGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Blocks.WARPED_BUTTON, ModBlocks.SEQUOIA_LOG);
        entries.addAfter(ModBlocks.SEQUOIA_LOG, ModBlocks.SEQUOIA_WOOD);
        entries.addAfter(ModBlocks.SEQUOIA_WOOD, ModBlocks.STRIPPED_SEQUOIA_LOG);
        entries.addAfter(ModBlocks.STRIPPED_SEQUOIA_LOG, ModBlocks.STRIPPED_SEQUOIA_WOOD);
        entries.addAfter(ModBlocks.STRIPPED_SEQUOIA_WOOD, ModBlocks.SEQUOIA_PLANKS);
        entries.addAfter(ModBlocks.SEQUOIA_PLANKS, ModBlocks.SEQUOIA_STAIRS);
        entries.addAfter(ModBlocks.SEQUOIA_STAIRS, ModBlocks.SEQUOIA_SLAB);
        entries.addAfter(ModBlocks.SEQUOIA_SLAB, ModBlocks.SEQUOIA_FENCE);
        entries.addAfter(ModBlocks.SEQUOIA_FENCE, ModBlocks.SEQUOIA_FENCE_GATE);
        entries.addAfter(ModBlocks.SEQUOIA_FENCE_GATE, ModBlocks.SEQUOIA_DOOR);
        entries.addAfter(ModBlocks.SEQUOIA_DOOR, ModBlocks.SEQUOIA_TRAPDOOR);
        entries.addAfter(ModBlocks.SEQUOIA_TRAPDOOR, ModBlocks.SEQUOIA_BUTTON);
        entries.addAfter(ModBlocks.SEQUOIA_BUTTON, ModBlocks.SEQUOIA_PRESSURE_PLATE);
    }

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
    }

    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries) {
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {

    }

    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Blocks.SPRUCE_SAPLING, ModBlocks.SEQUOIA_SAPLING);
        entries.addAfter(Blocks.FLOWERING_AZALEA, ModBlocks.PINECONE);
        entries.addAfter(Blocks.FLOWERING_AZALEA_LEAVES, ModBlocks.SEQUOIA_LEAVES);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Sequoia.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Sequoia.LOGGER.info("items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlockItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalItemGroup);
    }


    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id));
    }
}
