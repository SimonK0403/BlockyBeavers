package com.simonk0403.blockybeavers;

import com.simonk0403.blockybeavers.model.BeaverEntityModel;
import com.simonk0403.blockybeavers.renderer.BeaverEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class BlockyBeaversClient implements ClientModInitializer {
	public static final EntityModelLayer MODEL_BEAVER_LAYER = new EntityModelLayer(Identifier.of(BlockyBeavers.MOD_ID, "beaver"), "main");

	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(MODEL_BEAVER_LAYER, BeaverEntityModel::getTexturedModelData);
		EntityRendererRegistry.register(BlockyBeaversEntities.BEAVER, (context) ->
				new BeaverEntityRenderer(context, new BeaverEntityModel(context.getPart(MODEL_BEAVER_LAYER)), 0.5f)
		);
	}
}