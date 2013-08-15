package trs.someluigi.tslblocks.ref;

import net.minecraftforge.common.Configuration;

public class ModConfig {
	
	// Block IDs
	public static int bOne;
	
	// Item IDs
	public static int iOne;
	
	
	public static void handleMain(Configuration config) {
		config.load();
		
		bOne = config.getBlock("block", "blockOne", 1800, "BlockID#1 of this mod.").getInt(1800);
		
		iOne = config.getItem("item", "itemOne", 7900, "ItemID#1 of this mod.").getInt(7900);
		
		config.save();
	}
	
}
