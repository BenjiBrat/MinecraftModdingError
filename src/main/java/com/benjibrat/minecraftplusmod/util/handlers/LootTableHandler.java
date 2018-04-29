package com.benjibrat.minecraftplusmod.util.handlers;

import com.benjibrat.minecraftplusmod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {
	public static final ResourceLocation BRAMBLE = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "bramble"));
	public static final ResourceLocation SPOREAGER = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "sporeager"));
	public static final ResourceLocation INFECTOR = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "infector"));
}
