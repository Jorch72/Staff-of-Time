package com.lang2619.sot.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.lang2619.sot.lib.Reference;

public class ItemGeneral extends Item
{
    public ItemGeneral(int id)
    {
        super(id);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
    }

    public int getItemStackLimit()
    {
        return this.maxStackSize;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){}
}