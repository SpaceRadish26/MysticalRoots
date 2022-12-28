package com.brecht.fac.client.render.mobs;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.entity.mobs.ArchonOTVEntity;
import com.brecht.fac.entity.mobs.ArchonOTVModel;
import com.brecht.fac.entity.mobs.GhostEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ArchonOTVRenderer extends GeoEntityRenderer<ArchonOTVEntity> {
    public ArchonOTVRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ArchonOTVModel());

    }

    @Override
    public ResourceLocation getTextureLocation(ArchonOTVEntity animatable) {
        return new ResourceLocation(MysticalRoots.MOD_ID, "textures/entity/archonotv/archonotv.png");
    }

    @Override
    public RenderType getRenderType(ArchonOTVEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer,
                                    int packedLight, ResourceLocation texture) {
                                    poseStack.scale(1F,1F,1F);
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
