package com.benjibrat.minecraftplusmod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelWatcher - BenjiBrat
 * Created using Tabula 4.1.1
 */
public class ModelWatcher extends ModelBase {
    public ModelRenderer armRight;
    public ModelRenderer legLeft;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer armLeft;
    public ModelRenderer legRight;
    public ModelRenderer eye;

    public ModelWatcher() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.armRight = new ModelRenderer(this, 36, 8);
        this.armRight.setRotationPoint(-3.0F, 2.0F, 0.0F);
        this.armRight.addBox(-3.0F, -2.0F, -1.0F, 2, 20, 2, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.body = new ModelRenderer(this, 8, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -1.0F, 8, 12, 2, 0.0F);
        this.armLeft = new ModelRenderer(this, 36, 8);
        this.armLeft.mirror = true;
        this.armLeft.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.armLeft.addBox(-1.0F, -2.0F, -1.0F, 2, 20, 2, 0.0F);
        this.legRight = new ModelRenderer(this, 0, 16);
        this.legRight.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.legRight.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.eye = new ModelRenderer(this, 34, 0);
        this.eye.setRotationPoint(0.0F, -4.5F, -4.8F);
        this.eye.addBox(-3.0F, -3.0F, 0.0F, 6, 7, 1, 0.0F);
        this.legLeft = new ModelRenderer(this, 0, 16);
        this.legLeft.mirror = true;
        this.legLeft.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.legLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.head.addChild(this.eye);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.armRight.render(f5);
        this.head.render(f5);
        this.body.render(f5);
        this.armLeft.render(f5);
        this.legRight.render(f5);
        this.legLeft.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.legRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.legLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.legRight.rotateAngleY = 0.0F;
        this.legLeft.rotateAngleY = 0.0F;
        this.armRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.armLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.armRight.rotateAngleY = 0.0F;
        this.armLeft.rotateAngleY = 0.0F;
    }
}
