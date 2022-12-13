package com.brecht.fac.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HammerItem extends PickaxeItem {
    public HammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }




    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide()) {
            if (pEntityLiving instanceof Player && pStack.isCorrectToolForDrops(pState)) {
                BlockPos[] positions = {pPos.above(), pPos.below(), pPos.east(), pPos.west(), pPos.above().east(), pPos.above().west()
                        , pPos.below().east(), pPos.below().west()};

                for (int i = 0; i < positions.length; i++) {
                        //pLevel.getBlockState(n).getBlock().playerDestroy(pLevel, (Player) pEntityLiving, n, pLevel.getBlockState(n),null,pStack);

                    pLevel.destroyBlock(positions[i], true, null);
                }

            }
            return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
        }
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
    }}

