package com.benjibrat.minecraftplusmod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelVillager - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelSporeager extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer rightArm;
    public ModelRenderer leftArm;
    public ModelRenderer armConnect;
    public ModelRenderer leftLeg;
    public ModelRenderer bodyInner;
    public ModelRenderer bodyOuter;
    public ModelRenderer rightLeg;
    public ModelRenderer nose;
    public ModelRenderer mushroom;

    public ModelSporeager(float scale)
    {
        this();
    }
    public ModelSporeager() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.rightArm = new ModelRenderer(this, 44, 22);
        this.rightArm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.rightArm.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotation(rightArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.leftArm = new ModelRenderer(this, 44, 22);
        this.leftArm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.leftArm.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotation(leftArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.mushroom = new ModelRenderer(this, 24, 64);
        this.mushroom.setRotationPoint(-5.0F, -11.0F, -5.0F);
        this.mushroom.addBox(0.0F, 0.0F, 0.0F, 10, 5, 10, 0.0F);
        this.armConnect = new ModelRenderer(this, 40, 38);
        this.armConnect.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.armConnect.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotation(armConnect, -0.7499679795819634F, 0.0F, 0.0F);
        this.leftLeg = new ModelRenderer(this, 0, 22);
        this.leftLeg.mirror = true;
        this.leftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bodyInner = new ModelRenderer(this, 16, 20);
        this.bodyInner.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyInner.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.bodyOuter = new ModelRenderer(this, 0, 38);
        this.bodyOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyOuter.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.nose = new ModelRenderer(this, 24, 0);
        this.nose.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.nose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.head = new ModelRenderer(this, 0, 4);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
        this.rightLeg = new ModelRenderer(this, 0, 22);
        this.rightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.rightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.head.addChild(this.mushroom);
        this.head.addChild(this.nose);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    	super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.rightArm.render(f5);
        this.leftArm.render(f5);
        this.armConnect.render(f5);
        this.leftLeg.render(f5);
        this.bodyInner.render(f5);
        this.bodyOuter.render(f5);
        this.head.render(f5);
        this.rightLeg.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.rightLeg.rotateAngleY = 0.0F;
        this.leftLeg.rotateAngleY = 0.0F;
    }
}
