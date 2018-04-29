package com.benjibrat.minecraftplusmod.util.handlers;

import java.util.Random;

import com.benjibrat.minecraftplusmod.init.ModBlocks;
import com.benjibrat.minecraftplusmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.entity.passive.EntityVillager.PriceInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Reference.MOD_ID)
public class CustomProfesionsHandler {
	
	
	// instantiate Professions
	public final static VillagerProfession mechanic = null;
	public final static VillagerProfession minerProf = null;
	
	// declare Careers
	public static VillagerCareer redstoner;
	public static VillagerCareer engineer;
	public static VillagerCareer trapper;
	public static VillagerCareer miner;
	
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler{
		
		@SubscribeEvent
		public static void onEvent(final RegistryEvent.Register<VillagerProfession> event) {
			final IForgeRegistry<VillagerProfession> registry = event.getRegistry();

            // DEBUG
            System.out.println("Registering villager professions");
            
            registry.register(new VillagerProfession(
            	Reference.MOD_ID+":mechanic", 
            	Reference.MOD_ID+":textures/entity/villager/mechanic.png", 
            	Reference.MOD_ID+":textures/entity/zombie_villager/mechanic.png"
            	)
            );
            
            registry.register(new VillagerProfession(
                	Reference.MOD_ID+":minerProf", 
                	Reference.MOD_ID+":textures/entity/villager/miner.png", 
                	Reference.MOD_ID+":textures/entity/zombie_villager/miner.png"
                	)
                );
		}
	}
	
	public static void associateCareersAndTrades()
	{
		// DEBUG
		System.out.println("Associating careers and trades to villager professions");
		
		redstoner = (new VillagerCareer(mechanic, "redstoner")).addTrade(1, new TradeEmeraldsForItems(Items.REDSTONE, new EntityVillager.PriceInfo(1, 3))).addTrade(2, new TradeEmeraldsForBlocks(Blocks.REDSTONE_TORCH, new EntityVillager.PriceInfo(2, 3))).addTrade(2, new TradeEmeraldsForItems(Items.REPEATER, new EntityVillager.PriceInfo(3,4))).addTrade(3, new TradeEmeraldsForBlocks(Blocks.REDSTONE_BLOCK, new EntityVillager.PriceInfo(1,4))).addTrade(2, new TradeItemsForEmeralds(Items.REDSTONE, new EntityVillager.PriceInfo(4, 5)));
		engineer = (new VillagerCareer(mechanic, "engineer")).addTrade(1, new TradeEmeraldsForBlocks(Blocks.PISTON, new EntityVillager.PriceInfo(2, 3))).addTrade(1, new TradeEmeraldsForBlocks(Blocks.REDSTONE_LAMP, new EntityVillager.PriceInfo(1, 2))).addTrade(2, new TradeEmeraldsForBlocks(Blocks.STICKY_PISTON, new EntityVillager.PriceInfo(3, 4))).addTrade(2, new TradeEmeraldsForBlocks(Blocks.DROPPER, new EntityVillager.PriceInfo(2, 4))).addTrade(3, new TradeEmeraldsForItems(Items.COMPARATOR, new EntityVillager.PriceInfo(3, 5))).addTrade(3, new TradeEmeraldsForBlocks(Blocks.HOPPER, new EntityVillager.PriceInfo(2,4)));
		trapper = (new VillagerCareer(mechanic, "trapper")).addTrade(1, new TradeEmeraldsForBlocks(ModBlocks.SPIKE, new EntityVillager.PriceInfo(3, 4))).addTrade(2,  new TradeEmeraldsForBlocks(Blocks.DISPENSER, new EntityVillager.PriceInfo(3, 6))).addTrade(1, new TradeEmeraldsForBlocks(Blocks.WOODEN_PRESSURE_PLATE, new EntityVillager.PriceInfo(1, 3))).addTrade(2, new TradeEmeraldsForBlocks(Blocks.STONE_PRESSURE_PLATE, new EntityVillager.PriceInfo(3, 4))).addTrade(2, new TradeEmeraldsForBlocks(Blocks.TRIPWIRE_HOOK, new EntityVillager.PriceInfo(2, 3))).addTrade(1, new TradeBlocksForEmeralds(Blocks.WOODEN_PRESSURE_PLATE, new EntityVillager.PriceInfo(3, 4)));
		miner = (new VillagerCareer(minerProf, "miner")).addTrade(1, new TradeEmeraldsForMultipleBlocks(Blocks.IRON_ORE, new EntityVillager.PriceInfo(2,3))).addTrade(1, new TradeEmeraldsForMultipleItems(Items.IRON_INGOT, new EntityVillager.PriceInfo(2,3))).addTrade(2, new EntityVillager.ListItemForEmeralds(Items.IRON_INGOT, new EntityVillager.PriceInfo(-7, -5))).addTrade(3, new EntityVillager.ListEnchantedItemForEmeralds(Items.IRON_PICKAXE, new EntityVillager.PriceInfo(20, 22)));
	}
	
