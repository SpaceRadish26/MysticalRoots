package com.brecht.fac.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BREAD_SLICE = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 10, 1), 1.0F).alwaysEat().build();
    public static final FoodProperties BANANA = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).alwaysEat().build();
}
