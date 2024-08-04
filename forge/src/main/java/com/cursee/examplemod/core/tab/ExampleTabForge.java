package com.cursee.examplemod.core.tab;

import com.cursee.examplemod.core.item.ExampleItemsForge;
import com.cursee.examplemod.core.registry.ExampleRegistryForge;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public class ExampleTabForge {

    public static void register() {}

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = ExampleRegistryForge.CREATIVE_MODE_TAB.register("example_tab", () -> {
        return CreativeModeTab.builder()
                .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                .title(Component.translatable("itemGroup.exampleMod"))
                .icon(() -> new ItemStack(ExampleItemsForge.PLACEMENT_ROTATION_BLOCK_ITEM.get()))
                .displayItems(((itemDisplayParameters, output) -> {
                    output.accept(ExampleItemsForge.PLACEMENT_ROTATION_BLOCK_ITEM.get());
                })).build();
    });
}
