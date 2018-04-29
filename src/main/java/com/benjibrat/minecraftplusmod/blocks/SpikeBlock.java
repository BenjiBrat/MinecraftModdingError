package com.benjibrat.minecraftplusmod.blocks;

import java.util.Random;

import com.benjibrat.minecraftplusmod.util.ModDamageSource;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SpikeBlock extends BlockBase{

	
	protected static final AxisAlignedBB SPIKE_COLLISION_AABB = new AxisAlignedBB(0.125D, 0.125D, 0.125D, 0.875D, 0.875D, 0.875D);
    protected static final AxisAlignedBB SPIKE_AABB = new AxisAlignedBB(0.125D, 0.125D, 0.125D, 0.875D, 0.875D, 0.875D);
	public SpikeBlock(String name, Material material) {
		super(name, material);
		this.setTickRandomly(true);
		setSoundType(SoundType.STONE);
		setHardness(4.0f);
		setResistance(3.5f);
		setHarvestLevel("pickaxe", 0);
		setLightLevel(0.0f);
		setCreativeTab(CreativeTabs.REDSTONE);
	}
	
	 public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	    {
	        return SPIKE_COLLISION_AABB;
	    }

	    /**
	     * Return an AABB (in world coords!) that should be highlighted when the player is targeting this Block
	     */
	    @SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	{
	    return SPIKE_AABB.offset(pos);
	}
    /*public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.attackEntityFrom(null, 1);
    }*/
	public boolean isFullCube(IBlockState state)
	{
	    return false;
	}
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.attackEntityFrom(ModDamageSource.SPIKE, 1.0F);
    }

}
