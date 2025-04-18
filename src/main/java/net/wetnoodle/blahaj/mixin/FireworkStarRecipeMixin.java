package net.wetnoodle.blahaj.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.crafting.FireworkStarRecipe;
import net.wetnoodle.blahaj.entity.impl.BlFireworkShapeTypes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Map;

@Mixin(FireworkStarRecipe.class)
public class FireworkStarRecipeMixin {
    @Shadow
    @Mutable
    @Final
    private static Map<Item, FireworkExplosion.Shape> SHAPE_BY_ITEM;

//    @Inject(method = "<clinit>", at = @At(
//            opcode = Opcodes.PUTSTATIC,
//            value = "FIELD",
//            target = "Lnet/minecraft/world/item/crafting/FireworkStarRecipe;SHAPE_BY_ITEM:Ljava/util/Map;",
//            shift = At.Shift.AFTER)
//    )
//    private static void blahaj$addShapeItems(CallbackInfo info) {
//        SHAPE_BY_ITEM.put(Items.WHITE_WOOL, BlFireworkShapeTypes.BLAHAJ);
//    }

//    @ModifyVariable(
//            method = "<clinit>",
//            at = @At(value = "INVOKE", target = "Ljava/util/Map;of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", shift = At.Shift.AFTER)
//    )
//    private static Map<Item, FireworkExplosion.Shape> temp(Map<Item, FireworkExplosion.Shape> original) {
//        original.put(Items.WHITE_WOOL, BlFireworkShapeTypes.BLAHAJ);
//        return original;
//    }

//    @ModifyExpressionValue(
//            method = "<clinit>",
//            at = @At(value = "INVOKE", target = "Ljava/util/Map;of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;")
//    )
//    private static Map<Item, FireworkExplosion.Shape> blahaj$addShapeItems(Map<Item, FireworkExplosion.Shape> original) {
//        original.put(Items.WHITE_WOOL, BlFireworkShapeTypes.BLAHAJ);
//        return original;
//    }
}
