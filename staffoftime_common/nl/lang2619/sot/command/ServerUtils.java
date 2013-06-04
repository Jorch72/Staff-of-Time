package nl.lang2619.sot.command;

import net.minecraft.world.World;

public class ServerUtils
{
    public static long getTime(World world)
    {
        return world.getWorldInfo().getWorldTime();
    }
    
    public static void setTime(long l, World world)
    {
        world.getWorldInfo().setWorldTime(l);
    }
}
