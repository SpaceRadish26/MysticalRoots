package com.brecht.fac.block;

import com.brecht.fac.FantasyAndNature;
import com.brecht.fac.block.custom.SpeedyBlock;
import com.brecht.fac.item.ModCreativeModeTab;
import com.brecht.fac.item.ModItems;
import com.brecht.fac.item.custom.ModFlammableRotatedPillarBlock;
import com.brecht.fac.item.custom.TomatoPlantBlock;
import com.brecht.fac.world.feature.tree.GhostTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FantasyAndNature.MOD_ID);


    public static final RegistryObject<Block> GHOST_LOG = registerBlock("ghost_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2f)), ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> GHOST_WOOD = registerBlock("ghost_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)), ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> GHOST_PLANKS = registerBlock("ghost_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> GHOST_LEAVES = registerBlock("ghost_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> GHOST_SAPLING = registerBlock("ghost_sapling",
            () -> new SaplingBlock(new GhostTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.FAC_TAB);

    public static final RegistryObject<Block> LEMON_BLOCK = registerBlock("lemon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CACTUS).strength(2f)), ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f)), ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> LEMON_STAIRS = registerBlock("lemon_stairs",
            () -> new StairBlock(() -> ModBlocks.LEMON_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.CACTUS).strength(2f)),
            ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> LEMON_SLAB = registerBlock("lemon_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.CACTUS).strength(2f)), ModCreativeModeTab.FAC_TAB);

    public static final RegistryObject<Block> PINK_ROSE = registerBlock("pink_rose",
            () -> new FlowerBlock(MobEffects.REGENERATION, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
            ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> POTTED_PINK_ROSE = BLOCKS.register("potted_pink_rose",
            () -> new FlowerPotBlock(null, ModBlocks.PINK_ROSE,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion())
    );
    public static final RegistryObject<Block> CHRISTMAS_WINDOW = registerBlock("christmas_window",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()),
            ModCreativeModeTab.FAC_TAB);
    public static final RegistryObject<Block> TOMATO_PLANT = BLOCKS.register("tomato_plant",
            () -> new TomatoPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
