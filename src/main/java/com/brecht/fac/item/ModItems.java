package com.brecht.fac.item;

import com.brecht.fac.FantasyAndCombat;
import com.brecht.fac.block.custom.FireWoodItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.system.CallbackI;

public class ModItems {
    public static final DeferredRegister<Item>  ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FantasyAndCombat.MOD_ID);


    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).food(ModFoods.BREAD_SLICE)));

    public static final RegistryObject<Item> FIREWOOD = ITEMS.register("firewood", () -> new FireWoodItem(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static final RegistryObject<Item> LEMON_SWORD = ITEMS.register("lemon_sword", () -> new SwordItem(ModTiers.LEMON,2,3f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
