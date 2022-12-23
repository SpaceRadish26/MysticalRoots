package com.brecht.fac.networking.packet;

import com.brecht.fac.entity.ModEntityTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ExampleC2SPacktet {
    public ExampleC2SPacktet() {

    }
    public ExampleC2SPacktet(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();


            EntityType.WOLF.spawn(level, null,player,player.blockPosition(), MobSpawnType.BREEDING, true, true);

        });
    return true;
    }

}
