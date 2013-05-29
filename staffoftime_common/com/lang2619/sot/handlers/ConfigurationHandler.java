package com.lang2619.sot.handlers;

import java.io.File;
import java.util.logging.Level;

import org.lwjgl.input.Keyboard;

import com.lang2619.sot.lib.ItemID;
import com.lang2619.sot.lib.Reference;
import com.lang2619.sot.lib.Strings;
import com.lang2619.sot.lib.Utils;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.Configuration;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static final String CATEGORY_BLOCK_PROPERTIES = Configuration.CATEGORY_BLOCK + Configuration.CATEGORY_SPLITTER + "properties";

    public static void init(File configFile)
    {
        configuration = new Configuration(configFile);

        try{
            configuration.load();

            //Blocks

            //ITEMS
            ItemID.DUSKPOWDER = configuration.getItem(Strings.DUSK_POWDER, ItemID.DUSKPOWDER_DEFAULT).getInt(ItemID.DUSKPOWDER_DEFAULT);
            ItemID.DUSKFRAGMENT = configuration.getItem(Strings.DUSK_FRAGMENT, ItemID.DUSKFRAGMENT_DEFAULT).getInt(ItemID.DUSKFRAGMENT_DEFAULT);
            ItemID.DUSKSTONE = configuration.getItem(Strings.DUSK_STONE, ItemID.DUSKSTONE_DEFAULT).getInt(ItemID.DUSKSTONE_DEFAULT);
            ItemID.DAWNPOWDER = configuration.getItem(Strings.DAWN_POWDER, ItemID.DAWNPOWDER_DEFAULT).getInt(ItemID.DAWNPOWDER_DEFAULT);
            ItemID.DAWNFRAGMENT = configuration.getItem(Strings.DAWN_FRAGMENT, ItemID.DAWNFRAGMENT_DEFAULT).getInt(ItemID.DAWNFRAGMENT_DEFAULT);
            ItemID.DAWNSTONE = configuration.getItem(Strings.DAWN_STONE, ItemID.DAWNSTONE_DEFAULT).getInt(ItemID.DAWNSTONE_DEFAULT);
            ItemID.HEADSTAFF = configuration.getItem(Strings.HEAD_STAFF, ItemID.HEADSTAFF_DEFAULT).getInt(ItemID.HEADSTAFF_DEFAULT);
            ItemID.BODYSTAFF = configuration.getItem(Strings.BODY_STAFF, ItemID.BODYSTAFF_DEFAULT).getInt(ItemID.BODYSTAFF_DEFAULT);
            ItemID.BOTTOMSTAFF = configuration.getItem(Strings.BOTTOM_STAFF, ItemID.BOTTOMSTAFF_DEFAULT).getInt(ItemID.BOTTOMSTAFF_DEFAULT);
            ItemID.NEUTRALSTAFF = configuration.getItem(Strings.NEUTRAL_STAFF, ItemID.NEUTRALSTAFF_DEFAULT).getInt(ItemID.NEUTRALSTAFF_DEFAULT);
            ItemID.DUSKSTAFF = configuration.getItem(Strings.DUSK_STAFF, ItemID.DUSKSTAFF_DEFAULT).getInt(ItemID.DUSKSTAFF_DEFAULT);
            ItemID.DAWNSTAFF = configuration.getItem(Strings.DAWN_STAFF, ItemID.DAWNSTAFF_DEFAULT).getInt(ItemID.DAWNSTAFF_DEFAULT);
            ItemID.DUALSTAFF = configuration.getItem(Strings.DUAL_STAFF, ItemID.DUALSTAFF_DEFAULT).getInt(ItemID.DUALSTAFF_DEFAULT);
            ItemID.TIMEESSENCE = configuration.getItem(Strings.TIME_ESSENCE, ItemID.TIMEESSENCE_DEFAULT).getInt(ItemID.TIMEESSENCE_DEFAULT);

        }
        catch(Exception e){
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        }
        finally{
            configuration.save();
        }
    }

    public static void set(String categoryName, String propertyName, String newValue)
    {
        configuration.load();
        if(configuration.getCategoryNames().contains(categoryName)){
            if(configuration.getCategory(categoryName).containsKey(propertyName)){
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }

    public static boolean doAdditionalInfo()
    {
        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
                return true;
            }
        }
        return false;
    }

    public static String additionalInfoInstructions()
    {
        String message = "Press SHIFT for more information.";
        message = Utils.wrapMultipleFormatTags(message, Utils.FormatCodes.Grey, Utils.FormatCodes.Italic);
        return message;
    }
}