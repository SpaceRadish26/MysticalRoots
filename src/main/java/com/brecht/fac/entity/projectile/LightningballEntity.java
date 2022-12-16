package com.brecht.fac.entity.projectile;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public class LightningballEntity extends Arrow {
    public LightningballEntity(EntityType<? extends Arrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LightningballEntity(Level pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
    }

    public LightningballEntity(Level pLevel, LivingEntity pShooter) {
        super(pLevel, pShooter);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level.isClientSide()) {
            LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            lightning.moveTo(this.getX(),this.getY(), this.getZ());
            this.level.addFreshEntity(lightning);
            this.level.explode(null, this.getX(), this.getY(), this.getZ(), 1, true, Explosion.BlockInteraction.BREAK);
            this.remove(RemovalReason.DISCARDED);
        }
    }


   /* @Override
    protected void onHitEntity(EntityHitResult ray) {
        super.onHitEntity(ray);
        // this, x, y, z, explosionStrength, setsFires, breakMode
        if (!this.level.isClientSide()) {
            LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            lightning.moveTo(this.getX(),this.getY(), this.getZ());
            this.level.addFreshEntity(lightning);
            this.level.explode(null, this.getX(), this.getY(), this.getZ(), 1, true, Explosion.BlockInteraction.BREAK);
            this.remove(RemovalReason.DISCARDED);
        }
    }*/
    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
