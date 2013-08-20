package trs.someluigi.tslblocks.block;

import java.util.List;
import java.util.Random;

import trs.someluigi.tslblocks.ref.ModInst;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.Icon;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDyedIce extends Block {
	
	public BlockDyedIce(int par1, Material par2Material) {
		super(par1, par2Material);
		this.slipperiness = 0.98F;
		this.setTickRandomly(true);
		this.setHardness(0.5F);
		this.setLightOpacity(3);
		this.setStepSound(soundGlassFootstep);
		this.setCreativeTab(ModInst.modCtab);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int j = 0; j < 16; ++j) {
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
		if (ItemBlockDyedIce.icons.length-1 >= meta) {
			return ItemBlockDyedIce.icons[meta];
		}
		return ModInst.iOne.itemIcon;
	}
	
	@Override
	public int damageDropped(int par1) {
		return par1;
	}
	
	

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass() {
		return 1;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates.  Args: blockAccess, x, y, z, side
	 */
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
	}

	/**
	 * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
	 * block and l is the block's subtype/damage.
	 */
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	{
		par2EntityPlayer.addStat(StatList.mineBlockStatArray[this.blockID], 1);
		par2EntityPlayer.addExhaustion(0.025F);

		if (this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(par2EntityPlayer)) {
			ItemStack itemstack = this.createStackedBlock(par6);

			if (itemstack != null) {
				this.dropBlockAsItem_do(par1World, par3, par4, par5, itemstack);
			}
		} else {
			int i1 = EnchantmentHelper.getFortuneModifier(par2EntityPlayer);
			this.dropBlockAsItem(par1World, par3, par4, par5, par6, i1);
			Material material = par1World.getBlockMaterial(par3, par4 - 1, par5);

			if (material.blocksMovement() || material.isLiquid()) {
				par1World.setBlock(par3, par4, par5, Block.waterMoving.blockID); // TODO this will later be "dyed water"
			}
		}
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (par1World.getSavedLightValue(EnumSkyBlock.Block, par2, par3, par4) > 10) {
			this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.setBlock(par2, par3, par4, Block.waterStill.blockID); // TODO this will later be "dyed water"
		}
	}

	/**
	 * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
	 * and stop pistons
	 */
	public int getMobilityFlag()
	{
		return 0;
	}

}
