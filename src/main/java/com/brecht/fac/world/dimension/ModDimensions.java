package com.brecht.fac.world.dimension;

import com.brecht.fac.FantasyAndNature;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

import java.awt.*;

public class ModDimensions {
    public static final ResourceKey<Level> SIDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(FantasyAndNature.MOD_ID, "sidim"));
    public static final ResourceKey<DimensionType> SIDIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, SIDIM_KEY.getRegistryName());

    public static void register() {
        System.out.println("Registering ModDimensions for " + FantasyAndNature.MOD_ID);
    }
}
