package com.brecht.fac.entity.blocks;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.entity.ModEntityBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TileentityTeleporter extends BlockEntity {
    public TileentityTeleporter(BlockPos pPos, BlockState pBlockState) {
        super(ModEntityBlocks.TELEPORTER_TILE_ENTITY.get(), pPos, pBlockState);
    }
}
