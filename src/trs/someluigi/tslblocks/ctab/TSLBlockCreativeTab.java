package trs.someluigi.tslblocks.ctab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import trs.someluigi.tslblocks.ref.ModInst;

public class TSLBlockCreativeTab extends CreativeTabs {
	
	public TSLBlockCreativeTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ModInst.iOne);
	}
	
}
