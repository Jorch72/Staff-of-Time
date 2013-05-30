package com.lang2619.sot.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.lang2619.sot.handlers.ConfigurationHandler;
import com.lang2619.sot.handlers.Time;
import com.lang2619.sot.lib.Utils;

public class DuskStone extends ItemGeneral
{

    public DuskStone(int id)
    {
        super(id);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if(par3EntityPlayer.capabilities.isCreativeMode)
        {
            Time.processCommand(par3EntityPlayer, "dusk");
            return par1ItemStack;
        }
        else
        {
            Time.processCommand(par3EntityPlayer, "dusk");
            --par1ItemStack.stackSize;
            return par1ItemStack;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer,  List par3List, boolean par4)
    {
        if(ConfigurationHandler.doAdditionalInfo())
        {
            String message = "Turns time to Dusk.";
            message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
            par3List.add(message);
        }
        else
        {
            par3List.add("Turns time to Dusk.");
            //par3List.add(ConfigurationHandler.additionalInfoInstructions());
        }
    }
}
