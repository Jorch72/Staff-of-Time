package com.lang2619.sot.item;

import java.awt.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.lang2619.sot.handlers.ConfigurationHandler;
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
            return par1ItemStack;
        }
        else
        {
            --par1ItemStack.stackSize;
            return par1ItemStack;
        }
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {

        if(ConfigurationHandler.doAdditionalInfo())
        {
            String message = "Dusk stone, Turns Time to Dusk.";
            message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
            par3List.add(message);
        }
        else
        {
            par3List.add(ConfigurationHandler.additionalInfoInstructions());
        }

    }

}
