package com.brecht.fac.entity;

import com.brecht.fac.FantasyAndNature;
import com.brecht.fac.entity.projectile.ExplosiveArrowEntity;
import com.brecht.fac.entity.projectile.LightningballEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, FantasyAndNature.MOD_ID);

    public static final RegistryObject<EntityType<ExplosiveArrowEntity>> EXPLOSIVE_ARROW = ENTITY_TYPES.register("explosive_arrow",
            () -> EntityType.Builder.of((EntityType.EntityFactory<ExplosiveArrowEntity>) ExplosiveArrowEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("explosive_arrow"));
    public static final RegistryObject<EntityType<LightningballEntity>> LIGHTNING_BALL = ENTITY_TYPES.register("lightning_ball",
            () -> EntityType.Builder.of((EntityType.EntityFactory<LightningballEntity>) LightningballEntity::new, MobCategory.MISC).sized(0.2F, 0.2F).build("lightning_ball"));


    public static void register(IEventBus eventbus) {
        ENTITY_TYPES.register(eventbus);
    }


}