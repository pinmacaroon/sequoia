package com.github.pinmacaroon.sequoia.etc;

import com.github.pinmacaroon.sequoia.Sequoia;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Block {
        public static final TagKey<net.minecraft.block.Block> SEQUOIA_LOGS  = createTag("sequoia_logs");

        private static TagKey<net.minecraft.block.Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Sequoia.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> SEQUOIA_LOG_LIKES  = createTag("sequoia_log_likes");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Sequoia.MOD_ID, name));
        }
    }
}
