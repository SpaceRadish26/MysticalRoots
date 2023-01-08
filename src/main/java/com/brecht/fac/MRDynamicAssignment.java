package com.brecht.fac;

import com.brecht.fac.block.ModBlocks;
import com.brecht.fac.item.ModItems;
import com.mojang.datafixers.types.templates.Tag;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MRDynamicAssignment {
    public static void onData(GatherDataEvent event) {
        event.getGenerator().addProvider(true, new LootTable(event.getGenerator()));
        event.getGenerator().addProvider(true, new Tag(event.getGenerator(), MysticalRoots.MOD_ID, event.getExistingFileHelper()));

    }






    public static class Tag extends BlockTagsProvider {

        public Tag(DataGenerator pGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, modId, existingFileHelper);
        }

        @Override
        protected void addTags() {
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModBlocks.GHOST_GRASS_BLOCK.get());

            //super.addTags();
        }
    }
    public static class LootTable extends LootTableProvider {

        public LootTable(DataGenerator gen) {
            super(gen);
        }

        @Override
        protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, net.minecraft.world.level.storage.loot.LootTable.Builder>>>, LootContextParamSet>> getTables() {
            return Collections.singletonList(Pair.of(BlockLootTable::new, LootContextParamSets.BLOCK));
        }

        public static class BlockLootTable extends BlockLoot {

            @Override
            public void addTables() {

                dropSelf(ModBlocks.CHRISTMAS_WINDOW.get());
                dropSelf(ModBlocks.DRUID_ALTAR.get());
                dropSelf(ModBlocks.ZINNIA_FLOWER_LPURPLE.get());
                dropSelf(ModBlocks.ZINNIA_FLOWER_PINK.get());
                dropSelf(ModBlocks.ZINNIA_FLOWER_YELLOW.get());
                dropSelf(ModBlocks.ZINNIA_FLOWER_GRAY.get());
                dropSelf(ModBlocks.POTTED_ZINNIA_FLOWER_PINK.get());
                dropSelf(ModBlocks.POTTED_ZINNIA_FLOWER_YELLOW.get());
                dropSelf(ModBlocks.POTTED_ZINNIA_FLOWER_GRAY.get());
                dropSelf(ModBlocks.POTTED_ZINNIA_FLOWER_LPURPLE.get());
                dropPottedContents(ModBlocks.POTTED_ZINNIA_FLOWER_GRAY.get());
                dropPottedContents(ModBlocks.POTTED_ZINNIA_FLOWER_YELLOW.get());
                dropPottedContents(ModBlocks.POTTED_ZINNIA_FLOWER_LPURPLE.get());
                dropPottedContents(ModBlocks.POTTED_ZINNIA_FLOWER_PINK.get());
            }

            protected Iterable<Block> getKnownBlocks() {
                Block[] blocks = {ModBlocks.CHRISTMAS_WINDOW.get(), ModBlocks.DRUID_ALTAR.get(), ModBlocks.ZINNIA_FLOWER_LPURPLE.get()
                ,ModBlocks.POTTED_ZINNIA_FLOWER_PINK.get(), ModBlocks.POTTED_ZINNIA_FLOWER_YELLOW.get(), ModBlocks.POTTED_ZINNIA_FLOWER_GRAY.get(),
                        ModBlocks.POTTED_ZINNIA_FLOWER_LPURPLE.get(), ModBlocks.POTTED_ZINNIA_FLOWER_GRAY.get(), ModBlocks.POTTED_ZINNIA_FLOWER_YELLOW.get()
                ,ModBlocks.POTTED_ZINNIA_FLOWER_LPURPLE.get(), ModBlocks.POTTED_ZINNIA_FLOWER_PINK.get()};
                return List.of(blocks);
            }


        }

        @Override
        protected void validate(Map<ResourceLocation, net.minecraft.world.level.storage.loot.LootTable> map, ValidationContext validationtracker) {

        }
    }
}
