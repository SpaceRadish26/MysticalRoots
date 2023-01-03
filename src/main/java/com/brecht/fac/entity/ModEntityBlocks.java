package com.brecht.fac.entity;

import com.brecht.fac.MysticalRoots;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityBlocks {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MysticalRoots.MOD_ID);

    //public static final RegistryObject<BlockEntityType<TileentityTeleporter>> TELEPORTER_TILE_ENTITY = BLOCK_ENTITY_REGISTER.register("teleporter", () ->
            //BlockEntityType.Builder.of(TileentityTeleporter::new, ModBlocks.MYRTHIA_PORTAL.get()).build(null));

    public static void register(IEventBus eventbus) {
        BLOCK_ENTITY_REGISTER.register(eventbus);
    }
}
