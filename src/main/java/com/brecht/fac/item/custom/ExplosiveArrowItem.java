package com.brecht.fac.item.custom;

import com.brecht.fac.entity.ModEntityTypes;
import com.brecht.fac.entity.projectile.ExplosiveArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ExplosiveArrowItem extends ArrowItem {

    public ExplosiveArrowItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new ExplosiveArrowEntity(ModEntityTypes.EXPLOSIVE_ARROW.get(), pShooter,pLevel);
    }
}
