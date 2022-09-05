package net.vakror.thommas.mixin;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import team.reborn.energy.api.base.SimpleEnergyStorage;

@Mixin(BucketItem.class)
public interface BucketItemAccessor {

    @Accessor("fluid")
    public Fluid getFluid();
}
