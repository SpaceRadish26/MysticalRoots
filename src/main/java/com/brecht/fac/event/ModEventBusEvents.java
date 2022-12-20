package com.brecht.fac.event;


import com.brecht.fac.MysticalRoots;
import com.brecht.fac.entity.ModEntityTypes;
import com.brecht.fac.entity.mobs.GhostEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber (modid = MysticalRoots.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void RegisterModifierSerializer(@Nonnull final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, helper -> {
            //helper.register(); hier moet de datagen en global loot tutorial komen met argumenten omgedraaid, zie update tutorial



        });
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {

        });

    }

    //@SubscribeEvent
    //public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {}

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.GHOST.get(), GhostEntity.setAttributes());
    }

}
