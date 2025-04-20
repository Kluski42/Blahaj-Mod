package net.wetnoodle.blahaj.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.wetnoodle.blahaj.BlConstants;
import org.jetbrains.annotations.NotNull;

public class BlBannerPatterns {
    public static final ResourceKey<BannerPattern> BLAHAJ = bind("blahaj");

    public static void init() {
    }

    public static void bootstrap(@NotNull BootstrapContext<BannerPattern> context) {
        BlConstants.logWithModId("Registering Banner Patterns for");
        register(context, BLAHAJ);
    }

    private static ResourceKey<BannerPattern> bind(@NotNull String path) {
        return ResourceKey.create(Registries.BANNER_PATTERN, BlConstants.id(path));
    }

    private static void register(@NotNull BootstrapContext<BannerPattern> entries, @NotNull ResourceKey<BannerPattern> key, @NotNull BannerPattern bannerPattern) {
        BlConstants.log("Registering banner pattern " + key.location());
        entries.register(key, bannerPattern);
    }

    public static void register(BootstrapContext<BannerPattern> entries, ResourceKey<BannerPattern> key) {
        entries.register(key, new BannerPattern(key.location(), "block.minecraft.banner." + key.location().toShortLanguageKey()));
    }
}
