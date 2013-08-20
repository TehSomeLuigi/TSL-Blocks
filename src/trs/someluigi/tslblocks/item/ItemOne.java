package trs.someluigi.tslblocks.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import trs.someluigi.tslblocks.ref.ModInst;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemOne extends Item {
	
	public Icon itemIcon;
	
	public ItemOne(int par1) {
		super(par1);
		this.setHasSubtypes(true);
		this.setCreativeTab(ModInst.modCtab);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack i) {
		return "sl_extramisc:itemone_" + i.getItemDamage();
	}
	
	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return this.itemIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("sl_extramisc:i1_0");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean someBool) {
		switch (iStack.getItemDamage()) {
			case 0:
				list.add("Item One");
			break;
		}
	}
}
