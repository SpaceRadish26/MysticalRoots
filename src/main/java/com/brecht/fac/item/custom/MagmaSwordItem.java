package com.brecht.fac.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import net.minecraft.world.item.Item.Properties;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.literal("Press RMB to enchant/disenchant your sword.").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD));
        } else {
            pTooltipComponents.add(Component.literal("Press SHIFT to view info").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_RED));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
