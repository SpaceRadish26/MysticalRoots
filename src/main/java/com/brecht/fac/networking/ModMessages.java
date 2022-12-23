package com.brecht.fac.networking;

import com.brecht.fac.MysticalRoots;
import com.brecht.fac.networking.packet.ExampleC2SPacktet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;
    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(MysticalRoots.MOD_ID, "messages")).networkProtocolVersion(() -> "1.0").clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true).simpleChannel();

        INSTANCE = net;


        net.messageBuilder(ExampleC2SPacktet.class, id(), NetworkDirection.PLAY_TO_SERVER).decoder(ExampleC2SPacktet::new).encoder(ExampleC2SPacktet::toBytes)
                .consumerMainThread(ExampleC2SPacktet::handle).add();


    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
