package com.brecht.fac.painting;

import com.brecht.fac.FantasyAndTheMiddleAges;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, FantasyAndTheMiddleAges.MOD_ID);

    public static final RegistryObject<Motive> CLOUDY_DAY =
            PAINTING_MOTIVES.register("cloudy_day", () -> new Motive(16,16));




    public static void register(IEventBus eventBus) {
        PAINTING_MOTIVES.register(eventBus);
    }

}
