package net.wetnoodle.blahaj.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.wetnoodle.blahaj.BlConstants;
import net.wetnoodle.blahaj.block.entity.BlBannerPatterns;
import net.wetnoodle.blahaj.datagen.model.BlModelProvider;
import net.wetnoodle.blahaj.datagen.tag.BlBannerPatternTagProvider;
import net.wetnoodle.blahaj.datagen.tag.BlItemTagProvider;

public class BlahajDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        final FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(BlRegistryProvider::new);
        pack.addProvider(BlItemTagProvider::new);
        pack.addProvider(BlModelProvider::new);
        pack.addProvider(BlBannerPatternTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        BlConstants.logWithModId("Generating dynamic registries for");
        registryBuilder.add(Registries.BANNER_PATTERN, BlBannerPatterns::bootstrap);
    }
}
