package com.brecht.fac.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.world.item.Item.Properties;

public class ManMemeCoinItem extends Item {
    public ManMemeCoinItem(Properties pProperties) {
        super(pProperties);
    }

    //@Override
    public InteractionResult onUse(UseOnContext pContext, Player player) {
        Random rand = new Random();
        int randomInt = rand.nextInt(2);
        if (randomInt == 1) {
            player.addEffect(new MobEffectInstance((MobEffects.HERO_OF_THE_VILLAGE), 300));
        }
        else {
            player.addEffect(new MobEffectInstance((MobEffects.BAD_OMEN),300, 4));
        }

        return super.useOn(pContext);
    }
}



