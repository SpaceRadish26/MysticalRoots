package com.brecht.fac.block;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.block.custom.*;
import com.brecht.fac.item.ModCreativeModeTab;
import com.brecht.fac.item.ModItems;
import com.brecht.fac.world.feature.tree.GhostTreeGrower;
import com.brecht.fac.world.feature.tree.SakuraTreeGrower;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MysticalRoots.MOD_ID);



    //WOOD
    public static final RegistryObject<Block> GHOST_LOG = registerBlock("ghost_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(0.4f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> GHOST_WOOD = registerBlock("ghost_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(0.4f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> GHOST_PLANKS = registerBlock("ghost_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> GHOST_LEAVES = registerBlock("ghost_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> GHOST_SAPLING = registerBlock("ghost_sapling",
            () -> new SaplingBlock(new GhostTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> SAKURA_PLANKS = registerBlock("sakura_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> SAKURA_LOG = registerBlock("sakura_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(0.5f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> SAKURA_WOOD = registerBlock("sakura_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(0.5f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> SAKURA_LEAVES = registerBlock("sakura_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> SAKURA_SAPLING = registerBlock("sakura_sapling",
            () -> new SaplingBlock(new SakuraTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.MR_TAB);

    //ORES
    public static final RegistryObject<Block> GHOST_ORE = registerBlock("ghost_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> DEEPSLATE_GHOST_ORE = registerBlock("deepslate_ghost_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).strength(1.5f).requiresCorrectToolForDrops()), ModCreativeModeTab.MR_TAB);

    //ALTARS
    public static final RegistryObject<Block> DRUID_ALTAR = BLOCKS.register("druid_altar",
            () -> new DruidAltarBlock(BlockBehaviour.Properties.of(Material.WOOD)
            .noOcclusion()));

    //BUILDING BLOCKS
    public static final RegistryObject<Block> GHOST_LAMP = registerBlock("ghost_lamp", () -> new GhostLampBlock(BlockBehaviour
            .Properties.of(Material.GLASS).strength(1f).lightLevel(value -> 15)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> LEMON_BLOCK = registerBlock("lemon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CACTUS).strength(0.8f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(0.9f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> LEMON_STAIRS = registerBlock("lemon_stairs",
            () -> new StairBlock(() -> ModBlocks.LEMON_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.CACTUS).strength(0.6f)),
            ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> LEMON_SLAB = registerBlock("lemon_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.CACTUS).strength(0.4f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> GHOST_SLAB = registerBlock("ghost_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.4f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> SAKURA_SLAB = registerBlock("sakura_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.CACTUS).strength(0.4f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> GHOST_STAIRS = registerBlock("ghost_stairs",
            () -> new StairBlock(() -> ModBlocks.GHOST_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD).strength(0.4f)),
            ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> SAKURA_STAIRS = registerBlock("sakura_stairs",
            () -> new StairBlock(() -> ModBlocks.SAKURA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD).strength(0.6f)),
            ModCreativeModeTab.MR_TAB);




    //FLOWERS
    public static final RegistryObject<Block> PINK_ROSE = registerBlock("pink_rose",
            () -> new FlowerBlock(MobEffects.REGENERATION, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
            ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> POTTED_PINK_ROSE = BLOCKS.register("potted_pink_rose",
            () -> new FlowerPotBlock(null, ModBlocks.PINK_ROSE,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion())
    );
    public static final RegistryObject<Block> ORANGE_TULIP = registerBlock("orange_tulip",
            () -> new FlowerBlock(MobEffects.REGENERATION, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
            ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> POTTED_ORANGE_TULIP = BLOCKS.register("potted_orange_tulip",
            () -> new FlowerPotBlock(null, ModBlocks.ORANGE_TULIP,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion())
    );


    //GLASS
    public static final RegistryObject<Block> CHRISTMAS_WINDOW = registerBlock("christmas_window",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()),
            ModCreativeModeTab.MR_TAB);



    //PLANTS
    public static final RegistryObject<Block> TOMATO_PLANT = BLOCKS.register("tomato_plant",
            () -> new TomatoPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    public static final RegistryObject<Block> GRAPES_PLANT = BLOCKS.register("grapes_plant",
            () -> new GrapesPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    //DIRT STUFF
    public static final RegistryObject<Block> GHOST_GRASS_BLOCK = registerBlock("ghost_grass_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(0.8f)), ModCreativeModeTab.MR_TAB);
    public static final RegistryObject<Block> GHOST_GRASS = registerBlock("ghost_grass",
            () -> new GrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).strength(0.1f)), ModCreativeModeTab.MR_TAB);


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
