package com.benjibrat.minecraftplusmod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Infector - BenjiBrat
 * Created using Tabula 4.1.1
 */
public class ModelInfector extends ModelBase {
    public ModelRenderer bodyLower;
    public ModelRenderer legLeft;
    public ModelRenderer legRight;
    public ModelRenderer head;
    public ModelRenderer bodyUpper;
    public ModelRenderer armLeft;
    public ModelRenderer armRight;
    public ModelRenderer handLeft;
    public ModelRenderer handRight;
    public ModelRenderer footLeft;
    public ModelRenderer footLeft_1;
    public ModelRenderer mushroomTop1;
    public ModelRenderer mushroomTop2;
    public ModelRenderer mushroomTop3;

    public ModelInfector() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.mushroomTop1 = new ModelRenderer(this, 48, 12);
        this.mushroomTop1.setRotationPoint(-2.0F, -6.0F, -2.0F);
        this.mushroomTop1.addBox(-3.0F, -2.0F, -3.0F, 10, 2, 10, 0.0F);
        this.legRight = new ModelRenderer(this, 0, 32);
        this.legRight.setRotationPoint(-3.0F, 8.0F, 0.0F);
        this.legRight.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(legRight, -0.08726646259971647F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 40, 0);
        this.head.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
        this.footLeft = new ModelRenderer(this, 0, 32);
        this.footLeft.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.footLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(footLeft, 0.08726646259971647F, 0.0F, 0.0F);
        this.legLeft = new ModelRenderer(this, 0, 32);
        this.legLeft.setRotationPoint(3.0F, 8.0F, 0.0F);
        this.legLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(legLeft, -0.08726646259971647F, 0.0F, 0.0F);
        this.armRight = new ModelRenderer(this, 0, 32);
        this.armRight.setRotationPoint(-7.0F, -2.0F, 0.0F);
        this.armRight.addBox(-4.0F, -1.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(armRight, 0.17453292519943295F, 0.0F, 0.0F);
        this.handRight = new ModelRenderer(this, 0, 32);
        this.handRight.setRotationPoint(-2.0F, 6.8F, 0.0F);
        this.handRight.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(handRight, -0.3490658503988659F, 0.0F, 0.0F);
        this.bodyLower = new ModelRenderer(this, 0, 0);
        this.bodyLower.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.bodyLower.addBox(-6.0F, -8.0F, -4.0F, 12, 8, 8, 0.0F);
        this.mushroomTop3 = new ModelRenderer(this, 48, 36);
        this.mushroomTop3.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.mushroomTop3.addBox(-3.0F, -2.0F, -3.0F, 6, 2, 6, 0.0F);
        this.bodyUpper = new ModelRenderer(this, 0, 16);
        this.bodyUpper.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.bodyUpper.addBox(-7.0F, -6.0F, -5.0F, 14, 6, 10, 0.0F);
        this.armLeft = new ModelRenderer(this, 0, 32);
        this.armLeft.setRotationPoint(7.0F, -2.0F, 0.0F);
        this.armLeft.addBox(0.0F, -1.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(armLeft, 0.17453292519943295F, 0.0F, 0.0F);
        this.mushroomTop2 = new ModelRenderer(this, 48, 24);
        this.mushroomTop2.setRotationPoint(2.0F, -2.0F, 2.0F);
        this.mushroomTop2.addBox(-4.0F, -2.0F, -4.0F, 8, 2, 8, 0.0F);
        this.footLeft_1 = new ModelRenderer(this, 0, 32);
        this.footLeft_1.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.footLeft_1.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(footLeft_1, 0.08726646259971647F, 0.0F, 0.0F);
        this.handLeft = new ModelRenderer(this, 0, 32);
        this.handLeft.setRotationPoint(2.0F, 6.8F, 0.0F);
        this.handLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(handLeft, -0.3490658503988659F, 0.0F, 0.0F);
        this.head.addChild(this.mushroomTop1);
        this.legLeft.addChild(this.footLeft);
        this.bodyUpper.addChild(this.armRight);
        this.armRight.addChild(this.handRight);
        this.mushroomTop2.addChild(this.mushroomTop3);
        this.bodyLower.addChild(this.bodyUpper);
        this.bodyUpper.addChild(this.armLeft);
        this.mushroomTop1.addChild(this.mushroomTop2);
        this.legRight.addChild(this.footLeft_1);
        this.armLeft.addChild(this.handLeft);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	
    	this.legRight.render(f5);
        this.head.render(f5);
        this.legLeft.render(f5);
        this.bodyLower.render(f5);
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
