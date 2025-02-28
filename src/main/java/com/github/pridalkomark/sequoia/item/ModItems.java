package com.github.pridalkomark.sequoia.item;

import com.github.pridalkomark.sequoia.Sequoia;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //public static final Item PINE_CONE = registerItem("pine_cone", new Item(new FabricItemSettings()));

    private static void addItemsToBuildingBlockItemGroup(FabricItemGroupEntries entries) {
    }

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
    }

    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries) {
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
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
    }
}
