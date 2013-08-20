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

public class ItemBlockDyedIce extends ItemBlock {
	
	public static Icon[] icons = new Icon[16];
	
	public ItemBlockDyedIce(int par1) {
		super(par1);
		this.setHasSubtypes(true);
		this.setCreativeTab(ModInst.modCtab);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack i) {
		return "sl_extramisc:dyedice_" + i.getItemDamage();
	}
	
	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return ModInst.bDyedIce.getIcon(2, par1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		ItemBlockDyedIce.icons[0] = ir.registerIcon("sl_extramisc:b1_0");
		ItemBlockDyedIce.icons[1] = ir.registerIcon("sl_extramisc:b1_1");
		ItemBlockDyedIce.icons[2] = ir.registerIcon("sl_extramisc:b1_2");
		ItemBlockDyedIce.icons[3] = ir.registerIcon("sl_extramisc:b1_3");
		ItemBlockDyedIce.icons[4] = ir.registerIcon("sl_extramisc:b1_4");
		ItemBlockDyedIce.icons[5] = ir.registerIcon("sl_extramisc:b1_5");
		ItemBlockDyedIce.icons[6] = ir.registerIcon("sl_extramisc:b1_6");
		ItemBlockDyedIce.icons[7] = ir.registerIcon("sl_extramisc:b1_7");
		ItemBlockDyedIce.icons[8] = ir.registerIcon("sl_extramisc:b1_8");
		ItemBlockDyedIce.icons[9] = ir.registerIcon("sl_extramisc:b1_9");
		ItemBlockDyedIce.icons[10] = ir.registerIcon("sl_extramisc:b1_10");
		ItemBlockDyedIce.icons[11] = ir.registerIcon("sl_extramisc:b1_11");
		ItemBlockDyedIce.icons[12] = ir.registerIcon("sl_extramisc:b1_12");
		ItemBlockDyedIce.icons[13] = ir.registerIcon("sl_extramisc:b1_13");
		ItemBlockDyedIce.icons[14] = ir.registerIcon("sl_extramisc:b1_14");
		ItemBlockDyedIce.icons[15] = ir.registerIcon("sl_extramisc:b1_15");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean someBool) {
		list.add("Cold!");
	}

}
