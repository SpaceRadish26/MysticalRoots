package com.brecht.fac.block.custom;

import com.brecht.fac.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TomatoPlantBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public TomatoPlantBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getMaxAge() {
        return 2;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.TOMATO_SEEDS.get();
    }
}
