package com.simonk0403.blockybeavers;

import com.simonk0403.blockybeavers.model.BeaverEntityModel;
import com.simonk0403.blockybeavers.renderer.BeaverEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import static com.simonk0403.blockybeavers.BlockyBeaversEntities.BEAVER_ID;

public class BlockyBeaversClient implements ClientModInitializer {
	public static final EntityModelLayer MODEL_BEAVER_LAYER = new EntityModelLayer(Identifier.of(BlockyBeavers.MOD_ID, BEAVER_ID), "main");
	public static final EntityModelLayer MODEL_BEAVER_BABY_LAYER = new EntityModelLayer(Identifier.of(BlockyBeavers.MOD_ID, createBabyId(BEAVER_ID)), "main");

	public static String createBabyId(String parentId) {
		return parentId + "_baby";
	}

	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(MODEL_BEAVER_LAYER, BeaverEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MODEL_BEAVER_BABY_LAYER, () -> BeaverEntityModel.getTexturedModelData().transform(BeaverEntityModel.BABY_TRANSFORMER));
		EntityRendererRegistry.register(BlockyBeaversEntities.BEAVER, BeaverEntityRenderer::new);
	}
}