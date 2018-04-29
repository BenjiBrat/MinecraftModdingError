package com.benjibrat.minecraftplusmod.blocks.statues;

import com.benjibrat.minecraftplusmod.blocks.BlockBase;
import com.benjibrat.minecraftplusmod.blocks.statues.tileEntities.TileStatueSteve;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StatueSteve extends BlockBase implements ITileEntityProvider{
	private static String name = "StatueSteve";
	protected static final AxisAlignedBB STATUE_COLLISION_AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 3D, 1D);
    protected static final AxisAlignedBB STATUE_AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 3D, 1D);
	public StatueSteve(String name, Material material) {
		
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(3.0f);
		setResistance(0.0f);
		setHarvestLevel("pickaxe", 0);
		setLightLevel(0.0f);
		setCreativeTab(CreativeTabs.DECORATIONS);
		this.hasTileEntity = true;
		// TODO Auto-generated constructor stub
	}
	
	public static String getName(){
		return name;
		}
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return STATUE_COLLISION_AABB;
    }

    /**
     * Return an AABB (in world coords!) that should be highlighted when the player is targeting this Block
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
    	return STATUE_AABB.offset(pos);
    }
    public boolean isFullCube(IBlockState state)
	{
	    return false;
	}
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileStatueSteve();
    }
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return true;
    }
    
    public boolean renderAsNormalBlock()
    {
    return false;
    }
    
    public int getRenderBlockPass()
    {
    return 1;
    }
    
    private TileStatueSteve getTE(World world, BlockPos pos) {
    	return (TileStatueSteve) world.getTileEntity(pos);
    }


}
