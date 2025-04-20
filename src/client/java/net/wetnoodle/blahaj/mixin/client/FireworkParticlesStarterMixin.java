package net.wetnoodle.blahaj.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.FireworkParticles;
import net.minecraft.client.particle.NoRenderParticle;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.component.FireworkExplosion;
import net.wetnoodle.blahaj.entity.impl.BlFireworkShapeTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FireworkParticles.Starter.class)
public abstract class FireworkParticlesStarterMixin extends NoRenderParticle {

    protected FireworkParticlesStarterMixin(ClientLevel clientLevel, double d, double e, double f) {
        super(clientLevel, d, e, f);
    }

    @Shadow
    private void createParticle(double d, double e, double f, double g, double h, double i, IntList intList, IntList intList2, boolean bl, boolean bl2) {}

    @Unique
    private static final double[][] BLAHAJ$BLAHAJ_PARTICLE_COORDS = new double[][]{
            {-0.65,0},{-0.45,0.1},{-0.1,0.1},{0.15,0.35},{0.1,0.1},{0.25,0},{0.3,0.05},{0.3,0},{0.4,0},{0.4,0.15},{0.5,0},{0.65,-0.1},{0.5,-0.1},{0.2,-0.2},{0,-0.2},{0.2,-0.3},{0,-0.3},{-0.15,-0.2},{-0.1,-0.25},{-0.4,-0.25},{-0.6,-0.15},{-0.65,-0.05}
    };

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/component/FireworkExplosion;shape()Lnet/minecraft/world/item/component/FireworkExplosion$Shape;", ordinal = 1))
    void blahaj$blahajParticleCoords(CallbackInfo ci, @Local FireworkExplosion fireworkExplosion) {
        boolean bl3 = fireworkExplosion.hasTrail();
        boolean bl4 = fireworkExplosion.hasTwinkle();
        IntList intList = fireworkExplosion.colors();
        IntList intList2 = fireworkExplosion.fadeColors();
        if (intList.isEmpty()) {
            intList = IntList.of(DyeColor.BLACK.getFireworkColor());
        }

        if (fireworkExplosion.shape() == BlFireworkShapeTypes.BLAHAJ) {
            blahaj$createExactParticleShape(0.5, BLAHAJ$BLAHAJ_PARTICLE_COORDS, intList, intList2, bl3, bl4, true);
        }
    }

    @Unique
    public void blahaj$createExactParticleShape(double d, double[][] ds, IntList intList, IntList intList2, boolean bl, boolean bl2, boolean bl3) {
        double e = ds[0][0];
        double f = ds[0][1];
        this.createParticle(this.x, this.y, this.z, e * d, f * d, 0.0, intList, intList2, bl, bl2);
        float g = this.random.nextFloat() * (float) Math.PI;
        double h = bl3 ? 0.034 : 0.34;
        for (int i = 0; i < 3; i++) {
            double j = g + i * (float) Math.PI * h;
            double k = e;
            double l = f;
            for (int m = 1; m < ds.length; m++) {
                double n = ds[m][0];
                double o = ds[m][1];
                for (double p = 0.25; p <= 1.0; p += 0.25) {
                    double q = Mth.lerp(p, k, n) * d;
                    double r = Mth.lerp(p, l, o) * d;
                    double s = q * Math.sin(j);
                    q *= Math.cos(j);
                    this.createParticle(this.x, this.y, this.z, q, r, s, intList, intList2, bl, bl2);
                }
                k = n;
                l = o;
            }
        }
    }
}
