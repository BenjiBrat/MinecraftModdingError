package com.benjibrat.minecraftplusmod.init;

import java.util.ArrayList;
import java.util.List;

import com.benjibrat.minecraftplusmod.blocks.DraconiteOre;
import com.benjibrat.minecraftplusmod.blocks.IronMeshBlock;
import com.benjibrat.minecraftplusmod.blocks.SpikeBlock;
import com.benjibrat.minecraftplusmod.blocks.Test;
import com.benjibrat.minecraftplusmod.blocks.statues.StatueSteve;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block DRACONITE_ORE = new DraconiteOre("draconite_ore", Material.ROCK);
	public static final Block SPIKE = new SpikeBlock("spike_block", Material.IRON);
	public static final Block IRON_MESH = new IronMeshBlock("iron_mesh", Material.IRON);
	//public static final Block STATUE_STEVE = new StatueSteve("statue_steve", Material.ROCK);
	//public static final Block TEST = new Test("test", Material.IRON);
			
			
}
