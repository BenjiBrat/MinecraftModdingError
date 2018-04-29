package com.benjibrat.minecraftplusmod.blocks;

import java.util.Random;

import com.benjibrat.minecraftplusmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class DraconiteOre extends BlockBase{

	public DraconiteOre(String name, Material material) {
		
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(4.0f);
		setResistance(47.0f);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(4.0f);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.DRACONITE;
	}
	
	 @Override
	 public int quantityDropped(Random rand)
	 {
		 return 1 + rand.nextInt(2);
	 }
}
