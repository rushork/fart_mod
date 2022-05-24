package com.rushork.fart.mod.toolmaterials;

import com.rushork.fart.mod.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PooToolMaterial implements ToolMaterial {

    public static final PooToolMaterial INSTANCE = new PooToolMaterial();

    @Override
    public int getDurability() {
        return 50;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.5f;
    }

    @Override
    public float getAttackDamage() {
        return 1f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.POO_NUGGET);
    }
}
