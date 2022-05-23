package com.rushork.fart.mod.mixin;

import com.rushork.fart.mod.registry.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.Items;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CowEntity.class)
public abstract class MixinAnimalPooper extends AnimalEntity {

    private int poopingTime = (this.random.nextInt(5)+30)*20;
    private int fartingTime = (this.random.nextInt(5)+15)*20;

    protected MixinAnimalPooper(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public void tickMovement() {
        super.tickMovement();
        if (!this.world.isClient && this.isAlive() && --this.poopingTime <= 0) {
            this.playSound(SoundEvents.ENTITY_SLIME_SQUISH, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(ModItems.POO_NUGGET);
            this.poopingTime = (this.random.nextInt(5)+30)*20 ;
        } else if (!this.world.isClient && this.isAlive() && --this.fartingTime <= 0) {
            this.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 0.5f, 0.1f);
            this.fartingTime = (this.random.nextInt(5)+15)*20;
        }
    }

}
