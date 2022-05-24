package com.rushork.fart.mod.registry;

import com.rushork.fart.mod.DrinkableItem;
import com.rushork.fart.mod.Fartmod;
import com.rushork.fart.mod.toolmaterials.PooToolMaterial;
import com.rushork.fart.mod.util.ModLootTableModifiers;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item POO_NUGGET = new Item(new Item.Settings()
            .group(ItemGroup.MISC)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(2f).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*5), 0.75f).build()));
    public static final Item POO_INGOT = new Item(new Item.Settings()
            .group(ItemGroup.MATERIALS));
    public static final ModSword POO_SWORD = new ModSword(PooToolMaterial.INSTANCE, 0, 1f, new Item.Settings().group(ItemGroup.COMBAT));
    public static final DrinkableItem PEE_BOTTLE = new DrinkableItem(new Item.Settings().group(ItemGroup.BREWING).food(new FoodComponent.Builder().hunger(0).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*5), 1f).build()));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Fartmod.MOD_ID, "poo_nugget"), POO_NUGGET);
        Registry.register(Registry.ITEM, new Identifier(Fartmod.MOD_ID, "poo_sword"), POO_SWORD);
        Registry.register(Registry.ITEM, new Identifier(Fartmod.MOD_ID, "poo_ingot"), POO_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Fartmod.MOD_ID, "pee_bottle"), PEE_BOTTLE);
        ModLootTableModifiers.modifyLootTables();
    }
}
