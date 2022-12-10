package com.brecht.fac.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier LEMON = new ForgeTier(2,150,1.5f,2f,4, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ModItems.LEMON.get()));
    public static final ForgeTier GHOST = new ForgeTier(4,1500,3f,2f,8, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.GHOST_INGOT.get()));
}
