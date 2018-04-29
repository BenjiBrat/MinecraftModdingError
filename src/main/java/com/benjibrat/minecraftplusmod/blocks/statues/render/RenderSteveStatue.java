package com.benjibrat.minecraftplusmod.blocks.statues.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.benjibrat.minecraftplusmod.entity.model.ModelStatueSteve;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderSteveStatue extends TileEntitySpecialRenderer{
	ModelStatueSteve model;
	  
	   public RenderSteveStatue()
	   {
		  //super();
		  model = new ModelStatueSteve();
	   }
	  
	   public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f)
	   {
		  renderExtractorModelAt(d0,d1,d2,f);
		 
	   }
	   private void renderExtractorModelAt(double d, double d1, double d2, float f)
	   {
	  /*  int i = 0;
		  if(te.worldObj != null)
		  {
			 i = (te.worldObj.getBlockMetadata(te.xCoord, te.yCoord, te.zCoord));
		  }*/
					  //directory of the model's texture file
	    bindTexture("/textures/blocks/statues/stevestat.png");
	    GL11.glPushMatrix();
	    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		   GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		   GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.0F, (float)d2 + 0.5F);
		   GL11.glScalef(1.0F, -1.0F, -1.0F);
		    //GL11.glTranslatef(0.5F, 1.0F, 0.5F);
		   model.render(0.0625F);
		   GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		   GL11.glPopMatrix();
		   GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	   }

	private void bindTexture(String string) {
		// TODO Auto-generated method stub
		
	}
}
