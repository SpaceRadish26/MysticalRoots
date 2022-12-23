package com.brecht.fac;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MRBlockStateProvider extends BlockStateProvider {
    ExistingFileHelper helper;
    public MRBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
        helper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
