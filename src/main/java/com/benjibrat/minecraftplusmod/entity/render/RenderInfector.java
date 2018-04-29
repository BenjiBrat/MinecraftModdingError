package com.benjibrat.minecraftplusmod.entity.render;

import com.benjibrat.minecraftplusmod.entity.EntityInfector;
import com.benjibrat.minecraftplusmod.entity.EntitySporeager;
import com.benjibrat.minecraftplusmod.entity.model.ModelInfector;
import com.benjibrat.minecraftplusmod.entity.model.ModelSporeager;
import com.benjibrat.minecraftplusmod.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderInfector extends RenderLiving<EntityInfector>{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/infector.png");
	
	public RenderInfector(RenderManager manager) {
		super(manager, new ModelInfector(), 0.5f);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityInfector entity) 
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityInfector entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
	
}
