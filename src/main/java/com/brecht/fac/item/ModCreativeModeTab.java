package com.brecht.fac.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FAC_TAB = new CreativeModeTab("fac") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SABER.get());
        }
    };
}
