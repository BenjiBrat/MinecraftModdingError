package com.benjibrat.minecraftplusmod.blocks;

import com.benjibrat.minecraftplusmod.tileentities.TileTest;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRail;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Test extends BlockRail implements ITileEntityProvider {
	public static final PropertyEnum SHAPE = PropertyEnum.create("shape", BlockRailBase.EnumRailDirection.class);

	private static String name = "Test";

	public Test(String string, Material iron) {

	super();
	System.out.println("REGISTER TILEENTITY ON CLASS TEST");
	GameRegistry.registerTileEntity(TileTest.class, name);
	setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, BlockRailBase.EnumRailDirection.NORTH_SOUTH));
	//GameRegistry.registerBlock(this, name);
	//this.setCreativeTab(CreativeTabs.tabMisc);
	//this.setUnlocalizedName(name);
	this.setHardness(2.0f);
	this.setResistance(6.0f);
	this.setHarvestLevel("pickaxe", 2);
	//this.isBlockContainer = true;

	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
	return new TileTest();
	}



	public static String getName(){
	return name;
	}



	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
	{
	setBlockBoundsBasedOnState(worldIn, pos);
	return super.getSelectedBoundingBox(null, worldIn, pos);
	}

	public IProperty getShapeProperty()
	{
	return SHAPE;
	}



	public IBlockState getStateFromMeta(int meta)
	{
	return getDefaultState().withProperty(SHAPE, BlockRailBase.EnumRailDirection.byMetadata(meta));
	}

	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
	{

	this.setBlockBounds(-1.0F, 0.0F, -1.0F, 2.0F, 0.125F, 2.0F);

	}

	private void setBlockBounds(float f, float g, float h, float i, float j, float k) {
		// TODO Auto-generated method stub
		
	}

	public int getMetaFromState(IBlockState state)
	{
	return ((BlockRailBase.EnumRailDirection)state.getValue(SHAPE)).getMetadata();
	}

	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {SHAPE});
    }

	public boolean isOpaqueCube()
	{
	return false;
	}
	/**
	* If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	*/

	public boolean renderAsNormalBlock()
	{
	return false;
	}

	public int getRenderBlockPass()
	{
	return 1;
	}

	protected void onNeighborChangedInternal(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
	//whenever the blocks around it change
	}


}
