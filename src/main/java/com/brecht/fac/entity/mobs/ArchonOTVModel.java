package com.brecht.fac.entity.mobs;

import com.brecht.fac.MysticalRoots;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArchonOTVModel extends AnimatedGeoModel<ArchonOTVEntity> {
    @Override
    public ResourceLocation getModelResource(ArchonOTVEntity object) {
        return new ResourceLocation(MysticalRoots.MOD_ID,"geo/archonotv.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArchonOTVEntity object) {
        return new ResourceLocation(MysticalRoots.MOD_ID,"textures/entity/archonotv/archonotv.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ArchonOTVEntity animatable) {
        return new ResourceLocation(MysticalRoots.MOD_ID,"animations/archonotv.animation.json");
    }
}
