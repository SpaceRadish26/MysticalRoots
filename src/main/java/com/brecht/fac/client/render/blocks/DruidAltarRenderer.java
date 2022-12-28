package com.brecht.fac.client.render.blocks;

import com.brecht.fac.block.entity.DruidAltarEntity;
import com.brecht.fac.block.entity.DruidAltarModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import javax.annotation.Nullable;

public class DruidAltarRenderer extends GeoBlockRenderer<DruidAltarEntity> {
    public DruidAltarRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(rendererDispatcherIn, new DruidAltarModel());
    }

    @Override
    public RenderType getRenderType(DruidAltarEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                    int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
