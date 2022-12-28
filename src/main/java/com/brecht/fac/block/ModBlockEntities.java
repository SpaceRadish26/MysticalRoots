package com.brecht.fac.block;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.block.entity.DruidAltarEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MysticalRoots.MOD_ID);

    public static final RegistryObject<BlockEntityType<DruidAltarEntity>> DRUID_ALTAR_ENTITY =
            BLOCK_ENTITIES.register("druid_altar_entity", () ->
                    BlockEntityType.Builder.of(DruidAltarEntity::new, ModBlocks.DRUID_ALTAR.get()).build(null));








    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
