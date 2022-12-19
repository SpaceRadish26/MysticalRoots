package com.brecht.fac.client.render;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.entity.projectile.LightningballEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LightningballRenderer extends EntityRenderer<LightningballEntity> {

    public static final ResourceLocation TEXTURE1 = new ResourceLocation(MysticalRoots.MOD_ID, "textures/entity/lightning_ball.png");
    public LightningballRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }


    @Override
    public ResourceLocation getTextureLocation(LightningballEntity pEntity) {
        return TEXTURE1;
    }
}
