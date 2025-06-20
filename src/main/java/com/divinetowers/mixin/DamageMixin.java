package com.divinetowers.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.divinetowers.ModItems;

@Mixin(PlayerEntity.class)
public class DamageMixin {
    @Inject(method = "damage(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;F)Z", at = @At("HEAD"), cancellable = true)
	private void init(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> info) {
		// Prevent fall damage if wearing long fall boots
		PlayerEntity player = (PlayerEntity)(Object)this;
		if (source.isIn(DamageTypeTags.IS_FALL) && player.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.LONG_FALL_BOOTS)) {
			info.setReturnValue(false);
			
			// Create FX
			world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_MACE_SMASH_GROUND_HEAVY, SoundCategory.PLAYERS);
			world.spawnParticles(ParticleTypes.ENCHANTED_HIT, player.getX(), player.getY() + 1, player.getZ(), 25, 0, 0, 0, 0.25);

			player.addVelocity(0, 20, 0);
		}
	}
}