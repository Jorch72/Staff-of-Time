package com.lang2619.sot.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class StaffEvent extends PlayerEvent
{
    
    public final ItemStack staff;
    public int charge;

    public StaffEvent(EntityPlayer player, ItemStack staff, int charge)
    {
        super(player);
        this.staff = staff;
        this.charge = charge;
    }

}
