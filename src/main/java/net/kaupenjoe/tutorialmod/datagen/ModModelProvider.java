package net.kaupenjoe.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // Block Entity saga!
        
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JUMPY_BLOCK);
    }
    
    private void registerGemInfusingStation(BlockStateModelGenerator generator)
    {
        blockStateModelGenerator.blockStateCollector.accept(
            VariantsBlockStateSupplier.create(ModBlocks.GEM_INFUSING_STATION)
                                      .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.R0))
                                      .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.R270))
                                      .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.R90))
                                      .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.R180)
        );
        
        blockStateModelGenerator.registerItemModel(ModBlocks.GEM_INFUSING_STATION);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.EIGHT_BALL, Models.GENERATED);
    }
}
