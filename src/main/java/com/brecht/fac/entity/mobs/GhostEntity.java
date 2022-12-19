package com.brecht.fac.entity.mobs;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class GhostEntity extends Monster implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);
    public GhostEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FLYING_SPEED, 1f)
                .add(Attributes.ATTACK_DAMAGE,5.0f)
                .add(Attributes.MAX_HEALTH,30D)
                .add(Attributes.ATTACK_SPEED,2.0F)
                .add(Attributes.MOVEMENT_SPEED,1f).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.4f, true));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomFlyingGoal(this, 0.2D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ghost.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ghost.idle", true));
        return PlayState.CONTINUE;
    }
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this,"controller",
                0,this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
    protected SoundEvent getAmbientSound() {return SoundEvents.CANDLE_AMBIENT;}
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {return SoundEvents.VEX_HURT;}
    protected SoundEvent getDeathSound() {return SoundEvents.VEX_DEATH;}

    protected float GetSoundVolume() {
        return 0.2F;
    }
}
