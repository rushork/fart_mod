package com.rushork.fart.mod;

import com.rushork.fart.mod.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class Fartmod implements ModInitializer {

    public static final String MOD_ID = "fartmod";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }
}
