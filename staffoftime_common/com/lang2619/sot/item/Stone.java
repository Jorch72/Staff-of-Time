package com.lang2619.sot.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.lang2619.sot.handlers.ConfigurationHandler;
import com.lang2619.sot.handlers.Time;
import com.lang2619.sot.lib.Utils;

public class Stone extends ItemGeneral
{
    public final String stoneName;

    public Stone(int id, String par2str)
    {
        super(id);
        this.stoneName = par2str;
    }

    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if(par3EntityPlayer.capabilities.isCreativeMode)
        {
            if(stoneName == "dawn")
            {
                Time.processCommand(par3EntityPlayer, "dawn");
            }
            if(stoneName == "dusk")
            {
                Time.processCommand(par3EntityPlayer, "dusk");   
            }
            return par1ItemStack;
        }
        else
        {
            --par1ItemStack.stackSize;
            if(stoneName == "dawn")
            {
                Time.processCommand(par3EntityPlayer, "dawn");
            }
            if(stoneName == "dusk")
            {
                Time.processCommand(par3EntityPlayer, "dusk");   
            }
            return par1ItemStack;

        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer,  List par3List, boolean par4)
    {
        if(ConfigurationHandler.doAdditionalInfo())
        {
            if(stoneName == "dawn")
            {
                String message = "Turns time to Dawn.";
                message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
                par3List.add(message);
            }
            if(stoneName == "dusk")
            {
                String message = "Turns time to Dusk.";
                message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
                par3List.add(message);
            }
            if(stoneName == "sun")
            {
                String message = "Turns weather to Sunny.";
                message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
                par3List.add(message);
            }
            if(stoneName == "rain")
            {
                String message = "Turns weather to Rain.";
                message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
                par3List.add(message);
            }
            if(stoneName == "thunder")
            {
                String message = "Turns weather to a Thunderstorm.";
                message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
                par3List.add(message);
            }
        }
        else
        {
            par3List.add(ConfigurationHandler.additionalInfoInstructions());
        }
    }
}
