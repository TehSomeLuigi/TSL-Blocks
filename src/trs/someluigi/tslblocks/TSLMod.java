package trs.someluigi.tslblocks;

import trs.someluigi.tslblocks.ref.ModConfig;
import trs.someluigi.tslblocks.ref.ModInst;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "sl_extramisc")
public class TSLMod {
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent e) {
		System.out.println("SLTSL PreInit");
		
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
		ModConfig.handleMain(config);
		
		ModInst.createThings();
		ModInst.registerThings();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		System.out.println("SLTSL Init");
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent e) {
		System.out.println("SLTSL PostInit");
	}
	
}
