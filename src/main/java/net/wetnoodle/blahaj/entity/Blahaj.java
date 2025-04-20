package net.wetnoodle.blahaj.entity;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.wetnoodle.blahaj.registry.BlItems;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class Blahaj extends LivingEntity {
    private static final Predicate<Entity> RIDABLE_MINECARTS = entity -> entity instanceof AbstractMinecart abstractMinecart && abstractMinecart.isRideable();
    private boolean invisible = false;
    public long lastHit;


    public Blahaj(EntityType<? extends Blahaj> entityType, Level level) {
        super(entityType, level);
    }

    // If this causes any problems, it's May's fault
    @Override
    public @NotNull HumanoidArm getMainArm() {
        return HumanoidArm.LEFT;
    }


    public static AttributeSupplier.Builder createAttributes() {
        return createLivingAttributes().add(Attributes.STEP_HEIGHT, 0.0);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(Entity entity) {
    }

    @Override
    protected void pushEntities() {
        for (Entity entity : this.level().getEntities(this, this.getBoundingBox(), RIDABLE_MINECARTS)) {
            if (this.distanceToSqr(entity) <= 0.2) {
                entity.push(this);
            }
        }
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float f) {
        if (this.isRemoved()) {
            return false;
        } else if (!serverLevel.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && damageSource.getEntity() instanceof Mob) {
            return false;
        } else if (damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            this.kill(serverLevel);
            return false;
        } else if (this.isInvulnerableTo(serverLevel, damageSource) || this.invisible /*|| this.isMarker()*/) {
            return false;
        } else if (damageSource.is(DamageTypeTags.IS_EXPLOSION)) {
            this.brokenByAnything(serverLevel, damageSource);
            this.kill(serverLevel);
            return false;
        } else if (damageSource.is(DamageTypeTags.IGNITES_ARMOR_STANDS)) {
            if (this.isOnFire()) {
                this.causeDamage(serverLevel, damageSource, 0.15F);
            } else {
                this.igniteForSeconds(5.0F);
            }

            return false;
        } else if (damageSource.is(DamageTypeTags.BURNS_ARMOR_STANDS) && this.getHealth() > 0.5F) {
            this.causeDamage(serverLevel, damageSource, 4.0F);
            return false;
        } else {
            boolean bl = damageSource.is(DamageTypeTags.CAN_BREAK_ARMOR_STAND);
            boolean bl2 = damageSource.is(DamageTypeTags.ALWAYS_KILLS_ARMOR_STANDS);
            if (!bl && !bl2) {
                return false;
            } else if (damageSource.getEntity() instanceof Player player && !player.getAbilities().mayBuild) {
                return false;
            } else if (damageSource.isCreativePlayer()) {
                this.playBrokenSound();
                this.showBreakingParticles();
                this.kill(serverLevel);
                return true;
            } else {
                long l = serverLevel.getGameTime();
                if (l - this.lastHit > 5L && !bl2) {
                    serverLevel.broadcastEntityEvent(this, (byte) 32);
                    this.gameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getEntity());
                    this.lastHit = l;
                } else {
                    this.brokenByPlayer(serverLevel, damageSource);
                    this.showBreakingParticles();
                    this.kill(serverLevel);
                }

                return true;
            }
        }
    }

    @Override
    public void handleEntityEvent(byte b) {
        if (b == 32) {
            if (this.level().isClientSide) {
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ARMOR_STAND_HIT, this.getSoundSource(), 0.3F, 1.0F, false);
                this.lastHit = this.level().getGameTime();
            }
        } else {
            super.handleEntityEvent(b);
        }
    }

    private void showBreakingParticles() {
        if (this.level() instanceof ServerLevel) {
            ((ServerLevel) this.level())
                    .sendParticles(
                            new BlockParticleOption(ParticleTypes.BLOCK, Blocks.LIGHT_BLUE_WOOL.defaultBlockState()),
                            this.getX(),
                            this.getY(0.6666666666666666),
                            this.getZ(),
                            10,
                            this.getBbWidth() / 4.0F,
                            this.getBbHeight() / 4.0F,
                            this.getBbWidth() / 4.0F,
                            0.05
                    );
        }
    }

    private void causeDamage(ServerLevel serverLevel, DamageSource damageSource, float f) {
        float g = this.getHealth();
        g -= f;
        if (g <= 0.5F) {
            this.brokenByAnything(serverLevel, damageSource);
            this.kill(serverLevel);
        } else {
            this.setHealth(g);
            this.gameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getEntity());
        }
    }

    private void brokenByPlayer(ServerLevel serverLevel, DamageSource damageSource) {
        ItemStack itemStack = new ItemStack(BlItems.BLAHAJ);
        itemStack.set(DataComponents.CUSTOM_NAME, this.getCustomName());
        Block.popResource(this.level(), this.blockPosition(), itemStack);
        this.brokenByAnything(serverLevel, damageSource);
    }

    private void brokenByAnything(ServerLevel serverLevel, DamageSource damageSource) {
        this.playBrokenSound();
        this.dropAllDeathLoot(serverLevel, damageSource);

        for (EquipmentSlot equipmentSlot : EquipmentSlot.VALUES) {
            ItemStack itemStack = this.equipment.set(equipmentSlot, ItemStack.EMPTY);
            if (!itemStack.isEmpty()) {
                Block.popResource(this.level(), this.blockPosition().above(), itemStack);
            }
        }
    }

    private void playBrokenSound() {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ARMOR_STAND_BREAK, this.getSoundSource(), 1.0F, 1.0F);
    }

    @Override
    public void kill(ServerLevel serverLevel) {
        this.remove(Entity.RemovalReason.KILLED);
        this.gameEvent(GameEvent.ENTITY_DIE);
    }
}
