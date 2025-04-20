package net.wetnoodle.blahaj.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.wetnoodle.blahaj.BlConstants;
import net.wetnoodle.blahaj.item.BlahajItem;
import net.wetnoodle.blahaj.registry.tags.BlBannerPatternTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class BlItems {
    public static final Item BLAHAJ_BANNER_PATTERN = register(
            "blahaj_banner_pattern", Item::new,
            new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                    .component(DataComponents.PROVIDES_BANNER_PATTERNS, BlBannerPatternTags.PATTERN_ITEM_BLAHAJ));

    public static final Item BLAHAJ = register(
            "blahaj", BlahajItem::new,
            new Item.Properties()
    );

    public static void init() {
        BlConstants.logWithModId("Registering blocks for");
    }

//    private static Item register(@NotNull String path, @NotNull Item item) {
//        if (BuiltInRegistries.ITEM.getOptional(BlConstants.id(path)).isEmpty()) {
//            return Registry.register(BuiltInRegistries.ITEM, BlConstants.id(path), item);
//        }
//        return item;
//    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Item.Properties, Item> function, Item.@NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, BlConstants.id(name)), function, properties);
    }
}
