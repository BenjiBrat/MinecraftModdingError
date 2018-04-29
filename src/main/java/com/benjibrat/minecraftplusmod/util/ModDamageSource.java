package com.benjibrat.minecraftplusmod.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;

public class ModDamageSource extends DamageSource{
	
	public static final DamageSource SPIKE = new DamageSource("spike");
	
	
	protected ModDamageSource(String par1Str) 
	{
		super(par1Str);
	}

	public static final DamageSource causeSpikeDamage(Entity par0Entity, Entity par1Entity)
	{
		return (new EntityDamageSourceIndirect("spike", par0Entity, par1Entity));
	}

	public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn)
	    {
        EntityLivingBase entitylivingbase = entityLivingBaseIn.getAttackingEntity();
        String s = "death.attack." + this.damageType;
        String s1 = s + ".player";
        return entitylivingbase != null && I18n.canTranslate(s1) ? new TextComponentTranslation(s1, new Object[] {entityLivingBaseIn.getDisplayName(), entitylivingbase.getDisplayName()}) : new TextComponentTranslation(s, new Object[] {entityLivingBaseIn.getDisplayName()});
	    }
	}

