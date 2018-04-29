package com.benjibrat.minecraftplusmod.entity.render;

import com.benjibrat.minecraftplusmod.entity.EntityBramble;
import com.benjibrat.minecraftplusmod.entity.EntitySporeager;
import com.benjibrat.minecraftplusmod.entity.model.ModelSporeager;
import com.benjibrat.minecraftplusmod.entity.model.ModelBramble;
import com.benjibrat.minecraftplusmod.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;

public class RenderSporeager extends RenderLiving<EntitySporeager>{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/sporeager.png");
	
	public RenderSporeager(RenderManager manager) {
		super(manager, new ModelSporeager(), 0.5f);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySporeager entity) 
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntitySporeager entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
	
	protected void preRenderCallback(EntitySporeager entitylivingbaseIn, float partialTickTime)
    {
        float f = 0.9375F;

        if (entitylivingbaseIn.getGrowingAge() < 0)
        {
            f = (float)((double)f * 0.5D);
            this.shadowSize = 0.25F;
        }
        else
        {
            this.shadowSize = 0.5F;
        }

        GlStateManager.scale(f, f, f);
    }
}
