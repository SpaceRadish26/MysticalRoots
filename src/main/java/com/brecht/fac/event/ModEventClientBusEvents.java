package com.brecht.fac.event;


import com.brecht.fac.MysticalRoots;
import com.brecht.fac.block.ModBlockEntities;
import com.brecht.fac.client.render.blocks.DruidAltarRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MysticalRoots.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.DRUID_ALTAR_ENTITY.get(), DruidAltarRenderer::new);
    }
}
