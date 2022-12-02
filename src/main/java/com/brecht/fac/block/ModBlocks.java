package com.brecht.fac.block;

import com.brecht.fac.FantasyAndCombat;
import com.brecht.fac.block.custom.SpeedyBlock;
import com.brecht.fac.item.ModCreativeModeTab;
import com.brecht.fac.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.*;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FantasyAndCombat.MOD_ID);

    public static final RegistryObject<Block> LEMON_BLOCK = registerBlock("lemon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CACTUS).strength(2f)), ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f)), ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> LEMON_STAIRS = registerBlock("lemon_stairs",
            () -> new StairBlock(() -> ModBlocks.LEMON_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.CACTUS).strength(2f)), ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> LEMON_SLAB = registerBlock("lemon_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.CACTUS).strength(2f)), ModCreativeModeTab.FAC_TAB);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
