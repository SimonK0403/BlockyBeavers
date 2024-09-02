package com.simonk0403.blockybeavers.renderer;

import com.simonk0403.blockybeavers.BlockyBeavers;
import com.simonk0403.blockybeavers.entity.BeaverEntity;
import com.simonk0403.blockybeavers.model.BeaverEntityModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BeaverEntityRenderer extends MobEntityRenderer<BeaverEntity, BeaverEntityModel> {

    public BeaverEntityRenderer(EntityRendererFactory.Context context, BeaverEntityModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @Override
    public Identifier getTexture(BeaverEntity entity) {
        return Identifier.of(BlockyBeavers.MOD_ID, "textures/entity/beaver.png");
    }
}
