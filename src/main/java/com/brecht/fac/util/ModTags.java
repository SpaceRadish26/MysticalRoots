package com.brecht.fac.util;

import com.brecht.fac.MysticalRoots;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> PORTAL_FRAME_BLOCKS
                = tag("portal_frame_blocks");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MysticalRoots.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> GHOST_INGOT = forgeTag("ingots/ghost");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(MysticalRoots.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
