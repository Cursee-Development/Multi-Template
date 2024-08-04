package com.cursee.examplemod;

import com.cursee.examplemod.core.registry.ExampleRegistryForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class ExampleModForge {
    
    public ExampleModForge() {
    
        ExampleMod.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ExampleRegistryForge.registerAll(bus);
    }
}