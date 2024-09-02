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

	public static final EntityType<BeaverEntity> BEAVER = Registry.register(
			Registries.ENTITY_TYPE,
			Identifier.of(MOD_ID, "beaver"),
			EntityType.Builder.create(BeaverEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.75f).build("beaver")
	);

	@Override
	public void onInitialize() {
		LOGGER.info("Blocky Beavers loading...");
		FabricDefaultAttributeRegistry.register(BEAVER, BeaverEntity.createBeaverAttributes());
		LOGGER.info("Blocky Beavers loaded");
	}
}