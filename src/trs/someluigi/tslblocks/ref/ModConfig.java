package trs.someluigi.tslblocks.ref;

import net.minecraftforge.common.Configuration;

public class ModConfig {
	
	// Block IDs
	public static int bDyedIce, bCharcoal;
	
	// Item IDs
	public static int iOne;
	
	
	public static void handleMain(Configuration config) {
		config.load();
		
		bDyedIce = config.getBlock("block", "dyedIce", 1800, "BlockID of dyed ice. -1 removes my dyed ice from the game.").getInt(1800);
		
		iOne = config.getItem("item", "itemOne", 7900, "ItemID#1 of this mod.").getInt(7900);
		
		bCharcoal = config.getBlock("block", "charcoal", 1801, "BlockID of charcoal. -1 removes this block from the game.").getInt(1801);
		
		config.save();
	}
	
}
