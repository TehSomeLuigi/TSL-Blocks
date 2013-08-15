package trs.someluigi.tslblocks.ref;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import trs.someluigi.tslblocks.ctab.TSLBlockCreativeTab;
import trs.someluigi.tslblocks.item.ItemOne;

public class ModInst {
	
	public static Item iOne;
	
	public static Block bOne;
	
	public static TSLBlockCreativeTab modCtab;
	
	public static void createThings() {
		modCtab = new TSLBlockCreativeTab("sl_extramisc:mainctab");
		
		iOne = new ItemOne(ModConfig.iOne);
		
		//bOne = new BlockOne(ModConfig.bOne);
	}
	
	public static void registerThings() {
		LanguageRegistry lr = LanguageRegistry.instance();
		
		GameRegistry.registerItem(iOne, "itemOne");
		
		lr.addStringLocalization("itemGroup.sl_extramisc:mainctab", "ExtraMisc by TehSomeLuigi");
		
		lr.addStringLocalization("sl_extramisc:itemone_0.name", "Item 1#0");
	}
	
}
