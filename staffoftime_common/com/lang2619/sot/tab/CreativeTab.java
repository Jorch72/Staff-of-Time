package com.lang2619.sot.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.lang2619.sot.item.ModItems;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class CreativeTab
{
    
    public static CreativeTabs tabCustom;

    public static void init()
    {
        new CreativeTabs("tabCustom") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(ModItems.dawnStone, 1, 0);
            }
    };
        
        LanguageRegistry.instance().addStringLocalization("tabCustom", "en_US", "Staff of Time");
    }
}
