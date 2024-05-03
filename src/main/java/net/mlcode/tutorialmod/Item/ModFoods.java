package net.mlcode.tutorialmod.Item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.1F)
            .build();
}
