package net.wetnoodle.blahaj.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.crafting.FireworkStarRecipe;
import net.wetnoodle.blahaj.entity.impl.BlFireworkShapeTypes;
import net.wetnoodle.blahaj.registry.BlItems;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ShadowFinalModification")
@Mixin(FireworkStarRecipe.class)
public class FireworkStarRecipeMixin {
    @Shadow
    @Final
    private static Map<Item, FireworkExplosion.Shape> SHAPE_BY_ITEM;

    static {
        HashMap<Item, FireworkExplosion.Shape> mutableSBI = new HashMap<>(SHAPE_BY_ITEM);
        mutableSBI.put(BlItems.BLAHAJ, BlFireworkShapeTypes.BLAHAJ);
        SHAPE_BY_ITEM = Map.copyOf(mutableSBI);
    }
}
