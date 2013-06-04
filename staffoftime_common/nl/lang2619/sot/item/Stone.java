package nl.lang2619.sot.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.lang2619.sot.command.ClientUtils;
import nl.lang2619.sot.handlers.ConfigurationHandler;

import nl.lang2619.sot.handlers.Weather;
import nl.lang2619.sot.lib.Utils;


public class Stone extends ItemGeneral
{
    public final String stoneName;
    public int cooldownTime = 0;
    public int cooldownWeather = 0;

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
                ClientUtils.setTime(0, par2World);
            }
            if(stoneName == "dusk")
            {
                ClientUtils.setTime(12500, par2World);  
            }
            if(stoneName == "sun")
            {
                Weather.processCommand(par3EntityPlayer, "sun");
            }
            if(stoneName == "rain")
            {
                Weather.processCommand(par3EntityPlayer, "rain");
            }
            if(stoneName == "thunder")
            {
                Weather.processCommand(par3EntityPlayer, "thunder");
            }
            return par1ItemStack;
        }
        else
        {
            
            if(stoneName == "dawn")
            {
                if(cooldownTime <= 0)
                {
                    ClientUtils.changeTime(0, par2World);
                    cooldownTime = 12000;
                    --par1ItemStack.stackSize;
                }
                else
                {
                    par3EntityPlayer.addChatMessage("You can't use this Stone yet, wait for "+(cooldownTime/20)+" seconds.");
                }
            }
            if(stoneName == "dusk")
            {
                if(cooldownTime <= 0)
                {
                    ClientUtils.changeTime(12500, par2World);
                    cooldownTime = 12000;
                    --par1ItemStack.stackSize;
                }
                else
                {
                    par3EntityPlayer.addChatMessage("You can't use this Stone yet, wait for "+(cooldownTime/20)+" seconds.");
                }
            }
            if(stoneName == "sun")
            {
                if(cooldownWeather <= 0)
                {

                    Weather.processCommand(par3EntityPlayer, "sun");
                    cooldownWeather = 12000;
                    --par1ItemStack.stackSize;
                }
                else
                {
                    par3EntityPlayer.addChatMessage("You can't use this Stone yet, wait for "+(cooldownWeather/20)+" seconds.");
                }
            }
            if(stoneName == "rain")
            {
                if(cooldownWeather <= 0)
                {

                    Weather.processCommand(par3EntityPlayer, "rain");
                    cooldownWeather = 12000;
                    --par1ItemStack.stackSize;
                }
                else
                {
                    par3EntityPlayer.addChatMessage("You can't use this Stone yet, wait for "+(cooldownWeather/20)+" seconds.");
                }
            }
            if(stoneName == "thunder")
            {
                if(cooldownWeather <= 0)
                {
                    Weather.processCommand(par3EntityPlayer, "thunder");
                    cooldownWeather = 12000;
                    --par1ItemStack.stackSize;
                }
                else
                {
                    par3EntityPlayer.addChatMessage("You can't use this Stone yet, wait for "+(cooldownWeather/20)+" seconds.");
                }
            }

            return par1ItemStack;

        }
    }

    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
    {
        cooldownTime--;
        cooldownWeather--;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer,  List par3List, boolean par4)
    {
        if(ConfigurationHandler.doAdditionalInfo())
        {
            if(stoneName == "dawn")
            {
                String message = "Turns time to Day.";
                message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
                par3List.add(message);
            }
            if(stoneName == "dusk")
            {
                String message = "Turns time to Night.";
                message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
                par3List.add(message);
            }
            if(stoneName == "sun")
            {
                String message = "Turns weather to Clear.";
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
