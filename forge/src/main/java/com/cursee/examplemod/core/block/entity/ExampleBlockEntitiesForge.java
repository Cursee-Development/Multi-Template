package com.cursee.examplemod.core.block.entity;

import com.cursee.examplemod.core.block.ExampleBlocksForge;
import com.cursee.examplemod.core.block.entity.custom.PlacementRotationBlockEntity;
import com.cursee.examplemod.core.registry.ExampleRegistryForge;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

public class ExampleBlockEntitiesForge {

    public static void register() {}

    public static final RegistryObject<BlockEntityType<PlacementRotationBlockEntity>> PLACEMENT_ROTATION_BLOCK_ENTITY = ExampleRegistryForge.BLOCK_ENTITY_TYPES.register("placement_rotation_block", () -> BlockEntityType.Builder.of(PlacementRotationBlockEntity::new, ExampleBlocksForge.PLACEMENT_ROTATION_BLOCK.get()).build(null));
}
