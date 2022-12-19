package com.brecht.fac.entity.mobs;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.entity.mobs.GhostEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GhostModel extends AnimatedGeoModel<GhostEntity> {
    @Override
    public ResourceLocation getModelLocation(GhostEntity object) {
        return new ResourceLocation(MysticalRoots.MOD_ID,"geo/ghost.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GhostEntity object) {
        return new ResourceLocation(MysticalRoots.MOD_ID,"textures/entity/ghost/ghost.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GhostEntity animatable) {
        return new ResourceLocation(MysticalRoots.MOD_ID,"animations/ghost.animation.json");
    }
}
