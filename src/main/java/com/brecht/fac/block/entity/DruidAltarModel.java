package com.brecht.fac.block.entity;

import com.brecht.fac.MysticalRoots;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DruidAltarModel extends AnimatedGeoModel<DruidAltarEntity> {
    @Override
    public ResourceLocation getModelResource(DruidAltarEntity object) {
        return new ResourceLocation(MysticalRoots.MOD_ID, "geo/druid_altar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DruidAltarEntity object) {
        return new ResourceLocation(MysticalRoots.MOD_ID, "textures/block/altars/druid_altar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DruidAltarEntity animatable) {
        return new ResourceLocation(MysticalRoots.MOD_ID, "animations/animated_block.animation.json");
    }
}
