package com.simonk0403.blockybeavers;

import com.simonk0403.blockybeavers.entity.BeaverEntity;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockyBeavers implements ModInitializer {
	public static final String MOD_ID = "blockybeavers";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Blocky Beavers loading...");
		BlockyBeaversEntities.initialize();
		LOGGER.info("Blocky Beavers loaded");
	}
}