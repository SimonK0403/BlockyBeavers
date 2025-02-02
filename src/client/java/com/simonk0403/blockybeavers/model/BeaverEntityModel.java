package com.simonk0403.blockybeavers.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BabyModelTransformer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.ModelTransformer;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.math.MathHelper;

import java.util.Set;

public class BeaverEntityModel extends QuadrupedEntityModel<LivingEntityRenderState> {
	public static final ModelTransformer BABY_TRANSFORMER = new BabyModelTransformer(false, 2.0F, 2.5F, Set.of(EntityModelPartNames.HEAD));
	private final ModelPart tail;

	public BeaverEntityModel(ModelPart root) {
		super(root);
		this.tail = root.getChild(EntityModelPartNames.TAIL);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(19, 21).cuboid(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.0F, -5.0F));

		modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -3.0F, -5.0F, 8.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.0F, 0.0F));

		modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(0, 5).cuboid(0.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 21.0F, -5.0F));

		modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 21.0F, -5.0F));

		modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG, ModelPartBuilder.create().uv(26, 0).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 22.0F, 4.0F));

		modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG, ModelPartBuilder.create().uv(0, 26).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 22.0F, 4.0F));

		modelPartData.addChild(EntityModelPartNames.TAIL, ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 22.0F, 5.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(LivingEntityRenderState livingEntityRenderState) {
		this.head.pitch = livingEntityRenderState.pitch * (float) (Math.PI / 180.0);
		this.head.yaw = livingEntityRenderState.yawDegrees * (float) (Math.PI / 180.0);

		float limbFrequency = livingEntityRenderState.limbFrequency;
		float limbAmplitudeMultiplier = livingEntityRenderState.limbAmplitudeMultiplier;

		if(livingEntityRenderState.touchingWater){
			this.rightHindLeg.pitch = MathHelper.cos(limbFrequency * 4F) * 1.4F * limbAmplitudeMultiplier + 3F;
			this.leftHindLeg.pitch = MathHelper.cos(limbFrequency * 4F + (float) Math.PI) * 1.4F * limbAmplitudeMultiplier + 3F;
			this.rightFrontLeg.pitch = MathHelper.cos(limbFrequency * 4F) * 1.4F * limbAmplitudeMultiplier - 1.5F;
			this.leftFrontLeg.pitch = MathHelper.cos(limbFrequency * 4F + (float) Math.PI) * 1.4F * limbAmplitudeMultiplier - 1.5F;
			this.tail.pitch = MathHelper.cos(limbFrequency * 2F) * limbAmplitudeMultiplier;
		} else {
			this.rightHindLeg.pitch = MathHelper.cos(limbFrequency * 1.5F) * 1.4F * limbAmplitudeMultiplier;
			this.leftHindLeg.pitch = MathHelper.cos(limbFrequency * 1.5F + (float) Math.PI) * 1.4F * limbAmplitudeMultiplier;
			this.rightFrontLeg.pitch = MathHelper.cos(limbFrequency * 1.5F) * 1.4F * limbAmplitudeMultiplier;
			this.leftFrontLeg.pitch = MathHelper.cos(limbFrequency * 1.5F + (float) Math.PI) * 1.4F * limbAmplitudeMultiplier;
			this.tail.yaw = MathHelper.cos(limbFrequency * 1.5F) * limbAmplitudeMultiplier;
		}
	}
}