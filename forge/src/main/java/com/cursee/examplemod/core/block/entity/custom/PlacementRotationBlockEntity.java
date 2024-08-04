package com.cursee.examplemod.core.block.entity.custom;

import com.cursee.examplemod.core.block.entity.ExampleBlockEntitiesForge;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PlacementRotationBlockEntity extends BlockEntity {

    public PlacementRotationBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ExampleBlockEntitiesForge.PLACEMENT_ROTATION_BLOCK_ENTITY.get(), p_155229_, p_155230_);
    }
}
