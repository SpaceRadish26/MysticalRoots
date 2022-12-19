package com.brecht.fac.event;


import com.brecht.fac.MysticalRoots;
import com.brecht.fac.entity.ModEntityTypes;
import com.brecht.fac.entity.mobs.GhostEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber (modid = MysticalRoots.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void RegisterModifierSerializer(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll();
    }

    //@SubscribeEvent
    //public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {}

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.GHOST.get(), GhostEntity.setAttributes());
    }

}
