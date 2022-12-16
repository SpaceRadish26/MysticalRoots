package com.brecht.fac.client.render;

import com.brecht.fac.FantasyAndNature;
import com.brecht.fac.entity.projectile.ExplosiveArrowEntity;
import com.brecht.fac.entity.projectile.LightningballEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.DragonFireballRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LightningballRenderer extends EntityRenderer<LightningballEntity> {

    public static final ResourceLocation TEXTURE1 = new ResourceLocation(FantasyAndNature.MOD_ID, "textures/entity/lightning_ball.png");
    public LightningballRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }


    @Override
    public ResourceLocation getTextureLocation(LightningballEntity pEntity) {
        return TEXTURE1;
    }
}
