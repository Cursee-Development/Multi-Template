package com.cursee.examplemod;

import com.cursee.examplemod.core.registry.ExampleRegistryFabric;
import com.cursee.monolib.core.sailing.Sailing;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {

        ExampleMod.init();

        ExampleRegistryFabric.registerAll();
    }
}
