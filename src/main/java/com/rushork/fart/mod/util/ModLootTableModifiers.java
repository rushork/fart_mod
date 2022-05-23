package com.rushork.fart.mod.util;

import com.rushork.fart.mod.registry.ModItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier COW_ID = new Identifier("minecraft", "entities/cow");
    private static final Identifier PIG_ID = new Identifier("minecraft", "entities/pig");

    public static void modifyLootTables() {
        LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
            if (COW_ID.equals(id) || PIG_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.POO_NUGGET))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build());
                supplier.pool(poolBuilder);
            }
        });
    }
}
