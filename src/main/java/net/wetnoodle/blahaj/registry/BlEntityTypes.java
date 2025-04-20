package net.wetnoodle.blahaj.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.wetnoodle.blahaj.BlConstants;
import net.wetnoodle.blahaj.entity.Blahaj;
import org.jetbrains.annotations.NotNull;

public class BlEntityTypes {
    public static final EntityType<Blahaj> BLAHAJ = register(
            "blahaj",
            EntityType.Builder.of(Blahaj::new, MobCategory.MISC)
                    .sized(0.7F, 0.7F)
                    .eyeHeight(0.7F * 0.85F) // 0.85F is default eye height scaler
                    .clientTrackingRange(10)
    );

    public static void init() {
        BlConstants.logWithModId("Registering Entities for");
        FabricDefaultAttributeRegistry.register(BLAHAJ, Blahaj.createAttributes());
    }

    private static <T extends Entity> @NotNull EntityType<T> register(String string, EntityType.@NotNull Builder<T> builder) {
        ResourceKey<EntityType<?>> resourceKey = ResourceKey.create(Registries.ENTITY_TYPE, BlConstants.id(string));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, resourceKey, builder.build(resourceKey));
    }
}
