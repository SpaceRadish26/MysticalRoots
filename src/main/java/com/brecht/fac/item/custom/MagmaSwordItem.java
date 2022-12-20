package com.brecht.fac.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import net.minecraft.world.item.Item.Properties;

public class MagmaSwordItem extends SwordItem {
    public MagmaSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {
        ItemStack sword = player.getItemInHand(pUsedHand);
        if (!level.isClientSide()) {
            if (!sword.isEnchanted()) {
                sword.enchant(Enchantments.FIRE_ASPECT, 2);
            } else {
                sword.getEnchantmentTags().clear();
            }

        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, sword);
    }
    /*@Override
    public InteractionResult useOn(UseOnContext pContext) {
        ItemStack handsword = pContext.getItemInHand();
        if (!pContext.getLevel().isClientSide()) {
            if (!handsword.isEnchanted()) {
                handsword.enchant(Enchantments.FIRE_ASPECT, 2);
            }
            else {
                handsword.getEnchantmentTags().clear();
            }
        }
        return super.useOn(pContext);
    }*/

   /* @Override
    public void onCraftedBy(ItemStack pStack, Level pLevel, Player pPlayer) {
        if (!pLevel.isClientSide()) {
            pStack.enchant(Enchantments.FIRE_ASPECT, 1);

        }
        super.onCraftedBy(pStack, pLevel, pPlayer);
    }*/
}
