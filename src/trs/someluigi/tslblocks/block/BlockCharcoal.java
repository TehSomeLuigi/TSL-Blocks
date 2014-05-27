package trs.someluigi.tslblocks.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import trs.someluigi.tslblocks.ref.ModInst;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCharcoal extends Block {
	
	public BlockCharcoal(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setLightOpacity(3);
		this.setStepSound(soundStoneFootstep);
		this.setCreativeTab(ModInst.modCtab);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int j = 0; j < 1; ++j) {
			par3List.add(new ItemStack(par1, 1, j));
		}
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (ItemBlockCharcoal.icons.length-1 >= meta) {
			return ItemBlockCharcoal.icons[meta];
		}
		return ModInst.iOne.itemIcon;
	}
	
	@Override
	public int damageDropped(int par1) {
		return par1;
	}

}
