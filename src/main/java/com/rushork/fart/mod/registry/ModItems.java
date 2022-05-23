package com.rushork.fart.mod.registry;

import com.rushork.fart.mod.Fartmod;
import com.rushork.fart.mod.toolmaterials.PooToolMaterial;
import com.rushork.fart.mod.util.ModLootTableModifiers;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item POO_NUGGET = new Item(new Item.Settings()
            .group(ItemGroup.MISC)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(2f).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*5), 0.75f).build()));
    public static final Item POO_INGOT = new Item(new Item.Settings()
            .group(ItemGroup.MATERIALS));
    public static final Item POO_SWORD = new SwordItem(PooToolMaterial.INSTANCE, 1, 1F, new Item.Settings().group(ItemGroup.COMBAT));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Fartmod.MOD_ID, "poo_nugget"), POO_NUGGET);
        Registry.register(Registry.ITEM, new Identifier(Fartmod.MOD_ID, "poo_sword"), POO_SWORD);
        Registry.register(Registry.ITEM, new Identifier(Fartmod.MOD_ID, "poo_ingot"), POO_INGOT);
        ModLootTableModifiers.modifyLootTables();
    }
}
