package com.cursee.examplemod.core.item;

import com.cursee.examplemod.core.block.ExampleBlocksForge;
import com.cursee.examplemod.core.registry.ExampleRegistryForge;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ExampleItemsForge {

    public static void register() {}

    public static final RegistryObject<Item> PLACEMENT_ROTATION_BLOCK_ITEM = ExampleRegistryForge.ITEMS.register("placement_rotation_block", () -> new BlockItem(ExampleBlocksForge.PLACEMENT_ROTATION_BLOCK.get(), new Item.Properties().fireResistant()));
}
