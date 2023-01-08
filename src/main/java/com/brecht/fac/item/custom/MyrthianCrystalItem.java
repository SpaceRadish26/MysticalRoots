package com.brecht.fac.item.custom;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.world.dimension.MyrthiaDimensionTeleporter;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class MyrthianCrystalItem extends Item {
    public MyrthianCrystalItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand handIn) {
        ItemStack heldStack = player.getItemInHand(handIn);
        if (!level.isClientSide()) {
        if (player.getVehicle() != null || player.isVehicle()) {
            return new InteractionResultHolder<>(InteractionResult.FAIL, heldStack);
        }

        if (level.dimension().equals(MysticalRoots.MYRTHIA)) {
            if (!player.isCreative()) heldStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
            player.changeDimension(level.getServer().overworld(), new MyrthiaDimensionTeleporter());
        } else if (level.dimension().equals(Level.OVERWORLD)) {
            ServerLevel teleportWorld = (level.getServer().getLevel(MysticalRoots.MYRTHIA));

            if (teleportWorld == null) {
                return new InteractionResultHolder<>(InteractionResult.FAIL, heldStack);
            }
            if (!player.isCreative()) heldStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
            player.changeDimension(teleportWorld, new MyrthiaDimensionTeleporter());
        } else {
            player.displayClientMessage(Component.literal("You cannot teleport to Myrthia from this dimension"), true);
        }
    }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, heldStack);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.literal("Press RMB to teleport to myrthia when in the overworld.").withStyle(ChatFormatting.DARK_GREEN));
        } else {
            pTooltipComponents.add(Component.literal("Press SHIFT to view more info").withStyle(ChatFormatting.DARK_RED));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
