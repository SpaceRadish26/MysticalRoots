package com.brecht.fac.notworking;


import com.brecht.fac.MysticalRoots;
import com.brecht.fac.entity.blocks.TileentityTeleporter;
import com.brecht.fac.item.ModCreativeModeTab;

import com.brecht.fac.world.dimension.ModDimensions;
import com.brecht.fac.world.dimension.MyrthiaDimensionTeleporter;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Objects;


public class MyrthiaPortalBlock extends Block implements EntityBlock {
    public MyrthiaPortalBlock() {
        super(Properties.of(Material.WOOD).strength(3F).sound(SoundType.WOOD));
    }


    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player instanceof ServerPlayer) {
            transferPlayer((ServerPlayer) player, pos, world);
        }
        return InteractionResult.SUCCESS;
    }

    public boolean transferPlayer(ServerPlayer player, BlockPos pos, Level level) {
        if (player.getVehicle() != null || player.isVehicle()) {
            return false;
        }

        if (level.dimension().equals(MysticalRoots.MYRTHIA)) {
            player.changeDimension(Objects.requireNonNull(level.getServer()).overworld(), new MyrthiaDimensionTeleporter(pos));
        } else if (level.dimension().equals(Level.OVERWORLD)) {
            ServerLevel teleportWorld = player.server.getLevel(MysticalRoots.MYRTHIA);
            if (teleportWorld == null) {
                return false;
            }
            player.changeDimension(teleportWorld, new MyrthiaDimensionTeleporter(pos));
        } else {
            player.displayClientMessage(Component.literal("You cannot teleport to Myrthia from this dimension"), true);
        }

        return true;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileentityTeleporter(pos, state);
    }


}

