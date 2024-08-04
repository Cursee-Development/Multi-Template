package com.cursee.examplemod;

import com.cursee.examplemod.core.block.custom.PlacementRotationBlock;
import com.cursee.examplemod.core.block.entity.ExampleBlockEntitiesForge;
import com.cursee.examplemod.core.block.entity.renderer.PlacementRotationBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExampleModForgeClient {

    @SubscribeEvent
    public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ExampleBlockEntitiesForge.PLACEMENT_ROTATION_BLOCK_ENTITY.get(), PlacementRotationBlockEntityRenderer::new);
    }
}
