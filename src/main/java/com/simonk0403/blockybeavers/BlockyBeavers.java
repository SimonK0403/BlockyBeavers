package com.simonk0403.blockybeavers;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockyBeavers implements ModInitializer {
	public static final String MOD_ID = "blockybeavers";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Blocky Beavers loading...");
		BlockyBeaversEntities.initialize();
		BlockyBeaversItems.initialize();
		LOGGER.info("Blocky Beavers loaded");
	}
}