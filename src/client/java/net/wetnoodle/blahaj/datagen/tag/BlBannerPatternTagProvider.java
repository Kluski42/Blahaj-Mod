package net.wetnoodle.blahaj.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BannerPatternTags;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.wetnoodle.blahaj.block.entity.BlBannerPatterns;
import net.wetnoodle.blahaj.registry.tags.BlBannerPatternTags;

import java.util.concurrent.CompletableFuture;

public class BlBannerPatternTagProvider extends FabricTagProvider<BannerPattern> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public BlBannerPatternTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BANNER_PATTERN, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        this.getOrCreateTagBuilder(BlBannerPatternTags.PATTERN_ITEM_BLAHAJ)
                .add(BlBannerPatterns.BLAHAJ);
    }
}
