package com.benjibrat.minecraftplusmod.proxy;

import com.benjibrat.minecraftplusmod.entity.EntityBramble;
import com.benjibrat.minecraftplusmod.entity.EntityInfector;
import com.benjibrat.minecraftplusmod.entity.EntitySporeager;
import com.benjibrat.minecraftplusmod.entity.EntityWatcher;
import com.benjibrat.minecraftplusmod.entity.render.RenderBramble;
import com.benjibrat.minecraftplusmod.entity.render.RenderInfector;
import com.benjibrat.minecraftplusmod.entity.render.RenderSporeager;
import com.benjibrat.minecraftplusmod.entity.render.RenderWatcher;
import com.benjibrat.minecraftplusmod.util.handlers.RenderHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy 
{
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	public static void registerEntityRenders()
	{
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBramble.class, new IRenderFactory<EntityBramble>()
		{
			
			@Override
			public Render<? super EntityBramble> createRenderFor(RenderManager manager) 
			{
				return new RenderBramble(manager);
			}
			
		});
		RenderingRegistry.registerEntityRenderingHandler(EntitySporeager.class, new IRenderFactory<EntitySporeager>()
		{
			
			@Override
			public Render<? super EntitySporeager> createRenderFor(RenderManager manager) 
			{
				return new RenderSporeager(manager);
			}
			
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityInfector.class, new IRenderFactory<EntityInfector>()
		{
			
			@Override
			public Render<? super EntityInfector> createRenderFor(RenderManager manager) 
			{
				return new RenderInfector(manager);
			}
			
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityWatcher.class, new IRenderFactory<EntityWatcher>()
		{
			
			@Override
			public Render<? super EntityWatcher> createRenderFor(RenderManager manager) 
			{
				return new RenderWatcher(manager);
			}
			
		});
		System.out.println("RenderRegistry 1 on Client");
	}
}
