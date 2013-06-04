package nl.lang2619.sot.command;

import net.minecraft.client.Minecraft;

public class ClientUtils extends ServerUtils
{
    public static Minecraft mc()
    {
        return Minecraft.getMinecraft();
    }
    
    public static long getTime()
    {
        return mc().theWorld.getWorldInfo().getWorldTime();
    }

    public static void setTime(long l)
    {
        mc().theWorld.getWorldInfo().setWorldTime(l);
    }
    
    public static void changeTime(int time)
    {
        long day = (getTime() / 24000L) * 24000L;
        long newTime = day + 24000L + time * 1000;
        setTime(newTime);
        
    }
}
