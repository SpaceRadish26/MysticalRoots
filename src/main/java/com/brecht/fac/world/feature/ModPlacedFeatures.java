package com.brecht.fac.world.feature;

import com.brecht.fac.MysticalRoots;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MysticalRoots.MOD_ID);
    public static final RegistryObject<PlacedFeature> GHOST_PLACED = PLACED_FEATURES.register("ghost_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
            ModConfiguredFeatures.GHOST_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(7, 0.2f, 1))));

    public static final RegistryObject<PlacedFeature> SAKURA_PLACED = PLACED_FEATURES.register("sakura_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
            ModConfiguredFeatures.SAKURA_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(4, 0.2f, 2))));

    public static final RegistryObject<PlacedFeature> PINK_ROSE_PLACED = PLACED_FEATURES.register("pink_rose_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
            ModConfiguredFeatures.PINK_ROSE, List.of(RarityFilter.onAverageOnceEvery(10),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> ORANGE_TULIP_PLACED = PLACED_FEATURES.register("orange_tulip_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
            ModConfiguredFeatures.ORANGE_TULIP, List.of(RarityFilter.onAverageOnceEvery(15),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> ZINNIA_PINK_PLACED = PLACED_FEATURES.register("zinnia_pink_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.ZINNIA_PINK, List.of(RarityFilter.onAverageOnceEvery(15),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> ZINNIA_YELLOW_PLACED = PLACED_FEATURES.register("zinnia_yellow_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.ZINNIA_YELLOW, List.of(RarityFilter.onAverageOnceEvery(15),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> ZINNIA_LPURPLE_PLACED = PLACED_FEATURES.register("zinnia_lpurple_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.ZINNIA_LPURPLE, List.of(RarityFilter.onAverageOnceEvery(15),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> ZINNIA_GRAY_PLACED = PLACED_FEATURES.register("zinnia_gray_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.ZINNIA_GRAY, List.of(RarityFilter.onAverageOnceEvery(15),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    //ORES

    public static final RegistryObject<PlacedFeature> GHOST_ORE_PLACED = PLACED_FEATURES.register("ghost_ore_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
            ModConfiguredFeatures.GHOST_ORE, ModOrePlacement.commonOrePlacement(7,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));



    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}