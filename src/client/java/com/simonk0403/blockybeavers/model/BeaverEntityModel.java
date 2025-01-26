package com.simonk0403.blockybeavers.model;

import com.simonk0403.blockybeavers.entity.BeaverEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.util.math.MathHelper;

import java.util.List;

public class BeaverEntityModel extends QuadrupedEntityModel<BeaverEntity> {
	private final ModelPart tail;
	private static final String TAIL_PART = "tail";

	public BeaverEntityModel(ModelPart root) {
		super(root, false, 2.0F, 2.5F, 2.0F, 2.0F, 24);
		this.tail = root.getChild(TAIL_PART);
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

		modelPartData.addChild(TAIL_PART, ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 22.0F, 5.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	protected Iterable<ModelPart> getHeadParts() {
		return List.of(this.head);
	}

	@Override
	protected Iterable<ModelPart> getBodyParts() {
		return List.of(this.body, this.rightHindLeg, this.leftHindLeg, this.rightFrontLeg, this.leftFrontLeg, this.tail);
	}

	@Override
	public void setAngles(BeaverEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.head.pitch = headPitch * (float) (Math.PI / 180.0);
		this.head.yaw = headYaw * (float) (Math.PI / 180.0);

		if(entity.isTouchingWater()){
			this.rightHindLeg.pitch = MathHelper.cos(limbAngle * 4F) * 1.4F * limbDistance + 3F;
			this.leftHindLeg.pitch = MathHelper.cos(limbAngle * 4F + (float) Math.PI) * 1.4F * limbDistance + 3F;
			this.rightFrontLeg.pitch = MathHelper.cos(limbAngle * 4F) * 1.4F * limbDistance - 1.5F;
			this.leftFrontLeg.pitch = MathHelper.cos(limbAngle * 4F + (float) Math.PI) * 1.4F * limbDistance - 1.5F;
			this.tail.pitch = MathHelper.cos(limbAngle * 2F) * limbDistance;
		} else {
			this.rightHindLeg.pitch = MathHelper.cos(limbAngle * 1.5F) * 1.4F * limbDistance;
			this.leftHindLeg.pitch = MathHelper.cos(limbAngle * 1.5F + (float) Math.PI) * 1.4F * limbDistance;
			this.rightFrontLeg.pitch = MathHelper.cos(limbAngle * 1.5F) * 1.4F * limbDistance;
			this.leftFrontLeg.pitch = MathHelper.cos(limbAngle * 1.5F + (float) Math.PI) * 1.4F * limbDistance;
			this.tail.yaw = MathHelper.cos(limbAngle * 1.5F) * limbDistance;
		}
	}
}