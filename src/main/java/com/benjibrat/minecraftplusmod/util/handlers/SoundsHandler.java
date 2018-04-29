package com.benjibrat.minecraftplusmod.util.handlers;

import com.benjibrat.minecraftplusmod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
	
public static SoundEvent ENTITY_BRAMBLE_HURT, ENTITY_BRAMBLE_DEATH;
	
	public static void registerSounds()
	{
		//ENTITY_BRAMBLE_AMBIENT = registerSound("entity.bramble.ambient");
		ENTITY_BRAMBLE_HURT = registerSound("entity.bramble.hurt");
		ENTITY_BRAMBLE_DEATH = registerSound("entity.bramble.death");
	}
	
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
}

}
