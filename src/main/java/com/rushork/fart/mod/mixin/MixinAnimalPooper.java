package com.rushork.fart.mod.mixin;

import com.rushork.fart.mod.registry.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CowEntity.class)
public abstract class MixinAnimalPooper extends AnimalEntity {

    private int poopingTime = (this.random.nextInt(120)+300)*20;
    private int fartingTime = (this.random.nextInt(5)+15)*20;

    protected MixinAnimalPooper(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("TAIL"), method = "interactMob", cancellable = true)
    private void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.GLASS_BOTTLE) && !this.isBaby()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 2.0F);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, ModItems.PEE_BOTTLE.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }

    @Inject(at=@At("TAIL"), method="interactMob", cancellable = true)
    public void tickMovement() {
        if (!this.world.isClient && this.isAlive() && --this.poopingTime <= 0) {
            this.playSound(SoundEvents.ENTITY_SLIME_SQUISH, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(ModItems.POO_NUGGET);
            this.poopingTime = (this.random.nextInt(120)+300)*20 ;
        } else if (!this.world.isClient && this.isAlive() && --this.fartingTime <= 0) {
            this.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 0.5f, 0.1f);
            this.fartingTime = (this.random.nextInt(5)+15)*20;
        }
    }

}
