package com.simonk0403.blockybeavers.model;

import com.google.common.collect.ImmutableList;
import com.simonk0403.blockybeavers.entity.BeaverEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.util.math.MathHelper;

public class BeaverEntityModel extends QuadrupedEntityModel<BeaverEntity> {
	private final ModelPart rightFrontLeg;
	private final ModelPart leftFrontLeg;
	private final ModelPart rightHindLeg;
	private final ModelPart leftHindLeg;
	private final ModelPart tail;
	private final ModelPart body;
	private final ModelPart head;

	public BeaverEntityModel(ModelPart root) {
		super(root, false, 2.0F, 2.5F, 2.0F, 2.0F, 24);
		this.rightFrontLeg = root.getChild("right_front_leg");
		this.leftFrontLeg = root.getChild("left_front_leg");
		this.rightHindLeg = root.getChild("right_hind_leg");
		this.leftHindLeg = root.getChild("left_hind_leg");
		this.tail = root.getChild("tail");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(19, 21).cuboid(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.0F, -5.0F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -3.0F, -5.0F, 8.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.0F, 0.0F));

		ModelPartData right_front_leg = modelPartData.addChild("right_front_leg", ModelPartBuilder.create().uv(0, 5).cuboid(0.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 21.0F, -5.0F));

		ModelPartData left_front_leg = modelPartData.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 21.0F, -5.0F));

		ModelPartData right_hind_leg = modelPartData.addChild("right_hind_leg", ModelPartBuilder.create().uv(26, 0).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 22.0F, 4.0F));

		ModelPartData left_hind_leg = modelPartData.addChild("left_hind_leg", ModelPartBuilder.create().uv(0, 26).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 22.0F, 4.0F));

		ModelPartData tail = modelPartData.addChild("tail", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 22.0F, 5.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	protected Iterable<ModelPart> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelPart> getBodyParts() {
		return ImmutableList.of(this.body, this.rightHindLeg, this.leftHindLeg, this.rightFrontLeg, this.leftFrontLeg, this.tail);
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