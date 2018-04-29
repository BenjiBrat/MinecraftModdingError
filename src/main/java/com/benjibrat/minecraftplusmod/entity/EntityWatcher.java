package com.benjibrat.minecraftplusmod.entity;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityVindicator;
//import net.minecraft.entity.monster.EntityEnderman.AIFindPlayer;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityWatcher extends EntityMob{

	public EntityWatcher(World worldIn) {
		super(worldIn);
		this.setSize(0.6f, 1.9f);
		this.setPathPriority(PathNodeType.WATER, -1.0F);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void initEntityAI() {
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityWatcher.class}));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        //this.tasks.addTask(9, new EntityAIAvoidEntity(this, EntityPlayer.class, 10.0f, 0.8D, 0.8D));
        //this.tasks.addTask(9, new EntityAIFollow(this, interpTargetPitch, maximumHomeDistance, maximumHomeDistance));
	}
	
	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.31);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
    }
	
	protected void applyEntityAI() {
		
	}
	
	
	
	public float getEyeHeight()
    {
        return 1.55F;
    }

	public void onLivingUpdate()
    {
        if (this.world.isRemote)
        {
            for (int i = 0; i < 2; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            }
            
            
        }
        
        this.isJumping = false;
        super.onLivingUpdate();
    }
	public boolean attackEntityAsMob(EntityPlayer player)
    {
		if(!this.world.isRemote) {
		System.out.print("ATTACK BOOL");
        if (super.attackEntityAsMob(player))
        {
        	System.out.println("SUPER.ATTACK");
        	if (player instanceof EntityLivingBase)
            {
        		System.out.println("INSTANCEOF");
                int i = 1;
                if (this.world.getDifficulty() == EnumDifficulty.EASY)
                {
                    i = 3;
                }
                if (this.world.getDifficulty() == EnumDifficulty.NORMAL)
                {
                    i = 4;
                }
                else if (this.world.getDifficulty() == EnumDifficulty.HARD)
                {
                    i = 5;
                }

                if (i > 0)
                {
                	Random slotRandom = new Random();
                	int slotHigh = 3;
                	int slotLow = 0;
                	int randomSlotInt = slotRandom.nextInt(slotHigh) + slotLow;
                	Random chanceRandom = new Random();
                	int chanceHigh = 5;
                	int chanceLow = 1;
                	int randomInt = chanceRandom.nextInt(chanceHigh) + chanceLow;
                	/*Random r = new Random();
                	int i1 = r.nextInt(4 - 0) + 0;
                	int i2 = r.nextInt(101 - 1) + 1;*/
                	ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                	System.out.println("int i > 0");
                	System.out.println(itemstack);
                	
                	if (randomInt == 1) {
	                    if (1 == 1 && randomSlotInt == 0 /*&& i2 < 20*/)
	                    {
	                    	EntityItem entityitem = new EntityItem(this.world, player.posX, player.posY+1, player.posZ, itemstack);
	                    	player.setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
	        				
	        				System.out.println(entityitem);
	        				entityitem.setPickupDelay(i);
	        				this.world.spawnEntity(entityitem);
	                    }
	                    
	                    ItemStack itemstack2 = this.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
	                	
	                    if (itemstack2 != null && randomSlotInt == 1/*&& i2 < 20*/)
	                    {
	                    	EntityItem entityitem2 = new EntityItem(player.world, player.posX, player.posY+1, player.posZ, itemstack2);
	                    	player.setItemStackToSlot(EntityEquipmentSlot.CHEST, ItemStack.EMPTY);
	        				
	        				entityitem2.setPickupDelay(i);
	        				this.world.spawnEntity(entityitem2);
	                    }
	                    
	                    ItemStack itemstack3 = this.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
	                	
	                    if (itemstack3 != null && randomSlotInt == 2/*&& i2 < 20*/)
	                    {
	                    	EntityItem entityitem3 = new EntityItem(player.world, player.posX, player.posY+1, player.posZ, itemstack3);
	                    	player.setItemStackToSlot(EntityEquipmentSlot.LEGS, ItemStack.EMPTY);
	        				
	        				entityitem3.setPickupDelay(i);
	        				this.world.spawnEntity(entityitem3);
	                    }
	                	
	                    ItemStack itemstack4 = this.getItemStackFromSlot(EntityEquipmentSlot.FEET);
	                	
	                    if (itemstack4 != null && randomSlotInt == 3/*&& i2 < 20*/)
	                    {
	                    	EntityItem entityitem4 = new EntityItem(player.world, player.posX, player.posY+1, player.posZ, itemstack4);
	                    	player.setItemStackToSlot(EntityEquipmentSlot.FEET, ItemStack.EMPTY);
	        				
	        				entityitem4.setPickupDelay(i);
	        				this.world.spawnEntity(entityitem4);
	                    }
                	
                	}
                	
                }
            }
        	}
            return true;
        }
        else
        {
            return false;
        }

 
		
	
    }
}

