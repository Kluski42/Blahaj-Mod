package net.wetnoodle.blahaj.mixin;

import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.component.FireworkExplosion.Shape;
import net.wetnoodle.blahaj.entity.impl.BlFireworkShapeTypes;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(FireworkExplosion.Shape.class)
public class FireworkShapeMixin  {

   @Final
   @Shadow
   @Mutable
   private static Shape[] $VALUES;

   @SuppressWarnings("InvokerTarget")
   @Invoker("<init>")
   private static Shape blahaj$newShape(String internalName, int internalId, int id, String name) {
       throw new AssertionError("Mixin injection failed - Blahaj FireworkShapeMixin.");
   }


   @Inject(method = "<clinit>", at = @At(value = "FIELD",
           opcode = Opcodes.PUTSTATIC,
           target = "Lnet/minecraft/world/item/component/FireworkExplosion$Shape;$VALUES:[Lnet/minecraft/world/item/component/FireworkExplosion$Shape;",
           shift = At.Shift.AFTER))
   private static void blahaj$addCustomShape(CallbackInfo info) {
      var types = new ArrayList<>(Arrays.asList($VALUES));
      var last = types.getLast();


      Shape blahaj = blahaj$newShape("BLAHAJBLAHAJ", last.ordinal() + 1, last.ordinal() + 1, "blahajblahaj");
      BlFireworkShapeTypes.BLAHAJ = blahaj;
      types.add(blahaj);

      $VALUES = types.toArray(new Shape[0]);
   }
}
