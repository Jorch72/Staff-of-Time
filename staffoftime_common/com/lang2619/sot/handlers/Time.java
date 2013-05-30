package com.lang2619.sot.handlers;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class Time
{
    public static void processCommand(ICommandSender par1ICommandSender, String string)
    {
            int i = 0;

            if(string.equals("dawn"))
            {
                i = 0;
            }
            if(string.equals("dusk"))
            {
                i = 12500;
            }

            setTime(par1ICommandSender, i);
            return;
    }

    private static void setTime(ICommandSender par1iCommandSender, int i)
    {
        for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
        {
            MinecraftServer.getServer().worldServers[j].setWorldTime((long)i);
        }
        
    }
}
