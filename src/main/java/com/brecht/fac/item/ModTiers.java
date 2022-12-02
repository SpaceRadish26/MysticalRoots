package com.brecht.fac.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier LEMON = new ForgeTier(2,150,1.5f,2f,4, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ModItems.LEMON.get()));
}
