package com.theishiopian.parrying;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class PhasingCurse extends Enchantment
{
    protected PhasingCurse()
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
        return !(toCheck instanceof FragileCurse);
    }
}