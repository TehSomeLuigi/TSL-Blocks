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
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
		ModConfig.handleMain(config);
		
		ModInst.createThings();
		ModInst.registerThings();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		ModInst.registerRecipes();
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent e) {
	}
	
}
