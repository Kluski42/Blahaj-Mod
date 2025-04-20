package net.wetnoodle.blahaj.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.wetnoodle.blahaj.BlConstants;

import java.util.concurrent.CompletableFuture;

public class BlRegistryProvider extends FabricDynamicRegistryProvider {
    public BlRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        BlConstants.log("Adding banner patterns to datagen", true);
        entries.addAll(asLookup(entries.getLookup(Registries.BANNER_PATTERN)));
    }

    public static <T> HolderLookup.RegistryLookup<T> asLookup(HolderGetter<T> getter) {
        return (HolderLookup.RegistryLookup<T>) getter;
    }

    @Override
    public String getName() {
        return "BlRegistryProvider";
    }
}
