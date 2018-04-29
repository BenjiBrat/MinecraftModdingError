package com.benjibrat.minecraftplusmod.blocks;

import java.util.Random;

import com.benjibrat.minecraftplusmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IronMeshBlock extends BlockBase{

	public IronMeshBlock(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(5.0f);
		setResistance(1.0f);
		setHarvestLevel("pickaxe", 0);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.IRON_INGOT;
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		return 3 + rand.nextInt(2);
	}
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

}
