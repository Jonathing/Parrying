package com.theishiopian.parrying;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

public class FragileCurse extends Enchantment
{
    protected FragileCurse()
    {
        super(Rarity.VERY_RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    public int getMinCost(int in)
    {
        return 25;
    }

    public int getMaxCost(int in) {
        return 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isCurse()
    {
        return true;
    }

    public boolean checkCompatibility(Enchantment toCheck)
    {
        return !(toCheck instanceof PhasingCurse);
    }
}
