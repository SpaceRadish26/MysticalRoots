package com.brecht.fac.entity.mobs;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ArchonOTVEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    public ArchonOTVEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.ATTACK_DAMAGE,8.0f)
                .add(Attributes.MAX_HEALTH,85D)
                .add(Attributes.ATTACK_SPEED,0.8F)
                .add(Attributes.MOVEMENT_SPEED,1.2f).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.5D, true));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Animal.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.archonotv.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.archonotv.idle", true));
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
    protected SoundEvent getAmbientSound() {return SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST;}
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {return SoundEvents.HOGLIN_HURT;}
    protected SoundEvent getDeathSound() {return SoundEvents.GOAT_SCREAMING_DEATH;}

    protected float GetSoundVolume() {
        return 0.4F;
    }
}
