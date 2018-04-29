package com.benjibrat.minecraftplusmod.util.handlers;

import com.benjibrat.minecraftplusmod.entity.EntityBramble;
import com.benjibrat.minecraftplusmod.entity.EntityInfector;
import com.benjibrat.minecraftplusmod.entity.EntitySporeager;
import com.benjibrat.minecraftplusmod.entity.EntityWatcher;
import com.benjibrat.minecraftplusmod.entity.render.RenderBramble;
import com.benjibrat.minecraftplusmod.entity.render.RenderInfector;
import com.benjibrat.minecraftplusmod.entity.render.RenderSporeager;
import com.benjibrat.minecraftplusmod.entity.render.RenderWatcher;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

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
		System.out.println("RenderRegistry 1");
	}
}
