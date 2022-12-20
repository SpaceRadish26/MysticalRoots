package com.brecht.fac.painting;

import com.brecht.fac.MysticalRoots;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, MysticalRoots.MOD_ID);

    public static final RegistryObject<PaintingVariant> CLOUDY_DAY =
            PAINTING_MOTIVES.register("cloudy_day", () -> new PaintingVariant(16,16));




    public static void register(IEventBus eventBus) {
        PAINTING_MOTIVES.register(eventBus);
    }

}
