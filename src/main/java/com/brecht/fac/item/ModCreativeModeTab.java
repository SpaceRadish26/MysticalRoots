package com.brecht.fac.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MR_TAB = new CreativeModeTab("myr") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FOREST_ESSENCE.get());
        }
    };
}
