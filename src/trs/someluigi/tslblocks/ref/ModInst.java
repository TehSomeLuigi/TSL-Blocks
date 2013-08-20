package trs.someluigi.tslblocks.ref;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import trs.someluigi.tslblocks.Structs;
import trs.someluigi.tslblocks.block.BlockDyedIce;
import trs.someluigi.tslblocks.block.ItemBlockDyedIce;
import trs.someluigi.tslblocks.ctab.TSLBlockCreativeTab;
import trs.someluigi.tslblocks.item.ItemOne;

public class ModInst {
	
	public static ItemOne iOne;
	
	public static BlockDyedIce bDyedIce;
	
	public static TSLBlockCreativeTab modCtab;
	
	public static void createThings() {
		modCtab = new TSLBlockCreativeTab("sl_extramisc:mainctab");
		
		iOne = new ItemOne(ModConfig.iOne);
		
		if (ModConfig.bDyedIce != -1) {
			bDyedIce = new BlockDyedIce(ModConfig.bDyedIce, Material.ice);
		}
	}
	
	public static void registerThings() {
		LanguageRegistry lr = LanguageRegistry.instance();
		
		GameRegistry.registerItem(iOne, "itemOne");
		
		if (ModConfig.bDyedIce != -1) {
			GameRegistry.registerBlock(bDyedIce, ItemBlockDyedIce.class, "blockDyedIce");
			
			for (Integer i=0; i<=15; ++i) {
				lr.addStringLocalization("sl_extramisc:dyedice_" + i + ".name", Structs.colours[i] + " Dyed Ice");
			}
		}
		
		
		lr.addStringLocalization("itemGroup.sl_extramisc:mainctab", "ExtraMisc by TehSomeLuigi");
		
		lr.addStringLocalization("sl_extramisc:itemone_0.name", "Item 1#0");
		
	}
	
	public static void registerRecipes() {
		
		if (ModConfig.bDyedIce != -1) {
			for (Integer i=0; i<=15; ++i) {
				GameRegistry.addRecipe(new ItemStack(bDyedIce, 8, i), new Object[]{ "iii", "idi", "iii", 'i', new ItemStack(Block.ice), 'd', new ItemStack(Item.dyePowder, 1, BlockColored.getDyeFromBlock(i)) });
				GameRegistry.addRecipe(new ItemStack(bDyedIce, 8, i), new Object[]{ "iii", "idi", "iii", 'i', new ItemStack(bDyedIce, 1, -1), 'd', new ItemStack(Item.dyePowder, 1, BlockColored.getDyeFromBlock(i)) });
			}
		}
		
	}
	
}
