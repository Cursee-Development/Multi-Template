package com.cursee.examplemod.core.block;

import com.cursee.examplemod.core.block.custom.PlacementRotationBlock;
import com.cursee.examplemod.core.registry.ExampleRegistryForge;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ExampleBlocksForge {

    public static void register() {}

    public static final RegistryObject<Block> PLACEMENT_ROTATION_BLOCK = ExampleRegistryForge.BLOCKS.register("placement_rotation_block", () -> new PlacementRotationBlock());
}
