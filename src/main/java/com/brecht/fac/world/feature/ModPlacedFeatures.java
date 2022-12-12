package com.brecht.fac.world.feature;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.BiomeDictionary;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> GHOST_PLACED = PlacementUtils.register("ghost_placed",
            ModConfiguredFeatures.GHOST_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(0, 0.2f, 1)));

    public static final Holder<PlacedFeature> SAKURA_PLACED = PlacementUtils.register("sakura_placed",
            ModConfiguredFeatures.SAKURA_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.2f, 1)));

    public static final Holder<PlacedFeature> PINK_ROSE_PLACED = PlacementUtils.register("pink_rose_placed",
            ModConfiguredFeatures.PINK_ROSE, RarityFilter.onAverageOnceEvery(25),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> GHOST_ORE_PLACED = PlacementUtils.register("ghost_ore_placed",
            ModConfiguredFeatures.GHOST_ORE, ModOrePlacement.rareOrePlacement(5,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));


}