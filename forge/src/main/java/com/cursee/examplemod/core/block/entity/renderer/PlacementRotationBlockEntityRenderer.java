package com.cursee.examplemod.core.block.entity.renderer;

import com.cursee.examplemod.core.block.custom.PlacementRotationBlock;
import com.cursee.examplemod.core.block.entity.custom.PlacementRotationBlockEntity;
import com.cursee.examplemod.core.block.entity.model.PlacementRotationBlockModelBase;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.core.Direction;
import net.minecraft.core.UUIDUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;

import javax.annotation.Nullable;
import java.util.Map;

public class PlacementRotationBlockEntityRenderer implements BlockEntityRenderer<PlacementRotationBlockEntity> {

    private final Map<PlacementRotationBlock.Type, PlacementRotationBlockModelBase> modelByType;
    private static final Map<PlacementRotationBlock.Type, ResourceLocation> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), ($$0) -> {
        $$0.put(PlacementRotationBlock.Types.SKELETON, new ResourceLocation("textures/entity/skeleton/skeleton.png"));
        $$0.put(PlacementRotationBlock.Types.WITHER_SKELETON, new ResourceLocation("textures/entity/skeleton/wither_skeleton.png"));
        $$0.put(PlacementRotationBlock.Types.ZOMBIE, new ResourceLocation("textures/entity/zombie/zombie.png"));
        $$0.put(PlacementRotationBlock.Types.CREEPER, new ResourceLocation("textures/entity/creeper/creeper.png"));
        $$0.put(PlacementRotationBlock.Types.PLAYER, DefaultPlayerSkin.getDefaultSkin());
    });

    public static Map<PlacementRotationBlock.Type, PlacementRotationBlockModelBase> createSkullRenderers(EntityModelSet $$0) {
        ImmutableMap.Builder<PlacementRotationBlock.Type, PlacementRotationBlockModelBase> $$1 = ImmutableMap.builder();
        $$1.put(PlacementRotationBlock.Types.SKELETON, new PlacementRotationBlockModelBase($$0.bakeLayer(ModelLayers.SKELETON_SKULL)));
        $$1.put(PlacementRotationBlock.Types.WITHER_SKELETON, new PlacementRotationBlockModelBase($$0.bakeLayer(ModelLayers.WITHER_SKELETON_SKULL)));
        $$1.put(PlacementRotationBlock.Types.PLAYER, new PlacementRotationBlockModelBase($$0.bakeLayer(ModelLayers.PLAYER_HEAD)));
        $$1.put(PlacementRotationBlock.Types.ZOMBIE, new PlacementRotationBlockModelBase($$0.bakeLayer(ModelLayers.ZOMBIE_HEAD)));
        $$1.put(PlacementRotationBlock.Types.CREEPER, new PlacementRotationBlockModelBase($$0.bakeLayer(ModelLayers.CREEPER_HEAD)));
        return $$1.build();
    }

    public PlacementRotationBlockEntityRenderer(BlockEntityRendererProvider.Context $$0) {
        this.modelByType = createSkullRenderers($$0.getModelSet());
    }

    @Override
    public void render(PlacementRotationBlockEntity $$0, float $$1, PoseStack $$2, MultiBufferSource $$3, int $$4, int $$5) {
        float $$6 = 0;
        BlockState $$7 = $$0.getBlockState();
        boolean $$8 = false;
        Direction $$9 = null;
        int $$10 = (Integer)$$7.getValue(PlacementRotationBlock.ROTATION);
        float $$11 = RotationSegment.convertToDegrees($$10);
        PlacementRotationBlock.Type $$12 = ((PlacementRotationBlock)$$7.getBlock()).type;
        PlacementRotationBlockModelBase $$13 = (PlacementRotationBlockModelBase)this.modelByType.get($$12);
        RenderType $$14 = getRenderType($$12, null);
        renderSkull($$9, $$11, $$6, $$2, $$3, $$4, $$13, $$14);
    }

    public static void renderSkull(@Nullable Direction $$0, float $$1, float $$2, PoseStack $$3, MultiBufferSource $$4, int $$5, PlacementRotationBlockModelBase $$6, RenderType $$7) {
        $$3.pushPose();
        if ($$0 == null) {
            $$3.translate(0.5F, 0.0F, 0.5F);
        } else {
            float $$8 = 0.25F;
            $$3.translate(0.5F - (float)$$0.getStepX() * 0.25F, 0.25F, 0.5F - (float)$$0.getStepZ() * 0.25F);
        }

        $$3.scale(-1.0F, -1.0F, 1.0F);
        VertexConsumer $$9 = $$4.getBuffer($$7);
        $$6.setupAnim($$2, $$1, 0.0F);
        $$6.renderToBuffer($$3, $$9, $$5, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        $$3.popPose();
    }

    public static RenderType getRenderType(PlacementRotationBlock.Type $$0, @Nullable GameProfile $$1) {
        ResourceLocation $$2 = (ResourceLocation)SKIN_BY_TYPE.get($$0);
        if ($$0 == PlacementRotationBlock.Types.PLAYER && $$1 != null) {
            Minecraft $$3 = Minecraft.getInstance();
            Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> $$4 = $$3.getSkinManager().getInsecureSkinInformation($$1);
            return $$4.containsKey(MinecraftProfileTexture.Type.SKIN) ? RenderType.entityTranslucent($$3.getSkinManager().registerTexture((MinecraftProfileTexture)$$4.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN)) : RenderType.entityCutoutNoCull(DefaultPlayerSkin.getDefaultSkin(UUIDUtil.getOrCreatePlayerUUID($$1)));
        } else {
            return RenderType.entityCutoutNoCullZOffset($$2);
        }
    }
}
