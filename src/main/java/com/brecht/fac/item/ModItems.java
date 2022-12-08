package com.brecht.fac.item;

import com.brecht.fac.FantasyAndCombat;
import com.brecht.fac.block.custom.FireWoodItem;
import com.brecht.fac.item.custom.ChopperItem;
import com.brecht.fac.item.custom.ManMemeCoinItem;
import com.brecht.fac.item.custom.SaberItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FantasyAndCombat.MOD_ID);


    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).food(ModFoods.BREAD_SLICE)));

    public static final RegistryObject<Item> FIREWOOD = ITEMS.register("firewood", () -> new FireWoodItem(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static final RegistryObject<Item> CHOPPER = ITEMS.register("chopper", () -> new ChopperItem(ModTiers.LEMON, 2, 3f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).durability(400)
    ));
    public static final RegistryObject<Item> SABER = ITEMS.register("saber", () -> new SaberItem(Tiers.IRON, 3, 4f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> LEMON_HELMET = ITEMS.register("lemon_helmet", () -> new ArmorItem(ModArmorMaterials.LEMON, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static final RegistryObject<Item> LEMON_CHEST = ITEMS.register("lemon_chest", () -> new ArmorItem(ModArmorMaterials.LEMON, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> LEMON_LEGGINGS = ITEMS.register("lemon_leggings", () -> new ArmorItem(ModArmorMaterials.LEMON, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static final RegistryObject<Item> LEMON_BOOTS = ITEMS.register("lemon_boots", () -> new ArmorItem(ModArmorMaterials.LEMON, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));


    public static final RegistryObject<Item> MAN_MEME_COIN = ITEMS.register("man_meme_coin", () -> new ManMemeCoinItem(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
