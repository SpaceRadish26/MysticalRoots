package com.brecht.fac;

import com.brecht.fac.block.ModBlockEntities;
import com.brecht.fac.block.ModBlocks;
import com.brecht.fac.client.render.mobs.ArchonOTVRenderer;
import com.brecht.fac.client.render.projectiles.ExplosiveArrowRenderer;
import com.brecht.fac.client.render.projectiles.LightningballRenderer;
import com.brecht.fac.effect.ModEffects;
import com.brecht.fac.client.render.mobs.GhostRenderer;
import com.brecht.fac.item.ModItems;
import com.brecht.fac.loot.ModLootModifiers;
import com.brecht.fac.painting.ModPaintings;
import com.brecht.fac.sound.ModSounds;
import com.brecht.fac.util.ModItemProperties;
import com.brecht.fac.world.biomemods.ModBiomeModifiers;
import com.brecht.fac.world.dimension.ModDimensions;
import com.brecht.fac.world.feature.ModPlacedFeatures;
import com.mojang.logging.LogUtils;
import com.brecht.fac.entity.ModEntityTypes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MysticalRoots.MOD_ID)
public class MysticalRoots {
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "fac";

    public MysticalRoots() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModSounds.register(eventBus);
        ModPaintings.register(eventBus);

        ModEffects.register(eventBus);
        ModDimensions.register();
        ModEntityTypes.register(eventBus);
        ModBiomeModifiers.register(eventBus);
        ModPlacedFeatures.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModLootModifiers.register(eventBus);

        eventBus.addListener(MRDynamicAssignment::onData);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetupEvent);

        GeckoLib.initialize();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetupEvent(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GHOST_GRASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_ORANGE_TULIP.get(), RenderType.cutout());
        EntityRenderers.register(ModEntityTypes.EXPLOSIVE_ARROW.get(), ExplosiveArrowRenderer::new);
        EntityRenderers.register(ModEntityTypes.LIGHTNING_BALL.get(), LightningballRenderer::new);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHRISTMAS_WINDOW.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOMATO_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAPES_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GHOST_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GHOST_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SAKURA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SAKURA_LEAVES.get(), RenderType.cutout());

        ModItemProperties.addCustomItemProperties();




        EntityRenderers.register(ModEntityTypes.GHOST.get(), GhostRenderer::new);
        EntityRenderers.register(ModEntityTypes.ARCHONOTV.get(), ArchonOTVRenderer::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityTypes.GHOST.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);


            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE );
        });
    }
}
















    /*
    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}*/
