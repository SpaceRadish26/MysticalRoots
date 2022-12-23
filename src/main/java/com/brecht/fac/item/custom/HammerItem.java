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

import net.minecraft.world.item.Item.Properties;

public class HammerItem extends PickaxeItem {
    public HammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }


    /*private void helpBlockDestroy(BlockPos pPos, Level plevel, BlockState pState, LivingEntity pEntityLiving) {
        if (!plevel.isClientSide()) {
            for (int i = -1; i < 2; i++) {
                plevel.destroyBlock(pPos.relative(Direction.Axis.Y, i), true, null);
                for (int j = -1; j < 2; i++) {
                    BlockPos pos2 = pPos.relative(Direction.Axis.Y, i);

                    plevel.destroyBlock(pos2.relative(Direction.Axis.X, j), true, null);

                }
            }


        }

    }*/



    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide()) {
            if (pEntityLiving instanceof Player && pStack.isCorrectToolForDrops(pState)) {
                for (int i = -1; i < 2; i++) {
                    pLevel.destroyBlock(pPos.relative(Direction.Axis.Y, i), true, null);
                    for (int j = -1; j < 2; j++) {
                        BlockPos pos2 = pPos.relative(Direction.Axis.Y, i);

                        pLevel.destroyBlock(pos2.relative(Direction.Axis.X, j), true, null);

                    }
            }
            return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
        }}
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
        }}


    /*BlockPos[] positions = {pPos.above(), pPos.below(), pPos.east(), pPos.west(), pPos.above().east(), pPos.above().west()
            , pPos.below().east(), pPos.below().west()};

                for (int i = 0; i < positions.length; i++) {
        //pLevel.getBlockState(n).getBlock().playerDestroy(pLevel, (Player) pEntityLiving, n, pLevel.getBlockState(n),null,pStack);

        pLevel.destroyBlock(positions[i], true, null);
        }*/
