package net.doktorcraft23.dokstestmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class UraniumIngotItem {
    public static final FoodProperties URANIUM = new FoodProperties.Builder().nutrition(6).saturationModifier(0.5f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 600), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 600), 1f)
            .build();
}
