package com.brecht.fac.client.render.projectiles;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.entity.projectile.ExplosiveArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ExplosiveArrowRenderer extends ArrowRenderer<ExplosiveArrowEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(MysticalRoots.MOD_ID, "textures/entity/explosive_arrow.png");

    public ExplosiveArrowRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(ExplosiveArrowEntity pEntity) {
        return TEXTURE;
    }

    public ResourceLocation getTextureResource(ExplosiveArrowEntity arrow) {
        return TEXTURE;
    }
}
