package com.cursee.examplemod.core.block.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class PlacementRotationBlockModelBase extends Model {

    private final ModelPart root;
    protected final ModelPart head;

    public PlacementRotationBlockModelBase(ModelPart $$0) {
        super(RenderType::entityTranslucent);
        this.root = $$0;
        this.head = $$0.getChild("head");
    }

    public static MeshDefinition createHeadModel() {
        MeshDefinition $$0 = new MeshDefinition();
        PartDefinition $$1 = $$0.getRoot();
        $$1.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
        return $$0;
    }

    public static LayerDefinition createHumanoidHeadLayer() {
        MeshDefinition $$0 = createHeadModel();
        PartDefinition $$1 = $$0.getRoot();
        $$1.getChild("head").addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.ZERO);
        return LayerDefinition.create($$0, 64, 64);
    }

    public static LayerDefinition createMobHeadLayer() {
        MeshDefinition $$0 = createHeadModel();
        return LayerDefinition.create($$0, 64, 32);
    }

    public void setupAnim(float $$0, float $$1, float $$2) {
        this.head.yRot = $$1 * 0.017453292F;
        this.head.xRot = $$2 * 0.017453292F;
    }

    public void renderToBuffer(PoseStack $$0, VertexConsumer $$1, int $$2, int $$3, float $$4, float $$5, float $$6, float $$7) {
        this.root.render($$0, $$1, $$2, $$3, $$4, $$5, $$6, $$7);
    }
}
