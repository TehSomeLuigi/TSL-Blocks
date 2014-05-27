package trs.someluigi.tslblocks.block;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import trs.someluigi.tslblocks.ref.ModInst;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockCharcoal extends ItemBlock {
	
	public static Icon[] icons = new Icon[1];
	
	public ItemBlockCharcoal(int par1) {
		super(par1);
		this.setHasSubtypes(true);
		this.setCreativeTab(ModInst.modCtab);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack i) {
		return "sl_extramisc:charblock_" + i.getItemDamage();
	}
	
	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return ModInst.bCharcoal.getIcon(2, par1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		ItemBlockCharcoal.icons[0] = ir.registerIcon("sl_extramisc:charcoal_block");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean someBool) {
		list.add("9 charcoal in a block. Kinda like coal blocks, but uglier.");
	}

}
