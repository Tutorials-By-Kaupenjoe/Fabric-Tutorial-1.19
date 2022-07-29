package net.kaupenjoe.tutorialmod.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static FlowableFluid STILL_SOAP_WATER;
    public static FlowableFluid FLOWING_SOAP_WATER;
    public static Block SOAP_WATER_BLOCK;
    public static Item SOAP_WATER_BUCKET;

    public static void register() {
        STILL_SOAP_WATER = Registry.register(Registry.FLUID,
                new Identifier(TutorialMod.MOD_ID, "soap_water"), new SoapWaterFluid.Still());
        FLOWING_SOAP_WATER = Registry.register(Registry.FLUID,
                new Identifier(TutorialMod.MOD_ID, "flowing_soap_water"), new SoapWaterFluid.Flowing());

        SOAP_WATER_BLOCK = Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, "soap_water_block"),
                new FluidBlock(ModFluids.STILL_SOAP_WATER, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        SOAP_WATER_BUCKET = Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, "soap_water_bucket"),
                new BucketItem(ModFluids.STILL_SOAP_WATER, new FabricItemSettings().group(ModItemGroup.TANZANITE).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
