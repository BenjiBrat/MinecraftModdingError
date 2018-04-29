package com.benjibrat.minecraftplusmod.entity.render;

import com.benjibrat.minecraftplusmod.entity.EntityWatcher;
import com.benjibrat.minecraftplusmod.entity.model.ModelWatcher;
import com.benjibrat.minecraftplusmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWatcher extends RenderLiving<EntityWatcher>{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/watcher.png");
	
	public RenderWatcher(RenderManager manager) {
		super(manager, new ModelWatcher(), 0.5f);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityWatcher entity) 
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityWatcher entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
	
	protected void preRenderCallback(EntityWatcher entitylivingbaseIn, float partialTickTime)
    {
        //float f = 0.9375F;

        this.shadowSize = 0.5F;

        
    }
}