	public static class TradeEmeraldsForItems implements ITradeList
	{
		public Item stack;
		public EntityVillager.PriceInfo priceInfo;
		
		public TradeEmeraldsForItems(Item itemIn, EntityVillager.PriceInfo priceIn) {
			this.stack = itemIn;
			this.priceInfo = priceIn;
		}
		@Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;
            int payPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
                //payPrice = priceInfo.getPrice(random);
            }
            

            ItemStack stackToPay = new ItemStack(Items.EMERALD, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, new ItemStack(this.stack, payPrice, 0)));
            
            // DEBUG
            System.out.println("Merchant recipe list = "+recipeList.getRecipiesAsTags());
        }
		
	}
	
	public static class TradeEmeraldsForBlocks implements ITradeList
	{
		public Block stack;
		public EntityVillager.PriceInfo priceInfo;
		
		public TradeEmeraldsForBlocks(Block blockIn, EntityVillager.PriceInfo priceIn) {
			this.stack = blockIn;
			this.priceInfo = priceIn;
		}
		@Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
            }

            ItemStack stackToPay = new ItemStack(Items.EMERALD, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, new ItemStack(this.stack, 1, 0)));
            
            // DEBUG
            System.out.println("Merchant recipe list = "+recipeList.getRecipiesAsTags());
        }
		
	}
	
	public static class TradeItemsForEmeralds implements ITradeList
	{
		public Item stack;
		public EntityVillager.PriceInfo priceInfo;
		
		public TradeItemsForEmeralds(Item itemIn, EntityVillager.PriceInfo priceIn) {
			this.stack = itemIn;
			this.priceInfo = priceIn;
		}
		@Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;
            int payPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
                //payPrice = priceInfo.getPrice(random);
            }
            

            ItemStack stackToPay = new ItemStack(this.stack, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, new ItemStack(Items.EMERALD, payPrice, 0)));
            
            // DEBUG
            System.out.println("Merchant recipe list = "+recipeList.getRecipiesAsTags());
        }
		
	}
	
	public static class TradeBlocksForEmeralds implements ITradeList
	{
		public Block stack;
		public EntityVillager.PriceInfo priceInfo;
		
		public TradeBlocksForEmeralds(Block blockIn, EntityVillager.PriceInfo priceIn) {
			this.stack = blockIn;
			this.priceInfo = priceIn;
		}
		@Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
            }

            ItemStack stackToPay = new ItemStack(this.stack, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, new ItemStack(Items.EMERALD, 1, 0)));
            
            // DEBUG
            System.out.println("Merchant recipe list = "+recipeList.getRecipiesAsTags());
        }
		
	}
	
	public static class TradeEmeraldsForMultipleItems implements ITradeList
	{
		public Item stack;
		public EntityVillager.PriceInfo priceInfo;
		
		public TradeEmeraldsForMultipleItems(Item itemIn, EntityVillager.PriceInfo priceIn) {
			this.stack = itemIn;
			this.priceInfo = priceIn;
		}
		@Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;
            int payPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
                payPrice = actualPrice * priceInfo.getPrice(random);
            }
            

            ItemStack stackToPay = new ItemStack(Items.EMERALD, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, new ItemStack(this.stack, payPrice, 0)));
            
            // DEBUG
            System.out.println("Merchant recipe list = "+recipeList.getRecipiesAsTags());
        }
		
	}
	
	public static class TradeEmeraldsForMultipleBlocks implements ITradeList
	{
		public Block stack;
		public EntityVillager.PriceInfo priceInfo;
		
		public TradeEmeraldsForMultipleBlocks(Block itemIn, EntityVillager.PriceInfo priceIn) {
			this.stack = itemIn;
			this.priceInfo = priceIn;
		}
		@Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;
            int payPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
                payPrice = actualPrice * priceInfo.getPrice(random);
            }
            

            ItemStack stackToPay = new ItemStack(Items.EMERALD, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, new ItemStack(this.stack, payPrice, 0)));
            
            // DEBUG
            System.out.println("Merchant recipe list = "+recipeList.getRecipiesAsTags());
        }
		
	}
	
}
