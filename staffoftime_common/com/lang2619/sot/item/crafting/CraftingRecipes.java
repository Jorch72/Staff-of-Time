package com.lang2619.sot.item.crafting;

import com.lang2619.sot.item.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipes
{

    public static void init()
    {
       //Time Essence
       GameRegistry.addRecipe(new ItemStack(ModItems.timeEssence), new Object[]{
          " G ", "GEG", " G ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('E'), Item.enderPearl  
       });
        
       //Dusk Powder
       GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dawnPowder), new Object[]{
           new ItemStack(Item.redstone), new ItemStack(Item.lightStoneDust)
       });
       
       //Dawn Powder
       GameRegistry.addShapelessRecipe(new ItemStack(ModItems.duskPowder), new Object[]{
           new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.lightStoneDust)
       });
       
       //Dusk Stone
       GameRegistry.addRecipe(new ItemStack(ModItems.duskStone), new Object[]{
           "XXX", "XOX", "XXX", Character.valueOf('X'), ModItems.duskFragment, Character.valueOf('O'), ModItems.timeEssence
       });
       
       //Dawn Stone
       GameRegistry.addRecipe(new ItemStack(ModItems.dawnStone), new Object[]{
           "XXX", "XOX", "XXX", Character.valueOf('X'), ModItems.dawnFragment, Character.valueOf('O'), ModItems.timeEssence
       });
       
       //Head Staff
       GameRegistry.addRecipe(new ItemStack(ModItems.headStaff), new Object[]{
           "IIE", " II", "  I", 'I', Item.ingotIron, 'E', Item.enderPearl
       });
       
       //Body Staff
       GameRegistry.addRecipe(new ItemStack(ModItems.bodyStaff), new Object[]{
           "  I", " I ", "I  ", 'I', Item.ingotIron
       });
       
       //Bottom Staff
       GameRegistry.addRecipe(new ItemStack(ModItems.bottomStaff), new Object[]{
          "II", "EI", 'I', Item.ingotIron, 'E', Item.diamond
       });
       
       //Neutral Staff
       GameRegistry.addRecipe(new ItemStack(ModItems.neutralStaff), new Object[]{
           "  H"," B ","S  ", 'H', ModItems.headStaff, 'B', ModItems.bodyStaff, 'S', ModItems.bottomStaff
       });
       
       //Dusk Staff
       GameRegistry.addRecipe(new ItemStack(ModItems.duskStaff), new Object[]{
           " U "," N "," T ", 'U',ModItems.duskStone,'T',ModItems.timeEssence,'N',ModItems.neutralStaff
       });
       //Dawn Staff
       GameRegistry.addRecipe(new ItemStack(ModItems.dawnStaff), new Object[]{
           " A "," N "," T ", 'T',ModItems.timeEssence,'A',ModItems.dawnStone,'N',ModItems.neutralStaff
       });
       //Dual Staff
       GameRegistry.addRecipe(new ItemStack(ModItems.dualStaff), new Object[]{
           "U A","UTA"," N ", 'U',ModItems.duskStone,'T',ModItems.timeEssence,'A',ModItems.dawnStone,'N',ModItems.neutralStaff
       });
       GameRegistry.addRecipe(new ItemStack(ModItems.dualStaff), new Object[]{
           "U A","UTA"," N ", 'A',ModItems.duskStone,'T',ModItems.timeEssence,'U',ModItems.dawnStone,'N',ModItems.neutralStaff
       });
    }

}
