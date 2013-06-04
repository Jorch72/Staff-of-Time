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
    
    public static void changeTime(int time, World world)
    {
        long day = (getTime(world) / 24000L) * 24000L;
        long newTime = day + 24000L + time * 1000;
        setTime(newTime, world);
        //if(notify)ServerUtils.sendChatToAll("Day "+(getTime(world) /24000L)+". "+time+":00");
        
    }
}
