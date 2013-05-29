package com.lang2619.sot.item.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.lang2619.sot.item.ModItems;

public class SmeltingRecipes
{

    public static void init()
    {
        FurnaceRecipes.smelting().addSmelting(ModItems.duskPowder.itemID, 0, new ItemStack(ModItems.duskFragment), 0.5F);
        FurnaceRecipes.smelting().addSmelting(ModItems.dawnPowder.itemID, 0, new ItemStack(ModItems.dawnFragment), 0.5F);        
    }

}
