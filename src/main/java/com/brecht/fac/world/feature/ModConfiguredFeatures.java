package com.brecht.fac.world.feature;
import com.brecht.fac.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GHOST_TREE =
            FeatureUtils.register("ghost", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.GHOST_LOG.get()),
                    new StraightTrunkPlacer(7, 9, 3),
                    BlockStateProvider.simple(ModBlocks.GHOST_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> GHOST_CHECKED = PlacementUtils.register("ghost_checked", GHOST_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.GHOST_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> GHOST_SPAWN =
            FeatureUtils.register("ghost_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(GHOST_CHECKED,
                            0.05F)), GHOST_CHECKED));

    //SAKURA
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SAKURA_TREE =
            FeatureUtils.register("sakura", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.SAKURA_LOG.get()),
                    new StraightTrunkPlacer(4, 5, 3),
                    BlockStateProvider.simple(ModBlocks.SAKURA_LEAVES.get()),
                    new AcaciaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> SAKURA_CHECKED = PlacementUtils.register("sakura_checked", SAKURA_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.SAKURA_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SAKURA_SPAWN =
            FeatureUtils.register("sakura_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(SAKURA_CHECKED,
                            0.2F)), SAKURA_CHECKED));




    //FLOWERS
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PINK_ROSE =
            FeatureUtils.register("flower_pink_rose", Feature.FLOWER,
                    new RandomPatchConfiguration(16,6,2,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINK_ROSE.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ORANGE_TULIP =
            FeatureUtils.register("flower_orange_tulip", Feature.FLOWER,
                    new RandomPatchConfiguration(16,6,2,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ORANGE_TULIP.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ZINNIA_PINK =
            FeatureUtils.register("flower_zinnia_pink", Feature.FLOWER,
                    new RandomPatchConfiguration(12,7,3,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ZINNIA_FLOWER_PINK.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ZINNIA_YELLOW =
            FeatureUtils.register("flower_zinnia_yellow", Feature.FLOWER,
                    new RandomPatchConfiguration(15,8,3,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ZINNIA_FLOWER_YELLOW.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ZINNIA_LPURPLE =
            FeatureUtils.register("flower_zinnia_lpurple", Feature.FLOWER,
                    new RandomPatchConfiguration(15,8,3,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ZINNIA_FLOWER_LPURPLE.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ZINNIA_GRAY =
            FeatureUtils.register("flower_zinnia_gray", Feature.FLOWER,
                    new RandomPatchConfiguration(18,4,3,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ZINNIA_FLOWER_GRAY.get())))));



    //ORES

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_GHOST_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GHOST_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_GHOST_ORE.get().defaultBlockState())
    );
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> GHOST_ORE = FeatureUtils.register("ghost_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_GHOST_ORES, 9));




}


