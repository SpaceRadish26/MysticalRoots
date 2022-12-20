package com.brecht.fac.entity;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.entity.mobs.GhostEntity;
import com.brecht.fac.entity.projectile.ExplosiveArrowEntity;
import com.brecht.fac.entity.projectile.LightningballEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MysticalRoots.MOD_ID);

    public static final RegistryObject<EntityType<ExplosiveArrowEntity>> EXPLOSIVE_ARROW = ENTITY_TYPES.register("explosive_arrow",
            () -> EntityType.Builder.of((EntityType.EntityFactory<ExplosiveArrowEntity>) ExplosiveArrowEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("explosive_arrow"));
    public static final RegistryObject<EntityType<LightningballEntity>> LIGHTNING_BALL = ENTITY_TYPES.register("lightning_ball",
            () -> EntityType.Builder.of((EntityType.EntityFactory<LightningballEntity>) LightningballEntity::new, MobCategory.MISC).sized(0.2F, 0.2F).build("lightning_ball"));

    public static final RegistryObject<EntityType<GhostEntity>> GHOST =
            ENTITY_TYPES.register("ghost",
                    () -> EntityType.Builder.of(GhostEntity::new, MobCategory.MONSTER)
                            .sized(1.5f,2f)
                            .build(new ResourceLocation(MysticalRoots.MOD_ID,"ghost").toString()));


    public static void register(IEventBus eventbus) {
        ENTITY_TYPES.register(eventbus);
    }


}
