package com.lang2619.sot.item;

import com.lang2619.sot.lib.ItemID;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.item.Item;

public class ModItems
{
    public static Item duskPowder;
    public static Item duskFragment;
    public static Item duskStone;
    public static Item dawnPowder;
    public static Item dawnFragment;
    public static Item dawnStone;
    public static Item headStaff;
    public static Item bodyStaff;
    public static Item bottomStaff;
    public static Item neutralStaff;
    public static Item duskStaff;
    public static Item dawnStaff;
    public static Item dualStaff;
    public static Item timeEssence;
    
    public static void init()
    {
        duskPowder = new General(ItemID.DUSKPOWDER).setUnlocalizedName("duskPowder");
        duskFragment = new General(ItemID.DUSKFRAGMENT).setUnlocalizedName("duskFragment");
        duskStone = new DuskStone(ItemID.DUSKSTONE).setUnlocalizedName("duskStone");
        dawnPowder = new General(ItemID.DAWNPOWDER).setUnlocalizedName("dawnPowder");
        dawnFragment = new General(ItemID.DAWNFRAGMENT).setUnlocalizedName("dawnFragment");
        dawnStone = new DawnStone(ItemID.DAWNSTONE).setUnlocalizedName("dawnStone");
        headStaff = new General(ItemID.HEADSTAFF).setUnlocalizedName("headStaff");
        bodyStaff = new General(ItemID.BODYSTAFF).setUnlocalizedName("bodyStaff");
        bottomStaff = new General(ItemID.BOTTOMSTAFF).setUnlocalizedName("bottomStaff");
        neutralStaff = new Staff(ItemID.NEUTRALSTAFF).setUnlocalizedName("neutralStaff");
        duskStaff = new DuskStaff(ItemID.DUSKSTAFF).setUnlocalizedName("duskStaff");
        dawnStaff = new DawnStaff(ItemID.DAWNSTAFF).setUnlocalizedName("dawnStaff");
        dualStaff = new DualStaff(ItemID.DUALSTAFF).setUnlocalizedName("dualStaff");
        timeEssence = new Essence(ItemID.TIMEESSENCE).setUnlocalizedName("timeEssence");
        
        LanguageRegistry.addName(duskPowder, "Dusk Powder");
        LanguageRegistry.addName(duskFragment, "Dusk Fragment");
        LanguageRegistry.addName(duskStone, "Dusk Stone");
        LanguageRegistry.addName(dawnPowder, "Dawn Powder");
        LanguageRegistry.addName(dawnFragment, "Dawn Fragment");
        LanguageRegistry.addName(dawnStone, "Dawn Stone");
        LanguageRegistry.addName(headStaff, "Head Staff");
        LanguageRegistry.addName(bodyStaff, "Body Staff");
        LanguageRegistry.addName(bottomStaff, "Bottom Staff");
        LanguageRegistry.addName(neutralStaff, "Neutral Staff");
        LanguageRegistry.addName(duskStaff, "Dusk Staff");
        LanguageRegistry.addName(dawnStaff, "Dawn Staff");
        LanguageRegistry.addName(dualStaff, "Time Staff");
        LanguageRegistry.addName(timeEssence, "Essence of Time");
    }
}
