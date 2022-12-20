package com.brecht.fac.world.dimension;

import com.brecht.fac.MysticalRoots;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> SIDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(MysticalRoots.MOD_ID, "sidim"));
    public static final ResourceKey<DimensionType> SIDIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(MysticalRoots.MOD_ID, "sidim"));

    public static void register() {
        System.out.println("Registering ModDimensions for " + MysticalRoots.MOD_ID);
    }
}
