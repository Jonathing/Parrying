package com.theishiopian.parrying.Mixin;

import com.theishiopian.parrying.Mechanics.DualWielding;
import com.theishiopian.parrying.Utility.Debug;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin
{
    @Inject(at = @At("HEAD"), method = "getCurrentItemAttackStrengthDelay", cancellable = true)
    private void InjectIntoGetCurrentItemAttackStrengthDelay(CallbackInfoReturnable<Float> cir)
    {
        PlayerEntity player = ((PlayerEntity)(Object)this);
        boolean client = player.isLocalPlayer();
        boolean hasPlayer = client ? DualWielding.IsDualWielding : DualWielding.dualWielders.containsKey(player.getUUID());
        boolean usingOffHand = client ? DualWielding.CurrentHand != Hand.OFF_HAND : (DualWielding.dualWielders.get(player.getUUID()) != Hand.OFF_HAND);
        boolean hasSpeed = player.getOffhandItem().getAttributeModifiers(EquipmentSlotType.MAINHAND).containsKey(Attributes.ATTACK_SPEED);
        //Debug.log("mixin");
        if(hasPlayer && hasSpeed)
        {
            float speedMod;
            Debug.log(player.getOffhandItem());
            Debug.log(usingOffHand);
            if(usingOffHand)
            {
                speedMod = (float) player.getOffhandItem().
                        getAttributeModifiers(EquipmentSlotType.MAINHAND).
                        get(Attributes.ATTACK_SPEED).stream().findFirst().get().getAmount();
                cir.setReturnValue((float)((1.0D / (Attributes.ATTACK_SPEED.getDefaultValue() + speedMod)) * 20.0D));
            }
        }
    }
}