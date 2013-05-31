package com.lang2619.sot;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.lang2619.sot.handlers.ConfigurationHandler;
import com.lang2619.sot.item.ModItems;
import com.lang2619.sot.item.crafting.CraftingRecipes;
import com.lang2619.sot.item.crafting.SmeltingRecipes;
import com.lang2619.sot.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class StaffofTime
{
    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsoluteFile() + File.separator + "Staff of Time" + ".cfg"));
        //CreativeTab.init();
        ModItems.init();
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabTut", "en_US", "Staff of Time");
        
    }

    @Init
    public void init(FMLInitializationEvent event)
    {
        CraftingRecipes.init();
        SmeltingRecipes.init();

    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event)
    {

    }
    
    public static CreativeTabs tabTut = new CreativeTabs("tabTut")
    {
        public ItemStack getIconItemStack()
    {
            return new ItemStack(ModItems.dawnStone, 1, 0);
    }
    };
}
