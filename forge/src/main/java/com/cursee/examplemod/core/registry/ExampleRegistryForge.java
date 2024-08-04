package com.cursee.examplemod.core.registry;

import com.cursee.examplemod.Constants;
import com.cursee.examplemod.core.block.ExampleBlocksForge;
import com.cursee.examplemod.core.block.entity.ExampleBlockEntitiesForge;
import com.cursee.examplemod.core.item.ExampleItemsForge;
import com.cursee.examplemod.core.tab.ExampleTabForge;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ExampleRegistryForge {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static void registerAll(IEventBus bus) {

        ExampleBlocksForge.register();
        ExampleBlockEntitiesForge.register();
        ExampleItemsForge.register();
        ExampleTabForge.register();

        BLOCKS.register(bus);
        BLOCK_ENTITY_TYPES.register(bus);
        ITEMS.register(bus);
        CREATIVE_MODE_TAB.register(bus);
    }
}
