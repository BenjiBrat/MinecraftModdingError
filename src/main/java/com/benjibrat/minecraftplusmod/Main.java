package com.benjibrat.minecraftplusmod;

import com.benjibrat.minecraftplusmod.WorldGen.ModWorldGenerator;
import com.benjibrat.minecraftplusmod.blocks.statues.render.RenderSteveStatue;
import com.benjibrat.minecraftplusmod.blocks.statues.tileEntities.TileStatueSteve;
import com.benjibrat.minecraftplusmod.entity.EntityBramble;
import com.benjibrat.minecraftplusmod.init.EntityInit;
import com.benjibrat.minecraftplusmod.init.ModCrafting;
import com.benjibrat.minecraftplusmod.init.ModItems;
import com.benjibrat.minecraftplusmod.proxy.ClientProxy;
import com.benjibrat.minecraftplusmod.proxy.CommonProxy;
import com.benjibrat.minecraftplusmod.util.Reference;
import com.benjibrat.minecraftplusmod.util.handlers.CustomProfesionsHandler;
import com.benjibrat.minecraftplusmod.util.handlers.RenderHandler;
import com.benjibrat.minecraftplusmod.util.handlers.SoundsHandler;
import net.minecraft.block.Block;
import net.minecraft.client.resources.Language;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
		ClientProxy.registerEntityRenders();
		SoundsHandler.registerSounds();
		System.out.println("RenderHandler on Main");
		ModCrafting.register();
		//GameRegistry.addShapedRecipe(null, null, new ItemStack(Blocks.END_STONE, 64), new Object[] { "W $", " S ", "s E", 'W', new ItemStack(Blocks.PLANKS, 1, 2), '$', Items.STICK, 'S', Blocks.SAND, 's', Blocks.SAPLING, 'E', Items.ENDER_PEARL });
		
		GameRegistry.registerWorldGenerator(new ModWorldGenerator(), 0); 
			      
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		//ClientRegistry.bindTileEntitySpecialRenderer(TileStatueSteve.class, new RenderSteveStatue());
		//GameRegistry.registerTileEntity(TileStatueSteve.class, "StatueSteve");
		//System.out.println("REGISTER TILEENTITY ON MAIN");
		CustomProfesionsHandler.associateCareersAndTrades();
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
		
	}
	
	
}
