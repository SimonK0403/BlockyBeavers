package com.simonk0403.blockybeavers;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockyBeavers implements ModInitializer {
	public static final String MOD_ID = "blockybeavers";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("BlockyBeavers loading...");
		LOGGER.info("Loading entities...");
		BlockyBeaversEntities.initialize();
		LOGGER.info("Loading items...");
		BlockyBeaversItems.initialize();
		LOGGER.info("BlockyBeavers loaded");
	}
}