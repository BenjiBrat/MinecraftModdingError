package com.benjibrat.minecraftplusmod.init;

import com.benjibrat.minecraftplusmod.Main;
import com.benjibrat.minecraftplusmod.entity.EntityBramble;
import com.benjibrat.minecraftplusmod.entity.EntityInfector;
import com.benjibrat.minecraftplusmod.entity.EntitySporeager;
import com.benjibrat.minecraftplusmod.entity.EntityWatcher;
import com.benjibrat.minecraftplusmod.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.gen.MapGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("bramble", EntityBramble.class, Reference.ENTITY_BRAMBLE, 50, 0, 3241275);
		registerEntity("sporeager", EntitySporeager.class, Reference.ENTITY_SPOREAGER, 51, 15276568, 7685673);
		registerEntity("infector", EntityInfector.class, Reference.ENTITY_INFECTOR, 52, 15276572, 7685673);
		registerEntity("watcher", EntityWatcher.class, Reference.ENTITY_WATCHER, 53, 1315860, 8305233);
		EntityRegistry.addSpawn(EntityBramble.class, 6, 1, 5, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.TAIGA, Biomes.COLD_TAIGA, Biomes.TAIGA_HILLS, Biomes.COLD_TAIGA_HILLS, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS);
		EntityRegistry.addSpawn(EntitySporeager.class, 50, 1, 8, EnumCreatureType.CREATURE, Biomes.MUSHROOM_ISLAND);
		EntityRegistry.addSpawn(EntityInfector.class,50, 1, 3, EnumCreatureType.MONSTER, Biomes.MUSHROOM_ISLAND);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}

}
