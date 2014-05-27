package trs.someluigi.tslblocks.ref;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if ((fuel.itemID == ModConfig.bCharcoal) && (fuel.getItemDamage() == 0)) {
			return 14400;
		}
		return 0;
	}

}
