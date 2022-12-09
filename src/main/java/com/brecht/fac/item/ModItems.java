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
    public static final RegistryObject<Item> NUT = ITEMS.register("nut", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).food(ModFoods.BREAD_SLICE)));

    public static final RegistryObject<Item> FIREWOOD = ITEMS.register("firewood", () -> new FireWoodItem(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static final RegistryObject<Item> CHOPPER = ITEMS.register("chopper", () -> new ChopperItem(ModTiers.LEMON, 2, 3f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).durability(400)
    ));
    public static final RegistryObject<Item> SABER = ITEMS.register("saber", () -> new SaberItem(Tiers.IRON, 3, 4f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> SQUIRREL_HELMET = ITEMS.register("squirrel_helmet", () -> new ArmorItem(ModArmorMaterials.SQUIRREL, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> SQUIRREL_CHEST = ITEMS.register("squirrel_chest", () -> new ArmorItem(ModArmorMaterials.SQUIRREL, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> SQUIRREL_LEGGINGS = ITEMS.register("squirrel_leggings", () -> new ArmorItem(ModArmorMaterials.SQUIRREL, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> SQUIRREL_BOOTS = ITEMS.register("squirrel_boots", () -> new ArmorItem(ModArmorMaterials.SQUIRREL, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> MAN_MEME_COIN = ITEMS.register("man_meme_coin", () -> new ManMemeCoinItem(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
