package com.brecht.fac.item;

import com.brecht.fac.FantasyAndNature;
import com.brecht.fac.block.ModBlocks;
import com.brecht.fac.block.custom.FireWoodItem;
import com.brecht.fac.item.custom.ChopperItem;
//import com.brecht.fac.item.custom.ManMemeCoinItem;
import com.brecht.fac.item.custom.HammerItem;
import com.brecht.fac.item.custom.ModArmorItem;
import com.brecht.fac.item.custom.SaberItem;
import com.brecht.fac.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FantasyAndNature.MOD_ID);

    //ITEMS
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> NUT = ITEMS.register("nut",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static final RegistryObject<Item> GHOST_DUST = ITEMS.register("ghost_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static final RegistryObject<Item> GHOST_INGOT = ITEMS.register("ghost_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static final RegistryObject<Item> GFH_MUSIC_DISC = ITEMS.register("gfh_music_disc",
            () -> new RecordItem(4, ModSounds.GUNS_FOR_HIRE, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).stacksTo(1)));
    public static final RegistryObject<Item> FOREST_ESSENCE = ITEMS.register("forest_essence",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    //TOOLS

    public static final RegistryObject<Item> GHOST_PICKAXE = ITEMS.register("ghost_pickaxe", () -> new PickaxeItem(ModTiers.GHOST, -4, 0f,
            new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new HammerItem(Tiers.DIAMOND, 0, -2.8f,
            new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));




    //FOOD
    public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).food(ModFoods.BREAD_SLICE)));

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).food(ModFoods.BANANA)));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).food(ModFoods.TOMATO)));
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).food(ModFoods.GRAPES)));
    public static final RegistryObject<Item> WINE = ITEMS.register("wine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).food(ModFoods.WINE)));




    //SEEDS
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_PLANT.get(), new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));

    public static final RegistryObject<Item> GRAPES_SEEDS = ITEMS.register("grapes_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GRAPES_PLANT.get(), new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));







    //FUEL
    public static final RegistryObject<Item> FIREWOOD = ITEMS.register("firewood",
            () -> new FireWoodItem(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));





    //WEAPONS
    public static final RegistryObject<Item> CHOPPER = ITEMS.register("chopper",
            () -> new ChopperItem(Tiers.STONE, 5, -2.9f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).durability(400)
    ));
    public static final RegistryObject<Item> SABER = ITEMS.register("saber",
            () -> new SaberItem(Tiers.IRON, 3, 0f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).durability(500)));
    public static final RegistryObject<Item> GHOST_BOW = ITEMS.register("ghost_bow",
            () -> new BowItem(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).durability(500)));

    public static final RegistryObject<Item> SLASHING_JACK = ITEMS.register("slashing_jack",
            () -> new SwordItem(Tiers.DIAMOND, 4, -2.2f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).durability(1200)));
    public static final RegistryObject<Item> FIRE_SWORD = ITEMS.register("fire_sword",
            () -> new SwordItem(Tiers.IRON, 4, -2.2f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).durability(700)));

    public static final RegistryObject<Item> BO_STAFF = ITEMS.register("bo_staff",
            () -> new SwordItem(Tiers.WOOD, 4, -2.8f, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB).durability(700)));

    //ARMOR
    public static final RegistryObject<Item> SQUIRREL_HELMET = ITEMS.register("squirrel_helmet", () -> new ModArmorItem(ModArmorMaterials.SQUIRREL, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> SQUIRREL_CHESTPLATE = ITEMS.register("squirrel_chestplate", () -> new ArmorItem(ModArmorMaterials.SQUIRREL, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> SQUIRREL_LEGGINGS = ITEMS.register("squirrel_leggings", () -> new ArmorItem(ModArmorMaterials.SQUIRREL, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> SQUIRREL_BOOTS = ITEMS.register("squirrel_boots", () -> new ArmorItem(ModArmorMaterials.SQUIRREL, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    //public static final RegistryObject<Item> MAN_MEME_COIN = ITEMS.register("man_meme_coin", () -> new ManMemeCoinItem(new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> FOREST_HELMET = ITEMS.register("forest_helmet", () -> new ModArmorItem(ModArmorMaterials.FOREST, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> FOREST_CHESTPLATE = ITEMS.register("forest_chestplate", () -> new ArmorItem(ModArmorMaterials.FOREST, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> FOREST_LEGGINGS = ITEMS.register("forest_leggings", () -> new ArmorItem(ModArmorMaterials.FOREST, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static final RegistryObject<Item> FOREST_BOOTS = ITEMS.register("forest_boots", () -> new ArmorItem(ModArmorMaterials.FOREST, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.FAC_TAB)));
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
