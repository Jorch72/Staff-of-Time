package nl.lang2619.sot.handlers;

import java.util.Random;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class Weather
{
    public static void processCommand(ICommandSender par1ICommandSender, String string)
    {
        int i = (300 + (new Random()).nextInt(600)) * 20;

        WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
        WorldInfo worldinfo = worldserver.getWorldInfo();
        worldinfo.setRainTime(i);
        worldinfo.setThunderTime(i);

        if (string.equals("sun"))
        {
            worldinfo.setRaining(false);
            worldinfo.setThundering(false);
        }
        else if (string.equals("rain"))
        {
            worldinfo.setRaining(true);
            worldinfo.setThundering(false);
        }
        else if (string.equals("thunder"))
        {
            worldinfo.setRaining(true);
            worldinfo.setThundering(true);
        }
    }
}