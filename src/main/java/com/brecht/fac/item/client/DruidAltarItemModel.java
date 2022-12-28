package com.brecht.fac.item.client;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.item.custom.DruidAltarItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DruidAltarItemModel extends AnimatedGeoModel<DruidAltarItem> {
    @Override
    public ResourceLocation getModelResource(DruidAltarItem object) {
        return new ResourceLocation(MysticalRoots.MOD_ID, "geo/druid_altar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DruidAltarItem object) {
        return new ResourceLocation(MysticalRoots.MOD_ID, "textures/block/altars/druid_altar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DruidAltarItem animatable) {
        return new ResourceLocation(MysticalRoots.MOD_ID, "animations/druid_altar.animation.json");
    }
}
