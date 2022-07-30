package com.theishiopian.parrying.Mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.theishiopian.parrying.Mechanics.DualWieldingMechanic;
import com.theishiopian.parrying.Registration.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
This Mixin is used to allow the offhand to swing and animate just like the main hand. This is used for dual wielding.
It also tricks the renderer into considering scoped crossbows as crossbows
 */
@Mixin(ItemInHandRenderer.class)
public abstract class ItemInHandRendererMixin
{
    @ModifyArg(method = {"tick()V"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;clamp(FFF)F", ordinal = 3), index = 0)
    private float ModifyValueToClamp(float in, float min, float max)
    {
        LocalPlayer player = Minecraft.getInstance().player;
        assert player != null;//if this throws null we have a problem
        ItemInHandRenderer thisRenderer = Minecraft.getInstance().getItemInHandRenderer();
        ItemStack offHandCurrentItemStack = player.getOffhandItem();

        boolean reEquip = net.minecraftforge.client.ForgeHooksClient.shouldCauseReequipAnimation(thisRenderer.offHandItem, offHandCurrentItemStack, -1);

        float f = player.getAttackStrengthScale(1);
        return (DualWieldingMechanic.IsDualWielding(player) ? ((!reEquip) ? f * f * f : 0) : ((!reEquip) ? 1 : 0)) - thisRenderer.offHandHeight;
    }

    //the following code was created by paulevs, tweaked by theishiopian
    /**
     * steps:
     * 1. check what item the player is holding at the start of the render method
     * 2. cache in static field
     * 3. second mixin targets the "is" method from ItemStack
     * 4. check if the is method is checking for Items.Crossbow
     * 5. if it is, check if the in hand item is a scoped crossbow
     * 6. if it is, make the method check for our scoped crossbow instead, which will return true by default
     */
    private static Item inHandItem;

    @Inject(method = "renderArmWithItem", at = @At("HEAD"))
    private void getItemInHand(AbstractClientPlayer abstractClientPlayer, float f, float g, InteractionHand interactionHand, float h, ItemStack itemStack, float i, PoseStack poseStack, MultiBufferSource multiBufferSource, int j, CallbackInfo info)
    {
        inHandItem = itemStack.getItem();
    }

    //if wierd things start happening, look into replacing ordinal with @Slice
    @ModifyArg(method = "renderArmWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private Item changeStack(Item item)
    {
        //replaces the item to check for if we are looking for a crossbow and holding a scoped crossbow
        return item == Items.CROSSBOW && inHandItem == ModItems.SCOPED_CROSSBOW.get() ? ModItems.SCOPED_CROSSBOW.get() : item;
    }
}