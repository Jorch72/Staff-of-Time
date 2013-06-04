package nl.lang2619.sot.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import nl.lang2619.sot.command.ClientUtils;
import nl.lang2619.sot.handlers.ConfigurationHandler;
import nl.lang2619.sot.lib.Utils;


public class DawnStaff extends ItemGeneral
{

    public int cooldownTime = 0;


    public DawnStaff(int id)
    {
        super(id);
        this.setMaxDamage(384);
        this.maxStackSize = 1; 
    }    

    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
    {
        cooldownTime--;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer,  List par3List, boolean par4)
    {
        if(ConfigurationHandler.doAdditionalInfo())
        {

            String message = "A Staff that turns time to Day.";
            String message1 = "Uses sun fragments.";
            message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
            par3List.add(message);
            par3List.add(message1);
        }
        else
        {
            par3List.add(ConfigurationHandler.additionalInfoInstructions());
        }
    }

    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4, String astring)
    {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        float f = (float)j / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

        if ((double)f < 0.1D)
        {
            return;
        }

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        
        //par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

        if (par3EntityPlayer.capabilities.isCreativeMode)
        {
            ClientUtils.changeTime(0, par2World);
        }
        if(!par3EntityPlayer.capabilities.isCreativeMode && par3EntityPlayer.inventory.hasItem(ModItems.dawnFragment.itemID))
        {
            if(cooldownTime <= 0 && par3EntityPlayer.inventory.hasItem(ModItems.dawnFragment.itemID))
            {
                par3EntityPlayer.inventory.consumeInventoryItem(ModItems.dawnFragment.itemID);
                ClientUtils.changeTime(0, par2World);
                par1ItemStack.damageItem(1, par3EntityPlayer);
                cooldownTime = 6000;
                par1ItemStack.damageItem(1, par3EntityPlayer);
            }
            
            if(cooldownTime > 0 && cooldownTime < 5900)
            {
                par3EntityPlayer.addChatMessage("You can't use this Staff yet, wait for "+(cooldownTime/20)+" seconds.");
            }
        }

    }


    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (par3EntityPlayer.capabilities.isCreativeMode)
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        if(!par3EntityPlayer.capabilities.isCreativeMode && par3EntityPlayer.inventory.hasItem(ModItems.dawnFragment.itemID))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        if(!par3EntityPlayer.inventory.hasItem(ModItems.dawnFragment.itemID))
        {
            par3EntityPlayer.addChatMessage("You don't have any Sun Fragments to use this.");
        }
        return par1ItemStack;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 0;
    }
    
    public int getDamageVsEntity(Entity par1Entity)
    {
        return 5;
    }
}