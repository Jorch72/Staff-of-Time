package com.lang2619.sot.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DawnStone extends ItemGeneral
{

    public DawnStone(int id)
    {
        super(id);
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if(par3EntityPlayer.capabilities.isCreativeMode)
        {
            return par1ItemStack;
        }
        else if(par3EntityPlayer.ridingEntity != null)
        {
            return par1ItemStack;
        }
        else
        {
            --par1ItemStack.stackSize;
            return par1ItemStack;
        }
    }
}
