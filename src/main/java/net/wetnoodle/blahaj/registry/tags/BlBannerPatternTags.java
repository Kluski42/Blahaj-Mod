package net.wetnoodle.blahaj.registry.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.wetnoodle.blahaj.BlConstants;
import org.jetbrains.annotations.NotNull;

public class BlBannerPatternTags {
    public static final TagKey<BannerPattern> PATTERN_ITEM_BLAHAJ = register("pattern_item/blahaj");

    @NotNull
    private static TagKey<BannerPattern> register(@NotNull String path) {
        return TagKey.create(Registries.BANNER_PATTERN, BlConstants.id(path));
    }
}
