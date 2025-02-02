package com.simonk0403.blockybeavers.renderer;

import com.simonk0403.blockybeavers.BlockyBeavers;
import com.simonk0403.blockybeavers.BlockyBeaversClient;
import com.simonk0403.blockybeavers.entity.BeaverEntity;
import com.simonk0403.blockybeavers.model.BeaverEntityModel;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

public class BeaverEntityRenderer extends AgeableMobEntityRenderer<BeaverEntity, LivingEntityRenderState, BeaverEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(BlockyBeavers.MOD_ID, "textures/entity/beaver.png");

    public BeaverEntityRenderer(EntityRendererFactory.Context context) {
        super(context,
                new BeaverEntityModel(context.getPart(BlockyBeaversClient.MODEL_BEAVER_LAYER)),
                new BeaverEntityModel(context.getPart(BlockyBeaversClient.MODEL_BEAVER_BABY_LAYER)),
                0.5f);
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
}
